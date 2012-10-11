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
import java.io.FileNotFoundException;
import java.io.IOException;

import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.FileUtility;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.SAT4JSolver;
import no.sintef.ict.splcatool.SXFM;

import org.junit.Test;
import org.sat4j.reader.ParseFormatException;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;
import splar.core.fm.FeatureModelException;


public class ToSAT4J {
	@Test
	public void testConvertToSAT4J() throws UnsupportedModelException, IOException, FeatureModelException, TimeoutException, ContradictionException{
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
			
			CNF cnf = fm.getCNF();
			
			SAT4JSolver solver = cnf.getSAT4JSolver();
			solver.setTimeout(1);
			assertTrue(solver.isSatisfiable());
			
			int solutions = 0;
			try{
				solutions = solver.getSolutions();
			}catch(TimeoutException t){
				solutions = solver.getSolutionsLowerBound();
			}
			
			assertTrue(solutions>0);
		}
	}
	
	@Test
	public void testLoadSAT4J() throws FileNotFoundException, ParseFormatException, IOException, ContradictionException, TimeoutException{
		for(String file : new FileUtility().traverseDirCollectFiles("TestData/Realistic")){
			if(file.contains("_results")) continue;
			if(file.contains("-cache")) continue;
			if(!file.endsWith(".cnf")) continue;
			
			SAT4JSolver solver = new SAT4JSolver(file);
			solver.setTimeout(1);
			assertTrue(solver.isSatisfiable());
			
			int solutions = 0;
			try{
				solutions = solver.getSolutions();
			}catch(TimeoutException t){
				solutions = solver.getSolutionsLowerBound();
			}
			
			assertTrue(solutions>0);
		}
	}
}
