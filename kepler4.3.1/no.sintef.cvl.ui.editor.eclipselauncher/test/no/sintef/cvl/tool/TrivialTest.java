package no.sintef.cvl.tool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.primitive.Symbol;
import no.sintef.cvl.tool.primitive.SymbolTable;
import no.sintef.cvl.tool.strategy.impl.RRComposerStrategy;
import no.sintef.cvl.tool.strategy.impl.RealizationStrategyBottomUp;
import no.sintef.cvl.tool.strategy.impl.ScopeResolverStrategyScopeable;
import no.sintef.cvl.tool.ui.loader.CVLModel;
import no.sintef.test.common.TestProject;
import no.sintef.test.common.TestResourceHolder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.VSpecResolution;

public class TrivialTest {

	private static TestProject testProject;
	private static String[] testFolders = {
			"TestFolder", "TestFolder/vm",
			"TestFolder/products", "TestFolder/expproducts",
			"TestFolder/models20092013"
		};
	private static TestResourceHolder[] testResources = {
		new TestResourceHolder("/test/resources/vm/differentPackages.cvl", "/TestFolder/vm/differentPackages.cvl"),
		new TestResourceHolder("/test/resources/different_packages_model.uml", "/TestFolder/different_packages_model.uml"),
		new TestResourceHolder("/test/resources/expproducts/product_different_packages_model.uml", "/TestFolder/expproducts/product_different_packages_model.uml"),
		
		new TestResourceHolder("/test/resources/vm/containmentLessPlacements.cvl", "/TestFolder/vm/containmentLessPlacements.cvl"),
		new TestResourceHolder("/test/resources/models20092013/modeladjacenttest.uml", "/TestFolder/models20092013/modeladjacenttest.uml"),
		new TestResourceHolder("/test/resources/expproducts/contLesExp_modeladjacenttest.uml", "/TestFolder/expproducts/contLesExp_modeladjacenttest.uml"),
		
		new TestResourceHolder("/test/resources/vm/additiveAdjacentContLessPlacements.cvl", "/TestFolder/vm/additiveAdjacentContLessPlacements.cvl"),
		new TestResourceHolder("/test/resources/expproducts/additiveAdjacentContLessPlacements_modeladjacenttest.uml", "/TestFolder/expproducts/additiveAdjacentContLessPlacements_modeladjacenttest.uml"),
		
		new TestResourceHolder("/test/resources/vm/additiveAdjacentContLessPlacements1.cvl", "/TestFolder/vm/additiveAdjacentContLessPlacements1.cvl"),
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
	
	@Test
	public void containmentLessPlacements() throws IOException, CoreException {	
			File fileVarModel = testResources[3].getiFile().getLocation().toFile();
			CVLModel model = Context.eINSTANCE.loadModelFromFile(fileVarModel);
			ConfigurableUnit cu = model.getCU();
			VSpecResolution vSpecResolution = cu.getOwnedVSpecResolution().get(0);
			
			SymbolTable symbolTable = composer.buildSymbolTable(cu, vSpecResolution);
			scopeResolver.resolveScopes(symbolTable);
			productResolver.deriveProduct(symbolTable);
			
			IFile iProduct = testProject.iProject.getFile("/TestFolder/products/product");
			File fileProduct = iProduct.getLocation().toFile();
			Context.eINSTANCE.writeProductsToFiles(Context.eINSTANCE.getSubEngine().getCopiedBaseModels(), fileProduct);
			
			iProduct = testProject.iProject.getFile("/TestFolder/products/product_modeladjacenttest.uml");
			fileProduct = iProduct.getLocation().toFile();
			
			boolean isIdentical = TestProject.isIdentical(testResources[5].getiFile().getLocation().toFile().getAbsolutePath(), fileProduct.getAbsolutePath());
			Assert.assertTrue("derived and expected products are different", isIdentical);
	}
	
	@Test
	public void additiveAdjacentContLessPlacements() throws IOException, CoreException {	
			File fileVarModel = testResources[6].getiFile().getLocation().toFile();
			CVLModel model = Context.eINSTANCE.loadModelFromFile(fileVarModel);
			ConfigurableUnit cu = model.getCU();
			VSpecResolution vSpecResolution = cu.getOwnedVSpecResolution().get(0);
			
			SymbolTable symbolTable = composer.buildSymbolTable(cu, vSpecResolution);
			scopeResolver.resolveScopes(symbolTable);
			productResolver.deriveProduct(symbolTable);
			
			IFile iProduct = testProject.iProject.getFile("/TestFolder/products/product");
			File fileProduct = iProduct.getLocation().toFile();
			Context.eINSTANCE.writeProductsToFiles(Context.eINSTANCE.getSubEngine().getCopiedBaseModels(), fileProduct);
			
			iProduct = testProject.iProject.getFile("/TestFolder/products/product_modeladjacenttest.uml");
			fileProduct = iProduct.getLocation().toFile();
			
			boolean isIdentical = TestProject.isIdentical(testResources[7].getiFile().getLocation().toFile().getAbsolutePath(), fileProduct.getAbsolutePath());
			Assert.assertTrue("derived and expected products are different", isIdentical);
	}
	
	@Test
	public void additiveAdjacentContLessPlacements1() throws IOException, CoreException {	
			File fileVarModel = testResources[8].getiFile().getLocation().toFile();
			CVLModel model = Context.eINSTANCE.loadModelFromFile(fileVarModel);
			ConfigurableUnit cu = model.getCU();
			VSpecResolution vSpecResolution = cu.getOwnedVSpecResolution().get(0);
			
			SymbolTable symbolTable = composer.buildSymbolTable(cu, vSpecResolution);
			scopeResolver.resolveScopes(symbolTable);
			productResolver.deriveProduct(symbolTable);
			
			IFile iProduct = testProject.iProject.getFile("/TestFolder/products/product");
			File fileProduct = iProduct.getLocation().toFile();
			Context.eINSTANCE.writeProductsToFiles(Context.eINSTANCE.getSubEngine().getCopiedBaseModels(), fileProduct);
			
			iProduct = testProject.iProject.getFile("/TestFolder/products/product_modeladjacenttest.uml");
			fileProduct = iProduct.getLocation().toFile();
			
			boolean isIdentical = TestProject.isIdentical(testResources[7].getiFile().getLocation().toFile().getAbsolutePath(), fileProduct.getAbsolutePath());
			Assert.assertTrue("derived and expected products are different", isIdentical);
	}
	
	@Test
	public void additiveAdjacentContLessPlacementsDifferentOrder() throws IOException, CoreException {
			String [] vspecOrder = {"Installation", "AutroPrime", "Main", "Sub"};
			File fileVarModel = testResources[8].getiFile().getLocation().toFile();
			CVLModel model = Context.eINSTANCE.loadModelFromFile(fileVarModel);
			ConfigurableUnit cu = model.getCU();
			VSpecResolution vSpecResolution = cu.getOwnedVSpecResolution().get(0);
			
			SymbolTable symbolTable = composer.buildSymbolTable(cu, vSpecResolution);
			scopeResolver.resolveScopes(symbolTable);
			
			EList<FragmentSubstitution> fragmentSusbstitutions = TestProject.collectFragmentSuubstitutions(symbolTable.getSymbols());
			EList<Symbol> symbols = TestProject.sortSymbolByNames(symbolTable.getSymbols(), vspecOrder);
			
			Context.eINSTANCE.initSubEngine(fragmentSusbstitutions);
			Context.eINSTANCE.performSubstitutions(symbols);
			
			IFile iProduct = testProject.iProject.getFile("/TestFolder/products/productorder");
			File fileProduct = iProduct.getLocation().toFile();
			Context.eINSTANCE.writeProductsToFiles(Context.eINSTANCE.getSubEngine().getCopiedBaseModels(), fileProduct);
			
			iProduct = testProject.iProject.getFile("/TestFolder/products/productorder_modeladjacenttest.uml");
			fileProduct = iProduct.getLocation().toFile();
			
			boolean isIdentical = TestProject.isIdentical(testResources[7].getiFile().getLocation().toFile().getAbsolutePath(), fileProduct.getAbsolutePath());
			Assert.assertTrue("derived and expected products are different", isIdentical);
	}
	
	@Test
	public void additiveAdjacentContLessPlacementsDifferentOrder1() throws IOException, CoreException {
		String [] vspecOrder = {"Installation", "AutroPrime", "Sub", "Main"};
			File fileVarModel = testResources[8].getiFile().getLocation().toFile();
			CVLModel model = Context.eINSTANCE.loadModelFromFile(fileVarModel);
			ConfigurableUnit cu = model.getCU();
			VSpecResolution vSpecResolution = cu.getOwnedVSpecResolution().get(0);
			
			SymbolTable symbolTable = composer.buildSymbolTable(cu, vSpecResolution);
			scopeResolver.resolveScopes(symbolTable);
			
			EList<FragmentSubstitution> fragmentSusbstitutions = TestProject.collectFragmentSuubstitutions(symbolTable.getSymbols());
			EList<Symbol> symbols = TestProject.sortSymbolByNames(symbolTable.getSymbols(), vspecOrder);
			
			Context.eINSTANCE.initSubEngine(fragmentSusbstitutions);
			Context.eINSTANCE.performSubstitutions(symbols);
			
			IFile iProduct = testProject.iProject.getFile("/TestFolder/products/productorder1");
			File fileProduct = iProduct.getLocation().toFile();
			Context.eINSTANCE.writeProductsToFiles(Context.eINSTANCE.getSubEngine().getCopiedBaseModels(), fileProduct);
			
			iProduct = testProject.iProject.getFile("/TestFolder/products/productorder1_modeladjacenttest.uml");
			fileProduct = iProduct.getLocation().toFile();
			
			boolean isIdentical = TestProject.isIdentical(testResources[7].getiFile().getLocation().toFile().getAbsolutePath(), fileProduct.getAbsolutePath());
			Assert.assertTrue("derived and expected products are different", isIdentical);
	}
	
	@Test
	public void additiveAdjacentContLessPlacementsDifferentOrder2() throws IOException, CoreException {
		String [] vspecOrder = {"Installation", "Sub", "AutroPrime", "Main"};
			File fileVarModel = testResources[8].getiFile().getLocation().toFile();
			CVLModel model = Context.eINSTANCE.loadModelFromFile(fileVarModel);
			ConfigurableUnit cu = model.getCU();
			VSpecResolution vSpecResolution = cu.getOwnedVSpecResolution().get(0);
			
			SymbolTable symbolTable = composer.buildSymbolTable(cu, vSpecResolution);
			scopeResolver.resolveScopes(symbolTable);
			
			EList<FragmentSubstitution> fragmentSusbstitutions = TestProject.collectFragmentSuubstitutions(symbolTable.getSymbols());
			EList<Symbol> symbols = TestProject.sortSymbolByNames(symbolTable.getSymbols(), vspecOrder);
			
			Context.eINSTANCE.initSubEngine(fragmentSusbstitutions);
			Context.eINSTANCE.performSubstitutions(symbols);
			
			IFile iProduct = testProject.iProject.getFile("/TestFolder/products/productorder2");
			File fileProduct = iProduct.getLocation().toFile();
			Context.eINSTANCE.writeProductsToFiles(Context.eINSTANCE.getSubEngine().getCopiedBaseModels(), fileProduct);
			
			iProduct = testProject.iProject.getFile("/TestFolder/products/productorder2_modeladjacenttest.uml");
			fileProduct = iProduct.getLocation().toFile();
			
			boolean isIdentical = TestProject.isIdentical(testResources[7].getiFile().getLocation().toFile().getAbsolutePath(), fileProduct.getAbsolutePath());
			Assert.assertTrue("derived and expected products are different", isIdentical);
	}
	
	@Test
	public void additiveAdjacentContLessPlacementsDifferentOrder3() throws IOException, CoreException {
		String [] vspecOrder = {"Installation", "Sub", "Main", "AutroPrime"};
			File fileVarModel = testResources[8].getiFile().getLocation().toFile();
			CVLModel model = Context.eINSTANCE.loadModelFromFile(fileVarModel);
			ConfigurableUnit cu = model.getCU();
			VSpecResolution vSpecResolution = cu.getOwnedVSpecResolution().get(0);
			
			SymbolTable symbolTable = composer.buildSymbolTable(cu, vSpecResolution);
			scopeResolver.resolveScopes(symbolTable);
			
			EList<FragmentSubstitution> fragmentSusbstitutions = TestProject.collectFragmentSuubstitutions(symbolTable.getSymbols());
			EList<Symbol> symbols = TestProject.sortSymbolByNames(symbolTable.getSymbols(), vspecOrder);
			
			Context.eINSTANCE.initSubEngine(fragmentSusbstitutions);
			Context.eINSTANCE.performSubstitutions(symbols);
			
			IFile iProduct = testProject.iProject.getFile("/TestFolder/products/productorder3");
			File fileProduct = iProduct.getLocation().toFile();
			Context.eINSTANCE.writeProductsToFiles(Context.eINSTANCE.getSubEngine().getCopiedBaseModels(), fileProduct);
			
			iProduct = testProject.iProject.getFile("/TestFolder/products/productorder3_modeladjacenttest.uml");
			fileProduct = iProduct.getLocation().toFile();
			
			boolean isIdentical = TestProject.isIdentical(testResources[7].getiFile().getLocation().toFile().getAbsolutePath(), fileProduct.getAbsolutePath());
			Assert.assertTrue("derived and expected products are different", isIdentical);
	}
	
	@Test
	public void additiveAdjacentContLessPlacementsDifferentOrder4() throws IOException, CoreException {
		String [] vspecOrder = {"Installation", "Main", "Sub", "AutroPrime"};
			File fileVarModel = testResources[8].getiFile().getLocation().toFile();
			CVLModel model = Context.eINSTANCE.loadModelFromFile(fileVarModel);
			ConfigurableUnit cu = model.getCU();
			VSpecResolution vSpecResolution = cu.getOwnedVSpecResolution().get(0);
			
			SymbolTable symbolTable = composer.buildSymbolTable(cu, vSpecResolution);
			scopeResolver.resolveScopes(symbolTable);
			
			EList<FragmentSubstitution> fragmentSusbstitutions = TestProject.collectFragmentSuubstitutions(symbolTable.getSymbols());
			EList<Symbol> symbols = TestProject.sortSymbolByNames(symbolTable.getSymbols(), vspecOrder);
			
			Context.eINSTANCE.initSubEngine(fragmentSusbstitutions);
			Context.eINSTANCE.performSubstitutions(symbols);
			
			IFile iProduct = testProject.iProject.getFile("/TestFolder/products/productorder4");
			File fileProduct = iProduct.getLocation().toFile();
			Context.eINSTANCE.writeProductsToFiles(Context.eINSTANCE.getSubEngine().getCopiedBaseModels(), fileProduct);
			
			iProduct = testProject.iProject.getFile("/TestFolder/products/productorder4_modeladjacenttest.uml");
			fileProduct = iProduct.getLocation().toFile();
			
			boolean isIdentical = TestProject.isIdentical(testResources[7].getiFile().getLocation().toFile().getAbsolutePath(), fileProduct.getAbsolutePath());
			Assert.assertTrue("derived and expected products are different", isIdentical);
	}
	
	@Test
	public void additiveAdjacentContLessPlacementsDifferentOrder5() throws IOException, CoreException {
		String [] vspecOrder = {"Installation", "Main", "AutroPrime", "Sub"};
			File fileVarModel = testResources[8].getiFile().getLocation().toFile();
			CVLModel model = Context.eINSTANCE.loadModelFromFile(fileVarModel);
			ConfigurableUnit cu = model.getCU();
			VSpecResolution vSpecResolution = cu.getOwnedVSpecResolution().get(0);
			
			SymbolTable symbolTable = composer.buildSymbolTable(cu, vSpecResolution);
			scopeResolver.resolveScopes(symbolTable);
			
			EList<FragmentSubstitution> fragmentSusbstitutions = TestProject.collectFragmentSuubstitutions(symbolTable.getSymbols());
			EList<Symbol> symbols = TestProject.sortSymbolByNames(symbolTable.getSymbols(), vspecOrder);
			
			Context.eINSTANCE.initSubEngine(fragmentSusbstitutions);
			Context.eINSTANCE.performSubstitutions(symbols);
			
			IFile iProduct = testProject.iProject.getFile("/TestFolder/products/productorder5");
			File fileProduct = iProduct.getLocation().toFile();
			Context.eINSTANCE.writeProductsToFiles(Context.eINSTANCE.getSubEngine().getCopiedBaseModels(), fileProduct);
			
			iProduct = testProject.iProject.getFile("/TestFolder/products/productorder5_modeladjacenttest.uml");
			fileProduct = iProduct.getLocation().toFile();
			
			boolean isIdentical = TestProject.isIdentical(testResources[7].getiFile().getLocation().toFile().getAbsolutePath(), fileProduct.getAbsolutePath());
			Assert.assertTrue("derived and expected products are different", isIdentical);
	}

}
