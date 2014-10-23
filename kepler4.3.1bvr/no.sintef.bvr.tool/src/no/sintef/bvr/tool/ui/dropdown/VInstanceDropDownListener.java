package no.sintef.bvr.tool.ui.dropdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.eclipse.emf.common.util.EList;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.ChangeVSpecResolvedEvent;
import no.sintef.bvr.tool.ui.command.SetDecisionEvent;
import no.sintef.bvr.tool.ui.command.event.AddChoiceResolvedEvent;
import no.sintef.bvr.tool.ui.command.event.AddChoiceFromVClassifierEvent;
import no.sintef.bvr.tool.ui.command.event.AddValueResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.MaximizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.MinimizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecResolutionEvent;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;
//import no.sintef.bvr.ui.framework.elements.VInstancePanel;
import bvr.Choice;
import bvr.NamedElement;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.Variable;

public class VInstanceDropDownListener  extends MouseAdapter {
	private /*VInstancePanel*/ChoiceResolutionPanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private BVRNotifiableController view;
	//private VInstance c;
	
    public VInstanceDropDownListener(/*VInstancePanel*/ChoiceResolutionPanel cp, /*VInstance c,*/ BVRNotifiableController view, Map<JComponent, NamedElement> vmMap) {
		this.cp = cp;
		//this.c = c;
		this.view = view;
		this.vmMap = vmMap;
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
    	//VInstanceDropdown menu = new VInstanceDropdown(cp, c, view, vmMap);
       // menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class VInstanceDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public VInstanceDropdown(/*VInstancePanel*/ ChoiceResolutionPanel cp, /*VInstance c,*/ BVRNotifiableController view, Map<JComponent, NamedElement> vmMap){
    	// Add
    	/*if(c.getResolvedVSpec() != null){
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