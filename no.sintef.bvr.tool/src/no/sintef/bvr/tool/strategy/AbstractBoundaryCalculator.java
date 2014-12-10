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

import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.tool.common.LoaderUtility;
import no.sintef.bvr.tool.context.Context;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import bvr.BvrFactory;
import bvr.FromPlacement;
import bvr.FromReplacement;
import bvr.ObjectHandle;
import bvr.PlacementBoundaryElement;
import bvr.PlacementFragment;
import bvr.ReplacementBoundaryElement;
import bvr.ReplacementFragmentType;
import bvr.ToPlacement;
import bvr.ToReplacement;

public class AbstractBoundaryCalculator {
	
	protected Logger LOGGER = Context.eINSTANCE.logger;
	protected HashMap<EStructuralFeature, FromPlacement> refFromPlacMap;
	protected HashMap<EStructuralFeature, ToReplacement> refToReplacMap;

	protected boolean isReferenceToCut(EStructuralFeature property){
		boolean yes = true;
		int result = CommonUtility.isDerived(property);
		if(CommonUtility.unMask(result, CommonUtility.DERIVED)  == CommonUtility.DERIVED){
			yes = false;
			LOGGER.warn("property is derived, skip it: " + property);
		}
		if(CommonUtility.unMask(result, CommonUtility.TRANSIENT)  == CommonUtility.TRANSIENT){
			yes = false;
			LOGGER.warn("property is transient, skip it: " + property);
		}
		return yes;
	}
	
	protected FromPlacement testFromPlacementBoundary(PlacementFragment placement, EObject sourceEObject, EObject targetEObject, EStructuralFeature reference) {
		FromPlacement fromPlacement = null;
		EList<PlacementBoundaryElement> placementBoundaries = placement.getPlacementBoundaryElement();
		for(PlacementBoundaryElement boundary : placementBoundaries){
			if(boundary instanceof FromPlacement){
				FromPlacement fromP = (FromPlacement) boundary;
				FromPlacement fromPRef = refFromPlacMap.get(reference);
				if(fromP.equals(fromPRef) && sourceEObject.equals(fromP.getInsideBoundaryElement().getMOFRef())){
					fromPlacement = fromP;
					break;
				}
			}
		}
		if(fromPlacement == null){
			fromPlacement = createFromPlacement(placement, sourceEObject, targetEObject, reference);
		}else{
			ObjectHandle targetObjectHandle = LoaderUtility.testObjectHandle(placement, targetEObject);
			fromPlacement.getOutsideBoundaryElement().add(targetObjectHandle);
			fromPlacement.setName(createBoundaryName(sourceEObject, LoaderUtility.resolveProxies(fromPlacement.getOutsideBoundaryElement()), reference, true));
		}
		return fromPlacement;
	}
	
	protected FromReplacement testFromReplacementBoundary(ReplacementFragmentType replacement, EObject sourceEObject, EObject targetEObject, EStructuralFeature reference) {
		FromReplacement fromReplacement = null;
		String propertyName = reference.getName();
		EList<ReplacementBoundaryElement> replacementBoundaries = replacement.getReplacementBoundaryElement();
		for(ReplacementBoundaryElement boundary : replacementBoundaries){
			if(boundary instanceof FromReplacement){
				FromReplacement fromR = (FromReplacement) boundary;
				if(fromR.getPropertyName().equals(propertyName) && sourceEObject.equals(fromR.getInsideBoundaryElement().getMOFRef())){
					fromReplacement = fromR;
					break;
				}
			}
		}
		if(fromReplacement == null){
			fromReplacement = createFromReplacement(replacement, sourceEObject, targetEObject, reference);
		}else{
			ObjectHandle targetObjectHandle = LoaderUtility.testObjectHandle(replacement, targetEObject);
			fromReplacement.getOutsideBoundaryElement().add(targetObjectHandle);
		}
		return fromReplacement;
	}

	protected ToPlacement testToPlacementBoundary(PlacementFragment placement, EObject sourceEObject, EObject targetEObject, EStructuralFeature property) {
		ToPlacement toPlacement = null;
		String propertyName = property.getName();
		EList<PlacementBoundaryElement> placementBoundaries = placement.getPlacementBoundaryElement();
		for(PlacementBoundaryElement boundary : placementBoundaries){
			if(boundary instanceof ToPlacement){
				ToPlacement toP = (ToPlacement) boundary;
				if(toP.getPropertyName().equals(propertyName) && sourceEObject.equals(toP.getOutsideBoundaryElement().getMOFRef())){
					toPlacement = toP;
					break;
				}
			}
		}
		if(toPlacement == null){
			toPlacement = createToPlacement(placement, sourceEObject, targetEObject, property);
		}else{
			ObjectHandle targetObjectHandle = LoaderUtility.testObjectHandle(placement, targetEObject);
			//toPlacement.getInsideBoundaryElement().add(targetObjectHandle);
			Context.eINSTANCE.getEditorCommands().addInsideBElementToPlacement(toPlacement, targetObjectHandle);
		}
		return toPlacement;
	}
	
	protected ToReplacement testToReplacementBoundary(ReplacementFragmentType replacement, EObject sourceEObject, EObject targetEObject, EStructuralFeature property) {
		ToReplacement toReplacement = null;
		EList<ReplacementBoundaryElement> replacementBoundaries = replacement.getReplacementBoundaryElement();
		for(ReplacementBoundaryElement boundary : replacementBoundaries){
			if(boundary instanceof ToReplacement){
				ToReplacement toR = (ToReplacement) boundary;
				ToReplacement toRRef = refToReplacMap.get(property);
				if(toR.equals(toRRef) && sourceEObject.equals(toR.getOutsideBoundaryElement().getMOFRef())){
					toReplacement = toR;
					break;
				}
			}
		}
		if(toReplacement == null){
			toReplacement = createToReplacement(replacement, sourceEObject, targetEObject, property);
		}else{
			ObjectHandle targetObjectHandle = LoaderUtility.testObjectHandle(replacement, targetEObject);
			toReplacement.getInsideBoundaryElement().add(targetObjectHandle);
			toReplacement.setName(createBoundaryName(sourceEObject, LoaderUtility.resolveProxies(toReplacement.getInsideBoundaryElement()), property, true));
		}
		return toReplacement;
	}	
	
	protected ToPlacement createToPlacement(PlacementFragment placement, EObject sourceEObject, EObject targetEObject, EStructuralFeature property) {
		ToPlacement toPlacement = BvrFactory.eINSTANCE.createToPlacement();
		ObjectHandle targetObjectHandle = LoaderUtility.testObjectHandle(placement, targetEObject);
		ObjectHandle sourceObjectHandle = LoaderUtility.testObjectHandle(placement, sourceEObject);
		toPlacement.setOutsideBoundaryElement(sourceObjectHandle);
		toPlacement.getInsideBoundaryElement().add(targetObjectHandle);
		toPlacement.setName(createBoundaryName(sourceEObject, null, property, false));
		String propertyName = property.getName();
		toPlacement.setPropertyName(propertyName);
		//placement.getPlacementBoundaryElement().add(toPlacement);
		Context.eINSTANCE.getEditorCommands().addPlacementBoundaryElement(placement, toPlacement);
		return toPlacement;
	}
	
	protected FromPlacement createFromPlacement(PlacementFragment placement, EObject sourceEObject, EObject targetEObject, EStructuralFeature reference) {
		FromPlacement fromPlacement = BvrFactory.eINSTANCE.createFromPlacement();
		ObjectHandle targetObjectHandle = LoaderUtility.testObjectHandle(placement, targetEObject);
		ObjectHandle sourceObjectHandle = LoaderUtility.testObjectHandle(placement, sourceEObject);
		fromPlacement.setInsideBoundaryElement(sourceObjectHandle);
		fromPlacement.getOutsideBoundaryElement().add(targetObjectHandle);
		fromPlacement.setName(createBoundaryName(sourceEObject, LoaderUtility.resolveProxies(fromPlacement.getOutsideBoundaryElement()), reference, true));
		//placement.getPlacementBoundaryElement().add(fromPlacement);
		Context.eINSTANCE.getEditorCommands().addPlacementBoundaryElement(placement, fromPlacement);
		return fromPlacement;
	}
	
	protected ToReplacement createToReplacement(ReplacementFragmentType replacement, EObject sourceEObject, EObject targetEObject, EStructuralFeature property) {
		ToReplacement toReplacement = BvrFactory.eINSTANCE.createToReplacement();
		ObjectHandle targetObjectHandle = LoaderUtility.testObjectHandle(replacement, targetEObject);
		ObjectHandle sourceObjectHandle = LoaderUtility.testObjectHandle(replacement, sourceEObject);
		toReplacement.setOutsideBoundaryElement(sourceObjectHandle);
		toReplacement.getInsideBoundaryElement().add(targetObjectHandle);
		toReplacement.setName(createBoundaryName(sourceEObject, LoaderUtility.resolveProxies(toReplacement.getInsideBoundaryElement()), property, true));
		//replacement.getReplacementBoundaryElement().add(toReplacement);
		Context.eINSTANCE.getEditorCommands().addReplacementBoundaryElement(replacement, toReplacement);
		return toReplacement;
	}
	
	protected FromReplacement createFromReplacement(ReplacementFragmentType replacement, EObject sourceEObject, EObject targetEObject, EStructuralFeature reference) {
		FromReplacement fromReplacement = BvrFactory.eINSTANCE.createFromReplacement();
		ObjectHandle targetObjectHandle = LoaderUtility.testObjectHandle(replacement, targetEObject);
		ObjectHandle sourceObjectHandle = LoaderUtility.testObjectHandle(replacement, sourceEObject);
		fromReplacement.setInsideBoundaryElement(sourceObjectHandle);
		fromReplacement.getOutsideBoundaryElement().add(targetObjectHandle);
		String propertyName = reference.getName();
		fromReplacement.setName(createBoundaryName(sourceEObject, null, reference, false));
		fromReplacement.setPropertyName(propertyName);
		//replacement.getReplacementBoundaryElement().add(fromReplacement);
		Context.eINSTANCE.getEditorCommands().addReplacementBoundaryElement(replacement, fromReplacement);
		return fromReplacement;
	}
	
	protected String createBoundaryName(EObject sourceEObject, EList<EObject> targetEObjects, EStructuralFeature reference, boolean showTargets){
		Pattern classPattern = Pattern.compile("(\\w*)$");
		String sourceObjectClass = sourceEObject.eClass().getName();
		Matcher matcher = classPattern.matcher(sourceObjectClass); matcher.find();
		sourceObjectClass = matcher.group(matcher.groupCount() - 1);
		String sourceObjectName = getEObjectName(sourceEObject);
		
		String referenceType = reference.getEType().getName();
		String referenceName = reference.getName();
		
		String boundaryName = "((" + sourceObjectClass + ") " + sourceObjectName + ").<" + referenceType + ">" + referenceName;
		
		if(showTargets){
			boundaryName = boundaryName + "[" + targetEObjects.size() + "]=" + getReferencedNameSet(targetEObjects);
		}
		return boundaryName;
	}
	
	private String getEObjectName(EObject eObject){
		Pattern pattern = Pattern.compile("(\\w*)$");
		String eObjectName = eObject.eClass().getClass().getCanonicalName();
		Matcher matcher = pattern.matcher(eObjectName); matcher.find();
		eObjectName = matcher.group(matcher.groupCount() - 1);
		eObjectName = "'" + eObjectName +"'";
		EStructuralFeature nameProperty = eObject.eClass().getEStructuralFeature("name");
		if(nameProperty == null)
			nameProperty = eObject.eClass().getEStructuralFeature("id");
		if(nameProperty != null)
			eObjectName = (String) eObject.eGet(nameProperty);
		return eObjectName;
	}
	
	private String getReferencedNameSet(EList<EObject> eObjects){
		String name = "{";
		for(Iterator<EObject> iterator = eObjects.iterator(); iterator.hasNext();){
			EObject eObject = iterator.next();
			String nameEObject = getEObjectName(eObject);
			name+= (iterator.hasNext()) ? nameEObject + "," : nameEObject;
		}
		name+= "}";
		return name;		
	}
}
