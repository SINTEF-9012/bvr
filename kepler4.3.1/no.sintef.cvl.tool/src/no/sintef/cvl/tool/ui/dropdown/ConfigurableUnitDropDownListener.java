package no.sintef.cvl.tool.ui.dropdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import no.sintef.cvl.tool.ui.command.event.AddChoiceEvent;
import no.sintef.cvl.tool.ui.command.event.AddClassifierEvent;
import no.sintef.cvl.tool.ui.command.event.AddConstraintEvent;
import no.sintef.cvl.tool.ui.command.event.CutEvent;
import no.sintef.cvl.tool.ui.command.event.PasteChildEvent;
import no.sintef.cvl.tool.ui.command.event.RemoveChoiceEvent;
import no.sintef.cvl.tool.ui.command.event.SetGroupToAltEvent;
import no.sintef.cvl.tool.ui.command.event.SetGroupToNoneEvent;
import no.sintef.cvl.tool.ui.command.event.SetGroupToOrEvent;
import no.sintef.cvl.tool.ui.loader.CVLView;
import no.sintef.cvl.tool.ui.loader.Pair;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitSymbolPanel;
import cvl.NamedElement;
import cvl.VSpec;

public class ConfigurableUnitDropDownListener extends MouseAdapter {

	private ConfigurableUnitSymbolPanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private CVLView view;

	public ConfigurableUnitDropDownListener(ConfigurableUnitSymbolPanel cp, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view){
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
    	ConfigurableUnitDropdown menu = new ConfigurableUnitDropdown(cp, vmMap, nodes, bindings, view);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class ConfigurableUnitDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public ConfigurableUnitDropdown(ConfigurableUnitSymbolPanel cp, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view){
    	// Add
    	JMenu add = new JMenu("add");
    	JMenuItem addchoice = new JMenuItem("choice");
    	addchoice.addActionListener(new AddChoiceEvent(cp, vmMap, nodes, bindings, view));
    	add.add(addchoice);
    	JMenuItem addclassifier = new JMenuItem("classifier");
    	addclassifier.addActionListener(new AddClassifierEvent(cp, vmMap, nodes, bindings, view));
    	add.add(addclassifier);
    	JMenuItem addConstraint = new JMenuItem("constraint");
    	addConstraint.addActionListener(new AddConstraintEvent(cp, vmMap, nodes, bindings, view));
    	add.add(addConstraint);
    	
		add(add);
		
		// Remove
		JMenuItem rename = new JMenuItem("rename");
		rename.addActionListener(new RemoveChoiceEvent(cp, vmMap, nodes, bindings, view));
		add(rename);
		
		// Paste
		add(new JSeparator());
		JMenuItem pastechild = new JMenuItem("paste as child");
		pastechild.addActionListener(new PasteChildEvent(cp, vmMap, nodes, bindings, view));
		add(pastechild);
    }

}
