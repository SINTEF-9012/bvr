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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import no.sintef.bvr.common.logging.ConsoleLogger;
import no.sintef.bvr.engine.common.ResourceContentCopier;
import no.sintef.bvr.engine.interfaces.common.IResourceContentCopier;
import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.test.common.utils.TestResourceHolder;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.common.IVarModelResolutionsCopier;
import no.sintef.bvr.tool.interfaces.model.IBVRSPLCAModelTransformator;
import no.sintef.bvr.tool.interfaces.model.IIDProvider;
import no.sintef.bvr.tool.interfaces.model.IPostfixGenerator;
import no.sintef.bvr.tool.logging.impl.DefaultLogger;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.model.PostfixGeneratorFacade;
import no.sintef.bvr.tool.model.TransfFacade;
import no.sintef.bvr.tool.model.VSpecFacade;
import no.sintef.bvr.tool.test.Activator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bvr.BVRModel;
import bvr.Choice;
import bvr.CompoundNode;
import bvr.Target;
import bvr.VSpec;

/**
 * @author anavas Run as JUnit Plug-in Test
 */
public class AddVSpecTargetTest {

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

	private static TestResourceHolder[] resources = { new TestResourceHolder("/resources/vm/addvspectarget.bvr", "TestFolder/vm/addvspectarget.bvr"),
			new TestResourceHolder("/resources/vm/addvspectarget_tosave.bvr", "TestFolder/vm/addvspectarget_tosave.bvr") };

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
		Context.eINSTANCE.getEditorCommands().disableBatchProcessing();
	}

	@Test
	public void testDifferenTargets() {
		assertNotEquals("Choices should not point to the same targets", choice.getTarget(), anotherChoice.getTarget());
	}

	@Test
	public void testUpdateNames() {
		transactionModel.updateName(anotherChoice, choice.getTarget().getName());

		assertEquals("Names do not match", choice.getTarget().getName(), anotherChoice.getName());
		assertEquals("Names do not match", choice.getTarget().getName(), choice.getName());

		IBVRSPLCAModelTransformator transformator = TransfFacade.eINSTANCE.getSPLCATransformator(bvrModel);
		CompoundNode transformed = transformator.transformVarModelToSPLCA();
		assertNotNull(transformed);
		IVarModelResolutionsCopier copier = transformator.getModelCopier();
		assertNotNull(copier);

		Choice copiedChoice = (Choice) ((Map) copier).get(choice);
		Choice copiedAnotherChoice = (Choice) ((Map) copier).get(anotherChoice);

		assertTrue("choice name was not changed properly: anotherChoice " + copiedAnotherChoice.getName() + ", targetName: " + choice.getTarget().getName(),
				copiedAnotherChoice.getName().startsWith(choice.getTarget().getName() + "@"));
		assertFalse("choices' name should be unique in vspec tree", copiedAnotherChoice.getName().equals(copiedChoice.getName()));
		assertEquals("choices should reference the same target", choice.getTarget(), anotherChoice.getTarget());
	}

	@Test
	public void testUpdateNamesBatch() {
		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		transactionModel.updateName(anotherChoice, choice.getTarget().getName());
		Context.eINSTANCE.getEditorCommands().executeBatch();

		assertEquals("Names do not match", choice.getTarget().getName(), anotherChoice.getName());
		assertEquals("Names do not match", choice.getTarget().getName(), choice.getName());

		IBVRSPLCAModelTransformator transformator = TransfFacade.eINSTANCE.getSPLCATransformator(bvrModel);
		CompoundNode transformed = transformator.transformVarModelToSPLCA();
		assertNotNull(transformed);
		IVarModelResolutionsCopier copier = transformator.getModelCopier();
		assertNotNull(copier);

		Choice copiedChoice = (Choice) ((Map) copier).get(choice);
		Choice copiedAnotherChoice = (Choice) ((Map) copier).get(anotherChoice);

		assertTrue("choice name was not changed properly: anotherChoice " + copiedAnotherChoice.getName() + ", targetName: " + choice.getTarget().getName(),
				copiedAnotherChoice.getName().startsWith(choice.getTarget().getName() + "@"));
		assertFalse("choices' name should be unique in vspec tree", copiedAnotherChoice.getName().equals(copiedChoice.getName()));
		assertEquals("choices should reference the same target", choice.getTarget(), anotherChoice.getTarget());
	}

	@Test
	public void testNumberTargets() {
		transactionModel.updateName(anotherChoice, choice.getTarget().getName());

		TreeIterator<EObject> iterator = bvrModel.eAllContents();
		List<EObject> list = new ArrayList<EObject>();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			if (eObject instanceof Target)
				list.add(eObject);
		}

		assertEquals("To many targets in the model or few", 2, list.size());
		list.remove(choice.getTarget());
		assertEquals("There should be one at least one not referenced target", 1, list.size());
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

		assertTrue(targetMap.size() + 1 == targetList.size());
		assertTrue("Target inconsistency", targetList.contains(targetMap.keySet().iterator().next()));
	}

	@Test
	public void testVSpecNaming() {
		assertEquals("Incorrect vspec name", "Choice0", choice.getName());
		assertEquals("Incorrect vspec name", "Choice1", anotherChoice.getName());

		IBVRSPLCAModelTransformator transformator = TransfFacade.eINSTANCE.getSPLCATransformator(bvrModel);
		CompoundNode transformed = transformator.transformVarModelToSPLCA();
		assertNotNull(transformed);
		IVarModelResolutionsCopier copier = transformator.getModelCopier();
		assertNotNull(copier);

		Choice copiedChoice = (Choice) ((Map) copier).get(choice);
		Choice copiedAnotherChoice = (Choice) ((Map) copier).get(anotherChoice);

		assertEquals("Incorrect vspec name", "Choice0@0", copiedChoice.getName());
		assertEquals("Incorrect vspec name", "Choice1@1", copiedAnotherChoice.getName());
	}

	@Test
	public void testTargetNaming() {
		assertEquals("Incorrect target name", "Choice0", choice.getTarget().getName());
		assertEquals("Incorrect target name", "Choice1", anotherChoice.getTarget().getName());
	}

	@Test
	public void testVSpecRenaming() {
		transactionModel.updateName(anotherChoice, choice.getTarget().getName());

		assertEquals("Incorrect vspec name", "Choice0", choice.getName());
		assertEquals("Incorrect vspec name after renaming", "Choice0", anotherChoice.getName());

		assertEquals("Incorrect target name", "Choice0", choice.getTarget().getName());
		assertEquals("Incorrect target name", "Choice0", anotherChoice.getTarget().getName());

		IBVRSPLCAModelTransformator transformator = TransfFacade.eINSTANCE.getSPLCATransformator(bvrModel);
		CompoundNode transformed = transformator.transformVarModelToSPLCA();
		assertNotNull(transformed);
		IVarModelResolutionsCopier copier = transformator.getModelCopier();
		assertNotNull(copier);

		Choice copiedChoice = (Choice) ((Map) copier).get(choice);
		Choice copiedAnotherChoice = (Choice) ((Map) copier).get(anotherChoice);

		assertEquals("Incorrect vspec name", "Choice0@0", copiedChoice.getName());
		assertEquals("Incorrect vspec name after renaming", "Choice0@1", copiedAnotherChoice.getName());

	}

	@Test
	public void appendVSpecSameName() {
		VSpecFacade.eINSTANCE.choiceIDProvider = new DefaultIDProvider();
		Choice thirdChoice = transactionModel.addChoice(anotherChoice);
		assertEquals("Icorrect name in the first place", "Choice0", thirdChoice.getName());

		assertEquals("VSpecs do not reference the same target, however they have the same prefix name", choice.getTarget(), thirdChoice.getTarget());

		Map<Target, Set<VSpec>> targetMap = transactionModel.getTargetVSpecMap();
		assertTrue("target map is of the wrong size " + targetMap, targetMap.size() == 2);

		Set<VSpec> vspecs = targetMap.get(choice.getTarget());
		assertTrue("Target is not references by two vspecs", vspecs.size() == 2);

		assertTrue("VSpec set does not contain expected vspec-> set:" + vspecs + " vspec:" + choice, vspecs.contains(choice));
		assertTrue("VSpec set does not contain expected vspec-> set:" + vspecs + " vspec:" + thirdChoice, vspecs.contains(thirdChoice));

		TreeIterator<EObject> iterator = bvrModel.eAllContents();
		List<EObject> targetList = new ArrayList<EObject>();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			if (eObject instanceof Target)
				targetList.add(eObject);
		}
		assertTrue("Inconsistence between what in the model and logic model method returns", targetMap.size() == targetList.size());
	}

	@Test
	public void testPosfixUnique() {
		PostfixGeneratorFacade.eINSTANCE.setPostfixGenerator(null);
		VSpecFacade.eINSTANCE.choiceIDProvider = new DefaultIDProvider();
		Choice onechoice = transactionModel.addChoice(choice);
		VSpecFacade.eINSTANCE.choiceIDProvider = new DefaultIDProvider();
		Choice secondchoice = transactionModel.addChoice(choice);

		IBVRSPLCAModelTransformator transformator = TransfFacade.eINSTANCE.getSPLCATransformator(bvrModel);
		CompoundNode transformed = transformator.transformVarModelToSPLCA();
		assertNotNull(transformed);
		IVarModelResolutionsCopier copier = transformator.getModelCopier();
		assertNotNull(copier);

		Choice copiedOnechoice = (Choice) ((Map) copier).get(onechoice);
		Choice copiedSecondchoice = (Choice) ((Map) copier).get(secondchoice);

		assertEquals("Targets should be the same", onechoice.getTarget(), secondchoice.getTarget());
		assertNotEquals("Postfix is unique", copiedOnechoice.getName(), copiedSecondchoice.getName());
	}

	@Test
	public void testChoiceUpdateAllNamedChanged() {
		transactionModel.updateName(anotherChoice, choice.getTarget().getName());
		assertEquals("Unexpected choice name", "Choice0", choice.getName());
		assertEquals("Base choice name should be equal since they point to the same target", "Choice0", anotherChoice.getName());

		// choices which are pointing to the same target should have the same
		// base choice name
		transactionModel.updateName(choice, "ChoiceChanged");
		assertTrue("Base choice name does not correspond to changed name", anotherChoice.getName().equals("ChoiceChanged"));
		assertTrue("Base choice name does not correspond to changed name", choice.getName().equals("ChoiceChanged"));

	}

	@Test
	public void testTargetsAtTheTop() {
		CompoundNode variabilityModel = bvrModel.getVariabilityModel();
		assertNotNull(variabilityModel);

		EList<Target> targets = variabilityModel.getOwnedTargets();
		assertTrue("Not all tragts are at the top of variability model", targets.size() == 2);

		assertTrue("can not find expected target in the list: target " + choice.getTarget() + " list: " + targets, targets.contains(choice.getTarget()));
		assertTrue("can not find expected target in the list: target " + anotherChoice.getTarget() + " list: " + targets,
				targets.contains(anotherChoice.getTarget()));
	}

	@Test
	public void testTargetsChangedProperlySaveTrivial() {
		BVRModel model = transactionModel.getBVRModel();
		Resource resource = model.eResource();

		HashMap<Resource, IResourceContentCopier> copyMap = new HashMap<Resource, IResourceContentCopier>();
		ResourceContentCopier copier = new ResourceContentCopier();
		copier.copyResource(resource);
		copyMap.put(resource, copier);

		Context.eINSTANCE.writeProductsToFiles(copyMap, resources[0].getiFile().getLocation().toFile());
	}

	@Test
	public void testTargetsChangedProperlySaveBug() {
		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		Choice thirdChoice = transactionModel.addChoice(choice);
		Context.eINSTANCE.getEditorCommands().executeBatch();

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		transactionModel.updateName(thirdChoice, anotherChoice.getTarget().getName());
		Context.eINSTANCE.getEditorCommands().executeBatch();

		assertEquals("Choices do not point to the same target", anotherChoice.getTarget(), thirdChoice.getTarget());
		assertTrue("Base name for choices referencing the same target are wrong : anotherChoice-->" + anotherChoice + ", thirdChoice-->" + thirdChoice
				+ " expected--> " + anotherChoice.getTarget().getName(), anotherChoice.getName().equals(anotherChoice.getTarget().getName())
				&& thirdChoice.getName().equals(anotherChoice.getTarget().getName()));

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		Choice fourthChoice = transactionModel.addChoice(choice);
		Context.eINSTANCE.getEditorCommands().executeBatch();

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		transactionModel.updateName(thirdChoice, fourthChoice.getTarget().getName());
		Context.eINSTANCE.getEditorCommands().executeBatch();

		BVRModel model = transactionModel.getBVRModel();
		Resource resource = model.eResource();

		HashMap<Resource, IResourceContentCopier> copyMap = new HashMap<Resource, IResourceContentCopier>();
		ResourceContentCopier copier = new ResourceContentCopier();
		copier.copyResource(resource);
		copyMap.put(resource, copier);

		try {
			Context.eINSTANCE.writeProductsToFiles(copyMap, resources[0].getiFile().getLocation().toFile());
		} catch (UnsupportedOperationException e) {
			assertTrue("Could not save vm due to " + e.getMessage(), false);
		}
	}

	@Test
	public void testRenameOneChoiceAnotherExistingTarget() {
		Target anotherTargetInitial = anotherChoice.getTarget();

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		Choice thirdChoice = transactionModel.addChoice(choice);
		Context.eINSTANCE.getEditorCommands().executeBatch();

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		transactionModel.updateName(thirdChoice, anotherChoice.getTarget().getName());
		Context.eINSTANCE.getEditorCommands().executeBatch();

		assertEquals("Choices do not point to the same target", anotherChoice.getTarget(), thirdChoice.getTarget());
		assertTrue("Base name for choices referencing the same target are wrong : anotherChoice-->" + anotherChoice + ", thirdChoice-->" + thirdChoice
				+ " expected--> " + anotherChoice.getTarget().getName(), anotherChoice.getName().equals(anotherChoice.getTarget().getName())
				&& thirdChoice.getName().equals(anotherChoice.getTarget().getName()));

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		Choice fourthChoice = transactionModel.addChoice(choice);
		Context.eINSTANCE.getEditorCommands().executeBatch();

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		transactionModel.updateName(thirdChoice, fourthChoice.getTarget().getName());
		Context.eINSTANCE.getEditorCommands().executeBatch();

		assertEquals("thirdChoice and fourthChoice should reference the same target", thirdChoice.getTarget(), fourthChoice.getTarget());
		assertNotEquals("anotherChoice and thirdChoice should NOT reference the same target", anotherChoice.getTarget(), thirdChoice.getTarget());
		assertEquals("anotherChoice should NOT change its target", anotherTargetInitial, anotherChoice.getTarget());
	}

	@Test
	public void testDoNotRemoveTargets() {
		CompoundNode variabilityModel = transactionModel.getBVRModel().getVariabilityModel();
		assertTrue(variabilityModel.getOwnedTargets().size() == 2);

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		Choice thirdChoice = transactionModel.addChoice(choice);
		Context.eINSTANCE.getEditorCommands().executeBatch();

		assertTrue(variabilityModel.getOwnedTargets().size() == 3);
		List<Target> bufferTargetList = new ArrayList<Target>(variabilityModel.getOwnedTargets());
		bufferTargetList.remove(choice.getTarget());
		bufferTargetList.remove(anotherChoice.getTarget());
		bufferTargetList.remove(thirdChoice.getTarget());
		assertTrue("There are targets which should be in the model " + bufferTargetList, bufferTargetList.size() == 0);

		Target thirdTragetInitial = thirdChoice.getTarget();
		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		transactionModel.updateName(thirdChoice, anotherChoice.getTarget().getName());
		Context.eINSTANCE.getEditorCommands().executeBatch();

		assertEquals("Some targets have been removed " + variabilityModel.getOwnedTargets(), 3, variabilityModel.getOwnedTargets().size());
		bufferTargetList = new ArrayList<Target>(variabilityModel.getOwnedTargets());
		bufferTargetList.remove(choice.getTarget());
		bufferTargetList.remove(anotherChoice.getTarget());
		bufferTargetList.remove(thirdChoice.getTarget());
		assertTrue("There should one target which is not used by any choice " + bufferTargetList, bufferTargetList.size() == 1);
		assertEquals("Wrong target left", thirdTragetInitial, bufferTargetList.get(0));

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		Choice fourthChoice = transactionModel.addChoice(choice);
		Context.eINSTANCE.getEditorCommands().executeBatch();

		assertEquals("Some targets have been removed " + variabilityModel.getOwnedTargets(), 4, variabilityModel.getOwnedTargets().size());
		bufferTargetList = new ArrayList<Target>(variabilityModel.getOwnedTargets());
		bufferTargetList.remove(choice.getTarget());
		bufferTargetList.remove(anotherChoice.getTarget());
		bufferTargetList.remove(thirdChoice.getTarget());
		bufferTargetList.remove(fourthChoice.getTarget());
		assertTrue("There should one target which is not used by any choice " + bufferTargetList, bufferTargetList.size() == 1);
		assertEquals("Wrong target left", thirdTragetInitial, bufferTargetList.get(0));

		Target fourthTragetInitial = fourthChoice.getTarget();
		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		transactionModel.updateName(fourthChoice, anotherChoice.getTarget().getName());
		Context.eINSTANCE.getEditorCommands().executeBatch();

		assertEquals("Some targets have been removed " + variabilityModel.getOwnedTargets(), 4, variabilityModel.getOwnedTargets().size());
		bufferTargetList = new ArrayList<Target>(variabilityModel.getOwnedTargets());
		bufferTargetList.remove(choice.getTarget());
		bufferTargetList.remove(anotherChoice.getTarget());
		bufferTargetList.remove(thirdChoice.getTarget());
		bufferTargetList.remove(fourthChoice.getTarget());
		assertTrue("There should one target which is not used by any choice " + bufferTargetList, bufferTargetList.size() == 2);
		bufferTargetList.remove(thirdTragetInitial);
		bufferTargetList.remove(fourthTragetInitial);
		assertTrue("Wrong target left " + bufferTargetList, bufferTargetList.size() == 0);
	}

	@Test
	public void testRenameOneChoiceTheSameTarget() {
		Target anotherTargetInitial = anotherChoice.getTarget();

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		Choice thirdChoice = transactionModel.addChoice(choice);
		Context.eINSTANCE.getEditorCommands().executeBatch();

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		transactionModel.updateName(thirdChoice, anotherChoice.getTarget().getName());
		Context.eINSTANCE.getEditorCommands().executeBatch();

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		Choice fourthChoice = transactionModel.addChoice(choice);
		Context.eINSTANCE.getEditorCommands().executeBatch();

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		transactionModel.updateName(thirdChoice, fourthChoice.getTarget().getName());
		Context.eINSTANCE.getEditorCommands().executeBatch();

		Target fourthTargetInitial = fourthChoice.getTarget();

		assertEquals("thirdChoice and fourthChoice should reference the same target", thirdChoice.getTarget(), fourthChoice.getTarget());
		assertEquals("fourthChoice should still referennce initial Target", fourthTargetInitial, fourthChoice.getTarget());
		assertNotEquals("anotherChoice and thirdChoice should NOT reference the same target", anotherChoice.getTarget(), thirdChoice.getTarget());

		assertEquals("anotherChoice should NOT change its target", anotherTargetInitial, anotherChoice.getTarget());

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		transactionModel.updateName(fourthChoice, "ChangeNameForThirdFourth");
		Context.eINSTANCE.getEditorCommands().executeBatch();

		assertEquals("anotherChoice should NOT change its target", anotherTargetInitial, anotherChoice.getTarget());
		assertEquals("thirdChoice should NOT change its target", fourthTargetInitial, thirdChoice.getTarget());
		assertEquals("fourthChoice should NOT change its target", fourthTargetInitial, fourthChoice.getTarget());
		assertEquals("thirdChoice and fourthChoice should STILL reference the same target", thirdChoice.getTarget(), fourthChoice.getTarget());

		assertTrue("Base name for choices referencing the same target are wrong : thirdChoice-->" + thirdChoice + ", fourthChoice-->" + fourthChoice
				+ " expected--> " + fourthTargetInitial.getName(), thirdChoice.getName().equals(fourthTargetInitial.getName())
				&& fourthChoice.getName().equals(fourthTargetInitial.getName()));

	}

	private Choice testStandard_createThirdChoiceBatch() {
		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		Choice thirdChoice = transactionModel.addChoice(choice);
		Context.eINSTANCE.getEditorCommands().executeBatch();
		return thirdChoice;
	}

	private void testStandard_TargetExistsAndIsReferencedByAnotherChoice(Choice thirdChoice, int target_size, String expected_base_name) {
		// String anotherChoiceBaseName = anotherChoice.getTarget().getName();
		Target anotherTarget = anotherChoice.getTarget();
		CompoundNode variabilityModel = transactionModel.getBVRModel().getVariabilityModel();

		Target thirdTraget = thirdChoice.getTarget();

		assertFalse(anotherChoice.getTarget().equals(thirdChoice.getTarget()));
		assertTrue(variabilityModel.getOwnedTargets().size() == 3);

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		transactionModel.updateName(thirdChoice, expected_base_name);
		Context.eINSTANCE.getEditorCommands().executeBatch();

		assertTrue("Target was modified...", variabilityModel.getOwnedTargets().size() == target_size);
		assertTrue("Choices should reference teh same target", anotherChoice.getTarget().equals(thirdChoice.getTarget()));
		assertEquals("Target has been changed", anotherTarget, anotherChoice.getTarget());

		assertTrue("Base name is incorrect expected-->" + expected_base_name + " actual-->" + anotherChoice.getName(),
				anotherChoice.getName().equals(expected_base_name));
		assertTrue("Base name is incorrect expected-->" + expected_base_name + " actual-->" + thirdChoice.getName(),
				thirdChoice.getName().equals(expected_base_name));

		assertTrue("Not referenced target was removed... " + variabilityModel.getOwnedTargets(), variabilityModel.getOwnedTargets().contains(thirdTraget));
	}

	@Test
	public void testRenameChoice_TargetExistsAndIsReferencedByAnotherChoice0() {
		// Target exists and referenced by choice0, we take choice1 and change
		// the name so it has the same name as choice0. Check
		// 1) that they reference the same targets,
		// 2) their base names are the same
		// 3) the target of the choice1, is not removed
		Choice thirdChoice = testStandard_createThirdChoiceBatch();
		testStandard_TargetExistsAndIsReferencedByAnotherChoice(thirdChoice, 3, anotherChoice.getTarget().getName());
	}

	@Test
	public void testRenameChoice_TargetExistsAndIsReferencedByAnotherChoice1() {
		// Target exists and referenced by choice0, we take choice1 and change
		// the name so it has the same name as choice0. Check
		// 1) that they reference the same targets,
		// 2) their base names are the same
		// 3) the target of the choice1, is not removed

		Choice thirdChoice = testStandard_createThirdChoiceBatch();
		Target thirdTargetInitial = thirdChoice.getTarget();
		testStandard_TargetExistsAndIsReferencedByAnotherChoice(thirdChoice, 3, anotherChoice.getTarget().getName());

		// Rename a choice which was name choice1 in the first place, so it
		// references the target which was in the model
		// 4) check that base name of the choice1
		// 5) choice1 should reference the old target
		// 6) choice0 should still reference its original target not the target
		// of choice1

		Target anotherTarget = anotherChoice.getTarget();
		CompoundNode variabilityModel = transactionModel.getBVRModel().getVariabilityModel();
		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		transactionModel.updateName(thirdChoice, thirdTargetInitial.getName());
		Context.eINSTANCE.getEditorCommands().executeBatch();

		assertTrue("Target was modified...", variabilityModel.getOwnedTargets().size() == 3);
		assertFalse("Choices should reference different targets", anotherChoice.getTarget().equals(thirdChoice.getTarget()));
		assertEquals("Target has been changed", anotherTarget, anotherChoice.getTarget());
		assertEquals("Choice do not reference initial target", thirdTargetInitial, thirdChoice.getTarget());

		assertTrue("Base name is incorrect expected-->" + anotherTarget.getName() + " actual-->" + anotherChoice.getName(),
				anotherChoice.getName().equals(anotherTarget.getName()));
		assertTrue("Base name is incorrect expected-->" + thirdTargetInitial.getName() + " actual-->" + thirdChoice.getName(),
				thirdChoice.getName().equals(thirdTargetInitial.getName()));
	}

	@Test
	public void testRenameChoice_TargetExistsAndIsReferencedByAnotherChoice2() {
		// Target exists and referenced by choice0, we take choice1 and change
		// the name so it has the same name as choice0. Check
		// 1) that they reference the same targets,
		// 2) their base names are the same
		// 3) the target of the choice1, is not removed
		// Rename one of the choices which references the same target to
		// something else which is not in the model

		Choice thirdChoice = testStandard_createThirdChoiceBatch();
		testStandard_TargetExistsAndIsReferencedByAnotherChoice(thirdChoice, 3, anotherChoice.getTarget().getName());

		// 4) check that amount of target is the same, target was not removed
		// but renamed, choice base names changed and the same

		String new_name = "ChangedName";
		CompoundNode variabilityModel = transactionModel.getBVRModel().getVariabilityModel();
		Target thirdTraget = thirdChoice.getTarget();
		Target anotherTarget = anotherChoice.getTarget();

		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
		transactionModel.updateName(thirdChoice, new_name);
		Context.eINSTANCE.getEditorCommands().executeBatch();

		assertTrue("Target was modified...", variabilityModel.getOwnedTargets().size() == 3);
		assertTrue("Choices should reference teh same target", anotherChoice.getTarget().equals(thirdChoice.getTarget()));
		assertEquals("Target has been changed", anotherTarget, anotherChoice.getTarget());

		assertTrue("Base name is incorrect expected-->" + new_name + " actual-->" + anotherChoice.getName(), anotherChoice.getName().equals(new_name));
		assertTrue("Base name is incorrect expected-->" + new_name + " actual-->" + anotherChoice.getName(), thirdChoice.getName().equals(new_name));

		assertTrue("Not referenced target was removed... " + variabilityModel.getOwnedTargets(), variabilityModel.getOwnedTargets().contains(thirdTraget));

	}
}
