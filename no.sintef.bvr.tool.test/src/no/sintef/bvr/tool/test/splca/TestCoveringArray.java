package no.sintef.bvr.tool.test.splca;

import static org.junit.Assert.fail;

import java.io.IOException;

import no.sintef.bvr.common.logging.ConsoleLogger;
import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.test.common.utils.TestResourceHolder;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.logging.impl.DefaultLogger;
import no.sintef.bvr.tool.test.Activator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCoveringArray {

	private static String[] testFolders = { "TestFolder" };

	private static TestResourceHolder[] resources = { new TestResourceHolder("/resources/vm/gen_product_src.bvr", "TestFolder/gen_product_src.bvr"),
			new TestResourceHolder("/resources/vm/gen_product_trg.bvr", "TestFolder/gen_product_trg.bvr") };

	/** The test project. */
	private static TestProject testProject;

	@BeforeClass
	public static void setUpClass() throws CoreException, IOException {
		Context.eINSTANCE.setIWorkbenchWindow(PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		Context.eINSTANCE.logger = new ConsoleLogger();
		Context.eINSTANCE.problemLogger = new DefaultLogger();
		testProject = new TestProject("AddVSpecTargetTest", Activator.PLUGIN_ID);
		testProject.closeWelcome();
		testProject.createFolders(testFolders);
		testProject.createResources(resources);
	}

	@AfterClass
	public static void tearDownClass() throws CoreException {
		testProject.disposeTestProject();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTrivialProductGenration() {
		fail("Not yet implemented");
	}

}
