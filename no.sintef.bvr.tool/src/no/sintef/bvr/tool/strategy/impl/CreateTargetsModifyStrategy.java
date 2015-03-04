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
package no.sintef.bvr.tool.strategy.impl;

import org.eclipse.emf.ecore.EObject;

import bvr.BvrFactory;
import bvr.Choice;
import bvr.CompoundNode;
import bvr.NamedElement;
import bvr.Target;
import bvr.VClassifier;
import bvr.VSpec;
import no.sintef.bvr.tool.strategy.ModifyNodeStrategy;

public class CreateTargetsModifyStrategy implements ModifyNodeStrategy {

	@Override
	public void modify(EObject eObject) {
		CompoundNode node = (CompoundNode) eObject;
		String name = ((NamedElement) node).getName();
		Target target = BvrFactory.eINSTANCE.createTarget();
		target.setName(name);
		node.getOwnedTargets().add(target);
		((VSpec) node).setTarget(target);
	}

	@Override
	public boolean accept(EObject eObject) {
		if(eObject instanceof Choice || eObject instanceof VClassifier)
			return true;
		return false;
	}

}
