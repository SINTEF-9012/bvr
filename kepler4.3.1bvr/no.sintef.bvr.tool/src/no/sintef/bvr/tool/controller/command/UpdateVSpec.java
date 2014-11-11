package no.sintef.bvr.tool.controller.command;

import bvr.Variable;

abstract public class UpdateVSpec extends UpdateAbstractNamedElement {
	
	abstract public void setVariable(Variable v, String name, String type);
	
	abstract public void setComment(String text);

}
