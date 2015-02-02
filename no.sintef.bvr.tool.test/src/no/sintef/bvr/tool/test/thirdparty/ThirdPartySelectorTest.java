package no.sintef.bvr.tool.test.thirdparty;

import static org.junit.Assert.*;

import java.util.List;

import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.test.common.utils.TestResourceHolder;
import no.sintef.bvr.tool.common.ModelSelector;
import no.sintef.bvr.tool.context.ThirdpartyEditorSelector;
import no.sintef.bvr.tool.test.Activator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.FileEditorInput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bvr.BVRModel;
import bvr.BvrPackage;

public class ThirdPartySelectorTest {
	
	private TestProject testProject;
	private ModelSelector selector;
	private FileEditorInput vmFileinput;
	private IEditorPart thirdpartyEditor;
	private IWorkbenchPage activePage;

	
	private static String[] testFolders = {
		"TestFolder", "TestFolder/vm",
		"TestFolder/products", "TestFolder/exproducts"
	};
	
	private static TestResourceHolder[] testResources = {
		new TestResourceHolder("/resources/vm/VarModel.bvr", "/TestFolder/vm/VarModel.bvr"),
		
	};

	@Before
	public void setUp() throws Exception {
		testProject = new TestProject("ThirdPartySelector1", Activator.PLUGIN_ID);
		testProject.createFolders(testFolders);
		testProject.createResources(testResources);
		
		//open bvr editor
		vmFileinput = new FileEditorInput(testResources[0].getiFile());		
		activePage = testProject.getActionWorkbenchWindow().getActivePage();
		assertNotNull(activePage);
		thirdpartyEditor = activePage.openEditor(vmFileinput, "bvr.presentation.BvrEditorID", true);
		assertNotNull(thirdpartyEditor);
		
		//Open bvr file
		BvrPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		URI uri = URI.createPlatformResourceURI("/"+ testProject.getName() + testResources[0].getTarget(), true);
		Resource resource = resSet.getResource(uri, true);
		BVRModel model = (BVRModel) resource.getContents().get(0);
	
		//select element
		thirdpartyEditor.getSite().getSelectionProvider().setSelection(new StructuredSelection(model));
		
		//set up selector
		ThirdpartyEditorSelector.setWorkbeach(testProject.getActionWorkbenchWindow());
		selector = ThirdpartyEditorSelector.getEditorSelector();
	}

	@After
	public void tearDown() throws Exception {
		thirdpartyEditor.dispose();
		testProject.disposeTestProject();
	}

	/**
	 * Assertion: If we select one element in a tree edito then exactly one element should be returned as selected
	 */
	@Test
	public void testSelection() {
		List<Object> selection = selector.getSelections();
	
		assertTrue("Selection is made, but no object returned", selection.size() == 1);
	}

}
