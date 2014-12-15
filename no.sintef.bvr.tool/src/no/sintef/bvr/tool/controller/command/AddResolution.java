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
package no.sintef.bvr.tool.controller.command;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.model.ResolutionModelIterator;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceOccurrence;
import bvr.ChoiceResolution;
import bvr.CompoundNode;
import bvr.CompoundResolution;
import bvr.PosResolution;
import bvr.VClassOccurrence;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VSpec;
import bvr.VSpecResolution;

public class AddResolution implements ResCommand {
	private BVRToolModel view;
	private VSpec target;
	private boolean onlyOneInstance;
	private VSpecResolution parent;

	/**
	 * NOT TRANSACTIONAL ONLY for use with nodes NOT added to model
	 */
	@Override
	public ResCommand init(BVRToolModel view, VSpec vs, VSpecResolution vsr, boolean onlyOneInstance) {
		this.view = view;
		this.target = vs;
		this.parent = vsr;
		this.onlyOneInstance = onlyOneInstance;
		return this;
	}

	@Override
	public List<VSpecResolution> execute() {
		List<VSpecResolution> thisResolution = new ArrayList<VSpecResolution>();
		if (target instanceof Choice)
			thisResolution.add(addResolution((Choice) target, parent));

		if (target instanceof ChoiceOccurrence)
			thisResolution.add(addResolution((ChoiceOccurrence) target, parent));

		if (target instanceof VClassifier) {
			int min;
			if (((VClassifier) target).getInstanceMultiplicity() != null && !onlyOneInstance) {
				min = ((VClassifier) target).getInstanceMultiplicity().getLower();
			} else {
				min = 1;
			}
			for (int i = 0; i < min; i++) {
				thisResolution.add(addResolution((VClassifier) target, parent));
			}
			min = 0;
		}

		if (target instanceof VClassOccurrence) {
			VClassOccurrence vClassOccurence = (VClassOccurrence) target;
			int min = (vClassOccurence.getInstanceMultiplicity() != null && !onlyOneInstance) ? vClassOccurence.getInstanceMultiplicity().getLower()
					: 1;
			for (int i = 0; i < min; i++)
				thisResolution.add(addResolution((VClassOccurrence) target, parent));
		}

		return thisResolution;
	}

	private VSpecResolution addResolution(VClassifier target, VSpecResolution parent) {

		PosResolution thisResolution = BvrFactory.eINSTANCE.createPosResolution();
		thisResolution.setName("I:" + view.getIncrementedInstanceCount());
		thisResolution = (PosResolution) CommonUtility.setResolved(thisResolution, target);

		((CompoundResolution) parent).getMembers().add(thisResolution);
		return thisResolution;
	}

	// resolve Choice
	private VSpecResolution addResolution(Choice target, VSpecResolution parent) {

		ChoiceResolution thisResolution = BvrFactory.eINSTANCE.createPosResolution();
		thisResolution.setName(target.getName());
		thisResolution = (PosResolution) CommonUtility.setResolved(thisResolution, target);
		((CompoundResolution) parent).getMembers().add(thisResolution);
		return thisResolution;
	}

	// resolve ChoiceOccurence
	private VSpecResolution addResolution(ChoiceOccurrence target, VSpecResolution parent) {

		ChoiceResolution thisResolution = BvrFactory.eINSTANCE.createPosResolution();
		thisResolution.setName(target.getName());
		thisResolution = (PosResolution) CommonUtility.setResolved(thisResolution, target);

		for (VNode t : target.getVType().getMember()) {
			VSpec type = (VSpec) t;
			ChoiceResolution newResolution = BvrFactory.eINSTANCE.createPosResolution();
			newResolution.setName(type.getName());
			newResolution = (PosResolution) CommonUtility.setResolved(newResolution, type);
			ResolutionModelIterator.getInstance().iterateEmptyOnChildren(view, new AddMissingResolutions(), type, newResolution, false);
			((CompoundResolution) thisResolution).getMembers().add(newResolution);
		}
		/*
		 * for (VNode node : ((CompoundNode) type).getMember()) { ResolutionModelIterator.getInstance().iterateEmptyOnChildren(view, new AddMissingResolutions(), (VSpec) node, thisResolution, false);
		 * ((CompoundResolution) thisResolution).getMembers() .addAll((new AddResolution().init(view, (VSpec) type, thisResolution, false)).execute()); }
		 */((CompoundResolution) parent).getMembers().add(thisResolution);
		return thisResolution;
	}

	// resolve VClassOccurrence
	private VSpecResolution addResolution(VClassOccurrence target, VSpecResolution parent) {

		ChoiceResolution thisResolution = BvrFactory.eINSTANCE.createPosResolution();
		thisResolution.setName("I:" + view.getIncrementedInstanceCount());
		thisResolution = (PosResolution) CommonUtility.setResolved(thisResolution, target);
		((CompoundResolution) parent).getMembers().add(thisResolution);
		return thisResolution;
	}
}
