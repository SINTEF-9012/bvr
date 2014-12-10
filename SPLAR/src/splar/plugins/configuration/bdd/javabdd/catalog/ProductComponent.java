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
package splar.plugins.configuration.bdd.javabdd.catalog;

import java.util.HashSet;
import java.util.Set;

public class ProductComponent {
	
	private String id;
	private String name;
	private Set<String> types = null;

	public ProductComponent(String id, String name) {
		this.id = id;
		this.name = name;
		types = new HashSet<String>();
	}
	
	public String getID() {
		return id;
	}

	public String getName() {
		return name;
	}	
	
	public Set<String> getTypes() {
		return types;
	}
	
	public void addComponentType(String typeID) {
		types.add(typeID);
	}
	
	public String toString() {
		String toString = "Component: " + name + " [id=" + id + "]\r\n";
		toString += "   Types:\r\n";
		for( String type : types ) {
			toString += "   - " + type + "\r\n";
		}
		return toString;
	}		
}
