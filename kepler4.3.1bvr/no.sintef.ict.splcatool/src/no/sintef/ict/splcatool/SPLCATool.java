/*******************************************************************************
 * Copyright (c) 2011, 2012 SINTEF, Martin F. Johansen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SINTEF, Martin F. Johansen - the implementation
 *******************************************************************************/

package no.sintef.ict.splcatool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.math.util.MathUtils;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;

import splar.core.fm.FeatureModelException;
import splar.plugins.reasoners.bdd.javabdd.BDDExceededBuildingTimeException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class SPLCATool {
	
	GUIDSL m = null;
	CNF cnf = null;
	SXFM fm = null;
	static SPLCATool vspl = new SPLCATool();

	public static void main(String[] args){
		vspl.mainObj(args);
	}
	
	public void mainObj(String[] args){
		System.out.println("SPL Covering Array Tool v0.41 (BVR 2 Version)");
		System.out.println("http://www.variabilitymodeling.org/");
		
		// Defaults
		Map<String, String> argsMap = new HashMap<String, String>();
		argsMap.put("t", "help");
        argsMap.put("threads", "1");
        argsMap.put("limit", "100%");
        argsMap.put("a", "J12");
		
		// Get args
		String last = "";
		for(int i = 0; i < args.length; i++){
			if(args[i].startsWith("-")){
				last = args[i].substring(1);
				argsMap.put(last, "");
			}else{
				String params = argsMap.get(last);
				params += " " + args[i];
				argsMap.put(last, params.trim());
			}
		}
		
		System.out.println("Args: " + argsMap);
		
		String task = argsMap.get("t");
		
		try {
			if(task.equals("help")){
				System.out.println("Usage: <task>");
				System.out.println("Tasks: ");
				System.out.println(" -t count_solutions -fm <feature_model>");
				System.out.println(" -t sat_time -fm <feature_model>");
				System.out.println(" -t t_wise -a Chvatal -fm <feature_model> -s <strength, 1-4> (-startFrom <covering array>) (-limit <coverage limit>) (-sizelimit <rows>) (-onlyOnes) (-noAllZeros)");
				System.out.println(" -t t_wise -a J11 -fm <feature_model> -s <strength, 1-3> (-startFrom <covering array>) (-threads <threads>) (-onlyOnes) (-noAllZeros) [Inexact: (-sizelimit <rows>) (-limit <coverage limit>)]");
				System.out.println(" -t t_wise_weighted -a ChvatalWeighted -fm <feature_model> -s <strength, 1-3> -weights <ca_with_weights> (-limit <coverage limit>) (-sizelimit <rows>)");
				System.out.println(" -t calc_cov -fm <feature_model> -s <strength> -ca <covering array>");
				System.out.println(" -t calc_cov_weighted -fm <feature_model> -s <strength> -ca <covering array> -weights <ca_with_weights>");
				System.out.println(" -t verify_solutions -fm <feature_model> -check <covering array>");
				System.out.println(" -t verify_weighted_solutions -fm <feature_model> -check <ca_with_weights>");
				System.out.println(" -t improve_weighted -fm <feature_model> -s <strength> -ca <covering array> -weights <ca_with_weights>");
				System.out.println(" -t generate_featureide_equation_files -ca <covering array>");
				System.out.println(" -t help (this menu)");
				System.out.println("Supported Feature models formats: ");
				System.out.println(" - Feature IDE GUI DSL (.m)");
				System.out.println(" - Simple XML Feature Models (.xml)");
				System.out.println(" - Dimacs (.dimacs)");
				return;
			}else if(task.equals("count_solutions")){
				count_solutions(argsMap);
			}else if(task.equals("sat_time")){
				sat_time(argsMap);
			}else if(task.equals("t_wise")){
				t_wise(argsMap);
			}else if(task.equals("t_wise_weighted")){
				t_wise_weighted(argsMap);
			}else if(task.equals("calc_cov")){
				calc_cov(argsMap);
			}else if(task.equals("calc_cov_weighted")){
				calc_cov_weighted(argsMap);
			}else if(task.equals("verify_solutions")){
				verify_solutions(argsMap);
			}else if(task.equals("verify_weighted_solutions")){
				verify_weighted_solutions(argsMap);
			}else if(task.equals("improve_weighted")){
				improve_weighted(argsMap);
			}else if(task.equals("generate_featureide_equation_files")){
				generate_featureide_equation_files(argsMap);
			}else{
				System.out.println("task " + task + " unknown");
				throw new UnsupportedOperationException();
			}
		} catch (UnsupportedModelException e) {
			System.err.println("Failed to load feature model: " + argsMap.get("fm"));
			System.err.println("Exception: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("File IO failed.");
			System.err.println("Exception: " + e.getMessage());
		} catch (FeatureModelException e) {
			System.err.println("Failed to load feature model: " + argsMap.get("fm"));
			System.err.println("Exception: " + e.getMessage());
		} catch (BDDExceededBuildingTimeException e) {
			System.err.println("BDD Exceeded Building Time.");
			System.err.println("Exception: " + e.getMessage());
		} catch (ContradictionException e) {
			System.err.println("SAT4J reached a contradiction.");
			System.err.println("Exception: " + e.getMessage());
		} catch (TimeoutException e) {
			System.err.println("SAT4J timed out.");
			System.err.println("Exception: " + e.getMessage());
		} catch (java.util.concurrent.TimeoutException e) {
			System.err.println("Java timeout reached.");
			System.err.println("Exception: " + e.getMessage());
		} catch (CSVException e) {
			System.err.println("Error in CSV file.");
			System.err.println("Exception: " + e.getMessage());
		} catch (CoveringArrayGenerationException e) {
			System.err.println("Error generating covering array.");
			System.err.println("Exception: " + e.getMessage());
		}
	}

	void generate_featureide_equation_files(Map<String, String> argsMap) throws IOException, CSVException {
		System.out.println("Generating from: " + argsMap.get("ca"));
		File dir = new File(argsMap.get("ca")+".fidefiles");
		dir.mkdir();
		
		CoveringArray ca = new CoveringArrayFile(new File(argsMap.get("ca")));
		
		for(int i = 0; i < ca.getRowCount(); i++){
			StringBuffer output = new StringBuffer();
			File result = new File(dir.getAbsoluteFile() + "/" + i + ".equation");
			
			Integer[] row = ca.getRow(i);
			for(int j = 0; j < row.length; j++){
				if(row[j] == 0)
					output.append(ca.getId(j+1) + "\n");
			}
			new FileUtility().writeStringToFile(result.getAbsoluteFile().toString(), output.toString());
			
			System.out.println("Generated " + result.getName());
		}
		
		System.out.println("Done");
	}

	void improve_weighted(Map<String, String> argsMap)
			throws IOException, UnsupportedModelException,
			FeatureModelException, ContradictionException, TimeoutException, CSVException {
		// Calculate weight coverage
		int t = new Integer(argsMap.get("s"));
		String caFileName = argsMap.get("ca");
		Integer search = new Integer(argsMap.get("search"));
		CoveringArray ca = new CoveringArrayFile(new File(caFileName));
		String fmFileName = argsMap.get("fm");
		int threads = Runtime.getRuntime().availableProcessors();
		String weightFileName = argsMap.get("weights");
		
		loadFM(fmFileName);
		System.out.println("Rows: " + ca.getRowCount());
		
		double orgCov = CALib.calc_coverage_weighted(cnf, t, ca, fmFileName, threads, weightFileName, false);
		System.out.println("Original coverage: " + orgCov);
		
		List<Improvement> is = new ArrayList<Improvement>();
		
		if(search >= 1){
			int size = ((CoveringArrayFile)ca).rows.get(0).size();
			
			// Create threads
			List<ImproveW1Thread> iw1s = new ArrayList<ImproveW1Thread>();
			List<Thread> ts = new ArrayList<Thread>();
			for(int i = 0; i < threads; i++){
				int begin = i*size/threads;
				int end = (i+1)*size/threads;
				CoveringArray ca_own = new CoveringArrayFile(new File(caFileName));
				ImproveW1Thread iw1 = new ImproveW1Thread(cnf, t, ca_own, fmFileName, threads, weightFileName, orgCov, begin, end);
				ts.add(new Thread(iw1));
				iw1s.add(iw1);
			}
			
			// Start
			for(Thread th : ts){
				th.start();
			}
			
			// Start monitoring thread
			List<ProgressReporter> prs = new ArrayList<ProgressReporter>(iw1s);
			long products = ((CoveringArrayFile)ca).rows.size();
			int vars = ((CoveringArrayFile)ca).rows.get(0).size();
			long total = products*MathUtils.binomialCoefficient(vars, 1);
			ProgressThread pt = new ProgressThread("Find improvements (1)", prs, total);
			Thread ptt = new Thread(pt);
			ptt.start();
			
			// Wait
			for(Thread th : ts){
				try {
					th.join();
				} catch (InterruptedException e) {
				}
			}
			
			// Stop monitoring
			pt.stop();
			
			// Collect

			for(ImproveW1Thread iw1 : iw1s){
				is.addAll(iw1.getImprovements());
			}
		}
	
		if(search >= 2){
			int size = ((CoveringArrayFile)ca).rows.get(0).size();
			
			// Create threads
			List<ImproveW2Thread> iw2s = new ArrayList<ImproveW2Thread>();
			List<Thread> ts = new ArrayList<Thread>();
			for(int i = 0; i < threads; i++){
				int begin = i*size/threads;
				int end = (i+1)*size/threads;
				CoveringArray ca_own = new CoveringArrayFile(new File(caFileName));
				ImproveW2Thread iw2 = new ImproveW2Thread(cnf, t, ca_own, fmFileName, threads, weightFileName, orgCov, begin, end);
				ts.add(new Thread(iw2));
				iw2s.add(iw2);
			}
			
			// Start
			for(Thread th : ts){
				th.start();
			}
			
			// Start monitoring thread
			List<ProgressReporter> prs = new ArrayList<ProgressReporter>(iw2s);
			long products = ((CoveringArrayFile)ca).rows.size();
			int vars = ((CoveringArrayFile)ca).rows.get(0).size();
			long total = products*MathUtils.binomialCoefficient(vars, 2);
			ProgressThread pt = new ProgressThread("Find improvements (2)", prs, total);
			Thread ptt = new Thread(pt);
			ptt.start();
			
			// Wait
			for(Thread th : ts){
				try {
					th.join();
				} catch (InterruptedException e) {
				}
			}
			
			// Stop monitoring
			pt.stop();
			
			// Collect
			for(ImproveW2Thread iw2 : iw2s){
				is.addAll(iw2.getImprovements());
			}
		}
		
		if(search >= 3){
			int size = ((CoveringArrayFile)ca).rows.get(0).size();
			
			// Create threads
			List<ImproveW3Thread> iw3s = new ArrayList<ImproveW3Thread>();
			List<Thread> ts = new ArrayList<Thread>();
			for(int i = 0; i < threads; i++){
				int begin = i*size/threads;
				int end = (i+1)*size/threads;
				CoveringArray ca_own = new CoveringArrayFile(new File(caFileName));
				ImproveW3Thread iw3 = new ImproveW3Thread(cnf, t, ca_own, fmFileName, threads, weightFileName, orgCov, begin, end);
				ts.add(new Thread(iw3));
				iw3s.add(iw3);
			}
			
			// Start
			for(Thread th : ts){
				th.start();
			}
			
			// Start monitoring thread
			List<ProgressReporter> prs = new ArrayList<ProgressReporter>(iw3s);
			long products = ((CoveringArrayFile)ca).rows.size();
			int vars = ((CoveringArrayFile)ca).rows.get(0).size();
			long total = products*MathUtils.binomialCoefficient(vars, 3);
			ProgressThread pt = new ProgressThread("Find improvements (3)", prs, total);
			Thread ptt = new Thread(pt);
			ptt.start();
			
			// Wait
			for(Thread th : ts){
				try {
					th.join();
				} catch (InterruptedException e) {
				}
			}
			
			// Stop monitoring
			pt.stop();
			
			// Collect
			for(ImproveW3Thread iw3 : iw3s){
				is.addAll(iw3.getImprovements());
			}
		}
		
		// Sort and print list
		Collections.sort(is);
		System.out.println(is);
	}

	boolean verify_weighted_solutions(Map<String, String> argsMap)
			throws UnsupportedModelException, IOException,
			FeatureModelException, ContradictionException, TimeoutException, CSVException {
		String fmf = argsMap.get("fm");
		String caf = argsMap.get("check");
		
		loadFM(fmf);
		
		boolean isValid = CALib.verifyWeightedCA(cnf, caf);
		
		return isValid;
	}

	boolean verify_solutions(Map<String, String> argsMap)
			throws UnsupportedModelException, IOException,
			FeatureModelException, ContradictionException, TimeoutException, CSVException {
		loadFM(argsMap.get("fm"));
		CoveringArray ca = new CoveringArrayFile(new File(argsMap.get("check")));
		boolean isValid = CALib.verifyCA(cnf, ca, true, new ArrayList<String>());
		System.out.println("Verification done");
		
		return isValid;
	}

	double calc_cov_weighted(Map<String, String> argsMap)
			throws IOException, UnsupportedModelException,
			FeatureModelException, CSVException {
		int t = new Integer(argsMap.get("s"));
		String caFileName = argsMap.get("ca");
		CoveringArray ca = new CoveringArrayFile(new File(caFileName));
		String fmFileName = argsMap.get("fm");
		int threads = new Integer(argsMap.get("threads"));
		String weightFileName = argsMap.get("weights");
		
		double coverage = CALib.calc_coverage_weighted(cnf, t, ca, fmFileName, threads, weightFileName, false);
		
		return coverage;
	}

	float calc_cov(Map<String, String> argsMap) throws UnsupportedModelException, IOException, FeatureModelException, CSVException {
		int t = new Integer(argsMap.get("s"));
		loadFM(argsMap.get("fm"));
		CoveringArray ca = new CoveringArrayFile(new File(argsMap.get("ca")));
		System.out.println("Rows: " + ca.getRowCount());
		
		if(t==1){
			// Calculate the valid pairs
			List<Pair> uncovered = cnf.getU1();
			System.out.println("Valid singles: " + uncovered.size());
			
			// Calculate the covered pairs
			List<List<Integer>> sols = ca.getSolutionsAsList();
			Set<Pair> coveredPairs = ca.getCovInv1(sols, uncovered);
			System.out.println("Covered singles: " + coveredPairs.size());
			
			// Coverage
			float coverage = (float)coveredPairs.size()*100/uncovered.size();
			System.out.println("Coverage: " + coveredPairs.size() + "/" + uncovered.size() + " = " + coverage + "%");
			return coverage;
		}else if(t==2){
			// Calculate the valid pairs
			List<Pair2> uncovered = cnf.getU2();
			System.out.println("Valid pairs: " + uncovered.size());
			
			// Calculate the covered pairs
			List<List<Integer>> sols = ca.getSolutionsAsList();
			long coveredPairs = ca.getCovInvCount(sols, uncovered);
			System.out.println("Covered pairs: " + coveredPairs);
			
			// Coverage
			float coverage = (float)coveredPairs*100/uncovered.size();
			System.out.println("Coverage: " + coveredPairs + "/" + uncovered.size() + " = " + coverage + "%");
			return coverage;
		}else if(t==3){
			// Calculate the valid pairs
			List<Pair3> u3 = cnf.getU3();
			System.out.println("Valid triples: " + u3.size());
			
			// Calculate the covered pairs
			List<List<Integer>> sols = ca.getSolutionsAsList();
			long coveredTriples = ca.getCovCount3(sols, u3);
			System.out.println("Covered triples: " + coveredTriples);
			
			// Coverage
			float coverage = (float)coveredTriples*100/u3.size();
			System.out.println("Coverage: " + coveredTriples + "/" + u3.size() + " = " + coverage + "%");
			
			return coverage;
		}else{
			System.out.println("Unsupported value of t: " + t);
			throw new UnsupportedOperationException();
		}
	}

	CoveringArray t_wise_weighted(Map<String, String> argsMap) throws UnsupportedModelException, IOException, FeatureModelException, java.util.concurrent.TimeoutException, FileNotFoundException, CSVException, CoveringArrayGenerationException {
		String fmfile = argsMap.get("fm");
		if(fmfile == null){
			System.out.println("You must specify a feature model using the -fm option.");
			return null;
		}
		if(!new File(fmfile).exists()){
			System.out.println("Feature model not found: " + fmfile);
			return null;
		}
		loadFM(fmfile);
		
		// Threads
		try{
			Integer.parseInt(argsMap.get("threads"));
		}catch(NumberFormatException e){
			System.out.println("threads must be an integer value.");
			return null;
		}
		
		int threads = new Integer(argsMap.get("threads"));
		
		if(threads!=1){
			System.out.println("For Chvatal, only threads=1 is supported.");
			return null;
		}

		// Strength
		try{
			Integer.parseInt(argsMap.get("s"));
		}catch(NumberFormatException e){
			System.out.println("s must be an integer value.");
			return null;
		}
		int t = new Integer(argsMap.get("s"));
		if(t<1){
			System.out.println("Unsupported value for t: " + t);
			return null;
		}
		if(t > 3){
			System.out.println("Unsupported value for t for algorithm Chvatal Weighted: " + t);
			return null;
		}
		
		// Analyzing weights
		if(argsMap.get("weights") == null){
			System.out.println("Weighted analysis requires a file with weights.");
			return null;
		}
		
		// Algorithm
		String a = "ChvatalWeighted";
		CoveringArray ca = null;
		ca = cnf.getCoveringArrayGenerator(a, t, threads, argsMap.get("weights"));
		
		// Limit
		String lim = argsMap.get("limit");
		if(lim.contains("%")) lim = lim.substring(0, lim.length()-1);
		int limit = new Integer(lim);
		System.out.println("Covering " + limit + "%");
		
		// Size limit
		Integer sizelimit = Integer.MAX_VALUE;
		if(argsMap.get("sizelimit") != null){
			sizelimit = new Integer(argsMap.get("sizelimit"));
		}
		
		// Start from partial covering array
		if(argsMap.containsKey("startFrom")){
			CoveringArray startFrom = new CoveringArrayFile(new File(argsMap.get("startFrom")));
			ca.startFrom(startFrom);
			System.out.println("Starting from " + argsMap.get("startFrom"));
		}
		
		// Do not cover all zero tuples
		if(argsMap.containsKey("noAllZeros")){
			ca.coverZeros(false);
		}
		
		// Cover only 
		if(argsMap.containsKey("onlyOnes")){
			ca.coverOnlyOnes(true);
		}
		
		// Cover
		long start = System.currentTimeMillis();
		ca.generate(limit, sizelimit);
		long end = System.currentTimeMillis();
		System.out.println("Done. Size: " + ca.getRowCount() + ", time: " + (end-start) + " milliseconds");
		
		// Generate output file name
		String cafilename = argsMap.get("o");
		if(cafilename == null)
			cafilename = fmfile + ".ca" + t + ".csv";
		
		// Write to file
		ca.writeToFile(cafilename, CoveringArrayFile.Type.horizontal);
		System.out.println("Wrote result to " + cafilename);
		
		return ca;
	}

	CoveringArray t_wise(Map<String, String> argsMap) throws UnsupportedModelException, IOException, FeatureModelException, java.util.concurrent.TimeoutException, FileNotFoundException, CSVException, CoveringArrayGenerationException {
		String fmfile = argsMap.get("fm");
		if(fmfile==null){
			System.out.println("Error: You must specify a feature model.");
			return null;
		}
		loadFM(fmfile);
		
		// Handle special multi-file formats
		if(fmfile.contains(",")){
			fmfile = fmfile.split(",")[0];
		}
		
		// Algorithm
		if(!argsMap.get("a").equals("J11") && !argsMap.get("a").equals("J12") && !argsMap.get("a").equals("Chvatal")){
			System.out.println("For t_wise, chose between \"J11\" or \"Chaval\" as algorithms.");
			return null;
		}
		String a = argsMap.get("a");
		
		// Strength
		if(argsMap.get("s")==null){
			System.out.println("Error: You must specify a coverage strength.");
			return null;
		}
		try{
			Integer.parseInt(argsMap.get("s"));
		}catch(NumberFormatException e){
			System.out.println("s must be an integer value.");
			return null;
		}
		int t = new Integer(argsMap.get("s"));
		if(t<1){
			System.out.println("Unsupported value for t: " + t);
			return null;
		}
		if((a.equals("J11") || a.equals("J12")) && t > 3){
			System.out.println("Unsupported value for t for algorithm J11: " + t);
			return null;
		}
		if(a.equals("Chvatal") && t > 4){
			System.out.println("Unsupported value for t for algorithm Chvatal: " + t);
			return null;
		}
		
		// Make CA
		System.out.println("Generating "+t+"-wise covering array with algorithm: " + a);
		CoveringArray ca = null;
		
		try{
			Integer.parseInt(argsMap.get("threads"));
		}catch(NumberFormatException e){
			System.out.println("threads must be an integer value.");
			return null;
		}
		
		int threads = new Integer(argsMap.get("threads"));
		ca = cnf.getCoveringArrayGenerator(a, t, threads);
		
		if(argsMap.get("a").equals("Chvatal") && threads!=1){
			System.out.println("For Chvatal, only threads=1 is supported.");
			return null;
		}
		
		// Do not cover all zero tuples
		if(argsMap.containsKey("noAllZeros")){
			ca.coverZeros(false);
		}
		
		// Cover only 
		if(argsMap.containsKey("onlyOnes")){
			ca.coverOnlyOnes(true);
		}
		
		// -
		System.out.println("Running algorithm: " + ca.getAlgorithmName());
		
		// Limit
		String lim = argsMap.get("limit");
		if(lim.contains("%")) lim = lim.substring(0, lim.length()-1);
		int limit = new Integer(lim);
		System.out.println("Covering " + limit + "%");
		
		// Size limit
		Integer sizelimit = Integer.MAX_VALUE;
		if(argsMap.get("sizelimit") != null){
			sizelimit = new Integer(argsMap.get("sizelimit"));
		}
		
		// Start from partial covering array
		if(argsMap.containsKey("startFrom")){
			CoveringArray startFrom = new CoveringArrayFile(new File(argsMap.get("startFrom")));
			ca.startFrom(startFrom);
			System.out.println("Starting from " + argsMap.get("startFrom"));
		}
		
		// Cover
		long start = System.currentTimeMillis();
		ca.generate(limit, sizelimit);
		long end = System.currentTimeMillis();
		System.out.println("Done. Size: " + ca.getRowCount() + ", time: " + (end-start) + " milliseconds");
		
		if(argsMap.containsKey("BTR")){
			if(fm == null){
				System.out.println("BTR only supported for SXFM and GUIDSL");
			}else{
				ca.bowTieReduce(fmfile + ".afm", fm);
				System.out.println("BTR. Size: " + ca.getRowCountBTR());
			}
		}
		
		// Generate output file name
		String cafilename = argsMap.get("o");
		if(cafilename == null)
			cafilename = fmfile + ".ca" + t + ".csv";
		
		// Write to file
		ca.writeToFile(cafilename, CoveringArrayFile.Type.horizontal);
		System.out.println("Wrote result to " + cafilename);
		
		// Bow-tie reduce
		if(argsMap.get("BTR") != null){
			ca.bowTieReduce(fmfile+".afm", fm);
			ca.writeToFile(cafilename + ".btr.csv");
			System.out.println("Wrote result to " + cafilename + ".btr.csv");
		}
		
		return ca;
	}

	long sat_time(Map<String, String> argsMap)
			throws UnsupportedModelException, IOException,
			FeatureModelException, ContradictionException, TimeoutException {
		loadFM(argsMap.get("fm"));
		System.out.println("Satisfying the feature model");
		
		long start, end;
		
		SAT4JSolver s = null;
		s = cnf.getSAT4JSolver();
		//start = System.currentTimeMillis();
		start = System.nanoTime();
		boolean issat = s.isSatisfiable();
		//end = System.currentTimeMillis();
		end = System.nanoTime();
		System.out.println("SAT done: " + (end-start)/1000 + " microseconds, sat: " + issat);
		
		return (end-start)/1000;
	}

	double count_solutions(Map<String, String> argsMap)
			throws UnsupportedModelException, IOException,
			FeatureModelException, BDDExceededBuildingTimeException {
		loadFM(argsMap.get("fm"));
		System.out.println("Counting solutions");
		double sols = fm.getNrOfProducts();
		System.out.println("Solutions: " + sols);
		return sols;
	}

	@Override
	public String toString() {
		return "SPLCATool [m=" + m + ", cnf=" + cnf + ", fm=" + fm + "]";
	}
	
	static Map<String, GUIDSL> guiDSLCache = new HashMap<String, GUIDSL>();
	static Map<String, SXFM> sxfmCache = new HashMap<String, SXFM>();
	static Map<String, CNF> cnfCache = new HashMap<String, CNF>();
	private void loadFM(String file) throws UnsupportedModelException,
			IOException, FeatureModelException {
		if(file.endsWith(".m")){
			System.out.println("Loading GUI DSL: " + file);
			// GUIDSL
			if(guiDSLCache.get(file) == null){
				guiDSLCache.put(file, new GUIDSL(new File(file)));
			}
			m = guiDSLCache.get(file);
			
			// SXFM
			if(sxfmCache.get(file) == null){
				sxfmCache.put(file, m.getSXFM());
			}
			fm = sxfmCache.get(file);
			
			// CNF
			if(cnfCache.get(file) == null){
				cnfCache.put(file, fm.getCNF());
			}
			cnf = cnfCache.get(file);
		}else if(file.endsWith(".xml")){
			System.out.println("Loading SXFM: " + file);
			
			// SXFM
			if(sxfmCache.get(file) == null){
				sxfmCache.put(file, new SXFM(file));
			}
			fm = sxfmCache.get(file);
			
			// CNF
			if(cnfCache.get(file) == null){
				cnfCache.put(file, fm.getCNF());
			}
			cnf = cnfCache.get(file);
		}else if(file.endsWith(".dimacs")){
			System.out.println("Loading dimacs: " + file);
			// CNF
			if(cnfCache.get(file) == null){
				cnfCache.put(file, new CNF(file, CNF.type.dimacs));
			}
			cnf = cnfCache.get(file);
		}else if(file.endsWith(".cnf")){
			System.out.println("Loading cnf: " + file);
			if(cnfCache.get(file) == null){
				cnfCache.put(file, new CNF(file, CNF.type.cnf));
			}
			cnf = cnfCache.get(file);
		}else if(file.endsWith(".dot")){
			throw new UnsupportedOperationException();
		}/*else if(file.endsWith(".constraints")){
			System.out.println("Loading CASA Model: " + file);
			CASAModel cm = new CASAModel(new File(file.split(",")[0]), new File(file.split(",")[1]));
			String guiDSL = cm.getGUIDSL();
			m = new GUIDSL(guiDSL);
			fm = m.getSXFM();
			cnf = fm.getCNF();
		}*/else{
			System.out.println("Unable to load file: " + file);
			return;
		}
		
		System.out.println("Successfully loaded and converted the model:");
		if(fm!=null){
			System.out.println("Features: " + fm.getFeatures());
			System.out.println("Constraints: " + fm.fm.countConstraints());
		}else if(cnf!=null){
			System.out.println("Features: " + cnf.getVariables().size());
			System.out.println("Constraints: " + cnf.getClauses().size());
		}
	}

}

class Improvement implements Comparable<Improvement>{

	protected double coverage;
	protected int productnr;
	protected String featureid1;
	protected char setto1;
	protected double imp;

	public Improvement(double coverage, int productnr, String featureid, char setto, double imp) {
		this.coverage = coverage;
		this.productnr = productnr;
		this.featureid1 = featureid;
		this.setto1 = setto;
		this.imp = imp;
	}

	@Override
	public int compareTo(Improvement a) {
		Improvement b = this;
		if(a.coverage > b.coverage) return 1;
		if(a.coverage < b.coverage) return -1;
		return 0;
	}

	@Override
	public String toString() {
		return "\nImprovement [coverage=" + (float)coverage + "%, productnr=" + productnr
				+ ", featureid=" + featureid1 + ", setto=" + setto1 + ", imp=" + (float)(imp*100) + "%]";
	}
	
}

class Improvement2 extends Improvement{
	protected String featureid2;
	protected char setto2;

	public Improvement2(double coverage, int productnr, String featureid1, String featureid2, char setto1, char setto2, double imp) {
		super(coverage, productnr, featureid1, setto1, imp);
		this.featureid2 = featureid2;
		this.setto2 = setto2;
	}

	@Override
	public String toString() {
		return "\nImprovement2 [coverage=" + (float)coverage + "%, productnr=" + productnr
		+ ", featureid1=" + featureid1 + ", setto1=" + setto1 + ", featureid2=" + featureid2 + ", setto2=" + setto2 + ", imp=" + (float)(imp*100) + "%]";
	}
	
}

class Improvement3 extends Improvement2{
	protected String featureid3;
	protected char setto3;

	public Improvement3(double coverage, int productnr, String featureid1, String featureid2, String featureid3, char setto1, char setto2, char setto3, double imp) {
		super(coverage, productnr, featureid1, featureid2, setto1, setto2, imp);
		this.featureid3 = featureid3;
		this.setto3 = setto3;
	}

	@Override
	public String toString() {
		return "\nImprovement3 [coverage=" + (float)coverage + "%, productnr=" + productnr
		+ ", featureid1=" + featureid1 + ", setto1=" + setto1 + ", featureid2=" + featureid2 + ", setto2=" + setto2 + ", featureid3=" + featureid3 + ", setto3=" + setto3 + ", imp=" + (float)(imp*100) + "%]";
	}
	
}
