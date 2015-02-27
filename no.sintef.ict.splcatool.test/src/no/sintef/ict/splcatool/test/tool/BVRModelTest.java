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
package no.sintef.ict.splcatool.test.tool;

import static org.junit.Assert.*;

import java.io.File;

import no.sintef.bvr.tool.model.BVRSimpleToolModel;
import no.sintef.bvr.tool.model.BVRToolModel;

import org.junit.Test;

public class BVRModelTest {

	@Test
	public void testBVRModelFile() {
		BVRToolModel m = new BVRSimpleToolModel(new File("TestData/Artificial/Apl.m.bvr"));
		assertTrue(m != null);
	}

}
