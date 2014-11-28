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

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.ui.command.event.AddChoiceEvent;
import no.sintef.bvr.tool.ui.command.event.AddClassifierEvent;
import no.sintef.bvr.tool.ui.command.event.PasteChildEvent;
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
    	JMenu add = new JMenu("add");
    	JMenuItem addchoice = new JMenuItem("choice");
    	addchoice.addActionListener(new AddChoiceEvent(cp, controller));
    	add.add(addchoice);
    	JMenuItem addclassifier = new JMenuItem("classifier");
    	addclassifier.addActionListener(new AddClassifierEvent(cp, controller));
    	add.add(addclassifier);
    	
		add(add);
				
		// Paste
		add(new JSeparator());
		JMenuItem pastechild = new JMenuItem("paste as child");
		pastechild.addActionListener(new PasteChildEvent(cp, controller));
		add(pastechild);
    }

}
