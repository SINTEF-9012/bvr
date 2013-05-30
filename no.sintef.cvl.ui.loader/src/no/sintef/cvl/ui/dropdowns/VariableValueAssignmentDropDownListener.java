package no.sintef.cvl.ui.dropdowns;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.ui.commands.ChangeVSpecResolvedEvent;
import no.sintef.cvl.ui.commands.SetDecisionEvent;
import no.sintef.cvl.ui.commands.events.AddChoiceResolvedEvent;
import no.sintef.cvl.ui.commands.events.AddVInstanceEvent;
import no.sintef.cvl.ui.commands.events.AddVariableValueAssignmentEvent;
import no.sintef.cvl.ui.commands.events.RemoveVSpecResolutionEvent;
import no.sintef.cvl.ui.framework.elements.ChoiceResolutionPanel;
import no.sintef.cvl.ui.framework.elements.VInstancePanel;
import no.sintef.cvl.ui.framework.elements.VariableAssignmentPanel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Pair;
import cvl.Choice;
import cvl.ChoiceResolutuion;
import cvl.ConfigurableUnit;
import cvl.NamedElement;
import cvl.VClassifier;
import cvl.VInstance;
import cvl.VSpec;
import cvl.Variable;
import cvl.VariableValueAssignment;

public class VariableValueAssignmentDropDownListener  extends MouseAdapter {
	private VariableAssignmentPanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private CVLView view;
	private VariableValueAssignment c;
	
    public VariableValueAssignmentDropDownListener(VariableAssignmentPanel cp, VariableValueAssignment c, CVLView view, Map<JComponent, NamedElement> vmMap) {
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
    public VariableValueAssignmentDropdown(VariableAssignmentPanel cp, VariableValueAssignment c, CVLView view, Map<JComponent, NamedElement> vmMap){
		// -delete menus
		JMenuItem remove = new JMenuItem("Remove");
		remove.addActionListener(new RemoveVSpecResolutionEvent(cp, vmMap, view));
		add(remove);
    }
}