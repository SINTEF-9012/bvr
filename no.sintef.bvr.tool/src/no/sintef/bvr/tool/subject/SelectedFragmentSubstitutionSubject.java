/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.subject;

import bvr.FragmentSubstitution;
import no.sintef.bvr.tool.primitive.impl.ObserverDataBulk;

public class SelectedFragmentSubstitutionSubject extends AbstractViewSubject {

	private FragmentSubstitution selectedFragmentSubstitution;
	private String[] fields = {"selectedFragmentSubstitution"};
	
	public SelectedFragmentSubstitutionSubject(FragmentSubstitution fs){
		this.selectedFragmentSubstitution = fs;
	}
	
	@Override
	public void setState(ObserverDataBulk data) {
		Object value = data.getDataField("selectedFragmentSubstitution");
		selectedFragmentSubstitution = (value != null) ? (FragmentSubstitution) value : null;
	}
	
	public FragmentSubstitution getSelectedFragmentSubstitution(){
		return selectedFragmentSubstitution;
	}

	public void resetSelectedFragmentSubstitution() {
		selectedFragmentSubstitution = null;
	}
	
	@Override
	protected String[] getFileds(){
		return fields;
	}
}
