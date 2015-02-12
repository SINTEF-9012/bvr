package no.sintef.bvr.papyrusdiagram.adapter.test;

import static org.junit.Assert.*;

import java.util.List;

import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.test.common.utils.TestResourceHolder;
import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor;
import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor.IDProvider;

import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.FileEditorInput;
import org.junit.After;
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

	private TestProject testProject;

	private FileEditorInput vmFileinput;

	private IWorkbenchPage activePage;

	private IEditorPart thirdpartyEditor;

	private EObject eObject;

	private IBVREnabledEditor bvrEnabledEditor;

	private IEditorPart activeEditor;

	private List<?> editParts;

	// private FileEditorInput vmFileinput;

	@BeforeClass
	public static void setUpClass() {
		try {
			Platform.getBundle("no.sintef.bvr.papyrusdiagram.adapter").start();
		} catch (BundleException e) {
			e.printStackTrace();
			fail("Can not start adapter bundle");
		}
	}

	@Before
	public void setUp() throws Exception {
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

		assertTrue("can not find graphical elements", editParts.size() == 5);
		
	}

	@After
	public void tearDown() throws Exception {
		thirdpartyEditor.dispose();
		testProject.disposeTestProject();
	}

	@Test
	public void testSelectElements() {
		bvrEnabledEditor.selectObjects((List<Object>) editParts);
		
		List<Object> selectedParts = bvrEnabledEditor.getSelectedObjects();
		
		assertEquals("selected and grabbed elements do not match", editParts, selectedParts);
	}

}
