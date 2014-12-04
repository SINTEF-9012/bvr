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
package splar.plugins.reasoners.tests.bdd.javabdd;

import splar.core.fm.FeatureModel;
import splar.core.fm.reasoning.FMReasoningInterface;
import splar.core.heuristics.FTPreOrderTraversalHeuristic;
import splar.core.heuristics.VariableOrderingHeuristic;
import splar.core.heuristics.VariableOrderingHeuristicsManager;
import splar.plugins.reasoners.bdd.javabdd.FMReasoningWithBDD;
import splar.plugins.reasoners.tests.FMReasoningInterfaceTest;

public class ReasoningWithBDDTest extends FMReasoningInterfaceTest {
	
	public ReasoningWithBDDTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	protected FMReasoningInterface createReasoner(FeatureModel model) {
		int bddNodeNum = 10000, bddCacheSize = 10000;
		new FTPreOrderTraversalHeuristic("BDDVarOrderHeuristic", model);
		VariableOrderingHeuristic heuristic = VariableOrderingHeuristicsManager.createHeuristicsManager().getHeuristic("BDDVarOrderHeuristic");
		return new FMReasoningWithBDD(model, heuristic, bddNodeNum, bddCacheSize, 60000, "pre-order");
	}
}
