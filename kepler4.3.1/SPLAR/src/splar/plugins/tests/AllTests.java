package splar.plugins.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import splar.plugins.configuration.tests.bdd.javabdd.BDDConfigurationEngineTest;
import splar.plugins.configuration.tests.sat.sat4j.SATConfigurationEngineTest;
import splar.plugins.reasoners.tests.bdd.javabdd.ReasoningWithBDDTest;
import splar.plugins.reasoners.tests.sat.sat4j.ReasoningWithSATTest;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for tests");
		//$JUnit-BEGIN$
/*		suite.addTestSuite(ReasoningWithSATTest.class);
		suite.addTestSuite(ReasoningWithBDDTest.class);
		suite.addTestSuite(SATConfigurationEngineTest.class);
		suite.addTestSuite(BDDConfigurationEngineTest.class);
*/		//$JUnit-END$
		return suite;
	}

}
