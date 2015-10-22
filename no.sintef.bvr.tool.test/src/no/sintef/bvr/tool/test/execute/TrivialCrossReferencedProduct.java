/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.test.execute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.Arrays;

import no.sintef.bvr.engine.common.SubstitutionEngine;
import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.test.common.utils.TestResourceHolder;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.model.BVRTransactionalModel;
import no.sintef.bvr.tool.test.Activator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageableElement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TrivialCrossReferencedProduct {

	private static TestProject testProject;
	private static String[] testFolders = { "TestFolder", "TestFolder/products" };

	private static TestResourceHolder[] testResources = { new TestResourceHolder("/resources/cross_model.bvr", "/TestFolder/cross_model.bvr"),
			new TestResourceHolder("/resources/cross_base1.uml", "/TestFolder/cross_base1.uml"),
			new TestResourceHolder("/resources/cross_base2.uml", "/TestFolder/cross_base2.uml"),
			new TestResourceHolder("/resources/cross_lib.uml", "/TestFolder/cross_lib.uml") };

	private static String productPrefix = "/TestFolder/products/product";

	private static String[] productsURI = { "/TrivialCrossReferencedProduct/TestFolder/products/product_cross_base1.uml",
			"/TrivialCrossReferencedProduct/TestFolder/products/product_cross_base2.uml" };

	@BeforeClass
	public static void setUpClass() throws Exception {
		testProject = new TestProject("TrivialCrossReferencedProduct", Activator.PLUGIN_ID);
		testProject.closeWelcome();
		testProject.createFolders(testFolders);
		testProject.createResources(testResources);
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		testProject.disposeTestProject();
	}

	private BVRToolModel toolModel;

	@Before
	public void setUp() throws Exception {
		IWorkbenchWindow iWorkBenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		Context.eINSTANCE.setIWorkbenchWindow(iWorkBenchWindow);
		Context.eINSTANCE.testSubEngine(SubstitutionEngine.eINSTANCE);

		File fileVarModel = testResources[0].getiFile().getLocation().toFile();
		toolModel = Context.eINSTANCE.loadModelFromFile(fileVarModel);
	}

	@After
	public void tearDown() throws Exception {
		Context.eINSTANCE.getBvrModels().clear();
		Context.eINSTANCE.getBvrViews().clear();
		Context.eINSTANCE.disposeModel(toolModel);
	}

	@Test
	public void runDefualtDeriviationTest0() {
		File file = testResources[0].getiFile().getLocation().toFile();
		BVRTransactionalModel model = (BVRTransactionalModel) Context.eINSTANCE.testBVRToolModel(file);
		IFile iProduct = testProject.getIProject().getFile(productPrefix);
		File fileProduct = iProduct.getLocation().toFile();

		String[] base_model = { testResources[1].getiFile().getFullPath().toString(), testResources[2].getiFile().getFullPath().toString() };
		model.updateBaseModelFiles(Arrays.asList(base_model));

		try {
			model.executeResolution(fileProduct, 0);
		} catch (Exception e) {
			assertFalse("execution failed with message " + e.getMessage(), true);
		}
	}

	@Test
	public void runDefualtDeriviationTest1() {
		File file = testResources[0].getiFile().getLocation().toFile();
		BVRTransactionalModel model = (BVRTransactionalModel) Context.eINSTANCE.testBVRToolModel(file);
		IFile iProduct = testProject.getIProject().getFile(productPrefix);
		File fileProduct = iProduct.getLocation().toFile();

		String[] base_model = { testResources[1].getiFile().getFullPath().toString(), testResources[2].getiFile().getFullPath().toString() };
		model.updateBaseModelFiles(Arrays.asList(base_model));

		try {
			model.executeResolution(fileProduct, 0);
		} catch (Exception e) {
			assertFalse("execution failed with message " + e.getMessage(), true);
		}

		ResourceSet resSet = new ResourceSetImpl();
		URI product_base1 = URI.createPlatformResourceURI(productsURI[0], true);
		URI product_base2 = URI.createPlatformResourceURI(productsURI[1], true);

		try {
			resSet.getResource(product_base1, true);
		} catch (RuntimeException ex) {
			assertFalse("base models are not copied properly, '" + productsURI[0] + "' is missing", true);
		}

		try {
			resSet.getResource(product_base2, true);
		} catch (RuntimeException ex) {
			assertFalse("base models are not copied properly, '" + productsURI[1] + "' is missing", true);
		}

	}

	@Test
	public void runDefualtDeriviationTest2() {
		File file = testResources[0].getiFile().getLocation().toFile();
		BVRTransactionalModel model = (BVRTransactionalModel) Context.eINSTANCE.testBVRToolModel(file);
		IFile iProduct = testProject.getIProject().getFile(productPrefix);
		File fileProduct = iProduct.getLocation().toFile();

		String[] base_model = { testResources[1].getiFile().getFullPath().toString(), testResources[2].getiFile().getFullPath().toString() };
		model.updateBaseModelFiles(Arrays.asList(base_model));

		try {
			model.executeResolution(fileProduct, 0);
		} catch (Exception e) {
			assertFalse("execution failed with message " + e.getMessage(), true);
		}

		ResourceSet resSet = new ResourceSetImpl();
		URI product_base1 = URI.createPlatformResourceURI(productsURI[0], true);

		Resource resource = resSet.getResource(product_base1, true);

		ElementImport elementImport = (ElementImport) resource.getContents().get(0).eContents().get(0);

		PackageableElement importedElement = elementImport.getImportedElement();

		assertEquals("Cross-reference is incorrect", "platform:/resource" + productsURI[1], importedElement.eResource().getURI().toString());
	}
}
