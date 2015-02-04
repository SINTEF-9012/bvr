package no.sintef.bvr.tool.test.thirdparty;

import static org.junit.Assert.*;

import java.util.List;

import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.tool.common.ModelSelector;
import no.sintef.bvr.tool.context.ThirdpartyEditorSelector;
import no.sintef.bvr.tool.test.Activator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ThirdPartySelectorNoEditorTest {
	
	private static TestProject testProject;
	private static ModelSelector selector;

	@BeforeClass
	public static void setUp() throws Exception {
		testProject = new TestProject("ThirdPartySelectorNoEditorTest1", Activator.PLUGIN_ID);
		testProject.closeWelcome();
		ThirdpartyEditorSelector.setWorkbeach(testProject.getActionWorkbenchWindow());
		selector = ThirdpartyEditorSelector.getEditorSelector();
		
	}

	@AfterClass
	public static void tearDown() throws Exception {
		testProject.disposeTestProject();
	}

	/**
	 * Assertion: If no editors aer opened then return 0 selected objects
	 */
	@Test
	public void test() {
		List<Object> selection = selector.getSelections();
		assertTrue("No selection, because there is no opened editor", selection.size()  == 0);
	}

}
