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
package splar.core.constraints;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CNFFormula {

	private Set<CNFClause> clauses;
	
	public CNFFormula() {
		clauses = new LinkedHashSet<CNFClause>();
	}
	
	public void addClause(CNFClause clause) {
		clauses.add(clause);
	}
	
	public void addClauses(Collection<CNFClause> clauses) {
		this.clauses.addAll(clauses);
	}
	
	public Set<CNFClause> getClauses() {
		return clauses;
	}
	
	public double getClauseDensity() {
		if ( getVariables().size() == 0 ) {
			return 0;
		}
		return (1.0*clauses.size())/getVariables().size();
	}
	
	public int countClauses() {
		return clauses.size();
	}
	
	public Set<CNFLiteral> getLiterals() {
		Set<CNFLiteral> set = new HashSet<CNFLiteral>();
		for( Iterator<CNFClause> it = clauses.iterator() ; it.hasNext() ; ) {
			for( Iterator<CNFLiteral> it2 = it.next().getLiterals().iterator() ; it2.hasNext() ; ) {
				set.add(it2.next());
			}
		}
		return set;
	}
	
	public int countLiterals() {
		return getLiterals().size();
	}
	
	public Set<BooleanVariableInterface> getVariables() {
		Set<BooleanVariableInterface> set = new HashSet<BooleanVariableInterface>();
		for( Iterator<CNFClause> it = clauses.iterator() ; it.hasNext() ; ) {
			for( Iterator<CNFLiteral> it2 = it.next().getLiterals().iterator() ; it2.hasNext() ; ) {
				set.add(it2.next().getVariable());
			}
		}
		return set;
	}
	
	public int countVariables() {
		return getVariables().size();
	}

	public int calculateClauseSpan(Map<String,Integer> variable2indexMap) {
		int span = 0;		
		for( Iterator<CNFClause> it = clauses.iterator() ; it.hasNext() ; ) {
			span += it.next().calculateSpan(variable2indexMap);
		}
		return span;
	}
	
	public String toString() {
		StringBuffer toString = new StringBuffer(100);
		for( Iterator<CNFClause> it = clauses.iterator() ; it.hasNext() ; ) {
			toString.append(it.next());
		}
		return toString.toString();
	}
	
}
