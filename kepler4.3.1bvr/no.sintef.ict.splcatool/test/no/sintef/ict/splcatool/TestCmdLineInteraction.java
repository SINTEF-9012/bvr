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
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;

import splar.core.fm.FeatureModelException;
import splar.plugins.reasoners.bdd.javabdd.BDDExceededBuildingTimeException;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class TestCmdLineInteraction {
	@Test
	public void testtwise_1_ChvatalWeighted_err1() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File weights = new File("TestData/Realistic/rvm.m.actual-weighted.csv");
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Realistic/rvm.m").getAbsoluteFile().toString(),
			"-s", "1",
			"-a", "ChvatalWeightedx",
			"-weights", weights.getAbsoluteFile().toString(),
			}
		);
	}
	
	@Test
	public void testtwise_1_ChvatalWeighted_err2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File weights = new File("TestData/Realistic/rvm.m.actual-weighted.csv");
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Realistic/rvm.m").getAbsoluteFile().toString(),
			"-s", "1",
			"-a", "ChvatalWeighted",
			"-threads", "2",
			"-weights", weights.getAbsoluteFile().toString(),
			}
		);
	}
	
	@Test
	public void testtwise_1_ChvatalWeighted_err3() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File weights = new File("TestData/Realistic/rvm.m.actual-weighted.csv");
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Realistic/rvm.m").getAbsoluteFile().toString(),
			"-s", "1",
			"-a", "ChvatalWeighted",
			"-threads", "a",
			"-weights", weights.getAbsoluteFile().toString(),
			}
		);
	}
	
	@Test
	public void testtwise_1_ChvatalWeighted_err4() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File weights = new File("TestData/Realistic/rvm.m.actual-weighted.csv");
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Realistic/rvm.m").getAbsoluteFile().toString(),
			"-s", "b",
			"-a", "ChvatalWeighted",
			"-threads", "1",
			"-weights", weights.getAbsoluteFile().toString(),
			}
		);
	}
	
	@Test
	public void testtwise_ChvatalWeighted_err1() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File weights = new File("TestData/Realistic/rvm.m.actual-weighted.csv");
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Realistic/rvm.m").getAbsoluteFile().toString(),
			"-s", "0",
			"-a", "ChvatalWeighted",
			"-threads", "1",
			"-weights", weights.getAbsoluteFile().toString(),
			}
		);
	}
	
	@Test
	public void testtwise_ChvatalWeighted_err2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File weights = new File("TestData/Realistic/rvm.m.actual-weighted.csv");
		SPLCATool.main(new String [] {
			"-t", "t_wise_weighted", 
			"-fm", new File("TestData/Realistic/rvm.m").getAbsoluteFile().toString(),
			"-s", "4",
			"-a", "ChvatalWeighted",
			"-threads", "1",
			"-weights", weights.getAbsoluteFile().toString(),
			}
		);
	}
	
	@Test
	public void testCNFModelLoad() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
				"-t", "sat_time", 
				"-fm", new File("TestData/Realistic/Apl.cnf").getAbsoluteFile().toString()
			}
		);
	}
	
	@Test
	public void testCNFModelLoad2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File testFile = new File("TestData/Realistic/Berkeley.cnf.ca1.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		
		SPLCATool.main(new String [] {
				"-t", "t_wise",
				"-s", "1",
				"-fm", new File("TestData/Realistic/Berkeley.cnf").getAbsoluteFile().toString()
			}
		);
		
		assertTrue(testFile.exists());
	}

	@Test
	public void testDIMACSModelLoad() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
				"-t", "sat_time", 
				"-fm", new File("TestData/Realistic/2.6.28.6-icse11.dimacs").getAbsoluteFile().toString()
			}
		);
	}
	
	@Test
	public void testDIMACSModelLoad2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File testFile = new File("TestData/Realistic/Eshop-fm.dimacs.ca1.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		
		SPLCATool.main(new String [] {
				"-t", "t_wise",
				"-s", "1",
				"-fm", new File("TestData/Realistic/Eshop-fm.dimacs").getAbsoluteFile().toString()
			}
		);
		
		assertTrue(testFile.exists());
	}
	
	//TestData\Realistic\connector_fm.xml
	//TestData\Realistic\smart_home_fm.xml
	
	@Test
	public void testSXFMModelLoad() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
				"-t", "sat_time", 
				"-fm", new File("TestData/Realistic/connector_fm.xml").getAbsoluteFile().toString()
			}
		);
	}
	
	@Test
	public void testSXFMModelLoad2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File testFile = new File("TestData/Realistic/smart_home_fm.xml.ca1.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		
		SPLCATool.main(new String [] {
				"-t", "t_wise",
				"-s", "1",
				"-fm", new File("TestData/Realistic/smart_home_fm.xml").getAbsoluteFile().toString()
			}
		);
		
		assertTrue(testFile.exists());
	}
	
	@Test
	public void testGUIDSLModelLoad() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
				"-t", "sat_time", 
				"-fm", new File("TestData/Realistic/Gg4.m").getAbsoluteFile().toString()
			}
		);
	}
	
	@Test
	public void testGUIDSLModelLoad2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File testFile = new File("TestData/Realistic/Violet.m.ca1.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		
		SPLCATool.main(new String [] {
				"-t", "t_wise",
				"-s", "1",
				"-fm", new File("TestData/Realistic/Violet.m").getAbsoluteFile().toString()
			}
		);
		
		assertTrue(testFile.exists());
	}
	
	@Test
	public void testVerifyEclispeCA() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "verify_solutions", 
			"-fm", new File("TestData/Realistic/Eclipse-red.m").getAbsoluteFile().toString(), 
			"-check", new File("TestData/Realistic/eclipse-red.actual.csv").getAbsoluteFile().toString()}
		);
	}
	
	@Test
	public void testVerifyEclispeCA2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "verify_solutions", 
			"-fm", new File("TestData/Realistic/Eclipse-red.m").getAbsoluteFile().toString(), 
			"-check", new File("TestData/Realistic/eclipse.actual.csv").getAbsoluteFile().toString()}
		);
	}
	
	@Test
	public void testCountSolutions() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "count_solutions", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString()
			}
		);
	}
	
	@Test
	public void testSatTime() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "sat_time", 
			"-fm", new File("TestData/Realistic/ecos-icse11.dimacs").getAbsoluteFile().toString()
			}
		);
	}
	
	@Test
	public void testHelp() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "help", 
			}
		);
	}
	
	@Test
	public void testtwise_1_min() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File testFile = new File("TestData/Realistic/Eshop-fm.xml.ca1.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/Eshop-fm.xml").getAbsoluteFile().toString(),
			"-s", "1"
			}
		);
		assertTrue(testFile.exists());
	}
	
	@Test
	public void testtwise_2_min() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File testFile = new File("TestData/Realistic/Violet.m.ca2.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/Violet.m").getAbsoluteFile().toString(),
			"-s", "2"
			}
		);
		assertTrue(testFile.exists());
	}
	
	@Test
	public void testtwise_3_min() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File testFile = new File("TestData/Realistic/car_fm.xml.ca3.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "3"
			}
		);
		assertTrue(testFile.exists());
	}
	
	@Test
	public void testtwise_err1() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "t_wise"
			}
		);
	}
	
	@Test
	public void testtwise_err2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			}
		);
	}
	
	@Test
	public void testtwise_1_Chvatal() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File testFile = new File("TestData/Realistic/car_fm.xml.ca1.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "1",
			"-a", "Chvatal"
			}
		);
		assertTrue(testFile.exists());
	}
	
	@Test
	public void testtwise_1_Chvatal_err1() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "1",
			"-a", "Chvatalx"
			}
		);
	}
	
	@Test
	public void testtwise_1_Chvatal_err2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "1",
			"-a", "Chvatal",
			"-threads", "2"
			}
		);
	}
	
	@Test
	public void testtwise_1_Chvatal_err3() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "1",
			"-a", "Chvatal",
			"-threads", "a"
			}
		);
	}
	
	@Test
	public void testtwise_1_Chvatal_err4() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "b",
			"-a", "Chvatal",
			"-threads", "1"
			}
		);
	}
	
	@Test
	public void testtwise_Chvatal_err1() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "0",
			"-a", "Chvatal",
			"-threads", "1"
			}
		);
	}
	
	@Test
	public void testtwise_Chvatal_err2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "5",
			"-a", "Chvatal",
			"-threads", "1"
			}
		);
	}
	
	@Test
	public void testtwise_3_Chvatal_usage() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File fm = new File("TestData/Realistic/Car_fm.xml");
		File testFile = new File("TestData/Realistic/Car_fm.xml.ca3.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-a", "Chvatal",
			"-limit", "75%"
			}
		);
		
		assertTrue(testFile.exists());
		
		long oldSize = testFile.length();
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-limit", "85%",
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			}
		);
		
		assertTrue(testFile.exists());
		long newSize = testFile.length();
		assertTrue(oldSize<newSize);
		
		oldSize = newSize;
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-limit", "85%",
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			}
		);
		
		assertTrue(testFile.exists());
		newSize = testFile.length();
		assertEquals(oldSize, newSize);

		int oldrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile( testFile);
			oldrows = ca.getRowCount();
		}
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-sizelimit", ""+(oldrows+2),
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			}
		);
		
		assertTrue(testFile.exists());
		int newrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			newrows = ca.getRowCount();
		}
		assertEquals(newrows, oldrows+2);
	}
	
	@Test
	public void testtwise_4_Chvatal_usage() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File fm = new File("TestData/Realistic/Car_fm.xml");
		File testFile = new File("TestData/Realistic/Car_fm.xml.ca4.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "4",
			"-a", "Chvatal",
			"-limit", "75%"
			}
		);
		
		assertTrue(testFile.exists());
		
		long oldSize = testFile.length();
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "4",
			"-limit", "85%",
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			}
		);
		
		assertTrue(testFile.exists());
		long newSize = testFile.length();
		assertTrue(oldSize<newSize);
		
		oldSize = newSize;
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "4",
			"-limit", "85%",
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			}
		);
		
		assertTrue(testFile.exists());
		newSize = testFile.length();
		assertEquals(oldSize, newSize);

		int oldrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			oldrows = ca.getRowCount();
		}
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "4",
			"-sizelimit", ""+(oldrows+2),
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			}
		);
		
		assertTrue(testFile.exists());
		int newrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			newrows = ca.getRowCount();
		}
		assertEquals(newrows, oldrows+2);
	}
	
	@Test
	public void testtwise_3_Chvatal_usage_onlyOnes() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File fm = new File("TestData/Realistic/stack_fm.xml");
		File testFile = new File("TestData/Realistic/stack_fm.xml.ca3.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-a", "Chvatal",
			"-limit", "75%",
			"-onlyOnes"
			}
		);
		
		assertTrue(testFile.exists());
		
		long oldSize = testFile.length();
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-limit", "85%",
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-onlyOnes"
			}
		);
		
		assertTrue(testFile.exists());
		long newSize = testFile.length();
		assertTrue(oldSize<newSize);
		
		oldSize = newSize;
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-limit", "85%",
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-onlyOnes"
			}
		);
		
		assertTrue(testFile.exists());
		newSize = testFile.length();
		assertEquals(oldSize, newSize);

		int oldrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			oldrows = ca.getRowCount();
		}
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-sizelimit", ""+(oldrows+2),
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-onlyOnes"
			}
		);
		
		assertTrue(testFile.exists());
		int newrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			newrows = ca.getRowCount();
		}
		assertEquals(oldrows+2, newrows);
	}
	
	@Test
	public void testtwise_4_Chvatal_usage_onlyOnes() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File fm = new File("TestData/Realistic/stack_fm.xml");
		File testFile = new File("TestData/Realistic/stack_fm.xml.ca4.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "4",
			"-a", "Chvatal",
			"-limit", "75%",
			"-onlyOnes"
			}
		);
		
		assertTrue(testFile.exists());
		
		long oldSize = testFile.length();
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "4",
			"-limit", "85%",
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-onlyOnes"
			}
		);
		
		assertTrue(testFile.exists());
		long newSize = testFile.length();
		assertTrue(oldSize<newSize);
		
		oldSize = newSize;
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "4",
			"-limit", "85%",
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-onlyOnes"
			}
		);
		
		assertTrue(testFile.exists());
		newSize = testFile.length();
		assertEquals(oldSize, newSize);

		int oldrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			oldrows = ca.getRowCount();
		}
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "4",
			"-sizelimit", ""+(oldrows+2),
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-onlyOnes"
			}
		);
		
		assertTrue(testFile.exists());
		int newrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			newrows = ca.getRowCount();
		}
		assertEquals(newrows, oldrows+2);
	}
	
	@Test
	public void testtwise_3_Chvatal_usage_noAllZeros() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File fm = new File("TestData/Realistic/Car_fm.xml");
		File testFile = new File("TestData/Realistic/Car_fm.xml.ca3.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-a", "Chvatal",
			"-limit", "75%",
			"-noAllZeros"
			}
		);
		
		assertTrue(testFile.exists());
		
		long oldSize = testFile.length();
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-limit", "85%",
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-noAllZeros"
			}
		);
		
		assertTrue(testFile.exists());
		long newSize = testFile.length();
		assertTrue(oldSize<newSize);
		
		oldSize = newSize;
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-limit", "85%",
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-noAllZeros"
			}
		);
		
		assertTrue(testFile.exists());
		newSize = testFile.length();
		assertEquals(oldSize, newSize);

		int oldrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			oldrows = ca.getRowCount();
		}
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-sizelimit", ""+(oldrows+2),
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-noAllZeros"
			}
		);
		
		assertTrue(testFile.exists());
		int newrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			newrows = ca.getRowCount();
		}
		assertEquals(oldrows+2, newrows);
	}
	
	@Test
	public void testtwise_4_Chvatal_usage_noAllZeros() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File fm = new File("TestData/Realistic/Car_fm.xml");
		File testFile = new File("TestData/Realistic/Car_fm.xml.ca4.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "4",
			"-a", "Chvatal",
			"-limit", "75%",
			"-noAllZeros"
			}
		);
		
		assertTrue(testFile.exists());
		
		long oldSize = testFile.length();
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "4",
			"-limit", "85%",
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-noAllZeros"
			}
		);
		
		assertTrue(testFile.exists());
		long newSize = testFile.length();
		assertTrue(oldSize<newSize);
		
		oldSize = newSize;
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "4",
			"-limit", "85%",
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-noAllZeros"
			}
		);
		
		assertTrue(testFile.exists());
		newSize = testFile.length();
		assertEquals(oldSize, newSize);

		int oldrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			oldrows = ca.getRowCount();
		}
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "4",
			"-sizelimit", ""+(oldrows+2),
			"-a", "Chvatal",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-noAllZeros"
			}
		);
		
		assertTrue(testFile.exists());
		int newrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			newrows = ca.getRowCount();
		}
		assertEquals(newrows, oldrows+2);
	}
	
	@Test
	public void testerr1() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			}
		);
	}
	
	@Test
	public void testtwise_1_J11() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File testFile = new File("TestData/Realistic/car_fm.xml.ca1.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "1",
			"-a", "J11"
			}
		);
		assertTrue(testFile.exists());
	}
	
	@Test
	public void testtwise_1_J11_err1() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "1",
			"-a", "J11x"
			}
		);
	}
	
	@Test
	public void testtwise_1_J11_err2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "1",
			"-a", "J11",
			"-threads", "2"
			}
		);
	}
	
	@Test
	public void testtwise_1_J11_err3() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "1",
			"-a", "J11",
			"-threads", "a"
			}
		);
	}
	
	@Test
	public void testtwise_1_J11_err4() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "b",
			"-a", "J11",
			"-threads", "1"
			}
		);
	}
	
	@Test
	public void testtwise_J11_err1() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "0",
			"-a", "J11",
			"-threads", "1"
			}
		);
	}
	
	@Test
	public void testtwise_J11_err2() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", new File("TestData/Realistic/car_fm.xml").getAbsoluteFile().toString(),
			"-s", "5",
			"-a", "J11",
			"-threads", "1"
			}
		);
	}
	
	@Test
	public void testtwise_3_J11_usage() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File fm = new File("TestData/Realistic/Car_fm.xml");
		File testFile = new File("TestData/Realistic/Car_fm.xml.ca3.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-a", "J11",
			"-limit", "75%"
			}
		);
		
		assertTrue(testFile.exists());
		
//		long oldSize = testFile.length();
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-limit", "85%",
			"-a", "J11",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			}
		);
		
/*		assertTrue(testFile.exists());
		long newSize = testFile.length();
		assertTrue(oldSize<newSize);
		
		oldSize = newSize;
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-limit", "85%",
			"-a", "J11",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			}
		);
		
		assertTrue(testFile.exists());
		newSize = testFile.length();
		assertEquals(oldSize, newSize);
*/
		int oldrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			oldrows = ca.getRowCount();
		}
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-sizelimit", ""+(oldrows+2),
			"-a", "J11",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			}
		);
		
		assertTrue(testFile.exists());
		int newrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			newrows = ca.getRowCount();
		}
		assertEquals(newrows, oldrows+2);
	}
	
	@Test
	public void testtwise_3_J11_usage_onlyOnes() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File fm = new File("TestData/Realistic/stack_fm.xml");
		File testFile = new File("TestData/Realistic/stack_fm.xml.ca3.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-a", "J11",
			"-limit", "75%",
			"-onlyOnes"
			}
		);
		
		assertTrue(testFile.exists());
		
		long oldSize = testFile.length();
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-limit", "85%",
			"-a", "J11",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-onlyOnes"
			}
		);
		
		assertTrue(testFile.exists());
		long newSize = testFile.length();
		assertTrue(oldSize<newSize);
		
/*		oldSize = newSize;
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-limit", "85%",
			"-a", "J11",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-onlyOnes"
			}
		);
		
		assertTrue(testFile.exists());
		newSize = testFile.length();
		assertEquals(oldSize, newSize);
*/
		int oldrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			oldrows = ca.getRowCount();
		}
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-sizelimit", ""+(oldrows+2),
			"-a", "J11",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-onlyOnes"
			}
		);
		
		assertTrue(testFile.exists());
		int newrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			newrows = ca.getRowCount();
		}
		assertEquals(oldrows+2, newrows);
	}
	
	@Test
	public void testtwise_3_J11_usage_noAllZeros() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File fm = new File("TestData/Realistic/Car_fm.xml");
		File testFile = new File("TestData/Realistic/Car_fm.xml.ca3.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-a", "J11",
			"-limit", "75%",
			"-noAllZeros"
			}
		);
		
		assertTrue(testFile.exists());
		
		long oldSize = testFile.length();
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-limit", "85%",
			"-a", "J11",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-noAllZeros"
			}
		);
		
		assertTrue(testFile.exists());
		long newSize = testFile.length();
		assertTrue(oldSize<newSize);
		
/*		oldSize = newSize;
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-limit", "85%",
			"-a", "J11",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-noAllZeros"
			}
		);
		
		assertTrue(testFile.exists());
		newSize = testFile.length();
		assertEquals(oldSize, newSize);
*/
		int oldrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			oldrows = ca.getRowCount();
		}
		
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-sizelimit", ""+(oldrows+2),
			"-a", "J11",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-noAllZeros"
			}
		);
		
		assertTrue(testFile.exists());
		int newrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile(testFile);
			newrows = ca.getRowCount();
		}
		assertEquals(oldrows+2, newrows);
	}
}
