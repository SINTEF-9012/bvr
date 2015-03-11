package no.sintef.bvr.tool.test.adoptmodel;

import static org.junit.Assert.*;

import java.io.IOException;

import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.test.common.utils.TestResourceHolder;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.test.Activator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddVSpecTargetTest {
	
	private static String[] testFolders = {
		"TestFolder", "TestFolder/vm"
	};
	
	private static TestResourceHolder[] resources = {
		new TestResourceHolder("/resources/vm/addvspectarget.bvr", "TestFolder/vm/addvspectarget.bvr")
	};
	
	private static TestProject testProject;


	@BeforeClass
	public static void setUpClass() throws CoreException, IOException {
		Context.eINSTANCE.setIWorkbenchWindow(PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		testProject = new TestProject("AddVSpecTargetTest", Activator.PLUGIN_ID);
		testProject.closeWelcome();
		testProject.createFolders(testFolders);
		testProject.createResources(resources);
	}
	
	@AfterClass
	public static void tearDownClass() throws CoreException {
		testProject.disposeTestProject();
	}
	
	@After
	public void tearDown() {
		Context.eINSTANCE.getBvrModels().clear();
		Context.eINSTANCE.getBvrViews().clear();
	}

	@Test
	public void cerateChoiceTargetTest() {
		BVRToolModel transactionModel = Context.eINSTANCE.testBVRToolModel(resources[0].getiFile().getLocation().toFile());
		assertNotNull(transactionModel);
		
		fail("not implemented");
	}

}
