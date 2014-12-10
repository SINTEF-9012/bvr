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

class RIThread3 implements Runnable, ProgressReporter{
	private CNF cnf;
	private Set<Pair3> uncovered;
	private Set<Pair3> valid;
	private Set<Pair3> invalid;
	private int progress;
	private Map<String, Integer> idnr;
	SAT4JSolver satSolver;

	public RIThread3(CNF cnf, List<Pair3> uncovered, Map<Integer, String> nrid, Map<String, Integer> idnr){
		this.cnf = cnf;
		this.uncovered = new HashSet<Pair3>(uncovered);
		valid = new HashSet<Pair3>();
		progress = 0;
		this.idnr = idnr;
		invalid = new HashSet<Pair3>();
		
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException ce) {
		}
	}
	
	private void removeInvalid() {
		while(!uncovered.isEmpty()){			
			Pair3 e = null;
			for(Pair3 _e : uncovered){
				e = _e;
				break;
			}
			
			int [] clause = new int [3];
			
			clause[0] = cnf.getNr(e.v1.getID());
			if(!e.b1) clause[0] = -clause[0];
			
			clause[1] = cnf.getNr(e.v2.getID());
			if(!e.b2) clause[1] = -clause[1];
			
			clause[2] = cnf.getNr(e.v3.getID());
			if(!e.b3) clause[2] = -clause[2];

			IVecInt assumps = new VecInt(clause);
			try {
				if(!satSolver.solver.isSatisfiable(assumps)){
					invalid.add(e);
					uncovered.remove(e);
					progress++;
					continue;
				}
			} catch (org.sat4j.specs.TimeoutException e1) {
			}
			
			valid.add(e);
			uncovered.remove(e);
			progress++;
			
			// Remove valid from uncovered
			int[] s = satSolver.solver.model();
			List<Integer> solution = new ArrayList<Integer>();
			for(int z : s)
				solution.add(z);

			for(Pair3 p : uncovered){
				if(isCovered3(p, solution)){
					if(!valid.contains(p)){
						valid.add(p);
						progress++;
					}
				}
			}

			uncovered.removeAll(valid);
		}
	}
	
	private boolean isCovered3(Pair3 unc, List<Integer> s) {
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
	
	public static Set<Pair3> intersect(Set<Pair3> set1, Set<Pair3> set2)
	{
	    Set<Pair3> intersection = new HashSet<Pair3>(set1);
	    intersection.retainAll(new HashSet<Pair3>(set2));
	    return intersection;
	}
	
	public List<Pair3> getValid(){
		return new ArrayList<Pair3>(valid);
	}
	
	public List<Pair3> getInvalid(){
		return new ArrayList<Pair3>(invalid);
	}

	@Override
	public void run() {
		removeInvalid();
	}
	
	public long getProgress(){
		return progress;
	}
}