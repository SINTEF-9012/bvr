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

import static org.junit.Assert.*;

import java.io.IOException;

import no.sintef.ict.splcatool.FileUtility;
import no.sintef.ict.splcatool.SXFM;

import org.junit.Test;

import splar.core.fm.FeatureModelException;


public class SXFMTest {
	@Test
	public void testLoadSave() throws IOException, FeatureModelException{
		for(String file : new FileUtility().traverseDirCollectFiles("TestData/Realistic")){
			if(file.contains("-cache")) continue;
			if(file.contains("_result")) continue;
			if(!file.endsWith(".xml")) continue;
			System.out.println("Test loading and saving of SXFM file: " + file);
			SXFM m1 = new SXFM(file);
			m1.writeToFile("test.dat");
			SXFM m2 = new SXFM("test.dat");
			assertTrue(file, m1.equals(m2));
		}
	}
}
