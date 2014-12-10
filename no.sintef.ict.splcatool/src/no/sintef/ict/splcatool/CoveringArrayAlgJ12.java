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
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.apache.commons.math.util.MathUtils;

import splar.core.constraints.BooleanVariableInterface;

public class CoveringArrayAlgJ12 extends CoveringArray {
	private CNF cnf;
	private int threads;
	private long coverage = 0;
	private List<List<Integer>> result;
	private List<Integer> nrs = null;

	public CoveringArrayAlgJ12(int t, CNF cnf, Map<Integer, String> nrid, Map<String, Integer> idnr, int threads) {
		this.t = t;
		this.cnf = cnf;
		this.nrid = nrid;
		this.idnr = idnr;
		this.threads = threads;
	}

	public long getCoverage(){
		return(coverage);
	}

	@Override
	public Integer[] getRow(int n) {
		if(nrs == null){
			nrs = new ArrayList<Integer>(nrid.keySet());
			Collections.sort(nrs);
		}
		
		List<Integer> nl = result.get(n);
		Integer[] res = new Integer[nl.size()];
		
/*		if(nl.size() != nrs.size()){
			System.out.println("Incompatible sizes: " + nl.size() + " and " + nrs.size());
			System.exit(-1);
		}
*/		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public double estimateGenerationTime() {
		int F = cnf.getVariables().size();
		
		if(t == 2) return Math.exp(0.52*Math.log(F) + 0.80);
		if(t == 3) return Math.exp(0.69*Math.log(F) + 1.25);
		
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String getAlgorithmName() {
		return "J12 (Pair-split parallelization, SAT-exploitation, Logical Pair-reduction -- PSL)";
	}

	@Override
	public void generate() throws TimeoutException {
		generate(100, Integer.MAX_VALUE);
	}

	@Override
	public void generate(int coverLimit, Integer sizelimit) throws TimeoutException {
		if(t==1){
			try {
				generate1(coverLimit, sizelimit);
			} catch (org.sat4j.specs.TimeoutException e) {
				throw new TimeoutException();
			}
		}else if(t==2){
			try {
				generate2(coverLimit, sizelimit);
			} catch (org.sat4j.specs.TimeoutException e) {
				throw new TimeoutException();
			}
		}else if(t==3){
			try {
				generate3(coverLimit, sizelimit);
			} catch (org.sat4j.specs.TimeoutException e) {
				throw new TimeoutException();
			}
		}else throw new UnsupportedOperationException();
	}

	private void generate1(int coverLimit, Integer sizelimit) throws TimeoutException, org.sat4j.specs.TimeoutException {
		System.out.println("--- 1-wise ---");
		
		// Storage Structures
		List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(cnf.getVariables());
		List<List<Integer>> solutions = new ArrayList<List<Integer>>(initial);
		int nrVars = vars.size();
	    
	    // Generate I_1
		Set<Pair> invalid1w = new HashSet<Pair>(cnf.generateInvalid1());
		
		if(coverOnlyOnes || !coverZerosOnly){
			CALib.removeAllZeros1(invalid1w);
		}
		
		System.out.println("|I_1| = " + invalid1w.size());
		
		// Generate U_1
		List<Pair> u1 = new ArrayList<Pair>(cnf.getU1());
		
		if(coverOnlyOnes || !coverZerosOnly){
			CALib.removeAllZeros1(u1);
		}
		
		int u1size = u1.size();
	
		// T_1 = U_1 \ I_1
		u1.removeAll(invalid1w);
		
		System.out.println("|U_1| = " + u1.size());
		System.out.println("|T_1| = " + 2*MathUtils.binomialCoefficient(nrVars, 1));
		System.out.println("|T_1| = |I_1| + |U_1| = " + (u1.size()+invalid1w.size()));
		
		// Remove covered
		List<Pair> covered = new ArrayList<Pair>();
		for(Pair p : u1){
			if(CALib.isCovered1(idnr, p, solutions)){
				covered.add(p);
			}
		}
		u1.removeAll(covered);
		int coveredTuples = covered.size(); 
		System.out.println("|C_1| = " + covered.size());
		
		// Cover
		while(true){
			// Return if limits met
			float cov = coveredTuples*100/u1size;
			if(cov>=coverLimit){
				result = solutions;
				break;
			}
			if(solutions.size()>=sizelimit){
				result = solutions;
				break;
			}
			
			// Cover
			int totalunc = u1.size();
			List<List<Pair>> uncSplit = new ArrayList<List<Pair>>();
			int beg=0, range=totalunc/threads + 1;
			for(int i = 0; i < threads; i++){
				if(beg+range > totalunc) range = totalunc - beg;
				uncSplit.add(new ArrayList<Pair>(u1.subList(beg, beg+range)));
				beg += range;
			}
		
			List<C1SplitThread> fmts = new ArrayList<C1SplitThread>();
			List<Thread> ts = new ArrayList<Thread>();
			for(int i = 0; i < threads; i++){
				C1SplitThread fmt = new C1SplitThread(cnf, uncSplit.get(i));
				fmts.add(fmt);
				Thread t = new Thread(fmt);
				ts.add(t);
			}
			
			for(int i = 0; i < threads; i++){
				ts.get(i).start();
			}
			
			// Start monitoring thread
			List<ProgressReporter> prs = new ArrayList<ProgressReporter>(fmts);
			ProgressThread pt = new ProgressThread("Cover", prs, totalunc);
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
			List<List<Integer>> newSolutions = new ArrayList<List<Integer>>();
			for(int i = 0; i < threads; i++){
				newSolutions.add(fmts.get(i).getSolution());
			}
			
			// Round complete
			System.out.println("Round complete");
			Set<Pair> newCov = getCovInv1(newSolutions, u1);
			System.out.println("Covered " + newCov.size());
			u1.removeAll(newCov);
			coveredTuples += newCov.size();
			
			// Done
			solutions.addAll(newSolutions);
		}
		
		// Done
		result = solutions;
		
		System.out.println("1-wise done, solutions: "+solutions.size()+", invalid: " + invalid1w.size());
	}

	private void generate2(int coverLimit, Integer sizelimit) throws TimeoutException, org.sat4j.specs.TimeoutException{
        // Get a list of vars
		List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(cnf.getVariables());
		// Solutions
		List<List<Integer>> solutions = new ArrayList<List<Integer>>(initial);
		int coveredInitially = 0;
		
		// 2-wise
		System.out.println("--- 2-wise ---");
		
		// I_2
		Set<Pair2> invalid2w = new HashSet<Pair2>(cnf.generateInvalid2());
		if(!coverZerosOnly){
			CALib.removeAllZeros2(invalid2w);
		}
		if(coverOnlyOnes){
			CALib.removeAllWithZeroes(invalid2w);
		}
		System.out.println("|I_2| = " + invalid2w.size());
		
		// U_2
		List<Pair2> u2 = new ArrayList<Pair2>(cnf.getU2());
		if(!coverZerosOnly){
			CALib.removeAllZeros2(u2);
		}
		if(coverOnlyOnes){
			CALib.removeAllWithZeroes(u2);
		}

		System.out.println("|U_2| = " + u2.size());
		System.out.println("|T_2| = " + 4*MathUtils.binomialCoefficient(vars.size(), 2));
		System.out.println("|T_2| = |U_2| + |I_2| = " + (u2.size()+invalid2w.size()));
		
		// Remove covered
		List<Pair2> covered = new ArrayList<Pair2>();
		for(Pair2 p : u2){
			if(CALib.isCovered(idnr, p, solutions)){
				covered.add(p);
			}
		}
		u2.removeAll(covered);
		int coveredTuples = covered.size(); 
		System.out.println("|C_2| = " + covered.size());
	
		// Cover
		long grandTotal = u2.size() + coveredTuples;
		while(!u2.isEmpty()){
			// Report progress
			System.out.println("Uncovered: " + u2.size() + ", progress: " + (grandTotal-u2.size())*100/grandTotal + "% with solutions: " + solutions.size());
			
			// Stop at limit
			coverage  = (grandTotal-u2.size())*100/grandTotal;
			if(coverLimit <= coverage) break;
			
			// Stop at limit
			if(solutions.size() >= sizelimit) break;
			
			// Start threads
			int uncTotal = coveredInitially + u2.size();
			List<C2SplitThreadI> fmts = new ArrayList<C2SplitThreadI>();
			List<Thread> ts = new ArrayList<Thread>();
			int totalunc = u2.size();
			List<List<Pair2>> uncSplit = new ArrayList<List<Pair2>>();
			int beg=0, range=totalunc/threads + 1;
			for(int i = 0; i < threads; i++){
				if(beg+range > totalunc) range = totalunc - beg;
				uncSplit.add(new ArrayList<Pair2>(u2.subList(beg, beg+range)));
				beg += range;
			}
			
			for(int i = 0; i < threads; i++){
				C2SplitThreadI fmt = new C2SplitThreadI(cnf, uncSplit.get(i), idnr);
				fmts.add(fmt);
				Thread t = new Thread(fmt);
				ts.add(t);
			}
			
			for(int i = 0; i < threads; i++){
				ts.get(i).start();
			}
			
			// Start monitoring thread
			List<ProgressReporter> prs = new ArrayList<ProgressReporter>(fmts);
			ProgressThread pt = new ProgressThread("Cover pairs", prs, uncTotal);
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
			Set<Pair2> uncovSet = new HashSet<Pair2>();
			for(int i = 0; i < threads; i++){
				uncovSet.addAll(fmts.get(i).getUncovered());
			}
			List<List<Integer>> sols = new ArrayList<List<Integer>>();
			for(int i = 0; i < threads; i++){
				sols.addAll(fmts.get(i).getSolutions());
			}
			Set<Pair2> cov = getCovInv(sols, new ArrayList<Pair2>(uncovSet));
			System.out.println("Additionally covered " + cov.size());
			int newcovered = uncovSet.size();
			uncovSet.removeAll(cov);
			newcovered = newcovered - uncovSet.size();
			
			// Store
			solutions.addAll(sols);
			u2.clear();
			u2.addAll(uncovSet);
		}

		// Done
		result = solutions;
		
		System.out.println("2-wise done, solutions: "+solutions.size()+", invalid: " + invalid2w.size());
	}

	private void generate3(int coverLimit, Integer sizelimit) throws TimeoutException, org.sat4j.specs.TimeoutException{
	    // Get a list of vars
		List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(cnf.getVariables());
		// Solutions
		List<List<Integer>> solutions = new ArrayList<List<Integer>>(initial);
		int coveredInitially = 0;
		
		// 3-wise
		System.out.println("--- 3-wise ---");
		
		// I_3
		Set<Pair3> invalid3w = new HashSet<Pair3>(cnf.generateInvalid3());
		if(!coverZerosOnly){
			CALib.removeAllZeros3(invalid3w);
		}
		if(coverOnlyOnes){
			CALib.removeAllWithZeroes3(invalid3w);
		}
		System.out.println("|I_3| = " + invalid3w.size());
		
		// U_3
		List<Pair3> u3 = new ArrayList<Pair3>(cnf.getU3());
		
		if(!coverZerosOnly){
			CALib.removeAllZeros3(u3);
		}
		if(coverOnlyOnes){
			CALib.removeAllWithZeroes3(u3);
		}
	
		System.out.println("|U_3| = " + u3.size());
		System.out.println("|T_3| = " + 8*MathUtils.binomialCoefficient(vars.size(), 3));
		System.out.println("|T_3| = |U_3| + |I_3| = " + (u3.size()+invalid3w.size()));
		
		// Remove covered
		List<Pair3> covered = new ArrayList<Pair3>();
		for(Pair3 p : u3){
			if(CALib.isCovered3(idnr, p, solutions)){
				covered.add(p);
			}
		}
		u3.removeAll(covered);
		int coveredTuples = covered.size(); 
		System.out.println("|C_3| = " + covered.size());
	
		// Cover
		long grandTotal = u3.size()+coveredTuples;
		int oldcovered = u3.size();
		while(!u3.isEmpty()){
			// Report progress
			System.out.println("Uncovered: " + u3.size() + ", progress: " + (grandTotal-u3.size())*100/grandTotal + "% with solutions: " + solutions.size());
			
			// Stop at limit
			if(coverLimit <= (grandTotal-u3.size())*100/grandTotal) break;
			
			// Stop at limit
			if(solutions.size() >= sizelimit) break;
			
			List<List<Integer>> sols = new ArrayList<List<Integer>>();
			int uncTotal = coveredInitially + u3.size();
			
			// Start threads
			{
				List<C3SplitThread> fmts = new ArrayList<C3SplitThread>();
				List<Thread> ts = new ArrayList<Thread>();
				int totalunc = u3.size();
				List<List<Pair3>> uncSplit = new ArrayList<List<Pair3>>();
				int beg=0, range=totalunc/threads + 1;
				for(int i = 0; i < threads; i++){
					if(beg+range > totalunc) range = totalunc - beg;
					uncSplit.add(new ArrayList<Pair3>(u3.subList(beg, beg+range)));
					beg += range;
				}
				u3.clear();
				
				for(int i = 0; i < threads; i++){
					C3SplitThread fmt = new C3SplitThread(cnf, uncSplit.get(i), idnr);
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
					u3.addAll(fmts.get(i).getUncovered());
				}
				for(int i = 0; i < threads; i++){
					sols.addAll(fmts.get(i).getSolutions());
				}
			}
			
			// Remove covered
			int newcovered;
			Set<Pair3> cov;
			{
				cov = getCovInv3(sols, u3);
				System.out.println("Additionally covered " + cov.size());
				newcovered = u3.size();
				Set<Pair3> uncovSet = new HashSet<Pair3>(u3);
				u3.clear();
				uncovSet.removeAll(cov);
				u3.addAll(uncovSet);
				uncovSet.clear();
			}
			
			newcovered = newcovered - u3.size();
			
			// Store
			solutions.addAll(sols);
			
			// Done if no more covered
			if(oldcovered == u3.size()){
				System.out.println("Unable to cover valid tuples: " + u3.size());
				System.exit(-1);
			}
			oldcovered = u3.size();
		}
	
		result = solutions;
	}
}

