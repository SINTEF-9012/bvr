package no.sintef.cvl.ui.algorithms;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.exceptions.CVLModelException;

import cvl.ObjectHandle;
import cvl.ToPlacement;
import cvl.ToReplacement;
import cvl.VariationPoint;

public class ToPlacementBoundaryCalculator extends BoundaryCalculatorStrategy {
	
	ToReplacement nullToReplacement = null;

	@Override
	public ArrayList<VariationPoint> getCompliedBoundaries(
			VariationPoint forBoundary, ArrayList<VariationPoint> options) throws AbstractError {
		ToPlacement toPlacement = (ToPlacement) forBoundary;
		String propertyNameSrcObject = toPlacement.getPropertyName();
		EObject srcObject = toPlacement.getOutsideBoundaryElement().getMOFRef();
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
		
		ArrayList<VariationPoint> toReplacements = new ArrayList<VariationPoint>();
		for(VariationPoint boundary : options){
			if(Utility.isNullBoundary(boundary)){
				nullToReplacement = (ToReplacement) boundary;
			}else{
				ToReplacement toReplacement = (ToReplacement) boundary;
				EList<ObjectHandle> insideBoundaryElementsOH = toReplacement.getInsideBoundaryElement();
				if(insideBoundaryElementsOH.size() <= upperBound || upperBound == -1){
					EList<EObject> insideBoundaryElements = Utility.resolveProxies(insideBoundaryElementsOH);
					if(isInstance(srcObjectType, insideBoundaryElements)){
						toReplacements.add(boundary);
					}
				}
			}
		}
		if(lowerBound == 0){
			if(nullToReplacement == null){
				throw new CVLModelException("can not find NULL boundary of the type ToReplacement");
			}
			toReplacements.add(0, nullToReplacement);
		}
		return toReplacements;
	}
}
