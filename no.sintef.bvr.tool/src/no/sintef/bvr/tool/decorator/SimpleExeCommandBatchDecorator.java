/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.decorator;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.command.CommandBatchInterface;
import no.sintef.bvr.tool.exception.BatchRethrownException;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;

public class SimpleExeCommandBatchDecorator implements SimpleExeCommandInterface,
		CommandBatchInterface {

	private SimpleExeCommandInterface wrappedCommand;
	
	public SimpleExeCommandBatchDecorator(SimpleExeCommandInterface command){
		wrappedCommand = command;
	}
	
	@Override
	public void preExecute() {
		Context.eINSTANCE.getEditorCommands().enableBatchProcessing();
	}

	@Override
	public void postExecute() {
		Context.eINSTANCE.getEditorCommands().executeBatch();
	}

	@Override
	public void execute() {
		preExecute();
		try {
			wrappedCommand.execute();
			postExecute();
		} catch (Exception ex) {
			throw new BatchRethrownException(ex);
		} finally {
			reset();
		}
	}

	public void reset() {
		Context.eINSTANCE.getEditorCommands().disableBatchProcessing();
	}

}
