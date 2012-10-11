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
import java.util.Set;

public class Verifier {
	public boolean verify1w(CNF cnf, CoveringArray ca) {
		// Calculate the valid pairs
		List<Pair> uncovered = cnf.getU1();
		System.out.println("Valid singles: " + uncovered.size());
		
		// Calculate the covered pairs
		List<List<Integer>> sols = ca.getSolutionsAsList();
		Set<Pair> coveredPairs = ca.getCovInv1(sols, uncovered);
		System.out.println("Covered singles: " + coveredPairs.size());
		
		// Coverage
		System.out.println("Coverage: " + coveredPairs.size() + "/" + uncovered.size() + " = " + (float)coveredPairs.size()*100/uncovered.size() + "%");
		
		if(uncovered.size() != coveredPairs.size()) return false;
		
		for(Pair p : uncovered){
			if(!coveredPairs.contains(p)) return false;
		}
		
		return true;
	}
	
	public boolean verify2w(CNF cnf, CoveringArray ca) {
		// Calculate the valid pairs
		List<Pair2> uncovered = cnf.getU2();
		System.out.println("Valid pairs: " + uncovered.size());
		
		// Calculate the covered pairs
		List<List<Integer>> sols = ca.getSolutionsAsList();
		Set<Pair2> coveredPairs = ca.getCovInv(sols, uncovered);
		System.out.println("Covered pairs: " + coveredPairs.size());
		
		// Coverage
		System.out.println("Coverage: " + coveredPairs.size() + "/" + uncovered.size() + " = " + (float)coveredPairs.size()*100/uncovered.size() + "%");
		
		// Check
		if(uncovered.size() != coveredPairs.size()) return false;
		
		for(Pair2 p : uncovered){
			if(!coveredPairs.contains(p)) return false;
		}
		
		return true;
	}
	
	public boolean verify3w(CNF cnf, CoveringArray ca) {
		// Calculate the valid pairs
		List<Pair3> uncovered = cnf.getU3();
		System.out.println("Valid triples: " + uncovered.size());
		
		// Calculate the covered pairs
		List<List<Integer>> sols = ca.getSolutionsAsList();
		Set<Pair3> coveredTriples = ca.getCovInv3(sols, uncovered);
		System.out.println("Covered triples: " + coveredTriples.size());
		
		// Coverage
		System.out.println("Coverage: " + coveredTriples.size() + "/" + uncovered.size() + " = " + (float)coveredTriples.size()*100/uncovered.size() + "%");
		
		// Check
		if(uncovered.size() != coveredTriples.size()) return false;
		
		for(Pair3 p : uncovered){
			if(!coveredTriples.contains(p)) return false;
		}
		
		return true;
	}
}
