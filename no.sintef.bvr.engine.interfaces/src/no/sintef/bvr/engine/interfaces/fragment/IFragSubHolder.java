/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.interfaces.fragment;

import org.eclipse.emf.common.util.EList;

import bvr.FragmentSubstitution;
import bvr.FromBinding;
import bvr.ToBinding;


public interface IFragSubHolder {

	public IPlacementElementHolder getPlacement();
	
	public IReplacementElementHolder getReplacement();
	
	public FragmentSubstitution getFragment();
	
	public EList<ToBinding> getToBindings();
	
	public EList<FromBinding> getFromBinding();
}
