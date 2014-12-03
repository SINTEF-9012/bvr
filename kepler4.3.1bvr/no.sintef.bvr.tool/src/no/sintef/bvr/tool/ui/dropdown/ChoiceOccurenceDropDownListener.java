package no.sintef.bvr.tool.ui.dropdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import bvr.NamedElement;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.ui.command.event.AddConstraintEvent;
import no.sintef.bvr.tool.ui.command.event.AddVariableEvent;
import no.sintef.bvr.tool.ui.command.event.CutEvent;
import no.sintef.bvr.tool.ui.command.event.MaximizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.MinimizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.PasteChildEvent;
import no.sintef.bvr.tool.ui.command.event.PasteSiblingEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecEvent;
import no.sintef.bvr.ui.framework.elements.ChoiceOccurencePanel;


public class ChoiceOccurenceDropDownListener extends MouseAdapter {
	private ChoiceOccurencePanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController view;

	public ChoiceOccurenceDropDownListener(ChoiceOccurencePanel cp, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view){
		this.cp = cp;
		this.vmMap = vmMap;
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
    	ChoiceOccurenceDropDown menu = new ChoiceOccurenceDropDown(cp, vmMap, nodes, bindings, view);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class ChoiceOccurenceDropDown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public ChoiceOccurenceDropDown(ChoiceOccurencePanel cp, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view){
    	// Add
    	JMenu add = new JMenu(Constants.VSPEC_DROPDOWN_ADD);
    	JMenuItem addConstraint = new JMenuItem(Constants.VSPEC_DROPDOWN_ADD_CONSTRAINT);
    	addConstraint.addActionListener(new AddConstraintEvent(cp, view));
    	add.add(addConstraint);
    	
    	JMenuItem addVariable = new JMenuItem(Constants.VSPEC_DROPDOWN_ADD_VARIABLE);
    	addVariable.addActionListener(new AddVariableEvent(cp, view));
    	add.add(addVariable);
		add(add);
		
		// Remove
		JMenuItem removechoice = new JMenuItem(Constants.VSPEC_DROPDOWN_REMOVE);
		removechoice.addActionListener(new RemoveVSpecEvent(cp, view));
		add(removechoice);
		
		// Cut Paste
		add(new JSeparator());
		JMenuItem cut = new JMenuItem(Constants.VSPEC_DROPDOWN_CUT);
		cut.addActionListener(new CutEvent(cp, view));
		add(cut);
		JMenuItem pastechild = new JMenuItem(Constants.VSPEC_DROPDOWN_PAST_CHILD);
		pastechild.addActionListener(new PasteChildEvent(cp, view));
		add(pastechild);
		JMenuItem pastesibling = new JMenuItem(Constants.VSPEC_DROPDOWN_PAST_SIBLING);
		pastesibling.addActionListener(new PasteSiblingEvent(cp, view));
		add(pastesibling);
		add(new JSeparator());
		
		// max/min
		JMenuItem minimize = new JMenuItem(Constants.VSPEC_DROPDOWN_MINIMIZE);
		minimize.addActionListener(new MinimizeVSpecEvent(cp, view));
		add(minimize);
		JMenuItem maximize = new JMenuItem(Constants.VSPEC_DROPDOWN_MAXIMIZE);
		maximize.addActionListener(new MaximizeVSpecEvent(cp, view));
		add(maximize);
    }
}