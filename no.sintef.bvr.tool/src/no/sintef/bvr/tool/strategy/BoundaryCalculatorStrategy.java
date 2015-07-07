/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.strategy;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.exception.AbstractError;
import bvr.NamedElement;
import bvr.VariationPoint;

public abstract class BoundaryCalculatorStrategy {

	public abstract ArrayList<NamedElement> getCompliedBoundaries(NamedElement forBoundary, ArrayList<NamedElement> options) throws AbstractError;
	
	protected boolean isInstance(EClassifier eClassifier, EList<EObject> eObjectList){
		for(EObject eObject : eObjectList){
			if(!eClassifier.isInstance(eObject)){
				return false;
			}
		}
		return true;
	}
	
	protected boolean isInstance(EClassifier eClassifier, EObject eObject){
		return eClassifier.isInstance(eObject);
	}
}
