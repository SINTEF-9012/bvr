package no.sintef.cvl.ui.loader;

import java.io.File;
import java.io.IOException;

import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.primitive.SymbolTable;
import no.sintef.cvl.ui.strategy.impl.RRComposerStrategy;
import no.sintef.cvl.ui.strategy.impl.RealizationStrategyBottomUp;
import no.sintef.cvl.ui.strategy.impl.ScopeResolverStrategyScopeable;
import no.sintef.test.common.TestProject;
import no.sintef.test.common.TestResourceHolder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

public class TrivialTest {

	private static TestProject testProject;
	private static String[] testFolders = {
			"TestFolder", "TestFolder/vm",
			"TestFolder/products", "TestFolder/expproducts"
		};
	private static TestResourceHolder[] testResources = {
		new TestResourceHolder("/test/resources/vm/differentPackages.cvl", "/TestFolder/vm/differentPackages.cvl"),
		new TestResourceHolder("/test/resources/different_packages_model.uml", "/TestFolder/different_packages_model.uml"),
		new TestResourceHolder("/test/resources/expproducts/product_different_packages_model.uml", "/TestFolder/expproducts/product_different_packages_model.uml"),
	};
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testProject = new TestProject("TrivialProjectTest");
		for(String folder : testFolders)
			testProject.createFolder(folder);
		for(TestResourceHolder resource : testResources){
			IFile iFile = testProject.copyFileFromPlugin(resource.getSource(), resource.getTarget());
			resource.setiFile(iFile);
		}
	}

	private RRComposerStrategy composer;
	private ScopeResolverStrategyScopeable scopeResolver;
	private RealizationStrategyBottomUp productResolver;
	
	@Before
	public void setUp() throws Exception {
		IWorkbenchWindow iWorkBenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		Context.eINSTANCE.setIWorkbenchWindow(iWorkBenchWindow);
		
		composer = new RRComposerStrategy();
		scopeResolver = new ScopeResolverStrategyScopeable();
		productResolver = new RealizationStrategyBottomUp();

	}

	@After
	public void tearDown() throws Exception {
		Context.eINSTANCE.getCvlModels().clear();
		Context.eINSTANCE.getCvlViews().clear();
		//testProject.disposeTestProject();
	}

	@Test
	public void outsideBoundaryElementsInDifferentPackages() throws IOException, CoreException {	
			File fileVarModel = testResources[0].getiFile().getLocation().toFile();
			CVLModel model = Context.eINSTANCE.loadModelFromFile(fileVarModel);
			ConfigurableUnit cu = model.getCU();
			VSpecResolution vSpecResolution = cu.getOwnedVSpecResolution().get(0);
			
			SymbolTable symbolTable = composer.buildSymbolTable(cu, vSpecResolution);
			scopeResolver.resolveScopes(symbolTable);
			productResolver.deriveProduct(symbolTable);
			
			IFile iProduct = testProject.iProject.getFile("/TestFolder/products/product");
			File fileProduct = iProduct.getLocation().toFile();
			Context.eINSTANCE.writeProductsToFiles(Context.eINSTANCE.getSubEngine().getCopiedBaseModels(), fileProduct);
			
			iProduct = testProject.iProject.getFile("/TestFolder/products/product_different_packages_model.uml");
			fileProduct = iProduct.getLocation().toFile();
			
			boolean isIdentical = TestProject.isIdentical(testResources[2].getiFile().getLocation().toFile().getAbsolutePath(), fileProduct.getAbsolutePath());
			Assert.assertTrue("derived and expected products are different", isIdentical);
	}

}
