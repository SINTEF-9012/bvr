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
package no.sintef.bvr.constraints.bcl;

import java.util.Set;

import bvr.NamedElement;
import bvr.VSpecResolution;

public interface BCLChecker {
	// These might not be feasible with Eclipse OCL. 
	// It might be possible by guessing and trying with the boolean functions below
	// {
		// This command gives the valid single additions of "cu" at "parent"
		Set<NamedElement> getValidChildren(VSpecResolution parent);
		
		// This command gives the valid resolutions of "cu" for "vsr"
		Set<String> getValidAssignments(VSpecResolution vsr);
	// }
	
	// This command determines if a configuration is valid
	boolean isValid();
	boolean isValid(VSpecResolution vr);
	
	// This command determines if a VSpec has any valid configurations
	boolean hasConfigurations();
}
