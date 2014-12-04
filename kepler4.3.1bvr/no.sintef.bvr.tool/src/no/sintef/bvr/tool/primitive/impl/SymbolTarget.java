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
package no.sintef.bvr.tool.primitive.impl;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import bvr.NamedElement;
import bvr.Target;
import no.sintef.bvr.tool.primitive.VisitableSymbolEObject;
import no.sintef.bvr.tool.primitive.SymbolEObject;
import no.sintef.bvr.tool.primitive.SymbolTableEObject;
import no.sintef.bvr.tool.visitor.NodeVisitor;

public class SymbolTarget extends VisitableSymbolEObject {

	private Target target;
	private SymbolTableEObject table;
	private HashSet<SymbolEObject> refVSpecs;
	
	public SymbolTarget(Target trg) {
		target = trg;
		refVSpecs = new HashSet<SymbolEObject>();
	}

	@Override
	public NamedElement getSymbol() {
		return target;
	}

	@Override
	public void setSymbolTable(SymbolTableEObject stable) {
		table = stable;
	}

	@Override
	public SymbolTableEObject getSymbolTable() {
		return table;
	}
	
	public void addReferencedSymbols(SymbolEObject SymbolNamedElement) {
		refVSpecs.add(SymbolNamedElement);
	}
	
	public HashSet<SymbolEObject> getReferencedSymbols() {
		return refVSpecs;
	}

	@Override
	public void setSymbol(EObject element) {
		target = (Target) element;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visitNamedElement(this);
	}

}
