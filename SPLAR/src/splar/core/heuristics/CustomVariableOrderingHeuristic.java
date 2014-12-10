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

import splar.core.constraints.CNFFormula;


public class CustomVariableOrderingHeuristic extends VariableOrderingHeuristic {
	
	private String initialVO[] = null;
	
	public CustomVariableOrderingHeuristic(String name, String initialVO[]) {
		super(name);
		this.initialVO = initialVO;
	}
		
	public String[] runHeuristic(CNFFormula cnf) {
		
		String voList = (String)parameters.get("variable_ordering_list");
		List<String> varOrderList = new ArrayList<String>();
		if ( voList != null ) {		
			String[] result = voList.split(",");
			for (int i=0; i < result.length; i++) {
				varOrderList.add(result[i].trim());
			} 
			return varOrderList.toArray(new String[0]);
	    }
		return initialVO;
	}	
}

