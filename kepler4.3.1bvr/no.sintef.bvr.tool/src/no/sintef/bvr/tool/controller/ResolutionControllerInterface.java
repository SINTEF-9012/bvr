package no.sintef.bvr.tool.controller;

import java.util.List;

import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;

public interface ResolutionControllerInterface <GUI_NODE, MODEL_OBJECT>{

	public void addChoiceResolution(GUI_NODE parent, MODEL_OBJECT resolvedVSpec);
	
	public SimpleExeCommandInterface createResolutionModelCommand();

	public SimpleExeCommandInterface createRemoveRootResolutionCommand();

	public SimpleExeCommandInterface createGenerateAllProductsCommand();

	public boolean performSATValidation();

	public List<String> getSATValidationMessage();

	public Integer calculateCoverage(int t);

	public SimpleExeCommandInterface createGenerateCoveringArrayCommand(int t);
}
