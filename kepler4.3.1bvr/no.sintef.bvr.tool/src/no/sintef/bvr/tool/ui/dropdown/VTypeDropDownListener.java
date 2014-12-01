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

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.ui.command.event.AddChoiceEvent;
import no.sintef.bvr.tool.ui.command.event.AddClassifierEvent;
import no.sintef.bvr.tool.ui.command.event.PasteChildEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveVTypeEvent;
import no.sintef.bvr.ui.framework.elements.VTypeRootSymbolPanel;
import bvr.NamedElement;


public class VTypeDropDownListener extends MouseAdapter {

	private VTypeRootSymbolPanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRNotifiableController controller;

	public VTypeDropDownListener(VTypeRootSymbolPanel cp, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller){
		this.cp = cp;
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.controller = controller;
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
    	VTypeDropdown menu = new VTypeDropdown(cp, vmMap, nodes, bindings, controller);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class VTypeDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public VTypeDropdown(VTypeRootSymbolPanel cp, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller){
    	// Add
    	JMenu add = new JMenu(Constants.GENERAL_ADD_MENU_ITEM);
    	JMenuItem addchoice = new JMenuItem(Constants.GENERAL_CHOICE_MENU_ITEM);
    	addchoice.addActionListener(new AddChoiceEvent(cp, controller));
    	add.add(addchoice);
    	JMenuItem addclassifier = new JMenuItem(Constants.GENERAL_VCLASSIFIER_MENU_ITEM);
    	addclassifier.addActionListener(new AddClassifierEvent(cp, controller));
    	add.add(addclassifier);
		add(add);
		
		// Remove
		add(new JSeparator());
		JMenuItem remove = new JMenuItem(Constants.GENERAL_REMOVE_MENU_ITEM);
    	remove.addActionListener(new RemoveVTypeEvent(cp, controller));
		add(remove);
				
		// Paste
		add(new JSeparator());
		JMenuItem pastechild = new JMenuItem(Constants.GENERAL_PAST_AS_CHILD_MENU_ITEM);
		pastechild.addActionListener(new PasteChildEvent(cp, controller));
		add(pastechild);
    }

}
