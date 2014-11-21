package no.sintef.bvr.tool.controller.command;

import bvr.Variable;

abstract public class UpdateVSpec<EDITOR_PANEL, MODEL_PANEL> extends UpdateAbstractNamedElement<EDITOR_PANEL, MODEL_PANEL> {
	
	abstract public void setVariable(Variable v, String name, String type);
	
	abstract public void setComment(String text);

}
