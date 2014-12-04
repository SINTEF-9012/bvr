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

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.primitive.VisitableSymbolEObject;
import no.sintef.bvr.tool.primitive.SymbolTableEObject;
import no.sintef.bvr.tool.visitor.NodeVisitor;
import bvr.CompoundNode;
import bvr.NamedElement;

public class SymbolCompoundNode extends VisitableSymbolEObject {

	CompoundNode node;
	SymbolTableCompoundNode table;
	
	public SymbolCompoundNode(CompoundNode element) {
		node = element;
	}

	@Override
	public NamedElement getSymbol() {
		return (NamedElement) node;
	}

	@Override
	public void setSymbolTable(SymbolTableEObject stable) {
		table = (SymbolTableCompoundNode) stable;
	}

	@Override
	public SymbolTableEObject getSymbolTable() {
		return table;
	}

	@Override
	public void setSymbol(EObject element) {
		node = (CompoundNode) element;
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visitNamedElement(this);
	}

}
