package org.sat4j;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Test;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.reader.DimacsReader;
import org.sat4j.reader.InstanceReader;
import org.sat4j.reader.LecteurDimacs;
import org.sat4j.reader.ParseFormatException;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.TimeoutException;

public class BugSAT25 {

	@Test(expected = UnsupportedOperationException.class)
	public void testReaderFromInstanceReader() throws ParseFormatException,
			ContradictionException, IOException {
		String cnfString = "p cnf 3 4\n1 2 3 0\n-1 -2 0\n-1 -3 0\n-2 -3 0";
		InstanceReader reader = new InstanceReader(SolverFactory.newDefault());
		reader.parseInstance(new ByteArrayInputStream(cnfString.getBytes()));
		fail();
	}

	@Test
	public void testReaderFromDimacsReader() throws ParseFormatException,
			ContradictionException, IOException, TimeoutException {
		String cnfString = "p cnf 3 4\n1 2 3 0\n-1 -2 0\n-1 -3 0\n-2 -3 0";
		DimacsReader reader = new DimacsReader(SolverFactory.newDefault());
		IProblem problem = reader.parseInstance(new ByteArrayInputStream(
				cnfString.getBytes()));
		assertNotNull(problem);
		assertTrue(problem.isSatisfiable());
	}

	@Test
	public void testReaderFromLecteurDimacs() throws ParseFormatException,
			ContradictionException, IOException, TimeoutException {
		String cnfString = "p cnf 3 4\n1 2 3 0\n-1 -2 0\n-1 -3 0\n-2 -3 0";
		LecteurDimacs reader = new LecteurDimacs(SolverFactory.newDefault());
		IProblem problem = reader.parseInstance(new ByteArrayInputStream(
				cnfString.getBytes()));
		assertNotNull(problem);
		assertTrue(problem.isSatisfiable());
	}
}
