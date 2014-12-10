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

public class GCInvThread implements Runnable, ProgressReporter{
	
	private List<List<Integer>> solutions;
	private Map<String, Integer> idnr;
	private Set<Pair2> covered = new HashSet<Pair2>();
	private List<Pair2> uncovered;
	private int progress;

	public GCInvThread(List<List<Integer>> solutions, List<Pair2> uncovered, Map<Integer, String> nrid, Map<String, Integer> idnr){
		this.solutions = solutions;
		this.uncovered = uncovered;
		this.idnr = idnr;
	}

	@Override
	public void run() {
		findCovered();
	}
	
	private void findCovered() {
		for(Pair2 u : uncovered){
			for(List<Integer> solution : solutions)
				if(CALib.isCoveredS(idnr, u, solution)){
					covered.add(u);
					break;
				}
			progress++;
		}
	}
	
	public Set<Pair2> getCovered(){
		return covered;
	}
	
	public long getProgress(){
		return progress;
	}
}
