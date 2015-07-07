/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;


public class RenameResolution implements ActionListener {

	private BVRNotifiableController controller;

	public RenameResolution(BVRNotifiableController _controller){
		controller = _controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = JOptionPane.showInputDialog(Context.eINSTANCE.getActiveJApplet(), "Name");
		
		if (name != null && !name.equals("")) {
			SimpleExeCommandInterface command = controller.getResolutionControllerInterface().createRenameResolutionCommand(name);
			command.execute();
		}
	}

}
