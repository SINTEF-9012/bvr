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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.FileUtility;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.SAT4JSolver;
import no.sintef.ict.splcatool.SXFM;

import org.junit.Test;
import org.sat4j.specs.ContradictionException;

import splar.core.fm.FeatureModelException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class CNFTest {
	@Test
	public void loadCnf() throws IOException, ContradictionException, org.sat4j.specs.TimeoutException, TimeoutException{
		for(String file : new FileUtility().traverseDirCollectFiles("TestData/Realistic")){
			if(file.contains("-cache")) continue;
			if(file.contains("_results")) continue;
			CNF cnf = null;
			if(file.endsWith(".dimacs")){
				cnf = new CNF(file, CNF.type.dimacs);
			}else if(file.endsWith(".dot")){
				cnf = new CNF(file, CNF.type.dot);
			}else if(file.endsWith(".cnf")){
				cnf = new CNF(file, CNF.type.cnf);
			}else continue;
			
			System.out.println("Testing the loading of CNF file: " + file);
			
			SAT4JSolver s = cnf.getSAT4JSolver();
			assertTrue(s.isSatisfiable());
		}
	}
	
	@Test
	public void compareCnf() throws IOException, ContradictionException, UnsupportedModelException, FeatureModelException{
		List<String> guiDslFile = new ArrayList<String>();
		List<String> cnfFile = new ArrayList<String>();
		
		for(String file : new FileUtility().traverseDirCollectFiles("TestData/Realistic")){
			if(file.contains("-cache")) continue;
			if(file.contains("_results")) continue;
			if(file.endsWith(".m"))
				guiDslFile.add(file.substring(0, file.length()-2));
			if(file.endsWith(".cnf"))
				cnfFile.add(file.substring(0, file.length()-4));
		}
		
		List<String> intersection = new ArrayList<String>(guiDslFile);
		intersection.retainAll(cnfFile);
		
		for(String file : intersection){
			GUIDSL m = new GUIDSL(new File(file + ".m"));
			SXFM sxfm = m.getSXFM();
			CNF cnf1 = sxfm.getCNF();
			
			CNF cnf2 = new CNF(file + ".cnf", CNF.type.cnf);
			
			System.out.println("Comparing the CNF and the converted CNF: " + file);
			
			SAT4JSolver sat1 = cnf1.getSAT4JSolver();
			SAT4JSolver sat2 = cnf2.getSAT4JSolver();
			
			sat1.setTimeout(10);
			sat2.setTimeout(10);
			
			try{
				assertEquals(sat1.getSolutions(), sat2.getSolutions());
			}catch(org.sat4j.specs.TimeoutException t){
			}
		}
	}
}
