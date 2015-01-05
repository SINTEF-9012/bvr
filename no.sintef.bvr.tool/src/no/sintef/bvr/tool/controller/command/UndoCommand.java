package no.sintef.bvr.tool.controller.command;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;

public class UndoCommand implements SimpleExeCommandInterface{

	@Override
	public void execute() {
		Context.eINSTANCE.getEditorCommands().undo();
	}

}
