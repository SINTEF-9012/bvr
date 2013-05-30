package org.sat4j.minisat.core;

import org.junit.Test;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.opt.MaxSatDecorator;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;
import org.sat4j.tools.ModelIterator;
import org.sat4j.tools.OptToSatAdapter;

public class BugFatih {

	@Test
	public void testBugReport() throws ContradictionException, TimeoutException {
		ISolver theSolver = SolverFactory.newDefault();
		ModelIterator solver = new ModelIterator(new OptToSatAdapter(
				new MaxSatDecorator(SolverFactory.newDefault())));
		System.out.println("Taille de voc : " + solver.nVars());
		solver.newVar(3);
		solver.setExpectedNumberOfClauses(3);
		solver.addClause(new VecInt(new int[] { 1, 2 }));
		solver.addClause(new VecInt(new int[] { 1, 3 }));
		solver.addClause(new VecInt(new int[] { 2, 3 }));
		System.out.println("Taille de voc : " + solver.nVars());
		if (solver.isSatisfiable()) {
			System.out.println("Taille du modèle : " + solver.model().length);
			for (int i = 1; i <= solver.model().length; i++) {
				System.out.print(solver.model(i) + " ");
			}
			System.out.println();
		}

		solver.reset();
		System.out.println("Taille de voc : " + solver.nVars());
		solver.newVar(2);
		solver.setExpectedNumberOfClauses(2);
		solver.addClause(new VecInt(new int[] { 1, 2 }));
		solver.addClause(new VecInt(new int[] { 2 }));
		System.out.println("Taille de voc : " + solver.nVars());
		if (solver.isSatisfiable()) {
			System.out.println("Taille du modèle : " + solver.model().length);
			for (int i = 1; i <= solver.model().length; i++) {
				System.out.print(solver.model(i) + " ");
			}
			System.out.println();
		}
		System.out.println("The End.");

	}
}
