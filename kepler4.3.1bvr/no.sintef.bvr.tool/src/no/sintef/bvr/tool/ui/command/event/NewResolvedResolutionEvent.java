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