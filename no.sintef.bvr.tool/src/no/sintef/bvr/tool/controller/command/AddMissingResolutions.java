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
import no.sintef.bvr.tool.controller.command.AddResolution;
import no.sintef.bvr.tool.controller.command.ResCommand;
import no.sintef.bvr.tool.model.BVRToolModel;
import bvr.ChoiceOccurrence;
import bvr.CompoundResolution;
import bvr.PosResolution;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.VSpecResolution;

public class AddMissingResolutions implements ResCommand {
	private BVRToolModel view;
	private VSpec target;
	boolean unresolved;
	private VSpecResolution parent;
	/**
	 * NOT TRANSACTIONAL
	 * ONLY for use with nodes NOT added to model
	 */
	@Override
	public ResCommand init(BVRToolModel  view, VSpec target, VSpecResolution parent, boolean onlyOneInstance) {
		this.view = view;
		this.target = target;
		this.parent = parent;
		return this;
	}
	/**
	 * NOT TRANSACTIONAL
	 * ONLY for use with nodes NOT added to model
	 */
	@Override
	public List<VSpecResolution> execute() {
		ArrayList<VSpecResolution> thisResolution = new ArrayList<VSpecResolution>();
		unresolved = true;
		int instances = 0;
		int min = 0;
		
		if(parent instanceof PosResolution) {
			
			for (VSpecResolution x :((CompoundResolution) parent).getMembers()) {
				if (x.getResolvedVSpec().equals(target)) {
					thisResolution.add(x);
					unresolved = false;
					if(CommonUtility.isVSpecResolutionVClassifier(x)){
						min = ((VClassifier)x.getResolvedVSpec()).getInstanceMultiplicity().getLower();
						instances++;
					}
				}
			}
			
			while(instances < min ){
				thisResolution.addAll((ArrayList<VSpecResolution>) (new AddResolution().init(view, target, parent, true)).execute());
				instances++;
			}
			if(unresolved)
				thisResolution = (ArrayList<VSpecResolution>) (new AddResolution().init(view, target, parent, false)).execute();
		}
		return thisResolution;
	}

}
