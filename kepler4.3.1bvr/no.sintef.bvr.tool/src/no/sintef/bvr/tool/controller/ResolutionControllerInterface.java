package no.sintef.bvr.tool.controller;


import javax.swing.JComponent;

import org.eclipse.emf.ecore.EObject;

import java.util.List;

import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.model.BVRToolModel;

public interface ResolutionControllerInterface <GUI_NODE, MODEL_OBJECT>{

	public void addChoiceOrVClassifierResolution(GUI_NODE parent, MODEL_OBJECT resolvedVSpec);
	
	public SimpleExeCommandInterface createResolutionModelCommand();

	public SimpleExeCommandInterface createRemoveRootResolutionCommand();

	public SimpleExeCommandInterface createGenerateAllProductsCommand();


	public SimpleExeCommandInterface RemoveVsSpecResoluton(GUI_NODE toDelete);


	public boolean performSATValidation();

	public List<String> getSATValidationMessage();

	public Integer calculateCoverage(int t);

	public SimpleExeCommandInterface createGenerateCoveringArrayCommand(int t);

	void toggleChoice(GUI_NODE _toToggle);

	public void resolveSubtree(GUI_NODE parent);

}
