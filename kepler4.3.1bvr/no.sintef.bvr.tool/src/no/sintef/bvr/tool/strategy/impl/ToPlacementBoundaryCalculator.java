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
import bvr.NamedElement;
import bvr.ObjectHandle;
import bvr.ToPlacement;
import bvr.ToReplacement;
import bvr.VariationPoint;

public class ToPlacementBoundaryCalculator extends BoundaryCalculatorStrategy {
	
	private ToReplacement nullToReplacement = null;
	private Logger logger = Context.eINSTANCE.logger;

	@Override
	public ArrayList<NamedElement> getCompliedBoundaries(
			NamedElement forBoundary, ArrayList<NamedElement> options) throws AbstractError {
		ToPlacement toPlacement = (ToPlacement) forBoundary;
		String propertyNameSrcObject = toPlacement.getPropertyName();
		EObject srcObject = toPlacement.getOutsideBoundaryElement().getMOFRef();
		if(srcObject.eIsProxy())
			throw new BVRModelException("can not resolve a proxy object, it must be a model error : " + srcObject);
		
		EStructuralFeature propertySrcObject = srcObject.eClass().getEStructuralFeature(propertyNameSrcObject);
		if(propertySrcObject == null)
			throw new BVRModelException("can not find property : '" + propertyNameSrcObject + "'");
			
		int upperBound = propertySrcObject.getUpperBound();
		int lowerBound = propertySrcObject.getLowerBound();
		EClassifier srcObjectType = propertySrcObject.getEType();
		
		logger.debug("--------------------------------------------------------------");
		logger.debug("processing toPlacement " + toPlacement);
		logger.debug("calculating applicable boundaries for the element '" + srcObject + "' with the property '" + propertyNameSrcObject + "' of the type '" + srcObjectType + "' with the following cardinality lowerBound=" + lowerBound + " upperBound=" + upperBound);
		
		ArrayList<NamedElement> toReplacements = new ArrayList<NamedElement>();
		for(NamedElement boundary : options){
			if(LoaderUtility.isNullBoundary(boundary)){
				nullToReplacement = (ToReplacement) boundary;
			}else{
				ToReplacement toReplacement = (ToReplacement) boundary;
				
				logger.debug("processing boundary toReplacement " + toReplacement);
				
				EList<ObjectHandle> insideBoundaryElementsOH = toReplacement.getInsideBoundaryElement();
				if(insideBoundaryElementsOH.size() <= upperBound || upperBound == -1){
					EList<EObject> insideBoundaryElements = LoaderUtility.resolveProxies(insideBoundaryElementsOH);
					if(isInstance(srcObjectType, insideBoundaryElements)){
						toReplacements.add(boundary);
						logger.debug("the boundary is compatible");
					}else{
						logger.debug("skip boundary, some elements are not type compatible " + insideBoundaryElements);
					}
				}else{
					logger.debug("skip boundary, too many elements which do not match the cardinality of the source object, size=" + insideBoundaryElementsOH.size());
				}
			}
		}
		
		if(lowerBound == 0){
			if(nullToReplacement == null){
				throw new BVRModelException("can not find NULL boundary of the type ToReplacement");
			}
			toReplacements.add(0, nullToReplacement);
		}else{
			logger.debug("null boundary is skipped");
		}
		logger.debug("--------------------------------------------------------------");
		return toReplacements;
	}
}
