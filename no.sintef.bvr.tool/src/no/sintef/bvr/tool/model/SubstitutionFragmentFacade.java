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

import bvr.BvrFactory;
import bvr.FragmentSubstitution;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;

public class SubstitutionFragmentFacade {

	public static SubstitutionFragmentFacade eINSTANCE = getInstance();
	private static final String defaultPlacementName = "Placement";
	private static final String defaultReplacementName = "Replacement";
	private static final String defualtFragmentSubstitutionName = "FragmentSubstititution";
	private static int countReplacement = 0;
	private static int countPlacement = 0;
	private static int countFragment = 0;
	
	private static SubstitutionFragmentFacade getInstance() {
		if(eINSTANCE == null)
			eINSTANCE = new SubstitutionFragmentFacade();
		return eINSTANCE;
	}
	
	public PlacementFragment createPlacementFragment() {
		PlacementFragment placement = BvrFactory.eINSTANCE.createPlacementFragment();
		placement.setName(defaultPlacementName + countPlacement);
		countPlacement++;
		return placement;
	}

	public ReplacementFragmentType createReplacementFragment() {
		ReplacementFragmentType replacement = BvrFactory.eINSTANCE.createReplacementFragmentType();
		replacement.setName(defaultReplacementName + countReplacement);
		countReplacement++;
		return replacement;
	}

	public FragmentSubstitution createFragmentSubstitution() {
		FragmentSubstitution fs = BvrFactory.eINSTANCE.createFragmentSubstitution();
		fs.setName(defualtFragmentSubstitutionName + countFragment);
		countFragment++;
		return fs;
	}
}
