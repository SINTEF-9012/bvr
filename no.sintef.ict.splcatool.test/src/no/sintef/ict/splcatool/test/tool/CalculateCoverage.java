/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.ict.splcatool.test.tool;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import no.sintef.bvr.tool.model.BVRSimpleToolModel;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.ict.splcatool.BVRException;
import no.sintef.ict.splcatool.CALib;
import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CSVException;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.GUIDSL;
import org.junit.Test;
import splar.core.fm.FeatureModelException;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;


public class CalculateCoverage {


	@Test
	public void test2WiseDiffResolutionSize100Coverage() throws Exception {
		int coverage = calcultaeCoverage(2, new File("TestData/Artificial/resDiffSize.bvr"));
		assertEquals("incorrect coverage calculated", 100, coverage);
	}
	
	@Test
	public void test2WiseDiffResolutionSize50Coverage() throws Exception {
		int coverage = calcultaeCoverage(2, new File("TestData/Artificial/resDiffSize50.bvr"));
		assertEquals("incorrect coverage calculated", 50, coverage);
	}

	private int calcultaeCoverage(int n_wise, File f) throws IOException, UnsupportedModelException, FeatureModelException, BVRException, CSVException  {
		BVRToolModel x = new BVRSimpleToolModel(f);
		GUIDSL gdsl = x.getSPLCABVRModel().getGUIDSL();
		CNF cnf = gdsl.getSXFM().getCNF();
		// Get Covering Array
		CoveringArray ca = x.getSPLCABVRModel().getCoveringArray();
		// Calculate
		int cov = (int) Math.round(CALib.calc_coverage(cnf, n_wise, ca));
		return cov;
	}
}
