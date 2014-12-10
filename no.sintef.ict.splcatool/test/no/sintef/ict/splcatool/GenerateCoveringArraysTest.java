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
import java.util.concurrent.TimeoutException;

import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.CoveringArrayFile;
import no.sintef.ict.splcatool.FileUtility;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.SXFM;

import org.junit.Test;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;
import splar.core.fm.FeatureModelException;


public class GenerateCoveringArraysTest {
	@Test
	public void testCoveringArray() throws UnsupportedModelException, IOException, FeatureModelException, TimeoutException, CoveringArrayGenerationException{
		for(String file : new FileUtility().traverseDirCollectFiles("TestData/Realistic")){
			SXFM fm = null;
			if(file.contains("_results")) continue;
			if(file.contains("-cache")) continue;
			if(file.endsWith(".m")){
				GUIDSL m1 = new GUIDSL(new File(file));
				fm = m1.getSXFM();
			}else if(file.endsWith(".xml")){
				fm = new SXFM(file);
			}else continue;
			
			//System.out.println(file);
			
			CNF cnf = fm.getCNF();
			
			CoveringArray ca = cnf.getCoveringArrayGenerator("J11", 1, 1);
			
			ca.setTimeout(60);
			ca.generate();
			
			assertTrue(ca.getRowCount()>0);
		}
	}
	
	@Test
	public void testReadWriteCoveringArray_type1() throws UnsupportedModelException, IOException, FeatureModelException, CSVException, CoveringArrayGenerationException{
		for(String file : new FileUtility().traverseDirCollectFiles("TestData/Realistic")){
			if(file.contains("_results")) continue;
			if(file.contains("-cache")) continue;
			SXFM fm = null;
			if(file.endsWith(".m")){
				GUIDSL m1 = new GUIDSL(new File(file));
				fm = m1.getSXFM();
			}else if(file.endsWith(".xml")){
				fm = new SXFM(file);
			}else continue;
			
			//System.out.println(file);
			
			CNF cnf = fm.getCNF();
			
			CoveringArray ca = cnf.getCoveringArrayGenerator("J11", 2, 1);
			
			ca.setTimeout(2);
			try {
				ca.generate();
			} catch (TimeoutException e) {
				continue;
			}
			
			assertTrue(ca.getRowCount()>0);
			
			ca.writeToFile("test.csv", CoveringArrayFile.Type.horizontal);
			CoveringArray cab = new CoveringArrayFile(new File("test.csv"));
			
			assertTrue(ca.equals(cab));
		}
	}
}
