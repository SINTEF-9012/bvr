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
import java.util.Map;
import java.util.Set;

import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IVecInt;

class RIThread implements Runnable, ProgressReporter{
	private CNF cnf;
	private Set<Pair2> uncovered;
	private Set<Pair2> valid;
	private int progress;
	private Map<String, Integer> idnr;
	SAT4JSolver satSolver;
	private Set<Pair2> invalid2w;

	public RIThread(CNF cnf, List<Pair2> uncovered, Map<Integer, String> nrid, Map<String, Integer> idnr, Set<Pair2> invalid2w){
		this.cnf = cnf;
		this.uncovered = new HashSet<Pair2>(uncovered);
		valid = new HashSet<Pair2>();
		progress = 0;
		this.idnr = idnr;
		this.invalid2w = invalid2w;
		
		// Create SAT-solver
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException ce) {
		}
	}
	
	private void removeInvalid() {
		//System.out.println("####START" + this);
		while(!uncovered.isEmpty()){
			// Get an element
			Pair2 e = null;
			for(Pair2 _e : uncovered){
				e = _e;
				break;
			}
			
			// Test
			int [] clause = new int [2];
			
			clause[0] = cnf.getNr(e.v1.getID());
			if(!e.b1) clause[0] = -clause[0];
			
			clause[1] = cnf.getNr(e.v2.getID());
			if(!e.b2) clause[1] = -clause[1];

			IVecInt assumps = new VecInt(clause);
			try {
				if(!satSolver.solver.isSatisfiable(assumps)){
					uncovered.remove(e);
					synchronized(invalid2w){
						invalid2w.add(e);
					}
					progress++;
					continue;
				}
			} catch (org.sat4j.specs.TimeoutException e1) {
				//System.out.println("#############This??");
			}
			
			valid.add(e);
			uncovered.remove(e);
			progress++;
			
			// Remove valid from uncovered
			int[] s = satSolver.solver.model();
			List<Integer> solution = new ArrayList<Integer>();
			for(int z : s)
				solution.add(z);

			for(Pair2 p : uncovered){
				if(isCovered(p, solution)){
					if(!valid.contains(p)){
						valid.add(p);
						progress++;
					}
				}
			}

			uncovered.removeAll(valid);
		}
		//System.out.println("####DONE" + this);
	}
	
	private boolean isCovered(Pair2 unc, List<Integer> solution) {
		String id1 = unc.v1.getID();
		Integer nr1 = idnr.get(id1);
		if(!unc.b1) nr1 = -nr1;
		
		String id2 = unc.v2.getID();
		Integer nr2 = idnr.get(id2);
		if(!unc.b2) nr2 = -nr2;
		
		if(solution.contains(nr1) && solution.contains(nr2)){
			return true;
		}
		
		return false;
	}
	
	public static Set<Pair2> intersect(Set<Pair2> set1, Set<Pair2> set2)
	{
	    Set<Pair2> intersection = new HashSet<Pair2>(set1);
	    intersection.retainAll(new HashSet<Pair2>(set2));
	    return intersection;
	}
	
	public List<Pair2> getValid(){
		return new ArrayList<Pair2>(valid);
	}

	@Override
	public void run() {
		removeInvalid();
	}
	
	public long getProgress(){
		return progress;
	}
}