/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package no.sintef.bvr.tool.test.adoptmodel;

import static org.junit.Assert.*;

import java.io.File;



import no.sintef.bvr.test.common.utils.TestUtils;
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
