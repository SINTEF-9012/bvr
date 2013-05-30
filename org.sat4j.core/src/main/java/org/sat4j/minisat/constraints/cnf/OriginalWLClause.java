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
package org.sat4j.minisat.constraints.cnf;

import org.sat4j.minisat.core.ILits;
import org.sat4j.minisat.core.UnitPropagationListener;
import org.sat4j.specs.IVecInt;

public final class OriginalWLClause extends WLClause {

	public OriginalWLClause(IVecInt ps, ILits voc) {
		super(ps, voc);
	}

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sat4j.minisat.constraints.cnf.WLClause#register()
	 */
	public void register() {
		assert lits.length > 1;
		voc.watch(lits[0] ^ 1, this);
		voc.watch(lits[1] ^ 1, this);
	}

	public boolean learnt() {
		return false;
	}

	public void setLearnt() {
		// do nothing
	}

	/**
	 * Creates a brand new clause, presumably from external data.
	 * 
	 * @param s
	 *            the object responsible for unit propagation
	 * @param voc
	 *            the vocabulary
	 * @param literals
	 *            the literals to store in the clause
	 * @return the created clause or null if the clause should be ignored
	 *         (tautology for example)
	 */
	public static OriginalWLClause brandNewClause(UnitPropagationListener s,
			ILits voc, IVecInt literals) {
		OriginalWLClause c = new OriginalWLClause(literals, voc);
		c.register();
		return c;
	}

	/**
	 * @since 2.1
	 */
	public void forwardActivity(double claInc) {
		activity += claInc;
	}

	/**
	 * @param claInc
	 */
	public void incActivity(double claInc) {

	}

}
