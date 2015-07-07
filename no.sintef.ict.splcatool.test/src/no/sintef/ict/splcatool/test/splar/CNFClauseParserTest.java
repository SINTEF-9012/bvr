/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.ict.splcatool.test.splar;

import static org.junit.Assert.*;

import org.junit.Test;

import splar.core.constraints.parsing.CNFClauseParseException;
import splar.core.constraints.parsing.CNFClauseParser;

public class CNFClauseParserTest {

	@Test
	public void testCNFParserAtIsValid() {
		boolean flag = true;
		String cnfClaus = "~D@3 or C@2 or C@5";
		CNFClauseParser parser = new CNFClauseParser();
		try {
			parser.parse(cnfClaus);
		} catch (CNFClauseParseException e) {
			flag = false;
		}
		assertTrue("@ should be allowed in the clause", flag);
	}

}
