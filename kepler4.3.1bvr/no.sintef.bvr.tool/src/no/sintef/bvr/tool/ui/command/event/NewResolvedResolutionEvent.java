package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.common.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.controller.BVRNotifiableController;


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