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

import java.util.ArrayList;

import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.strategy.BoundaryCalculatorStrategy;
import bvr.FromReplacement;
import bvr.NamedElement;
import bvr.ToPlacement;
import bvr.VariationPoint;

public class BoundaryCalculatorContext {

	private BoundaryCalculatorStrategy defualtToPlacementStrategy;
	private BoundaryCalculatorStrategy defaultFromReplacementStrategy;

	public BoundaryCalculatorContext(BoundaryCalculatorStrategy toPlacementStrategy, BoundaryCalculatorStrategy fromReplacementStrategy){
		defualtToPlacementStrategy = toPlacementStrategy;
		defaultFromReplacementStrategy = fromReplacementStrategy;
	}
	
	public BoundaryCalculatorContext(){
		defualtToPlacementStrategy = new ToPlacementBoundaryCalculator();
		defaultFromReplacementStrategy = new FromReplacementBoundaryCalculator();
	}
	
	public ArrayList<NamedElement> getCompliedBoundaries(NamedElement forBoundary, ArrayList<NamedElement> options) throws AbstractError{
		ArrayList<NamedElement> compliedVP;
		if(forBoundary instanceof ToPlacement){
			compliedVP = defualtToPlacementStrategy.getCompliedBoundaries(forBoundary, options);
		} else if(forBoundary instanceof FromReplacement){
			compliedVP = defaultFromReplacementStrategy.getCompliedBoundaries(forBoundary, options);
		}else{
			throw new UnsupportedOperationException("stategy is not defined for this type of boundary" + forBoundary.eClass());
		}
		return compliedVP;
	}
}
