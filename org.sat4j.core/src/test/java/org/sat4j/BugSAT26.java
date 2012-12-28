package org.sat4j;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.reader.DimacsReader;
import org.sat4j.reader.ParseFormatException;
import org.sat4j.reader.Reader;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IConstr;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;
import org.sat4j.tools.xplain.Xplain;

public class BugSAT26 {
	private Xplain<ISolver> xplain;

	@Before
	public void setUp() throws FileNotFoundException, ParseFormatException,
			IOException, ContradictionException {
		xplain = new Xplain<ISolver>(SolverFactory.newDefault());
		xplain.setTimeout(3600); // 1 hour timeout
		Reader reader = new DimacsReader(xplain);
		String dimacs = "src/test/testfiles/eb42.dimacs";
		reader.parseInstance(dimacs);
	}

	@Test
	public void testConsecutiveCallToSolver() throws ContradictionException,
			TimeoutException {
		assertTrue(xplain.isSatisfiable());
		int i = 0;
		while (i < 5) {
			VecInt assumption = new VecInt();
			assumption.push(1187);
			IConstr constr = xplain.addClause(assumption);
			xplain.removeConstr(constr);
			i++;
		}
	}
}
