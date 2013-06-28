package no.sintef.cvl.ui.strategy.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.exception.CVLModelException;
import no.sintef.cvl.ui.strategy.BoundaryCalculatorStrategy;

import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.ObjectHandle;
import cvl.VariationPoint;

public class FromReplacementBoundaryCalculator extends
		BoundaryCalculatorStrategy {

	FromPlacement nullFromPlacement = null;
	
	@Override
	public ArrayList<VariationPoint> getCompliedBoundaries(
			VariationPoint forBoundary, ArrayList<VariationPoint> options) throws AbstractError {
		FromReplacement fromReplacement = (FromReplacement) forBoundary;
		String propertyNameSrcObject = fromReplacement.getPropertyName();
		EObject srcObject = fromReplacement.getInsideBoundaryElement().getMOFRef();
		if(srcObject.eIsProxy()){
			throw new CVLModelException("can not resolve a proxy object, it must be a model error");
		}
		EStructuralFeature propertySrcObject = srcObject.eClass().getEStructuralFeature(propertyNameSrcObject);
		if(propertySrcObject == null){
			throw new CVLModelException("can not find property : '" + propertyNameSrcObject + "'");
		}
		int upperBound = propertySrcObject.getUpperBound();
		int lowerBound = propertySrcObject.getLowerBound();
		EClassifier srcObjectType = propertySrcObject.getEType();
		
		ArrayList<VariationPoint> fromPlacements = new ArrayList<VariationPoint>();
		for(VariationPoint boundary : options){
			if(Utility.isNullBoundary(boundary)){
				nullFromPlacement = (FromPlacement) boundary;
			}else{
				FromPlacement fromPlacement = (FromPlacement) boundary;
				EList<ObjectHandle> outsideBoundaryElementsOH = fromPlacement.getOutsideBoundaryElement();
				if(outsideBoundaryElementsOH.size() <= upperBound || upperBound == -1){
					EList<EObject> outsideBoundaryElements = Utility.resolveProxies(outsideBoundaryElementsOH);
					if(isInstance(srcObjectType, outsideBoundaryElements)){
						fromPlacements.add(boundary);
					}
				}
			}
		}
		
		if(lowerBound == 0){
			if(nullFromPlacement == null){
				throw new CVLModelException("can not find NULL boundary of the type ToReplacement");
			}
			fromPlacements.add(0, nullFromPlacement);
		}
		return fromPlacements;
	}

}
