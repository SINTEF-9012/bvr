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
package splar.plugins.reasoners.bdd.javabdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import splar.core.constraints.Assignment;
import splar.core.constraints.BooleanVariable;
import splar.core.constraints.BooleanVariableInterface;

import net.sf.javabdd.BDD;

public class BDDSolutionsIterator2<T> implements Iterator<T> {

//	private BDD.BDDIterator bit;
	private Iterator bit;
	private String[] index2varMap;
	private List<Assignment> assignments; 
	private Assignment assignmentDC;   // variable dontcares (-1) are skipped  
	int j = 0;
	
	public BDDSolutionsIterator2(BDD bdd, String[] index2varMap) {
//		this.bit = bdd.allsat();
		this.bit = new BDD.BDDIterator(bdd,bdd.support());
		this.index2varMap = index2varMap;
		this.assignments = new ArrayList<Assignment>(); 
		assignmentDC = new Assignment();
	}
		
	public boolean hasNext() {
		if ( assignments.size() == 0 && !bit.hasNext() ){
			return false;
		}
		if (assignments.size() == 0) {
			BDD sol = (BDD)bit.next();
			System.out.println(sol);
			assignments.clear();
			assignments.add(new Assignment());
		}
		return true;
	}

	public T next() {	
		Assignment next = null;
		if (hasNext()) {
			next = assignments.get(0);
			assignments.remove(0);
		}
		return (T)next;
	}

	public void remove() {
		
	}
}
