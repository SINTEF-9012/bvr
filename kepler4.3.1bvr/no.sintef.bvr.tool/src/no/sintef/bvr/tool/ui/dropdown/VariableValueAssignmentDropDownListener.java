package no.sintef.bvr.tool.ui.dropdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecResolutionEvent;
import no.sintef.bvr.ui.framework.elements.VariableAssignmentPanel;



public class VariableValueAssignmentDropDownListener  extends MouseAdapter {
	private VariableAssignmentPanel cp;
	private BVRNotifiableController view;

	
    public VariableValueAssignmentDropDownListener(VariableAssignmentPanel cp, BVRNotifiableController view) {
		this.cp = cp;
		this.view = view;
	}

	public void mousePressed(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    private void doPop(MouseEvent e){
    	VariableValueAssignmentDropdown menu = new VariableValueAssignmentDropdown(cp, view);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class VariableValueAssignmentDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;

    public VariableValueAssignmentDropdown(VariableAssignmentPanel cp, BVRNotifiableController view){
		JMenuItem remove = new JMenuItem(Constants.RESOLUTION_DROPDOWN_REMOVE_ITEM);
		remove.addActionListener(new RemoveVSpecResolutionEvent(cp, view));
		add(remove);
    }
}