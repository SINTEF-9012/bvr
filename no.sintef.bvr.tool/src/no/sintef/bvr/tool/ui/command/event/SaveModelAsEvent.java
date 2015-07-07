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

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.context.StaticUICommands;


public class SaveModelAsEvent implements ActionListener {
	private JTabbedPane filePane;
	private boolean trydirectsave;

	public SaveModelAsEvent(JTabbedPane filePane,  boolean b) {
		this.filePane = filePane;
		this.trydirectsave = b;
	}

	public void actionPerformed(ActionEvent event) {		
		try{
			int i = filePane.getSelectedIndex();
			BVRToolModel model = Context.eINSTANCE.getBvrModels().get(i);
			
			File file = StaticUICommands.saveModelToFile(filePane, model, trydirectsave);
			if(file != null){
				filePane.setTitleAt(i, file.getName());
				filePane.setToolTipTextAt(i, file.getAbsolutePath());
			}
		}catch(Exception e){
			Context.eINSTANCE.logger.error("some error on Save", e);
			StaticUICommands.showMessageErrorDialog(filePane, e, "Error saving file:");
		}
	}
}
