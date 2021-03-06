/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.strategy.impl;

import no.sintef.bvr.tool.strategy.PlacementBoundaryCalcStrategy;
import no.sintef.bvr.tool.strategy.ReplacementBoundaryCalcStrategy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.NamedElement;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;

public class CreateBoundaryContext {

	private PlacementBoundaryCalcStrategy defaultPlacementCalc;
	private ReplacementBoundaryCalcStrategy defaultReplacementCalc;

	public CreateBoundaryContext(){
		defaultPlacementCalc = new DefaultPlacementBoundaryCalcStrategy();
		defaultReplacementCalc = new DefaultReplacementBoundaryCalcStrategy();
	}
	
	public CreateBoundaryContext(PlacementBoundaryCalcStrategy placementCalcStrategy, ReplacementBoundaryCalcStrategy replacementCalcStrategy){
		defaultPlacementCalc = placementCalcStrategy;
		defaultReplacementCalc = replacementCalcStrategy;
	}
	
	public void creatBoundaries(NamedElement fragment, EList<EObject> selectedElements){
		PlacementFragment placement = null;
		ReplacementFragmentType replacement = null;
		if(fragment instanceof PlacementFragment && defaultPlacementCalc != null){
			placement = (PlacementFragment) fragment;
			defaultPlacementCalc.calculateBoundaries(placement, selectedElements);
		}else if (fragment instanceof ReplacementFragmentType && defaultReplacementCalc != null){
			replacement = (ReplacementFragmentType) fragment;
			defaultReplacementCalc.calculateBoundaries(replacement, selectedElements);
		}else{
			throw new UnsupportedOperationException("fragment should be either PlacementFragment or ReplacementFragmentType; is corresponding strategy set?");
		}
	}
}
