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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.tool.common.LoaderUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.BVRModelException;
import no.sintef.bvr.tool.strategy.BoundaryCalculatorStrategy;
import bvr.FromPlacement;
import bvr.FromReplacement;
import bvr.NamedElement;
import bvr.ObjectHandle;
import bvr.VariationPoint;

public class FromReplacementBoundaryCalculator extends
		BoundaryCalculatorStrategy {

	private FromPlacement nullFromPlacement = null;
	private Logger logger = Context.eINSTANCE.logger;
	
	@Override
	public ArrayList<NamedElement> getCompliedBoundaries(
			NamedElement forBoundary, ArrayList<NamedElement> options) throws AbstractError {
		FromReplacement fromReplacement = (FromReplacement) forBoundary;
		String propertyNameSrcObject = fromReplacement.getPropertyName();
		EObject srcObject = fromReplacement.getInsideBoundaryElement().getMOFRef();
		if(srcObject.eIsProxy())
			throw new BVRModelException("can not resolve a proxy object, it must be a model error: " + srcObject);
		
		EStructuralFeature propertySrcObject = srcObject.eClass().getEStructuralFeature(propertyNameSrcObject);
		if(propertySrcObject == null)
			throw new BVRModelException("can not find property : '" + propertyNameSrcObject + "'");
		
		int upperBound = propertySrcObject.getUpperBound();
		int lowerBound = propertySrcObject.getLowerBound();
		EClassifier srcObjectType = propertySrcObject.getEType();
		
		logger.debug("--------------------------------------------------------------");
		logger.debug("processing fromReplacement " + fromReplacement);
		logger.debug("calculating applicable boundaries for the element '" + srcObject + "' with the property '" + propertyNameSrcObject + "' of the type '" + srcObjectType + "' with the following cardinality lowerBound=" + lowerBound + " upperBound=" + upperBound);
		
		ArrayList<NamedElement> fromPlacements = new ArrayList<NamedElement>();
		for(NamedElement boundary : options){
			if(LoaderUtility.isNullBoundary(boundary)){
				nullFromPlacement = (FromPlacement) boundary;
			}else{
				FromPlacement fromPlacement = (FromPlacement) boundary;
				
				logger.debug("processing boundary fromPlacement " + fromPlacement);
				
				EList<ObjectHandle> outsideBoundaryElementsOH = fromPlacement.getOutsideBoundaryElement();
				if(outsideBoundaryElementsOH.size() <= upperBound || upperBound == -1){
					EList<EObject> outsideBoundaryElements = LoaderUtility.resolveProxies(outsideBoundaryElementsOH);
					if(isInstance(srcObjectType, outsideBoundaryElements)){
						fromPlacements.add(boundary);
						logger.debug("the boundary is compatible");
					}else{
						logger.debug("skip boundary, some elements are not type compatible " + outsideBoundaryElements);
					}
				}else{
					logger.debug("skip boundary, too many elements which do not match the cardinality of the source object, size=" + outsideBoundaryElementsOH.size());
				}
			}
		}
		
		if(lowerBound == 0){
			if(nullFromPlacement == null){
				throw new BVRModelException("can not find NULL boundary of the type ToReplacement");
			}
			fromPlacements.add(0, nullFromPlacement);
		}else{
			logger.debug("null boundary is skipped");
		}
		logger.debug("--------------------------------------------------------------");
		return fromPlacements;
	}

}
