package no.sintef.bvr.tool.decorator;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.command.CommandBatchInterface;
import no.sintef.bvr.tool.controller.command.UpdateVInstance;


public class UpdateVInstanceBatchCmdDecorator extends
	UpdateVInstanceDecorator implements CommandBatchInterface {

	public UpdateVInstanceBatchCmdDecorator(
			UpdateVInstance _wrapped) {
		super(_wrapped);
	}

	@Override
	public JComponent execute() {
		preExecute();
		JComponent component = super.execute();
		postExecute();
		return component;
	}

	@Override
	public void preExecute() {
		controller.getCommonControllerInterface().enableBatchCommandProcessing();
	}

	@Override
	public void postExecute() {
		controller.getCommonControllerInterface().executeCommandBatch();
		controller.getCommonControllerInterface().disableBatchCommandProcessing();
	}
}
