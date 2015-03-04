package no.sintef.bvr.tool.test.adoptmodel;

import static org.junit.Assert.*;

import java.io.File;

import no.sintef.bvr.testutils.common.TestUtils;
import no.sintef.bvr.tool.interfaces.model.IBVRModelTransformation;
import no.sintef.bvr.tool.model.BVRSimpleToolModel;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.model.TransfFacade;

import org.junit.Test;

import bvr.CompoundNode;

public class ConvertModel {

	@Test
	public void testTrivialModelConvertion() {		
		CompoundNode srcVarModel = getVariabilityModel("resources/vm/trivial_src.bvr");
		CompoundNode trgVarModel = getVariabilityModel("resources/vm/trivial_trg.bvr");
		
		IBVRModelTransformation transformator = TransfFacade.eINSTANCE.getSPLCATransformator();
		CompoundNode transformed = transformator.transformVarModelToSPLCA(srcVarModel);
		assertNotNull(transformed);
		
		assertTrue(TestUtils.isEObjectTreesIdentical(trgVarModel, transformed));

	}
	
	@Test
	public void testTrivialModelConstrConvertion() {		
		CompoundNode srcVarModel = getVariabilityModel("resources/vm/trivial_const_src.bvr");
		CompoundNode trgVarModel = getVariabilityModel("resources/vm/trivial_const_trg.bvr");
		
		IBVRModelTransformation transformator = TransfFacade.eINSTANCE.getSPLCATransformator();
		CompoundNode transformed = transformator.transformVarModelToSPLCA(srcVarModel);
		assertNotNull(transformed);
		
		assertTrue(TestUtils.isEObjectTreesIdentical(trgVarModel, transformed));

	}
	
	@Test
	public void testTrivialModelAllConvertion() {		
		CompoundNode srcVarModel = getVariabilityModel("resources/vm/trivial_all_src.bvr");
		CompoundNode trgVarModel = getVariabilityModel("resources/vm/trivial_all_trg.bvr");
		
		IBVRModelTransformation transformator = TransfFacade.eINSTANCE.getSPLCATransformator();
		CompoundNode transformed = transformator.transformVarModelToSPLCA(srcVarModel);
		assertNotNull(transformed);
		
		assertTrue(TestUtils.isEObjectTreesIdentical(trgVarModel, transformed));

	}
	
	private BVRToolModel createBVRToolModel(String filename) {
		BVRToolModel model = new BVRSimpleToolModel(new File(filename));
		return model;
	}
	
	private CompoundNode getVariabilityModel(String filename) {
		BVRToolModel toolModel = createBVRToolModel(filename);
		assertNotNull(toolModel);
		
		CompoundNode varModel = toolModel.getBVRModel().getVariabilityModel();
		assertNotNull(varModel);
		return varModel;
	};

}
