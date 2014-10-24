package no.sintef.bvr.tool.decorator;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.command.UpdateChoice;

public class UpdateChoiceBatchCommandDecorator extends
		UpdateChoiceAbstractDecorator implements CommandBatchDecorator {

	public UpdateChoiceBatchCommandDecorator(UpdateChoice _command) {
		super(_command);
	}
	
	@Override
	public JComponent execute() {
		preExecute();
		JComponent component = command.execute();
		postExecute();
		return component;
	}

	@Override
	public void preExecute() {
		controller.getVSpecControllerInterface().enableBatchCommandProcessing();
	}

	@Override
	public void postExecute() {
		controller.getVSpecControllerInterface().executeCommandBatch();
		controller.getVSpecControllerInterface().disableBatchCommandProcessing();
	}

}
