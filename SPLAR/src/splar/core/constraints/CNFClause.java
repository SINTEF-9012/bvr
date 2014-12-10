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

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;


public class CNFClause {
	
	private Vector<CNFLiteral> literals;

	public CNFClause() {
		literals = new Vector<CNFLiteral>();
	}
	
	public void addLiteral(CNFLiteral literal) {
		literals.add(literal);
	}
		
	public List<BooleanVariableInterface> getVariables() {
		Vector<BooleanVariableInterface> variables = new Vector<BooleanVariableInterface>();
		for( Iterator<CNFLiteral> it = literals.iterator() ; it.hasNext() ; ) {
			variables.add(it.next().getVariable());
		}
		return variables;
	}
	
	public int calculateSpan(Map<String,Integer> variable2indexMap) {
		int min = Integer.MAX_VALUE;
		int max = -1;
		Integer order;
		for( Iterator<CNFLiteral> it = literals.iterator() ; it.hasNext() ; ) {
			BooleanVariableInterface variable = it.next().getVariable();
			order = variable2indexMap.get(variable.getID());
			if ( order != null ) {
				if ( order < min ) {
					min = order.intValue();
				}
				if ( order > max ) {
					max = order.intValue();
				}
			}
		}
		return (max-min);
	}
	
	public List<CNFLiteral> getLiterals() {
		return literals;
	}
	
	public int countLiterals() {
		return literals.size();
	}
	
	public int countVariables() {
		return getVariables().size();
	}
	
	public int hashCode() {
		return literals.hashCode();
	}
	
	public boolean equals(Object o) {
		CNFClause clause = (CNFClause)o;
		// same number of literals
		if ( clause.getLiterals().size() != getLiterals().size() ) {
			return false;
		}
		// same literals: one way
		for( CNFLiteral literal : clause.getLiterals()) {
			if ( !getLiterals().contains(literal) ) {
				return false;
			}
		}
		// same literals: other way
		for( CNFLiteral literal : getLiterals()) {
			if ( !clause.getLiterals().contains(literal) ) {
				return false;
			}
		}
		return true;
	}
	
	public String toPropositionalFormula() {
		String formula = "";
		for( Iterator<CNFLiteral> it = literals.iterator() ; it.hasNext() ; ) {
			CNFLiteral literal = it.next();
			formula += (literal.isPositive() ? literal.getVariable().getID() : "~" + literal.getVariable().getID());
			if ( it.hasNext() ) {
				formula += " OR ";
			}
		}
		return formula;
	}
	
	public String toString() {
		StringBuffer toString = new StringBuffer(100);
		for( Iterator<CNFLiteral> it = literals.iterator() ; it.hasNext() ; ) {
			toString.append(it.next());
			if ( it.hasNext() ) {
				toString.append(" or ");
			}
		}
		return toString.toString();
	}
	
	public String toString2() {
		StringBuffer toString = new StringBuffer(100);
		for( Iterator<CNFLiteral> it = literals.iterator() ; it.hasNext() ; ) {
			toString.append(it.next().toString2());
			if ( it.hasNext() ) {
				toString.append(" or ");
			}
		}
		return toString.toString();
	}	
}
