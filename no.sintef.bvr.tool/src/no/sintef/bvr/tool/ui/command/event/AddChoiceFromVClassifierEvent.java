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

import javax.swing.JComponent;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;


public class AddChoiceFromVClassifierEvent implements ActionListener {
	private JComponent cr;
	private EObject target;
	private BVRNotifiableController controller;
	
	public AddChoiceFromVClassifierEvent(JComponent parent, EObject toResolve, BVRNotifiableController controller) {
		cr = parent;
		target = toResolve;
		this.controller = controller;
	}
	
	static int count = 0;

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		controller.getResolutionControllerInterface().addChoiceOrVClassifierResolution(cr, target);
	}
}
