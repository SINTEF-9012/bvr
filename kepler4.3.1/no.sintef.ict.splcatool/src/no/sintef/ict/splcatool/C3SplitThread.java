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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IVecInt;

import splar.core.constraints.BooleanVariableInterface;

class C3SplitThread implements Runnable, ProgressReporter{
	private CNF cnf;
	private List<List<Integer>> solutions;
	private List<Pair3> uncovered;
	private List<Pair3> discarded;
	private int progress;
	private Map<String, Integer> idnr;

	public C3SplitThread(CNF cnf, List<Pair3> uncovered, Map<String, Integer> idnr){
		this.cnf = cnf;
		solutions = new ArrayList<List<Integer>>();
		discarded = new ArrayList<Pair3>();
		this.uncovered = uncovered;
		progress = 0;
		this.idnr = idnr;
	}
	
	public List<List<Integer>> getSolutions(){
		return solutions;
	}
	
	public long getProgress(){
		return progress;
	}
	
	private void cover() {
		if(!uncovered.isEmpty()){
			List<Integer> solution = setAndSolveMax();
			solutions.add(solution);
		}
	}
	
	private List<Integer> setAndSolveMax() {
		List<Pair3> canBeSet = new ArrayList<Pair3>();
		Set<BooleanVariableInterface> coveredFeatures = new HashSet<BooleanVariableInterface>();
		Set<BooleanVariableInterface> presentFeatures = new HashSet<BooleanVariableInterface>();
		Set<Pair> unsettableFeatures = new HashSet<Pair>();
		Set<Pair> setFeatures = new HashSet<Pair>();
		
		for(Pair3 p : uncovered){
			presentFeatures.add(p.v1);
			presentFeatures.add(p.v2);
			presentFeatures.add(p.v3);
		}
		
		// Get solver
		SAT4JSolver satSolver = null;
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException e) {
		}
		
		// assumptions
		Set<Integer> sol = new HashSet<Integer>();
		
		//System.out.println("Uncovered: " +uncovered.size());
		for(int i=0; i<uncovered.size(); i++){
			progress = i;
			
			// Check
			if(canBeSet.size()==uncovered.size()){
				progress = uncovered.size();
				break;
			}
			if(canBeSet.contains(uncovered.get(i))) continue;
			
			// Set up some vars
			boolean b1 = uncovered.get(i).b1;
			boolean b2 = uncovered.get(i).b2;
			boolean b3 = uncovered.get(i).b3;
			BooleanVariableInterface v1 = uncovered.get(i).v1;
			BooleanVariableInterface v2 = uncovered.get(i).v2;
			BooleanVariableInterface v3 = uncovered.get(i).v3;
			Pair p1 = new Pair();
			p1.v = v1;
			p1.b = b1;
			Pair p2 = new Pair();
			p2.v = v2;
			p2.b = b2;
			Pair p3 = new Pair();
			p3.v = v3;
			p3.b = b3;
			
			// Check if covered
			if(coveredFeatures.contains(v1) && !setFeatures.contains(p1)) continue;
			if(coveredFeatures.contains(v2) && !setFeatures.contains(p2)) continue;
			if(coveredFeatures.contains(v3) && !setFeatures.contains(p3)) continue;
			if(coveredFeatures.contains(v1) && coveredFeatures.contains(v2) && coveredFeatures.contains(v3)) continue;
			if(unsettableFeatures.contains(p1) || unsettableFeatures.contains(p2) || unsettableFeatures.contains(p3)) continue;
			
			// Set it
			int var1nr, var2nr, var3nr;
			boolean canItBeSet = true;
			var1nr = (b1?1:-1) * idnr.get(v1.getID());
			var2nr = (b2?1:-1) * idnr.get(v2.getID());
			var3nr = (b3?1:-1) * idnr.get(v3.getID());
			
			// Check
			try {
				// Convert
				Set<Integer> trySol = new HashSet<Integer>(sol);
				trySol.add(var1nr);
				trySol.add(var2nr);
				trySol.add(var3nr);
				int assumpsArray[] = new int[trySol.size()];
				int c = 0;
				for(int a : trySol){
					assumpsArray[c] = a;
					c++;
				}

				IVecInt assumps = new VecInt(assumpsArray);
				
				//System.out.println("Trying " + assumps);
				
				// Check
				if(!satSolver.solver.isSatisfiable(assumps)){
					canItBeSet = false;
					
					// Add unsettable features and value pair
					if(!setFeatures.contains(p1) && setFeatures.contains(p2) && setFeatures.contains(p3)){
						unsettableFeatures.add(p1);
						coveredFeatures.add(p1.v);
					}
					if(setFeatures.contains(p1) && !setFeatures.contains(p2) && setFeatures.contains(p3)){
						unsettableFeatures.add(p2);
						coveredFeatures.add(p2.v);
					}
					if(setFeatures.contains(p1) && setFeatures.contains(p2) && !setFeatures.contains(p3)){
						unsettableFeatures.add(p3);
						coveredFeatures.add(p3.v);
					}
					// TODO: more possible here I think ^^
				}else{
					// Add last pair to the list
					sol.add(var1nr);
					sol.add(var2nr);
					sol.add(var3nr);
					//System.out.println("Covered");
				}
			} catch (org.sat4j.specs.TimeoutException e1) {
			}
			
			if(canItBeSet){
				canBeSet.add(uncovered.get(i));;
				
				// Track covered features
				Pair3 nc = uncovered.get(i);
				coveredFeatures.add(nc.v1);
				coveredFeatures.add(nc.v2);
				coveredFeatures.add(nc.v3);
				
				setFeatures.add(p1);
				setFeatures.add(p2);
				setFeatures.add(p3);
				
				if(coveredFeatures.size()==presentFeatures.size()){
					progress = uncovered.size();
					break;
				}
			}
		}
		
		// Get solver
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException e) {
		}
		
		// Convert
		int asssumpsArray[] = new int[sol.size()];
		int c = 0;
		for(int a : sol){
			asssumpsArray[c] = a;
			c++;
		}
		IVecInt assumps = new VecInt(asssumpsArray);
		
		// Solve
		try {
			satSolver.solver.isSatisfiable(assumps);
		} catch (org.sat4j.specs.TimeoutException e1) {
		}
		int[] s = satSolver.solver.model();
		List<Integer> solution = new ArrayList<Integer>();
		for(int x : s)
			solution.add(x);
		
		// Return
		return solution;
	}

	@Override
	public void run() {
		cover();
	}

	public Collection<? extends Pair3> getUncovered() {
		List<Pair3> ret = new ArrayList<Pair3>();
		ret.addAll(uncovered);
		ret.addAll(discarded);
		return ret;
	}
}