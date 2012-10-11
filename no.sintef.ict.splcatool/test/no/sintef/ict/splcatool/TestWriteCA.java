/*******************************************************************************
 * Copyright (c) 2011, 2012 SINTEF, Martin F. Johansen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SINTEF, Martin F. Johansen - the implementation
 *******************************************************************************/

package no.sintef.ict.splcatool;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.CoveringArrayFile;
import no.sintef.ict.splcatool.FileUtility;

import org.junit.Test;

public class TestWriteCA {
	@Test
	public void testWriteCA2() throws IOException, TimeoutException, CSVException, CoveringArrayGenerationException{
		CNF cnf = new CNF("TestData/Artificial/test.dimacs", CNF.type.dimacs);
		CoveringArray ca = cnf.getCoveringArrayGenerator("J11", 2, 1);
		ca.generate();
		ca.writeToFile("test.csv");
		CoveringArray dupe = new CoveringArrayFile("test.csv");
		dupe.writeToFile("test2.csv");
		String f1 = new FileUtility().readFileAsString("test.csv");
		String f2 = new FileUtility().readFileAsString("test2.csv");
		assertEquals(f1.length(), f2.length());
		assertEquals(f1, f2);
	}
}
