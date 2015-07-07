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
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.context.StaticUICommands;

public class OpenModelEvent implements ActionListener {
	
	private JTabbedPane c;

	public OpenModelEvent(JTabbedPane c){
		this.c = c;
	}

	public void actionPerformed(ActionEvent arg0) {
		try{
			JFileChooser fc = StaticUICommands.getBVRFileChooser();
			
			int isCanceled = fc.showOpenDialog(c);
			if(isCanceled == JFileChooser.CANCEL_OPTION)
				return;
			
			File sf = fc.getSelectedFile();
			if(sf == null) return;
			
			BVRToolModel m = Context.eINSTANCE.loadModelFromFile(sf);
			Context.eINSTANCE.addBvrModel(m);
			//Context.eINSTANCE.addBvrView(new VSpecView(m, c));
		}catch(Exception e){
			Context.eINSTANCE.logger.error("some error on Open", e);
			StaticUICommands.showMessageErrorDialog(null, e, "Failed to load file due to:");
		}
	}

}
