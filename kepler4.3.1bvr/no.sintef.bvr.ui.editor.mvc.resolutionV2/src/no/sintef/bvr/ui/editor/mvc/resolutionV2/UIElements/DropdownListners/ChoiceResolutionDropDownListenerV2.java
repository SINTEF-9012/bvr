package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.DropdownListners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import no.sintef.bvr.tool.ui.command.ChangeVSpecResolvedEvent;
import no.sintef.bvr.tool.ui.command.SetDecisionEvent;
import no.sintef.bvr.tool.ui.command.event.AddChoiceResolvedEvent;
import no.sintef.bvr.tool.ui.command.event.AddVInstanceEvent;
import no.sintef.bvr.tool.ui.command.event.AddVariableValueAssignmentEvent;
import no.sintef.bvr.tool.ui.command.event.MaximizeEvent;
import no.sintef.bvr.tool.ui.command.event.MinimizeEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecResolutionEvent;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRViewV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.AddSubTreeEvent;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.AddVInstanceTreeEvent;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.ShowAddMultipleInstanceDialogAndAddEvent;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.StrippedEvent;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.UnstrippedEvent;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.ValidateEvent;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;

import org.eclipse.emf.common.util.EList;

import bvr.Choice;
//import bvr.ChoiceResolutuion;
//import bvr.ConfigurableUnit;
import bvr.NamedElement;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.Variable;

public class ChoiceResolutionDropDownListenerV2 extends MouseAdapter {
	/*
	private ChoiceResolutionPanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private BVRViewV2 view;
	private ChoiceResolutuion c;

	public ChoiceResolutionDropDownListenerV2(ChoiceResolutionPanel cp, ChoiceResolutuion c, Map<JComponent, NamedElement> vmMap, BVRViewV2 view) {
		this.cp = cp;
		this.vmMap = vmMap;
		this.view = view;
		this.c = c;
	}

	public void mousePressed(MouseEvent e) {
		if (e.isPopupTrigger())
			doPop(e);
	}

	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger())
			doPop(e);
	}

	private void doPop(MouseEvent e) {
		ChoiceResolutionDropdown menu = new ChoiceResolutionDropdown(cp, c, (BVRViewV2) view, vmMap);
		menu.show(e.getComponent(), e.getX(), e.getY());
	}
}

class ChoiceResolutionDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;

	public ChoiceResolutionDropdown(ChoiceResolutionPanel cp, ChoiceResolutuion c, BVRViewV2 view, Map<JComponent, NamedElement> vmMap) {
		// Add
		if (c.getResolvedVSpec() != null) {
			JMenu add = new JMenu("add");
			for (VSpec x : c.getResolvedVSpec().getChild()) {
				JMenuItem addchild = new JMenuItem(x.getName());
				if (x instanceof Choice) {
					addchild.addActionListener(new AddChoiceResolvedEvent(c, (Choice) x, view));
				} else if (x instanceof VClassifier) {
					addchild.addActionListener(new AddVInstanceEvent(c, (VClassifier) x, view));
				} else if (x instanceof Variable) {
					addchild.addActionListener(new AddVariableValueAssignmentEvent(c, (Variable) x, view));
				} else {
					throw new UnsupportedOperationException("Unsupported: " + x.getClass().getName());
				}
				add.add(addchild);
			}
			if (c.getResolvedVSpec().getChild().size() == 0) {
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
		/*
		 * JMenuItem removechoice = new JMenuItem("remove"); removechoice.addActionListener(new RemoveChoiceEvent(cp, vmMap, nodes, bindings, view));
		 * add(removechoice);
		 
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
		if (c.getResolvedVSpec() == null) {
			vspecs = view.getCU().getOwnedVSpec();
		} else {
			VSpec parent = getParent(view.getCU(), c.getResolvedVSpec());
			if (parent == null)
				vspecs = view.getCU().getOwnedVSpec();
			else
				vspecs = getParent(view.getCU(), c.getResolvedVSpec()).getChild();
		}
		// -Add menus
		JMenu change = new JMenu("Resolve");
		for (VSpec x : vspecs) {
			if (x instanceof Choice) {
				JMenuItem i = new JMenuItem(x.getName());
				i.addActionListener(new ChangeVSpecResolvedEvent(c, (Choice) x, view));
				change.add(i);
			} else {
				// Can only change to another of the same type
			}
		}
		add(change);
		// -delete menus
		JMenuItem remove = new JMenuItem("Remove");
		remove.addActionListener(new RemoveVSpecResolutionEvent(cp, vmMap, view));
		add(remove);
		//Resolve subtree
		JMenuItem resTree = new JMenuItem("resolve subtree");
		resTree.addActionListener(new AddSubTreeEvent(c, view));
		add(resTree);

		// max/min
		JMenuItem minimize = new JMenuItem("minimize");
		minimize.addActionListener(new MinimizeEvent(cp, vmMap, null, null, view));
		add(minimize);
		JMenuItem maximize = new JMenuItem("maximize");
		maximize.addActionListener(new MaximizeEvent(cp, vmMap, null, null, view));
		add(maximize);

		// strip
		JMenuItem strip = new JMenuItem("strip");
		strip.addActionListener(new StrippedEvent(cp, vmMap, view, c.getResolvedVSpec()));
		add(strip);
		JMenuItem unstrip = new JMenuItem("unstrip");
		unstrip.addActionListener(new UnstrippedEvent(cp, vmMap, view, c.getResolvedVSpec()));
		add(unstrip);
		
		JMenuItem validate = new JMenuItem("Validate");
		validate.addActionListener(new ValidateEvent((BVRViewV2) view, c));
		add(validate);
		

		
		
		
	}

	private VSpec getParent(ConfigurableUnit cu, VSpec child) {
		for (VSpec c : cu.getOwnedVSpec())
			if (c == child)
				return null;
		for (VSpec r : cu.getOwnedVSpec()) {
			VSpec found = getParent(r, child);
			if (found != null)
				return found;
		}
		return null;
	}

	private VSpec getParent(VSpec root, VSpec child) {
		for (VSpec r : root.getChild())
			if (r == child)
				return root;
		for (VSpec r : root.getChild()) {
			VSpec found = getParent(r, child);
			if (found != null)
				return found;
		}
		return null;
	}*/
	
}