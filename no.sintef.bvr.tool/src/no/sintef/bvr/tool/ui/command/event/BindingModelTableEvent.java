/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.command.event;


import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;


public class BindingModelTableEvent implements TableModelListener {

	private BVRNotifiableController controller;

	public BindingModelTableEvent(BVRNotifiableController _controller) {
		controller = _controller;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		if(TableModelEvent.UPDATE == e.getType()){
			if(e.getLastRow() == e.getFirstRow()){
				int rowIndex = e.getLastRow();
				int columnIndex = e.getColumn();
				
				SimpleExeCommandInterface command = controller.getRealizationControllerInterface().createUpdateBindingCommand(rowIndex, columnIndex);
				command.execute();
			}
		}
	}
}
