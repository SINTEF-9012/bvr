/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.decorator;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.command.CommandBatchInterface;
import no.sintef.bvr.tool.controller.command.UpdateVariableValueAssignment;

public class UpdateVarValAssigBatchCmdDecorator<EDITOR_PANEL, MODEL_PANEL> extends
		UpdateVariableValueAssignmentDecorator<EDITOR_PANEL, MODEL_PANEL> implements CommandBatchInterface {

	public UpdateVarValAssigBatchCmdDecorator(
			UpdateVariableValueAssignment<EDITOR_PANEL, MODEL_PANEL> _wrapped) {
		super(_wrapped);
	}

	@Override
	public JComponent execute() {
		preExecute();
		JComponent component = super.execute();
		postExecute();
		return component;
	}

	@Override
	public void preExecute() {
		controller.getCommonControllerInterface().enableBatchCommandProcessing();
	}

	@Override
	public void postExecute() {
		controller.getCommonControllerInterface().executeCommandBatch();
		controller.getCommonControllerInterface().disableBatchCommandProcessing();
	}
}
