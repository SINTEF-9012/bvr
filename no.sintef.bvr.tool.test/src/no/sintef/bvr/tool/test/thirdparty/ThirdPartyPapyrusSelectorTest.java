/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.test.thirdparty;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;

import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.test.common.utils.TestResourceHolder;
import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor;
import no.sintef.bvr.tool.common.ModelSelector;
import no.sintef.bvr.tool.context.ThirdpartyEditorSelector;
import no.sintef.bvr.tool.test.Activator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.FileEditorInput;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ThirdPartyPapyrusSelectorTest {

	private static TestProject testProject;
	private static ModelSelector selector;
	private static FileEditorInput vmFileinput;
	private static IEditorPart thirdpartyEditor;
	private static IWorkbenchPage activePage;
	private static EObject selectedEObject;

	private static String[] testFolders = { "TestFolder" };

	private static TestResourceHolder[] testResources = { new TestResourceHolder("/resources/model.uml", "/TestFolder/model.uml"),
			new TestResourceHolder("/resources/model.notation", "/TestFolder/model.notation"),
			new TestResourceHolder("/resources/model.di", "/TestFolder/model.di")

	};

	@BeforeClass
	public static void setUpClass() throws Exception {
		testProject = new TestProject("ThirdPartyPapyrusSelector1", Activator.PLUGIN_ID);
		testProject.closeWelcome();
		testProject.createFolders(testFolders);
		testProject.createResources(testResources);

		// open bvr editor
		vmFileinput = new FileEditorInput(testResources[2].getiFile());
		activePage = testProject.getActionWorkbenchWindow().getActivePage();
		assertNotNull(activePage);
		thirdpartyEditor = activePage.openEditor(vmFileinput, "no.sintef.bvr.papyrusdiagramadapter2.editors.PapyrusBVREditor", true);
		assertNotNull(thirdpartyEditor);

		// Open bvr file
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		URI uri = URI.createPlatformResourceURI("/" + testProject.getName() + testResources[0].getTarget(), true);
		Resource resource = resSet.getResource(uri, true);
		selectedEObject = resource.getContents().get(0).eContents().get(0);

		// set up selector
		ThirdpartyEditorSelector.setWorkbeach(testProject.getActionWorkbenchWindow());
		selector = ThirdpartyEditorSelector.getEditorSelector();
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		thirdpartyEditor.dispose();
		testProject.disposeTestProject();
	}

	@Before
	public void setUp() throws Exception {
		// ModelEditPart exactly ome element should be slected, i.e. opened a
		// tab with class diagram
		// TODO should be dome properly
		thirdpartyEditor.getSite().getSelectionProvider().setSelection(new StructuredSelection());
		List<Object> selection = selector.getSelections();
		assertTrue(selection.size() == 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Assertion: Test selection in the Papyrus adapter
	 */
	@Test
	public void testSelection() {
		// find corresponding graphical elements in the diagram
		IEditorPart activePapyrusDiagram = ((CoreMultiDiagramEditor) thirdpartyEditor).getActiveEditor();
		IDiagramGraphicalViewer gv = ((IDiagramWorkbenchPart) activePapyrusDiagram).getDiagramGraphicalViewer();

		List<?> editParts = gv.findEditPartsForElement(IBVREnabledEditor.IDProvider.getXMIId(selectedEObject), EditPart.class);

		assertTrue("Can not find papyrus diagram part corresponding to the object", editParts.size() != 0);

		// select element
		thirdpartyEditor.getSite().getSelectionProvider().setSelection(new StructuredSelection(editParts));
		List<Object> selection = selector.getSelections();
		assertTrue("Pre-defined selection does not correspond to actual selection", selection.size() == editParts.size());
		assertEquals("Pre-defined selection does not correspond to actual selection", selection, editParts);
	}

	@Test
	public void testSelectionEObject() {
		// find corresponding graphical elements in the diagram
		IEditorPart activePapyrusDiagram = ((CoreMultiDiagramEditor) thirdpartyEditor).getActiveEditor();
		IDiagramGraphicalViewer gv = ((IDiagramWorkbenchPart) activePapyrusDiagram).getDiagramGraphicalViewer();

		List<?> editParts = gv.findEditPartsForElement(IBVREnabledEditor.IDProvider.getXMIId(selectedEObject), EditPart.class);

		assertTrue("Can not find papyrus diagram part corresponding to the object", editParts.size() != 0);

		// select element
		thirdpartyEditor.getSite().getSelectionProvider().setSelection(new StructuredSelection(editParts));
		List<Object> selection = selector.getSelections();
		assertTrue("Pre-defined selection does not correspond to actual selection", selection.size() == editParts.size());
		assertEquals("Pre-defined selection does not correspond to actual selection", selection, editParts);

		HashSet<EObject> eObjects = new HashSet<EObject>();
		for (Object object : selection) {
			EObject eObject = selector.getEObject(object);
			if (eObject != null)
				eObjects.add(eObject);
		}

		assertTrue(eObjects.size() == 1);

		String expectedName = (String) selectedEObject.eGet(selectedEObject.eClass().getEStructuralFeature("name"));

		EObject eObject = eObjects.iterator().next();
		String actualName = (String) eObject.eGet(eObject.eClass().getEStructuralFeature("name"));

		assertEquals("Pre-defined selected eObject does not correspond to actual ", selectedEObject.eClass().getName(), eObject.eClass().getName());
		assertEquals("Pre-defined selected eObject does not correspond to actual ", expectedName, actualName);

	}
}
