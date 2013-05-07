package no.sintef.cvl.ui.dropdowns;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.ui.commands.ChangeChoiceResolvedEvent;
import no.sintef.cvl.ui.commands.SetDecisionEvent;
import no.sintef.cvl.ui.commands.events.AddChoiceResolvedEvent;
import no.sintef.cvl.ui.commands.events.AddVInstanceEvent;
import no.sintef.cvl.ui.commands.events.AddVariableValueAssignmentEvent;
import no.sintef.cvl.ui.framework.elements.ChoiceResolutionPanel;
import no.sintef.cvl.ui.framework.elements.VInstancePanel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Pair;
import cvl.Choice;
import cvl.ChoiceResolutuion;
import cvl.ConfigurableUnit;
import cvl.NamedElement;
import cvl.VClassifier;
import cvl.VInstance;
import cvl.VSpec;
import cvl.Variable;

public class VInstanceDropDownListener  extends MouseAdapter {
	private VInstancePanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private CVLView view;
	private VInstance c;

	/*public VInstanceDropDownListener(VInstancePanel c, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view){
		this.cp = c;
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.view = view;
	}*/
	
    public VInstanceDropDownListener(VInstancePanel cp, VInstance c, CVLView view) {
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
    	VInstanceDropdown menu = new VInstanceDropdown(cp, c, view);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class VInstanceDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public VInstanceDropdown(VInstancePanel cp, VInstance c, CVLView view){
    	// Add
    	if(c.getResolvedVSpec() != null){
    		JMenu add = new JMenu("add");
	    	for(VSpec x : c.getResolvedVSpec().getChild()){
	    		JMenuItem addchild = new JMenuItem(x.getName());
	    		if(x instanceof Choice){
	    			addchild.addActionListener(new AddChoiceResolvedEvent(c, (Choice) x, view));
	    		}else if(x instanceof VClassifier){
	    			addchild.addActionListener(new AddVInstanceEvent(c, (VClassifier) x, view));
	    		}else if(x instanceof Variable){
	    			addchild.addActionListener(new AddVariableValueAssignmentEvent(c, (Variable) x, view));
	    		}else{
	    			throw new UnsupportedOperationException("Unsupported: " + x.getClass().getName());
	    		}
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