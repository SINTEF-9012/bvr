/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
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
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.ui.command.event.AddChoiceEvent;
import no.sintef.bvr.tool.ui.command.event.AddChoiceOccEvent;
import no.sintef.bvr.tool.ui.command.event.AddClassifierEvent;
import no.sintef.bvr.tool.ui.command.event.AddConstraintEvent;
import no.sintef.bvr.tool.ui.command.event.AddVClassOccEvent;
import no.sintef.bvr.tool.ui.command.event.AddVTypeEvent;
import no.sintef.bvr.tool.ui.command.event.AddVariableEvent;
import no.sintef.bvr.tool.ui.command.event.CutEvent;
import no.sintef.bvr.tool.ui.command.event.MaximizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.MinimizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.PasteChildEvent;
import no.sintef.bvr.tool.ui.command.event.PasteSiblingEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupCustomEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupToAltEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupToNoneEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupToOrEvent;
import no.sintef.bvr.tool.ui.command.event.ToggleOptionalEvent;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;
import no.sintef.bvr.ui.framework.elements.VClassifierPanel;

public class ClassifierDropDownListener extends MouseAdapter {
	private VClassifierPanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController view;

	public ClassifierDropDownListener(VClassifierPanel cp, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view){
		this.cp = cp;
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
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
    	ClassifierDropdown menu = new ClassifierDropdown(cp, vmMap, nodes, bindings, view);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class ClassifierDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public ClassifierDropdown(VClassifierPanel cp, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view){
    	// Add
    	JMenu add = new JMenu(Constants.VSPEC_DROPDOWN_ADD);
    	JMenuItem addchoice = new JMenuItem(Constants.VSPEC_DROPDOWN_ADD_CHOICE);
    	addchoice.addActionListener(new AddChoiceEvent(cp, view));
    	add.add(addchoice);
    	JMenuItem addchoiceocc = new JMenuItem(Constants.VSPEC_DROPDOWN_ADD_CHOICEOCC);
    	addchoiceocc.addActionListener(new AddChoiceOccEvent(cp, view));
    	add.add(addchoiceocc);
    	JMenuItem addclassifier = new JMenuItem(Constants.VSPEC_DROPDOWN_ADD_VCLASSIFIER);
    	addclassifier.addActionListener(new AddClassifierEvent(cp, view));
    	add.add(addclassifier);
    	JMenuItem addclassifierocc = new JMenuItem(Constants.VSPEC_DROPDOWN_ADD_VCLASSOCC);
    	addclassifierocc.addActionListener(new AddVClassOccEvent(cp, view));
    	add.add(addclassifierocc);
    	JMenuItem addConstraint = new JMenuItem(Constants.VSPEC_DROPDOWN_ADD_CONSTRAINT);
    	addConstraint.addActionListener(new AddConstraintEvent(cp, view));
    	add.add(addConstraint);
    	
    	JMenuItem addVariable = new JMenuItem(Constants.VSPEC_DROPDOWN_ADD_VARIABLE);
    	addVariable.addActionListener(new AddVariableEvent(cp, view));
    	add.add(addVariable);
    	
    	JMenuItem addType = new JMenuItem(Constants.VSPEC_DROPDOWN_ADD_VTYPE);
    	addType.addActionListener(new AddVTypeEvent(cp, view));
    	add.add(addType);
    	
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
				
		// Set group
		JMenu group = new JMenu(Constants.VSPEC_DROPDOWN_SET_GROUP);
		JMenuItem none = new JMenuItem(Constants.VSPEC_DROPDOWN_SET_GROUP_NONE);
		none.addActionListener(new SetGroupToNoneEvent(cp, view));
		group.add(none);
		JMenuItem alt = new JMenuItem(Constants.VSPEC_DROPDOWN_SET_GROUP_XOR);
		alt.addActionListener(new SetGroupToAltEvent(cp, view));
		group.add(alt);
		JMenuItem or = new JMenuItem(Constants.VSPEC_DROPDOWN_SET_GROUP_OR);
		or.addActionListener(new SetGroupToOrEvent(cp, view));
		group.add(or);
		JMenuItem cus = (new JMenuItem(Constants.VSPEC_DROPDOWN_SET_GROUP_CUSTOM));
		cus.addActionListener(new SetGroupCustomEvent(cp, view));
		group.add(cus);
		add(group);
				
		// max/min
		JMenuItem minimize = new JMenuItem(Constants.VSPEC_DROPDOWN_MINIMIZE);
		minimize.addActionListener(new MinimizeVSpecEvent(cp, view));
		add(minimize);
		JMenuItem maximize = new JMenuItem(Constants.VSPEC_DROPDOWN_MAXIMIZE);
		maximize.addActionListener(new MaximizeVSpecEvent(cp, view));
		add(maximize);
    }
}
