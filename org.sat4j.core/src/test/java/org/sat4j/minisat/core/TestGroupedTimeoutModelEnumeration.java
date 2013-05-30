package org.sat4j.minisat.core;

import org.junit.Before;
import org.junit.Test;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.TimeoutException;
import org.sat4j.tools.ModelIterator;

public class TestGroupedTimeoutModelEnumeration {

	private ISolver solver;

	@Before
	public void tearDDown() throws ContradictionException {
		solver = new ModelIterator(SolverFactory.newDefault());
		IVecInt clause = new VecInt();
		for (int i = 1; i <= 1000; i++)
			clause.push(-i);
		solver.addClause(clause);
	}

	@Test(expected = TimeoutException.class, timeout = 2500)
	public void testTimeoutOnSeconds() throws TimeoutException {
		solver.setTimeout(2);
		while (solver.isSatisfiable()) {
			solver.model(); // needed to discard that solution
		}
	}

	@Test(expected = TimeoutException.class, timeout = 2500)
	public void testTimeoutOnMilliSeconds() throws TimeoutException {
		solver.setTimeoutMs(2000);
		while (solver.isSatisfiable()) {
			solver.model(); // needed to discard that solution
		}
	}

	@Test(expected = TimeoutException.class, timeout = 2500)
	public void testTimeoutOnConflicts() throws TimeoutException {
		solver.setTimeoutOnConflicts(1000);
		while (solver.isSatisfiable()) {
			solver.model(); // needed to discard that solution
		}
	}
}
