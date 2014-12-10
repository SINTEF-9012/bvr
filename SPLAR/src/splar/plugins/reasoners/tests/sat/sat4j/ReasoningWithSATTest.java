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
package splar.plugins.reasoners.tests.sat.sat4j;

import splar.core.fm.FeatureModel;
import splar.core.fm.reasoning.FMReasoningInterface;
import splar.plugins.reasoners.sat.sat4j.FMReasoningWithSAT;
import splar.plugins.reasoners.tests.FMReasoningInterfaceTest;

public class ReasoningWithSATTest extends FMReasoningInterfaceTest {
	
	public ReasoningWithSATTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	protected FMReasoningInterface createReasoner(FeatureModel model) {
		return new FMReasoningWithSAT("MiniSAT", model, 60000);
	}
}
