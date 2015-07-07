/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.command;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import no.sintef.bvr.tool.interfaces.controller.command.Command;


public class CommandMouseListener extends MouseAdapter {

    private Command leftClickCommand, rightClickCommand;

    public void setLeftClickCommand(Command command) {
        this.leftClickCommand = command;
    }

    public void setRightClickCommand(Command command) {
        this.rightClickCommand = command;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch(e.getButton()) {
            case MouseEvent.BUTTON1 : {
                if(leftClickCommand != null) {
                    leftClickCommand.execute();
                }
            }break;
            case MouseEvent.BUTTON3 : {
                if(rightClickCommand != null) {
                    rightClickCommand.execute();
                }
            }break;
        }
        
    }
}
