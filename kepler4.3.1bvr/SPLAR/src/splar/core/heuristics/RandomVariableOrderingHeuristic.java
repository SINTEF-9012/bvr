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

import java.util.ArrayList;
import java.util.List;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFFormula;


public class RandomVariableOrderingHeuristic extends VariableOrderingHeuristic {
	
	public RandomVariableOrderingHeuristic(String name) {
		super(name);
	}
	
	// generates a random variable ordering
	// useful for benchmark purposes
	public String[] runHeuristic(CNFFormula cnf) {
	
		List<BooleanVariableInterface> variables = new ArrayList<BooleanVariableInterface>();
		variables.addAll(cnf.getVariables());
		java.util.Collections.shuffle(variables);
		String varOrder[] = new String[variables.size()];
		int i = 0;
		for( BooleanVariableInterface var : variables ) {
			varOrder[i++] = var.getID(); 
		}
		return varOrder;
	}	
}

