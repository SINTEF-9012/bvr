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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Map.Entry;

import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.TimeoutException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.fm.FeatureModelException;

public class CALib {
	static public boolean isCovered1(Map<String, Integer> idnr, Pair unc, List<List<Integer>> solutions) {
		for(List<Integer> s : solutions){
			String id1 = unc.v.getID();
			Integer nr1 = idnr.get(id1);
			if(!unc.b) nr1 = -nr1;
			
			if(s.contains(nr1)){
				return true;
			}
		}
		
		return false;
	}
	
	static public boolean isCovered(Map<String, Integer> idnr, Pair2 unc, List<List<Integer>> solutions) {
		for(List<Integer> s : solutions){
			boolean isCovered = isCoveredS(idnr, unc, s);
			if(isCovered == true) return true;
		}
		
		return false;
	}
	
	static public boolean isCoveredS(Map<String, Integer> idnr, Pair2 unc, List<Integer> s) {
		String id1 = unc.v1.getID();
		Integer nr1 = idnr.get(id1);
		if(!unc.b1) nr1 = -nr1;
		
		String id2 = unc.v2.getID();
		Integer nr2 = idnr.get(id2);
		if(!unc.b2) nr2 = -nr2;
		
		if(s.contains(nr1) && s.contains(nr2)){
			return true;
		}
		
		return false;
	}
	
	static public boolean isCovered3(Map<String, Integer> idnr, Pair3 unc, List<List<Integer>> solutions) {
		for(List<Integer> s : solutions){
			boolean isCovered = isCovered3S(idnr, unc, s);
			if(isCovered == true) return true;
		}
		
		return false;
	}
	
	static public boolean isCovered3S(Map<String, Integer> idnr, Pair3 unc, List<Integer> s) {
		String id1 = unc.v1.getID();
		Integer nr1 = idnr.get(id1);
		if(!unc.b1) nr1 = -nr1;
		
		String id2 = unc.v2.getID();
		Integer nr2 = idnr.get(id2);
		if(!unc.b2) nr2 = -nr2;
		
		String id3 = unc.v3.getID();
		Integer nr3 = idnr.get(id3);
		if(!unc.b3) nr3 = -nr3;
		
		if(s.contains(nr1) && s.contains(nr2) && s.contains(nr3)){
			return true;
		}
		
		return false;
	}
	
	static public boolean isCovered4(Map<String, Integer> idnr, Pair4 unc, List<List<Integer>> solutions) {
		for(List<Integer> s : solutions){
			String id1 = unc.v1.getID();
			Integer nr1 = idnr.get(id1);
			if(!unc.b1) nr1 = -nr1;
			
			String id2 = unc.v2.getID();
			Integer nr2 = idnr.get(id2);
			if(!unc.b2) nr2 = -nr2;
			
			String id3 = unc.v3.getID();
			Integer nr3 = idnr.get(id3);
			if(!unc.b3) nr3 = -nr3;
			
			String id4 = unc.v4.getID();
			Integer nr4 = idnr.get(id4);
			if(!unc.b4) nr4 = -nr4;
			
			if(s.contains(nr1) && s.contains(nr2) && s.contains(nr3) && s.contains(nr4)){
				//if(Math.abs(nr1)==11 && Math.abs(nr2)==14)
				//System.out.println(nr1 + ", " + nr2 + " is covered by " + s);
				return true;
			}
		}
		
		return false;
	}
	
	static public List<Pair> getCovered(Map<Integer, String> nrid, List<Integer> solution, List<BooleanVariableInterface> vars) {
		List<Pair> covered = new ArrayList<Pair>();
		
		for(int i = 0; i < solution.size(); i++){
			Pair pair = new Pair();
			int p = solution.get(i);
			for(BooleanVariableInterface var : vars){
				if(var.getID().equals(nrid.get(Math.abs(p)))){
					pair.v = var;
					pair.b = p>0;
				}
			}
			if(pair.v != null)
				covered.add(pair);
		}
		return covered;
	}

	static public Set<Pair2> intersect(Set<Pair2> set1, Set<Pair2> set2)
	{
	    Set<Pair2> intersection = new HashSet<Pair2>(set1);
	    intersection.retainAll(new HashSet<Pair2>(set2));
	    return intersection;
	}

	static public Set<Pair3> intersect(Set<Pair3> set1, List<Pair3> set2) {
	    Set<Pair3> intersection = new HashSet<Pair3>(set1);
	    intersection.retainAll(new HashSet<Pair3>(set2));
	    return intersection;
	}

	public static void removeAllZeros1(Collection<Pair> collection) {
		Collection<Pair> zeros = new HashSet<Pair>();
		for(Pair p : collection){
			if(p.b == false)
				zeros.add(p);
		}
		collection.removeAll(zeros);
	}

	public static void removeAllZeros2(Collection<Pair2> collection) {
		Collection<Pair2> zeros = new HashSet<Pair2>();
		for(Pair2 p : collection){
			if(p.b1 == false && p.b2 == false)
				zeros.add(p);
		}
		collection.removeAll(zeros);
	}

	public static void removeAllWithZeroes(Collection<Pair2> collection) {
		Collection<Pair2> zeros = new HashSet<Pair2>();
		for(Pair2 p : collection){
			if(p.b1 == false || p.b2 == false)
				zeros.add(p);
		}
		collection.removeAll(zeros);
	}

	public static void removeAllZeros3(Collection<Pair3> collection) {
		Collection<Pair3> zeros = new HashSet<Pair3>();
		for(Pair3 p : collection){
			if(p.b1 == false && p.b2 == false && p.b3 == false)
				zeros.add(p);
		}
		collection.removeAll(zeros);
	}

	public static void removeAllWithZeroes3(Collection<Pair3> collection) {
		Collection<Pair3> zeros = new HashSet<Pair3>();
		for(Pair3 p : collection){
			if(p.b1 == false || p.b2 == false || p.b3 == false)
				zeros.add(p);
		}
		collection.removeAll(zeros);
	}
	
	public static double calc_coverage(CNF cnf, int t, CoveringArray ca){
		if(t==1){
			return calc_coverage_1(cnf, ca);
		}else if(t==2){
			return calc_coverage_2(cnf, ca);
		}else if(t==3){
			return calc_coverage_3(cnf, ca);
		}else{
			System.out.println("Unsupported value of t: " + t);
			
			return 0;
		}
	}
	
	private static double calc_coverage_1(CNF cnf, CoveringArray ca) {
		List<Pair> uncovered = cnf.getU1();
		List<List<Integer>> sols = ca.getSolutionsAsList();
		Set<Pair> coveredPairs = ca.getCovInv1(sols, uncovered);
		return (double)coveredPairs.size()*100/uncovered.size();
	}
	
	private static double calc_coverage_2(CNF cnf, CoveringArray ca) {
		List<Pair2> uncovered = cnf.getU2();
		List<List<Integer>> sols = ca.getSolutionsAsList();
		Set<Pair2> coveredPairs = ca.getCovInv(sols, uncovered);
		return (double)coveredPairs.size()*100/uncovered.size();
	}

	private static double calc_coverage_3(CNF cnf, CoveringArray ca) {
		List<Pair3> uncovered = cnf.getU3();
		List<List<Integer>> sols = ca.getSolutionsAsList();
		Set<Pair3> coveredPairs = ca.getCovInv3(sols, uncovered);
		return (double)coveredPairs.size()*100/uncovered.size();
	}

	public static double calc_coverage_weighted(CNF cnf, int t, CoveringArray ca,
			String fmFileName, int threads, String weightFileName, boolean silent)
			throws UnsupportedModelException, IOException,
			FeatureModelException, CSVException {
		// Analyzing weights
		if(t==1){
			return calc_coverage_weighted_1(cnf, ca, weightFileName, silent);
		}else if(t==2){
			return calc_coverage_weighted_2(cnf, ca, weightFileName, silent);
		}else if(t==3){
			return calc_coverage_weighted_3(cnf, ca, weightFileName, silent);
		}else{
			System.out.println("Unsupported value of t: " + t);
			
			return 0;
		}
	}

	private static double calc_coverage_weighted_1(CNF cnf, CoveringArray ca,
			String weightFileName, boolean silent) throws IOException, CSVException {
		Queue<WPair> q1 = new PriorityQueue<WPair>();
		q1.addAll(generate1wWeights(cnf, weightFileName));
		if(!silent) System.out.println("Weighted singles: " + q1.size());
		
		// Calculate the valid pairs
		List<Pair> uncovered = cnf.getU1();
		if(!silent) System.out.println("Valid singles: " + uncovered.size());
		
		// Calculate the covered pairs
		List<List<Integer>> sols = ca.getSolutionsAsList();
		//System.out.println(sols);
		Set<Pair> coveredPairs = ca.getCovInv1(sols, uncovered);
		if(!silent) System.out.println("Covered singles: " + coveredPairs.size());
		
		// Calculate total weight
		long totalWeight = 0;
		for(WPair p : q1){
			totalWeight += p.getWeight();
		}
		if(!silent) System.out.println("Total weight: " + totalWeight);
		
		// Calculate total weight of valids
		long totalValidWeight = 0;
		for(WPair p : q1){
			if(uncovered.contains(p))
				totalValidWeight += p.getWeight();
		}
		if(!silent) System.out.println("Total valid weight: " + totalValidWeight);
		
		// Calculate covered weight
		long totalCoveredWeight = 0;
		for(WPair p : q1){
			if(coveredPairs.contains(p))
				totalCoveredWeight += p.getWeight();
		}
		if(!silent) System.out.println("Total covered weight: " + totalCoveredWeight);
		
		// Coverage
		double ratio = (double)totalCoveredWeight*100/totalValidWeight;
		int ratioI = (int) Math.round(ratio*100);
		if(!silent) System.out.println("Coverage: " + totalCoveredWeight + "/" + totalValidWeight + " = " + (float)ratioI/100 + "%");
		
		return ratio;
	}
	
	private static double calc_coverage_weighted_2(CNF cnf, CoveringArray ca,
			String weightFileName, boolean silent) throws IOException, CSVException {
		Queue<WPair2> q2 = new PriorityQueue<WPair2>();
		q2.addAll(generate2wWeights(cnf, weightFileName));
		if(!silent) System.out.println("Weighted pairs: " + q2.size());
		
		// Calculate the valid pairs
		List<Pair2> uncovered = cnf.getU2();
		if(!silent) System.out.println("Valid pairs: " + uncovered.size());
		
		// Calculate the covered pairs
		List<List<Integer>> sols = ca.getSolutionsAsList();
		Set<Pair2> coveredPairs = ca.getCovInv(sols, uncovered);
		if(!silent) System.out.println("Covered pairs: " + coveredPairs.size());
		
		// Calculate total weight of valids
		long totalValidWeight = 0;
		for(WPair2 w : q2){
			totalValidWeight += w.getWeight();
		}
		if(!silent) System.out.println("Total valid weight: " + totalValidWeight);
		
		long totalWeight = 0;
		for(WPair2 w : q2){
			totalWeight += w.getWeight();
		}
		if(!silent) System.out.println("Total weight: " + totalWeight);
		
		// Calculate covered weight
		long totalCoveredWeight = 0;
		for(Pair2 u : coveredPairs){
			for(WPair2 w : q2){
				if(w.equals(u)){
					totalCoveredWeight += w.getWeight();
				}
			}
		}
		if(!silent) System.out.println("Total convered weight: " + totalCoveredWeight);
		
		// Coverage
		double ratio = (double)totalCoveredWeight*100/totalValidWeight;
		int ratioI = (int) Math.round(ratio*100);
		if(!silent) System.out.println("Coverage: " + totalCoveredWeight + "/" + totalValidWeight + " = " + (float)ratioI/100 + "%");
		
		return ratio;
	}

	private static double calc_coverage_weighted_3(CNF cnf, CoveringArray ca, String weightFileName, boolean silent) throws IOException, CSVException {
		// Find weights
		Map<Pair3, Integer> q = new HashMap<Pair3, Integer>();
		for(WPair3 p : generate3wWeights(cnf, weightFileName)){
			q.put(p, p.getWeight());
		}
		if(!silent) System.out.println("Weighted triples: " + q.size());
		
		// Calculate the valid pairs
		
		List<Pair3> uncovered = cnf.getU3();
		if(!silent) System.out.println("Valid triples: " + uncovered.size());
		
		// Calculate the covered pairs
		List<List<Integer>> sols = ca.getSolutionsAsList();
		Set<Pair3> coveredTriples = ca.getCovInv3(sols, uncovered);
		if(!silent) System.out.println("Covered triples: " + coveredTriples.size());
		
		// Calculate total weight of valids
		long totalValidWeight = 0;
		for(Pair3 u : uncovered){
			Integer w = q.get(u);
			if(w != null)
				totalValidWeight += w;
		}
		if(!silent) System.out.println("Total valid weight: " + totalValidWeight);
		
		// Calculate covered weight
		long totalCoveredWeight = 0;
		for(Pair3 u : coveredTriples){
			Integer w = q.get(u);
			if(w != null)
				totalCoveredWeight += w;
		}
		if(!silent) System.out.println("Total convered weight: " + totalCoveredWeight);
		
		// Coverage
		double ratio = (double)totalCoveredWeight*100/totalValidWeight;
		int ratioI = (int) Math.round(ratio*100);
		if(!silent) System.out.println("Coverage: " + totalCoveredWeight + "/" + totalValidWeight + " = " + (float)ratioI/100 + "%");
		
		return ratio;
	}

	static private Map<String, Set<WPair>> weightCache1 = new HashMap<String, Set<WPair>>();
	static private Map<String, Set<WPair2>> weightCache2 = new HashMap<String, Set<WPair2>>();
	static private Map<String, Set<WPair3>> weightCache3 = new HashMap<String, Set<WPair3>>();

	public static Set<WPair> generate1wWeights(CNF cnf, String weightsFile) throws IOException, CSVException {
		if(weightCache1.get(weightsFile) != null) return weightCache1.get(weightsFile);
		
		Set<WPair> q = new HashSet<WPair>();
		Map<Integer, Integer> mw = new HashMap<Integer, Integer>();
		
		CoveringArrayFile caw = new CoveringArrayFile(new File(weightsFile));
		for(int n = 0; n < caw.getRowCount(); n++){
			// Convert
			Integer[] solinteger = caw.getRow(n);
			int[] sol = new int[solinteger.length];
			//System.out.println("Weight of " + n + " is " + ca.getWeight(n));
			for(int i = 0; i < sol.length; i++){
				//System.out.println("# \""+caw.getId(i+1)+"\" " + cnf.getNr(caw.getId(i+1)));
				sol[i] = cnf.getNr(caw.getId(i+1));
				if(solinteger[i]==1) sol[i] = -sol[i];
				
				//System.out.println(ca.getId(i+1) + " adds weight " + ca.getWeight(n));
				
				// Weighing
				if(solinteger[i]==2){
					if(mw.get(sol[i]) == null)
						mw.put(sol[i], 0);
					mw.put(sol[i], mw.get(sol[i]) + caw.getWeight(n)/2); // cnf.getVariables().size()
					
					if(mw.get(-sol[i]) == null)
						mw.put(-sol[i], 0);
					mw.put(-sol[i], mw.get(-sol[i]) + caw.getWeight(n)/2); // cnf.getVariables().size()
					continue;
				}
				if(mw.get(sol[i]) == null)
					mw.put(sol[i], 0);
				mw.put(sol[i], mw.get(sol[i]) + caw.getWeight(n));
			}
		}
		
		for(Entry<Integer, Integer> x : mw.entrySet()){
			//System.out.println(x);
			boolean inc = true;
			if(x.getKey()<0) inc = false;
			String id = cnf.getID(Math.abs(x.getKey()));
			//System.out.println(id);
			BooleanVariableInterface b = null;
			for(BooleanVariableInterface z : cnf.getVariables()){
				if(z.getID().equals(id))
					b = z;
			}
			//System.out.println(b);
			q.add(new WPair(b, inc, x.getValue()));
		}
		
		// Remove invalids
		Set<Pair> i1 = cnf.generateInvalid1();
		q.removeAll(i1);
		
		// Add unmodifiable version to cache
		q = Collections.unmodifiableSet(q);
		weightCache1.put(weightsFile, q);
		
		return q;
	}

	public static Set<WPair2> generate2wWeights(CNF cnf, String weightFileName) throws IOException, CSVException {
		if(weightCache2.get(weightFileName) != null) return weightCache2.get(weightFileName);
		
		Set<WPair2> q2 = new HashSet<WPair2>();
		CoveringArrayFile caw = new CoveringArrayFile(new File(weightFileName));
		
		for(int n = 0; n < caw.getRowCount(); n++){
			Integer[] solinteger = caw.getRow(n);
			for(int i = 0; i < solinteger.length; i++){
				for(int j = i+1; j < solinteger.length; j++){
					char ast = ' ';
					if(solinteger[i] == 1) ast = '-';
					if(solinteger[i] == 2) ast = '?';
					if(solinteger[i] == 0) ast = 'X';
					char bst = ' ';
					if(solinteger[j] == 1) bst = '-';
					if(solinteger[j] == 2) bst = '?';
					if(solinteger[j] == 0) bst = 'X';
					int a = cnf.getNr(caw.getId(i+1));
					int b = cnf.getNr(caw.getId(j+1));
					String aid = cnf.getID(Math.abs(a));
					String bid = cnf.getID(Math.abs(b));
					//System.out.println(aid + "(" + ast + "), " + bid + "(" + bst + ")");
					
					// Construct
					Pair2 p = new Pair2(cnf.idnr);
					
					int weightadd = caw.getWeight(n);
					if(ast == '?') weightadd /= 2;
					if(bst == '?') weightadd /= 2;
					
					for(char nast : new char [] {'X', '-'}){
						if(ast != '?') if(ast != nast) continue;
						for(char nbst : new char [] {'X', '-'}){
							if(bst != '?') if(bst != nbst) continue;
							p.b1 = nast=='X'?true:false;
							p.b2 = nbst=='X'?true:false;
							for(BooleanVariableInterface z : cnf.getVariables()){
								if(z.getID().equals(aid))
									p.v1 = z;
							}
							for(BooleanVariableInterface z : cnf.getVariables()){
								if(z.getID().equals(bid))
									p.v2 = z;
							}
							
							if(!q2.contains(p)){
								WPair2 w = new WPair2(cnf.idnr, 0);
								w.b1 = p.b1;
								w.b2 = p.b2;
								w.v1 = p.v1;
								w.v2 = p.v2;
								q2.add(w);
							}
							
							for(WPair2 w : q2){
								if(w.equals(p)){
									w.setWeight(w.getWeight() + weightadd);
								}
							}
						}
					}
				}
			}
		}
		
		// Remove invalids
		Set<Pair2> i2 = cnf.generateInvalid2();
		q2.removeAll(i2);
		
		// Add unmodifiable version to cache
		q2 = Collections.unmodifiableSet(q2);
		weightCache2.put(weightFileName, q2);
		
		return q2;
	}
	
	public static Set<WPair3> generate3wWeights(CNF cnf, String weightFileName) throws IOException, CSVException {
		if(weightCache3.get(weightFileName) != null) return weightCache3.get(weightFileName);
		
		//Map<String, WPair3> hq = new HashMap<String, WPair3>();
		CoveringArrayFile caw = new CoveringArrayFile(new File(weightFileName));
		
		// Map ID to Variable Object
		Map<String, BooleanVariableInterface> idb = new HashMap<String, BooleanVariableInterface>();
		for(BooleanVariableInterface z : cnf.getVariables()){
			idb.put(z.getID(), z);
		}
		
		// Map position to Variable Object
		Map<Integer, BooleanVariableInterface> posvar = new HashMap<Integer, BooleanVariableInterface>();
		
		for(int pos = 0; pos < caw.getRow(0).length; pos++){
			String id = caw.getId(pos+1);
			BooleanVariableInterface v = idb.get(id);
			posvar.put(pos, v);
		}
		
		//System.out.println(posvar);
		
		Map<WPair3, Integer> tuples = new HashMap<WPair3, Integer>();
		
		// Generate all present tuples
		for(int n = 0; n < caw.getRowCount(); n++){
			
			Integer[] solinteger = caw.getRow(n);
			for(int i = 0; i < solinteger.length; i++) for(int j = i+1; j < solinteger.length; j++) for(int k = j+1; k < solinteger.length; k++){
				char ast = ' ';
				if(solinteger[i] == 1) ast = '-';
				if(solinteger[i] == 2) ast = '?';
				if(solinteger[i] == 0) ast = 'X';
				char bst = ' ';
				if(solinteger[j] == 1) bst = '-';
				if(solinteger[j] == 2) bst = '?';
				if(solinteger[j] == 0) bst = 'X';
				char cst = ' ';
				if(solinteger[k] == 1) cst = '-';
				if(solinteger[k] == 2) cst = '?';
				if(solinteger[k] == 0) cst = 'X';

				for(char nast : new char [] {'X', '-'}){
					if(ast != '?') if(ast != nast) continue;
					for(char nbst : new char [] {'X', '-'}){
						if(bst != '?') if(bst != nbst) continue;
						for(char ncst : new char [] {'X', '-'}){
							if(cst != '?') if(cst != ncst) continue;
							
							int weight = caw.getWeight(n);
							
							if(ast == '?') weight /= 2;
							if(bst == '?') weight /= 2;
							if(cst == '?') weight /= 2;
							
							WPair3 p = new WPair3(cnf.idnr, weight);
							p.v1 = posvar.get(i);
							p.v2 = posvar.get(j);
							p.v3 = posvar.get(k);
							p.b1 = (nast=='X')?true:false;
							p.b2 = (nbst=='X')?true:false;
							p.b3 = (ncst=='X')?true:false;
							
							if(tuples.get(p) != null){
								p.setWeight(tuples.get(p) + p.getWeight());
							}
							
							tuples.put(p, p.getWeight());
						}
					}
				}
			}
		}
		
		// Done
		Set<WPair3> q = new HashSet<WPair3>();
		q.addAll(tuples.keySet());
		
		// Remove invalids
		Set<Pair3> i3 = cnf.generateInvalid3();
		q.removeAll(i3);
		
		// Add unmodifiable version to cache
		q = Collections.unmodifiableSet(q);
		weightCache3.put(weightFileName, q);
		
		return q;
	}
	
	public static boolean verifyCA(CNF cnf, CoveringArray ca, boolean verbose, List<String> output) throws ContradictionException, TimeoutException {
		boolean allvalid = true;
		
		SAT4JSolver solver = cnf.getSAT4JSolver();
		if(!solver.solver.isSatisfiable()){
			output.add("Feature model not satisfiable");
			System.exit(0);
		}
		for(int n = 0; n < ca.getRowCount(); n++){
			// Convert
			Integer[] solinteger = ca.getRow(n);
			int[] sol = new int[solinteger.length];
			for(int i = 0; i < sol.length; i++){
				if(cnf.getNr(ca.getId(i+1)) == null){
					output.add("Cannot find \""+ca.nrid.get(i+1)+"\" in feature model, it is in the covering array");
					return false;
				}
				sol[i] = cnf.getNr(ca.getId(i+1));
				if(solinteger[i]==1) sol[i] = -sol[i];
			}
			IVecInt assumps = new VecInt(sol);
			//System.out.println(assumps);
			//System.out.println(n + ", " + assumps.size());
			
			// Test
			if(!solver.solver.isSatisfiable(assumps)){
				if(verbose){
					output.add("Solution invalid: " + n);
					String str = "Reason: (";
					for(int x :solver.solver.unsatExplanation().toArray()){
						str += ((x<0)?"-":"") + cnf.getID(Math.abs(x)) + ", ";
					}
					str += ")";
					output.add(str);
				}
				
				//allvalid = false;
				return false;
			}else{
				//System.out.println("Solution valid: " + n);
			}
		}
		
		return allvalid;
	}
	
	static public boolean verifyWeightedCA(CNF cnf, String caf)
	throws UnsupportedModelException, IOException,
	FeatureModelException, ContradictionException, TimeoutException,
	CSVException {
		boolean isValid = true;

		SAT4JSolver solver = cnf.getSAT4JSolver();
		if(!solver.solver.isSatisfiable()){
			System.out.println("Feature model not satisfiable");
			System.exit(0);
		}

		CoveringArray ca = new CoveringArrayFile(new File(caf));
		for(int n = 0; n < ca.getRowCount(); n++){
			// Convert
			Integer[] solinteger = ca.getRow(n);
			int[] sol = new int[solinteger.length];
			for(int i = 0; i < sol.length; i++){
				if(cnf.getNr(ca.getId(i+1)) == null){
					System.out.println("Cannot find \""+ca.nrid.get(i+1)+"\" in feature model, it is in the covering array");
					return false;
				}
				sol[i] = cnf.getNr(ca.getId(i+1));
				if(solinteger[i]==1) sol[i] = -sol[i];
				if(solinteger[i]==2) sol[i] = 0;
			}
			IVecInt assumps = new VecInt(sol);
			//System.out.println(assumps);
			//System.out.println(n + ", " + assumps.size());

			// Test
			if(!solver.solver.isSatisfiable(assumps)){
				isValid = false;

				System.out.println("Solution invalid: " + n);
				System.out.print("Reason: (");
				for(int x :solver.solver.unsatExplanation().toArray()){
					System.out.print(((x<0)?"-":"") + cnf.getID(Math.abs(x)) + ", ");
				}
				System.out.println(")");
			}else{
				//System.out.println("Solution valid: " + n);
			}
		}
		System.out.println("Verification done");
		return isValid;
	}
}
