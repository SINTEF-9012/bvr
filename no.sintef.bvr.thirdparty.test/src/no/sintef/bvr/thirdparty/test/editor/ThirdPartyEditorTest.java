package no.sintef.bvr.thirdparty.test.editor;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map.Entry;

import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.test.common.utils.TestResourceHolder;
import no.sintef.bvr.thirdparty.editor.BVRLabelProvider;
import no.sintef.bvr.thirdparty.editor.ProxyThirdPartyTreeEditor;
import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor;
import no.sintef.bvr.tool.common.ModelSelector;
import no.sintef.bvr.tool.context.ThirdpartyEditorSelector;
import no.sintef.bvr.thirdparty.test.Activator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bvr.BVRModel;
import bvr.BvrPackage;

public class ThirdPartyEditorTest {
	
	private static TestProject testProject;
	private static ModelSelector selector;
	private static FileEditorInput vmFileinput;
	private static IEditorPart thirdpartyEditor;
	private static IWorkbenchPage activePage;
	private static BVRModel model;

	
	private static String[] testFolders = {
		"TestFolder", "TestFolder/vm",
		"TestFolder/products", "TestFolder/exproducts"
	};
	
	private static TestResourceHolder[] testResources = {
		new TestResourceHolder("/resources/vm/VarModel.bvr", "/TestFolder/vm/VarModel.bvr"),
		
	};

	@BeforeClass
	public static void setUpClass() throws Exception {
		testProject = new TestProject("ThirdPartyEditorTest1", Activator.PLUGIN_ID);
		testProject.closeWelcome();
		testProject.createFolders(testFolders);
		testProject.createResources(testResources);
		
		
		//Open bvr file
		BvrPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		URI uri = URI.createPlatformResourceURI("/"+ testProject.getName() + testResources[0].getTarget(), true);
		Resource resource = resSet.getResource(uri, true);
		model = (BVRModel) resource.getContents().get(0);
		
		//set up selector
		ThirdpartyEditorSelector.setWorkbeach(testProject.getActionWorkbenchWindow());
		selector = ThirdpartyEditorSelector.getEditorSelector();

	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		testProject.disposeTestProject();
	}
	
	@Before
	public void setUp() throws Exception {
		//open Sample Ecore Model editor
		vmFileinput = new FileEditorInput(testResources[0].getiFile());		
		activePage = testProject.getActionWorkbenchWindow().getActivePage();
		assertNotNull(activePage);
		// org.eclipse.emf.ecore.presentation.EcoreEditorID
		// bvr.presentation.BvrEditorID
		thirdpartyEditor = activePage.openEditor(vmFileinput, "org.eclipse.emf.ecore.presentation.EcoreEditorID", true, IWorkbenchPage.MATCH_ID | IWorkbenchPage.MATCH_INPUT);
		assertNotNull(thirdpartyEditor);
	}
	
	@After
	public void tearDown() throws Exception {
		thirdpartyEditor.dispose();
	}
	
	/**
	 * Assertion: If we highlight elements then exactly these elements should be highlighted
	 */
	@Test
	public void testHighlightObjects() {
		HashMap<EObject, Integer> objects = new HashMap<EObject, Integer>();
		objects.put(model, IBVREnabledEditor.HL_PLACEMENT);
		EList<HashMap<EObject,Integer>> list = new BasicEList<HashMap<EObject,Integer>>();
		list.add(objects);
		
		ProxyThirdPartyTreeEditor editor = new ProxyThirdPartyTreeEditor((EditorPart) thirdpartyEditor);
		TreeViewer treeview = (TreeViewer) editor.getViewer();
		IBaseLabelProvider label = treeview.getLabelProvider();
		assertTrue("Incorrect label provider", label instanceof BVRLabelProvider);
		BVRLabelProvider bvrLabelProvider = (BVRLabelProvider) label;
		
		editor.highlightObject(model, IBVREnabledEditor.HL_PLACEMENT);
		
		HashMap<String, Integer> result = bvrLabelProvider.getObjectToHighlight();
		assertTrue("Exactly one element should be highlighted", result.size() == 1);
		
		Entry<String, Integer> item = result.entrySet().iterator().next();
		assertTrue(item.getKey().equals(IBVREnabledEditor.IDProvider.getObjectId(model)));
		assertTrue(item.getValue() == IBVREnabledEditor.HL_PLACEMENT);
	}
	
	/**
	 * Assertion: If we clean highlighted elements then not elements are highlighted
	 */
	@Test
	public void testCleanHighlightedObject() {
		HashMap<EObject, Integer> objects = new HashMap<EObject, Integer>();
		objects.put(model, IBVREnabledEditor.HL_PLACEMENT);
		EList<HashMap<EObject,Integer>> list = new BasicEList<HashMap<EObject,Integer>>();
		list.add(objects);
		
		ProxyThirdPartyTreeEditor editor = new ProxyThirdPartyTreeEditor((EditorPart) thirdpartyEditor);
		TreeViewer treeview = (TreeViewer) editor.getViewer();
		IBaseLabelProvider label = treeview.getLabelProvider();
		assertTrue("Incorrect label provider", label instanceof BVRLabelProvider);
		BVRLabelProvider bvrLabelProvider = (BVRLabelProvider) label;
		
		editor.highlightObject(model, IBVREnabledEditor.HL_PLACEMENT);
		
		HashMap<String, Integer> result = bvrLabelProvider.getObjectToHighlight();
		assertTrue("Exactly one element should be highlighted", result.size() == 1);
		
		editor.clearHighlighting();
		result = bvrLabelProvider.getObjectToHighlight();
		assertTrue("No objects highlighted", result.size() == 0);
		
	}
}
	

