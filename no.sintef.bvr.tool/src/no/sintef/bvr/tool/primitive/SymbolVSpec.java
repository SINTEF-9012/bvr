/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.primitive;


import org.eclipse.emf.common.util.EList;

import bvr.FragmentSubstitution;
import bvr.VSpec;
import bvr.VSpecResolution;

public interface SymbolVSpec {

	public void setVSpec(VSpec vSpec);
	
	public void setVSpecResolution(VSpecResolution vSpecResolution);
	
	public VSpec getVSpec();
	
	public VSpecResolution getVSpecResolution();
	
	public void addFragmentSubstitution(FragmentSubstitution fragmentSubstiotution);
	
	public EList<FragmentSubstitution> getFragmentSubstitutions();
	
	public FragmentSubstitution getFragmentSubstitutionCopy(FragmentSubstitution original);
	
	public void setFragmentSubstitutionCopy(FragmentSubstitution original, FragmentSubstitution copy);
	
	public EList<FragmentSubstitution> getFragmentSubstitutionsToExecute();
	
	public void addFragmentSubstitutionsToExecute(FragmentSubstitution fragment);
	
	public void setParent(SymbolVSpec parent);
	
	public SymbolVSpec getParent();
	
	public void addChild(SymbolVSpec child);
	
	public EList<SymbolVSpec> getChildren();
	
	public void setScope(SymbolVSpecResolutionTable table);
	
	public SymbolVSpecResolutionTable getScope();
	
	public void setMulti(boolean multi);
	
	public boolean getMulti();
}
