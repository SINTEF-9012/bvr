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
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.SXFM;
import no.sintef.ict.splcatool.Verifier;

import org.junit.Before;
import org.junit.Test;
import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IVecInt;

import splar.core.fm.FeatureModelException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class TestVerify {
	Verifier v;
	
	@Before
	public void setup(){
		v = new Verifier();
	}
	
	@Test
	public void verify1w_Chvatal() throws UnsupportedModelException, IOException, FeatureModelException, TimeoutException, org.sat4j.specs.TimeoutException, ContradictionException, CoveringArrayGenerationException{
		GUIDSL m1 = new GUIDSL(new File("TestData/Realistic/Apl.m"));
		SXFM fm = m1.getSXFM();
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("Chvatal", 1, 1);
		ca.generate();
		assertTrue(v.verify1w(cnf, ca));
		
		for(int n = 0; n < ca.getRowCount(); n++){
			SAT4JSolver solver = cnf.getSAT4JSolver();
			if(!solver.solver.isSatisfiable()){
				System.out.println("Feature model not satisfiable");
				System.exit(0);
			}
			
			// Convert
			Integer[] solinteger = ca.getRow(n);
			int[] sol = new int[solinteger.length];
			for(int i = 0; i < sol.length; i++){
				//System.out.println("Cannot find \""+ca.nrid.get(i+1)+"\"");
				sol[i] = cnf.getNr(ca.getId(i+1));
				if(solinteger[i]==1) sol[i] = -sol[i];
			}
			IVecInt assumps = new VecInt(sol);
			//System.out.println(assumps);
			//System.out.println(n + ", " + assumps.size());
			
			// Test
			if(!solver.solver.isSatisfiable(assumps)){
				String out = "Solution invalid: " + n;
				out += "Reason: (";
				for(int x :solver.solver.unsatExplanation().toArray()){
					out += ((x<0)?"-":"") + cnf.getID(Math.abs(x)) + ", ";
				}
				out += ")";
				fail(out);
			}else{
				//System.out.println("Solution valid: " + n);
			}
		}
	}
	
	@Test
	public void verify2w_Chvatal() throws UnsupportedModelException, IOException, FeatureModelException, TimeoutException, org.sat4j.specs.TimeoutException, ContradictionException, CoveringArrayGenerationException{
		GUIDSL m1 = new GUIDSL(new File("TestData/Realistic/Apl.m"));
		SXFM fm = m1.getSXFM();
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("Chvatal", 2, 1);
		ca.generate();
		assertTrue(v.verify2w(cnf, ca));
		
		for(int n = 0; n < ca.getRowCount(); n++){
			SAT4JSolver solver = cnf.getSAT4JSolver();
			if(!solver.solver.isSatisfiable()){
				System.out.println("Feature model not satisfiable");
				System.exit(0);
			}
			
			// Convert
			Integer[] solinteger = ca.getRow(n);
			int[] sol = new int[solinteger.length];
			for(int i = 0; i < sol.length; i++){
				//System.out.println("Cannot find \""+ca.nrid.get(i+1)+"\"");
				sol[i] = cnf.getNr(ca.getId(i+1));
				if(solinteger[i]==1) sol[i] = -sol[i];
			}
			IVecInt assumps = new VecInt(sol);
			//System.out.println(assumps);
			//System.out.println(n + ", " + assumps.size());
			
			// Test
			if(!solver.solver.isSatisfiable(assumps)){
				String out = "Solution invalid: " + n;
				out += "Reason: (";
				for(int x :solver.solver.unsatExplanation().toArray()){
					out += ((x<0)?"-":"") + cnf.getID(Math.abs(x)) + ", ";
				}
				out += ")";
				fail(out);
			}else{
				//System.out.println("Solution valid: " + n);
			}
		}
	}
	
	@Test
	public void verify2w_Chvatal3() throws UnsupportedModelException, IOException, FeatureModelException, TimeoutException, org.sat4j.specs.TimeoutException, ContradictionException, CoveringArrayGenerationException{
		SXFM fm = new SXFM("TestData/Realistic/car_fm.xml");
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("Chvatal", 2, 1);
		ca.generate();
		assertTrue(v.verify2w(cnf, ca));
		
		for(int n = 0; n < ca.getRowCount(); n++){
			SAT4JSolver solver = cnf.getSAT4JSolver();
			if(!solver.solver.isSatisfiable()){
				System.out.println("Feature model not satisfiable");
				System.exit(0);
			}
			
			// Convert
			Integer[] solinteger = ca.getRow(n);
			int[] sol = new int[solinteger.length];
			for(int i = 0; i < sol.length; i++){
				//System.out.println("Cannot find \""+ca.nrid.get(i+1)+"\"");
				sol[i] = cnf.getNr(ca.getId(i+1));
				if(solinteger[i]==1) sol[i] = -sol[i];
			}
			IVecInt assumps = new VecInt(sol);
			//System.out.println(assumps);
			//System.out.println(n + ", " + assumps.size());
			
			// Test
			if(!solver.solver.isSatisfiable(assumps)){
				String out = "Solution invalid: " + n;
				out += "Reason: (";
				for(int x :solver.solver.unsatExplanation().toArray()){
					out += ((x<0)?"-":"") + cnf.getID(Math.abs(x)) + ", ";
				}
				out += ")";
				fail(out);
			}else{
				//System.out.println("Solution valid: " + n);
			}
		}
	}
	
	@Test
	public void verify3w_Chvatal() throws UnsupportedModelException, IOException, FeatureModelException, TimeoutException, org.sat4j.specs.TimeoutException, ContradictionException, CoveringArrayGenerationException{
		SXFM fm = new SXFM("TestData/Realistic/aircraft_fm.xml");
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("Chvatal", 3, 1);
		ca.generate();
		assertTrue(v.verify3w(cnf, ca));
		
		for(int n = 0; n < ca.getRowCount(); n++){
			SAT4JSolver solver = cnf.getSAT4JSolver();
			if(!solver.solver.isSatisfiable()){
				System.out.println("Feature model not satisfiable");
				System.exit(0);
			}
			
			// Convert
			Integer[] solinteger = ca.getRow(n);
			int[] sol = new int[solinteger.length];
			for(int i = 0; i < sol.length; i++){
				//System.out.println("Cannot find \""+ca.nrid.get(i+1)+"\"");
				sol[i] = cnf.getNr(ca.getId(i+1));
				if(solinteger[i]==1) sol[i] = -sol[i];
			}
			IVecInt assumps = new VecInt(sol);
			//System.out.println(assumps);
			//System.out.println(n + ", " + assumps.size());
			
			// Test
			if(!solver.solver.isSatisfiable(assumps)){
				String out = "Solution invalid: " + n;
				out += "Reason: (";
				for(int x :solver.solver.unsatExplanation().toArray()){
					out += ((x<0)?"-":"") + cnf.getID(Math.abs(x)) + ", ";
				}
				out += ")";
				fail(out);
			}else{
				//System.out.println("Solution valid: " + n);
			}
		}
	}
	
	@Test
	public void verify4w_Chvatal() throws UnsupportedModelException, IOException, FeatureModelException, TimeoutException, org.sat4j.specs.TimeoutException, ContradictionException, CoveringArrayGenerationException{
		SXFM fm = new SXFM("TestData/Realistic/aircraft_fm.xml");
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("Chvatal", 4, 1);
		ca.generate();
		
		for(int n = 0; n < ca.getRowCount(); n++){
			SAT4JSolver solver = cnf.getSAT4JSolver();
			if(!solver.solver.isSatisfiable()){
				System.out.println("Feature model not satisfiable");
				System.exit(0);
			}
			
			// Convert
			Integer[] solinteger = ca.getRow(n);
			int[] sol = new int[solinteger.length];
			for(int i = 0; i < sol.length; i++){
				//System.out.println("Cannot find \""+ca.nrid.get(i+1)+"\"");
				sol[i] = cnf.getNr(ca.getId(i+1));
				if(solinteger[i]==1) sol[i] = -sol[i];
			}
			IVecInt assumps = new VecInt(sol);
			//System.out.println(assumps);
			//System.out.println(n + ", " + assumps.size());
			
			// Test
			if(!solver.solver.isSatisfiable(assumps)){
				String out = "Solution invalid: " + n;
				out += "Reason: (";
				for(int x :solver.solver.unsatExplanation().toArray()){
					out += ((x<0)?"-":"") + cnf.getID(Math.abs(x)) + ", ";
				}
				out += ")";
				fail(out);
			}else{
				//System.out.println("Solution valid: " + n);
			}
		}
	}
	
	@Test
	public void verify1w_Alg2() throws UnsupportedModelException, IOException, FeatureModelException, TimeoutException, CoveringArrayGenerationException{
		GUIDSL m1 = new GUIDSL(new File("TestData/Realistic/Apl.m"));
		SXFM fm = m1.getSXFM();
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("J11", 1, 4);
		ca.generate();
		assertTrue(v.verify1w(cnf, ca));
	}
	
	@Test
	public void verify2w_J11() throws UnsupportedModelException, IOException, FeatureModelException, TimeoutException, CoveringArrayGenerationException{
		GUIDSL m1 = new GUIDSL(new File("TestData/Realistic/Apl.m"));
		SXFM fm = m1.getSXFM();
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("J11", 2, 4);
		ca.generate();
		boolean isCovered = v.verify2w(cnf, ca);
		assertTrue(isCovered);
	}
	
	@Test
	public void verify2w_J11_2() throws UnsupportedModelException, IOException, FeatureModelException, TimeoutException, CoveringArrayGenerationException{
		SXFM fm = new SXFM("TestData/Realistic/Eshop-fm.xml");
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("J11", 2, 4);
		ca.generate();
/*		boolean isCovered = v.verify2w(cnf, ca);
		assertTrue(isCovered);
*/	}
	
	@Test
	public void verify3w_J11() throws UnsupportedModelException, IOException, FeatureModelException, TimeoutException, ContradictionException, org.sat4j.specs.TimeoutException, CoveringArrayGenerationException{
		SXFM fm = new SXFM("TestData/Realistic/car_fm.xml");
		CNF cnf = fm.getCNF();
		CoveringArray ca = cnf.getCoveringArrayGenerator("J11", 3, 1);
		ca.generate();
		boolean isCovered = v.verify3w(cnf, ca);
		assertTrue(isCovered);
		
		for(int n = 0; n < ca.getRowCount(); n++){
			SAT4JSolver solver = cnf.getSAT4JSolver();
			if(!solver.solver.isSatisfiable()){
				System.out.println("Feature model not satisfiable");
				System.exit(0);
			}
			
			// Convert
			Integer[] solinteger = ca.getRow(n);
			int[] sol = new int[solinteger.length];
			for(int i = 0; i < sol.length; i++){
				//System.out.println("Cannot find \""+ca.nrid.get(i+1)+"\"");
				sol[i] = cnf.getNr(ca.getId(i+1));
				if(solinteger[i]==1) sol[i] = -sol[i];
			}
			IVecInt assumps = new VecInt(sol);
			//System.out.println(assumps);
			//System.out.println(n + ", " + assumps.size());
			
			// Test
			if(!solver.solver.isSatisfiable(assumps)){
				String out = "Solution invalid: " + n;
				out += "Reason: (";
				for(int x :solver.solver.unsatExplanation().toArray()){
					out += ((x<0)?"-":"") + cnf.getID(Math.abs(x)) + ", ";
				}
				out += ")";
				fail(out);
			}else{
				//System.out.println("Solution valid: " + n);
			}
		}
	}
}
