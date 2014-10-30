package no.sintef.bvr.tool.controller;

import javax.swing.JComponent;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;

public interface ResolutionControllerInterface <GUI_NODE, MODEL_OBJECT>{

	public void addChoiceOrVClassifierResolution(GUI_NODE parent, MODEL_OBJECT resolvedVSpec);
	
	public SimpleExeCommandInterface createResolutionModelCommand();

	public SimpleExeCommandInterface createRemoveRootResolutionCommand();

	public SimpleExeCommandInterface createGenerateAllProductsCommand();

	public SimpleExeCommandInterface RemoveVsSpecResoluton(GUI_NODE toDelete);


}
