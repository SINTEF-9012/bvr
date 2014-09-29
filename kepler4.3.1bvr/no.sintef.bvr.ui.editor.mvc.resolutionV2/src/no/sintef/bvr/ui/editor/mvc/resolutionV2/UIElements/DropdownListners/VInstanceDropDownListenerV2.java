package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.DropdownListners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import no.sintef.bvr.tool.ui.command.event.AddChoiceResolvedEvent;
import no.sintef.bvr.tool.ui.command.event.AddVInstanceEvent;
import no.sintef.bvr.tool.ui.command.event.AddVariableValueAssignmentEvent;
import no.sintef.bvr.tool.ui.command.event.MaximizeEvent;
import no.sintef.bvr.tool.ui.command.event.MinimizeEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecResolutionEvent;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.AddVInstanceTreeEvent;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.ShowAddMultipleInstanceDialogAndAddEvent;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.StrippedEvent;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.UnstrippedEvent;
import no.sintef.bvr.ui.framework.elements.VInstancePanel;
import bvr.Choice;
import bvr.NamedElement;
import bvr.VClassifier;
//import bvr.VInstance;
import bvr.VSpec;
import bvr.Variable;

public class VInstanceDropDownListenerV2  extends MouseAdapter {
/*	private VInstancePanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private BVRViewV2 view;
//	private VInstance c;
	
    public VInstanceDropDownListenerV2(VInstancePanel cp, VInstance c, BVRViewV2 view, Map<JComponent, NamedElement> vmMap) {
		this.cp = cp;
	//	this.c = c;
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
    	VInstanceDropdown menu = new VInstanceDropdown(cp, c, view, vmMap);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class VInstanceDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public VInstanceDropdown(VInstancePanel cp, VInstance c, BVRViewV2 view, Map<JComponent, NamedElement> vmMap){
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
		//addInstanceTree
		if (c.getResolvedVSpec() != null) {
			JMenu addTree = new JMenu("add realized VInstance subtree");
			for (VSpec x : c.getResolvedVSpec().getChild()) {
				JMenuItem addChild = new JMenuItem(x.getName());
				if (x instanceof VClassifier) {
					addChild.addActionListener(new AddVInstanceTreeEvent(c, (VClassifier) x, view));
					addTree.add(addChild);
				}
			}
			if (c.getResolvedVSpec().getChild().size() == 0) {
				addTree.add(new JMenuItem("No VInstances to add"));
			}
			add(addTree);
		}
		if (c.getResolvedVSpec() != null) {
			JMenu addMulTree = new JMenu("add multiple realized VInstance subtrees");
			for (VSpec x : c.getResolvedVSpec().getChild()) {
				JMenuItem addChild = new JMenuItem(x.getName());
				if (x instanceof VClassifier) {
					addChild.addActionListener(new ShowAddMultipleInstanceDialogAndAddEvent((VClassifier) x, c, view));
					addMulTree.add(addChild);
				}
			}
			if (c.getResolvedVSpec().getChild().size() == 0) {
				addMulTree.add(new JMenuItem("No VInstances to add"));
			}
			add(addMulTree);
		}
		
		// Remove
		JMenuItem removechoice = new JMenuItem("remove");
		removechoice.addActionListener(new RemoveChoiceEvent(cp, vmMap, nodes, bindings, view));
		add(removechoice);
		
		
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
		add(maximize);
		JMenuItem strip = new JMenuItem("strip");
		strip.addActionListener(new StrippedEvent(cp, vmMap, view, c.getResolvedVSpec()));
		add(strip);
		JMenuItem unstrip = new JMenuItem("unstrip");
		unstrip.addActionListener(new UnstrippedEvent(cp, vmMap, view, c.getResolvedVSpec()));
		add(unstrip);
    }*/
}