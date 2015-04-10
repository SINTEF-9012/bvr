package no.sintef.bvr.constraints.test.strategy;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import no.sintef.bvr.common.logging.ConsoleLogger;
import no.sintef.bvr.constraints.test.Activator;
import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.test.common.utils.TestResourceHolder;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.UserInputError;
import no.sintef.bvr.tool.interfaces.model.IIDProvider;
import no.sintef.bvr.tool.interfaces.model.IPostfixGenerator;
import no.sintef.bvr.tool.logging.impl.DefaultLogger;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.model.PostfixGeneratorFacade;
import no.sintef.bvr.tool.model.VSpecFacade;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bvr.BCLConstraint;
import bvr.BVRModel;
import bvr.CompoundNode;
import bvr.Constraint;
import bvr.VSpec;

public class TestBVRToolBCLBuilderStrategy {

	private class DefaultIDProvider implements IIDProvider {

		private Integer count = 0;

		@Override
		public String getUnique() {
			String id = count.toString();
			count++;
			return id;
		}

		@Override
		public String toString() {
			return getUnique();
		}

	}

	private static String[] testFolders = { "TestFolder", "TestFolder/vm" };

	private static TestResourceHolder[] resources = { new TestResourceHolder("/resources/vmbase.bvr", "TestFolder/vm/vmbase.bvr") };

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

	private BVRToolModel transactionModel;

	@Before
	public void setUp() {
		VSpecFacade.eINSTANCE.choiceIDProvider = new DefaultIDProvider();
		VSpecFacade.eINSTANCE.classifierIDProvider = new DefaultIDProvider();
		PostfixGeneratorFacade.eINSTANCE.setPostfixGenerator(new IPostfixGenerator() {

			private int count = 0;
			private final String DELIMITER = "@";

			@Override
			public String getPostfix() {
				return "@" + count++;
			}

			@Override
			public String getPostfixDelimiter() {
				return DELIMITER;
			}

			@Override
			public String removePostfix(String str) {
				String[] strings = str.split(DELIMITER);
				return strings[0];
			}
		});

		transactionModel = Context.eINSTANCE.testBVRToolModel(resources[0].getiFile().getLocation().toFile());
		assertNotNull(transactionModel);
	}

	@After
	public void tearDown() {
		Context.eINSTANCE.getBvrModels().clear();
		Context.eINSTANCE.getBvrViews().clear();
		Context.eINSTANCE.disposeModel(transactionModel);
		TransactionalEditingDomain.Registry.INSTANCE.remove("no.sintef.bvr.shared.EditingDomain");
		Context.eINSTANCE.getEditorCommands().disableBatchProcessing();
	}

	@Test
	public void testAddTrivialConstraint() {
		BVRModel bvrModel = transactionModel.getBVRModel();
		assertNotNull(bvrModel);

		CompoundNode variabilityModel = bvrModel.getVariabilityModel();
		assertNotNull(variabilityModel);

		EList<Constraint> constraints = variabilityModel.getOwnedConstraint();
		assertTrue(constraints.size() == 0);

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		transactionModel.addBCLConstraint(variabilityModel);
		Context.eINSTANCE.getEditorCommands().executeBatch();

		constraints = variabilityModel.getOwnedConstraint();
		assertTrue("Constraint is not added", constraints.size() == 1);
		Constraint constraint = constraints.get(0);

		try {
			Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
			transactionModel.updateBCLConstraint((BCLConstraint) constraint, ((VSpec) variabilityModel).getTarget().getName());
			Context.eINSTANCE.getEditorCommands().executeBatch();
		} catch (UserInputError e) {
			assertTrue(e.getMessage(), false);
		}

	}
}
