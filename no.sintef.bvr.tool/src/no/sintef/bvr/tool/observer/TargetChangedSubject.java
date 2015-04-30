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

import no.sintef.bvr.tool.interfaces.observer.AbstractResourceSubject;
import bvr.Target;
import bvr.VSpec;

public class TargetChangedSubject extends AbstractResourceSubject {

	private Target new_target;
	private Target stale_target;
	private String new_name;
	private Set<VSpec> vspecs;

	public Target getCurrentTarget() {
		return new_target;
	}

	public void setCurrentTarget(Target target) {
		new_target = target;
	}

	public String getCurrentName() {
		return new_name;
	}

	public void setCurrentName(String name) {
		new_name = name;
	}

	public Set<VSpec> getVSpecs() {
		return vspecs;
	}

	public void setVSpecs(Set<VSpec> vspecs) {
		this.vspecs = vspecs;
	}

	public Target getStaleTarget() {
		return stale_target;
	}

	public void setStaleTarget(Target stale_target) {
		this.stale_target = stale_target;
	}

}
