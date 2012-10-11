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

import org.junit.Test;

import splar.core.fm.FeatureModelException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class TestWeightAlgs {
	@Test
	public void test2() throws UnsupportedModelException, IOException, FeatureModelException, TimeoutException, CoveringArrayGenerationException, CSVException{
		String fmfile = "TestData/Realistic/EclipseEx1/eclipse.m";
		String labfile = "TestData/Realistic/EclipseEx1/eclipse.m.actual.csv";
		String marketfile = "TestData/Realistic/EclipseEx1/eclipse.m.actual-weighted.csv";
		
		for(int t = 1; t < 4; t++){
			CNF cnf = new GUIDSL(new File(fmfile)).getSXFM().getCNF();
			CoveringArray ca = new CoveringArrayFile(labfile);
			double coverage = CALib.calc_coverage_weighted(cnf, t, ca, fmfile, 1, marketfile, false);
			assertEquals(100, (int)coverage);
		}
	}
	
/*	@Test
	public void test1() throws IOException, UnsupportedModelException, FeatureModelException, CSVException{
		File fm = new File("TestData/Realistic/EclipseEx1/eclipse.m");
		File lab = new File("TestData/Realistic/EclipseEx1/eclipse.m.actual.csv");
		File weights = new File("TestData/Realistic/EclipseEx1/eclipse.m.actual-weighted.csv");
		
		Map<String, String> args = new HashMap<String, String>();
		args.put("fm", fm.getAbsoluteFile().toString());
		args.put("s", "1");
		args.put("ca", lab.getAbsoluteFile().toString());
		args.put("threads", "1");
		args.put("weights", weights.getAbsoluteFile().toString());
		int cov2wactua2w = (int) SPLCATool.vspl.calc_cov_weighted(args);

		assertEquals(100, cov2wactua2w);
	}
	
	@Test
	public void test2() throws IOException, UnsupportedModelException, FeatureModelException, CSVException{
		File fm = new File("TestData/Realistic/EclipseEx1/eclipse.m");
		File lab = new File("TestData/Realistic/EclipseEx1/eclipse.m.actual.csv");
		File weights = new File("TestData/Realistic/EclipseEx1/eclipse.m.actual-weighted.csv");
		
		Map<String, String> args = new HashMap<String, String>();
		args.put("fm", fm.getAbsoluteFile().toString());
		args.put("s", "2");
		args.put("ca", lab.getAbsoluteFile().toString());
		args.put("threads", "1");
		args.put("weights", weights.getAbsoluteFile().toString());
		int cov2wactua2w = (int) SPLCATool.vspl.calc_cov_weighted(args);

		assertEquals(100, cov2wactua2w);
	}
	
	@Test
	public void test3() throws IOException, UnsupportedModelException, FeatureModelException, CSVException{
		File fm = new File("TestData/Realistic/EclipseEx1/eclipse.m");
		File lab = new File("TestData/Realistic/EclipseEx1/eclipse.m.actual.csv");
		File weights = new File("TestData/Realistic/EclipseEx1/eclipse.m.actual-weighted.csv");
		
		Map<String, String> args = new HashMap<String, String>();
		args.put("fm", fm.getAbsoluteFile().toString());
		args.put("s", "3");
		args.put("ca", lab.getAbsoluteFile().toString());
		args.put("threads", "1");
		args.put("weights", weights.getAbsoluteFile().toString());
		int cov2wactua2w = (int) SPLCATool.vspl.calc_cov_weighted(args);

		assertEquals(100, cov2wactua2w);
	}
	*/
}
