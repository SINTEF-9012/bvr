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


import java.io.File;
import java.io.IOException;

import no.sintef.ict.splcatool.FileUtility;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.SXFM;

import org.junit.Test;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;
import splar.core.fm.FeatureModelException;
import splar.plugins.reasoners.bdd.javabdd.BDDExceededBuildingTimeException;


public class GUIDSLandSXFMTest {
	@Test
	public void testConvertFromGUIDSLToSXFM() throws UnsupportedModelException, IOException, FeatureModelException, BDDExceededBuildingTimeException{
		for(String file : new FileUtility().traverseDirCollectFiles("TestData/Realistic")){
			if(!file.endsWith(".m")) continue;
			System.out.println("Testing conversion from GUIDSL to SXFM for file: " + file);
			GUIDSL m1 = new GUIDSL(new File(file));
			SXFM mi1 = m1.getSXFM();
			GUIDSL m2 = mi1.getGUIDSL();
			m2.getSXFM();
			//assertEquals((long)mi1.getNrOfProducts(), (long)mi2.getNrOfProducts());
		}
	}
	
	@Test
	public void testConvertFromSXFMToGUIDSL() throws FeatureModelException, UnsupportedModelException, BDDExceededBuildingTimeException{
		for(String file : new FileUtility().traverseDirCollectFiles("TestData/Realistic")){
			if(!file.endsWith(".xml")) continue;
			System.out.println("Testing conversion from SXFM to GUIDSL for file: " + file);
			SXFM m1 = new SXFM(file);
			GUIDSL mi = m1.getGUIDSL();
			mi.getSXFM();
			//if(m1.getFeatures() < 150)
				//assertEquals((long)m1.getNrOfProducts(), (long)m2.getNrOfProducts());
		}
	}
}
