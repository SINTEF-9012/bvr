package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.controller.BVRNotifiableController;


public class ClearSelectionRelalizationEvent implements ActionListener {

	
	private BVRNotifiableController controller;
	
	public ClearSelectionRelalizationEvent(BVRNotifiableController _controller){
		controller = _controller;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.getRealizationControllerInterface().clearSelection();
	}

}
