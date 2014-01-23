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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.sat4j.specs.ContradictionException;

import splar.core.constraints.BooleanVariableInterface;

public class MandatoryAndDeadDetection {
	private CNF cnf;
	private Map<Integer, String> nrid;

	public MandatoryAndDeadDetection(CNF cnf, Map<Integer, String> nrid) {
		this.cnf = cnf;
		this.nrid = nrid;
	}
	
	public void findMandatoryAndDeadFeatures(List<BooleanVariableInterface> varsOrg, Set<BooleanVariableInterface> mandatory, Set<BooleanVariableInterface> dead) {
		List<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(varsOrg);
		
		// Threads for this task: run at full speed
		Runtime runtime = Runtime.getRuntime();        
        int threads = runtime.availableProcessors();
        System.out.println("Threads for this task: " + threads);
		
		// Find a first solution
        Set<BooleanVariableInterface> notmandatory = new HashSet<BooleanVariableInterface>();
        Set<BooleanVariableInterface> notdead = new HashSet<BooleanVariableInterface>();
		{
			SAT4JSolver satSolver = null;
			try {
				satSolver = cnf.getSAT4JSolver();
				satSolver.solver.isSatisfiable();
			} catch (ContradictionException e1) {
			} catch (org.sat4j.specs.TimeoutException e) {
			}
			int[] s = satSolver.solver.model();
			List<Integer> solution = new ArrayList<Integer>();
			for(int z : s)
				solution.add(z);
			
			for(int i=0;i<solution.size();i++){
				if(solution.get(i)<0){
					for(BooleanVariableInterface var : vars){
						if(var.getID().equals(nrid.get(new Integer(-solution.get(i)))))
							notmandatory.add(var);
					}
				}else{
					for(BooleanVariableInterface var : vars){
						if(var.getID().equals(nrid.get(new Integer(solution.get(i)))))
							notdead.add(var);
					}
				}
			}
			
			//System.out.println(negative + " and " + positive);
			//System.out.println(solution);
		}
		// Find inverse solution and then remove the inverse
		// This works because SAT4J seems to select the solution with the most falses
		{
			SAT4JSolver satSolver = null;
			try {
				satSolver = cnf.getSAT4JSolverInverse();
				satSolver.solver.isSatisfiable();
			} catch (ContradictionException e1) {
			} catch (org.sat4j.specs.TimeoutException e) {
			}
			int[] s = satSolver.solver.model();
			List<Integer> solution = new ArrayList<Integer>();
			for(int z : s)
				solution.add(z);
			
			for(int i=0;i<solution.size();i++){
				if(solution.get(i)>0){
					for(BooleanVariableInterface var : vars){
						if(var.getID().equals(nrid.get(new Integer(solution.get(i)))))
							notmandatory.add(var);
					}
				}else{
					for(BooleanVariableInterface var : vars){
						if(var.getID().equals(nrid.get(new Integer(-solution.get(i)))))
							notdead.add(var);
					}
				}
			}
			
			//System.out.println(negative + " and " + positive);
			//System.out.println(solution);
		}
		
		// Find mandatory features
		if(notmandatory.size()!=vars.size()){
			List<BooleanVariableInterface> varscand = new ArrayList<BooleanVariableInterface>(cnf.getVariables());
			varscand.removeAll(notmandatory);
			List<List<BooleanVariableInterface>> varSplit = new ArrayList<List<BooleanVariableInterface>>();
			int beg=0, range=varscand.size()/threads + 1;
			for(int i = 0; i < threads; i++){
				if(beg+range > varscand.size()) range = varscand.size() - beg;
				varSplit.add(varscand.subList(beg, beg+range));
				beg += range;
			}
	
			List<FMThread> fmts = new ArrayList<FMThread>();
			List<Thread> ts = new ArrayList<Thread>();
			for(int i = 0; i < threads; i++){
				FMThread fmt = new FMThread(cnf, varSplit.get(i));
				fmts.add(fmt);
				Thread t = new Thread(fmt);
				ts.add(t);
			}
			
			for(int i = 0; i < threads; i++){
				ts.get(i).start();
			}
			
			// Start monitoring thread
			List<ProgressReporter> prs = new ArrayList<ProgressReporter>(fmts);
			ProgressThread pt = new ProgressThread("Find mandatory", prs, varscand.size());
			Thread ptt = new Thread(pt);
			ptt.start();
			
			// Wait for all threads to finish
			for(int i = 0; i < threads; i++){
				try {
					ts.get(i).join();
				} catch (InterruptedException e) {
				}
			}
			
			// Stop monitoring
			pt.stop();
	
			// Collect
			for(int i = 0; i < threads; i++){
				mandatory.addAll(fmts.get(i).getMandatory());
			}
		}
		System.out.println("Mandatory features: " + mandatory.size());
		// Remove mandatory
		vars.removeAll(mandatory);
		
		// Find dead features
		//System.out.println(notdead.size() + " vs " + vars.size());
		if(notdead.size()!=vars.size()){
			List<BooleanVariableInterface> deadscand = new ArrayList<BooleanVariableInterface>(vars);
			deadscand.removeAll(notdead);
			List<List<BooleanVariableInterface>> varSplit = new ArrayList<List<BooleanVariableInterface>>();
			int beg=0, range=deadscand.size()/threads + 1;
			for(int i = 0; i < threads; i++){
				if(beg+range > deadscand.size()) range = deadscand.size() - beg;
				//total += vars.subList(beg, beg+range).size();
				//System.out.println(beg + " -> " + (beg+range));
				varSplit.add(deadscand.subList(beg, beg+range));
				beg += range;
			}
	
			List<FDThread> fmts = new ArrayList<FDThread>();
			List<Thread> ts = new ArrayList<Thread>();
			for(int i = 0; i < threads; i++){
				FDThread fmt = new FDThread(cnf, varSplit.get(i));
				fmts.add(fmt);
				Thread t = new Thread(fmt);
				ts.add(t);
			}
			
			for(int i = 0; i < threads; i++){
				ts.get(i).start();
			}
			
			// Start monitoring thread
			List<ProgressReporter> prs = new ArrayList<ProgressReporter>(fmts);
			ProgressThread pt = new ProgressThread("Find dead", prs, deadscand.size());
			Thread ptt = new Thread(pt);
			ptt.start();
			
			// Wait for all threads to finish
			for(int i = 0; i < threads; i++){
				try {
					ts.get(i).join();
				} catch (InterruptedException e) {
				}
			}
			
			// Stop monitoring
			pt.stop();
			
			// Collect
			for(int i = 0; i < threads; i++){
				dead.addAll(fmts.get(i).getDead());
			}
		}
		System.out.println("Dead features: " + dead.size());
		vars.removeAll(dead);
	}
}