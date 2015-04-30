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
