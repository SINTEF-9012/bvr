package no.sintef.bvr.tool.ui.edit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;


import javax.swing.JDialog;

import no.sintef.bvr.tool.ui.command.Command;
import no.sintef.bvr.tool.ui.loader.BVRToolView;


public class JCommandButton extends JButton {

	private static final long serialVersionUID = 6470959770787697161L;
	protected Command command;
	protected BVRToolView view;
	
    public JCommandButton(final String title, final Command command, final BVRToolView view){
    	this.command = command;
    	this.view = view;
        this.setText(title);
        this.setOpaque(false);
        this.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
        		command.execute();
        		if(view != null)
        			view.getKernel().getEditorPanel().unshowPropertyEditor();
            }
        });

    }
    
    public JCommandButton(final String title, final Command command){
    	this(title, command, null);
    }
}
