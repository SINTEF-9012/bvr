package org.sat4j;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;

public class BugSAT18 {

	private ISolver solver;

	@Before
	public void setup() throws ContradictionException {
		solver = SolverFactory.newDefault();
		solver.setTimeout(15);
		solver.addClause(new VecInt(new int[] { 1 }));
		solver.addClause(new VecInt(new int[] { -1, 2 }));
		solver.addClause(new VecInt(new int[] { -1, 3 }));
		solver.addClause(new VecInt(new int[] { -2, 1 }));
		solver.addClause(new VecInt(new int[] { -4, 1 }));
		solver.addClause(new VecInt(new int[] { -3, 1 }));
		solver.addClause(new VecInt(new int[] { -3, 5 }));
		solver.addClause(new VecInt(new int[] { -5, 3 }));
		solver.addClause(new VecInt(new int[] { 6 }));
		solver.addClause(new VecInt(new int[] { -7 }));
		solver.addClause(new VecInt(new int[] { 2, 5, 4, 6 }));

	}

	@Test
	public void testAll() throws ContradictionException, TimeoutException {

		assertFalse(solver.isSatisfiable(new VecInt(new int[] { 4, -3 })));
		assertFalse(solver.isSatisfiable(new VecInt(new int[] { 5, -3 })));

	}

	@Test
	public void testSingle1() throws ContradictionException, TimeoutException {

		assertFalse(solver.isSatisfiable(new VecInt(new int[] { 4, -3 })));

	}

	@Test
	public void testSingle2() throws ContradictionException, TimeoutException {

		assertFalse(solver.isSatisfiable(new VecInt(new int[] { 5, -3 })));

	}

}