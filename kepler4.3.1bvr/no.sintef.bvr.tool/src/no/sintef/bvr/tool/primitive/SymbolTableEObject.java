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
package no.sintef.bvr.tool.primitive;

import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import bvr.NamedElement;


public interface SymbolTableEObject {

	SymbolEObject lookup(EObject element);
	
	public void insert(SymbolEObject symbol);
	
	public void delete(SymbolEObject symbol);
	
	public SymbolEObject lookup(SymbolEObject symbol);
	
	public SymbolTableEObject lookupTable(EObject eObject);
	
	public SymbolTableEObject getParent();
	
	public void setParent(SymbolTableEObject parent);
	
	public HashSet<SymbolTableEObject> getChildren();
	
	public ArrayList<SymbolEObject> getSymbols();
}
