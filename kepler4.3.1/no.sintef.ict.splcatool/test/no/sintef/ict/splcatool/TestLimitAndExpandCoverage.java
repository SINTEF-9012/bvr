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

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.List;
import java.util.concurrent.TimeoutException;

import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.Pair2;
import no.sintef.ict.splcatool.SXFM;

import org.junit.Test;

import splar.core.fm.FeatureModelException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class TestLimitAndExpandCoverage {
	@Test(timeout=10000)
	public void testLimitCoverage() throws IOException, UnsupportedModelException, FeatureModelException, TimeoutException, CoveringArrayGenerationException{
		GUIDSL m1 = new GUIDSL(new File("TestData/Realistic/Apl.m"));
		SXFM fm = m1.getSXFM();
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("J11", 2, 1);
		ca.generate(75, Integer.MAX_VALUE);
		
		// Calculate the valid pairs
		List<Pair2> uncovered = cnf.getU2();
		System.out.println("Valid pairs: " + uncovered.size());
		
		// Calculate the covered pairs
		List<List<Integer>> sols = ca.getSolutionsAsList();
		Set<Pair2> coveredPairs = ca.getCovInv(sols, uncovered);
		System.out.println("Covered pairs: " + coveredPairs.size());
		
		// Coverage
		System.out.println("Coverage: " + coveredPairs.size() + "/" + uncovered.size() + " = " + (float)coveredPairs.size()*100/uncovered.size() + "%");
		
		assertTrue(ca.getCoverage() >= (int)((float)coveredPairs.size()*100/uncovered.size()));
	}
}
