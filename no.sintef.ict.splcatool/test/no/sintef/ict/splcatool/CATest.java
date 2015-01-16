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

import no.sintef.ict.splcatool.FileUtility;

import org.junit.Test;


public class CATest {
	
	final char LF = 0x0A;
	final char CR = 0x0D;
	
	@Test
	public void testLoadEmptyCA() throws IOException, CSVException{
		CoveringArrayFile caf = new CoveringArrayFile(new File("TestData/Artificial/TestCSVs/car_fm.xml.empty.fp.csv"));
		caf.writeToFile("test.dat");
		
		String a = new FileUtility().readFileAsString("TestData/Artificial/TestCSVs/car_fm.xml.empty.fp.csv");
		String b = new FileUtility().readFileAsString("test.dat");
		
		//there is a bug in the utils above, you may end up with the different ending in expected and actual result...
		a = a.replaceAll("(?<!" + CR + ")" + LF, ""+CR+""+LF);
		b = b.replaceAll("(?<!" + CR + ")" + LF, ""+CR+""+LF);
		
		assertEquals(a, b);
	}
	
	@Test
	public void testLoadFPCA() throws IOException, CSVException{
		CoveringArrayFile caf = new CoveringArrayFile(new File("TestData/Artificial/TestCSVs/car_fm.xml.ca2.fp.csv"));
		
		caf.writeToFile("test.dat", CoveringArrayFile.Type.horizontal);
		
		//there is a bug in the utils above, you may end up with the different ending in expected and actual result...
		String a = new FileUtility().readFileAsString("TestData/Artificial/TestCSVs/car_fm.xml.ca2.fp.csv");
		String b = new FileUtility().readFileAsString("test.dat");
		
		a = a.replaceAll("(?<!" + CR + ")" + LF, ""+CR+""+LF);
		b = b.replaceAll("(?<!" + CR + ")" + LF, ""+CR+""+LF);
		
		assertEquals(a, b);
	}
	
	@Test
	public void testSortedCA() throws IOException{
		File fm = new File("TestData/Artificial/TestCSVs/car_fm.xml");
		File testFile = new File("TestData/Artificial/TestCSVs/car_fm.xml.empty.fp.csv");
		SPLCATool.main(new String [] {
			"-t", "t_wise", 
			"-fm", fm.getAbsoluteFile().toString(),
			"-s", "2",
			"-sizelimit", "0",
			"-startFrom", testFile.getAbsoluteFile().toString(),
			"-o", "test.dat"
			}
		);
		
		//there is a bug in the utils above, you may end up with the different ending in expected and actual result...
		String a = new FileUtility().readFileAsString("TestData/Artificial/TestCSVs/car_fm.xml.empty.fp.csv");
		String b = new FileUtility().readFileAsString("test.dat");
		
		a = a.replaceAll("(?<!" + CR + ")" + LF, ""+CR+""+LF);
		b = b.replaceAll("(?<!" + CR + ")" + LF, ""+CR+""+LF);
		
		assertEquals(a, b);
	}
}
