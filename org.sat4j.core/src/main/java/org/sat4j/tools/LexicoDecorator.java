/*******************************************************************************
 * SAT4J: a SATisfiability library for Java Copyright (C) 2004-2008 Daniel Le Berre
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU Lesser General Public License Version 2.1 or later (the
 * "LGPL"), in which case the provisions of the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of the LGPL, and not to allow others to use your version of
 * this file under the terms of the EPL, indicate your decision by deleting
 * the provisions above and replace them with the notice and other provisions
 * required by the LGPL. If you do not delete the provisions above, a recipient
 * may use your version of this file under the terms of the EPL or the LGPL.
 * 
 * Based on the original MiniSat specification from:
 * 
 * An extensible SAT solver. Niklas Een and Niklas Sorensson. Proceedings of the
 * Sixth International Conference on Theory and Applications of Satisfiability
 * Testing, LNCS 2919, pp 502-518, 2003.
 *
 * See www.minisat.se for the original solver in C++.
 * 
 *******************************************************************************/
package org.sat4j.tools;

import java.util.ArrayList;
import java.util.List;

import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IConstr;
import org.sat4j.specs.IOptimizationProblem;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.IteratorInt;
import org.sat4j.specs.TimeoutException;

public class LexicoDecorator<T extends ISolver> extends SolverDecorator<T>
		implements IOptimizationProblem {

	protected final List<IVecInt> criteria = new ArrayList<IVecInt>();

	protected int currentCriterion = 0;

	private IConstr prevConstr;

	private int currentValue = -1;

	protected int[] prevfullmodel;
	protected boolean[] prevboolmodel;

	private boolean isSolutionOptimal;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LexicoDecorator(T solver) {
		super(solver);
	}

	public void addCriterion(IVecInt literals) {
		IVecInt copy = new VecInt(literals.size());
		literals.copyTo(copy);
		criteria.add(copy);
	}

	public boolean admitABetterSolution() throws TimeoutException {
		return admitABetterSolution(VecInt.EMPTY);
	}

	public boolean admitABetterSolution(IVecInt assumps)
			throws TimeoutException {
		isSolutionOptimal = false;
		if (decorated().isSatisfiable(assumps, true)) {
			prevboolmodel = new boolean[nVars()];
			for (int i = 0; i < nVars(); i++) {
				prevboolmodel[i] = decorated().model(i + 1);
			}
			calculateObjective();
			prevfullmodel = decorated().model();
			return true;
		}
		return manageUnsatCase();
	}

	private boolean manageUnsatCase() {
		if (currentCriterion < criteria.size() - 1) {
			if (prevConstr != null) {
				super.removeConstr(prevConstr);
				prevConstr = null;
			}
			try {
				super.addAtMost(criteria.get(currentCriterion), currentValue);
				super.addAtLeast(criteria.get(currentCriterion), currentValue);
			} catch (ContradictionException e) {
				throw new IllegalStateException(e);
			}
			if (isVerbose()) {
				System.out.println(getLogPrefix()
						+ "Found optimal criterion number "
						+ (currentCriterion + 1));
			}
			currentCriterion++;
			calculateObjective();
			return true;
		}
		if (isVerbose()) {
			System.out.println(getLogPrefix()
					+ "Found optimal solution for the last criterion ");
		}
		isSolutionOptimal = true;
		if (prevConstr != null) {
			super.removeConstr(prevConstr);
			prevConstr = null;
		}
		return false;
	}

	@Override
	public int[] model() {
		return prevfullmodel;
	}

	@Override
	public boolean model(int var) {
		return prevboolmodel[var - 1];
	}

	public boolean hasNoObjectiveFunction() {
		return false;
	}

	public boolean nonOptimalMeansSatisfiable() {
		return true;
	}

	public Number calculateObjective() {
		currentValue = evaluate();
		return currentValue;
	}

	public Number getObjectiveValue() {
		return currentValue;
	}

	public void forceObjectiveValueTo(Number forcedValue)
			throws ContradictionException {
		throw new UnsupportedOperationException();
	}

	public void discard() throws ContradictionException {
		discardCurrentSolution();

	}

	public void discardCurrentSolution() throws ContradictionException {
		if (prevConstr != null) {
			super.removeSubsumedConstr(prevConstr);
		}
		try {
			prevConstr = super.addAtMost(criteria.get(currentCriterion),
					currentValue - 1);
		} catch (ContradictionException c) {
			prevConstr = null;
			if (!manageUnsatCase()) {
				throw c;
			}
		}

	}

	private int evaluate() {
		int value = 0;
		int lit;
		for (IteratorInt it = criteria.get(currentCriterion).iterator(); it
				.hasNext();) {
			lit = it.next();
			if ((lit > 0 && prevboolmodel[lit - 1])
					|| (lit < 0 && !prevboolmodel[-lit - 1])) {
				value++;
			}
		}
		return value;
	}

	public boolean isOptimal() {
		return isSolutionOptimal;
	}

}
