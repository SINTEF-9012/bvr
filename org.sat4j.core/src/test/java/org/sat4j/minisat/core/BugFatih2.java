package org.sat4j.minisat.core;

import org.junit.Test;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.opt.MaxSatDecorator;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;
import org.sat4j.tools.ModelIterator;
import org.sat4j.tools.OptToSatAdapter;

public class BugFatih2 {

	@Test
	public void testBugReport() throws ContradictionException, TimeoutException {
		ModelIterator solver = new ModelIterator(new OptToSatAdapter(
				new MaxSatDecorator(SolverFactory.newDefault())));
		// MaxSatDecorator solver = new
		// MaxSatDecorator(SolverFactory.newDefault());
		System.out.println("Taille de voc : " + solver.nVars());
		solver.newVar(13);
		solver.setExpectedNumberOfClauses(24);
		solver.addClause(new VecInt(new int[] { -1 }));
		solver.addClause(new VecInt(new int[] { -2 }));
		solver.addClause(new VecInt(new int[] { -3, 4 }));
		solver.addClause(new VecInt(new int[] { -3, 5 }));
		solver.addClause(new VecInt(new int[] { -3, 6 }));
		solver.addClause(new VecInt(new int[] { -1, 7 }));
		solver.addClause(new VecInt(new int[] { -2, 6 }));
		solver.addClause(new VecInt(new int[] { -4, 3 }));
		solver.addClause(new VecInt(new int[] { -5, 3 }));
		solver.addClause(new VecInt(new int[] { -6, 3, 2 }));
		solver.addClause(new VecInt(new int[] { -7, 1 }));
		solver.addClause(new VecInt(new int[] { 3, -1, 8 }));
		solver.addClause(new VecInt(new int[] { -3, 1, 8 }));
		solver.addClause(new VecInt(new int[] { -3, -1, 9 }));
		solver.addClause(new VecInt(new int[] { -9 }));
		solver.addClause(new VecInt(new int[] { 1, -2, 10 }));
		solver.addClause(new VecInt(new int[] { -1, 2, 10 }));
		solver.addClause(new VecInt(new int[] { -1, -2, 11 }));
		solver.addClause(new VecInt(new int[] { -10 }));
		solver.addClause(new VecInt(new int[] { -11 }));
		solver.addClause(new VecInt(new int[] { 3, -1, 12 }));
		solver.addClause(new VecInt(new int[] { -3, 1, 12 }));
		solver.addClause(new VecInt(new int[] { -3, -1, 13 }));
		solver.addClause(new VecInt(new int[] { -13 }));
		System.out.println("Taille de voc : " + solver.nVars());
		if (solver.isSatisfiable()) {
			System.out.println("Taille du modèle : " + solver.model().length);
			for (int i = 1; i <= solver.model().length; i++) {
				System.out.print(solver.model(i) + " ");
			}
			System.out.println();
		}
	}
}
