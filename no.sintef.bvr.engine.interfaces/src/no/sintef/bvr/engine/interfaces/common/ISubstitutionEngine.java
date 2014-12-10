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
package no.sintef.bvr.engine.interfaces.common;

import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;

import bvr.FragmentSubstitution;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;
import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.engine.interfaces.fragment.IPlacementElementHolder;
import no.sintef.bvr.engine.interfaces.fragment.IReplacementElementHolder;


public interface ISubstitutionEngine {
	
	public void setLogger(Logger logger);
	
	public void init(EList<FragmentSubstitution> fragmentSubstitutions);
	
	public void subsitute(FragmentSubstitution fragmentSubstitution, boolean replace) throws RuntimeException;
	
	public HashMap<Resource, IResourceContentCopier> getCopiedBaseModels();
	
	public IBVRElementDeepCopier createBVRElementDeepCopier();
	
	public IEngineUtility getUtility();
	
	public IReplacementElementHolder createReplacementElementHolder(ReplacementFragmentType replacement);
	
	public IPlacementElementHolder createPlacementElementHolder(PlacementFragment placement);
	
}
