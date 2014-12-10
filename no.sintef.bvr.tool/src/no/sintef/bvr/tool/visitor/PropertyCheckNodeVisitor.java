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
package no.sintef.bvr.tool.visitor;

import java.util.Arrays;
import java.util.HashSet;

import no.sintef.bvr.tool.primitive.SymbolEObject;
import no.sintef.bvr.tool.rule.SymbolRule;
import no.sintef.bvr.tool.rule.SymbolVSpecTargetNotNullRule;
import no.sintef.bvr.tool.rule.SymbolVSpecTargetScopeRule;

public class PropertyCheckNodeVisitor extends AbstractNodeVisitor {

	private HashSet<SymbolRule> rulesSymbolNamedElement = new HashSet<SymbolRule>(Arrays.asList(
			new SymbolVSpecTargetNotNullRule(),
			new SymbolVSpecTargetScopeRule()));
	
	@Override
	public void visitNamedElement(SymbolEObject element) {
		super.visitNamedElement(element);
		for(SymbolRule rule : rulesSymbolNamedElement)
			rule.execute(element);	
	}
}
