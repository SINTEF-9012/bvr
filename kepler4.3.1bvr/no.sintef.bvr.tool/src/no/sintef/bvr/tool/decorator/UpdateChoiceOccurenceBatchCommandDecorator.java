package no.sintef.bvr.tool.decorator;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.command.CommandBatchInterface;
import no.sintef.bvr.tool.controller.command.UpdateChoiceOccurence;

public class UpdateChoiceOccurenceBatchCommandDecorator<EDITOR_PANEL, MODEL_PANEL> extends
		UpdateChoiceOccurenceAbstractDecorator<EDITOR_PANEL, MODEL_PANEL> implements CommandBatchInterface {

	public UpdateChoiceOccurenceBatchCommandDecorator(UpdateChoiceOccurence<EDITOR_PANEL, MODEL_PANEL> _command) {
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
