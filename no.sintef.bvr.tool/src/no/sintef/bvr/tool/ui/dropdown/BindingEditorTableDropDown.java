/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.dropdown;

import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.event.CreateToBindingEvent;
import no.sintef.bvr.tool.ui.command.event.DeleteBindingAllEvent;
import no.sintef.bvr.tool.ui.command.event.DeleteBindingEvent;

public class BindingEditorTableDropDown extends BindingEditorDropDown {

	private static final long serialVersionUID = 8629958457282670624L;
	
	public BindingEditorTableDropDown(BVRNotifiableController _view){
		super(_view);
		
		add(new JSeparator());
		
		JMenuItem deleteBinding = new JMenuItem(Constants.REALIZATION_DELETE_BINDING);
		deleteBinding.addActionListener(new DeleteBindingEvent(_view));
		add(deleteBinding);
	}

}
