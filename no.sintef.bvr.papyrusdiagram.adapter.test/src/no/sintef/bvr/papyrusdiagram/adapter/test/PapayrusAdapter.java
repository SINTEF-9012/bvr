package no.sintef.bvr.papyrusdiagram.adapter.test;

import static org.junit.Assert.*;
import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.test.common.utils.TestResourceHolder;

import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor;

import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.FileEditorInput;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.framework.BundleException;

public class PapayrusAdapter {

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
		testProject = new TestProject("PapayrusAdapter1", Activator.PLUGIN_ID);
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
	}

	@After
	public void tearDown() throws Exception {
		thirdpartyEditor.dispose();
		testProject.disposeTestProject();
	}

	@Test
	public void testAdapterLoaded() {
		IEditorPart activeEditor = activePage.getActiveEditor();
		assertNotNull(activeEditor);

		IBVREnabledEditor bvrEnabledEditor = (IBVREnabledEditor) Platform
				.getAdapterManager().getAdapter(activeEditor,
						IBVREnabledEditor.class);

		assertNotNull("Can not find adapter for this editor", bvrEnabledEditor);
	}

}
