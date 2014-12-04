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
package splar.core.heuristics;

import java.util.LinkedHashMap;
import java.util.Map;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFFormula;
import splar.core.fm.FeatureModel;


public class VariableOrderingHeuristicsManager {
	
	private Map<String, VariableOrderingHeuristic> heuristics;

	public static VariableOrderingHeuristicsManager manager = null;

	public static VariableOrderingHeuristicsManager createHeuristicsManager() {
		if ( manager == null ) {
			manager = new VariableOrderingHeuristicsManager();
		}
		
		return manager;
	}
	
	private VariableOrderingHeuristicsManager() {
		heuristics = new LinkedHashMap<String, VariableOrderingHeuristic>();
	}

	public String[] run(String name, CNFFormula cnf) {
		VariableOrderingHeuristic heuristic = heuristics.get(name);
		if ( heuristic != null ) {
			return heuristic.run(cnf);
		}
		return null;
	}
	
	public void registerHeuristic(String name, VariableOrderingHeuristic heuristic) {
		heuristics.put(name, heuristic);
	}
	
	public VariableOrderingHeuristic getHeuristic(String name) {
		return heuristics.get(name);
	}
	
	public String[] getHeuristicNames() {
		String names[] = new String[heuristics.size()];
		int i = 0;
		for( VariableOrderingHeuristic heuristic : heuristics.values() ) {
			names[i++] = heuristic.getName();
		}
		return names;
	}
	
}
