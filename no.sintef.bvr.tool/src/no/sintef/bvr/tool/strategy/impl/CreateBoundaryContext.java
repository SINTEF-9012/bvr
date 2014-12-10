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
package no.sintef.bvr.tool.strategy.impl;

import no.sintef.bvr.tool.strategy.PlacementBoundaryCalcStrategy;
import no.sintef.bvr.tool.strategy.ReplacementBoundaryCalcStrategy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.NamedElement;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;

public class CreateBoundaryContext {

	private PlacementBoundaryCalcStrategy defaultPlacementCalc;
	private ReplacementBoundaryCalcStrategy defaultReplacementCalc;

	public CreateBoundaryContext(){
		defaultPlacementCalc = new DefaultPlacementBoundaryCalcStrategy();
		defaultReplacementCalc = new DefaultReplacementBoundaryCalcStrategy();
	}
	
	public CreateBoundaryContext(PlacementBoundaryCalcStrategy placementCalcStrategy, ReplacementBoundaryCalcStrategy replacementCalcStrategy){
		defaultPlacementCalc = placementCalcStrategy;
		defaultReplacementCalc = replacementCalcStrategy;
	}
	
	public void creatBoundaries(NamedElement fragment, EList<EObject> selectedElements){
		PlacementFragment placement = null;
		ReplacementFragmentType replacement = null;
		if(fragment instanceof PlacementFragment && defaultPlacementCalc != null){
			placement = (PlacementFragment) fragment;
			defaultPlacementCalc.calculateBoundaries(placement, selectedElements);
		}else if (fragment instanceof ReplacementFragmentType && defaultReplacementCalc != null){
			replacement = (ReplacementFragmentType) fragment;
			defaultReplacementCalc.calculateBoundaries(replacement, selectedElements);
		}else{
			throw new UnsupportedOperationException("fragment should be either PlacementFragment or ReplacementFragmentType; is corresponding strategy set?");
		}
	}
}
