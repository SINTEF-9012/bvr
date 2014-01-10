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
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.sat4j.specs.ContradictionException;

import splar.core.fm.FeatureModelException;
import splar.plugins.reasoners.bdd.javabdd.BDDExceededBuildingTimeException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class TestCmdLineInteraction3 {
	@Test
	public void testtwise_3_J12_usage() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File fm = new File("TestData/Realistic/Car_fm.xml");
		File testFile = new File("TestData/Realistic/Car_fm.xml.ca3.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-a", "J12",
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
			"-a", "J12",
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
			"-a", "J12",
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
			"-s", "3",
			"-sizelimit", ""+(oldrows+2),
			"-a", "J12",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			}
		);
		
		assertTrue(testFile.exists());
		int newrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile( testFile);
			newrows = ca.getRowCount();
		}
		assertEquals(newrows, oldrows+2);
	}
	
	@Test
	public void testtwise_3_J12_usage_onlyOnes() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File fm = new File("TestData/Realistic/stack_fm.xml");
		File testFile = new File("TestData/Realistic/stack_fm.xml.ca3.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-a", "J12",
			"-limit", "65%",
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
			"-a", "J12",
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
			"-a", "J12",
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
			"-a", "J12",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-onlyOnes"
			}
		);
		
		assertTrue(testFile.exists());
		int newrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile( testFile);
			newrows = ca.getRowCount();
		}
		assertEquals(oldrows+2, newrows);
	}
	
	@Test
	public void testtwise_3_J12_usage_noAllZeros() throws UnsupportedModelException, IOException, FeatureModelException, ContradictionException, TimeoutException, BDDExceededBuildingTimeException, java.util.concurrent.TimeoutException, CSVException{
		File fm = new File("TestData/Realistic/Car_fm.xml");
		File testFile = new File("TestData/Realistic/Car_fm.xml.ca3.csv");
		if(testFile.exists()){
			testFile.delete();
		}
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "3",
			"-a", "J12",
			"-limit", "65%",
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
			"-a", "J12",
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
			"-a", "J12",
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
			"-a", "J12",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-noAllZeros"
			}
		);
		
		assertTrue(testFile.exists());
		int newrows = 0;
		{
			CoveringArray ca = new CoveringArrayFile( testFile);
			newrows = ca.getRowCount();
		}
		assertEquals(oldrows+2, newrows);
	}
}

