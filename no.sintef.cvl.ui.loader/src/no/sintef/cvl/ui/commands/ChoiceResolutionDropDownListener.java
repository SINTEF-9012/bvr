package no.sintef.cvl.ui.commands;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.ui.commands.events.AddChoiceEvent;
import no.sintef.cvl.ui.commands.events.AddClassifierEvent;
import no.sintef.cvl.ui.commands.events.RemoveChoiceEvent;
import no.sintef.cvl.ui.commands.events.SetGroupToAltEvent;
import no.sintef.cvl.ui.commands.events.SetGroupToNoneEvent;
import no.sintef.cvl.ui.commands.events.SetGroupToOrEvent;
import no.sintef.cvl.ui.framework.elements.ChoiceResolutionPanel;
import no.sintef.cvl.ui.framework.elements.VClassifierPanel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Pair;
import cvl.Choice;
import cvl.ChoiceResolutuion;
import cvl.ConfigurableUnit;
import cvl.VSpec;
import cvl.VSpecResolution;

public class ChoiceResolutionDropDownListener extends MouseAdapter {
	private ChoiceResolutionPanel cp;
	private Map<JComponent, VSpec> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private CVLView view;
	private ChoiceResolutuion c;

	ChoiceResolutionDropDownListener(ChoiceResolutionPanel cp, Map<JComponent, VSpec> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view){
		this.cp = cp;
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.view = view;
	}
	
    public ChoiceResolutionDropDownListener(ChoiceResolutionPanel cp, ChoiceResolutuion c, CVLView view) {
		this.cp = cp;
		this.c = c;
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
    	ChoiceResolutionDropdown menu = new ChoiceResolutionDropdown(cp, c, view);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class ChoiceResolutionDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public ChoiceResolutionDropdown(ChoiceResolutionPanel cp, ChoiceResolutuion c, CVLView view){
    	// Add
    	if(c.getResolvedVSpec() != null){
    		JMenu add = new JMenu("add");
	    	for(VSpec x : c.getResolvedVSpec().getChild()){
	    		JMenuItem addchild = new JMenuItem(x.getName());
	    		addchild.addActionListener(new AddChoiceResolvedEvent(c, x, view));
	    		add.add(addchild);    		
	    	}
	    	if(c.getResolvedVSpec().getChild().size() == 0){
	    		add.add(new JMenuItem("No further VSpec")); 
	    	}
	    	add(add);
    	}
		
		
		// Remove
/*		JMenuItem removechoice = new JMenuItem("remove");
		removechoice.addActionListener(new RemoveChoiceEvent(cp, vmMap, nodes, bindings, view));
		add(removechoice);
*/		
		// Set group
		JMenu value = new JMenu("Set Resolution");
		JMenuItem vtrue = new JMenuItem("true");
		vtrue.addActionListener(new SetDecisionEvent(c, view, true));
		value.add(vtrue);
		JMenuItem vfalse = new JMenuItem("false");
		vfalse.addActionListener(new SetDecisionEvent(c, view, false));
		value.add(vfalse);
		add(value);
		
		// Change to
		EList<VSpec> vspecs = null;
		if(c.getResolvedVSpec() == null){
			vspecs = view.getCU().getOwnedVSpec();
		}else{
			VSpec parent = getParent(view.getCU(), c.getResolvedVSpec());
			if(parent == null)
				vspecs = view.getCU().getOwnedVSpec();
			else
				vspecs = getParent(view.getCU(), c.getResolvedVSpec()).getChild();
		}
		// -Add menus
    	JMenu change = new JMenu("Resolve");
    	for(VSpec x : vspecs){
    		JMenuItem i = new JMenuItem(x.getName());
    		i.addActionListener(new ChangeChoiceResolvedEvent(c, (Choice)x, view));
    		change.add(i);
    	}
		add(change);
    }
    
    private VSpec getParent(ConfigurableUnit cu, VSpec child){
    	for(VSpec c : cu.getOwnedVSpec())
    		if(c == child)
    			return null;
    	for(VSpec r : cu.getOwnedVSpec()){
    		VSpec found = getParent(r, child);
    		if(found != null) return found;
    	}
    	return null;
    }
    
    private VSpec getParent(VSpec root, VSpec child){
    	for(VSpec r : root.getChild())
    		if(r == child)
    			return root;
    	for(VSpec r : root.getChild()){
    		VSpec found = getParent(r, child);
    		if(found != null) return found;
    	}
    	return null;
    }
}