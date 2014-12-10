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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;

import splar.core.fm.FeatureModelException;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class ImproveW2Thread implements Runnable, ProgressReporter {
	
	private int t;
	private CoveringArray ca;
	private String fmFileName;
	private int threads;
	private String weightFileName;
	private double orgCov;
	private List<Improvement> l;
	private int begin;
	private int end;
	private CNF cnf;
	private long progress;

	ImproveW2Thread(CNF cnf, int t, CoveringArray ca,
			String fmFileName, int threads, String weightFileName,
			double orgCov, int begin, int end){
		this.cnf = cnf;
		this.t = t;
		this.ca = ca;
		this.fmFileName = fmFileName;
		this.threads = threads;
		this.weightFileName = weightFileName;
		this.orgCov = orgCov;
		l = new ArrayList<Improvement>();
		this.begin = begin;
		this.end = end;
		progress = 0;
	}
	
	public List<Improvement> getImprovements(){
		return l;
	}

	@Override
	public void run() {
		try {
			improve_weighted_2(cnf, t, ca, fmFileName, threads, weightFileName, orgCov);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void improve_weighted_2(CNF cnf, int t, CoveringArray ca,
			String fmFileName, int threads, String weightFileName,
			double orgCov)
			throws ContradictionException, TimeoutException,
			UnsupportedModelException, IOException, FeatureModelException,
			CSVException {
		
		// For each assignment in each row, change and re-measure the coverage.
		// Suggest the change with the highest increase in weight coverage.
		CoveringArrayFile caf = (CoveringArrayFile)ca;
		//System.out.println(caf.rows);
		
		for(int i = 0; i < caf.rows.size(); i++){
			for(int j = begin; j < end; j++){
				for(int k = j+1; k < caf.rows.get(i).size(); k++){
					// Change first
					int x = caf.rows.get(i).get(j);
					if(x == 1) x = 0;
					else if(x == 0) x = 1;
					caf.rows.get(i).set(j, x);
					
					// Change second
					int y = caf.rows.get(i).get(k);
					if(y == 1) y = 0;
					else if(y == 0) y = 1;
					caf.rows.get(i).set(k, y);
					
					boolean isValid = CALib.verifyCA(cnf, ca, false, new ArrayList<String>());
					
					if(isValid){
						//System.out.println(caf.rows);
						double newCov = CALib.calc_coverage_weighted(cnf, t, ca, fmFileName, threads, weightFileName, true);
						
						// store improvement
						if(newCov > orgCov){
							Improvement imp = new Improvement2(newCov, i, caf.getId(j+1), caf.getId(k+1), (x==0?'X':'-'), (y==0?'X':'-'), (newCov-orgCov)/orgCov);
							l.add(imp);
						}
						
						//System.out.println("New coverage: " + newCov);
					}
					
					// Change back first
					if(x == 1) x = 0;
					else if(x == 0) x = 1;
					caf.rows.get(i).set(j, x);
					
					// Change back second
					if(y == 1) y = 0;
					else if(y == 0) y = 1;
					caf.rows.get(i).set(k, y);
					
					// Update progress
					progress++;
				}
			}
		}
	}

	@Override
	public long getProgress() {
		return progress;
	}

}
