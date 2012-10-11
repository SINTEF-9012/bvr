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

import java.util.List;
import java.util.Map;

public class GCInvThreadCount implements Runnable, ProgressReporter{
	
	private List<List<Integer>> solutions;
	private Map<String, Integer> idnr;
	private long covered = 0;
	private List<Pair2> uncovered;
	private int progress;

	public GCInvThreadCount(List<List<Integer>> solutions, List<Pair2> uncovered, Map<String, Integer> idnr){
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
				if(isCovered(u, solution)){
					covered++;
					break;
				}
			progress++;
		}
	}
	
	private boolean isCovered(Pair2 unc, List<Integer> s) {
		String id1 = unc.v1.getID();
		Integer nr1 = idnr.get(id1);
		if(!unc.b1) nr1 = -nr1;
		
		String id2 = unc.v2.getID();
		Integer nr2 = idnr.get(id2);
		if(!unc.b2) nr2 = -nr2;
		
		if(s.contains(nr1) && s.contains(nr2)){
			return true;
		}
		
		return false;
	}
	
	public long getCovered(){
		return covered;
	}
	
	public long getProgress(){
		return progress;
	}
}
