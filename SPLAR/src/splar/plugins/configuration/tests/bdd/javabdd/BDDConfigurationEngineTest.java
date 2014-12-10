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
package splar.plugins.configuration.tests.bdd.javabdd;

import org.junit.Test;

import splar.core.fm.configuration.ConfigurationEngine;
import splar.plugins.configuration.bdd.javabdd.BDDConfigurationEngine;
import splar.plugins.configuration.tests.ConfigurationEngineTest;

public class BDDConfigurationEngineTest extends ConfigurationEngineTest {
	
	public BDDConfigurationEngineTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	protected ConfigurationEngine createConfigurationEngine(String featureModelPath) throws Exception {
		return new BDDConfigurationEngine(featureModelPath);	
	}
	
	@Test
	@Override
	public void testAutoCompletion() {		
	}
	
	@Test
	@Override
	public void testToggle() {		
	}
	
	@Test
	@Override
	public void testConflictDetection() {		
	}

}
