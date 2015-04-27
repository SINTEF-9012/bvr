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
package no.sintef.bvr.engine.operation;

import java.io.File;
import java.util.HashMap;

import no.sintef.bvr.engine.fragment.impl.FragmentSubstitutionHolder;
import no.sintef.bvr.engine.operation.impl.FragmentSubOperation;
import no.sintef.bvr.engine.testutils.SetUpUtils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bvr.BVRModel;
import bvr.FragmentSubstitution;
import bvr.VariationPoint;

public class FragmentSubstitutionTrivialTest {

	private static File file;
	private static HashMap<String, Object> map;
	private static BVRModel cu;
	private static FragmentSubstitution fragSub;
	private Resource baseModel;
	private FragmentSubstitutionHolder fragmentSubHolder;

	@Before
	public void setUp() throws Exception {
		file = new File("src/test/resources/node9-7/node.newbvr2.bvr");
		map = SetUpUtils.load(file);
		cu = (BVRModel) ((Resource) map.get("resource")).getContents().get(0);
		EList<VariationPoint> vps = cu.getRealizationModel();
		for(VariationPoint vp : vps){
			if(vp instanceof FragmentSubstitution){
				fragSub = (FragmentSubstitution) vp;
				break;
			}
		}
		
		Assert.assertNotNull("can not locate a fragment substitution, the test can not be executed", fragSub);
		fragmentSubHolder = new FragmentSubstitutionHolder(fragSub);
		baseModel = cu.eResource().getResourceSet().getResource(URI.createFileURI("base.node"), false);
		Assert.assertNotNull("base model is not found, the test cases can not be executed", baseModel);
	}

	@After
	public void tearDown() throws Exception {
		SetUpUtils.tearDown(map);
	}
	
	@Test
	public void testSingleSubstitutiontTrue() throws Exception {
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
	}
	
	@Test
	public void testSingleSubstitutionFalse() throws Exception {
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(false);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod2.node", "base_new.node"));
	}
	
	@Test
	public void testSeveralSubstitutionsReplaceTrue() throws Exception {
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
	}
	
	@Test
	public void testSeveralSubstitutionsReplaceTrueFalse() throws Exception {
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
		fso.execute(false);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod1.node", "base_new.node"));
	}

	@Test
	public void testSeveralSubstitutionsReplaceFalseTrue() throws Exception {
		FragmentSubOperation fso = new FragmentSubOperation(fragmentSubHolder);
		fso.execute(false);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod2.node", "base_new.node"));
		fso.execute(true);
		SetUpUtils.writeToFile(baseModel, "base_new.node");
		Assert.assertTrue("Expected transformation is different", SetUpUtils.isIdentical("prod0.node", "base_new.node"));
	}
}
