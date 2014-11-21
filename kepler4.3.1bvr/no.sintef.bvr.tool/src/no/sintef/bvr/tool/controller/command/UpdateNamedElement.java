package no.sintef.bvr.tool.controller.command;

import no.sintef.bvr.tool.interfaces.controller.command.Command;


public interface UpdateNamedElement<EDITOR_PANEL, MODEL_PANEL> extends Command<EDITOR_PANEL, MODEL_PANEL> {

	public void setName(String name);
}
