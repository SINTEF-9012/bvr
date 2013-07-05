package no.sintef.cvl.ui.strategy;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.logging.Logger;
import no.sintef.cvl.ui.logging.impl.Logging;


import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import cvl.CvlFactory;
import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.ObjectHandle;
import cvl.PlacementBoundaryElement;
import cvl.PlacementFragment;
import cvl.ReplacementBoundaryElement;
import cvl.ReplacementFragmentType;
import cvl.ToPlacement;
import cvl.ToReplacement;

public class AbstractBoundaryCalculator {
	
	protected Logger LOGGER = Logging.getLogger(); 

	protected boolean isReferenceToCut(EStructuralFeature property){
		boolean yes = true;
		/*The value of a derived feature is computed from other
		features, so it doesn't represent any additional object
		state. Framework classes, such as EcoreUtil.Copier,
		that copy model objects will not attempt to copy such
		features. The generated code is unaffected by the value
		of the derived flag. Derived features are typically also
		marked volatile and transient.*/
		Boolean isDerived = (Boolean) property.eGet(property.eClass().getEStructuralFeature("derived"));
		if(isDerived){
			yes = false;
			LOGGER.warn("property is derived, skip it: " + property);
		}
		/*Transient features are used to declare (modeled) data
		whose lifetime never spans application invocations and
		therefore doesn't need to be persisted. The (default XMI)
		serializer will not save features that are declared to be
		transient.*/
		Boolean isTransient = (Boolean) property.eGet(property.eClass().getEStructuralFeature("transient"));
		if(isTransient){
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
				if(sourceEObject.equals(fromP.getInsideBoundaryElement().getMOFRef())){
					fromPlacement = fromP;
					break;
				}
			}
		}
		if(fromPlacement == null){
			fromPlacement = createFromPlacement(placement, sourceEObject, targetEObject, reference);
		}else{
			ObjectHandle targetObjectHandle = Utility.testObjectHandle(placement, targetEObject);
			fromPlacement.getOutsideBoundaryElement().add(targetObjectHandle);
			fromPlacement.setName(createBoundaryName(sourceEObject, Utility.resolveProxies(fromPlacement.getOutsideBoundaryElement()), reference, true));
		}
		return fromPlacement;
	}

	protected ToPlacement testToPlacementBoundary(PlacementFragment placement, EObject sourceEObject, EObject targetEObject, EStructuralFeature property) {
		ToPlacement toPlacement = null;
		String propertyName = (String) property.eGet(property.eClass().getEStructuralFeature("name"));
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
			ObjectHandle targetObjectHandle = Utility.testObjectHandle(placement, targetEObject);
			toPlacement.getInsideBoundaryElement().add(targetObjectHandle);
		}
		return toPlacement;
	}
	
	protected ToPlacement createToPlacement(PlacementFragment placement, EObject sourceEObject, EObject targetEObject, EStructuralFeature property) {
		ToPlacement toPlacement = CvlFactory.eINSTANCE.createToPlacement();
		ObjectHandle targetObjectHandle = Utility.testObjectHandle(placement, targetEObject);
		ObjectHandle sourceObjectHandle = Utility.testObjectHandle(placement, sourceEObject);
		toPlacement.setOutsideBoundaryElement(sourceObjectHandle);
		toPlacement.getInsideBoundaryElement().add(targetObjectHandle);
		toPlacement.setName(createBoundaryName(sourceEObject, null, property, false));
		String propertyName = (String) property.eGet(property.eClass().getEStructuralFeature("name"));
		toPlacement.setPropertyName(propertyName);
		placement.getPlacementBoundaryElement().add(toPlacement);
		return toPlacement;
	}
	
	protected FromPlacement createFromPlacement(PlacementFragment placement, EObject sourceEObject, EObject targetEObject, EStructuralFeature reference) {
		FromPlacement fromPlacement = CvlFactory.eINSTANCE.createFromPlacement();
		ObjectHandle targetObjectHandle = Utility.testObjectHandle(placement, targetEObject);
		ObjectHandle sourceObjectHandle = Utility.testObjectHandle(placement, sourceEObject);
		fromPlacement.setInsideBoundaryElement(sourceObjectHandle);
		fromPlacement.getOutsideBoundaryElement().add(targetObjectHandle);
		BasicEList<EObject> list = new BasicEList<EObject>();
		list.add(targetEObject);
		fromPlacement.setName(createBoundaryName(sourceEObject, list, reference, true));
		placement.getPlacementBoundaryElement().add(fromPlacement);
		return fromPlacement;
	}
		
	protected FromReplacement testFromReplacementBoundary(ReplacementFragmentType replacement, EObject sourceEObject, EObject targetEObject, EStructuralFeature reference) {
		FromReplacement fromReplacement = null;
		String propertyName = (String) reference.eGet(reference.eClass().getEStructuralFeature("name"));
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
			ObjectHandle targetObjectHandle = Utility.testObjectHandle(replacement, targetEObject);
			fromReplacement.getOutsideBoundaryElement().add(targetObjectHandle);
		}
		return fromReplacement;
	}

	protected ToReplacement testToReplacementBoundary(ReplacementFragmentType replacement, EObject sourceEObject, EObject targetEObject, EStructuralFeature property) {
		ToReplacement toReplacement = null;
		EList<ReplacementBoundaryElement> replacementBoundaries = replacement.getReplacementBoundaryElement();
		for(ReplacementBoundaryElement boundary : replacementBoundaries){
			if(boundary instanceof ToReplacement){
				ToReplacement toR = (ToReplacement) boundary;
				if(sourceEObject.equals(toR.getOutsideBoundaryElement().getMOFRef())){
					toReplacement = toR;
					break;
				}
			}
		}
		if(toReplacement == null){
			toReplacement = createToReplacement(replacement, sourceEObject, targetEObject, property);
		}else{
			ObjectHandle targetObjectHandle = Utility.testObjectHandle(replacement, targetEObject);
			toReplacement.getInsideBoundaryElement().add(targetObjectHandle);
			BasicEList<EObject> list = new BasicEList<EObject>();
			list.add(targetEObject);
			toReplacement.setName(createBoundaryName(sourceEObject, list, property, true));
		}
		return toReplacement;
	}
	
	protected ToReplacement createToReplacement(ReplacementFragmentType replacement, EObject sourceEObject, EObject targetEObject, EStructuralFeature property) {
		ToReplacement toReplacement = CvlFactory.eINSTANCE.createToReplacement();
		ObjectHandle targetObjectHandle = Utility.testObjectHandle(replacement, targetEObject);
		ObjectHandle sourceObjectHandle = Utility.testObjectHandle(replacement, sourceEObject);
		toReplacement.setOutsideBoundaryElement(sourceObjectHandle);
		toReplacement.getInsideBoundaryElement().add(targetObjectHandle);
		BasicEList<EObject> list = new BasicEList<EObject>();
		list.add(targetEObject);
		toReplacement.setName(createBoundaryName(sourceEObject, list, property, true));
		replacement.getReplacementBoundaryElement().add(toReplacement);
		return toReplacement;
	}
	
	protected FromReplacement createFromReplacement(ReplacementFragmentType replacement, EObject sourceEObject, EObject targetEObject, EStructuralFeature reference) {
		FromReplacement fromReplacement = CvlFactory.eINSTANCE.createFromReplacement();
		ObjectHandle targetObjectHandle = Utility.testObjectHandle(replacement, targetEObject);
		ObjectHandle sourceObjectHandle = Utility.testObjectHandle(replacement, sourceEObject);
		fromReplacement.setInsideBoundaryElement(sourceObjectHandle);
		fromReplacement.getOutsideBoundaryElement().add(targetObjectHandle);
		String propertyName = (String) reference.eGet(reference.eClass().getEStructuralFeature("name"));
		fromReplacement.setName(createBoundaryName(sourceEObject, null, reference, false));
		fromReplacement.setPropertyName(propertyName);
		replacement.getReplacementBoundaryElement().add(fromReplacement);
		return fromReplacement;
	}
	
	protected String createBoundaryName(EObject sourceEObject, EList<EObject> targetEObjects, EStructuralFeature reference, boolean showTargets){
		Pattern classPattern = Pattern.compile("(\\w*)$");
		String sourceObjectClass = sourceEObject.eClass().getName();
		Matcher matcher = classPattern.matcher(sourceObjectClass); matcher.find();
		sourceObjectClass = matcher.group(matcher.groupCount() - 1);
		String sourceObjectName = getEObjectName(sourceEObject);
		
		String referenceType = reference.getEType().getName();
		String referenceName = (String) reference.eGet(reference.eClass().getEStructuralFeature("name"));
		
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
