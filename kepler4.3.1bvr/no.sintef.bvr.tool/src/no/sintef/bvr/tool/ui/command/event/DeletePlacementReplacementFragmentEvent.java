package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.common.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.controller.BVRNotifiableController;


public class DeletePlacementReplacementFragmentEvent implements ActionListener {

	private BVRNotifiableController controller;

	public DeletePlacementReplacementFragmentEvent(BVRNotifiableController _controller){
		controller = _controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SimpleExeCommandInterface command = controller.getRealizationControllerInterface().createDeleteSubstitutionFragmentsCommand();
		command.execute();
	}

}
