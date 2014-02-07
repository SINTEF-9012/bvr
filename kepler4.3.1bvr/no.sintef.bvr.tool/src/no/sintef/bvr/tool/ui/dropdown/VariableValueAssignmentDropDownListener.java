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

import no.sintef.bvr.tool.ui.command.ChangeVSpecResolvedEvent;
import no.sintef.bvr.tool.ui.command.SetDecisionEvent;
import no.sintef.bvr.tool.ui.command.event.AddChoiceResolvedEvent;
import no.sintef.bvr.tool.ui.command.event.AddVInstanceEvent;
import no.sintef.bvr.tool.ui.command.event.AddVariableValueAssignmentEvent;
import no.sintef.bvr.tool.ui.command.event.MaximizeEvent;
import no.sintef.bvr.tool.ui.command.event.MinimizeEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecResolutionEvent;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;
import no.sintef.bvr.ui.framework.elements.VInstancePanel;
import no.sintef.bvr.ui.framework.elements.VariableAssignmentPanel;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.NamedElement;
import bvr.VClassifier;
import bvr.VInstance;
import bvr.VSpec;
import bvr.Variable;
import bvr.VariableValueAssignment;

public class VariableValueAssignmentDropDownListener  extends MouseAdapter {
	private VariableAssignmentPanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private BVRView view;
	private VariableValueAssignment c;
	
    public VariableValueAssignmentDropDownListener(VariableAssignmentPanel cp, VariableValueAssignment c, BVRView view, Map<JComponent, NamedElement> vmMap) {
		this.cp = cp;
		this.c = c;
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
    	VariableValueAssignmentDropdown menu = new VariableValueAssignmentDropdown(cp, c, view, vmMap);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class VariableValueAssignmentDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public VariableValueAssignmentDropdown(VariableAssignmentPanel cp, VariableValueAssignment c, BVRView view, Map<JComponent, NamedElement> vmMap){
		// -delete menus
		JMenuItem remove = new JMenuItem("Remove");
		remove.addActionListener(new RemoveVSpecResolutionEvent(cp, vmMap, view));
		add(remove);
		
		// max/min
		JMenuItem minimize = new JMenuItem("minimize");
		minimize.addActionListener(new MinimizeEvent(cp, vmMap, null, null, view));
		add(minimize);
		JMenuItem maximize = new JMenuItem("maximize");
		maximize.addActionListener(new MaximizeEvent(cp, vmMap, null, null, view));
		add(maximize);
    }
}