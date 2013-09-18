package no.sintef.cvl.ui.strategy.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import no.sintef.cvl.common.logging.Logger;
import no.sintef.cvl.ui.common.LoaderUtility;
import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.exception.CVLModelException;
import no.sintef.cvl.ui.strategy.BoundaryCalculatorStrategy;

import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.ObjectHandle;
import cvl.VariationPoint;

public class FromReplacementBoundaryCalculator extends
		BoundaryCalculatorStrategy {

	private FromPlacement nullFromPlacement = null;
	private Logger logger = Context.eINSTANCE.logger;
	
	@Override
	public ArrayList<VariationPoint> getCompliedBoundaries(
			VariationPoint forBoundary, ArrayList<VariationPoint> options) throws AbstractError {
		FromReplacement fromReplacement = (FromReplacement) forBoundary;
		String propertyNameSrcObject = fromReplacement.getPropertyName();
		EObject srcObject = fromReplacement.getInsideBoundaryElement().getMOFRef();
		if(srcObject.eIsProxy())
			throw new CVLModelException("can not resolve a proxy object, it must be a model error: " + srcObject);
		
		EStructuralFeature propertySrcObject = srcObject.eClass().getEStructuralFeature(propertyNameSrcObject);
		if(propertySrcObject == null)
			throw new CVLModelException("can not find property : '" + propertyNameSrcObject + "'");
		
		int upperBound = propertySrcObject.getUpperBound();
		int lowerBound = propertySrcObject.getLowerBound();
		EClassifier srcObjectType = propertySrcObject.getEType();
		
		logger.debug("--------------------------------------------------------------");
		logger.debug("processing fromReplacement " + fromReplacement);
		logger.debug("calculating applicable boundaries for the element '" + srcObject + "' with the property '" + propertyNameSrcObject + "' of the type '" + srcObjectType + "' with the following cardinality lowerBound=" + lowerBound + " upperBound=" + upperBound);
		
		ArrayList<VariationPoint> fromPlacements = new ArrayList<VariationPoint>();
		for(VariationPoint boundary : options){
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
				throw new CVLModelException("can not find NULL boundary of the type ToReplacement");
			}
			fromPlacements.add(0, nullFromPlacement);
		}else{
			logger.debug("null boundary is skipped");
		}
		logger.debug("--------------------------------------------------------------");
		return fromPlacements;
	}

}
