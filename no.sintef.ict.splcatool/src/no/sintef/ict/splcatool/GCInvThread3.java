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

public class GCInvThread3 implements Runnable, ProgressReporter{
	private List<List<Integer>> solutions;
	private Map<String, Integer> idnr;
	private Set<Pair3> covered = new HashSet<Pair3>();
	private List<Pair3> uncovered;
	private int progress;

	public GCInvThread3(List<List<Integer>> solutions, List<Pair3> uncovered, Map<Integer, String> nrid, Map<String, Integer> idnr){
		this.solutions = solutions;
		this.uncovered = uncovered;
		this.idnr = idnr;
	}

	@Override
	public void run() {
		findCovered();
	}
	
	private void findCovered() {
		for(Pair3 u : uncovered){
			for(List<Integer> solution : solutions)
				if(CALib.isCovered3S(idnr, u, solution)){
					covered.add(u);
					break;
				}
			progress++;
		}
	}
	
	public Set<Pair3> getCovered(){
		return covered;
	}
	
	public long getProgress(){
		return progress;
	}
}
