package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.command.BatchCommandExecutor;
import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;


public class DeletePlacementReplacementFragmentEvent implements ActionListener {

	private BVRNotifiableController controller;

	public DeletePlacementReplacementFragmentEvent(BVRNotifiableController _controller){
		controller = _controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new BatchCommandExecutor(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				controller.getRealizationControllerInterface().deleteSubstitutionFragments();
			}
		}).execute();
	}

}
