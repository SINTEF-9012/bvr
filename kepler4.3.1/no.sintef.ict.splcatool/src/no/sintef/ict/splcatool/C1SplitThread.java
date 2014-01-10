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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IVecInt;

import splar.core.constraints.BooleanVariableInterface;

class C1SplitThread implements Runnable, ProgressReporter{
	private CNF cnf;
	private List<Integer> solution;
	private List<Pair> uncovered;
	private int progress;

	public C1SplitThread(CNF cnf, List<Pair> uncovered){
		this.cnf = cnf;
		this.uncovered = uncovered;
		progress = 0;
	}
	
	public List<Integer> getSolution(){
		return solution;
	}
	
	public long getProgress(){
		return progress;
	}
	
	private void cover() {
		if(!uncovered.isEmpty()){
			List<Pair> covered = new ArrayList<Pair>();
			solution = setAndSolveMax(uncovered, covered);
		}
	}
	
	private List<Integer> setAndSolveMax(List<Pair> uncovered, List<Pair> covered) {
		List<Pair> canBeSet = new ArrayList<Pair>();
		List<Pair> x = new ArrayList<Pair>(uncovered);
		
		// Get solver
		SAT4JSolver satSolver = null;
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException e) {
			System.out.println("contradiction");
		}
		
		// assumptions
		Set<Integer> sol = new HashSet<Integer>();
		
		for(int i=0; i<x.size(); i++){
			if(canBeSet.contains(x.get(i))) continue;
			
			boolean isTrue = x.get(i).b;
			BooleanVariableInterface v = x.get(i).v;
			
			// Set it
			int varnr = 0;
			boolean canItBeSet = true;
			varnr = (isTrue?1:-1) * cnf.getNr(v.getID());
			
			// Check
			try {
				// Convert
				int assumpsArray[] = new int[sol.size()+1];
				int c = 0;
				for(int a : sol){
					assumpsArray[c] = a;
					c++;
				}
				assumpsArray[assumpsArray.length-1] = varnr;
				IVecInt assumps = new VecInt(assumpsArray);
				
				// Check
				if(!satSolver.solver.isSatisfiable(assumps)){
					canItBeSet = false;
				}else{
					sol.add(varnr);
					progress++;
				}
			} catch (org.sat4j.specs.TimeoutException e1) {
			}
			
			if(canItBeSet){
				canBeSet.add(x.get(i));
			}
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
		
		// Return
		covered.addAll(canBeSet);
		return solution;
	}

	@Override
	public void run() {
		cover();
	}
}