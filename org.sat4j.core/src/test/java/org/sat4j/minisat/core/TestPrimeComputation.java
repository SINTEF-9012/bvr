package org.sat4j.minisat.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.minisat.orders.PositiveLiteralSelectionStrategy;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.TimeoutException;

public class TestPrimeComputation {

	private Solver<DataStructureFactory> solver;

	@Before
	public void setUp() {
		solver = SolverFactory.newBestWL();
		solver.getOrder().setPhaseSelectionStrategy(
				new PositiveLiteralSelectionStrategy());
	}

	@Test
	public void testBasicImplicant() throws ContradictionException,
			TimeoutException {
		IVecInt clause = new VecInt();
		clause.push(1).push(-2).push(3);
		solver.addClause(clause);
		clause.clear();
		clause.push(-1).push(2).push(3);
		solver.addClause(clause);
		clause.clear();
		clause.push(1).push(2).push(-3);
		solver.addClause(clause);
		clause.clear();
		assertTrue(solver.isSatisfiable());
		int[] model = solver.model();
		System.out.println(new VecInt(model));
		assertEquals(3, model.length);
		int[] implicant = solver.primeImplicant();
		System.out.println(new VecInt(implicant));
		assertEquals(2, implicant.length);
	}

	@Test
	public void testOtherImplicant() throws ContradictionException,
			TimeoutException {
		IVecInt clause = new VecInt();
		clause.push(1).push(-2).push(3);
		solver.addClause(clause);
		clause.clear();
		clause.push(1).push(2).push(3);
		solver.addClause(clause);
		clause.clear();
		clause.push(1).push(2).push(-3);
		solver.addClause(clause);
		clause.clear();
		assertTrue(solver.isSatisfiable());
		int[] model = solver.model();
		System.out.println(new VecInt(model));
		assertEquals(3, model.length);
		int[] implicant = solver.primeImplicant();
		System.out.println(new VecInt(implicant));
		assertEquals(2, implicant.length);
		clause.push(1).push(-2).push(-3);
		solver.addBlockingClause(clause);
		assertTrue(solver.isSatisfiable());
		clause.clear();
		model = solver.model();
		System.out.println(new VecInt(model));
		assertEquals(3, model.length);
		implicant = solver.primeImplicant();
		System.out.println(new VecInt(implicant));
		assertEquals(1, implicant.length);
	}

	@Test
	public void testFolletExample() throws ContradictionException,
			TimeoutException {
		IVecInt clause = new VecInt();
		clause.push(1);
		solver.addClause(clause);
		clause.clear();
		clause.push(2).push(3);
		solver.addClause(clause);
		clause.clear();
		clause.push(3);
		solver.addClause(clause);
		clause.clear();
		assertTrue(solver.isSatisfiable());
		int[] model = solver.model();
		System.out.println(new VecInt(model));
		assertEquals(3, model.length);
		int[] implicant = solver.primeImplicant();
		System.out.println(new VecInt(implicant));
		assertEquals(2, implicant.length);
	}
}
