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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.CoveringArrayFile;
import no.sintef.ict.splcatool.Pair2;
import no.sintef.ict.splcatool.SXFM;

import org.junit.Test;

import splar.core.fm.FeatureModelException;

public class TestLimitCoverAndCalculation {
	@Test
	public void testLimitCoverAndCalculation() throws IOException, TimeoutException, FeatureModelException, CoveringArrayGenerationException{
		SXFM fm = new SXFM("TestData/Realistic/Eshop-fm.xml");
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("J11", 2, 4);
		ca.generate(95, Integer.MAX_VALUE);
		ca.writeToFile("test.dat");
		
		// Calculate the valid pairs
		List<Pair2> uncovered = cnf.getU2();
		System.out.println("Valid pairs: " + uncovered.size());
		
		// Calculate the covered pairs
		List<List<Integer>> sols = new ArrayList<List<Integer>>();
		for(int i=0;i<ca.getRowCount();i++){
			Integer rowa[] = ca.getRow(i);
			List<Integer> row = new ArrayList<Integer>();
			for(int j=0;j<rowa.length;j++)
				row.add((rowa[j]==0)?(j+1):-(j+1));
			sols.add(row);
		}
		Set<Pair2> coveredPairs = ca.getCovInv(sols, uncovered);
		
		assertTrue(95 <= (int)((float)coveredPairs.size()*100/uncovered.size()));
	}
	
	@Test
	public void testLimitCoverThenAdd() throws IOException, TimeoutException, FeatureModelException, CSVException, CoveringArrayGenerationException{
		int sols1 = 0;
		int sols2 = 0;
		
		{
			SXFM fm = new SXFM("TestData/Realistic/Eshop-fm.xml");
			CNF cnf = fm.getCNF();
			CoveringArray ca = cnf.getCoveringArrayGenerator("J11", 2, 4);
			ca.generate(95, Integer.MAX_VALUE);
			ca.writeToFile("test.csv");
			sols1 = ca.getRowCount();
		}
		
		{
			CoveringArray partial = new CoveringArrayFile(new File("test.csv"));
			SXFM fm = new SXFM("TestData/Realistic/Eshop-fm.xml");
			CNF cnf = fm.getCNF();
			CoveringArray ca = cnf.getCoveringArrayGenerator("J11", 2, 4);
			ca.startFrom(partial);
			ca.generate(100, Integer.MAX_VALUE);
			sols2 = ca.getRowCount();
		}
		
		System.out.println(sols1 + " and " + sols2);
	}
}
