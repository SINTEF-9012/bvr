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

import java.io.FileNotFoundException;
import java.io.IOException;

import org.sat4j.minisat.SolverFactory;
import org.sat4j.reader.DimacsReader;
import org.sat4j.reader.ParseFormatException;
import org.sat4j.reader.Reader;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;
import org.sat4j.tools.SolutionCounter;

public class SAT4JSolver {
	ISolver solver;
	private SolutionCounter sc;
	private int timeout = 0;

	public SAT4JSolver(ISolver solver) {
		this.solver = solver;
	}

	public SAT4JSolver(String filename) throws FileNotFoundException, ParseFormatException, IOException, ContradictionException {
		solver = SolverFactory.newDefault();
		solver.setDBSimplificationAllowed(true);
        Reader reader = new DimacsReader(solver);
		reader.parseInstance(filename);
	}

	public void setTimeout(int t) {
		this.timeout = t;
		solver.setTimeout(t);
	}

	public boolean isSatisfiable() throws TimeoutException {
		return solver.isSatisfiable();
	}

	public int getSolutions() throws TimeoutException {
		sc = new SolutionCounter(solver);
		sc.setTimeout(timeout);
		return (int) sc.countSolutions();
	}

	public int getSolutionsLowerBound() {
		if(sc == null){
			sc = new SolutionCounter(solver);
			sc.setTimeout(timeout);
			try {
				sc.countSolutions();
			} catch (TimeoutException e) {
			}
		}
		return sc.lowerBound();
	}
}
