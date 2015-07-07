/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.controller.command;


import javax.swing.JComponent;


public class UpdateVariableValueAssignment<EDITOR_PANEL, MODEL_PANEL> extends UpdateAbstractNamedElement<EDITOR_PANEL, MODEL_PANEL> {


	@SuppressWarnings("unchecked")
	@Override
	public JComponent execute() {
		controller.getResolutionControllerInterface().setValueResolutionValue(parent, value);
		super.execute();
		return parent;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
