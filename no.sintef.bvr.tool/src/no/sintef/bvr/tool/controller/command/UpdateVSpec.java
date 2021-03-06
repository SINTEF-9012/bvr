/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.controller.command;

import bvr.Variable;

abstract public class UpdateVSpec<EDITOR_PANEL, MODEL_PANEL> extends UpdateAbstractNamedElement<EDITOR_PANEL, MODEL_PANEL> {
	
	abstract public void setVariable(Variable v, String name, String type);
	
	abstract public void setComment(String text);

}
