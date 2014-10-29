package no.sintef.bvr.tool.controller;

import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;

public interface ResolutionControllerInterface <GUI_NODE, MODEL_OBJECT>{

	public void addChoiceResolution(GUI_NODE parent, MODEL_OBJECT resolvedVSpec);
	
	public SimpleExeCommandInterface createResolutionModel();

	public SimpleExeCommandInterface removeRootResolution();
}
