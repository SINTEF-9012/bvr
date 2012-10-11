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

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import splar.core.constraints.BooleanVariableInterface;

public class GCThread implements Runnable, ProgressReporter{
	
	private List<Integer> solution;
	private List<BooleanVariableInterface> vars;
	private Map<Integer, String> nrid;
	private Map<String, Integer> idnr;
	private Set<Pair2> covered = new HashSet<Pair2>();

	public GCThread(List<Integer> solution, List<BooleanVariableInterface> vars, Map<Integer, String> nrid, Map<String, Integer> idnr){
		this.solution = solution;
		this.vars = vars;
		this.nrid = nrid;
		this.idnr = idnr;
	}

	@Override
	public void run() {
		findCovered();
	}
	
	private void findCovered() {
		for(int i = 0; i < solution.size(); i++)
			for(int j = i+1; j < solution.size(); j++){
				Pair2 p = new Pair2(idnr);
				int p0 = solution.get(i);
				int p1 = solution.get(j);
				for(BooleanVariableInterface var : vars){
					if(var.getID().equals(nrid.get(Math.abs(p0)))){
						p.v1 = var;
						p.b1 = p0>0;
					}
				}
				for(BooleanVariableInterface var : vars){
					if(var.getID().equals(nrid.get(Math.abs(p1)))){
						p.v2 = var;
						p.b2 = p1>0;
					}
				}
				covered.add(p);
			}
	}
	
	public Set<Pair2> getCovered(){
		return covered;
	}
	
	public long getProgress(){
		return covered.size();
	}
}
