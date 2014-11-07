package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.DropdownListners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.ui.command.ChangeVSpecResolvedEvent;
import no.sintef.bvr.tool.ui.command.SetDecisionEvent;
import no.sintef.bvr.tool.ui.command.event.ResolveChoiceVClassifierEvent;
import no.sintef.bvr.tool.ui.command.event.AddChoiceFromVClassifierEvent;
import no.sintef.bvr.tool.ui.command.event.AddSubTreeEvent;
import no.sintef.bvr.tool.ui.command.event.AddValueResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.MaximizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.MinimizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecResolutionEvent;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.AddChoicesFromVClassifierTreeEvent;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.ShowAddMultipleChoicesFromVSpecDialogAndAddEvent;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.StrippedEvent;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.UnstrippedEvent;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.ValidateEvent;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;

import org.eclipse.emf.common.util.EList;

import bvr.BVRModel;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.CompoundNode;
//import bvr.ChoiceResolution;
//import bvr.ConfigurableUnit;
import bvr.NamedElement;
import bvr.NegResolution;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VSpec;
import bvr.Variable;

public class ChoiceResolutionDropDownListenerV2 extends MouseAdapter {

	private ChoiceResolutionPanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private BVRResolutionToolView view;
	private ChoiceResolution c;

	public ChoiceResolutionDropDownListenerV2(ChoiceResolutionPanel cp, ChoiceResolution c, Map<JComponent, NamedElement> vmMap,
			BVRResolutionToolView view) {
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
		ChoiceResolutionDropdown menu = new ChoiceResolutionDropdown(cp, c, view, vmMap);
		menu.show(e.getComponent(), e.getX(), e.getY());
	}
}

class ChoiceResolutionDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;

	public ChoiceResolutionDropdown(ChoiceResolutionPanel cp, ChoiceResolution c, BVRResolutionToolView view, Map<JComponent, NamedElement> vmMap) {
		// Add
		if (c.getResolvedVSpec() != null) {
			JMenu add = new JMenu("add");
			if (c instanceof NegResolution) {

			}
			if (c.getResolvedVSpec() instanceof CompoundNode) {
				for (VNode x : ((CompoundNode) (c.getResolvedVSpec())).getMember()) {// TODO add Variables

					// TODO ADD NAME
					JMenuItem addchild = new JMenuItem((((VSpec) x).getName()));
					if (x instanceof Choice) {
						//addchild.addActionListener(new AddChoiceResolvedEvent(c, (Choice) x, view));
					} else if (x instanceof VClassifier) {
						addchild.addActionListener(new AddChoiceFromVClassifierEvent(cp, x, view));
					} else if (x instanceof Variable) {
						//addchild.addActionListener(new AddValueResolutionEvent(c, (Variable) x, view));// TODO namechange
					} else {
						throw new UnsupportedOperationException("Unsupported: " + x.getClass().getName());
					}
					add.add(addchild);
				}
				if (((CompoundNode) (c.getResolvedVSpec())).getMember().size() == 0) {
					add.add(new JMenuItem("No further VSpec"));
				}
			} else {
				System.err.println("the Resolved VSpec is not a VNode");
				add.add(new JMenuItem("the Resolved VSpec is not a VNode"));
			}
			add(add);
		}
		// addInstanceTree
		if (c.getResolvedVSpec() != null) {
			JMenu addTree = new JMenu("add realized VInstance subtree");
			if (c.getResolvedVSpec() instanceof CompoundNode) {
				for (VNode x : ((CompoundNode) (c.getResolvedVSpec())).getMember()) {
					JMenuItem addChild = new JMenuItem(((VSpec) x).getName());
					if (x instanceof VClassifier) {
						//addChild.addActionListener(new AddChoicesFromVClassifierTreeEvent(c, (VClassifier) x, view));
						addTree.add(addChild);
					}
				}

				if (addTree.getMenuComponents().length == 0) {
					addTree.add(new JMenuItem("No VInstances to add"));
				}
			} else {
				System.err.println("the Resolved VSpec is not a VNode, error addVInstanceTree");
				addTree.add(new JMenuItem("the Resolved VSpec is not a VNode"));
			}
			add(addTree);
		}
		if (c.getResolvedVSpec() != null) {

			JMenu addMulTree = new JMenu("add multiple realized VInstance subtrees");
			if (c.getResolvedVSpec() instanceof CompoundNode) {
				for (VNode x : ((CompoundNode) (c.getResolvedVSpec())).getMember()) {
					JMenuItem addChild = new JMenuItem(((VSpec) x).getName());
					if (x instanceof VClassifier) {
						//addChild.addActionListener(new ShowAddMultipleChoicesFromVSpecDialogAndAddEvent((VClassifier) x, c, view));
						addMulTree.add(addChild);
					}
				}
				if (addMulTree.getMenuComponents().length == 0) {
					addMulTree.add(new JMenuItem("No VInstances to add"));
				}
			} else {
				System.err.println("the Resolved VSpec is not a VNode, error addMulTree");
				addMulTree.add(new JMenuItem("the Resolved VSpec is not a VNode"));
			}

			add(addMulTree);
		}

		/*
		 * TODO fix change resolution // Set group JMenu value = new JMenu("Set Resolution"); JMenuItem vtrue = new JMenuItem("true");
		 * vtrue.addActionListener(new SetDecisionEvent(c, view, true)); value.add(vtrue); JMenuItem vfalse = new JMenuItem("false");
		 * vfalse.addActionListener(new SetDecisionEvent(c,view, false)); value.add(vfalse); add(value);
		 */
		// Change to
		/*
		 * EList<VSpec> vspecs = null; if (c.getResolvedVSpec() == null) { vspecs =view.getBVRModel().getVariabilityModel(); } else { VSpec parent =
		 * getParent(view.getBVRModel(), c.getResolvedVSpec()); if (parent == null) vspecs = view.getBVRModel().getVariabilityModel(); else { if ()
		 * vspecs = getParent(view.getBVRModel(), (()c.getResolvedVSpec()).getChild(); } // -Add menus JMenu change = new JMenu("Resolve"); for (VSpec
		 * x : vspecs) { if (x instanceof Choice) { JMenuItem i = new JMenuItem(x.getName()); i.addActionListener(new ChangeVSpecResolvedEvent(c,
		 * (Choice) x, view)); change.add(i); } else { // Can only change to another of the same type } } add(change);
		 */
		// -delete menus
		JMenuItem remove = new JMenuItem("Remove");
		remove.addActionListener(new RemoveVSpecResolutionEvent(cp, view));
		add(remove);
		// Resolve subtree
		JMenuItem resTree = new JMenuItem("resolve subtree");
		//resTree.addActionListener(new AddSubTreeEvent(c, view));
		add(resTree);

		/*
		 * // max/min TODO Create new events JMenuItem minimize = new JMenuItem("minimize"); minimize.addActionListener(new MinimizeEvent(cp, vmMap,
		 * null, null, view)); add(minimize); JMenuItem maximize = new JMenuItem("maximize"); maximize.addActionListener(new MaximizeEvent(cp, vmMap,
		 * null, null, view)); add(maximize);
		 * 
		 * // strip JMenuItem strip = new JMenuItem("strip"); strip.addActionListener(new StrippedEvent(cp, vmMap, view, c.getResolvedVSpec()));
		 * add(strip); JMenuItem unstrip = new JMenuItem("unstrip"); unstrip.addActionListener(new UnstrippedEvent(cp, vmMap, view,
		 * c.getResolvedVSpec())); add(unstrip);
		 */
		JMenuItem validate = new JMenuItem("Validate");
		validate.addActionListener(new ValidateEvent(view, c));
		add(validate);
	}

	private VSpec getParent(BVRModel cu, VSpec child) {
		VSpec c = (VSpec) cu.getVariabilityModel();
		if (c == child)
			return null;
		VSpec found = getParent(c, child);
		if (found != null)
			return found;
		return null;

	}

	private VSpec getParent(VSpec root, VSpec child) {

		if (root instanceof CompoundNode) {
			for (VNode r : ((CompoundNode) root).getMember())
				if ((VSpec) r == child)
					return root;
			for (VNode r : ((CompoundNode) root).getMember()) {
				VSpec found = getParent((VSpec) r, child);
				if (found != null)
					return found;
			}
		}
		return null;
	}

}
