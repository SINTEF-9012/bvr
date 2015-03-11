package no.sintef.bvr.tool.test.adoptmodel;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.common.logging.ConsoleLogger;
import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.test.common.utils.TestResourceHolder;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.logging.impl.DefaultLogger;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.test.Activator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bvr.BVRModel;
import bvr.Choice;
import bvr.Target;
import bvr.TargetRef;

public class AddVSpecTargetTest {

	private static String[] testFolders = { "TestFolder", "TestFolder/vm" };

	private static TestResourceHolder[] resources = { new TestResourceHolder("/resources/vm/addvspectarget.bvr", "TestFolder/vm/addvspectarget.bvr") };

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

	private BVRToolModel transactionModel;

	private BVRModel bvrModel;

	private Choice choice;

	private Choice anotherChoice;

	@Before
	public void setUp() {
		transactionModel = Context.eINSTANCE.testBVRToolModel(resources[0].getiFile().getLocation().toFile());
		assertNotNull(transactionModel);

		bvrModel = transactionModel.getBVRModel();
		assertNotNull(bvrModel);
		assertTrue("model is not empty", bvrModel.eContents().size() == 0);

		choice = transactionModel.addChoice(bvrModel);
		assertNotNull(choice.getTarget());

		anotherChoice = transactionModel.addChoice(choice);
		assertNotNull(anotherChoice.getTarget());
	}

	@After
	public void tearDown() {
		Context.eINSTANCE.getBvrModels().clear();
		Context.eINSTANCE.getBvrViews().clear();
	}

	@Test
	public void testDifferenTargets() {
		assertNotEquals("Choices should not point to the same targets", choice.getTarget(), anotherChoice.getTarget());
	}

	@Test
	public void testUpdateNames() {
		transactionModel.updateName(anotherChoice, choice.getTarget().getName());

		assertTrue("choice name was not changed properly", anotherChoice.getName().startsWith(choice.getTarget().getName() + "@"));
		assertFalse("choices' name should be unique in vspec tree", anotherChoice.getName().equals(choice.getName()));
		assertEquals("choices should reference the same target", choice.getTarget(), anotherChoice.getTarget());
	}

	@Test
	public void testNumberTragtes() {
		transactionModel.updateName(anotherChoice, choice.getTarget().getName());

		TreeIterator<EObject> iterator = bvrModel.eAllContents();
		List<EObject> list = new ArrayList<EObject>();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			if (eObject instanceof Target)
				list.add(eObject);
		}

		assertTrue("To many targets in the model", list.size() == 1);
		assertEquals("Wrong target is referenced", choice.getTarget(), list.get(0));
	}

}
