package no.sintef.bvr.tool.test.thirdparty;

import static org.junit.Assert.*;

import java.util.List;

import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.tool.common.ModelSelector;
import no.sintef.bvr.tool.context.ThirdpartyEditorSelector;
import no.sintef.bvr.tool.test.Activator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ThirdPartySelectorTest {
	
	private TestProject testProject;
	private ModelSelector selector;

	@Before
	public void setUp() throws Exception {
		testProject = new TestProject("ThirdPartySelector1", Activator.PLUGIN_ID);
		ThirdpartyEditorSelector.setWorkbeach(testProject.getActionWorkbenchWindow());
		selector = ThirdpartyEditorSelector.getEditorSelector();
		
	}

	@After
	public void tearDown() throws Exception {
		testProject.disposeTestProject();
	}

	@Test
	public void test() {
		List<Object> selection = selector.getSelections();
		
		assertTrue("Selection is made, but no object returned", selection.size() > 0);
	}

}
