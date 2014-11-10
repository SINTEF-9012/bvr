package no.sintef.bvr.tool.controller;

import java.util.List;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.command.Command;
import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;


public interface ResolutionControllerInterface<GUI_NODE, MODEL_OBJECT, SERIALIZABLE> extends EditorsCommonControllerInterface<SERIALIZABLE, GUI_NODE, MODEL_OBJECT> {

	public void addChoiceOrVClassifierResolution(GUI_NODE parent,
			MODEL_OBJECT resolvedVSpec);

	public SimpleExeCommandInterface createResolutionModelCommand();

	public SimpleExeCommandInterface createRemoveRootResolutionCommand();

	public SimpleExeCommandInterface createGenerateAllProductsCommand();

	public SimpleExeCommandInterface createRemoveVSpecResolutionCommand(GUI_NODE toDelete);

	public boolean performSATValidation();

	public List<String> getSATValidationMessage();

	public Integer calculateCoverage(int t);

	public SimpleExeCommandInterface createGenerateCoveringArrayCommand(int t);

	public SimpleExeCommandInterface createToggleChoiceCommand(GUI_NODE _toToggle);

	public SimpleExeCommandInterface createResolveSubtreeCommand(GUI_NODE parent);

	public void importResolution(SERIALIZABLE file);

	public String calculateCosts();
	
	public void toggleShowConstraints();
	
	public boolean isResolutionModelSet();

	public void minimizeNode(GUI_NODE node);
	
	public void maximizeNode(GUI_NODE node);
	
	public SimpleExeCommandInterface createVariableResolutionCommand(GUI_NODE parent, MODEL_OBJECT variable);

	public Command createUpdateVariableResolutionCommand(GUI_NODE elem);

	public void setValueResolutionValue(GUI_NODE parent, String value);

	public void setValueResolutionName(GUI_NODE parent, String name);

	public String getValueReolutionStringValue(GUI_NODE node);
}
