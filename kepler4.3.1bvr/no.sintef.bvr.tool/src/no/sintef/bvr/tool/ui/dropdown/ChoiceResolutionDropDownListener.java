package no.sintef.bvr.tool.ui.dropdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.event.ResolveChoiceVClassifierEvent;
import no.sintef.bvr.tool.ui.command.event.AddSubTreeEvent;
import no.sintef.bvr.tool.ui.command.event.AddValueResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.MaximizeVSpecResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.MinimizeVSpecResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.ShowAddMultipleChoicesFromVSpecDialogAndAddEvent;
import no.sintef.bvr.tool.ui.command.event.ValidateEvent;


import no.sintef.bvr.ui.framework.elements.ChoiceResolutionPanel;

import org.eclipse.emf.ecore.EObject;

import bvr.Choice;
import bvr.ChoiceResolution;
import bvr.CompoundNode;
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
					
					JMenuItem maximize = new JMenuItem(Constants.RESOLUTION_DROPDOWN_MAXIMIZE_ITEM); 
					maximize.addActionListener(new MaximizeVSpecResolutionEvent(cp, controller));
					add(maximize);
					add(new JSeparator());
				}
			}
		}

		JMenuItem remove = new JMenuItem(Constants.RESOLUTION_DROPDOWN_REMOVE_ITEM);
		remove.addActionListener(new RemoveVSpecResolutionEvent(cp, controller));
		add(remove);
		
		add(new JSeparator());
		JMenuItem validate = new JMenuItem(Constants.RESOLUTION_DROPDOWN_VALIDATE_ITEM);
		validate.addActionListener(new ValidateEvent(cp, controller));
		add(validate);
	}
}
