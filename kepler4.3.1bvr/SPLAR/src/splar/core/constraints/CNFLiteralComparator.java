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

import java.util.Comparator;

public class CNFLiteralComparator implements Comparator {
	public int compare(Object obj1, Object obj2) {
		CNFLiteral bobj1 = (CNFLiteral)obj1;
		CNFLiteral bobj2 = (CNFLiteral)obj2;
		return bobj1.getVariable().getID().compareTo(bobj2.getVariable().getID());
	}
}


