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

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.SXFM;

import org.junit.Test;

import splar.core.fm.FeatureModelException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class TestSizeLimit {
	@Test
	public void testLimitCoverageJ111w() throws IOException, UnsupportedModelException, FeatureModelException, TimeoutException, CoveringArrayGenerationException{
		GUIDSL m1 = new GUIDSL(new File("TestData/Realistic/Apl.m"));
		SXFM fm = m1.getSXFM();
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("J11", 1, 1);
		
		// Coverage
		ca.generate(100, 1);
		assertEquals(1, ca.getRowCount());
	}
	
	@Test
	public void testLimitCoverageJ112w() throws IOException, UnsupportedModelException, FeatureModelException, TimeoutException, CoveringArrayGenerationException{
		GUIDSL m1 = new GUIDSL(new File("TestData/Realistic/Apl.m"));
		SXFM fm = m1.getSXFM();
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("J11", 2, 1);
		
		// Coverage
		ca.generate(100, 5);
		assertEquals(5, ca.getRowCount());
	}
	
	@Test
	public void testLimitCoverageJ113w() throws IOException, UnsupportedModelException, FeatureModelException, TimeoutException, CoveringArrayGenerationException{
		GUIDSL m1 = new GUIDSL(new File("TestData/Realistic/Apl.m"));
		SXFM fm = m1.getSXFM();
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("J11", 3, 1);
		
		// Coverage
		ca.generate(100, 10);
		assertEquals(10, ca.getRowCount());
	}
	
	@Test
	public void testLimitCoverageChvatal1w() throws IOException, UnsupportedModelException, FeatureModelException, TimeoutException, CoveringArrayGenerationException{
		GUIDSL m1 = new GUIDSL(new File("TestData/Realistic/Apl.m"));
		SXFM fm = m1.getSXFM();
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("Chvatal", 1, 1);
		
		// Coverage
		ca.generate(100, 1);
		assertEquals(1, ca.getRowCount());
	}
	
	@Test
	public void testLimitCoverageChvatal2w() throws IOException, UnsupportedModelException, FeatureModelException, TimeoutException, CoveringArrayGenerationException{
		GUIDSL m1 = new GUIDSL(new File("TestData/Realistic/Apl.m"));
		SXFM fm = m1.getSXFM();
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("Chvatal", 2, 1);
		
		// Coverage
		ca.generate(100, 5);
		assertEquals(5, ca.getRowCount());
	}
	
	@Test
	public void testLimitCoverageChvatal3w() throws IOException, UnsupportedModelException, FeatureModelException, TimeoutException, CoveringArrayGenerationException{
		GUIDSL m1 = new GUIDSL(new File("TestData/Realistic/Apl.m"));
		SXFM fm = m1.getSXFM();
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("Chvatal", 3, 1);
		
		// Coverage
		ca.generate(100, 10);
		assertEquals(10, ca.getRowCount());
	}
	
	@Test
	public void testLimitCoverageChvatal4w() throws IOException, UnsupportedModelException, FeatureModelException, TimeoutException, CoveringArrayGenerationException{
		GUIDSL m1 = new GUIDSL(new File("TestData/Realistic/Apl.m"));
		SXFM fm = m1.getSXFM();
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("Chvatal", 4, 1);
		
		// Coverage
		ca.generate(100, 11);
		assertEquals(11, ca.getRowCount());
	}
	
	@Test
	public void testLimitCoverageChvatalWeighted1w() throws IOException, UnsupportedModelException, FeatureModelException, TimeoutException, CSVException, CoveringArrayGenerationException{
		GUIDSL m1 = new GUIDSL(new File("TestData/Realistic/Apl.m"));
		SXFM fm = m1.getSXFM();
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("ChvatalWeighted", 1, 1, "TestData/Artificial/Apl.m.weights.csv");
		
		// Coverage
		ca.generate(100, 1);
		assertEquals(1, ca.getRowCount());
	}
	
	@Test
	public void testLimitCoverageChvatalWeighted2w() throws IOException, UnsupportedModelException, FeatureModelException, TimeoutException, CSVException, CoveringArrayGenerationException{
		GUIDSL m1 = new GUIDSL(new File("TestData/Realistic/Apl.m"));
		SXFM fm = m1.getSXFM();
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("ChvatalWeighted", 2, 1, "TestData/Artificial/Apl.m.weights.csv");
		
		// Coverage
		ca.generate(100, 5);
		assertEquals(5, ca.getRowCount());
	}
	
	@Test
	public void testLimitCoverageChvatalWeighted3w() throws IOException, UnsupportedModelException, FeatureModelException, TimeoutException, CSVException, CoveringArrayGenerationException{
		GUIDSL m1 = new GUIDSL(new File("TestData/Realistic/Apl.m"));
		SXFM fm = m1.getSXFM();
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("ChvatalWeighted", 3, 1, "TestData/Artificial/Apl.m.weights.csv");
		
		// Coverage
		ca.generate(100, 10);
		assertEquals(10, ca.getRowCount());
	}
}
