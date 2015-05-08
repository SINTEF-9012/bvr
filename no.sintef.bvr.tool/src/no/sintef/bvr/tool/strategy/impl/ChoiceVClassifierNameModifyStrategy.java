/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June
 * 2007; you may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package no.sintef.bvr.tool.strategy.impl;

import no.sintef.bvr.tool.model.PostfixGeneratorFacade;
import no.sintef.bvr.tool.strategy.ModifyNodeStrategy;

import org.eclipse.emf.ecore.EObject;

import bvr.Choice;
import bvr.CompoundNode;
import bvr.NamedElement;
import bvr.VClassifier;

public class ChoiceVClassifierNameModifyStrategy implements ModifyNodeStrategy {

	private final PostfixGeneratorFacade postfix = PostfixGeneratorFacade.eINSTANCE;

	@Override
	public void modify(EObject eObject) {
		CompoundNode node = (CompoundNode) eObject;
		String name = ((NamedElement) node).getName();
		String new_name = name + postfix.getUnique();
		((NamedElement) node).setName(new_name);
	}

	@Override
	public boolean accept(EObject eObject) {
		if (eObject instanceof Choice || eObject instanceof VClassifier)
			return true;
		return false;
	}

}
