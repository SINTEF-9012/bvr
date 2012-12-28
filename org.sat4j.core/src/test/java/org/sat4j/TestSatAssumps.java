package org.sat4j;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.reader.LecteurDimacs;
import org.sat4j.reader.ParseFormatException;
import org.sat4j.reader.Reader;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.TimeoutException;

public class TestSatAssumps {
	@Test
	public void testIterativeAssumptionCallsWithSet()
			throws FileNotFoundException, ParseFormatException, IOException,
			ContradictionException, TimeoutException {
		ISolver satSolver = SolverFactory.newDefault();
		Reader reader = new LecteurDimacs(satSolver);
		IProblem p = reader.parseInstance("src/test/testfiles/Eshop-fm.dimacs");

		List<Integer> vars = new ArrayList<Integer>();
		for (int i = 1; i <= p.nVars(); i++) {
			vars.add(-i);
			vars.add(i);
		}

		Set<Integer> sol = new HashSet<Integer>();

		for (int i = 0; i < vars.size(); i++) {
			ISolver satSolverOracle = SolverFactory.newDefault();
			Reader readerOracle = new LecteurDimacs(satSolverOracle);
			readerOracle.parseInstance("src/test/testfiles/Eshop-fm.dimacs");

			int varnr = vars.get(i);

			int assumpsArray[] = new int[sol.size() + 1];
			int c = 0;
			for (int a : sol) {
				assumpsArray[c] = a;
				c++;
			}
			assumpsArray[assumpsArray.length - 1] = varnr;
			IVecInt assumps = new VecInt(assumpsArray);

			System.out.println(assumps);

			// Check
			if (satSolver.isSatisfiable(assumps)) {
				sol.add(varnr);
			} else {
				System.out.println("unsat: " + varnr);
			}

			assertEquals(satSolverOracle.isSatisfiable(assumps),
					satSolver.isSatisfiable(assumps));
		}
	}

	@Test
	public void testIterativeAssumptionCallsWithList()
			throws FileNotFoundException, ParseFormatException, IOException,
			ContradictionException, TimeoutException {
		ISolver satSolver = SolverFactory.newDefault();
		Reader reader = new LecteurDimacs(satSolver);
		IProblem p = reader.parseInstance("src/test/testfiles/Eshop-fm.dimacs");

		List<Integer> vars = new ArrayList<Integer>();
		for (int i = 1; i <= p.nVars(); i++) {
			vars.add(-i);
			vars.add(i);
		}

		List<Integer> sol = new ArrayList<Integer>();

		for (int i = 0; i < vars.size(); i++) {
			ISolver satSolverOracle = SolverFactory.newDefault();
			Reader readerOracle = new LecteurDimacs(satSolverOracle);
			readerOracle.parseInstance("src/test/testfiles/Eshop-fm.dimacs");

			int varnr = vars.get(i);

			int assumpsArray[] = new int[sol.size() + 1];
			int c = 0;
			for (int a : sol) {
				assumpsArray[c] = a;
				c++;
			}
			assumpsArray[assumpsArray.length - 1] = varnr;
			IVecInt assumps = new VecInt(assumpsArray);

			System.out.println(assumps);

			// Check
			if (satSolver.isSatisfiable(assumps)) {
				sol.add(varnr);
			} else {
				System.out.println("unsat: " + varnr);
			}

			assertEquals(satSolverOracle.isSatisfiable(assumps),
					satSolver.isSatisfiable(assumps));
		}
	}

	@Test
	public void testIterativeCorrectWay() throws FileNotFoundException,
			ParseFormatException, IOException, ContradictionException,
			TimeoutException {
		ISolver satSolver = SolverFactory.newDefault();
		Reader reader = new LecteurDimacs(satSolver);
		IProblem p = reader.parseInstance("src/test/testfiles/Eshop-fm.dimacs");

		Set<Integer> sol = new HashSet<Integer>();

		for (int i = 1; i <= p.nVars(); i++) {
			ISolver satSolverOracle = SolverFactory.newDefault();
			Reader readerOracle = new LecteurDimacs(satSolverOracle);
			readerOracle.parseInstance("src/test/testfiles/Eshop-fm.dimacs");

			int assumpsArray[] = new int[sol.size() + 1];
			int c = 0;
			for (int a : sol) {
				assumpsArray[c] = a;
				c++;
			}
			assumpsArray[assumpsArray.length - 1] = -i;
			IVecInt assumps = new VecInt(assumpsArray);

			System.out.println(assumps);

			// Check
			assertEquals(satSolverOracle.isSatisfiable(assumps),
					satSolver.isSatisfiable(assumps));
			if (satSolver.isSatisfiable(assumps)) {
				sol.add(-i);
				continue;
			}
			assumpsArray[assumpsArray.length - 1] = i;
			System.out.println(assumps);
			satSolverOracle = SolverFactory.newDefault();
			readerOracle = new LecteurDimacs(satSolverOracle);
			readerOracle.parseInstance("src/test/testfiles/Eshop-fm.dimacs");
			assertEquals(satSolverOracle.isSatisfiable(assumps),
					satSolver.isSatisfiable(assumps));
			if (satSolver.isSatisfiable(assumps)) {
				sol.add(i);
			} else {
				System.out.println("unsat: " + i);
			}
		}
	}
}
