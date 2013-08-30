package no.sintef.cvl.ui.loader;

import static org.junit.Assert.*;

import no.sintef.test.common.TestProject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Another {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private TestProject testProject;

	@Before
	public void setUp() throws Exception {
		testProject = new TestProject("BottomUpResolverTest");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
