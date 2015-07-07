/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.ui.editor.common;

import java.awt.AWTEvent;

import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;

public class ExecuteCommandEvent extends AWTEvent {


	private static final long serialVersionUID = -8635468107891567339L;
	
	public static final int EVENT_ID = AWTEvent.RESERVED_ID_MAX + 2;
	
	SimpleExeCommandInterface command;
	
	public ExecuteCommandEvent(Object target, SimpleExeCommandInterface _command) {
		super(target, EVENT_ID);
		command = _command;
	}
	
	public void execute() {
		command.execute();
	}
}
