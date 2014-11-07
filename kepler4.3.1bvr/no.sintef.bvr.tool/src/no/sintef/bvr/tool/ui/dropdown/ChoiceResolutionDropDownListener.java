package no.sintef.bvr.tool.ui.dropdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.ChangeVSpecResolvedEvent;
import no.sintef.bvr.tool.ui.command.SetDecisionEvent;
import no.sintef.bvr.tool.ui.command.event.AddChoiceResolvedEvent;
import no.sintef.bvr.tool.ui.command.event.AddChoiceFromVClassifierEvent;
import no.sintef.bvr.tool.ui.command.event.AddSubTreeEvent;
import no.sintef.bvr.tool.ui.command.event.AddValueResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.MaximizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.MaximizeVSpecResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.MinimizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.MinimizeVSpecResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecResolutionEvent;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.AddSubTreeEvent;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.AddChoicesFromVClassifierTreeEvent;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.ShowAddMultipleChoicesFromVSpecDialogAndAddEvent;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.StrippedEvent;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.UnstrippedEvent;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.ValidateEvent;
import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.BVRModel;
import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.CompoundNode;
//import bvr.ChoiceResolution;
//import bvr.ConfigurableUnit;
import bvr.NamedElement;
import bvr.NegResolution;
import bvr.PosResolution;
import bvr.VClassifier;
import bvr.VNode;
import bvr.VSpec;
import bvr.Variable;

public class ChoiceResolutionDropDownListener extends MouseAdapter {

	private ChoiceResolutionPanel cp;
	private BVRNotifiableController view;
	private ChoiceResolution c;

	public ChoiceResolutionDropDownListener(ChoiceResolutionPanel cp, ChoiceResolution c,
			BVRNotifiableController view) {
		this.cp = cp;
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
		ChoiceResolutionDropdown menu = new ChoiceResolutionDropdown(cp, c, view);
		menu.show(e.getComponent(), e.getX(), e.getY());
	}
}

class ChoiceResolutionDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;

	public ChoiceResolutionDropdown(ChoiceResolutionPanel cp, ChoiceResolution c, BVRNotifiableController controller) {
		// Add
		if(c instanceof PosResolution){
			if (c.getResolvedVSpec() instanceof CompoundNode) {
				JMenu add = new JMenu(Constants.RESOLUTION_DROPDOWN_ADD_ITEM);
				for (VNode x : ((CompoundNode) (c.getResolvedVSpec())).getMember()) {// TODO add Variables
					// TODO ADD NAME
					JMenuItem addchild = new JMenuItem((((VSpec) x).getName()));
					if( (x instanceof Choice) ||  (x instanceof VClassifier)){
						addchild.addActionListener(new AddChoiceResolvedEvent(cp, (EObject)x, controller));
					} else if (x instanceof Variable) {
						addchild.addActionListener(new AddValueResolutionEvent(c, (Variable) x, controller));// TODO namechange
					}
						add.add(addchild);
				}
				if (((CompoundNode) (c.getResolvedVSpec())).getMember().size() == 0) {
					add.setEnabled(false);
				}
				add(add);
			}
			
			// addInstanceTree

			if (c.getResolvedVSpec() instanceof CompoundNode) {
				JMenu addTree = new JMenu(Constants.RESOLUTION_DROPDOWN_VCLASS_SUBTREE_ITEM);
				for (VNode x : ((CompoundNode) (c.getResolvedVSpec())).getMember()) {
					JMenuItem addChild = new JMenuItem(((VSpec) x).getName());
					if (x instanceof VClassifier) {
						//TODO addChild.addActionListener(new AddChoicesFromVClassifierTreeEvent(c, (VClassifier) x, view));
						addTree.add(addChild);
					}
				}
	
				if (addTree.getMenuComponents().length == 0) {
					addTree.setEnabled(false);
				}
				add(addTree);
			}
		
			if (c.getResolvedVSpec() instanceof CompoundNode) {
				JMenu addMulTree = new JMenu(Constants.RESOLUTION_DROPDOWN_VINST_SUBTREE_ITEM);
				for (VNode x : ((CompoundNode) (c.getResolvedVSpec())).getMember()) {
					JMenuItem addChild = new JMenuItem(((VSpec) x).getName());
					if (x instanceof VClassifier) {
						//TODO addChild.addActionListener(new ShowAddMultipleChoicesFromVSpecDialogAndAddEvent((VClassifier) x, c, view));
						addMulTree.add(addChild);
					}
				}
				if (addMulTree.getMenuComponents().length == 0) {
					addMulTree.setEnabled(false);
				}
				add(addMulTree);
			}
			
			if(c.getResolvedVSpec() instanceof CompoundNode && ((CompoundNode) (c.getResolvedVSpec())).getMember().size() > 0){
				// Resolve subtree
				JMenuItem resTree = new JMenuItem(Constants.RESOLUTION_DROPDOWN_RESOLVE_SUBTREE_ITEM);
				resTree.addActionListener(new AddSubTreeEvent(cp, controller));
				add(resTree);
	
				add( new JSeparator());
				JMenuItem minimize = new JMenuItem(Constants.RESOLUTION_DROPDOWN_MININIZE_ITEM); 
				minimize.addActionListener(new MinimizeVSpecResolutionEvent(cp, controller));
				add(minimize);
				
				JMenuItem maximize = new JMenuItem(Constants.RESOLUTION_DROPDOWN_MININIZE_ITEM); 
				maximize.addActionListener(new MaximizeVSpecResolutionEvent(cp, controller));
				add(maximize);
				add(new JSeparator());
			}
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
		JMenuItem remove = new JMenuItem(Constants.RESOLUTION_DROPDOWN_REMOVE_ITEM);
		remove.addActionListener(new RemoveVSpecResolutionEvent(cp, controller));
		add(remove);
		
		/*
		 * // max/min TODO Create new events JMenuItem minimize = new JMenuItem("minimize"); minimize.addActionListener(new MinimizeEvent(cp, vmMap,
		 * null, null, view)); add(minimize); JMenuItem maximize = new JMenuItem("maximize"); maximize.addActionListener(new MaximizeEvent(cp, vmMap,
		 * null, null, view)); add(maximize);
		 * 
		 * // strip JMenuItem strip = new JMenuItem("strip"); strip.addActionListener(new StrippedEvent(cp, vmMap, view, c.getResolvedVSpec()));
		 * add(strip); JMenuItem unstrip = new JMenuItem("unstrip"); unstrip.addActionListener(new UnstrippedEvent(cp, vmMap, view,
		 * c.getResolvedVSpec())); add(unstrip);
		 */
		add(new JSeparator());
		JMenuItem validate = new JMenuItem(Constants.RESOLUTION_DROPDOWN_VALIDATE_ITEM);
		//TODO validate.addActionListener(new ValidateEvent(view, c));
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
