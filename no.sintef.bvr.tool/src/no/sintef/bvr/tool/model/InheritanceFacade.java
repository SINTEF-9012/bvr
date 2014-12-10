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


import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.CompoundResolution;
import bvr.NegResolution;
import bvr.VSpecResolution;

public class InheritanceFacade {
	private static InheritanceFacade instance = null;

	private InheritanceFacade() {

	}

	public static synchronized InheritanceFacade getInstance() {
		if (instance == null) {
			instance = new InheritanceFacade();
		}
		return instance;
	}

	public void passInheritance(ChoiceResolution c, boolean nBool, BVRToolModel view) {
		if(c instanceof NegResolution) return;
		for (VSpecResolution x : ((CompoundResolution) c).getMembers()) {
			if (x instanceof ChoiceResolution) {
				if (((ChoiceResolution) x).getResolvedVSpec() instanceof Choice) {
					if (((Choice) x.getResolvedVSpec()).isIsImpliedByParent()) {
						ChangeChoiceFacade.eINSTANCE.setChoiceResolution(c, nBool, view);
						passInheritance((ChoiceResolution) x, nBool, view);
					}
				}
				else{//VClassifier
					passInheritance((ChoiceResolution) x, nBool, view);
				}
			}
		}
	}

	// TODO Auto-generated method stub

}
