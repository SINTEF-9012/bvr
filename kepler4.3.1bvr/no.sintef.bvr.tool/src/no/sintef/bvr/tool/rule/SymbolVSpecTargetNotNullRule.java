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
package no.sintef.bvr.tool.rule;

import bvr.Target;
import bvr.VSpec;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.primitive.Symbol;
import no.sintef.bvr.tool.primitive.SymbolEObject;
import no.sintef.bvr.tool.primitive.impl.SymbolCompoundNode;

public class SymbolVSpecTargetNotNullRule implements SymbolRule {
	
	@Override
	public void execute(Symbol symbol) {
		if(!(symbol instanceof SymbolCompoundNode && ((SymbolEObject) symbol).getSymbol() instanceof VSpec))
			return;
		VSpec vSpec = (VSpec) ((SymbolEObject) symbol).getSymbol();
		Target target = vSpec.getTarget();
		if(target == null)
			Context.eINSTANCE.problemLogger.warn("Target is not set for " + vSpec.toString());
	}

}
