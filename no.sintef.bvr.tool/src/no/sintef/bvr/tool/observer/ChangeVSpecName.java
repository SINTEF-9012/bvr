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
package no.sintef.bvr.tool.observer;

import java.util.Set;

import no.sintef.bvr.tool.interfaces.model.IBVRToolModel;
import no.sintef.bvr.tool.interfaces.observer.ResourceObserver;
import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;
import no.sintef.bvr.tool.model.VSpecFacade;
import bvr.Target;
import bvr.VSpec;

public class ChangeVSpecName implements ResourceObserver {

	private IBVRToolModel toolModel;

	public ChangeVSpecName(IBVRToolModel _toolModel) {
		toolModel = _toolModel;
	}

	@Override
	public void update(ResourceSubject subject) {
		if (!(subject instanceof TargetChangedSubject))
			return;

		TargetChangedSubject targetSubject = ((TargetChangedSubject) subject);

		Target changedTarget = targetSubject.getTarget();
		if (changedTarget == null)
			return;

		String new_name = targetSubject.getName();
		if (new_name == null)
			return;

		Set<VSpec> vspecs = targetSubject.getVSpecs();
		if (vspecs != null) {
			for (VSpec vspec : vspecs)
				VSpecFacade.eINSTANCE.updateName(vspec, new_name);
		}
	}

}
