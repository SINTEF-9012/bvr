/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.ict.splcatool.test.tool;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;

import splar.core.fm.FeatureModelException;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;
import no.sintef.bvr.tool.model.BVRSimpleToolModel;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.ict.splcatool.CALib;
import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CSVException;
import no.sintef.ict.splcatool.BVRException;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.SPLCABVRModel;

public class TestValModel {
	@Test
	public void testValModel() throws CSVException, FeatureModelException, IOException, UnsupportedModelException, ContradictionException, TimeoutException,
			BVRException {
		assertTrue(validate(new File("TestData/Artificial/valid.bvr")));

	}

	private boolean validate(File f) throws CSVException, FeatureModelException, IOException, UnsupportedModelException, ContradictionException,
			TimeoutException, BVRException {
		BVRToolModel x = new BVRSimpleToolModel(f);
		SPLCABVRModel z = x.getSPLCABVRModel();
		CoveringArray ca = z.getCoveringArray();
		CNF cnf = z.getGUIDSL().getSXFM().getCNF();
		List<String> log = new ArrayList<String>();
		boolean valid = CALib.verifyCA(cnf, ca, true, log);
		return valid;
	}

	@Test
	public void testValModel2() throws CSVException, FeatureModelException, IOException, UnsupportedModelException, ContradictionException, TimeoutException,
			BVRException {
		assertFalse(validate(new File("TestData/Artificial/invalid.bvr")));
	}

	@Test
	public void testValModel3() throws CSVException, FeatureModelException, IOException, UnsupportedModelException, ContradictionException, TimeoutException,
			BVRException {
		assertFalse(validate(new File("TestData/Artificial/resDiffSizeInvalid.bvr")));
	}
	
	@Test
	public void testValMode4() throws CSVException, FeatureModelException, IOException, UnsupportedModelException, ContradictionException, TimeoutException,
			BVRException {
		assertFalse(validate(new File("TestData/Artificial/resDiffSizeInvalid2.bvr")));
	}
}
