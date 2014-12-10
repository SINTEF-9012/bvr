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
package no.sintef.bvr.tool.model;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.command.AddResolution;

import bvr.BvrFactory;
import bvr.ChoiceResolution;
import bvr.CompoundResolution;
import bvr.NegResolution;
import bvr.PosResolution;
import bvr.VSpecResolution;

public class ChangeChoiceFacade {
	public static ChangeChoiceFacade eINSTANCE = getInstance();


	private static synchronized ChangeChoiceFacade getInstance() {
		if (eINSTANCE == null) {
			eINSTANCE = new ChangeChoiceFacade();
		}
		return eINSTANCE;
	}

	public ChoiceResolution setChoiceResolution(ChoiceResolution c, boolean bool, BVRToolModel bvrModel) {
		ChoiceResolution created = null;
		if (c instanceof PosResolution && !bool) {
			VSpecResolution parentResolution = ResolutionModelIterator.getInstance().getParent(bvrModel.getBVRModel(), c);
			if(parentResolution == null)
				return null; //is root or c is not in model
				
			int index = ((CompoundResolution) parentResolution).getMembers().indexOf(c);
			ChoiceResolution newRes = BvrFactory.eINSTANCE.createNegResolution();
			CommonUtility.setResolved(newRes, CommonUtility.getResolvedVSpec(c));
			newRes.setName(c.getName());
			Context.eINSTANCE.getEditorCommands().addChoiceResoulution(parentResolution, (NegResolution) newRes, index);
			Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(parentResolution, c);
			created = newRes;
		} else if (c instanceof NegResolution && bool) {
			VSpecResolution parentResolution = ResolutionModelIterator.getInstance().getParent(bvrModel.getBVRModel(), c);
			if(parentResolution == null)
				return null; //is root
			int index = ((CompoundResolution) parentResolution).getMembers().indexOf(c);
			ChoiceResolution newRes = BvrFactory.eINSTANCE.createPosResolution();
			CommonUtility.setResolved(newRes, CommonUtility.getResolvedVSpec(c));
			newRes.setName(c.getName());
			ResolutionModelIterator.getInstance().iterateEmptyOnChildren(bvrModel, new AddResolution(), CommonUtility.getResolvedVSpec(c), newRes, false);
			Context.eINSTANCE.getEditorCommands().addChoiceResoulution(parentResolution, (PosResolution) newRes, index);
			Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(parentResolution, c);
			created = newRes;
		}
		return created;
	}
	
	public void replaceChoiceResolution(ChoiceResolution parent, ChoiceResolution oldChild, ChoiceResolution newChild) {
		if(parent == null)
			return; //is root or c is not in model
		
		int index = ((CompoundResolution) parent).getMembers().indexOf(oldChild);
		Context.eINSTANCE.getEditorCommands().addChoiceResoulution(parent, newChild, index);
		Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(parent, oldChild);
	}
}
