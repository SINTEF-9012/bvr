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

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;


public class NewResolvedResolutionEvent implements ActionListener {
	private BVRNotifiableController controller;

	public NewResolvedResolutionEvent(BVRNotifiableController _controller) {
		controller = _controller;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		SimpleExeCommandInterface command = controller.getResolutionControllerInterface().createResolutionModelCommand();
		command.execute();
	}
}
