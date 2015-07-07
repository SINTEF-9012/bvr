/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.command.event;


import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;


public class FragSubTableRowSelectionEvent implements ListSelectionListener {
	
	private BVRNotifiableController controller;

	public FragSubTableRowSelectionEvent(BVRNotifiableController _controller){
		controller = _controller;
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		int selectedIndex = ((ListSelectionModel) event.getSource()).getLeadSelectionIndex();
		if(!event.getValueIsAdjusting() && selectedIndex >= 0)
			controller.getRealizationControllerInterface().fragmentSubstitutionRowSelected(selectedIndex);
	}
}
