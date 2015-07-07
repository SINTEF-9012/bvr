/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.test.splca;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import no.sintef.bvr.common.logging.ConsoleLogger;
import no.sintef.bvr.test.common.utils.TestProject;
import no.sintef.bvr.test.common.utils.TestResourceHolder;
import no.sintef.bvr.test.common.utils.TestUtils;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.logging.impl.DefaultLogger;
import no.sintef.bvr.tool.model.BVRSimpleToolModel;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.test.Activator;
import no.sintef.ict.splcatool.BVRException;
import no.sintef.ict.splcatool.CSVException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bvr.BVRModel;
import bvr.CompoundResolution;

public class TestCoveringArrayConstTranformation {

	private static String[] testFolders = { "TestFolder" };

	private static TestResourceHolder[] resources = {
			new TestResourceHolder("/resources/vm/gen_product_const_src.bvr", "TestFolder/gen_product_const_src.bvr"),
			new TestResourceHolder("/resources/vm/gen_product_const_trg.bvr", "TestFolder/gen_product_const_trg.bvr"),
			new TestResourceHolder("/resources/vm/gen_product_const_invalid_trg.bvr", "TestFolder/gen_product_const_invalid_trg.bvr"),
			new TestResourceHolder("/resources/vm/gen_product_const_invalid_trg1.bvr", "TestFolder/gen_product_const_invalid_trg1.bvr"),
			new TestResourceHolder("/resources/vm/product_const.bvr", "TestFolder/product_const.bvr") };

	/** The test project. */
	private static TestProject testProject;

	@BeforeClass
	public static void setUpClass() throws CoreException, IOException {
		Context.eINSTANCE.setIWorkbenchWindow(PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		Context.eINSTANCE.logger = new ConsoleLogger();
		Context.eINSTANCE.problemLogger = new DefaultLogger();
		testProject = new TestProject("AddVSpecTargetTest", Activator.PLUGIN_ID);
		testProject.closeWelcome();
		testProject.createFolders(testFolders);
		testProject.createResources(resources);
	}

	@AfterClass
	public static void tearDownClass() throws CoreException {
		testProject.disposeTestProject();
	}

	private BVRToolModel transactionModel;

	private BVRModel bvrModel;

	private BVRToolModel simpleToolModelTarget;

	private BVRModel bvrModelTarget;

	private BVRToolModel transactionModelInvalidModel;
	private BVRToolModel transactionModelInvalidModel1;
	private BVRToolModel transactionModelCalculate;

	@Before
	public void setUp() throws Exception {
		transactionModel = Context.eINSTANCE.testBVRToolModel(resources[0].getiFile().getLocation().toFile());
		assertNotNull(transactionModel);

		bvrModel = transactionModel.getBVRModel();
		assertNotNull(bvrModel);

		simpleToolModelTarget = createBVRToolModel(resources[1].getiFile().getLocation().toFile().getAbsolutePath());
		assertNotNull(simpleToolModelTarget);

		bvrModelTarget = simpleToolModelTarget.getBVRModel();
		assertNotNull(bvrModelTarget);

		transactionModelInvalidModel = Context.eINSTANCE.testBVRToolModel(resources[2].getiFile().getLocation().toFile());
		assertNotNull(transactionModelInvalidModel);

		transactionModelInvalidModel1 = Context.eINSTANCE.testBVRToolModel(resources[3].getiFile().getLocation().toFile());
		assertNotNull(transactionModelInvalidModel1);

		transactionModelCalculate = Context.eINSTANCE.testBVRToolModel(resources[4].getiFile().getLocation().toFile());
		assertNotNull(transactionModelCalculate);
	}

	@After
	public void tearDown() throws Exception {
		Context.eINSTANCE.getBvrModels().clear();
		Context.eINSTANCE.getBvrViews().clear();
		Context.eINSTANCE.disposeModel(transactionModel);
		TransactionalEditingDomain.Registry.INSTANCE.remove("no.sintef.bvr.shared.EditingDomain");
		Context.eINSTANCE.getEditorCommands().disableBatchProcessing();
	}

	@Test
	public void testProductGeneration() throws BVRException, CSVException {
		transactionModel.generateCoveringArray(2);

		EList<CompoundResolution> resolutions = bvrModel.getResolutionModels();
		assertEquals("Wrong number of resolution is generated", bvrModelTarget.getResolutionModels().size(), resolutions.size());

		List<Map<String, Boolean>> producedProducts = transactionModel.getSPLCABVRModel().extractResolvedVSpecProducts();
		List<Map<String, Boolean>> expectedProducts = simpleToolModelTarget.getSPLCABVRModel().extractResolvedVSpecProducts();

		assertTrue("Actual product list is incorrect: expected -->" + expectedProducts + " actual -->" + producedProducts,
				TestUtils.compareProductResalutionsEqual(expectedProducts, producedProducts));

	}

	@Test
	public void testAllProductGeneration() throws BVRException, CSVException {
		transactionModel.generatAllProducts();

		EList<CompoundResolution> resolutions = bvrModel.getResolutionModels();
		assertEquals("Wrong number of resolution is generated", bvrModelTarget.getResolutionModels().size(), resolutions.size());

		List<Map<String, Boolean>> producedProducts = transactionModel.getSPLCABVRModel().extractResolvedVSpecProducts();
		List<Map<String, Boolean>> expectedProducts = simpleToolModelTarget.getSPLCABVRModel().extractResolvedVSpecProducts();

		assertTrue("Actual product list is incorrect: expected -->" + expectedProducts + " actual -->" + producedProducts,
				TestUtils.compareProductResalutionsEqual(expectedProducts, producedProducts));

	}

	@Test
	public void testAllProductValidation() throws BVRException, CSVException {
		transactionModel.generatAllProducts();

		EList<CompoundResolution> resolutions = bvrModel.getResolutionModels();
		assertEquals("Wrong number of resolution is generated", bvrModelTarget.getResolutionModels().size(), resolutions.size());

		boolean result = transactionModel.performSATValidation();
		assertTrue("product is actuall valid, however false is reported", result);
	}

	@Test
	public void testSingleProductValidation() throws BVRException, CSVException {
		transactionModel.generatAllProducts();

		EList<CompoundResolution> resolutions = bvrModel.getResolutionModels();
		assertEquals("Wrong number of resolution is generated", bvrModelTarget.getResolutionModels().size(), resolutions.size());

		boolean result = transactionModel.performSATValidation(resolutions.get(0));
		assertTrue("product is actuall valid, however invalid is reported", result);
	}

	@Test
	public void testInvalidProduct() {
		boolean result = transactionModelInvalidModel.performSATValidation();
		assertFalse("NegResolution is actuall invalid, however valid is reported", result);
	}

	@Test
	public void testInvalidProduct1() {
		boolean result = transactionModelInvalidModel1.performSATValidation();
		assertFalse("NegResolution is actuall invalid, however valid is reported", result);
	}

	@Test
	public void testCalcultateCoveringNotNull() {
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		try {
			result1 = transactionModelCalculate.calculateCoverage(1);
			result2 = transactionModelCalculate.calculateCoverage(2);
			result3 = transactionModelCalculate.calculateCoverage(3);
		} catch (Exception ex) {
			ex.printStackTrace();
			assertFalse("failed with message " + ex.getMessage(), true);
		}

		assertEquals("2-wise calculation is wrong", 100, result1);
		assertEquals("2-wise calculation is wrong", 100, result2);
		assertEquals("2-wise calculation is wrong", 100, result3);
	}

	private BVRToolModel createBVRToolModel(String filename) {
		BVRToolModel model = new BVRSimpleToolModel(new File(filename));
		return model;
	}
}
