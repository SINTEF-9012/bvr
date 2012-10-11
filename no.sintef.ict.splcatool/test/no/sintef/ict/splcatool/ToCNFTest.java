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

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.FileUtility;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.SXFM;

import org.junit.Test;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;
import splar.core.fm.FeatureModelException;


public class ToCNFTest {
	@Test
	public void testConvertToCNF() throws UnsupportedModelException, IOException, FeatureModelException{
		for(String file : new FileUtility().traverseDirCollectFiles("TestData/Realistic")){
			if(file.contains("-cache")) continue;
			SXFM fm = null;
			if(file.endsWith(".m")){
				System.out.println("Testing conversion GUIDSL file to CNF: " + file);
				GUIDSL m1 = new GUIDSL(new File(file));
				fm = m1.getSXFM();
			}else if(file.endsWith(".xml")){
				System.out.println("Testing conversion SXFM file to CNF: " + file);
				fm = new SXFM(file);
			}else continue;
			
			CNF cnf = fm.getCNF();
			
			assertNotNull(cnf);
		}
	}
	
	@Test
	public void testWriteCNF() throws FeatureModelException, FileNotFoundException, IOException{
		SXFM fm = new SXFM("TestData/Realistic/Eshop-fm.xml");
		CNF cnf = fm.getCNF();
		cnf.writeToFile("TestData/Realistic/Eshop-fm.dimacs");
	}
}
