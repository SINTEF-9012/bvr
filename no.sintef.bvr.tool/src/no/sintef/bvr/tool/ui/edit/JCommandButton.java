/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.edit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;


public class JCommandButton extends JButton {

	private static final long serialVersionUID = 6470959770787697161L;
	protected Command command;

	protected BVRNotifiableController controller;
	protected BVRUIKernel kernel;
	
    public JCommandButton(final String title, final Command command, final BVRUIKernel kernel, final BVRNotifiableController controller){
    	this.command = command;
    	this.controller = controller;
    	this.kernel = kernel;
        this.setText(title);
        this.setOpaque(false);
        this.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
        		command.execute();
        		if(controller != null)
        			kernel.getEditorPanel().unshowPropertyEditor();
            }
        });

    }
    
    public JCommandButton(final String title, final Command command){
    	this(title, command, null, null);
    }
}
