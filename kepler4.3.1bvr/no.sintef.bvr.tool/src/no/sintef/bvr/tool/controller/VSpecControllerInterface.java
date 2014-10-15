package no.sintef.bvr.tool.controller;

public interface VSpecControllerInterface<GIU_NODE, MODEL_OBJECT> {
	
	public void addChoice(GIU_NODE parent);
	
	public void minimizeNode(GIU_NODE node);
	
	public void maximizeNode(GIU_NODE node);
	
	public MODEL_OBJECT getModelObjectByUINode(GIU_NODE node);
}
