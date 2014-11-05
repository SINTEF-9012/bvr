package no.sintef.bvr.tool.controller;

import java.util.List;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;

public interface ResolutionControllerInterface<GUI_NODE, MODEL_OBJECT, SERIALIZABLE> extends EditorsCommonControllerInterface<SERIALIZABLE> {

	public void addChoiceOrVClassifierResolution(GUI_NODE parent,
			MODEL_OBJECT resolvedVSpec);

	public SimpleExeCommandInterface createResolutionModelCommand();

	public SimpleExeCommandInterface createRemoveRootResolutionCommand();

	public SimpleExeCommandInterface createGenerateAllProductsCommand();

	public SimpleExeCommandInterface RemoveVsSpecResoluton(GUI_NODE toDelete);

	public boolean performSATValidation();

	public List<String> getSATValidationMessage();

	public Integer calculateCoverage(int t);

	public SimpleExeCommandInterface createGenerateCoveringArrayCommand(int t);

	void toggleChoice(GUI_NODE _toToggle);

	public SimpleExeCommandInterface createResolveSubtreeCommand(GUI_NODE parent);

	public void importResolution(SERIALIZABLE file);

	public String calculateCosts();
	
	public void toggleShowConstraints();
	
	public boolean isResolutionModelSet();

	public void minimizeNode(GUI_NODE node);
	
	public void maximizeNode(GUI_NODE node);
}
