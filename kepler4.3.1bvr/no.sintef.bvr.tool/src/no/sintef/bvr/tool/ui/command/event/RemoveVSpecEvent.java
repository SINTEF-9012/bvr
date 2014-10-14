package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.BVRModel;
import bvr.CompoundNode;
import bvr.Constraint;
import bvr.NamedElement;
import bvr.VNode;


public class RemoveVSpecEvent implements ActionListener {
	private JComponent p;
	private Map<JComponent, NamedElement> vmMap;
	private BVRNotifiableController view;

	public RemoveVSpecEvent(JComponent p, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		NamedElement v = vmMap.get(p);
		
		// Modify model
		VNode parent = null;
		BVRModel cuParent = null;
		if(view.getBVRModel().getVariabilityModel().equals(v)) {
			cuParent = view.getBVRModel();
		
		}else{
			for(NamedElement _c : vmMap.values()){
				if(_c instanceof CompoundNode){
					CompoundNode c = (CompoundNode)_c;
					if(c.getMember().contains(v) || c.getOwnedConstraint().contains(v)){
						parent = c;
						continue;
					}
				}
			}
		}
		
		if(parent != null){
			if(v instanceof Constraint){
				Context.eINSTANCE.getEditorCommands().removeConstraintCompoundNode((CompoundNode) parent, (Constraint) v);
			} else if(v instanceof VNode){
				Context.eINSTANCE.getEditorCommands().removeVNodeCompoundNode((CompoundNode) parent, (VNode) v);
			}else {
				throw new UnsupportedOperationException("can not remove " + v + " with parent " + parent);
			}
		}else if(cuParent != null){
			Context.eINSTANCE.getEditorCommands().removeVariabilityModelBVRModel(cuParent, (CompoundNode) v);
		}else{
			throw new UnexpectedException("can not find parent element to remove " + v);
		}
		

	}
}
