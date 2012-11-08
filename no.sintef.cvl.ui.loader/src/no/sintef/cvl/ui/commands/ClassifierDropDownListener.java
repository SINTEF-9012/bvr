package no.sintef.cvl.ui.commands;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import no.sintef.cvl.ui.commands.events.AddChoiceEvent;
import no.sintef.cvl.ui.commands.events.AddClassifierEvent;
import no.sintef.cvl.ui.commands.events.RemoveChoiceEvent;
import no.sintef.cvl.ui.commands.events.SetGroupToAltEvent;
import no.sintef.cvl.ui.commands.events.SetGroupToNoneEvent;
import no.sintef.cvl.ui.commands.events.SetGroupToOrEvent;
import no.sintef.cvl.ui.commands.events.ToggleOptionalEvent;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.framework.elements.VClassifierPanel;
import no.sintef.cvl.ui.loader.Main;

class ClassifierDropDownListener extends MouseAdapter {
	private VClassifierPanel cp;

	ClassifierDropDownListener(VClassifierPanel cp){
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
    	ClassifierDropdown menu = new ClassifierDropdown(cp);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class ClassifierDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public ClassifierDropdown(VClassifierPanel cp){
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