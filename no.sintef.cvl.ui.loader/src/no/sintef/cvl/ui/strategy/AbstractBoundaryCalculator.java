package no.sintef.cvl.ui.strategy;

import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.logging.Logger;
import no.sintef.cvl.ui.logging.impl.Logging;


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
			String className = reference.getEType().getName();
			String propertyName = reference.getName();
			fromPlacement.setName("[" + className + "]." + propertyName + "=" + this.getObjectHandlesEObjectName(fromPlacement.getOutsideBoundaryElement()));
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
		
		String className = property.getEType().getName();
		String propertyName = (String) property.eGet(property.eClass().getEStructuralFeature("name"));
		toPlacement.setName("[" + className + "]." + propertyName);
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
		
		String className = reference.getEType().getName();
		String propertyName = reference.getName();
		fromPlacement.setName("[" + className + "]." + propertyName + "={" + targetEObject.getClass().getName() + "}");
		
		placement.getPlacementBoundaryElement().add(fromPlacement);
		return fromPlacement;
	}
	
	protected String getObjectHandlesEObjectName(EList<ObjectHandle> objectHandles){
		String name = "{";
		for(ObjectHandle objectHandle : objectHandles){
			String klass = objectHandle.getMOFRef().getClass().getName();
			name+=klass + ",";
		}
		name+= "}";
		return name;
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
			String className = property.getEType().getName();
			String propertyName = property.getName();
			toReplacement.setName("[" + className + "]." + propertyName + "=" + this.getObjectHandlesEObjectName(toReplacement.getInsideBoundaryElement()));
		}
		return toReplacement;
	}
	
	protected ToReplacement createToReplacement(ReplacementFragmentType replacement, EObject sourceEObject, EObject targetEObject, EStructuralFeature property) {
		ToReplacement toReplacement = CvlFactory.eINSTANCE.createToReplacement();
		ObjectHandle targetObjectHandle = Utility.testObjectHandle(replacement, targetEObject);
		ObjectHandle sourceObjectHandle = Utility.testObjectHandle(replacement, sourceEObject);
		toReplacement.setOutsideBoundaryElement(sourceObjectHandle);
		toReplacement.getInsideBoundaryElement().add(targetObjectHandle);
		
		String className = property.getEType().getName();
		String propertyName = (String) property.eGet(property.eClass().getEStructuralFeature("name"));
		toReplacement.setName("[" + className + "]." + propertyName + "=" + this.getObjectHandlesEObjectName(toReplacement.getInsideBoundaryElement()));
		
		replacement.getReplacementBoundaryElement().add(toReplacement);
		return toReplacement;
	}
	
	protected FromReplacement createFromReplacement(ReplacementFragmentType replacement, EObject sourceEObject, EObject targetEObject, EStructuralFeature reference) {
		FromReplacement fromReplacement = CvlFactory.eINSTANCE.createFromReplacement();
		ObjectHandle targetObjectHandle = Utility.testObjectHandle(replacement, targetEObject);
		ObjectHandle sourceObjectHandle = Utility.testObjectHandle(replacement, sourceEObject);
		fromReplacement.setInsideBoundaryElement(sourceObjectHandle);
		fromReplacement.getOutsideBoundaryElement().add(targetObjectHandle);
		
		String className = reference.getEType().getName();
		String propertyName = (String) reference.eGet(reference.eClass().getEStructuralFeature("name"));
		fromReplacement.setName("[" + className + "]." + propertyName);
		fromReplacement.setPropertyName(propertyName);
		
		replacement.getReplacementBoundaryElement().add(fromReplacement);
		return fromReplacement;
	}
}
