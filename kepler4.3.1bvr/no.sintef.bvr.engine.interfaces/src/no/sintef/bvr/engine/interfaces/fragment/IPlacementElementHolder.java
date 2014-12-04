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
package no.sintef.bvr.engine.interfaces.fragment;

import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

import bvr.FromPlacement;
import bvr.ObjectHandle;
import bvr.PlacementFragment;
import bvr.ToPlacement;
import no.sintef.bvr.common.engine.error.BasicBVREngineException;


public interface IPlacementElementHolder extends IElementHolderOIF, IElementHolder {

	public void update() throws BasicBVREngineException;
	
	public PlacementFragment getPlacementFragment();
	
	public HashMap<FromPlacement, HashSet<EObject>> getFromPlacementInsBoundaryMap();
	
	public HashMap<ToPlacement,HashSet<EObject>> getToPlacementOutBoundaryMap();
	
	public void setFromPlacementInsBoundaryMap(HashMap<FromPlacement, HashSet<ObjectHandle>> fromPlacementInsBoundaryMap);
	
	public void setToPlacementOutBoundaryMap(HashMap<ToPlacement, HashSet<ObjectHandle>> toPlacementOHOutsideBoundaryMap);
}
