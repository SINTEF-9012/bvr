package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;


public class CreateBindingsEvent implements ActionListener {

	private BVRNotifiableController controller;

	public CreateBindingsEvent(BVRNotifiableController _controller){
		controller = _controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SimpleExeCommandInterface command = controller.getRealizationControllerInterface().createGenerateBindingsCommand();
		command.execute();
	}
}
