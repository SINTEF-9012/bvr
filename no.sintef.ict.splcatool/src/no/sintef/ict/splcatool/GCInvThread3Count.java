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

public class GCInvThread3Count implements Runnable, ProgressReporter{
	
	private List<List<Integer>> solutions;
	private Map<String, Integer> idnr;
	private List<Pair3> uncovered;
	private int progress;
	private long covered;

	public GCInvThread3Count(List<List<Integer>> solutions, List<Pair3> uncovered, Map<Integer, String> nrid, Map<String, Integer> idnr){
		this.solutions = solutions;
		this.uncovered = uncovered;
		this.idnr = idnr;
		this.covered = 0;
	}

	@Override
	public void run() {
		findCovered();
	}
	
	private void findCovered() {
		for(Pair3 u : uncovered){
			for(List<Integer> solution : solutions)
				if(isCovered3(u, solution)){
					covered++;
					break;
				}
			progress++;
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
	
	public long getCovered(){
		return covered;
	}
	
	public long getProgress(){
		return progress;
	}
}
