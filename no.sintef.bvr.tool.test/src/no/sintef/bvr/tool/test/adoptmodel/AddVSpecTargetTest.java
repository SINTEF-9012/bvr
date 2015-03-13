/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June
 * 2007; you may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package no.sintef.bvr.tool.test.adoptmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import no.sintef.bvr.common.logging.ConsoleLogger;
import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.test.common.utils.TestResourceHolder;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.model.IIDProvider;
import no.sintef.bvr.tool.interfaces.model.IPostfixGenerator;
import no.sintef.bvr.tool.logging.impl.DefaultLogger;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.model.PostfixGeneratorFacade;
import no.sintef.bvr.tool.model.VSpecFacade;
import no.sintef.bvr.tool.test.Activator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bvr.BVRModel;
import bvr.Choice;
import bvr.Target;
import bvr.VSpec;

/**
 * @author anavas Run as JUnit Plug-in Test
 */
public class AddVSpecTargetTest {

	private static String[] testFolders = { "TestFolder", "TestFolder/vm" };

	private static TestResourceHolder[] resources = { new TestResourceHolder("/resources/vm/addvspectarget.bvr", "TestFolder/vm/addvspectarget.bvr") };

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

	private BVRModel bvrModel;

	private Choice choice;

	private Choice anotherChoice;

	@Before
	public void setUp() {
		VSpecFacade.eINSTANCE.choiceIDProvider = new DefaultIDProvider();
		VSpecFacade.eINSTANCE.classifierIDProvider = new DefaultIDProvider();
		PostfixGeneratorFacade.eINSTANCE.setPostfixGenerator(new IPostfixGenerator() {

			private int count = 0;

			@Override
			public String getPostfix() {
				return "@" + count++;
			}
		});

		transactionModel = Context.eINSTANCE.testBVRToolModel(resources[0].getiFile().getLocation().toFile());
		assertNotNull(transactionModel);

		bvrModel = transactionModel.getBVRModel();
		assertNotNull(bvrModel);
		assertTrue("model is not empty " + bvrModel.eContents(), bvrModel.eContents().size() == 0);

		choice = transactionModel.addChoice(bvrModel);
		assertNotNull(choice.getTarget());

		anotherChoice = transactionModel.addChoice(choice);
		assertNotNull(anotherChoice.getTarget());
	}

	@After
	public void tearDown() {
		Context.eINSTANCE.getBvrModels().clear();
		Context.eINSTANCE.getBvrViews().clear();
		Context.eINSTANCE.disposeModel(transactionModel);
		TransactionalEditingDomain.Registry.INSTANCE.remove("no.sintef.bvr.shared.EditingDomain");
	}

	@Test
	public void testDifferenTargets() {
		assertNotEquals("Choices should not point to the same targets", choice.getTarget(), anotherChoice.getTarget());
	}

	@Test
	public void testUpdateNames() {
		transactionModel.updateName(anotherChoice, choice.getTarget().getName());

		assertTrue("choice name was not changed properly: anotherChoice " + anotherChoice.getName() + ", targetName: " + choice.getTarget().getName(),
				anotherChoice.getName().startsWith(choice.getTarget().getName() + "@"));
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

	@Test
	public void testTargetVSpecMap() {
		Map<Target, Set<VSpec>> targetMap = transactionModel.getTargetVSpecMap();
		assertTrue("target map is of the wrong size " + targetMap, targetMap.size() == 2);

		Set<VSpec> vspecs = targetMap.get(choice.getTarget());
		assertTrue(vspecs != null && vspecs.size() == 1);
		assertEquals("Vspec references wrong target", choice, vspecs.iterator().next());

		vspecs = targetMap.get(anotherChoice.getTarget());
		assertTrue(vspecs != null && vspecs.size() == 1);
		assertEquals("VSpec references wrong target", anotherChoice, vspecs.iterator().next());
	}

	@Test
	public void testTargetVSpecMapSameTarget() {
		transactionModel.updateName(anotherChoice, choice.getTarget().getName());

		Map<Target, Set<VSpec>> targetMap = transactionModel.getTargetVSpecMap();
		assertTrue("target map is of the wrong size " + targetMap, targetMap.size() == 1);

		Set<VSpec> vspecs = targetMap.get(choice.getTarget());
		assertTrue(vspecs != null && vspecs.size() == 2);

		assertTrue("VSpec set does not contain expected vspec-> set:" + vspecs + " vspec:" + choice, vspecs.contains(choice));
		assertTrue("VSpec set does not contain expected vspec-> set:" + vspecs + " vspec:" + anotherChoice, vspecs.contains(anotherChoice));
	}

	@Test
	public void testTargetVSpecMapModelConsistency() {
		transactionModel.updateName(anotherChoice, choice.getTarget().getName());

		Map<Target, Set<VSpec>> targetMap = transactionModel.getTargetVSpecMap();
		assertTrue("target map is of the wrong size " + targetMap, targetMap.size() == 1);

		TreeIterator<EObject> iterator = bvrModel.eAllContents();
		List<EObject> targetList = new ArrayList<EObject>();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			if (eObject instanceof Target)
				targetList.add(eObject);
		}

		assertTrue(targetMap.size() == targetList.size());
		assertEquals("Target inconsistency", targetList.get(0), targetMap.keySet().iterator().next());
	}

	@Test
	public void testVSpecNaming() {
		assertEquals("Incorrect vspec name", "Choice0@0", choice.getName());
		assertEquals("Incorrect vspec name", "Choice1@1", anotherChoice.getName());
	}

	@Test
	public void testTargetNaming() {
		assertEquals("Incorrect target name", "Choice0", choice.getTarget().getName());
		assertEquals("Incorrect target name", "Choice1", anotherChoice.getTarget().getName());
	}

	@Test
	public void testVSpecRenaming() {
		transactionModel.updateName(anotherChoice, choice.getTarget().getName());

		assertEquals("Incorrect vspec name", "Choice0@0", choice.getName());
		assertEquals("Incorrect vspec name after renaming", "Choice0@2", anotherChoice.getName());

		assertEquals("Incorrect target name", "Choice0", choice.getTarget().getName());
		assertEquals("Incorrect target name", "Choice0", anotherChoice.getTarget().getName());
	}

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

}
