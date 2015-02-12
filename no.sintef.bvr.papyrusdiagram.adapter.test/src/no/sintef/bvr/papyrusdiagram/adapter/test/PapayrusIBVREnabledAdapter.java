package no.sintef.bvr.papyrusdiagram.adapter.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.test.common.utils.TestResourceHolder;
import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor;
import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor.IDProvider;

import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.FileEditorInput;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.framework.BundleException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;

public class PapayrusIBVREnabledAdapter {

	private static String[] testFolders = { "TestFolder" };

	private static TestResourceHolder[] testResources = {
			new TestResourceHolder("/resources/model.di",
					"/TestFolder/model.di"),
			new TestResourceHolder("/resources/model.notation",
					"/TestFolder/model.notation"),
			new TestResourceHolder("/resources/model.uml",
					"/TestFolder/model.uml")

	};

	private static TestProject testProject;

	private static FileEditorInput vmFileinput;

	private static IWorkbenchPage activePage;

	private static IEditorPart thirdpartyEditor;

	private static EObject eObject;

	private static IBVREnabledEditor bvrEnabledEditor;

	private static IEditorPart activeEditor;

	private static List<?> editParts;

	private static ArrayList<Object> papyrusParts;


	@BeforeClass
	public static void setUpClass() throws Exception {
		try {
			Platform.getBundle("no.sintef.bvr.papyrusdiagram.adapter").start();
		} catch (BundleException e) {
			e.printStackTrace();
			fail("Can not start adapter bundle");
		}
		
		testProject = new TestProject("PapayrusIBVREnabledAdapter", Activator.PLUGIN_ID);
		testProject.closeWelcome();
		testProject.createFolders(testFolders);
		testProject.createResources(testResources);

		vmFileinput = new FileEditorInput(testResources[0].getiFile());
		activePage = testProject.getActionWorkbenchWindow().getActivePage();
		assertNotNull(activePage);
		// org.eclipse.emf.ecore.presentation.EcoreEditorID
		// bvr.presentation.BvrEditorID
		thirdpartyEditor = activePage.openEditor(vmFileinput,
				"org.eclipse.papyrus.infra.core.papyrusEditor", true,
				IWorkbenchPage.MATCH_ID | IWorkbenchPage.MATCH_INPUT);
		assertNotNull(thirdpartyEditor);
		
		//load uml resource
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		URI uri = URI.createPlatformResourceURI("/" + testProject.getName() + testResources[2].getTarget(), true);
		Resource resource = resSet.getResource(uri, true);
		
		//we select an object with name Class1 in the model
		eObject = resource.getContents().get(0).eContents().get(0);
		assertNotNull(eObject);
		
		String name = (String) eObject.eGet(eObject.eClass().getEStructuralFeature("name"));
		assertEquals("Class1", name);
		
		//get adapter
		activeEditor = activePage.getActiveEditor();
		assertNotNull(activeEditor);

		bvrEnabledEditor = (IBVREnabledEditor) Platform
				.getAdapterManager().getAdapter(activeEditor,
						IBVREnabledEditor.class);
		assertNotNull("Can not find adapter for this editor", bvrEnabledEditor);
		
		//graphical elements to select
		PapyrusMultiDiagramEditor papyrusEditor = (PapyrusMultiDiagramEditor) activeEditor;
		
		IDiagramGraphicalViewer gv = ((IDiagramWorkbenchPart) papyrusEditor.getActiveEditor())
				.getDiagramGraphicalViewer();

		editParts = gv.findEditPartsForElement(
				IDProvider.getXMIId(eObject), EditPart.class);

		assertEquals("can not find graphical elements", 5, editParts.size());
		
		//papyrus parts
		papyrusParts = new ArrayList<Object>();
		for(Object object : editParts) {
			if(object instanceof IPapyrusEditPart)
				papyrusParts.add(object);
		}
		
		assertEquals("can not find papyrus graphical elements", 1, papyrusParts.size());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		thirdpartyEditor.dispose();
		testProject.disposeTestProject();
	}
	
	@Before
	public void setUp() {
		bvrEnabledEditor.selectObjects(new ArrayList<Object>());
		//diagram should be selected at least
		assertEquals(1, bvrEnabledEditor.getSelectedObjects().size());
	}

	@Test
	public void testSelectElements() {
		bvrEnabledEditor.selectObjects((List<Object>) editParts);
		
		List<Object> selectedParts = bvrEnabledEditor.getSelectedObjects();
		
		assertEquals("selected and grabbed elements do not match", editParts, selectedParts);
	}
	
	@Test
	public void testSelectElementsEmpty() {		
		bvrEnabledEditor.selectObjects((List<Object>) editParts);
		
		List<Object> selectedParts = bvrEnabledEditor.getSelectedObjects();
		
		assertEquals("selected and grabbed elements do not match", editParts, selectedParts);
		
		bvrEnabledEditor.selectObjects(new ArrayList<Object>());
		assertTrue("diselection does not work", bvrEnabledEditor.getSelectedObjects().size() == 1);
	}
	
	@Test
	public void testHighlight() {
		bvrEnabledEditor.highlightObject(eObject, IBVREnabledEditor.HL_PLACEMENT);
		
		assertTrue(papyrusParts.size() != 0);
		
		for(Object object : papyrusParts) {
			IPapyrusEditPart ep = (IPapyrusEditPart) object;
			Color color = ep.getPrimaryShape().getForegroundColor();
			
			assertEquals("Highlight color does not match for " + object, IBVREnabledEditor.PLACEMENT, color);
		}
	}
	

}
