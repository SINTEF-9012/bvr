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
package splar.core.heuristics;

import splar.core.constraints.CNFFormula;
import splar.core.fm.FeatureModel;

public abstract class FTTraversalHeuristic extends VariableOrderingHeuristic {
	
	protected FeatureModel featureModel;
	
	public FTTraversalHeuristic(String name, FeatureModel featureModel) {
		super(name);
		this.featureModel = featureModel;
	}
	
	public FeatureModel getFeatureModel() {
		return featureModel;
	}

	public void setParameter(String name, Object value) {
		if ( name.compareToIgnoreCase("feature_model") == 0 ) {
			if ( value != null && (value instanceof FeatureModel ) ) {
				featureModel = (FeatureModel)value;
			}
		}
		super.setParameter(name, value);
	}

}
