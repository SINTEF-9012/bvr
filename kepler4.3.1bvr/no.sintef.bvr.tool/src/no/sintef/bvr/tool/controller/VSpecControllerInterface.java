package no.sintef.bvr.tool.controller;

import no.sintef.bvr.tool.ui.command.Command;

public interface VSpecControllerInterface<GUI_NODE, MODEL_OBJECT> {
	
	public void addChoice(GUI_NODE parent);
	
	public void minimizeNode(GUI_NODE node);
	
	public void maximizeNode(GUI_NODE node);
	
	public MODEL_OBJECT getModelObjectByUINode(GUI_NODE node);
	
	public Command createUpdateChoiceCommand(GUI_NODE node);
	
	public void updateVariable(MODEL_OBJECT variable, String name, String typeName);
	
	public void setNodeComment(GUI_NODE node, String comment);
	
	public void setNodeName(GUI_NODE node, String name);
	
	public String getNodesCommentText(GUI_NODE node);
}
