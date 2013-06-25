package no.sintef.cvl.ui.strategies.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;

import cvl.CvlFactory;
import cvl.FromReplacement;
import cvl.ObjectHandle;
import cvl.ReplacementBoundaryElement;
import cvl.ReplacementFragmentType;
import cvl.ToReplacement;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.strategies.AbstractBoundaryCalculator;
import no.sintef.cvl.ui.strategies.ReplacementBoundaryCalcStrategy;

public class DefaultReplacementBoundaryCalcStrategy extends AbstractBoundaryCalculator implements ReplacementBoundaryCalcStrategy {
	
	@Override
	public void calculateBoundaries(ReplacementFragmentType replacement, EList<EObject> selection) {
		for(EObject eObject : selection){
			//calculate toReplacement-s
			Collection<Setting> refSittings = EcoreUtil.UsageCrossReferencer.find(eObject, eObject.eResource());
			for(Setting setting : refSittings){
				EObject sourceEObject = setting.getEObject();
				//object is referenced form inside of the selection
				if(selection.indexOf(sourceEObject) >= 0)
					continue;
				EStructuralFeature property = setting.getEStructuralFeature();
				if(!isReferenceToCut(property))
					continue;
				this.testToReplacementBoundary(replacement, sourceEObject, eObject, property);
			}
			//containment
			EObject sourceEObject = eObject.eContainer();
			if(selection.indexOf(sourceEObject) < 0){
				EStructuralFeature property = eObject.eContainingFeature();
				if(!isReferenceToCut(property))
					continue;
				this.testToReplacementBoundary(replacement, sourceEObject, eObject, property);
			}
			
			//calculate fromReplacement-s
			EList<EReference> references = eObject.eClass().getEAllReferences();
			for(EStructuralFeature reference : references){
				Object targetObject = eObject.eGet(reference);
				if(reference.getUpperBound() == 1){
					if(!(targetObject instanceof EObject))
						continue;
					EObject targetEObject = (EObject) targetObject;
					if(selection.indexOf(targetEObject) >= 0)
						continue;
					if(!isReferenceToCut(reference))
						continue;
					this.testFromReplacementBoundary(replacement, eObject, targetEObject, reference);
				}else{
					EList<?> targetListObjects = (EList<?>) targetObject;
					for(Object object : targetListObjects){
						if(!(object instanceof EObject))
							continue;
						EObject trgEObject = (EObject) object;
						if(selection.indexOf(trgEObject) >= 0)
							continue;
						if(!isReferenceToCut(reference))
							continue;
						this.testFromReplacementBoundary(replacement, eObject, trgEObject, reference);
					}
				}
			}
		}
		this.createNullToReplacement(replacement);
	}
	
	private void testFromReplacementBoundary(ReplacementFragmentType replacement, EObject sourceEObject, EObject targetEObject, EStructuralFeature reference) {
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
			this.createFromReplacement(replacement, sourceEObject, targetEObject, reference);
		}else{
			ObjectHandle targetObjectHandle = this.testObjectHandle(replacement, targetEObject);
			fromReplacement.getOutsideBoundaryElement().add(targetObjectHandle);
		}		
	}

	private void testToReplacementBoundary(ReplacementFragmentType replacement, EObject sourceEObject, EObject targetEObject, EStructuralFeature property) {
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
			this.createToReplacement(replacement, sourceEObject, targetEObject, property);
		}else{
			ObjectHandle targetObjectHandle = this.testObjectHandle(replacement, targetEObject);
			toReplacement.getInsideBoundaryElement().add(targetObjectHandle);
			String className = property.getEType().getName();
			String propertyName = property.getName();
			toReplacement.setName("[" + className + "]." + propertyName + "=" + this.getObjectHandlesEObjectName(toReplacement.getInsideBoundaryElement()));
		}
	}
	
	private void createToReplacement(ReplacementFragmentType replacement, EObject sourceEObject, EObject targetEObject, EStructuralFeature property) {
		ToReplacement toReplacement = CvlFactory.eINSTANCE.createToReplacement();
		ObjectHandle targetObjectHandle = this.testObjectHandle(replacement, targetEObject);
		ObjectHandle sourceObjectHandle = this.testObjectHandle(replacement, sourceEObject);
		toReplacement.setOutsideBoundaryElement(sourceObjectHandle);
		toReplacement.getInsideBoundaryElement().add(targetObjectHandle);
		
		String className = property.getEType().getName();
		String propertyName = (String) property.eGet(property.eClass().getEStructuralFeature("name"));
		toReplacement.setName("[" + className + "]." + propertyName + "=" + this.getObjectHandlesEObjectName(toReplacement.getInsideBoundaryElement()));
		
		replacement.getReplacementBoundaryElement().add(toReplacement);
	}
	
	private void createFromReplacement(ReplacementFragmentType replacement, EObject sourceEObject, EObject targetEObject, EStructuralFeature reference) {
		FromReplacement fromReplacement = CvlFactory.eINSTANCE.createFromReplacement();
		ObjectHandle targetObjectHandle = this.testObjectHandle(replacement, targetEObject);
		ObjectHandle sourceObjectHandle = this.testObjectHandle(replacement, sourceEObject);
		fromReplacement.setInsideBoundaryElement(sourceObjectHandle);
		fromReplacement.getOutsideBoundaryElement().add(targetObjectHandle);
		
		String className = reference.getEType().getName();
		String propertyName = (String) reference.eGet(reference.eClass().getEStructuralFeature("name"));
		fromReplacement.setName("[" + className + "]." + propertyName);
		fromReplacement.setPropertyName(propertyName);
		
		replacement.getReplacementBoundaryElement().add(fromReplacement);		
	}
	
	private ObjectHandle testObjectHandle(ReplacementFragmentType replacement, EObject eObject){
		EList<ObjectHandle> objectHandles = replacement.getSourceObject();
		for(ObjectHandle oh : objectHandles){
			if(eObject != null && eObject.equals(oh.getMOFRef())){
				return oh;
			}else if(oh.getMOFRef() == null && eObject == null){
				return oh;
			}
		}
		ObjectHandle objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
		objectHandle.setMOFRef(eObject);
		replacement.getSourceObject().add(objectHandle);
		return objectHandle;
	}
	
	private String getObjectHandlesEObjectName(EList<ObjectHandle> objectHandles){
		String name = "{";
		for(ObjectHandle objectHandle : objectHandles){
			String klass = objectHandle.getMOFRef().getClass().getName();
			name+=klass + ",";
		}
		name+= "}";
		return name;
	}
	
	private void createNullToReplacement(ReplacementFragmentType replacement){
		ToReplacement nullToReplacement = CvlFactory.eINSTANCE.createToReplacement();
		ObjectHandle nullObjectHandle = this.testObjectHandle(replacement, null);
		nullToReplacement.setName(Constants.NULL_NAME);
		nullToReplacement.setOutsideBoundaryElement(nullObjectHandle);
		nullToReplacement.getInsideBoundaryElement().add(nullObjectHandle);
		replacement.getReplacementBoundaryElement().add(nullToReplacement);
	}
}
