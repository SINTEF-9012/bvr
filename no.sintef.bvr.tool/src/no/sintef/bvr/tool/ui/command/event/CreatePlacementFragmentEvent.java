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


public class CreatePlacementFragmentEvent implements ActionListener {

	
	private BVRNotifiableController controller;
	private boolean withContainment;

	public CreatePlacementFragmentEvent(BVRNotifiableController _controller, boolean _withContainment) {
		controller = _controller;
		withContainment = _withContainment;
	}
	

	@Override
	public void actionPerformed(ActionEvent ev) {
		SimpleExeCommandInterface command = controller.getRealizationControllerInterface().createPlacementFragmentCommand(withContainment);
		command.execute();
	}
}
