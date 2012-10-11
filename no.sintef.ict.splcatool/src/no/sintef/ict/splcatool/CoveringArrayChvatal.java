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
import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IVecInt;

import splar.core.constraints.BooleanVariableInterface;

public class CoveringArrayChvatal extends CoveringArray {

	private CNF cnf;
	private long coverage = 0;
	
	public long getCoverage(){
		return(coverage);
	}

	public CoveringArrayChvatal(int t, CNF cnf, Map<Integer, String> nrid, Map<String, Integer> idnr, int threads) {
		this.t = t;
		this.cnf = cnf;
		this.nrid = nrid;
		this.idnr = idnr;
	}
	
	@Override
	public void generate(int coverLimit, Integer sizelimit) throws TimeoutException {
		if(t==1){
			try {
				generate1(coverLimit, sizelimit);
			} catch (org.sat4j.specs.TimeoutException e) {
				throw new TimeoutException();
			}
		}else if(t==2){ generate2(coverLimit, sizelimit);
		}else if(t==3){ generate3(coverLimit, sizelimit);
		}else if(t==4){ generate4(coverLimit, sizelimit);
		}else throw new UnsupportedOperationException();
	}

	@Override
	public void generate() throws TimeoutException {
		generate(100, Integer.MAX_VALUE);
	}
	
	public static Set<Pair2> intersect(Set<Pair2> set1, Set<Pair2> set2)
	{
	    Set<Pair2> intersection = new HashSet<Pair2>(set1);
	    intersection.retainAll(new HashSet<Pair2>(set2));
	    return intersection;
	}

	
	private void generate2(int coverLimit, Integer sizelimit){
        // Get a list of vars
		List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(cnf.getVariables());
		List<List<Integer>> solutions = new ArrayList<List<Integer>>(initial);

		// Calculate uncovered tuples
		List<Pair2> uncovered = new ArrayList<Pair2>();
		List<BooleanVariableInterface> vars2 = new ArrayList<BooleanVariableInterface>(vars);
		long ignored = 0;
		long alreadyCovered = 0;
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
					ignored+=4;
					continue;
				}
				
				// Set pairs
				Pair2 unc;
				if(!coverOnlyOnes){
					if(coverZerosOnly){
						unc = new Pair2(idnr);
						unc.v1 = var1;
						unc.b1 = false;
						unc.v2 = var2;
						unc.b2 = false;
						if(!CALib.isCovered(idnr, unc, solutions)){
							uncovered.add(unc);
						}else{
							alreadyCovered++;
						}
					}
					unc = new Pair2(idnr);
					unc.v1 = var1;
					unc.b1 = false;
					unc.v2 = var2;
					unc.b2 = true;
					if(!CALib.isCovered(idnr, unc, solutions)){
						uncovered.add(unc);
					}else{
						alreadyCovered++;
					}
					unc = new Pair2(idnr);
					unc.v1 = var1;
					unc.b1 = true;
					unc.v2 = var2;
					unc.b2 = false;
					if(!CALib.isCovered(idnr, unc, solutions)){
						uncovered.add(unc);
					}else{
						alreadyCovered++;
					}
				}
				unc = new Pair2(idnr);
				unc.v1 = var1;
				unc.b1 = true;
				unc.v2 = var2;
				unc.b2 = true;
				if(!CALib.isCovered(idnr, unc, solutions)){
					uncovered.add(unc);
				}else{
					alreadyCovered++;
				}
			}
		}
			
		System.out.println("Uncovered pairs left: " + uncovered.size());
		
		// If starting from a covering array or doing a cover limit, start by finding invalids
		boolean invalidRemoved = false;
		long invalids = 0;
		if(coverLimit!=100 || initial.size()>0){
			System.out.println("Removing invalid first when given a cover limit or a size limit or an initial covering array");
			int diff = uncovered.size();
			uncovered = getInvalid(0, uncovered);
			diff -= uncovered.size();
			System.out.println("Invalid: " + diff);
			invalids = diff;
			invalidRemoved = true;
		}
		
		// Check
		if(coverOnlyOnes){
			if(uncovered.size()+alreadyCovered+invalids != MathUtils.binomialCoefficient(vars.size(), 2)){
				System.out.println("Internal error: Wrong number of tuples");
				System.exit(-1);
			}
		}else if(!coverZerosOnly){
			if(uncovered.size()+alreadyCovered+invalids != 3*MathUtils.binomialCoefficient(vars.size(), 2)){
				System.out.println("Internal error: Wrong number of tuples");
				System.exit(-1);
			}
		}else{
			if(uncovered.size()+alreadyCovered+invalids != 4*MathUtils.binomialCoefficient(vars.size(), 2)){
				System.out.println("Internal error: Wrong number of tuples");
				System.exit(-1);
			}
		}
		
		// Get solver
		SAT4JSolver satSolver = null;
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException e) {
		}
		
		// Cover
		long grandTotal = uncovered.size() + alreadyCovered;
		while(true){
			// Calculate coverage
			coverage  = (grandTotal-uncovered.size())*100/grandTotal;
			
			// Stop at limit
			if(invalidRemoved && coverLimit <= coverage) break;
			
			// Check for limit
			if(solutions.size() >= sizelimit) break;
			
			// Mix
			Set<Pair2> mix = new HashSet<Pair2>(uncovered);
			
			List<Pair2> canBeSet = new ArrayList<Pair2>();
			List<Pair2> x = new ArrayList<Pair2>(uncovered);
			
			// assumptions
			Set<Integer> sol = new HashSet<Integer>();
			
			//System.out.println("Uncovered: " +uncovered.size());
			for(int i=0; i<x.size(); i++){
				if(i%1000 == 0) System.out.println(i + "/" + x.size());
				
				// Get the two pairs
				boolean b1 = x.get(i).b1;
				boolean b2 = x.get(i).b2;
				BooleanVariableInterface v1 = x.get(i).v1;
				BooleanVariableInterface v2 = x.get(i).v2;
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
						canBeSet.add(x.get(i));
						mix.remove(x.get(i));
					}
				} catch (org.sat4j.specs.TimeoutException e1) {
				}
			}
			
			uncovered = new ArrayList<Pair2>(mix);
			
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
			
			// Remove invalid at some round
			if(!invalidRemoved){
				if((int)Math.log10(canBeSet.size()) <= (int)Math.log10(cnf.getVariables().size())){
					System.out.println("Removing invalid");
					int diff = uncovered.size();
					uncovered = getInvalid(0, uncovered);
					diff -= uncovered.size();
					System.out.println("Invalid: " + diff);
					invalidRemoved = true;
				}
			}
			
			// Calculate coverage
			coverage  = (grandTotal-uncovered.size())*100/grandTotal;
			
			// Check if done
			if(canBeSet.size() == 0){
				System.out.println("Breaking at " + uncovered.size() + " invalids");
				break;
			}else{
				System.out.println("Covered at " + (uncovered.size()+canBeSet.size()) + ", " + canBeSet.size() + ", progress: " + coverage + "%");
				//System.out.println(canBeSet);
			}
			
			// Return
			solutions.add(solution);
		}

		// Done
		result = solutions;
	}

	private List<List<Integer>> result;
	private List<Integer> nrs = null;
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public double estimateGenerationTime() {
		int F = cnf.getVariables().size();
		
		if(t == 2) return Math.exp(0.37*Math.log(F) + 1.30);
		if(t == 3) return Math.exp(1.09*Math.log(F) + 0.00);
		
		throw new UnsupportedOperationException();
	}
	
	private List<Pair2> nonaffect = new ArrayList<Pair2>();
	private List<Pair3> nonaffect3 = new ArrayList<Pair3>();
	private List<Pair4> nonaffect4 = new ArrayList<Pair4>();

	@Override
	public String getAlgorithmName() {
		return "Chvatal's algorithm adopted for Covering Array generation";
	}

	private void generate1(int coverLimit, Integer sizelimit) throws TimeoutException, org.sat4j.specs.TimeoutException {
		List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(cnf.getVariables());
		List<List<Integer>> solutions = new ArrayList<List<Integer>>(initial);
		
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
		
		// If starting from a covering array or doing a cover limit, start by finding invalids
		List<Pair> invalid = new ArrayList<Pair>();
		if(coverLimit!=100 || initial.size()>0){
			getInvalid1(uncovered, invalid);
			
			// Remove from uncovered
			uncovered.removeAll(invalid);
		}
		
		// Check
		if(coverZerosOnly && !coverOnlyOnes){
			if(uncovered.size()+alreadyCovered+invalid.size() != 2*MathUtils.binomialCoefficient(vars.size(), 1)){
				System.out.println("Internal error: Wrong number of tuples");
				System.out.println(uncovered.size()+alreadyCovered+invalid.size());
				System.out.println(2*MathUtils.binomialCoefficient(vars.size(), 1));
				return;
			}
		}else{
			if(uncovered.size()+alreadyCovered+invalid.size() != MathUtils.binomialCoefficient(vars.size(), 1)){
				System.out.println("Internal error: Wrong number of tuples");
				System.out.println(uncovered.size()+alreadyCovered+invalid.size());
				System.out.println(MathUtils.binomialCoefficient(vars.size(), 1));
				return;
			}
		}
		
		// Start
		Set<Pair> mix = new HashSet<Pair>(uncovered);
		uncovered = new ArrayList<Pair>(mix);
		
		long grandTotal = uncovered.size() + invalid.size() + alreadyCovered;
		while(true){
			// Calculate coverage
			coverage  = (grandTotal-uncovered.size())*100/grandTotal;
			// Stop at limit
			if(coverLimit <= coverage) break;
			// Check for limit
			if(solutions.size() >= sizelimit) break;
			
			// Mix
			mix = new HashSet<Pair>(uncovered);
			uncovered = new ArrayList<Pair>(mix);
			
			// Cover as many as possible
			List<Pair> canBeSet = new ArrayList<Pair>();
			List<Pair> x = new ArrayList<Pair>(uncovered);
			Set<Integer> sol = new HashSet<Integer>();
			
			for(int i=0; i<x.size(); i++){
				SAT4JSolver satSolver = null;
				try {
					satSolver = cnf.getSAT4JSolver();
				} catch (ContradictionException e) {
				}
				
				Pair p = x.get(i);
				
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
						uncovered.remove(p);
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
				System.out.println("Breaking at " + uncovered.size() + " invalids");
				break;
			}else{
				System.out.println("Covered at " + (uncovered.size()+canBeSet.size()) + ", " + canBeSet.size());
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
	
	private void generate3(int coverLimit, Integer sizelimit){
        // Get a list of vars
		List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(cnf.getVariables());
		List<List<Integer>> solutions = new ArrayList<List<Integer>>(initial);

		// Calculate uncovered tuples
		List<Pair3> uncovered = new ArrayList<Pair3>();
		List<BooleanVariableInterface> vars2 = new ArrayList<BooleanVariableInterface>(vars);
		List<BooleanVariableInterface> vars3 = new ArrayList<BooleanVariableInterface>(vars);
		long ignored = 0;
		long alreadyCovered = 0;
		for(int i = 0; i < vars.size(); i++){
			BooleanVariableInterface var1 = vars.get(i);
			for(int j = i+1; j < vars2.size(); j++){
				BooleanVariableInterface var2 = vars2.get(j);
				for(int k = j+1; k < vars3.size(); k++){
					BooleanVariableInterface var3 = vars3.get(k);
					// Check if there is no affection between the features
					boolean nonaff = false;
					for(Pair3 p : nonaffect3){
						     if(p.v1 == var1 && p.v2 == var2 && p.v3 == var3) nonaff = true;
						else if(p.v1 == var3 && p.v2 == var1 && p.v3 == var2) nonaff = true;
						else if(p.v1 == var2 && p.v2 == var3 && p.v3 == var1) nonaff = true;
						else if(p.v1 == var3 && p.v2 == var2 && p.v3 == var1) nonaff = true;
						else if(p.v1 == var2 && p.v2 == var1 && p.v3 == var3) nonaff = true;
						else if(p.v1 == var1 && p.v2 == var3 && p.v3 == var2) nonaff = true;
					}
					if(nonaff){
						ignored+=8;
						continue;
					}
					
					// Set triples
					Pair3 unc;
					if(!coverOnlyOnes){
						if(coverZerosOnly){
							unc = new Pair3(idnr);
							unc.v1 = var1;
							unc.b1 = false;
							unc.v2 = var2;
							unc.b2 = false;
							unc.v3 = var3;
							unc.b3 = false;
							if(!CALib.isCovered3(idnr, unc, solutions))
								uncovered.add(unc);
							else
								alreadyCovered++;
						}
						unc = new Pair3(idnr);
						unc.v1 = var1;
						unc.b1 = false;
						unc.v2 = var2;
						unc.b2 = false;
						unc.v3 = var3;
						unc.b3 = true;
						if(!CALib.isCovered3(idnr, unc, solutions))
							uncovered.add(unc);
						else
							alreadyCovered++;
						unc = new Pair3(idnr);
						unc.v1 = var1;
						unc.b1 = false;
						unc.v2 = var2;
						unc.b2 = true;
						unc.v3 = var3;
						unc.b3 = false;
						if(!CALib.isCovered3(idnr, unc, solutions))
							uncovered.add(unc);
						else
							alreadyCovered++;
						unc = new Pair3(idnr);
						unc.v1 = var1;
						unc.b1 = false;
						unc.v2 = var2;
						unc.b2 = true;
						unc.v3 = var3;
						unc.b3 = true;
						if(!CALib.isCovered3(idnr, unc, solutions))
							uncovered.add(unc);
						else
							alreadyCovered++;
						unc = new Pair3(idnr);
						unc.v1 = var1;
						unc.b1 = true;
						unc.v2 = var2;
						unc.b2 = false;
						unc.v3 = var3;
						unc.b3 = false;
						if(!CALib.isCovered3(idnr, unc, solutions))
							uncovered.add(unc);
						else
							alreadyCovered++;
						unc = new Pair3(idnr);
						unc.v1 = var1;
						unc.b1 = true;
						unc.v2 = var2;
						unc.b2 = false;
						unc.v3 = var3;
						unc.b3 = true;
						if(!CALib.isCovered3(idnr, unc, solutions))
							uncovered.add(unc);
						else
							alreadyCovered++;
						unc = new Pair3(idnr);
						unc.v1 = var1;
						unc.b1 = true;
						unc.v2 = var2;
						unc.b2 = true;
						unc.v3 = var3;
						unc.b3 = false;
						if(!CALib.isCovered3(idnr, unc, solutions))
							uncovered.add(unc);
						else
							alreadyCovered++;
					}
					unc = new Pair3(idnr);
					unc.v1 = var1;
					unc.b1 = true;
					unc.v2 = var2;
					unc.b2 = true;
					unc.v3 = var3;
					unc.b3 = true;
					if(!CALib.isCovered3(idnr, unc, solutions))
						uncovered.add(unc);
					else
						alreadyCovered++;
				}
			}
		}
			
		System.out.println("Uncovered triples left: " + uncovered.size());
		
		System.out.println("alreadyCovered: " + alreadyCovered);
		
		System.out.println("expected: " + 8*MathUtils.binomialCoefficient(vars.size(), 3));
		
		// Check
		if(coverOnlyOnes){
			if(uncovered.size()+alreadyCovered != MathUtils.binomialCoefficient(vars.size(), 3)){
				System.out.println("Internal error: Wrong number of tuples");
				System.exit(-1);
			}
		}else if(!coverZerosOnly){
			if(uncovered.size()+alreadyCovered != 7*MathUtils.binomialCoefficient(vars.size(), 3)){
				System.out.println("Internal error: Wrong number of tuples");
				System.exit(-1);
			}
		}else{
			if(uncovered.size()+alreadyCovered != 8*MathUtils.binomialCoefficient(vars.size(), 3)){
				System.out.println("Internal error: Wrong number of tuples");
				System.exit(-1);
			}
		}
		
		// If starting from a covering array or doing a cover limit, start by finding invalids
		boolean invalidRemoved = false;
		if(coverLimit!=100 || initial.size()>0){
			System.out.println("Removing invalid first when given a cover limit or a size limit or an initial covering array");
			int diff = uncovered.size();
			uncovered = getInvalid3(0, uncovered);
			diff -= uncovered.size();
			System.out.println("Invalid: " + diff);
			invalidRemoved = true;
		}
		
		// Get solver
		SAT4JSolver satSolver = null;
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException e) {
		}
		
		// Cover
		long grandTotal = uncovered.size() + alreadyCovered;
		while(true){
			// Calculate coverage
			coverage  = (grandTotal-uncovered.size())*100/grandTotal;
			// Stop at limit
			if(invalidRemoved && coverLimit <= coverage) break;
			// Check for limit
			if(solutions.size() >= sizelimit) break;
			
			// Mix
			Set<Pair3> mix = new HashSet<Pair3>(uncovered);
			
			List<Pair3> canBeSet = new ArrayList<Pair3>();
			List<Pair3> x = new ArrayList<Pair3>(uncovered);
			
			// assumptions
			Set<Integer> sol = new HashSet<Integer>();
			
			//System.out.println("Uncovered: " +uncovered.size());
			for(int i=0; i<x.size(); i++){
				if(i%1000 == 0) System.out.println(i + "/" + x.size());
				
				// Get the two pairs
				boolean b1 = x.get(i).b1;
				boolean b2 = x.get(i).b2;
				boolean b3 = x.get(i).b3;
				BooleanVariableInterface v1 = x.get(i).v1;
				BooleanVariableInterface v2 = x.get(i).v2;
				BooleanVariableInterface v3 = x.get(i).v3;
				Pair p1 = new Pair();
				p1.v = v1;
				p1.b = b1;
				Pair p2 = new Pair();
				p2.v = v2;
				p2.b = b2;
				Pair p3 = new Pair();
				p3.v = v3;
				p3.b = b3;
				
				// Set it
				int var1nr, var2nr, var3nr;
				var1nr = (b1?1:-1) * idnr.get(v1.getID());
				var2nr = (b2?1:-1) * idnr.get(v2.getID());
				var3nr = (b3?1:-1) * idnr.get(v3.getID());
				
				// Check
				try {
					// List
					List<Integer> assumpsList = new ArrayList<Integer>();
					for(int a : sol){
						assumpsList.add(a);
					}
					if(assumpsList.contains(-var1nr)) continue;
					if(assumpsList.contains(-var2nr)) continue;
					if(assumpsList.contains(-var3nr)) continue;
					
					assumpsList.add(var1nr);
					assumpsList.add(var2nr);
					assumpsList.add(var3nr);
					
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
						sol.add(var3nr);
						canBeSet.add(x.get(i));
						mix.remove(x.get(i));
					}
				} catch (org.sat4j.specs.TimeoutException e1) {
				}
			}
			
			uncovered = new ArrayList<Pair3>(mix);
			
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
			
			// Remove invalid at some round
			if(!invalidRemoved){
				if((int)Math.log10(canBeSet.size()) <= (int)Math.log10(cnf.getVariables().size())){
					System.out.println("Removing invalid");
					int diff = uncovered.size();
					uncovered = getInvalid3(0, uncovered);
					diff -= uncovered.size();
					System.out.println("Invalid: " + diff);
					invalidRemoved = true;
				}
			}
			
			// Check if done
			if(canBeSet.size() == 0){
				System.out.println("Breaking at " + uncovered.size() + " invalids");
				break;
			}else{
				System.out.println("Covered at " + (uncovered.size()+canBeSet.size()) + ", " + canBeSet.size());
				//System.out.println(canBeSet);
			}
			
			// Return
			solutions.add(solution);
		}

		// Done
		result = solutions;
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
		
		// Return
		return uncovered;
	}
	
	private void generate4(int coverLimit, Integer sizelimit){
        // Get a list of vars
		List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(cnf.getVariables());
		List<List<Integer>> solutions = new ArrayList<List<Integer>>(initial);

		// Calculate uncovered tuples
		List<Pair4> uncovered = new ArrayList<Pair4>();
		List<BooleanVariableInterface> vars2 = new ArrayList<BooleanVariableInterface>(vars);
		List<BooleanVariableInterface> vars3 = new ArrayList<BooleanVariableInterface>(vars);
		List<BooleanVariableInterface> vars4 = new ArrayList<BooleanVariableInterface>(vars);
		long ignored = 0;
		long alreadyCovered = 0;
		for(int i = 0; i < vars.size(); i++){
			BooleanVariableInterface var1 = vars.get(i);
			for(int j = i+1; j < vars2.size(); j++){
				BooleanVariableInterface var2 = vars2.get(j);
				for(int k = j+1; k < vars3.size(); k++){
					BooleanVariableInterface var3 = vars3.get(k);
					for(int l = k+1; l < vars4.size(); l++){
						BooleanVariableInterface var4 = vars4.get(l);
						// Check if there is no affection between the features
						boolean nonaff = false;
						for(Pair4 p : nonaffect4){
							Set<BooleanVariableInterface> s1 = new HashSet<BooleanVariableInterface>();
							s1.add(p.v1);s1.add(p.v2);s1.add(p.v3);s1.add(p.v4);
							Set<BooleanVariableInterface> s2 = new HashSet<BooleanVariableInterface>();
							s2.add(var1);s2.add(var2);s2.add(var3);s2.add(var4);
							if(s1.equals(s2)) nonaff = true;
						}
						if(nonaff){
							ignored+=8;
							continue;
						}
						
						// Set pair
						boolean tf[] = new boolean [] {false, true};
						for(boolean a : tf) for(boolean b : tf) for(boolean c : tf) for(boolean d : tf){
							Pair4 unc = new Pair4(idnr);
							unc.v1 = var1;
							unc.b1 = a;
							unc.v2 = var2;
							unc.b2 = b;
							unc.v3 = var3;
							unc.b3 = c;
							unc.v4 = var4;
							unc.b4 = d;
							if(coverOnlyOnes && (a!=true || b!=true || c!=true || d!=true)) continue;
							if(!coverZerosOnly && (a==false && b==false && c==false && d==false)) continue;
							if(!CALib.isCovered4(idnr, unc, solutions))
								uncovered.add(unc);
							else
								alreadyCovered++;
						}
					}
				}
			}
		}
			
		System.out.println("Uncovered tuples left: " + uncovered.size());
		
		// Check
		if(coverOnlyOnes){
			if(uncovered.size()+alreadyCovered != MathUtils.binomialCoefficient(vars.size(), 4)){
				System.out.println("Internal error: Wrong number of tuples");
				System.exit(-1);
			}
		}else if(!coverZerosOnly){
			if(uncovered.size()+alreadyCovered != 15*MathUtils.binomialCoefficient(vars.size(), 4)){
				System.out.println("Internal error: Wrong number of tuples");
				System.exit(-1);
			}
		}else{
			if(uncovered.size()+alreadyCovered != 16*MathUtils.binomialCoefficient(vars.size(), 4)){
				System.out.println("Internal error: Wrong number of tuples");
				System.exit(-1);
			}
		}
		
		// If starting from a covering array or doing a cover limit, start by finding invalids
		boolean invalidRemoved = false;
		List<Pair4> invalid = new ArrayList<Pair4>();
		if(coverLimit!=100 || initial.size()>0){
			System.out.println("Removing invalid first when given a cover limit or a size limit or an initial covering array");
			getInvalid4(uncovered, invalid);
			System.out.println("Invalid: " + invalid.size());
			uncovered.removeAll(invalid);
			invalidRemoved = true;
		}
		
		// Get solver
		SAT4JSolver satSolver = null;
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException e) {
		}
		
		// Cover
		long grandTotal = uncovered.size() + alreadyCovered;
		while(true){
			// Calculate coverage
			coverage  = (grandTotal-uncovered.size())*100/grandTotal;
			// Stop at limit
			if(invalidRemoved && coverLimit <= coverage) break;
			// Check for limit
			if(solutions.size() >= sizelimit) break;
			
			// Mix
			Set<Pair4> mix = new HashSet<Pair4>(uncovered);
			
			List<Pair4> canBeSet = new ArrayList<Pair4>();
			List<Pair4> x = new ArrayList<Pair4>(uncovered);
			
			// assumptions
			Set<Integer> sol = new HashSet<Integer>();
			
			//System.out.println("Uncovered: " +uncovered.size());
			for(int i=0; i<x.size(); i++){
				if(i%1000 == 0) System.out.println(i + "/" + x.size());
				
				// Get the two pairs
				boolean b1 = x.get(i).b1;
				boolean b2 = x.get(i).b2;
				boolean b3 = x.get(i).b3;
				boolean b4 = x.get(i).b4;
				BooleanVariableInterface v1 = x.get(i).v1;
				BooleanVariableInterface v2 = x.get(i).v2;
				BooleanVariableInterface v3 = x.get(i).v3;
				BooleanVariableInterface v4 = x.get(i).v4;
				Pair p1 = new Pair();
				p1.v = v1;
				p1.b = b1;
				Pair p2 = new Pair();
				p2.v = v2;
				p2.b = b2;
				Pair p3 = new Pair();
				p3.v = v3;
				p3.b = b3;
				Pair p4 = new Pair();
				p4.v = v4;
				p4.b = b4;
				
				// Set it
				int var1nr, var2nr, var3nr, var4nr;
				var1nr = (b1?1:-1) * idnr.get(v1.getID());
				var2nr = (b2?1:-1) * idnr.get(v2.getID());
				var3nr = (b3?1:-1) * idnr.get(v3.getID());
				var4nr = (b4?1:-1) * idnr.get(v4.getID());
				
				// Check
				try {
					// List
					List<Integer> assumpsList = new ArrayList<Integer>();
					for(int a : sol){
						assumpsList.add(a);
					}
					if(assumpsList.contains(-var1nr)) continue;
					if(assumpsList.contains(-var2nr)) continue;
					if(assumpsList.contains(-var3nr)) continue;
					if(assumpsList.contains(-var4nr)) continue;
					
					if(!assumpsList.contains(var1nr)) assumpsList.add(var1nr);
					if(!assumpsList.contains(var2nr)) assumpsList.add(var2nr);
					if(!assumpsList.contains(var3nr)) assumpsList.add(var3nr);
					if(!assumpsList.contains(var4nr)) assumpsList.add(var4nr);
					
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
						sol.add(var2nr);
						sol.add(var3nr);
						sol.add(var4nr);
						canBeSet.add(x.get(i));
						mix.remove(x.get(i));
					}
				} catch (org.sat4j.specs.TimeoutException e1) {
				}
			}
			
			uncovered = new ArrayList<Pair4>(mix);
			
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
				System.out.println("Breaking at " + uncovered.size() + " invalids");
				break;
			}else{
				System.out.println("Covered at " + (uncovered.size()+canBeSet.size()) + ", " + canBeSet.size());
				//System.out.println(canBeSet);
			}
			
			// Return
			solutions.add(solution);
		}

		// Done
		result = solutions;
	}
	
	private void getInvalid4(List<Pair4> uncovered, List<Pair4> invalid) {
		// Get SAT-solver
		SAT4JSolver satSolver = null;
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException e) {
		}
		
		// Find invalid
		for(int i=0; i<uncovered.size(); i++){
			
			Pair4 p = uncovered.get(i);
			
			// Set it
			boolean b1 = p.b1;
			boolean b2 = p.b2;
			boolean b3 = p.b3;
			boolean b4 = p.b4;
			BooleanVariableInterface v1 = p.v1;
			BooleanVariableInterface v2 = p.v2;
			BooleanVariableInterface v3 = p.v3;
			BooleanVariableInterface v4 = p.v4;
			Pair p1 = new Pair();
			p1.v = v1;
			p1.b = b1;
			Pair p2 = new Pair();
			p2.v = v2;
			p2.b = b2;
			Pair p3 = new Pair();
			p3.v = v3;
			p3.b = b3;
			Pair p4 = new Pair();
			p4.v = v4;
			p4.b = b4;
			
			// Set it
			int var1nr, var2nr, var3nr, var4nr;
			var1nr = (b1?1:-1) * idnr.get(v1.getID());
			var2nr = (b2?1:-1) * idnr.get(v2.getID());
			var3nr = (b3?1:-1) * idnr.get(v3.getID());
			var4nr = (b4?1:-1) * idnr.get(v4.getID());
			
			// Check
			try {
				// List
				List<Integer> assumpsList = new ArrayList<Integer>();
				assumpsList.add(var1nr);
				assumpsList.add(var2nr);
				assumpsList.add(var3nr);
				assumpsList.add(var4nr);
				
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
}

