/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.edit;



import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import bvr.NamedElement;


public class VInstancePropertyEditor extends ElementPropertyEditor {

	private static final long serialVersionUID = 47770113151580106L;

	
    public VInstancePropertyEditor(BVRUIKernel _kernel, Command _command, NamedElement _obj, JComponent _node,
			BVRNotifiableController _view) {
		super(_kernel, _command, _obj, _node, _view);
	}
}
