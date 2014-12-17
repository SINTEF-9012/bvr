package no.sintef.bvr.tool.ui.command.event;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;

public class UndoEvent implements SimpleExeCommandInterface{

	@Override
	public void execute() {
		Context.eINSTANCE.getEditorCommands().undo();
	}

}
