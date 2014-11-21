package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;


public class CreateFragmentSubstitutionEvent implements ActionListener {

	private BVRNotifiableController controller;

	public CreateFragmentSubstitutionEvent(BVRNotifiableController _controller){
		controller = _controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.getRealizationControllerInterface().createFragmentSubstitution();
	}
}
