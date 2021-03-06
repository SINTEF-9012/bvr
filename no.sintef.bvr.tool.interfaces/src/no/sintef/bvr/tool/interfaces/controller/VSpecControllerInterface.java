/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.interfaces.controller;



import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.command.Command;


public interface VSpecControllerInterface<GUI_NODE, MODEL_OBJECT, SERIALIZABLE> extends EditorsCommonControllerInterface<SERIALIZABLE, GUI_NODE, MODEL_OBJECT> {
	
	public void addChoice(GUI_NODE parent);
	
	public void minimizeNode(GUI_NODE node);
	
	public void maximizeNode(GUI_NODE node);
	
	public Command createUpdateChoiceCommand(GUI_NODE node);
	
	public void updateVariable(MODEL_OBJECT variable, String name, String typeName);
	
	public void setNodeComment(GUI_NODE node, String comment);
	
	public String getNodesCommentText(GUI_NODE node);
	
	public void addVariable(GUI_NODE node);

	public Command createUpdateVClassifierCommand(GUI_NODE node);
	
	public void setVClassifierGroupMultiplicityUpperBound(GUI_NODE node, int upperBound);
	
	public void setVClassifierGroupMultiplicityLowerBound(GUI_NODE node, int lowerBound);
	
	public void addVClassifier(GUI_NODE node);
	
	public void addBCLConstraint(GUI_NODE node);
	
	public Command createUpdateBCLConstraintCommand(GUI_NODE node);
	
	public void updateBCLConstraint(GUI_NODE node, String strConstr);
	
	public void toggleChoiceOptionalMandotary(GUI_NODE node);
	
	public void cutNamedElement(GUI_NODE node);
	
	public void pastNamedElementAsChild(GUI_NODE node);
	
	public void pastNamedElementAsSibling(GUI_NODE node);
	
	public void setGroupMultiplicityAlternative(GUI_NODE node);
	
	public void setGroupMultiplicityNone(GUI_NODE node);
	
	public void setGroupMultiplicityOr(GUI_NODE node);
	
	public void setGroupMultiplicityCustom(GUI_NODE node, int lowerBound, int upperBound);
	
	public Command createUpdateBVRModelCommand(GUI_NODE node);
	
	public String getBCLConstraintString(GUI_NODE node);
	
	public void removeNamedElement(GUI_NODE node);

	public void editVType(MODEL_OBJECT vNode, MODEL_OBJECT vType);

	public void addVType(GUI_NODE node);

	public Command createUpdateChoiceOccurenceCommand(GUI_NODE elem);

	public void setChoiceOccurenceType(GUI_NODE node, String strType);

	public Command createUpdateVClassOccurenceCommand(GUI_NODE elem);

	public void setVClassOccurenceType(GUI_NODE parent, String typeName);

	void setVClassOccurenceGroupMultiplicityUpperBound(GUI_NODE node,
			int upperBound);

	void setVClassOccurenceGroupMultiplicityLowerBound(GUI_NODE node,
			int lowerBound);

	public void addChoiceOccurence(GUI_NODE parent);

	void addVClassOccurence(GUI_NODE parent);

}
