package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;


public class DeleteResolution implements ActionListener {

	private BVRNotifiableController controller;

	public DeleteResolution(BVRNotifiableController _controller){
		controller = _controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SimpleExeCommandInterface command = controller.getResolutionControllerInterface().removeRootResolution();
		command.execute();
	}

}
