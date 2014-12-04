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

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.UnimplementedBVRException;

import org.eclipse.emf.common.util.EList;

import bvr.BvrFactory;
import bvr.Choice;
import bvr.CompoundNode;
import bvr.Target;
import bvr.VClassifier;
import bvr.VSpec;

public class TargetFacade {
	
	public static TargetFacade eINSTANCE = getInstance();
	
	private static TargetFacade getInstance() {
		if(eINSTANCE == null)
			eINSTANCE = new TargetFacade();
		return eINSTANCE;
	}
	
	public Target getVSpecTarget(VSpec vSpec){
		return vSpec.getTarget();
	}
	
	public Target testVSpecTarget(VSpec vSpec){
		String name = vSpec.getName();
		Target target = ((VSpec) vSpec).getTarget();
		if(target == null){
			if((vSpec instanceof VClassifier || vSpec instanceof Choice) && vSpec instanceof CompoundNode){
				EList<Target> targets = ((CompoundNode) vSpec).getOwnedTargets();
				for(Target t : targets){
					if(t.getName().equals(name)){
						target = t;
						break;
					}
				}
				if(target == null){
					target = BvrFactory.eINSTANCE.createTarget();
					Context.eINSTANCE.getEditorCommands().addTargetToCompoundNode((CompoundNode) vSpec, target);
				}
				Context.eINSTANCE.getEditorCommands().setVSpecTarget((VSpec) vSpec, target);
			} else {
				throw new UnimplementedBVRException("Can not add target to " + vSpec);
			}
		}
		return target;
	}
	
}
