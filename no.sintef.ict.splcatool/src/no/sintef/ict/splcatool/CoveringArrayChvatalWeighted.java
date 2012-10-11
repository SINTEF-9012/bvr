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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IVecInt;

import splar.core.constraints.BooleanVariableInterface;

public class CoveringArrayChvatalWeighted extends CoveringArray {

	private CNF cnf;
	private long coverage = 0;
	private List<List<Integer>> result;
	private List<Integer> nrs = null;
	private String weightFile;

	public CoveringArrayChvatalWeighted(int t, CNF cnf, Map<Integer, String> nrid, Map<String, Integer> idnr, int threads, String weightFile) {
		this.t = t;
		this.cnf = cnf;
		this.nrid = nrid;
		this.idnr = idnr;
		this.weightFile = weightFile;
	}

	public long getCoverage(){
		return(coverage);
	}

	@Override
	public void generate(int coverLimit, Integer sizelimit) throws TimeoutException, CoveringArrayGenerationException {
		if(t==1){
			try {
				generate1(coverLimit, sizelimit);
			} catch (org.sat4j.specs.TimeoutException e) {
				throw new TimeoutException();
			}
		}else if(t==2){ generate2(coverLimit, sizelimit);
		}else if(t==3){ generate3(coverLimit, sizelimit);
		}else throw new UnsupportedOperationException();
	}

	@Override
	public void generate() throws TimeoutException, CoveringArrayGenerationException {
		generate(100, Integer.MAX_VALUE);
	}

	@Override
	public Integer[] getRow(int n) {
		if(nrs == null){
			nrs = new ArrayList<Integer>(nrid.keySet());
			Collections.sort(nrs);
		}
		
		List<Integer> nl = result.get(n);
		Integer[] res = new Integer[nl.size()];
		
		for(int i = 0; i < nrs.size(); i++){
			int x = nrs.get(i);
			for(int j = 0; j < nl.size(); j++){
				if(Math.abs(nl.get(j)) == x)
					res[i] = nl.get(j)<0?1:0;
			}
		}

		return res;
	}

	@Override
	public int getRowCount() {
		return result.size();
	}

	@Override
	public void setTimeout(int timeout) {
	}

	@Override
	public double estimateGenerationTime() {
		int F = cnf.getVariables().size();
		
		if(t == 2) return Math.exp(0.37*Math.log(F) + 1.30);
		if(t == 3) return Math.exp(1.09*Math.log(F) + 0.00);
		
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String getAlgorithmName() {
		return "Chvatal's algorithm adopted for Covering Array generation (Weighted)";
	}

	private void generate1(int coverLimit, Integer sizelimit) throws TimeoutException, org.sat4j.specs.TimeoutException {		
		// Weighted tuples to cover
		Queue<WPair> uncoveredq = new PriorityQueue<WPair>();
		try {
			uncoveredq.addAll(CALib.generate1wWeights(cnf, weightFile));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Calculate totalt weight
		int totalweight = 0;
		for(WPair p : uncoveredq){
			totalweight += p.getWeight();
		}
		System.out.println("Total weight: " + totalweight);
		System.out.println("Total singles: " + uncoveredq.size());
		
		// Remove already covered
		List<List<Integer>> solutions = new ArrayList<List<Integer>>(initial);
		List<WPair> uncoveredqtmp = new ArrayList<WPair>(uncoveredq);
		long alreadyCovered = 0;
		for(WPair p : uncoveredqtmp){
			if(CALib.isCovered1(idnr, p, solutions)){
				uncoveredq.remove(p);
				alreadyCovered++;
			}
		}
		System.out.println("Uncovered pairs left: " + uncoveredq.size());
		System.out.println("Already covered: " + alreadyCovered);
		
		// Cover
		while(true){
			// Break if limit reached
			// Calculate weight left
			int weightleft = 0;
			for(WPair p : uncoveredq){
				weightleft += p.getWeight();
			}
			System.out.println("Weight left: " + weightleft + " of " + totalweight + " = " + (double)weightleft*100/totalweight);
			
			if(100-weightleft*100/totalweight > coverLimit)
				break;
			
			// Check for limit
			if(solutions.size() >= sizelimit) break;
			
			// Cover as many as possible
			List<Pair> canBeSet = new ArrayList<Pair>();
			Queue<WPair> x = new PriorityQueue<WPair>(uncoveredq);
			Set<Integer> sol = new HashSet<Integer>();
			
			while(!x.isEmpty()){
				SAT4JSolver satSolver = null;
				try {
					satSolver = cnf.getSAT4JSolver();
				} catch (ContradictionException e) {
				}
				
				Pair p = x.remove();
				
				// Set it
				int var1nr = (p.b?1:-1) * cnf.getNr(p.v.getID());
				
				// Check
				try {
					// List
					List<Integer> assumpsList = new ArrayList<Integer>();
					for(int a : sol){
						assumpsList.add(a);
					}
					
					if(assumpsList.contains(-var1nr)) continue;
					
					assumpsList.add(var1nr);
					
					// Convert
					int assumpsArray[] = new int[assumpsList.size()];
					int c = 0;
					for(int a : assumpsList){
						assumpsArray[c] = a;
						c++;
					}
					IVecInt assumps = new VecInt(assumpsArray);
					
					//System.out.println(assumps);
					
					// Check
					if(satSolver.solver.isSatisfiable(assumps)){
						sol.add(var1nr);
						canBeSet.add(p);
						uncoveredq.remove(p);
						//System.out.println("sat: " + varnr);
					}else{
						//System.out.println("unsat: " + varnr + ", " + p.v.getID());
					}
					
					/*if(varnr == -101){
						System.exit(-1);
					}*/
				} catch (org.sat4j.specs.TimeoutException e1) {
				}
			}
			
			SAT4JSolver satSolver = null;
			try {
				satSolver = cnf.getSAT4JSolver();
			} catch (ContradictionException e) {
			}

			
			// Break if no more covered
			if(canBeSet.size() == 0){
				System.out.println("Breaking at " + uncoveredq.size() + " invalids");
				break;
			}else{
				System.out.println("Covered at " + (uncoveredq.size()+canBeSet.size()) + ", " + canBeSet.size());
				//System.out.println(canBeSet);
			}
			
			// Convert
			int assumpsArray[] = new int[sol.size()];
			int c = 0;
			for(int a : sol){
				assumpsArray[c] = a;
				c++;
			}
			IVecInt assumps = new VecInt(assumpsArray);

			// Solve
			try {
				satSolver.solver.isSatisfiable(assumps);
			} catch (org.sat4j.specs.TimeoutException e1) {
			}
			int[] s = satSolver.solver.model();
			
			List<Integer> solution = new ArrayList<Integer>();
			for(int i : s)
				solution.add(i);
			
			// Add solution
			solutions.add(solution);
		}
		
		// Done
		result = solutions;
	}
	
	private void generate2(int coverLimit, Integer sizelimit) throws CoveringArrayGenerationException{
		// Make queue based on weights
		Queue<WPair2> uncoveredq = new PriorityQueue<WPair2>();
		try {
			uncoveredq.addAll(CALib.generate2wWeights(cnf, weightFile));
		} catch (Exception e) {
			throw new CoveringArrayGenerationException("File not found: " + weightFile);
		}
			
		// Calculate totalt weight
		long totalweight = 0;
		for(WPair2 p : uncoveredq){
			totalweight += p.getWeight();
		}
		System.out.println("Total weight: " + totalweight);
		
		// Remove already covered
		List<List<Integer>> solutions = new ArrayList<List<Integer>>(initial);
		long alreadyCovered = 0;
		List<WPair2> uncoveredqtmp = new ArrayList<WPair2>(uncoveredq);
		for(WPair2 p : uncoveredqtmp){
			if(CALib.isCovered(idnr, p, solutions)){
				uncoveredq.remove(p);
				alreadyCovered++;
			}
		}
		System.out.println("Uncovered pairs left: " + uncoveredq.size());
		System.out.println("Already covered: " + alreadyCovered);

		// Get solver
		SAT4JSolver satSolver = null;
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException e) {
		}
		
		// Cover
		while(true){
			// Break if limit reached
			// Calculate weight left
			long weightleft = 0;
			for(WPair2 p : uncoveredq){
				weightleft += p.getWeight();
			}
			System.out.println("Weight left: " + weightleft + " of " + totalweight + " = " + (double)weightleft*100/totalweight);
			
			if(100-(double)weightleft*100/totalweight >= coverLimit)
				break;
			
			// Check for limit
			if(solutions.size() >= sizelimit) break;
			
			// Cover as many as possible
			List<Pair2> canBeSet = new ArrayList<Pair2>();
			Queue<Pair2> x = new PriorityQueue<Pair2>(uncoveredq);
			
			// assumptions
			Set<Integer> sol = new HashSet<Integer>();
			
			//System.out.println("Uncovered: " +uncovered.size());
			for(int i=0; !x.isEmpty(); i++){
				Pair2 p = x.remove();
				
				if(i%1000 == 0) System.out.println(i + "/" + x.size());
				
				// Get the two pairs
				boolean b1 = p.b1;
				boolean b2 = p.b2;
				BooleanVariableInterface v1 = p.v1;
				BooleanVariableInterface v2 = p.v2;
				Pair p1 = new Pair();
				p1.v = v1;
				p1.b = b1;
				Pair p2 = new Pair();
				p2.v = v2;
				p2.b = b2;
				
				// Set it
				int var1nr, var2nr;
				var1nr = (b1?1:-1) * idnr.get(v1.getID());
				var2nr = (b2?1:-1) * idnr.get(v2.getID());
				
				// Check
				try {
					// List
					List<Integer> assumpsList = new ArrayList<Integer>();
					for(int a : sol){
						assumpsList.add(a);
					}
					if(assumpsList.contains(-var1nr)) continue;
					if(assumpsList.contains(-var2nr)) continue;
					
					assumpsList.add(var1nr);
					assumpsList.add(var2nr);
					
					// Convert
					int assumpsArray[] = new int[assumpsList.size()];
					int c = 0;
					for(int a : assumpsList){
						assumpsArray[c] = a;
						c++;
					}
					IVecInt assumps = new VecInt(assumpsArray);
					
					// Check
					if(satSolver.solver.isSatisfiable(assumps)){
						sol.add(var1nr);
						sol.add(var2nr);
						canBeSet.add(p);
						uncoveredq.remove(p);
					}
				} catch (org.sat4j.specs.TimeoutException e1) {
				}
			}
			
			// Convert
			int asssumpsArray[] = new int[sol.size()];
			int c = 0;
			for(int a : sol){
				asssumpsArray[c] = a;
				c++;
			}
			IVecInt assumps = new VecInt(asssumpsArray);
			
			try {
				satSolver.solver.isSatisfiable(assumps);
			} catch (org.sat4j.specs.TimeoutException e1) {
			}
			int[] s = satSolver.solver.model();
			List<Integer> solution = new ArrayList<Integer>();
			for(int z : s)
				solution.add(z);
			
			// Check if done
			if(canBeSet.size() == 0){
				System.out.println("Breaking at " + uncoveredq.size() + " invalids");
				break;
			}else{
				System.out.println("Covered at " + (uncoveredq.size()+canBeSet.size()) + ", " + canBeSet.size());
				//System.out.println(canBeSet);
			}
			
			// Return
			solutions.add(solution);
		}
	
		// Done
		result = solutions;
	}

	private void generate3(int coverLimit, Integer sizelimit) throws CoveringArrayGenerationException{
		// Make queue based on weights
		Queue<WPair3> uncoveredq = new PriorityQueue<WPair3>();
		try {
			uncoveredq.addAll(CALib.generate3wWeights(cnf, weightFile));
		} catch (Exception e) {
			throw new CoveringArrayGenerationException("Error generating weighted queue.");
		}
		
		System.out.println("Queue elements: " + uncoveredq.size());
		System.out.println("Uncovered triples left: " + uncoveredq.size());
		
		// Calculate totalt weight
		long totalweight = 0;
		for(WPair3 p : uncoveredq){
			totalweight += p.getWeight();
		}
		System.out.println("Total weight: " + totalweight);
		
		// Remove already covered
		List<List<Integer>> solutions = new ArrayList<List<Integer>>(initial);
		long alreadyCovered = 0;
		{
			Set<WPair3> uncovered = new HashSet<WPair3>(uncoveredq);
			uncoveredq.clear();
			for(WPair3 p : uncoveredq){
				if(CALib.isCovered3(idnr, p, solutions)){
					uncovered.remove(p);
					alreadyCovered++;
				}
			}
			uncoveredq.addAll(uncovered);
		}
		
		if(solutions.size()>=1){
			Set<Pair3> covered = getCovInv3(solutions, new ArrayList<Pair3>(uncoveredq));
			alreadyCovered = covered.size();
			uncoveredq.removeAll(covered);
		}
		
		System.out.println("Uncovered triples left: " + uncoveredq.size());
		System.out.println("Already covered: " + alreadyCovered);
		System.out.println("Starting from solutions: " + solutions.size());
		
		// Cover
		int threads = 1;
		while(true){
			// Break if limit reached
			// Calculate weight left
			long weightleft = 0;
			for(WPair3 p : uncoveredq){
				weightleft += p.getWeight();
			}
			System.out.println("Weight left: " + weightleft + " of " + totalweight + " = " + (double)weightleft*100/totalweight);
			System.out.println("Tuples left " + uncoveredq.size());
			
			if(100-(double)weightleft*100/totalweight >= coverLimit)
				break;
			
			// Check for limit
			if(solutions.size() >= sizelimit) break;
			
			List<List<Integer>> sols = new ArrayList<List<Integer>>();
			long uncTotal = alreadyCovered + uncoveredq.size();
			
			// Start threads
			{
				List<C3SplitThreadWeighted> fmts = new ArrayList<C3SplitThreadWeighted>();
				List<Thread> ts = new ArrayList<Thread>();
				ArrayList<Queue<WPair3>> uncSplit = new ArrayList<Queue<WPair3>>();
				for(int i = 0; i < threads; i++){
					uncSplit.add(new PriorityQueue<WPair3>());
				}
				int n = 0;
				while(!uncoveredq.isEmpty()){
					WPair3 top = uncoveredq.poll();
					uncSplit.get(n).add(top);
					n++;
					n %= threads;
				}
				
				for(int i = 0; i < threads; i++){
					C3SplitThreadWeighted fmt = new C3SplitThreadWeighted(cnf, uncSplit.get(i), idnr);
					fmts.add(fmt);
					Thread t = new Thread(fmt);
					ts.add(t);
				}
				
				for(int i = 0; i < threads; i++){
					ts.get(i).start();
				}
				
				// Start monitoring thread
				List<ProgressReporter> prs = new ArrayList<ProgressReporter>(fmts);
				ProgressThread pt = new ProgressThread("Cover triples", prs, uncTotal);
				Thread ptt = new Thread(pt);
				ptt.start();
				
				// Wait for all threads to finish
				for(int i = 0; i < threads; i++){
					try {
						ts.get(i).join();
					} catch (InterruptedException e) {
					}
				}
				
				// Stop monitoring
				pt.stop();
				
				// Round complete
				System.out.println("Round complete");
				for(int i = 0; i < threads; i++){
					uncoveredq.addAll(fmts.get(i).getUncovered());
				}
				for(int i = 0; i < threads; i++){
					sols.addAll(fmts.get(i).getSolutions());
				}
			}
			
			// Remove covered
			int newcovered;
			Set<Pair3> cov;
			{
				cov = getCovInv3(sols, new ArrayList<Pair3>(uncoveredq));
				System.out.println("Additionally covered " + cov.size());
				newcovered = uncoveredq.size();
				Set<WPair3> uncovSet = new HashSet<WPair3>(uncoveredq);
				uncoveredq.clear();
				uncovSet.removeAll(cov);
				uncoveredq.addAll(uncovSet);
				uncovSet.clear();
			}
			
			newcovered = newcovered - uncoveredq.size();
			
			// Store
			solutions.addAll(sols);
		}

		// Done
		result = solutions;
	}
/*
	private void getInvalid1(List<Pair> uncovered, List<Pair> invalid) {
		// Get SAT-solver
		SAT4JSolver satSolver = null;
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException e) {
		}
		
		// Find invalid
		for(int i=0; i<uncovered.size(); i++){
			
			Pair p = uncovered.get(i);
			
			// Set it
			int var1nr = (p.b?1:-1) * cnf.getNr(p.v.getID());
			
			// Check
			try {
				// List
				List<Integer> assumpsList = new ArrayList<Integer>();
				assumpsList.add(var1nr);
				
				// Convert
				int assumpsArray[] = new int[assumpsList.size()];
				int c = 0;
				for(int a : assumpsList){
					assumpsArray[c] = a;
					c++;
				}
				IVecInt assumps = new VecInt(assumpsArray);
							
				// Check
				if(!satSolver.solver.isSatisfiable(assumps)){
					invalid.add(p);
				}
			} catch (org.sat4j.specs.TimeoutException e1) {
			}
		}
	}

	private List<Pair2> getInvalid(int coveredInitially, List<Pair2> uncovered) {
		int uncTotal = uncovered.size() + coveredInitially;
		
		// This should run
		Runtime runtime = Runtime.getRuntime();        
	    int threads = runtime.availableProcessors();
	    System.out.println("Threads for this task: " + threads);
		
		// Remove invalid
		List<List<Pair2>> uncSplit = new ArrayList<List<Pair2>>();
		int beg=0, range=uncovered.size()/threads + 1;
		for(int i = 0; i < threads; i++){
			if(beg+range > uncovered.size()) range = uncovered.size() - beg;
			uncSplit.add(uncovered.subList(beg, beg+range));
			//System.out.println(beg + " ->" + (beg+range));
			beg += range;
		}
	
		List<RIThread> rits = new ArrayList<RIThread>();
		List<Thread> ts = new ArrayList<Thread>();
		for(int i = 0; i < threads; i++){
			RIThread rit = new RIThread(cnf, uncSplit.get(i), nrid, idnr, new HashSet<Pair2>());
			rits.add(rit);
			Thread t = new Thread(rit);
			ts.add(t);
		}
		
		for(int i = 0; i < threads; i++){
			ts.get(i).start();
		}
		
		// Start monitoring thread
		List<ProgressReporter> prs = new ArrayList<ProgressReporter>(rits);
		ProgressThread pt = new ProgressThread("Find invalid", prs, uncTotal);
		Thread ptt = new Thread(pt);
		ptt.start();
		
		// Wait for all threads to finish
		for(int i = 0; i < threads; i++){
			try {
				ts.get(i).join();
			} catch (InterruptedException e) {
			}
		}
		
		// Stop monitoring
		pt.stop();
		
		// Collect
		uncovered = new ArrayList<Pair2>();
		for(int i = 0; i < threads; i++){
			uncovered.addAll(rits.get(i).getValid());
		}
		
		// Return
		return uncovered;
	}
	*/
}

