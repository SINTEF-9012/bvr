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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.apache.commons.math.util.MathUtils;
import org.sat4j.specs.ContradictionException;

import splar.core.constraints.BooleanVariableInterface;

public class CoveringArrayAlgJ11Utils extends CoveringArray {

	private CNF cnf;
	private int threads;
	private long coverage = 0;
	
	private List<List<Integer>> result;
	private List<Integer> nrs = null;

	private List<Pair2> nonaffect = new ArrayList<Pair2>();
	private List<Pair3> nonaffect3 = new ArrayList<Pair3>();
	// Invalid tuples sets
	Set<Pair> invalid1w;
	Set<Pair2> invalid2w;
	Set<Pair3> invalid3w;
	Set<Pair4> invalid4w;
	File fmdir;

	public CoveringArrayAlgJ11Utils(int t, CNF cnf, Map<Integer, String> nrid, Map<String, Integer> idnr, int threads) {
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

	@Override
	public void generate() throws TimeoutException {
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
		return "J11 (Pair-split parallelization, SAT-exploitation, Logical Pair-reduction -- PSL)";
	}

	private void generate1(int coverLimit, Integer sizelimit) throws TimeoutException, org.sat4j.specs.TimeoutException {
			System.out.println("--- 1-wise ---");
			
			List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(cnf.getVariables());
			List<List<Integer>> solutions = new ArrayList<List<Integer>>(initial);
			
			int nrVars = vars.size();
	        
	        // Find mandatory and dead features
	        Set<BooleanVariableInterface> mandatory = new HashSet<BooleanVariableInterface>();
			Set<BooleanVariableInterface> dead = new HashSet<BooleanVariableInterface>();
			MandatoryAndDeadDetection mdd = new MandatoryAndDeadDetection(cnf, nrid); 
			mdd.findMandatoryAndDeadFeatures(vars, mandatory, dead);
			vars.removeAll(mandatory);
			vars.removeAll(dead);
			
			// Fill invalid1w
			invalid1w = new HashSet<Pair>();
			if(coverZerosOnly && !coverOnlyOnes){
				for(BooleanVariableInterface v : mandatory){
					Pair p = new Pair();
					p.v = v;
					p.b = false;
					invalid1w.add(p);
				}
			}
			
			for(BooleanVariableInterface v : dead){
				Pair p = new Pair();
				p.v = v;
				p.b = true;
				invalid1w.add(p);
			}
			
			// Cover the uncovered
			// Check uncovered
			List<Pair> uncovered = new ArrayList<Pair>();
			long alreadyCovered = 0;
			for(BooleanVariableInterface v : vars){
				Pair p;
				if(coverZerosOnly && !coverOnlyOnes){
					p = new Pair();
					p.b = false;
					p.v = v;
					if(!CALib.isCovered1(idnr, p, solutions))
						uncovered.add(p);
					else
						alreadyCovered++;
				}
				p = new Pair();
				p.b = true;
				p.v = v;
				if(!CALib.isCovered1(idnr, p, solutions))
					uncovered.add(p);
				else
					alreadyCovered++;
			}
			//int totaluncTotal = uncovered.size();
	/*		System.out.print("Uncovered: [");
			for(Pair p : uncovered)
				System.out.print("" + cnf.idnr.get(p.v.getID()) + ":" +p.b + ", ");
			System.out.println("]");
	*/
			
			System.out.println("Total uncovered: " + uncovered.size());
			
			// Check
			if(coverZerosOnly && !coverOnlyOnes){
				if(uncovered.size()+alreadyCovered+invalid1w.size()+mandatory.size()+dead.size() != 2*MathUtils.binomialCoefficient(nrVars, 1)){
					System.out.println("Internal error: Wrong number of tuples");
					System.out.println(uncovered.size()+alreadyCovered+invalid1w.size()+mandatory.size()+dead.size());
					System.out.println(2*MathUtils.binomialCoefficient(nrVars, 1));
					System.exit(-1);
				}
			}else{
				if(uncovered.size()+alreadyCovered+invalid1w.size()+mandatory.size() != MathUtils.binomialCoefficient(nrVars, 1)){
					System.out.println("Internal error: Wrong number of tuples");
					System.out.println(uncovered.size()+alreadyCovered+invalid1w.size()+mandatory.size());
					System.out.println(MathUtils.binomialCoefficient(nrVars, 1));
					System.exit(-1);
				}
			}
			
			// Find two solutions and remove covered
			{
				SAT4JSolver satSolver = null;
				try {
					satSolver = cnf.getSAT4JSolver();
					satSolver.solver.isSatisfiable();
				} catch (ContradictionException e1) {
				} catch (org.sat4j.specs.TimeoutException e) {
				}
				int[] s1 = satSolver.solver.model();
				List<Integer> solution1 = new ArrayList<Integer>();
				for(int z : s1)
					solution1.add(z);
				try {
					satSolver = cnf.getSAT4JSolverInverse();
					satSolver.solver.isSatisfiable();
				} catch (ContradictionException e1) {
				} catch (org.sat4j.specs.TimeoutException e) {
				}
				int[] s2 = satSolver.solver.model();
				List<Integer> solution2 = new ArrayList<Integer>();
				for(int z : s2)
					solution2.add(-z); // Must be inverted since sat is inverted
				
				solutions.add(solution1);
				solutions.add(solution2);
				
				List<Pair> covered = new ArrayList<Pair>();
				covered.addAll(getCovered(solution1, vars));
				covered.addAll(getCovered(solution2, vars));
				uncovered.removeAll(covered);
			}
			
			System.out.println("Total uncovered after first removal: " + uncovered.size());
			
			// Cover
			int totalunc = uncovered.size();
			List<List<Pair>> uncSplit = new ArrayList<List<Pair>>();
			int beg=0, range=totalunc/threads + 1;
			for(int i = 0; i < threads; i++){
				if(beg+range > totalunc) range = totalunc - beg;
				//total += vars.subList(beg, beg+range).size();
				//System.out.println(beg + " -> " + (beg+range));
				uncSplit.add(new ArrayList<Pair>(uncovered.subList(beg, beg+range)));
				beg += range;
			}
	
			List<C1Thread> fmts = new ArrayList<C1Thread>();
			List<Thread> ts = new ArrayList<Thread>();
			for(int i = 0; i < threads; i++){
				C1Thread fmt = new C1Thread(cnf, uncSplit.get(i), sizelimit);
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
			for(int i = 0; i < threads; i++){
				solutions.addAll(fmts.get(i).getSolutions());
			}
			
			// For the special cases where the sizelimit is less than 3 (due to how the algorithm for 1w starts with adding 3)
			if(sizelimit == 2){
				if(solutions.size() == 3){
					solutions.remove(2);
				}
			}
			if(sizelimit == 1){
				if(solutions.size() == 3){
					solutions.remove(2);
				}
				if(solutions.size() == 2){
					solutions.remove(1);
				}
			}
			
			// Done
			result = solutions;
			
			System.out.println("1-wise done, solutions: "+solutions.size()+", invalid: " + invalid1w.size());
		}

	private void generate2(int coverLimit, Integer sizelimit) throws TimeoutException, org.sat4j.specs.TimeoutException{
		
        // Get a list of vars
		List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(cnf.getVariables());
		
/*		// Find mandatory and dead features
		Set<BooleanVariableInterface> mandatory = new HashSet<BooleanVariableInterface>();
		Set<BooleanVariableInterface> dead = new HashSet<BooleanVariableInterface>();
		MandatoryAndDeadDetection mdd = new MandatoryAndDeadDetection(cnf, nrid); 
		mdd.findMandatoryAndDeadFeatures(vars, mandatory, dead);
		System.out.println("Mandatory: " + mandatory.size());
		System.out.println("Dead: " + dead.size());
*/
		// Get the invalid 1-tuples
		//generate1(100, sizelimit);
		
		// 2-wise
		System.out.println("--- 2-wise ---");
		
		// Set of invalid 2-tuples
		invalid2w = new HashSet<Pair2>();
		
		// Solutions
		List<List<Integer>> solutions = new ArrayList<List<Integer>>(initial);
		int coveredInitially = 0;

		// Calculate uncovered tuples
		List<Pair2> uncovered = new ArrayList<Pair2>();
		List<BooleanVariableInterface> vars2 = new ArrayList<BooleanVariableInterface>(vars);
		long invalid = 0;
		for(BooleanVariableInterface var1 : vars){
			vars2.remove(var1);
			for(BooleanVariableInterface var2 : vars2){
				// Check if there is no affection between the features
				boolean nonaff = false;
				for(Pair2 p : nonaffect){
					if(p.v1 == var1 && p.v2 == var2) nonaff = true;
					else if(p.v1 == var2 && p.v2 == var1) nonaff = true;
				}
				if(nonaff){
					continue;
				}
				
				// Set pair
				Pair2 unc;
				if(!coverOnlyOnes){
					if(coverZerosOnly){
						if(!(invalid1w.contains(new Pair(var1, false)) || invalid1w.contains(new Pair(var2, false)))){
							unc = new Pair2(idnr);
							unc.v1 = var1;
							unc.b1 = false;
							unc.v2 = var2;
							unc.b2 = false;
							if(!CALib.isCovered(idnr, unc, solutions))
								uncovered.add(unc);
							else invalid++;
						}else{
							Pair2 inv = new Pair2(idnr);
							inv.v1 = var1;
							inv.b1 = false;
							inv.v2 = var2;
							inv.b2 = false;
							invalid2w.add(inv);
							invalid++;
						}
					}
					if(!(invalid1w.contains(new Pair(var1, false)) || invalid1w.contains(new Pair(var2, true)))){
						unc = new Pair2(idnr);
						unc.v1 = var1;
						unc.b1 = false;
						unc.v2 = var2;
						unc.b2 = true;
						if(!CALib.isCovered(idnr, unc, solutions))
							uncovered.add(unc);
						else invalid++;
					}else{
						Pair2 inv = new Pair2(idnr);
						inv.v1 = var1;
						inv.b1 = false;
						inv.v2 = var2;
						inv.b2 = true;
						invalid2w.add(inv);
						invalid++;
					}
					if(!(invalid1w.contains(new Pair(var1, true)) || invalid1w.contains(new Pair(var2, false)))){
						unc = new Pair2(idnr);
						unc.v1 = var1;
						unc.b1 = true;
						unc.v2 = var2;
						unc.b2 = false;
						if(!CALib.isCovered(idnr, unc, solutions))
							uncovered.add(unc);
						else invalid++;
					}else{
						Pair2 inv = new Pair2(idnr);
						inv.v1 = var1;
						inv.b1 = true;
						inv.v2 = var2;
						inv.b2 = false;
						invalid2w.add(inv);
						invalid++;
					}
				}
				if(!(invalid1w.contains(new Pair(var1, true)) || invalid1w.contains(new Pair(var2, true)))){
					unc = new Pair2(idnr);
					unc.v1 = var1;
					unc.b1 = true;
					unc.v2 = var2;
					unc.b2 = true;
					if(!CALib.isCovered(idnr, unc, solutions))
						uncovered.add(unc);
					else invalid++;
				}else{
					Pair2 inv = new Pair2(idnr);
					inv.v1 = var1;
					inv.b1 = true;
					inv.v2 = var2;
					inv.b2 = true;
					invalid2w.add(inv);
					invalid++;
				}
			}
		}
			
		System.out.println("Uncovered pairs left: " + uncovered.size() + ", invalid: " + invalid2w.size());
		
		// Check
/*		System.out.println(uncovered.size());
		System.out.println(invalid);
		System.out.println(ignored);
		System.out.println(4*MathUtils.binomialCoefficient(vars.size(), 2));
*//*		if(uncovered.size() + invalid + ignored != 4*MathUtils.binomialCoefficient(vars.size(), 2)){
			System.out.println("Internal error: Wrong number of tuples");
			System.exit(-1);
		}
*/		
		// Cover
		long grandTotal = uncovered.size() + invalid;
		boolean invalidRemoved = false;
		while(!uncovered.isEmpty()){
			// Start threads
			int uncTotal = coveredInitially + uncovered.size();
			List<C2SplitThread> fmts = new ArrayList<C2SplitThread>();
			List<Thread> ts = new ArrayList<Thread>();
			int totalunc = uncovered.size();
			List<List<Pair2>> uncSplit = new ArrayList<List<Pair2>>();
			int beg=0, range=totalunc/threads + 1;
			for(int i = 0; i < threads; i++){
				if(beg+range > totalunc) range = totalunc - beg;
				uncSplit.add(new ArrayList<Pair2>(uncovered.subList(beg, beg+range)));
				beg += range;
			}
			
			for(int i = 0; i < threads; i++){
				C2SplitThread fmt = new C2SplitThread(cnf, uncSplit.get(i), idnr);
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
			
			// Remove invalid at some round
			if(!invalidRemoved){
				if((int)Math.log10(cov.size()) <= (int)Math.log10(cnf.getVariables().size()) || coverLimit <= coverage){
					System.out.println("Removing invalid");
					int diff = uncovSet.size();
					uncovSet = new HashSet<Pair2>(getInvalid(coveredInitially, new ArrayList<Pair2>(uncovSet)));
					diff -= uncovSet.size();
					uncTotal -= diff;
					System.out.println("Invalid: " + diff);
					invalidRemoved = true;
				}
			}
			
			// Store
			solutions.addAll(sols);
			uncovered.clear();
			uncovered.addAll(uncovSet);
			
			// Report progress
			System.out.println("Uncovered: " + uncovered.size() + ", progress: " + (grandTotal-uncovered.size())*100/grandTotal + "% with solutions: " + solutions.size());
			
			// Stop at limit
			coverage  = (grandTotal-uncovered.size())*100/grandTotal;
			if(invalidRemoved && coverLimit <= coverage) break;
			
			// Stop at limit
			if(solutions.size() >= sizelimit) break;
		}

		// Done
		result = solutions;
		
		System.out.println("2-wise done, solutions: "+solutions.size()+", invalid: " + invalid2w.size());
	}

	private void generate3(int coverLimit, Integer sizelimit) throws TimeoutException, org.sat4j.specs.TimeoutException{
	        // Get a list of vars
			List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(cnf.getVariables());
			
	/*		// Find mandatory and dead features
	        Set<BooleanVariableInterface> mandatory = new HashSet<BooleanVariableInterface>();
			Set<BooleanVariableInterface> dead = new HashSet<BooleanVariableInterface>();
			MandatoryAndDeadDetection mdd = new MandatoryAndDeadDetection(cnf, nrid); 
			mdd.findMandatoryAndDeadFeatures(vars, mandatory, dead);
			System.out.println("Mandatory: " + mandatory.size());
			System.out.println("Dead: " + dead.size());
	*/
			// Get invalid 2-tuples
			//generate2(100, sizelimit);
			
			// 3-wise
			System.out.println("--- 3-wise ---");
			
			// Set of invalid 3-tuples
			invalid3w = new HashSet<Pair3>();
			
			// Solutions
			List<List<Integer>> solutions = new ArrayList<List<Integer>>(initial);
			int coveredInitially = 0;
		
			/* Calculate uncovered tuples */
			List<Pair3> uncovered = new ArrayList<Pair3>();
			CalcUncovered3Thread cut = new CalcUncovered3Thread(uncovered, nonaffect3, vars, coverOnlyOnes, coverZerosOnly, invalid2w, idnr, solutions, invalid3w);
			Thread cutt = new Thread(cut);
			cutt.start();
			
			// Monitor progress
			List<ProgressReporter> xprs = new ArrayList<ProgressReporter>();
			xprs.add(cut);
			ProgressThread xpt = new ProgressThread("Calculate uncovered triples", xprs, 8*MathUtils.binomialCoefficient(vars.size(), 3));
			Thread xptt = new Thread(xpt);
			xptt.start();
			
			// Wait
			try {
				cutt.join();
			} catch (InterruptedException e1) {
			}
			long invalid = cut.getInvalidCount();
			long ignored = cut.getIgnoredCount();
			
			xpt.stop();
	
			// Done
			System.out.println("Uncovered triples left: " + uncovered.size() + " invalid: " + invalid + " ignored: " + ignored);
			
			// Check
	/*		if(uncovered.size() + invalid + ignored != 8*MathUtils.binomialCoefficient(vars.size(), 3)){
				System.out.println("Internal error: Wrong number of tuples");
				System.exit(-1);
			}
	*/
			// Cover
			long grandTotal = uncovered.size() + invalid;
			boolean invalidRemoved = false;
			int oldcovered = uncovered.size();
			while(!uncovered.isEmpty()){
				List<List<Integer>> sols = new ArrayList<List<Integer>>();
				int uncTotal = coveredInitially + uncovered.size();
				
				// Start threads
				{
					List<C3SplitThread> fmts = new ArrayList<C3SplitThread>();
					List<Thread> ts = new ArrayList<Thread>();
					int totalunc = uncovered.size();
					List<List<Pair3>> uncSplit = new ArrayList<List<Pair3>>();
					int beg=0, range=totalunc/threads + 1;
					for(int i = 0; i < threads; i++){
						if(beg+range > totalunc) range = totalunc - beg;
						uncSplit.add(new ArrayList<Pair3>(uncovered.subList(beg, beg+range)));
						beg += range;
					}
					uncovered.clear();
					
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
						uncovered.addAll(fmts.get(i).getUncovered());
					}
					for(int i = 0; i < threads; i++){
						sols.addAll(fmts.get(i).getSolutions());
					}
				}
				
				// Remove covered
				int newcovered;
				Set<Pair3> cov;
				{
					cov = getCovInv3(sols, uncovered);
					System.out.println("Additionally covered " + cov.size());
					newcovered = uncovered.size();
					Set<Pair3> uncovSet = new HashSet<Pair3>(uncovered);
					uncovered.clear();
					uncovSet.removeAll(cov);
					uncovered.addAll(uncovSet);
					uncovSet.clear();
				}
				
				newcovered = newcovered - uncovered.size();
				
				// Remove invalid at some round
				if(!invalidRemoved){
					if((int)Math.log10(cov.size()) <= (int)Math.log10(cnf.getVariables().size())){
						System.out.println("Removing invalid");
						int diff = uncovered.size();
						uncovered = getInvalid3(coveredInitially, uncovered);
						diff -= uncovered.size();
						uncTotal -= diff;
						System.out.println("Invalid: " + diff);
						invalidRemoved = true;
					}
				}
				
				// Store
				solutions.addAll(sols);
				
				// Report progress
				System.out.println("Uncovered: " + uncovered.size() + ", progress: " + (grandTotal-uncovered.size())*100/grandTotal + "% with solutions: " + solutions.size());
				
				// Stop at limit
				if(coverLimit <= (grandTotal-uncovered.size())*100/grandTotal) break;
				
				// Stop at limit
				if(solutions.size() >= sizelimit) break;
				
				// Done if no more covered
				if(oldcovered == uncovered.size()){
					System.out.println("Unable to cover valid tuples: " + uncovered.size());
					System.exit(-1);
				}
				oldcovered = uncovered.size();
			}
	
			result = solutions;
			System.out.println("Invalid: " + invalid3w.size());
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
			RIThread rit = new RIThread(cnf, uncSplit.get(i), nrid, idnr, invalid2w);
			rits.add(rit);
			Thread t = new Thread(rit);
			ts.add(t);
		}
		
		for(int i = 0; i < threads; i++){
			ts.get(i).start();
		}
		
		// Start monitoring thread
		List<ProgressReporter> prs = new ArrayList<ProgressReporter>(rits);
		ProgressThread pt = new ProgressThread("Find invalid pairs", prs, uncTotal);
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

	private List<Pair3> getInvalid3(int coveredInitially, List<Pair3> uncovered) {
		int uncTotal = uncovered.size() + coveredInitially;
		
		// This should run
		Runtime runtime = Runtime.getRuntime();        
	    int threads = runtime.availableProcessors();
	    System.out.println("Threads for this task: " + threads);
		
		// Remove invalid
		List<List<Pair3>> uncSplit = new ArrayList<List<Pair3>>();
		int beg=0, range=uncovered.size()/threads + 1;
		for(int i = 0; i < threads; i++){
			if(beg+range > uncovered.size()) range = uncovered.size() - beg;
			uncSplit.add(uncovered.subList(beg, beg+range));
			//System.out.println(beg + " ->" + (beg+range));
			beg += range;
		}
	
		List<RIThread3> rits = new ArrayList<RIThread3>();
		List<Thread> ts = new ArrayList<Thread>();
		for(int i = 0; i < threads; i++){
			RIThread3 rit = new RIThread3(cnf, uncSplit.get(i), nrid, idnr);
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
		uncovered = new ArrayList<Pair3>();
		for(int i = 0; i < threads; i++){
			uncovered.addAll(rits.get(i).getValid());
		}
		
		for(int i = 0; i < threads; i++){
			invalid3w.addAll(rits.get(i).getInvalid());
		}
		
		// Return
		return uncovered;
	}

	private List<Pair> getCovered(List<Integer> solution, List<BooleanVariableInterface> vars) {
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
}

