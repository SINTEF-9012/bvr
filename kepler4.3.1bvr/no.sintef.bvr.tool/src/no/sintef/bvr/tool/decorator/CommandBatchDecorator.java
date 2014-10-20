package no.sintef.bvr.tool.decorator;

import no.sintef.bvr.tool.ui.command.Command;



interface CommandBatchDecorator extends Command {

	
	public void preExecute();
	
	public void postExecute();

}
