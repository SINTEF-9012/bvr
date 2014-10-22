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
import bvr.VSpec;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.event.AddChoiceEvent;
import no.sintef.bvr.tool.ui.command.event.AddClassifierEvent;
import no.sintef.bvr.tool.ui.command.event.AddConstraintEvent;
import no.sintef.bvr.tool.ui.command.event.AddVariableEvent;
import no.sintef.bvr.tool.ui.command.event.CutEvent;
import no.sintef.bvr.tool.ui.command.event.MaximizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.MinimizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.PasteChildEvent;
import no.sintef.bvr.tool.ui.command.event.PasteSiblingEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupToAltEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupToNoneEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupToOrEvent;
import no.sintef.bvr.tool.ui.command.event.ToggleOptionalEvent;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;

public class ChoiceDropDownListener extends MouseAdapter {
	private ChoicePanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController view;

	public ChoiceDropDownListener(ChoicePanel cp, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view){
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
        ChoiceDropdown menu = new ChoiceDropdown(cp, vmMap, nodes, bindings, view);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class ChoiceDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public ChoiceDropdown(ChoicePanel cp, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view){
    	// Add
    	JMenu add = new JMenu("add");
    	JMenuItem addchoice = new JMenuItem("choice");
    	addchoice.addActionListener(new AddChoiceEvent(cp, view));
    	add.add(addchoice);
    	JMenuItem addclassifier = new JMenuItem("classifier");
    	addclassifier.addActionListener(new AddClassifierEvent(cp, view));
    	add.add(addclassifier);
    	JMenuItem addConstraint = new JMenuItem("constraint");
    	addConstraint.addActionListener(new AddConstraintEvent(cp, view));
    	add.add(addConstraint);
    	
    	JMenuItem addVariable = new JMenuItem("variable");
    	addVariable.addActionListener(new AddVariableEvent(cp, view));
    	add.add(addVariable);
    	
		add(add);
		
		// Remove
		JMenuItem removechoice = new JMenuItem("remove");
		removechoice.addActionListener(new RemoveVSpecEvent(cp, vmMap, nodes, bindings, view));
		add(removechoice);
		
		// Cut Paste
		add(new JSeparator());
		JMenuItem cut = new JMenuItem("cut");
		cut.addActionListener(new CutEvent(cp, view));
		add(cut);
		JMenuItem pastechild = new JMenuItem("paste as child");
		pastechild.addActionListener(new PasteChildEvent(cp, view));
		add(pastechild);
		JMenuItem pastesibling = new JMenuItem("paste as sibling");
		pastesibling.addActionListener(new PasteSiblingEvent(cp, view));
		add(pastesibling);
		add(new JSeparator());
		
		// Toggle optional
		JMenuItem toggleOptional = new JMenuItem("un-/toggle optional");
		toggleOptional.addActionListener(new ToggleOptionalEvent(cp, view));
		add(toggleOptional);
		
		// Set group
		JMenu group = new JMenu("set group");
		JMenuItem none = new JMenuItem("none (0..*)");
		none.addActionListener(new SetGroupToNoneEvent(cp, vmMap, nodes, bindings, view));
		group.add(none);
		JMenuItem alt = new JMenuItem("alternative/xor (1..1)");
		alt.addActionListener(new SetGroupToAltEvent(cp, vmMap, nodes, bindings, view));
		group.add(alt);
		JMenuItem or = new JMenuItem("or (1..*)");
		or.addActionListener(new SetGroupToOrEvent(cp, vmMap, nodes, bindings, view));
		group.add(or);
		group.add(new JMenuItem("custom..."));
		add(group);
		
		// Change to
		JMenu change = new JMenu("change to");
		change.add(new JMenuItem("classifier"));
		add(change);
		
		// max/min
		JMenuItem minimize = new JMenuItem("minimize");
		minimize.addActionListener(new MinimizeVSpecEvent(cp, view));
		add(minimize);
		JMenuItem maximize = new JMenuItem("maximize");
		maximize.addActionListener(new MaximizeVSpecEvent(cp, view));
		add(maximize);
    }
}