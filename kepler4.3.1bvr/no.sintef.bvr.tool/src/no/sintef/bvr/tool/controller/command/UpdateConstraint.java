package no.sintef.bvr.tool.controller.command;


abstract public class UpdateConstraint<EDITOR_PANEL, MODEL_PANEL> extends UpdateAbstractNamedElement<EDITOR_PANEL, MODEL_PANEL> {
	
	abstract public void setConstraint(String text);
}
