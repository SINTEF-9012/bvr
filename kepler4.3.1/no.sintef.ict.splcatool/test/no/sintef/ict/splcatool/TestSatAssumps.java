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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.Pair;
import no.sintef.ict.splcatool.SAT4JSolver;
import no.sintef.ict.splcatool.SXFM;

import org.junit.Test;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.reader.LecteurDimacs;
import org.sat4j.reader.ParseFormatException;
import org.sat4j.reader.Reader;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.TimeoutException;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.fm.FeatureModelException;
import splar.plugins.reasoners.bdd.javabdd.BDDExceededBuildingTimeException;

public class TestSatAssumps {
	@Test
	public void testBug1() throws FeatureModelException, BDDExceededBuildingTimeException, TimeoutException{
		SXFM fm = new SXFM("TestData/Realistic/Eshop-fm.xml");
		CNF cnf = fm.getCNF();
		SAT4JSolver satSolver = null;
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException e) {
		}
		
		List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(cnf.getVariables());
		List<List<Integer>> solutions = new ArrayList<List<Integer>>();
		
		// Cover the uncovered
		// Check uncovered
		List<Pair> uncovered = new ArrayList<Pair>();
		for(BooleanVariableInterface v : vars){
			Pair p = new Pair();
			p.b = false;
			p.v = v;
			uncovered.add(p);
			p = new Pair();
			p.b = true;
			p.v = v;
			uncovered.add(p);
		}
		
		
		while(true){
			// Get solver
			
			// Cover as many as possible
			List<Pair> canBeSet = new ArrayList<Pair>();
			List<Pair> x = new ArrayList<Pair>(uncovered);
			Set<Integer> sol = new HashSet<Integer>();
			
			for(int i=0; i<x.size(); i++){
				SAT4JSolver satSolverOracle = null;
				try {
					satSolverOracle = cnf.getSAT4JSolver();
				} catch (ContradictionException e) {
				}

				
				Pair p = x.get(i);
				
				// Set it
				int varnr = (p.b?1:-1) * cnf.getNr(p.v.getID());
				
				// Check
				try {
					// Convert
					int assumpsArray[] = new int[sol.size()+1];
					int c = 0;
					for(int a : sol){
						assumpsArray[c] = a;
						c++;
					}
					assumpsArray[assumpsArray.length-1] = varnr;
					IVecInt assumps = new VecInt(assumpsArray);
					
					System.out.println(assumps);
					
					// Check
					if(satSolver.solver.isSatisfiable(assumps)){
						sol.add(varnr);
						canBeSet.add(p);
						uncovered.remove(p);
						//System.out.println("sat: " + varnr);
					}else{
						System.out.println("unsat: " + varnr + ", " + p.v.getID());
					}
					
					assertTrue(satSolverOracle.solver.isSatisfiable(assumps) == satSolver.solver.isSatisfiable(assumps));
				} catch (org.sat4j.specs.TimeoutException e1) {
				}
			}
			
			// Break of no more covered
			if(canBeSet.size() == 0){
				System.out.println("Breaking at " + uncovered.size() + " invalids");
				break;
			}else{
				System.out.println("Covered at " + (uncovered.size()+canBeSet.size()) + ", " + canBeSet.size());
				//System.out.println(canBeSet);
			}
			
			// Convert
			int assumpsArray[] = new int[sol.size()];
			int c = 0;
			for(int a : sol){
				assumpsArray[c] = a;
				c++;
			}
			IVecInt assumps = new VecInt(assumpsArray);

			// Solve
			try {
				satSolver.solver.isSatisfiable(assumps);
			} catch (org.sat4j.specs.TimeoutException e1) {
			}
			int[] s = satSolver.solver.model();
			
			List<Integer> solution = new ArrayList<Integer>();
			for(int i : s)
				solution.add(i);
			
			// Add solution
			solutions.add(solution);
		}
	}
	
	@Test
	public void testBug4() throws FeatureModelException, BDDExceededBuildingTimeException, TimeoutException{
		SXFM fm = new SXFM("TestData/Realistic/Eshop-fm.xml");
		CNF cnf = fm.getCNF();
		SAT4JSolver satSolver = null;
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException e) {
		}
		
		List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(cnf.getVariables());
		List<List<Integer>> solutions = new ArrayList<List<Integer>>();
		
		// Cover the uncovered
		// Check uncovered
		List<Pair> uncovered = new ArrayList<Pair>();
		for(BooleanVariableInterface v : vars){
			Pair p = new Pair();
			p.b = false;
			p.v = v;
			uncovered.add(p);
			p = new Pair();
			p.b = true;
			p.v = v;
			uncovered.add(p);
		}
		
		Set<Pair> mix = new HashSet<Pair>(uncovered);
		uncovered = new ArrayList<Pair>(mix);
		
		while(true){
			mix = new HashSet<Pair>(uncovered);
			uncovered = new ArrayList<Pair>(mix);
			Collections.shuffle(uncovered);
			
			// Cover as many as possible
			List<Pair> canBeSet = new ArrayList<Pair>();
			List<Pair> x = new ArrayList<Pair>(uncovered);
			Set<Integer> sol = new HashSet<Integer>();
			
			for(int i=0; i<x.size(); i++){
				SAT4JSolver satSolverOracle = null;
				try {
					satSolverOracle = cnf.getSAT4JSolver();
				} catch (ContradictionException e) {
				}

				
				Pair p = x.get(i);
				
				// Set it
				int varnr = (p.b?1:-1) * cnf.getNr(p.v.getID());
				
				// Check
				try {
					// Convert
					int assumpsArray[] = new int[sol.size()+1];
					int c = 0;
					for(int a : sol){
						assumpsArray[c] = a;
						c++;
					}
					assumpsArray[assumpsArray.length-1] = varnr;
					IVecInt assumps = new VecInt(assumpsArray);
					
					System.out.println(assumps);
					
					// Check
					if(satSolver.solver.isSatisfiable(assumps)){
						sol.add(varnr);
						canBeSet.add(p);
						uncovered.remove(p);
						//System.out.println("sat: " + varnr);
					}else{
						System.out.println("unsat: " + varnr + ", " + p.v.getID());
					}
					
					assertTrue(satSolverOracle.solver.isSatisfiable(assumps) == satSolver.solver.isSatisfiable(assumps));
				} catch (org.sat4j.specs.TimeoutException e1) {
				}
			}
			
			// Break of no more covered
			if(canBeSet.size() == 0){
				System.out.println("Breaking at " + uncovered.size() + " invalids");
				break;
			}else{
				System.out.println("Covered at " + (uncovered.size()+canBeSet.size()) + ", " + canBeSet.size());
				//System.out.println(canBeSet);
			}
			
			// Convert
			int assumpsArray[] = new int[sol.size()];
			int c = 0;
			for(int a : sol){
				assumpsArray[c] = a;
				c++;
			}
			IVecInt assumps = new VecInt(assumpsArray);

			// Solve
			try {
				satSolver.solver.isSatisfiable(assumps);
			} catch (org.sat4j.specs.TimeoutException e1) {
			}
			int[] s = satSolver.solver.model();
			
			List<Integer> solution = new ArrayList<Integer>();
			for(int i : s)
				solution.add(i);
			
			// Add solution
			solutions.add(solution);
		}
	}
	
	@Test
	public void testBug3() throws FileNotFoundException, ParseFormatException, IOException, ContradictionException{
		ISolver satSolver = SolverFactory.newDefault();
		Reader reader = new LecteurDimacs(satSolver);
		IProblem p = reader.parseInstance("TestData/Realistic/Eshop-fm.dimacs");
		
		List<Integer> uncovered = new ArrayList<Integer>();
		for(int i = 1; i <= p.nVars(); i++){
			uncovered.add(-i);
			uncovered.add(i);
		}
		
		List<Integer> canBeSet = new ArrayList<Integer>();
		Set<Integer> sol = new HashSet<Integer>();
		
		for(int i=0; i<uncovered.size(); i++){
			ISolver satSolverOracle = SolverFactory.newDefault();
			Reader readerOracle = new LecteurDimacs(satSolverOracle);
			readerOracle.parseInstance("TestData/Realistic/Eshop-fm.dimacs");
			
			// Set it
			int varnr = uncovered.get(i);
			
			// Check
			try {
				// Convert
				int assumpsArray[] = new int[sol.size()+1];
				int c = 0;
				for(int a : sol){
					assumpsArray[c] = a;
					c++;
				}
				assumpsArray[assumpsArray.length-1] = varnr;
				IVecInt assumps = new VecInt(assumpsArray);
				
				System.out.println(assumps);
				
				// Check
				if(satSolver.isSatisfiable(assumps)){
					sol.add(varnr);
					canBeSet.add(varnr);
				}else{
					System.out.println("unsat: " + varnr);
				}
				
				assertTrue(satSolverOracle.isSatisfiable(assumps) == satSolver.isSatisfiable(assumps));
			} catch (org.sat4j.specs.TimeoutException e1) {
			}
		}
	}
	
	@Test
	public void testBug() throws IOException, TimeoutException{
		CNF cnf = new CNF("TestData/Realistic/Eshop-fm.dimacs", CNF.type.dimacs);

		int x[][] = {
		{-1},
		{-1,1},
		/*unsat: 1, Reminders*/
		{-1,-2}, 
		{-2,-1,2}, 
		/*unsat: 2, Campaigns*/
		{-2,-1,-3}, 
		{-3,-2,-1,3}, 
		/*unsat: 3, Site_layout*/
		{-3,-2,-1,-4}, 
		{-4,-3,-2,-1,4}, 
		/*unsat: 4, Multiple_billing_addresses*/
		{-4,-3,-2,-1,-5}, 
		{-5,-4,-3,-2,-1,5}, 
		/*unsat: 5, Quality*/
		{-5,-4,-3,-2,-1,-6}, 
		{-6,-5,-4,-3,-2,-1,6}, 
		/*unsat: 6, _Demographics*/
		{-6,-5,-4,-3,-2,-1,-7}, 
		{-7,-6,-5,-4,-3,-2,-1,7}, 
		/*unsat: 7, Rate_factors*/
		{-7,-6,-5,-4,-3,-2,-1,-8}, 
		{-8,-7,-6,-5,-4,-3,-2,-1,8}, 
		/*unsat: 8, Custom_shipping_gateway*/
		{-8,-7,-6,-5,-4,-3,-2,-1,-9}, 
		{-9,-8,-7,-6,-5,-4,-3,-2,-1,9}, 
		/*unsat: 9, Dynamic_content*/
		{-9,-8,-7,-6,-5,-4,-3,-2,-1,-10}, 
		{-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,10}, 
		/*unsat: 10, Demographics*/
		{-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,-11}, 
		{-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,11}, 
		/*unsat: 11, Quality_of_service_selection*/
		{-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,-12}, 
		{-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,12}, 
		/*unsat: 12, Non-repudiation_service*/
		{-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,-13}, 
		/*unsat: -13, store_front*/
		{-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,13}, 
		{13,-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,-14}, 
		{13,-14,-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,14}, 
		/*unsat: 14, Product_and_quantity_scope*/
		{13,-14,-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,-15}, 
		{13,-15,-14,-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,15},
		/*unsat: 15, Pop-up_ads*/
		{13,-15,-14,-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,-16},
		{13,-16,-15,-14,-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,16},
		/*unsat: 16, Display_and_notification*/
		{13,-16,-15,-14,-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,-17}};
		
		SAT4JSolver satSolver = null;
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException e) {
		}
		
		for(int i = 0; i < x.length; i++){
			SAT4JSolver satSolver2 = null;
			try {
				satSolver2 = cnf.getSAT4JSolver();
			} catch (ContradictionException e) {
			}
			
			VecInt assumps = new VecInt(x[i]);
			assertTrue(satSolver.solver.isSatisfiable(assumps) == satSolver2.solver.isSatisfiable(assumps));
		}
	}
	
	@Test
	public void testBug2() throws IOException, TimeoutException{
		CNF cnf = new CNF("TestData/Realistic/Eshop-fm.dimacs", CNF.type.dimacs);
		SAT4JSolver satSolver = null;
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException e) {
		}


		int assumpsArray[] = new int[1];
		assumpsArray[0] = -101;
		IVecInt assumps = new VecInt(assumpsArray);
		assertFalse(satSolver.solver.isSatisfiable(assumps));
		
		assumpsArray[0] = 101;
		assumps = new VecInt(assumpsArray);
		
		assertTrue(satSolver.solver.isSatisfiable(assumps));
	}
}
