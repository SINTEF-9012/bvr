/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.interfaces.controller;


import no.sintef.bvr.tool.interfaces.controller.command.Command;


public interface VTypeControllerInterface<GUI_NODE, MODEL_OBJECT, SERIALIZABLE>
		extends
		EditorsCommonControllerInterface<SERIALIZABLE, GUI_NODE, MODEL_OBJECT> {

	public Command<?,?> createUpdateVTypeCommand(GUI_NODE elem);

	public void removeVType(GUI_NODE parent);

}
