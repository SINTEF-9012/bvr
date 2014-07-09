package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import no.sintef.bvr.tool.ui.command.Command;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;


public class JCommandButtonV2 extends JButton {

	private static final long serialVersionUID = 6470959770787697161L;
	protected Command command;
	protected BVREditorPanel view;
	
    public JCommandButtonV2(final String title, final Command command, final BVREditorPanel view){
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
    
    public JCommandButtonV2(final String title, final Command command){
    	this(title, command, null);
    }
}
