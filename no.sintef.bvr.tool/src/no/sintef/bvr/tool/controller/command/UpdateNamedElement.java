/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.controller.command;

import no.sintef.bvr.tool.interfaces.controller.command.Command;


public interface UpdateNamedElement<EDITOR_PANEL, MODEL_PANEL> extends Command<EDITOR_PANEL, MODEL_PANEL> {

	public void setName(String name);
}
