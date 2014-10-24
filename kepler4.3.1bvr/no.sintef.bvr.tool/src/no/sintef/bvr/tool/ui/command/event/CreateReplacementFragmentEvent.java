package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.command.SimpleExeCommand;


public class CreateReplacementFragmentEvent implements ActionListener {
	
	private BVRNotifiableController controller;
	private boolean withContainment;


	public CreateReplacementFragmentEvent(BVRNotifiableController _controller, boolean _withContainment) {
		controller = _controller;
		withContainment = _withContainment;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		SimpleExeCommand command = controller.getRealizationControllerInterface().createReplacementFragmentCommand(withContainment);
		command.execute();
	}
}