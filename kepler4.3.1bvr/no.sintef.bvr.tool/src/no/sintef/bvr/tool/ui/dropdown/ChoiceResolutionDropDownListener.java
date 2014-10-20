package no.sintef.bvr.tool.ui.dropdown;

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

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.ChangeVSpecResolvedEvent;
import no.sintef.bvr.tool.ui.command.SetDecisionEvent;
import no.sintef.bvr.tool.ui.command.event.AddChoiceEvent;
import no.sintef.bvr.tool.ui.command.event.AddChoiceResolvedEvent;
import no.sintef.bvr.tool.ui.command.event.AddClassifierEvent;
import no.sintef.bvr.tool.ui.command.event.AddVInstanceEvent;
import no.sintef.bvr.tool.ui.command.event.AddVariableValueAssignmentEvent;
import no.sintef.bvr.tool.ui.command.event.MaximizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.MinimizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupToAltEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupToNoneEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupToOrEvent;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;
import no.sintef.bvr.ui.framework.elements.VClassifierPanel;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.CompoundNode;
import bvr.NamedElement;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.Variable;


public class ChoiceResolutionDropDownListener extends MouseAdapter {
	private ChoiceResolutionPanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private BVRNotifiableController view;
	private ChoiceResolution c;

	public ChoiceResolutionDropDownListener(ChoiceResolutionPanel cp, ChoiceResolution c, Map<JComponent, NamedElement> vmMap, BVRNotifiableController view){
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
    public ChoiceResolutionDropdown(ChoiceResolutionPanel cp, ChoiceResolution c, BVRNotifiableController view, Map<JComponent, NamedElement> vmMap){
    	// Add
    	VSpec vSpec = CommonUtility.getResolvedVSpec(c);
    	if(vSpec != null){
    		JMenu add = new JMenu("add");
	    	for(VNode x : ((CompoundNode) vSpec).getMember()){
	    		JMenuItem addchild = new JMenuItem(((NamedElement) x).getName());
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
	    	if(((CompoundNode) vSpec).getMember().size() == 0){
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
	/*	JMenu value = new JMenu("Set Resolution");
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
		
		// max/min
		JMenuItem minimize = new JMenuItem("minimize");
		minimize.addActionListener(new MinimizeEvent(cp, vmMap, null, null, view));
		add(minimize);
		JMenuItem maximize = new JMenuItem("maximize");
		maximize.addActionListener(new MaximizeEvent(cp, vmMap, null, null, view));
		add(maximize);*/
    }
    
    /*private VSpec getParent(ConfigurableUnit cu, VSpec child){
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
    }*/
}