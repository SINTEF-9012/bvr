package no.sintef.cvl.tool.ui.dropdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import no.sintef.cvl.tool.ui.command.event.AddVariableEvent;
import no.sintef.cvl.tool.ui.command.event.CutEvent;
import no.sintef.cvl.tool.ui.command.event.PasteChildEvent;
import no.sintef.cvl.tool.ui.command.event.PasteSiblingEvent;
import no.sintef.cvl.tool.ui.command.event.RemoveChoiceEvent;
import no.sintef.cvl.tool.ui.command.event.SetGroupToAltEvent;
import no.sintef.cvl.tool.ui.command.event.SetGroupToNoneEvent;
import no.sintef.cvl.tool.ui.command.event.SetGroupToOrEvent;
import no.sintef.cvl.tool.ui.command.event.ToggleOptionalEvent;
import no.sintef.cvl.tool.ui.loader.VSpecView;
import no.sintef.cvl.tool.ui.loader.Pair;
import no.sintef.cvl.ui.framework.ParallelogramTitledPanel;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import cvl.NamedElement;

public class BCLConstraintDropDownListener extends MouseAdapter {

	private ParallelogramTitledPanel constraint1;
	private Map<JComponent, NamedElement> vmMap;
	private VSpecView view;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;

	public BCLConstraintDropDownListener(ParallelogramTitledPanel constraint1,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, VSpecView view) {
		this.constraint1 = constraint1;
		this.vmMap = vmMap;
		this.view = view;
		this.nodes = nodes;
		this.bindings = bindings;
	}

	@Override
	public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger())
            doPop(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger())
            doPop(e);
	}

   private void doPop(MouseEvent e){
        BCLConstraintDropdown menu = new BCLConstraintDropdown(constraint1, vmMap, nodes, bindings, view);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class BCLConstraintDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public BCLConstraintDropdown(ParallelogramTitledPanel constraint1, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, VSpecView view){
		
		// Remove
		JMenuItem removechoice = new JMenuItem("remove");
		removechoice.addActionListener(new RemoveChoiceEvent(constraint1, vmMap, nodes, bindings, view));
		add(removechoice);
    }
}