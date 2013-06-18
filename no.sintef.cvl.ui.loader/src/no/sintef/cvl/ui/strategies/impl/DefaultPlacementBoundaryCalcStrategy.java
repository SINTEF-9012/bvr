package no.sintef.cvl.ui.strategies.impl;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;

import cvl.CvlFactory;
import cvl.FromPlacement;
import cvl.ObjectHandle;
import cvl.PlacementBoundaryElement;
import cvl.PlacementFragment;
import cvl.ToPlacement;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.logging.Logger;
import no.sintef.cvl.ui.logging.impl.Logging;
import no.sintef.cvl.ui.strategies.PlacementBoundaryCalcStrategy;

public class DefaultPlacementBoundaryCalcStrategy implements PlacementBoundaryCalcStrategy {
	
	Logger LOGGER = Logging.getLogger();

	@Override
	public void calculateBoundaries(PlacementFragment placement, EList<EObject> selection) {
		for(EObject eObject : selection){
			//calculate toPlacement-s
			Collection<Setting> refSittings = EcoreUtil.UsageCrossReferencer.find(eObject, eObject.eResource());
			for(Setting setting : refSittings){
				EObject sourceEObject = setting.getEObject();
				//object is referenced form inside of the selection
				if(selection.indexOf(sourceEObject) >= 0)
					continue;
				EStructuralFeature property = setting.getEStructuralFeature();
				Boolean isDerived = (Boolean) property.eGet(property.eClass().getEStructuralFeature("derived"));
				if(isDerived){
					LOGGER.warn("property is derived, skip it: " + property);
					continue;
				}
				this.testToPlacementBoundary(placement, sourceEObject, eObject, property);
			}
			//containment
			EObject sourceEObject = eObject.eContainer();
			if(selection.indexOf(sourceEObject) < 0){
				EStructuralFeature property = eObject.eContainingFeature();
				Boolean isDerived = (Boolean) property.eGet(property.eClass().getEStructuralFeature("derived"));
				if(isDerived){
					LOGGER.warn("property is derived, skip it: " + property);
					continue;
				}
				this.testToPlacementBoundary(placement, sourceEObject, eObject, property);
			}
			
			//calculate fromPlacement-s
			EList<EReference> references = eObject.eClass().getEAllReferences();
			for(EStructuralFeature reference : references){
				Object targetObject = eObject.eGet(reference);
				if(reference.getUpperBound() == 1){
					if(!(targetObject instanceof EObject))
						continue;
					EObject targetEObject = (EObject) targetObject;
					if(selection.indexOf(targetEObject) >= 0)
						continue;
					Boolean isDerived = (Boolean) reference.eGet(reference.eClass().getEStructuralFeature("derived"));
					if(isDerived){
						LOGGER.warn("property is derived, skip it: " + reference);
						continue;
					}
					this.testFromPlacementBoundary(placement, eObject, targetEObject, reference);
				}else{
					EList<?> targetListObjects = (EList<?>) targetObject;
					for(Object object : targetListObjects){
						if(!(object instanceof EObject))
							continue;
						EObject trgEObject = (EObject) object;
						if(selection.indexOf(trgEObject) >= 0)
							continue;
						Boolean isDerived = (Boolean) reference.eGet(reference.eClass().getEStructuralFeature("derived"));
						if(isDerived){
							LOGGER.warn("property is derived, skip it: " + reference);
							continue;
						}
						this.testFromPlacementBoundary(placement, eObject, trgEObject, reference);
					}
				}
			}
		}
		this.createNullFromPlacement(placement);
	}
	
	private void testFromPlacementBoundary(PlacementFragment placement, EObject sourceEObject, EObject targetEObject, EStructuralFeature reference) {
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
			this.createFromPlacement(placement, sourceEObject, targetEObject, reference);
		}else{
			ObjectHandle targetObjectHandle = this.testObjectHandle(placement, targetEObject);
			fromPlacement.getOutsideBoundaryElement().add(targetObjectHandle);
			String className = reference.getEType().getName();
			String propertyName = reference.getName();
			fromPlacement.setName("[" + className + "]." + propertyName + "=" + this.getObjectHandlesEObjectName(fromPlacement.getOutsideBoundaryElement()));
		}		
	}

	private void testToPlacementBoundary(PlacementFragment placement, EObject sourceEObject, EObject targetEObject, EStructuralFeature property) {
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
			this.createToPlacement(placement, sourceEObject, targetEObject, property);
		}else{
			ObjectHandle targetObjectHandle = this.testObjectHandle(placement, targetEObject);
			toPlacement.getInsideBoundaryElement().add(targetObjectHandle);
		}
	}
	
	private void createToPlacement(PlacementFragment placement, EObject sourceEObject, EObject targetEObject, EStructuralFeature property) {
		ToPlacement toPlacement = CvlFactory.eINSTANCE.createToPlacement();
		ObjectHandle targetObjectHandle = this.testObjectHandle(placement, targetEObject);
		ObjectHandle sourceObjectHandle = this.testObjectHandle(placement, sourceEObject);
		toPlacement.setOutsideBoundaryElement(sourceObjectHandle);
		toPlacement.getInsideBoundaryElement().add(targetObjectHandle);
		
		String className = property.getEType().getName();
		String propertyName = (String) property.eGet(property.eClass().getEStructuralFeature("name"));
		toPlacement.setName("[" + className + "]." + propertyName);
		toPlacement.setPropertyName(propertyName);
		
		placement.getPlacementBoundaryElement().add(toPlacement);
	}
	
	private void createFromPlacement(PlacementFragment placement, EObject sourceEObject, EObject targetEObject, EStructuralFeature reference) {
		FromPlacement fromPlacement = CvlFactory.eINSTANCE.createFromPlacement();
		ObjectHandle targetObjectHandle = this.testObjectHandle(placement, targetEObject);
		ObjectHandle sourceObjectHandle = this.testObjectHandle(placement, sourceEObject);
		fromPlacement.setInsideBoundaryElement(sourceObjectHandle);
		fromPlacement.getOutsideBoundaryElement().add(targetObjectHandle);
		
		String className = reference.getEType().getName();
		String propertyName = reference.getName();
		fromPlacement.setName("[" + className + "]." + propertyName + "={" + targetEObject.getClass().getName() + "}");
		
		placement.getPlacementBoundaryElement().add(fromPlacement);		
	}
	
	private ObjectHandle testObjectHandle(PlacementFragment placement, EObject eObject){
		EList<ObjectHandle> objectHandles = placement.getSourceObject();
		for(ObjectHandle oh : objectHandles){
			if(eObject != null && eObject.equals(oh.getMOFRef())){
				return oh;
			}else if(oh.getMOFRef() == null && eObject == null){
				return oh;
			}
		}
		ObjectHandle objectHandle = CvlFactory.eINSTANCE.createObjectHandle();
		objectHandle.setMOFRef(eObject);
		placement.getSourceObject().add(objectHandle);
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
	
	private void createNullFromPlacement(PlacementFragment placement){
		FromPlacement nullFromPlacement = CvlFactory.eINSTANCE.createFromPlacement();
		ObjectHandle nullObjectHandle = this.testObjectHandle(placement, null);
		nullFromPlacement.setInsideBoundaryElement(nullObjectHandle);
		nullFromPlacement.getOutsideBoundaryElement().add(nullObjectHandle);
		nullFromPlacement.setName(Constants.NULL_NAME);
		placement.getPlacementBoundaryElement().add(nullFromPlacement);
	}
}
