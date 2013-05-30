package no.sintef.cvl.ui.dropdowns;

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

import no.sintef.cvl.ui.commands.events.AddChoiceEvent;
import no.sintef.cvl.ui.commands.events.AddClassifierEvent;
import no.sintef.cvl.ui.commands.events.AddConstraintEvent;
import no.sintef.cvl.ui.commands.events.AddVariableEvent;
import no.sintef.cvl.ui.commands.events.CutEvent;
import no.sintef.cvl.ui.commands.events.PasteChildEvent;
import no.sintef.cvl.ui.commands.events.PasteSiblingEvent;
import no.sintef.cvl.ui.commands.events.RemoveChoiceEvent;
import no.sintef.cvl.ui.commands.events.SetGroupToAltEvent;
import no.sintef.cvl.ui.commands.events.SetGroupToNoneEvent;
import no.sintef.cvl.ui.commands.events.SetGroupToOrEvent;
import no.sintef.cvl.ui.commands.events.ToggleOptionalEvent;
import no.sintef.cvl.ui.framework.ParallelogramTitledPanel;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Pair;
import cvl.NamedElement;

public class BCLConstraintDropDownListener extends MouseAdapter {

	private ParallelogramTitledPanel constraint1;
	private Map<JComponent, NamedElement> vmMap;
	private CVLView view;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;

	public BCLConstraintDropDownListener(ParallelogramTitledPanel constraint1,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, CVLView view) {
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
    public BCLConstraintDropdown(ParallelogramTitledPanel constraint1, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view){
		
		// Remove
		JMenuItem removechoice = new JMenuItem("remove");
		removechoice.addActionListener(new RemoveChoiceEvent(constraint1, vmMap, nodes, bindings, view));
		add(removechoice);
    }
}