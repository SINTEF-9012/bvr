package no.sintef.cvl.ui.commands;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import no.sintef.cvl.ui.commands.events.AddChoiceEvent;
import no.sintef.cvl.ui.commands.events.AddClassifierEvent;
import no.sintef.cvl.ui.commands.events.CutEvent;
import no.sintef.cvl.ui.commands.events.PasteChildEvent;
import no.sintef.cvl.ui.commands.events.PasteSiblingEvent;
import no.sintef.cvl.ui.commands.events.RemoveChoiceEvent;
import no.sintef.cvl.ui.commands.events.SetGroupToAltEvent;
import no.sintef.cvl.ui.commands.events.SetGroupToNoneEvent;
import no.sintef.cvl.ui.commands.events.SetGroupToOrEvent;
import no.sintef.cvl.ui.commands.events.ToggleOptionalEvent;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.loader.Main;

class ChoiceDropDownListener extends MouseAdapter {
	private ChoicePanel cp;

	ChoiceDropDownListener(ChoicePanel cp){
		this.cp = cp;
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
        ChoiceDropdown menu = new ChoiceDropdown(cp);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class ChoiceDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public ChoiceDropdown(ChoicePanel cp){
    	// Add
    	JMenu add = new JMenu("add");
    	JMenuItem addchoice = new JMenuItem("choice");
    	addchoice.addActionListener(new AddChoiceEvent(cp, Main.vmMap));
    	add.add(addchoice);
    	JMenuItem addclassifier = new JMenuItem("classifier");
    	addclassifier.addActionListener(new AddClassifierEvent(cp, Main.vmMap));
    	add.add(addclassifier);
    	add.add(new JMenuItem("constraint"));
		add(add);
		
		// Remove
		JMenuItem removechoice = new JMenuItem("remove");
		removechoice.addActionListener(new RemoveChoiceEvent(cp, Main.vmMap));
		add(removechoice);
		
		// Cut Paste
		add(new JSeparator());
		JMenuItem cut = new JMenuItem("cut");
		cut.addActionListener(new CutEvent(cp, Main.vmMap));
		add(cut);
		JMenuItem pastechild = new JMenuItem("paste as child");
		pastechild.addActionListener(new PasteChildEvent(cp, Main.vmMap));
		add(pastechild);
		JMenuItem pastesibling = new JMenuItem("paste as sibling");
		pastesibling.addActionListener(new PasteSiblingEvent(cp, Main.vmMap));
		add(pastesibling);
		add(new JSeparator());
		
		// Toggle optional
		JMenuItem toggleOptional = new JMenuItem("toggle optional");
		toggleOptional.addActionListener(new ToggleOptionalEvent(cp, Main.vmMap));
		add(toggleOptional);
		
		// Set group
		JMenu group = new JMenu("set group");
		JMenuItem none = new JMenuItem("none (0..*)");
		none.addActionListener(new SetGroupToNoneEvent(cp, Main.vmMap));
		group.add(none);
		JMenuItem alt = new JMenuItem("alternative/xor (1..1)");
		alt.addActionListener(new SetGroupToAltEvent(cp, Main.vmMap));
		group.add(alt);
		JMenuItem or = new JMenuItem("or (1..*)");
		or.addActionListener(new SetGroupToOrEvent(cp, Main.vmMap));
		group.add(or);
		group.add(new JMenuItem("custom..."));
		add(group);
		
		// Change to
    	JMenu change = new JMenu("change to");
    	change.add(new JMenuItem("classifier"));
		add(change);
    }
}