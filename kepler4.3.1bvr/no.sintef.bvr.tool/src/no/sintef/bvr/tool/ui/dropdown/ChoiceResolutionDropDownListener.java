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
import no.sintef.bvr.tool.ui.command.event.ResolveChoiceVClassifierEvent;
import no.sintef.bvr.tool.ui.command.event.AddChoiceFromVClassifierEvent;
import no.sintef.bvr.tool.ui.command.event.AddSubTreeEvent;
import no.sintef.bvr.tool.ui.command.event.AddValueResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.MaximizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.MaximizeVSpecResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.MinimizeVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.MinimizeVSpecResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.ShowAddMultipleChoicesFromVSpecDialogAndAddEvent;
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
				JMenu resolve_choice = new JMenu(Constants.RESOLUTION_DROPDOWN_RESOLVE_CHOICE_ITEM);
				JMenu resolve_vclass = new JMenu(Constants.RESOLUTION_DROPDOWN_RESOLVE_VCLASS_ITEM);
				JMenu addMulTree = new JMenu(Constants.RESOLUTION_DROPDOWN_VINST_SUBTREE_ITEM);
				for (VNode x : ((CompoundNode) (c.getResolvedVSpec())).getMember()) {
					JMenuItem addchild = new JMenuItem((((VSpec) x).getName()));
					if(x instanceof Choice) {
						addchild.addActionListener(new ResolveChoiceVClassifierEvent(cp, (EObject)x, controller));
						resolve_choice.add(addchild);
					} else if (x instanceof VClassifier){
						addchild.addActionListener(new ResolveChoiceVClassifierEvent(cp, (EObject)x, controller));
						resolve_vclass.add(addchild);
						
						JMenuItem addChild = new JMenuItem(((VSpec) x).getName());
						addChild.addActionListener(new ShowAddMultipleChoicesFromVSpecDialogAndAddEvent(cp, (VClassifier) x, controller));
						addMulTree.add(addChild);
					}
				}
				JMenu resolve_variable = new JMenu(Constants.RESOLUTION_DROPDOWN_RESOLVE_VAR_ITEM);
				for(Variable var : ((VNode) c.getResolvedVSpec()).getVariable()){
					JMenuItem addchild = new JMenuItem(var.getName());
					addchild.addActionListener(new AddValueResolutionEvent(cp, (Variable) var, controller));
					resolve_variable.add(addchild);
				}
				
				if (resolve_choice.getMenuComponents().length == 0)
					resolve_choice.setEnabled(false);
				if (resolve_variable.getMenuComponents().length == 0)
					resolve_variable.setEnabled(false);
				if (resolve_vclass.getMenuComponents().length == 0)
					resolve_vclass.setEnabled(false);
				if (addMulTree.getMenuComponents().length == 0)
					addMulTree.setEnabled(false);
	
				add(resolve_choice);
				add(resolve_variable);
				add(resolve_vclass);
				add(addMulTree);
				
				if(resolve_choice.isEnabled() || resolve_vclass.isEnabled()){
					JMenuItem resTree = new JMenuItem(Constants.RESOLUTION_DROPDOWN_RESOLVE_SUBTREE_ITEM);
					resTree.addActionListener(new AddSubTreeEvent(cp, controller));
					add(resTree);
				}
				
				if(resolve_choice.isEnabled() || resolve_variable.isEnabled() || resolve_vclass.isEnabled()){
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
