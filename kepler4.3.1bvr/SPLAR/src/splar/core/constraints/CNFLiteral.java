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

public class CNFLiteral {
	private BooleanVariableInterface variable;
	private boolean state;
	
	public CNFLiteral(BooleanVariableInterface variable, boolean state) {
		this.variable = variable;
		this.state = state;
	}
	
	public BooleanVariableInterface getVariable() {
		return variable;
	}
	
	public boolean isPositive() {
		return state;
	}
	
	public int hashCode() {
		String hashStr = (isPositive() ? "+" : "-") + variable;   
		return hashStr.hashCode();
	}
	
	public boolean equals(Object o) {
		CNFLiteral literal = (CNFLiteral)o;
		return literal.variable.equals(variable) && (literal.isPositive() == isPositive());
	}
	
	public String toString() {
		String toString = "";
		if ( !state ) {
			toString += "~";
		}
		toString += variable.getID();
		return toString;
	}	

	public String toString2() {
		if ( !state ) {
			return "(~" + variable.getID() + ")";
		}
		return variable.getID();
	}	
}
