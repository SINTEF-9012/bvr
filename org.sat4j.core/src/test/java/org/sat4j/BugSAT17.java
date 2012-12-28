package org.sat4j;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;

public class BugSAT17 {

	private ISolver solver;

	@Before
	public void setup() throws ContradictionException {
		solver = SolverFactory.newDefault();
		solver.addClause(new VecInt(new int[] { 1 }));
		solver.addClause(new VecInt(new int[] { 2 }));
	}

	@Test
	public void testAll() throws ContradictionException, TimeoutException {
		assertFalse(solver.isSatisfiable(new VecInt(new int[] { -2 })));
		assertFalse(solver.isSatisfiable(new VecInt(new int[] { 2, -2 })));
		assertFalse(solver.isSatisfiable(new VecInt(new int[] { 1, -2 })));
		assertTrue(solver.isSatisfiable(new VecInt(new int[] { 2, 1 })));
	}

	@Test
	public void testSingleLit() throws ContradictionException, TimeoutException {
		assertFalse(solver.isSatisfiable(new VecInt(new int[] { -2 })));
	}

	@Test
	public void testInconsistentLits() throws ContradictionException,
			TimeoutException {
		assertFalse(solver.isSatisfiable(new VecInt(new int[] { 2, -2 })));
	}

	@Test
	public void testTwoLits() throws ContradictionException, TimeoutException {
		assertFalse(solver.isSatisfiable(new VecInt(new int[] { 1, -2 })));
	}

	@Test
	public void testSameLits() throws ContradictionException, TimeoutException {
		assertTrue(solver.isSatisfiable(new VecInt(new int[] { 2, 1 })));
	}

	@Test
	public void testOneSameOneContradictory() throws ContradictionException,
			TimeoutException {
		assertFalse(solver.isSatisfiable(new VecInt(new int[] { 2, -1 })));
		assertFalse(solver.isSatisfiable(new VecInt(new int[] { -2 })));
	}

}
