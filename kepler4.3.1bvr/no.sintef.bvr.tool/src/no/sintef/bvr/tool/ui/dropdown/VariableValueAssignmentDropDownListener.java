package no.sintef.bvr.tool.ui.dropdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.eclipse.emf.common.util.EList;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.ChangeVSpecResolvedEvent;
import no.sintef.bvr.tool.ui.command.SetDecisionEvent;
import no.sintef.bvr.tool.ui.command.event.ResolveChoiceVClassifierEvent;
import no.sintef.bvr.tool.ui.command.event.AddChoiceFromVClassifierEvent;
import no.sintef.bvr.tool.ui.command.event.AddValueResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.MaximizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.MinimizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecResolutionEvent;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;
//import no.sintef.bvr.ui.framework.elements.VInstancePanel;
import no.sintef.bvr.ui.framework.elements.VariableAssignmentPanel;
import bvr.Choice;
import bvr.NamedElement;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.Variable;


public class VariableValueAssignmentDropDownListener  extends MouseAdapter {
	private VariableAssignmentPanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private BVRNotifiableController view;

	
    public VariableValueAssignmentDropDownListener(VariableAssignmentPanel cp, /*VariableValueAssignment c,*/ BVRNotifiableController view, Map<JComponent, NamedElement> vmMap) {
		this.cp = cp;
		//this.c = c;
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
    	//VariableValueAssignmentDropdown menu = new VariableValueAssignmentDropdown(cp, c, view, vmMap);
       // menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class VariableValueAssignmentDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public VariableValueAssignmentDropdown(VariableAssignmentPanel cp, /*VariableValueAssignment c,*/ BVRNotifiableController view, Map<JComponent, NamedElement> vmMap){
		// -delete menus
		JMenuItem remove = new JMenuItem("Remove");
		remove.addActionListener(new RemoveVSpecResolutionEvent(cp, view));
		add(remove);
		
		// max/min
		/*JMenuItem minimize = new JMenuItem("minimize");
		minimize.addActionListener(new MinimizeVSpecEvent(cp, vmMap, null, null, view));
		add(minimize);
		JMenuItem maximize = new JMenuItem("maximize");
		maximize.addActionListener(new MaximizeVSpecEvent(cp, vmMap, null, null, view));
		add(maximize);*/
    }
}