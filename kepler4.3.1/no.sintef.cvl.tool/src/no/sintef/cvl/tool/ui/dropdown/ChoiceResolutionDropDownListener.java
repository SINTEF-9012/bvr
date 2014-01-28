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

import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.tool.ui.command.ChangeVSpecResolvedEvent;
import no.sintef.cvl.tool.ui.command.SetDecisionEvent;
import no.sintef.cvl.tool.ui.command.event.AddChoiceEvent;
import no.sintef.cvl.tool.ui.command.event.AddChoiceResolvedEvent;
import no.sintef.cvl.tool.ui.command.event.AddClassifierEvent;
import no.sintef.cvl.tool.ui.command.event.AddVInstanceEvent;
import no.sintef.cvl.tool.ui.command.event.AddVariableValueAssignmentEvent;
import no.sintef.cvl.tool.ui.command.event.RemoveChoiceEvent;
import no.sintef.cvl.tool.ui.command.event.RemoveVSpecResolutionEvent;
import no.sintef.cvl.tool.ui.command.event.SetGroupToAltEvent;
import no.sintef.cvl.tool.ui.command.event.SetGroupToNoneEvent;
import no.sintef.cvl.tool.ui.command.event.SetGroupToOrEvent;
import no.sintef.cvl.tool.ui.loader.CVLView;
import no.sintef.cvl.tool.ui.loader.Pair;
import no.sintef.cvl.ui.framework.elements.ChoiceResolutionPanel;
import no.sintef.cvl.ui.framework.elements.VClassifierPanel;
import cvl.Choice;
import cvl.ChoiceResolutuion;
import cvl.ConfigurableUnit;
import cvl.NamedElement;
import cvl.VClassifier;
import cvl.VSpec;
import cvl.VSpecResolution;
import cvl.Variable;
import cvl.VariableValueAssignment;

public class ChoiceResolutionDropDownListener extends MouseAdapter {
	private ChoiceResolutionPanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private CVLView view;
	private ChoiceResolutuion c;

	public ChoiceResolutionDropDownListener(ChoiceResolutionPanel cp, ChoiceResolutuion c, Map<JComponent, NamedElement> vmMap, CVLView view){
		this.cp = cp;
		this.vmMap = vmMap;
		this.view = view;
		this.c = c;
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
    	ChoiceResolutionDropdown menu = new ChoiceResolutionDropdown(cp, c, view, vmMap);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class ChoiceResolutionDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public ChoiceResolutionDropdown(ChoiceResolutionPanel cp, ChoiceResolutuion c, CVLView view, Map<JComponent, NamedElement> vmMap){
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
    		if(x instanceof Choice){
	    		JMenuItem i = new JMenuItem(x.getName());
	    		i.addActionListener(new ChangeVSpecResolvedEvent(c, (Choice)x, view));
	    		change.add(i);
    		}else{
    			// Can only change to another of the same type
    		}
    	}
		add(change);
		// -delete menus
		JMenuItem remove = new JMenuItem("Remove");
		remove.addActionListener(new RemoveVSpecResolutionEvent(cp, vmMap, view));
		add(remove);
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