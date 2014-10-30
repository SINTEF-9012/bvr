package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.DropdownListners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecResolutionEvent;
import no.sintef.bvr.ui.framework.elements.VariableAssignmentPanel;
import bvr.NamedElement;
//import bvr.VariableValueAssignment;

public class VariableValueAssignmentDropDownListenerV2  extends MouseAdapter {
	private VariableAssignmentPanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private BVRResolutionToolView view;
	//private VariableValueAssignment c;
	
    public VariableValueAssignmentDropDownListenerV2(VariableAssignmentPanel cp, /*VariableValueAssignment c,*/ BVRResolutionToolView view, Map<JComponent, NamedElement> vmMap) {
		this.cp = cp;
	//	this.c = c;
		this.view = view;
		this.vmMap = vmMap;
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
    	VariableValueAssignmentDropdown menu = new VariableValueAssignmentDropdown(cp, /*c,*/ view, vmMap);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class VariableValueAssignmentDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public VariableValueAssignmentDropdown(VariableAssignmentPanel cp, /*VariableValueAssignment c,*/ BVRResolutionToolView view, Map<JComponent, NamedElement> vmMap){
		// -delete menus
		JMenuItem remove = new JMenuItem("Remove");
		remove.addActionListener(new RemoveVSpecResolutionEvent(cp, vmMap, view));
		add(remove);
		
    }
}