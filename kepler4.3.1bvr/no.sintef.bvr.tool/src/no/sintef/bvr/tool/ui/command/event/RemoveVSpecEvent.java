package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRToolView;
import no.sintef.bvr.tool.ui.loader.Main;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.BCLConstraint;
import bvr.Constraint;
import bvr.NamedElement;
import bvr.VSpec;

public class RemoveVSpecEvent implements ActionListener {
	private JComponent p;
	private Map<JComponent, NamedElement> vmMap;
	private BVRToolView view;

	public RemoveVSpecEvent(JComponent p, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRToolView view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		/*NamedElement v = vmMap.get(p);
		
		// Modify model
		VSpec parent = null;
		ConfigurableUnit cuParent = null;
		for(NamedElement _c : vmMap.values()){
			if(_c instanceof VSpec){
				VSpec c = (VSpec)_c;
				if(c.getChild().contains(v))
					parent = c;
			}else if(_c instanceof BCLConstraint){
				if(view.getCU().getOwnedConstraint().contains(v))
					cuParent = view.getCU();
			}else{
				throw new UnsupportedOperationException();
			}
		}
		if(parent != null){
			Context.eINSTANCE.getEditorCommands().removeNamedElementVSpec(parent, v);
		}else if(cuParent == null){
			ConfigurableUnit cu = view.getCU();
			Context.eINSTANCE.getEditorCommands().removeOwnedVSpecConfigurableUnit(cu, v);
		}else{
			Context.eINSTANCE.getEditorCommands().removeConstraintConfigurableUnit(cuParent, v);
		}
		
		// Remove constraints
		List<Constraint> toremove = new ArrayList<>();
		for(Constraint c : view.getCU().getOwnedConstraint()){
			if(c.getContext() == v){
				//toremove.add(c);
				Context.eINSTANCE.getEditorCommands().removeConstraintConfigurableUnit(cuParent, v);
			}
		}*/

	}
}
