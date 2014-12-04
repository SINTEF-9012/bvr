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
package no.sintef.bvr.tool.subject;

import bvr.FragmentSubstitution;
import no.sintef.bvr.tool.primitive.impl.ObserverDataBulk;

public class SelectedFragmentSubstitutionSubject extends AbstractViewSubject {

	private FragmentSubstitution selectedFragmentSubstitution;
	private String[] fields = {"selectedFragmentSubstitution"};
	
	public SelectedFragmentSubstitutionSubject(FragmentSubstitution fs){
		this.selectedFragmentSubstitution = fs;
	}
	
	@Override
	public void setState(ObserverDataBulk data) {
		Object value = data.getDataField("selectedFragmentSubstitution");
		selectedFragmentSubstitution = (value != null) ? (FragmentSubstitution) value : null;
	}
	
	public FragmentSubstitution getSelectedFragmentSubstitution(){
		return selectedFragmentSubstitution;
	}

	public void resetSelectedFragmentSubstitution() {
		selectedFragmentSubstitution = null;
	}
	
	@Override
	protected String[] getFileds(){
		return fields;
	}
}
