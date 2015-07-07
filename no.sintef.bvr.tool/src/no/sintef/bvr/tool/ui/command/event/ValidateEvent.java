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
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;


public class ValidateEvent implements ActionListener{
	private JComponent component;
	private BVRNotifiableController controller;
	
	public ValidateEvent(JComponent _component, BVRNotifiableController _controller) {
		component = _component;
		controller = _controller;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		List<String> results = controller.getResolutionControllerInterface().validateResolutionNode(component);
		if(results.size() == 0) {
			JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), "Valid: true []");
			return;
		}

		String message = "";
		Iterator<String> iterator = results.iterator();
		while(iterator.hasNext()) {
			String result = iterator.next();
			message += result;
			if(iterator.hasNext())
				message += ", ";
		}
		
		JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), "Valid: false [" + message + "]");
	}
}
