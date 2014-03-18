package no.sintef.bvr.tool.ui.edit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;


import no.sintef.bvr.tool.ui.command.Command;


public class JCommandButton extends JButton {

	private static final long serialVersionUID = 6470959770787697161L;
	protected Command command;
	
    public JCommandButton(final String title, final Command command){
    	this.command = command;
        this.setText(title);
        this.setOpaque(false);
        this.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
        		command.execute();
            }
        });

    }
}
