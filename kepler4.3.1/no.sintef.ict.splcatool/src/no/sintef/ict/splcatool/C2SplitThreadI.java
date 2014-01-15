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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IVecInt;

import splar.core.constraints.BooleanVariableInterface;

class C2SplitThreadI implements Runnable, ProgressReporter{
	private List<List<Integer>> solutions;
	private List<Pair2> uncovered;
	private List<Pair2> discarded;
	private Map<String, Integer> idnr;
	private SAT4JSolver satSolver;

	public C2SplitThreadI(CNF cnf, List<Pair2> uncovered, Map<String, Integer> idnr){
		solutions = new ArrayList<List<Integer>>();
		discarded = new ArrayList<Pair2>();
		this.uncovered = uncovered;
		this.idnr = idnr;
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException e) {
		}
	}
	
	public List<List<Integer>> getSolutions(){
		return solutions;
	}
	
	public long getProgress(){
		return i*uncovered.size()/1;
	}
	
	private int i;
	
	private void cover() {
		if(!uncovered.isEmpty()){
			for(i = 0; i < 1; i++){
				// solve
				Collections.shuffle(uncovered);
				List<Integer> solution = setAndSolveMax();
				solutions.add(solution);
			}
		}
	}
	
	private List<Integer> setAndSolveMax() {
		List<Pair2> canBeSet = new ArrayList<Pair2>();
		Set<BooleanVariableInterface> coveredFeatures = new HashSet<BooleanVariableInterface>();
		Set<BooleanVariableInterface> presentFeatures = new HashSet<BooleanVariableInterface>();
		Set<Pair> unsettableFeatures = new HashSet<Pair>();
		Set<Pair> setFeatures = new HashSet<Pair>();
		
		for(Pair2 p : uncovered){
			presentFeatures.add(p.v1);
			presentFeatures.add(p.v2);
		}
		
		// assumptions
		Set<Integer> sol = new HashSet<Integer>();
		
		for(int i=0; i<uncovered.size(); i++){
			if(canBeSet.size()==uncovered.size()){
				break;
			}
			if(canBeSet.contains(uncovered.get(i))) continue;
			boolean b1 = uncovered.get(i).b1;
			boolean b2 = uncovered.get(i).b2;
			BooleanVariableInterface v1 = uncovered.get(i).v1;
			BooleanVariableInterface v2 = uncovered.get(i).v2;
			Pair p1 = new Pair();
			p1.v = v1;
			p1.b = b1;
			Pair p2 = new Pair();
			p2.v = v2;
			p2.b = b2;
			
			// Check if covered
			if(coveredFeatures.contains(v1) && !setFeatures.contains(p1)) continue;
			if(coveredFeatures.contains(v2) && !setFeatures.contains(p2)) continue;
			if(coveredFeatures.contains(v1) && coveredFeatures.contains(v2)) continue;
			if(unsettableFeatures.contains(p1) || unsettableFeatures.contains(p2)) continue;
			
			// Set it
			int var1nr, var2nr;
			boolean canItBeSet = true;
			var1nr = (b1?1:-1) * idnr.get(v1.getID());
			var2nr = (b2?1:-1) * idnr.get(v2.getID());
			
			// Check
			try {
				// Convert
				int assumpsArray[] = new int[sol.size()+2];
				int c = 0;
				for(int a : sol){
					assumpsArray[c] = a;
					c++;
				}
				assumpsArray[assumpsArray.length-2] = var1nr;
				assumpsArray[assumpsArray.length-1] = var2nr;
				IVecInt assumps = new VecInt(assumpsArray);
				
				// Check
				if(!satSolver.solver.isSatisfiable(assumps)){
					canItBeSet = false;
					
					// Add unsettable features and value pair
					if(!setFeatures.contains(p1) && setFeatures.contains(p2)){
						unsettableFeatures.add(p1);
						coveredFeatures.add(p1.v);
					}
					if(setFeatures.contains(p1) && !setFeatures.contains(p2)){
						unsettableFeatures.add(p2);
						coveredFeatures.add(p2.v);
					}
				}else{
					// Add last pair to the list
					sol.add(var1nr);
					sol.add(var2nr);
				}
			} catch (org.sat4j.specs.TimeoutException e1) {
			}
			
			if(canItBeSet){
				canBeSet.add(uncovered.get(i));
				
				// Track covered features
				Pair2 nc = uncovered.get(i);
				coveredFeatures.add(nc.v1);
				coveredFeatures.add(nc.v2);
				
				setFeatures.add(p1);
				setFeatures.add(p2);
				
				if(coveredFeatures.size()==presentFeatures.size()){
					// The intermission will catch the rest
					break;
				}
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
		
		// Solve
		try {
			satSolver.solver.isSatisfiable(assumps);
		} catch (org.sat4j.specs.TimeoutException e1) {
		}
		int[] s = satSolver.solver.model();
		List<Integer> solution = new ArrayList<Integer>();
		for(int x : s)
			solution.add(x);
		
		// Improve
/*		if(isfirst){
			isfirst = false;
			return solution;
		}
			
		ArrayList<Integer> bestsol = new ArrayList<Integer>(solution);
		float orgcov = (float)getCovInvCount(solution, uncovered)*100/uncovered.size();
		//System.out.println("Original Coverage " + orgcov);
		
		float bestcoverage = orgcov; 
		for(int j = 0; j < solution.size(); j++){
			//for(int k = j+1; k < solution.size(); k++){
				// Change first
				int x = solution.get(j);
				solution.set(j, -x);
				
				// Change second
				//int y = solution.get(k);
				//solution.set(k, -y);
				
				boolean isValid = false;
				// Convert
				asssumpsArray = new int[solution.size()];
				c = 0;
				for(int a : solution){
					asssumpsArray[c] = a;
					c++;
				}
				assumps = new VecInt(asssumpsArray);
				try {
					isValid = satSolver.solver.isSatisfiable(assumps);
				} catch (org.sat4j.specs.TimeoutException e1) {
				}
				
				if(isValid){
					float newcov = (float)getCovInvCount(solution, uncovered)*100/uncovered.size();
					
					// Find the best
					if(newcov > bestcoverage){
						bestcoverage = newcov;
						bestsol = new ArrayList<Integer>(solution);
						//System.out.println("New best coverage: " + newcov);	
					}
				}
				
				// Change back first
				solution.set(j, x);
				
				// Change back second
				//solution.set(k, y);
			//}
		}
		*/
		
		// Return
		return solution;
	}

	@Override
	public void run() {
		cover();
	}

	public Collection<? extends Pair2> getUncovered() {
		List<Pair2> ret = new ArrayList<Pair2>();
		ret.addAll(uncovered);
		ret.addAll(discarded);
		return ret;
	}
	
	static boolean isfirst = true;
}