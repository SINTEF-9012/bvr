package no.sintef.bvr.tool.decorator;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.command.CommandBatchInterface;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;

public class SimpleExeCommandBatchDecorator implements SimpleExeCommandInterface,
		CommandBatchInterface {

	private SimpleExeCommandInterface wrappedCommand;
	
	public SimpleExeCommandBatchDecorator(SimpleExeCommandInterface command){
		wrappedCommand = command;
	}
	
	@Override
	public void preExecute() {
		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
	}

	@Override
	public void postExecute() {
		Context.eINSTANCE.getEditorCommands().executeBatch();
		Context.eINSTANCE.getEditorCommands().disableBatchProcessing();
	}

	@Override
	public void execute() {
		preExecute();
		wrappedCommand.execute();
		postExecute();
	}

}
