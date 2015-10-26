/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.interfaces.controller;

import java.util.List;

import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;
import bvr.Constraint;

public interface ResolutionControllerInterface<GUI_NODE, MODEL_OBJECT, SERIALIZABLE> extends
		EditorsCommonControllerInterface<SERIALIZABLE, GUI_NODE, MODEL_OBJECT> {

	public void addChoiceOrVClassifierResolution(GUI_NODE parent, MODEL_OBJECT resolvedVSpec);

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

	public int getReslovedVClassifierCount(GUI_NODE panel, MODEL_OBJECT vclassifier);

	public SimpleExeCommandInterface createResolveNVSpecCommand(GUI_NODE panel, MODEL_OBJECT vspec, int instancesToResolve);

	public Command createUpdateInstanceChoiceResolutionCommand(GUI_NODE vInstance);

	public boolean findGroupError(MODEL_OBJECT compoundResolution);

	public void toggleShowGrouping();

	public List<Constraint> getInvalidConstraints();

	public String getBCLConstraintString(GUI_NODE constraint);

	public List<String> validateResolutionNode(GUI_NODE component);

	public void executeProduct(SERIALIZABLE destFile);

	public SimpleExeCommandInterface createRemoveAllResolutionsCommand();

	public void removeUncontainedResolutions(GUI_NODE p);

	public boolean performSATValidationSingleResolution();

	public SimpleExeCommandInterface createRenameResolutionCommand(String name);

	public List<String> getBaseModelFiles();
}
