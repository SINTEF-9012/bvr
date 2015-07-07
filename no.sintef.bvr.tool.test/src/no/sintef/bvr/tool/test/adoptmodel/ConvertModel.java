/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.test.adoptmodel;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import no.sintef.bvr.test.common.utils.TestUtils;
import no.sintef.bvr.tool.exception.MalformedVarModelException;
import no.sintef.bvr.tool.interfaces.model.IBVRSPLCAModelTransformator;
import no.sintef.bvr.tool.interfaces.model.IPostfixGenerator;
import no.sintef.bvr.tool.model.BVRSimpleToolModel;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.model.PostfixGeneratorFacade;
import no.sintef.bvr.tool.model.TransfFacade;

import org.junit.Before;
import org.junit.Test;

import bvr.CompoundNode;

//IMPORTANT NOTE:
//most of the test cases here depends on the way we work through the model
//thus test cases may fail if it changes....
//should be fixed at some point

public class ConvertModel {

	@Before
	public void setUp() {
		PostfixGeneratorFacade.eINSTANCE.setPostfixGenerator(new IPostfixGenerator() {

			private int count = 0;
			private final String DELIMITER = "@";

			@Override
			public String getPostfix() {
				return "@" + count++;
			}

			@Override
			public String getPostfixDelimiter() {
				return DELIMITER;
			}

			@Override
			public String removePostfix(String str) {
				String[] strings = str.split(DELIMITER);
				return strings[0];
			}
		});
	}

	@Test
	public void testTrivialModelConvertion() {
		BVRToolModel srcVarModel = createBVRToolModel("resources/vm/trivial_src.bvr");
		BVRToolModel trgVarModel = createBVRToolModel("resources/vm/trivial_trg.bvr");

		IBVRSPLCAModelTransformator transformator = TransfFacade.eINSTANCE.getSPLCATransformator(srcVarModel.getBVRModel());
		CompoundNode transformed = transformator.transformVarModelToSPLCA();
		assertNotNull(transformed);

		assertTrue(TestUtils.isEObjectTreesIdentical(trgVarModel.getBVRModel().getVariabilityModel(), transformed));

	}

	@Test
	public void testTrivialModelConstrConvertion() {
		BVRToolModel srcVarModel = createBVRToolModel("resources/vm/trivial_const_src.bvr");
		BVRToolModel trgVarModel = createBVRToolModel("resources/vm/trivial_const_trg.bvr");

		IBVRSPLCAModelTransformator transformator = TransfFacade.eINSTANCE.getSPLCATransformator(srcVarModel.getBVRModel());
		CompoundNode transformed = transformator.transformVarModelToSPLCA();
		assertNotNull(transformed);

		assertTrue(TestUtils.isEObjectTreesIdentical(trgVarModel.getBVRModel().getVariabilityModel(), transformed));

	}

	@Test
	public void testTrivialModelAllConvertion() {
		BVRToolModel srcVarModel = createBVRToolModel("resources/vm/trivial_all_src.bvr");
		BVRToolModel trgVarModel = createBVRToolModel("resources/vm/trivial_all_trg.bvr");

		IBVRSPLCAModelTransformator transformator = TransfFacade.eINSTANCE.getSPLCATransformator(srcVarModel.getBVRModel());
		CompoundNode transformed = transformator.transformVarModelToSPLCA();
		assertNotNull(transformed);

		assertTrue(TestUtils.isEObjectTreesIdentical(trgVarModel.getBVRModel().getVariabilityModel(), transformed));

	}

	@Test
	public void testThrowExceptionForNotValidModel() {
		BVRToolModel toolModel = createBVRToolModel("resources/vm/invalid_model.bvr");
		boolean thrown = false;

		try {
			IBVRSPLCAModelTransformator transformator = TransfFacade.eINSTANCE.getSPLCATransformator(toolModel.getBVRModel());
			transformator.transformVarModelToSPLCA();
		} catch (MalformedVarModelException ex) {
			thrown = true;
		}

		assertTrue("a proper exception was not trown when we tried to transform invalid model", thrown);
	}

	private BVRToolModel createBVRToolModel(String filename) {
		BVRToolModel model = new BVRSimpleToolModel(new File(filename));
		return model;
	}

}
