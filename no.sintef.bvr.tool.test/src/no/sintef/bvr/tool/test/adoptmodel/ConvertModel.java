package no.sintef.bvr.tool.test.adoptmodel;

import static org.junit.Assert.*;

import java.io.File;

import no.sintef.bvr.testutils.common.TestUtils;
import no.sintef.bvr.tool.interfaces.model.IBVRSPLCAModelTransformator;
import no.sintef.bvr.tool.model.BVRSimpleToolModel;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.model.TransfFacade;

import org.junit.Test;

import bvr.CompoundNode;

public class ConvertModel {

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
