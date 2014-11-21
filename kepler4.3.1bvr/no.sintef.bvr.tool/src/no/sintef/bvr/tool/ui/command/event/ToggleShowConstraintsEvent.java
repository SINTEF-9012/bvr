package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;


public class ToggleShowConstraintsEvent implements ActionListener {

	private BVRNotifiableController controller;

	public ToggleShowConstraintsEvent(BVRNotifiableController _controller) {
		controller = _controller;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		controller.getResolutionControllerInterface().toggleShowConstraints();
	}
}
