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
package no.sintef.bvr.tool.primitive;


import org.eclipse.emf.common.util.EList;

import bvr.FragmentSubstitution;
import bvr.VSpec;
import bvr.VSpecResolution;

public interface SymbolVSpec {

	public void setVSpec(VSpec vSpec);
	
	public void setVSpecResolution(VSpecResolution vSpecResolution);
	
	public VSpec getVSpec();
	
	public VSpecResolution getVSpecResolution();
	
	public void addFragmentSubstitution(FragmentSubstitution fragmentSubstiotution);
	
	public EList<FragmentSubstitution> getFragmentSubstitutions();
	
	public FragmentSubstitution getFragmentSubstitutionCopy(FragmentSubstitution original);
	
	public void setFragmentSubstitutionCopy(FragmentSubstitution original, FragmentSubstitution copy);
	
	public EList<FragmentSubstitution> getFragmentSubstitutionsToExecute();
	
	public void addFragmentSubstitutionsToExecute(FragmentSubstitution fragment);
	
	public void setParent(SymbolVSpec parent);
	
	public SymbolVSpec getParent();
	
	public void addChild(SymbolVSpec child);
	
	public EList<SymbolVSpec> getChildren();
	
	public void setScope(SymbolVSpecResolutionTable table);
	
	public SymbolVSpecResolutionTable getScope();
	
	public void setMulti(boolean multi);
	
	public boolean getMulti();
}
