/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.test.execute;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.Arrays;

import no.sintef.bvr.engine.common.SubstitutionEngine;
import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.test.common.utils.TestResourceHolder;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.model.BVRTransactionalModel;
import no.sintef.bvr.tool.primitive.SymbolVSpecResolutionTable;
import no.sintef.bvr.tool.strategy.impl.RRComposerStrategy;
import no.sintef.bvr.tool.strategy.impl.RealizationStrategyBottomUp;
import no.sintef.bvr.tool.strategy.impl.ScopeResolverStrategyScopeable;
import no.sintef.bvr.tool.test.Activator;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bvr.BVRModel;
import bvr.PosResolution;
import bvr.VSpecResolution;

public class TrivialDeriveProduct {

	private static TestProject testProject;
	private static String[] testFolders = { "TestFolder", "TestFolder/products" };

	private static TestResourceHolder[] testResources = { new TestResourceHolder("/resources/realization_trivial.bvr", "/TestFolder/realization_trivial.bvr"),
			new TestResourceHolder("/resources/trivial_base.uml", "/TestFolder/trivial_base.uml"),
			new TestResourceHolder("/resources/trivial_lib.uml", "/TestFolder/trivial_lib.uml") };

	@BeforeClass
	public static void setUpClass() throws Exception {
		testProject = new TestProject("TrivialDeriveProduct", Activator.PLUGIN_ID);
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
	public void trivialExecute() {
		BVRModel model = toolModel.getBVRModel();
		VSpecResolution vSpecResolution = model.getResolutionModels().get(0);

		RRComposerStrategy composer = new RRComposerStrategy();
		ScopeResolverStrategyScopeable scopeResolver = new ScopeResolverStrategyScopeable();
		RealizationStrategyBottomUp productResolver = new RealizationStrategyBottomUp();

		try {
			SymbolVSpecResolutionTable symbolTable = composer.buildSymbolTable(model, (PosResolution) vSpecResolution);
			scopeResolver.resolveScopes(symbolTable);
			productResolver.deriveProduct(symbolTable);

			IFile iProduct = testProject.getIProject().getFile("/TestFolder/products/product");
			File fileProduct = iProduct.getLocation().toFile();
			Context.eINSTANCE.writeProductsToFiles(Context.eINSTANCE.getSubEngine().getCopiedBaseModels(), fileProduct);
		} catch (Exception ex) {
			assertFalse("execution failed with message " + ex.getMessage(), true);
		}
	}

	@Test
	public void runDefualtDeriviationTest() {
		File file = testResources[0].getiFile().getLocation().toFile();
		BVRTransactionalModel model = (BVRTransactionalModel) Context.eINSTANCE.testBVRToolModel(file);
		IFile iProduct = testProject.getIProject().getFile("/TestFolder/products/product");
		File fileProduct = iProduct.getLocation().toFile();

		String[] model_paths = { testResources[1].getiFile().getFullPath().toString() };
		model.updateBaseModelFiles(Arrays.asList(model_paths));

		try {
			model.executeResolution(fileProduct, 0);
		} catch (Exception e) {
			assertFalse("execution failed with message " + e.getMessage(), true);
		}
	}
}
