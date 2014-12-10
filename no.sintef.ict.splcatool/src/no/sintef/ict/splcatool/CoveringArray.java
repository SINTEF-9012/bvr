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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import no.sintef.ict.splcatool.CoveringArrayFile.Type;

import splar.core.fm.FeatureTreeNode;

public abstract class CoveringArray {
	protected Map<Integer, String> nrid;
	protected Map<String, Integer> idnr;
	protected int t;
	protected List<Integer> btr = new ArrayList<Integer>();
	protected List<List<Integer>> initial = new ArrayList<List<Integer>>();
	protected List<String> featureOrder = new ArrayList<String>();
	
	protected boolean coverZerosOnly = true;
	protected boolean coverOnlyOnes = false;

	abstract public void generate() throws TimeoutException, CoveringArrayGenerationException;
	abstract public void generate(int i, Integer sizelimit) throws TimeoutException, CoveringArrayGenerationException;
	
	abstract public Integer[] getRow(int n);
	abstract public int getRowCount();
	abstract public void setTimeout(int timeout);
	
	@Override
	public boolean equals(Object cabo) {
		CoveringArray cab = (CoveringArray) cabo;
		CoveringArray caa = this;
		
		if(caa.getRowCount() != cab.getRowCount())
			return false;
		for(int i = 0; i<caa.getRowCount(); i++){
			Integer[]rowa = caa.getRow(i);
			Integer[]rowb = cab.getRow(i);
			if(!Arrays.equals(rowa, rowb)){
				return false;
			}
		}
		
		return true;
	}

	
	public void writeToFile(String filename) throws FileNotFoundException, IOException {
		writeToFile(filename, Type.horizontal);
	}
	
	public void writeToFile(String filename, Type type) throws FileNotFoundException, IOException {
		StringBuffer output = new StringBuffer();
		
		/*if(type == Type.vertical){
			List<Integer> nrs = new ArrayList<Integer>(nrid.keySet());
			Collections.sort(nrs);
			
			output.append("Product\\Feature;");
			
			for(int nr : nrs){
				output.append(nrid.get(nr) + ";");
			}
			output.append("\n");
			for(int i = 0; i < getRowCount(); i++){
				output.append(i + ";");
				for(int n : getRow(i)){
					if(n==0)
						output.append("X;");
					else if(n==1)
						output.append("-;");
					else
						output.append("?;");
				}
				if(isRowBTR(i)) output.append("BTR;");
				output.append("\n");
			}
			
			new FileUtility().writeStringToFile(filename, output.toString());
		}else */if(type == Type.horizontal){
			List<Integer> nrs = new ArrayList<Integer>(nrid.keySet());
			Collections.sort(nrs);
			
			output.append("Feature\\Product;");
			for(int i = 0; i < getRowCount(); i++){
				output.append(i + ";");
			}
			output.append("\n");
			
			// Cache rows
			List<Integer[]> rows = new ArrayList<Integer[]>();
			for(int j = 0; j < getRowCount(); j++){
				rows.add(getRow(j));
			}
			
			// Write weights if present
			if(this instanceof CoveringArrayFile){
				CoveringArrayFile ca = (CoveringArrayFile) this;
				if(!ca.weights.isEmpty()){ 
					output.append("#Weight;");
					for(int i = 0; i < getRowCount(); i++)
						output.append(ca.getWeight(i) + ";");
					output.append("\n");
				}
			}
			
			// Write rows
			for(int i = 0; i < nrs.size(); i++){
				output.append(nrid.get(nrs.get(i)) + ";");
				for(int j = 0; j < getRowCount(); j++){
					int n = rows.get(j)[i];
					if(n==0)
						output.append("X;");
					else if(n==1)
						output.append("-;");
					else
						output.append("?;");
				}
				output.append("\n");
			}
			
			// Sort if featureOrder is populated
			if(featureOrder.size() > 0){
				//System.out.println("Sorting");
				String lines[] = output.toString().split("\n");
				
				output = new StringBuffer(lines[0] + "\n");
				
				for(String id : featureOrder){
					//System.out.println(id);
					for(int i = 1; i < lines.length; i++){
						String line = lines[i];
						if(line.split(";")[0].equals(id)){
							output.append(line + "\n");
							break;
						}
					}
				}
			}
		}
		
		//System.out.println(output.toString());
		
		// Write to file
		new FileUtility().writeStringToFile(filename, output.toString());
	}
	
	abstract public double estimateGenerationTime();
	public int getT() {
		return t;
	}
	
	public void bowTieReduce(String annFileName, SXFM fm) throws IOException{
		btr = new ArrayList<Integer>();
		
		// Load file
		String anns = new FileUtility().readFileAsString(annFileName);
		//System.err.println(anns);
		
		List<String> alfsRoots = new ArrayList<String>();
		for(String ann : anns.split("\n")){
			String command = ann.split(" ")[0];
			if(command.equals("AL")){
				alfsRoots.add(ann.substring("AL".length()+1).trim()); // Rest of the line
			}
			//System.err.println(ann);
		}
		//System.err.println(alfsRoots);
		
		// Add all AL features
		List<String> alfs = new ArrayList<String>();
		for(String alfRoot : alfsRoots){
			//System.err.println(p.fm.FM2CNF().getVariables());
			traverseChildren(alfs, fm.getNodeByID(alfRoot));
		}
		
/*		System.err.println(alfs);
		System.err.println(alfs.size());
		System.err.println(nrid);
*/				
		// Get Rows
		Set<String> rows = new HashSet<String>();
		for(int i=0;i<getRowCount();i++){
			String row = "";
			int k = 1;
			for(int j : getRow(i)){
				if(alfs.contains(nrid.get(k++))){
					continue;
				}
				String res = "0";
				if(j == 0) res = "1";
				row += res;
			}
			if(rows.contains(row)) btr.add(i);
			rows.add(row);
		}
		
/*		for(String row : rows)
			System.err.println(row);
*/
		//System.err.println("BTR: " + rows.size());
		//System.out.println(btr);
	}
	
	public boolean isRowBTR(int i){
		return btr.contains(i);
	}
	
	public int getRowCountBTR(){
		return getRowCount()-btr.size();
	}
	
	private void traverseChildren(List<String> alfs, FeatureTreeNode n){
		@SuppressWarnings("unchecked")
		Enumeration<FeatureTreeNode> cs = n.children();
		while(cs.hasMoreElements()){
			FeatureTreeNode f = cs.nextElement();
			//System.err.println(f);
			alfs.add(f.getID());
			if(f.children().hasMoreElements())
				traverseChildren(alfs, f);
		}
	}
	abstract public String getAlgorithmName();
	public void startFrom(CoveringArray partial) {
		for(int n = 0; n < partial.getRowCount(); n++){
			// Convert
			Integer[] solinteger = partial.getRow(n);
			List<Integer> sol = new ArrayList<Integer>();
			for(int i = 0; i < solinteger.length; i++){
				int x = idnr.get(partial.nrid.get(i+1));
				if(solinteger[i]==1) x = -x;
				sol.add(x);
			}
			initial.add(sol);
		}
		
		List<Integer> nrs = new ArrayList<Integer>(partial.idnr.values());
		Collections.sort(nrs);
		for(Integer n : nrs){
			featureOrder.add(partial.nrid.get(n));
		}
		//System.out.println(featureOrder);
	}
	abstract public long getCoverage();
	
	public List<List<Integer>> getSolutionsAsList(){
		List<List<Integer>> sols = new ArrayList<List<Integer>>();
		for(int i=0;i<getRowCount();i++){
			Integer rowa[] = getRow(i);
			List<Integer> row = new ArrayList<Integer>();
			for(int j=0;j<rowa.length;j++)
				row.add((rowa[j]==0)?(j+1):-(j+1));
			sols.add(row);
		}
		return sols;
	}
	
	public Set<Pair> getCovInv1(List<List<Integer>> sols, List<Pair> uncovered) {
		Set<Pair> covered = new HashSet<Pair>();
		for(Pair p : uncovered){
			for(List<Integer> sol : sols)
				if(isCovered1(p, sol))
					covered.add(p);
		}
		return covered;
	}
	
	private boolean isCovered1(Pair unc, List<Integer> s) {
		String id1 = unc.v.getID();
		//System.out.println(id1);
		//System.out.println(idnr);
		Integer nr1 = idnr.get(id1);
		if(!unc.b) nr1 = -nr1;
		
		if(s.contains(nr1)){
			return true;
		}
		
		return false;
	}
	
	public Set<Pair2> getCovInv(List<List<Integer>> sols, List<Pair2> uncovered){
		Set<Pair2> coveredSet = new HashSet<Pair2>();
		int threads = sols.size();
		
		List<List<Pair2>> uncSplit = new ArrayList<List<Pair2>>();
		int beg=0, range=uncovered.size()/threads + 1;
		for(int i = 0; i < threads; i++){
			if(beg+range > uncovered.size()) range = uncovered.size() - beg;
			uncSplit.add(uncovered.subList(beg, beg+range));
			//System.out.println(beg + " ->" + (beg+range));
			beg += range;
		}
		
		List<GCInvThread> gcs = new ArrayList<GCInvThread>();
		List<Thread> ts = new ArrayList<Thread>();
		for(int i = 0; i< sols.size(); i++){
			GCInvThread gc = new GCInvThread(sols, uncSplit.get(i), nrid, idnr);
			gcs.add(gc);
			ts.add(new Thread(gc));
		}
		
		for(int i = 0; i< sols.size(); i++){
			ts.get(i).start();
		}
		
		// Start monitoring thread
		List<ProgressReporter> prs = new ArrayList<ProgressReporter>(gcs);
		ProgressThread pt = new ProgressThread("Find covered", prs, uncovered.size());
		Thread ptt = new Thread(pt);
		ptt.start();
		
		// Wait for threads to finish
		for(int i = 0; i < threads; i++){
			try {
				ts.get(i).join();
			} catch (InterruptedException e) {
			}
		}
		
		// Stop monitoring
		pt.stop();
		
		// Collect
		for(int i = 0; i< sols.size(); i++){
			coveredSet.addAll(gcs.get(i).getCovered());
		}
		
		return coveredSet;
	}
	
	public Set<Pair3> getCovInv3(List<List<Integer>> sols, List<Pair3> uncovered){
		Set<Pair3> coveredSet = new HashSet<Pair3>();
		int threads = sols.size();
		
		List<List<Pair3>> uncSplit = new ArrayList<List<Pair3>>();
		int beg=0, range=uncovered.size()/threads + 1;
		for(int i = 0; i < threads; i++){
			if(beg+range > uncovered.size()) range = uncovered.size() - beg;
			uncSplit.add(uncovered.subList(beg, beg+range));
			//System.out.println(beg + " ->" + (beg+range));
			beg += range;
		}
		
		List<GCInvThread3> gcs = new ArrayList<GCInvThread3>();
		List<Thread> ts = new ArrayList<Thread>();
		for(int i = 0; i< sols.size(); i++){
			GCInvThread3 gc = new GCInvThread3(sols, uncSplit.get(i), nrid, idnr);
			gcs.add(gc);
			ts.add(new Thread(gc));
		}
		
		for(int i = 0; i< sols.size(); i++){
			ts.get(i).start();
		}
		
		// Start monitoring thread
		List<ProgressReporter> prs = new ArrayList<ProgressReporter>(gcs);
		ProgressThread pt = new ProgressThread("Find covered", prs, uncovered.size());
		Thread ptt = new Thread(pt);
		ptt.start();
		
		// Wait for threads to finish
		for(int i = 0; i < threads; i++){
			try {
				ts.get(i).join();
			} catch (InterruptedException e) {
			}
		}
		
		// Stop monitoring
		pt.stop();
		
		// Collect
		for(int i = 0; i< sols.size(); i++){
			coveredSet.addAll(gcs.get(i).getCovered());
		}
		
		return coveredSet;
	}
	
	public String getId(int i) {
		return nrid.get(i);
	}
	
	public void coverZeros(boolean doCover) {
		coverZerosOnly = doCover;
	}
	
	public void coverOnlyOnes(boolean coverOnes) {
		this.coverOnlyOnes  = coverOnes;
	}
	public long getCovCount3(List<List<Integer>> sols, List<Pair3> u3) {
		int threads = sols.size();
		
		List<List<Pair3>> uncSplit = new ArrayList<List<Pair3>>();
		int beg=0, range=u3.size()/threads + 1;
		for(int i = 0; i < threads; i++){
			if(beg+range > u3.size()) range = u3.size() - beg;
			uncSplit.add(u3.subList(beg, beg+range));
			//System.out.println(beg + " ->" + (beg+range));
			beg += range;
		}
		
		List<GCInvThread3Count> gcs = new ArrayList<GCInvThread3Count>();
		List<Thread> ts = new ArrayList<Thread>();
		for(int i = 0; i< sols.size(); i++){
			GCInvThread3Count gc = new GCInvThread3Count(sols, uncSplit.get(i), nrid, idnr);
			gcs.add(gc);
			ts.add(new Thread(gc));
		}
		
		for(int i = 0; i< sols.size(); i++){
			ts.get(i).start();
		}
		
		// Start monitoring thread
		List<ProgressReporter> prs = new ArrayList<ProgressReporter>(gcs);
		ProgressThread pt = new ProgressThread("Find covered", prs, u3.size());
		Thread ptt = new Thread(pt);
		ptt.start();
		
		// Wait for threads to finish
		for(int i = 0; i < threads; i++){
			try {
				ts.get(i).join();
			} catch (InterruptedException e) {
			}
		}
		
		// Stop monitoring
		pt.stop();
		
		// Collect
		long count = 0;
		for(int i = 0; i< sols.size(); i++){
			count += gcs.get(i).getCovered();
		}
		
		return count;
	}
	public long getCovInvCount(List<List<Integer>> sols, List<Pair2> uncovered) {
		int threads = sols.size();
		
		List<List<Pair2>> uncSplit = new ArrayList<List<Pair2>>();
		int beg=0, range=uncovered.size()/threads + 1;
		for(int i = 0; i < threads; i++){
			if(beg+range > uncovered.size()) range = uncovered.size() - beg;
			uncSplit.add(uncovered.subList(beg, beg+range));
			//System.out.println(beg + " ->" + (beg+range));
			beg += range;
		}
		
		List<GCInvThreadCount> gcs = new ArrayList<GCInvThreadCount>();
		List<Thread> ts = new ArrayList<Thread>();
		for(int i = 0; i< sols.size(); i++){
			GCInvThreadCount gc = new GCInvThreadCount(sols, uncSplit.get(i), idnr);
			gcs.add(gc);
			ts.add(new Thread(gc));
		}
		
		for(int i = 0; i< sols.size(); i++){
			ts.get(i).start();
		}
		
		// Start monitoring thread
		List<ProgressReporter> prs = new ArrayList<ProgressReporter>(gcs);
		ProgressThread pt = new ProgressThread("Find covered", prs, uncovered.size());
		Thread ptt = new Thread(pt);
		ptt.start();
		
		// Wait for threads to finish
		for(int i = 0; i < threads; i++){
			try {
				ts.get(i).join();
			} catch (InterruptedException e) {
			}
		}
		
		// Stop monitoring
		pt.stop();
		
		// Collect
		long count = 0;
		for(int i = 0; i< sols.size(); i++){
			count += gcs.get(i).getCovered();
		}
		
		return count;
	}
}
