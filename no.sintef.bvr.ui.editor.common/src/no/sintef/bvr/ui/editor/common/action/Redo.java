/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.ui.editor.common.action;

import java.awt.Toolkit;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.command.RedoCommand;
import no.sintef.bvr.ui.editor.common.ExecuteCommandEvent;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;


public class Redo extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new ExecuteCommandEvent(Context.eINSTANCE.getActiveJApplet(), new RedoCommand()));
		return null;
	}

}
