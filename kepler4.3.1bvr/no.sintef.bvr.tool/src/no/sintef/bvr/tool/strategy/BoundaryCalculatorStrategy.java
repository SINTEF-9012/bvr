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
package no.sintef.bvr.tool.strategy;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.exception.AbstractError;
import bvr.NamedElement;
import bvr.VariationPoint;

public abstract class BoundaryCalculatorStrategy {

	public abstract ArrayList<NamedElement> getCompliedBoundaries(NamedElement forBoundary, ArrayList<NamedElement> options) throws AbstractError;
	
	protected boolean isInstance(EClassifier eClassifier, EList<EObject> eObjectList){
		for(EObject eObject : eObjectList){
			if(!eClassifier.isInstance(eObject)){
				return false;
			}
		}
		return true;
	}
	
	protected boolean isInstance(EClassifier eClassifier, EObject eObject){
		return eClassifier.isInstance(eObject);
	}
}
