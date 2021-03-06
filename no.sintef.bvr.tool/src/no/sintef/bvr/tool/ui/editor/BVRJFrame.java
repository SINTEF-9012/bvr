/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.context.StaticUICommands;

public class BVRJFrame extends JFrame {
	
	private BVRJFrame frame;
	private JTabbedPane tabbedPane;
	private static final String title = Messages.EDITOR_TITLE;
	
	public BVRJFrame() {
		super(title);
		frame = this;
		tabbedPane = new JTabbedPane();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1000, 800));
		frame.setBackground(Color.WHITE);
		frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				String[] buttunTitles = {Messages.BUTTONS_TITLE_SAVE_AND_EXIT, Messages.BUTTONS_TITLE_EXIT, Messages.BUTTONS_TITLE_CANCEL};
				int result = JOptionPane.showOptionDialog(null, Messages.DIALOG_MSG_EXIT, Messages.DIALOG_TITLE_EXIT,
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				        null, buttunTitles, buttunTitles[0]);
				if(result == JOptionPane.YES_OPTION || result == JOptionPane.NO_OPTION){
					try{
						if(result == JOptionPane.YES_OPTION){
							int componentCount = tabbedPane.getComponentCount();
							for(int index = 0; index<componentCount; index++){
								BVRToolModel model = Context.eINSTANCE.getBvrModels().get(index);
								StaticUICommands.saveModelToFile((JComponent) tabbedPane.getComponent(index), model, true);
							}
						}
						System.exit(0);
					}catch (Exception error){
						Context.eINSTANCE.logger.error("some error on Save", error);
						StaticUICommands.showMessageErrorDialog(frame, error, "Error:");
					}
				}
			}
		});
	}

	public JTabbedPane getJTabbedPane(){
		return tabbedPane;
	}

}
