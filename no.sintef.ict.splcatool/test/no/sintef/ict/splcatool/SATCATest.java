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
import no.sintef.ict.splcatool.FileUtility;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.SXFM;

import org.junit.Test;

import splar.core.fm.FeatureModelException;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;


public class SATCATest {
	@Test
	public void testCoveringArray() throws UnsupportedModelException, IOException, FeatureModelException, TimeoutException, CoveringArrayGenerationException{
		for(String file : new FileUtility().traverseDirCollectFiles("TestData/Realistic")){
			SXFM fm = null;
			if(file.contains("_results")) continue;
			if(file.contains("-cache")) continue;
			if(!file.contains("EclipseSPL.m")) continue;
			if(file.endsWith(".m")){
				GUIDSL m1 = new GUIDSL(new File(file));
				fm = m1.getSXFM();
			}else if(file.endsWith(".xml")){
				fm = new SXFM(file);
			}else continue;
			
			//System.out.println(file);
			
			CNF cnf = fm.getCNF();
			
			CoveringArray ca1 = cnf.getCoveringArrayGenerator("jenny", 1, 0);
			ca1.generate();
			//System.out.println(ca1.getRowCount());
			assertEquals(14, ca1.getRowCount());
			CoveringArray ca2 = cnf.getCoveringArrayGenerator("jenny", 2, 0);
			ca2.generate();
			//System.out.println(ca2.getRowCount());
			assertEquals(67, ca2.getRowCount());
		}
	}
}
