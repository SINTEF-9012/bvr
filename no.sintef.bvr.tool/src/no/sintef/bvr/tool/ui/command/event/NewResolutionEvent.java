/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;

import bvr.BVRModel;
import bvr.BvrFactory;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.model.BVRToolModel;

public class NewResolutionEvent implements ActionListener {
	private BVRModel cu;
	private BVRNotifiableController v;

	public NewResolutionEvent(BVRModel cu, BVRNotifiableController bvrView) {
		this.cu = cu;
		this.v = bvrView;
	}

	public void actionPerformed(ActionEvent arg0) {
	
		//ChoiceResolutuion cr = BvrFactory.eINSTANCE.createChoiceResolutuion();
		//cu.getOwnedVSpecResolution().add(cr);
		//Context.eINSTANCE.getEditorCommands().createNewResolution(cr, cu);
		
		//v.notifyResolutionViewUpdate();
	}

}
