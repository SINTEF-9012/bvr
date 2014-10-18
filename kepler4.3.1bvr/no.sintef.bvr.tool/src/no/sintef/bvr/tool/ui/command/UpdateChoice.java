package no.sintef.bvr.tool.ui.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.CompoundNode;
import bvr.NamedElement;
import bvr.Variable;

public class UpdateChoice extends UpdateVSpec {
	
	Map<Variable, String> varNames = new HashMap<Variable, String>();
	Map<Variable, String> varTypes = new HashMap<Variable, String>();
	String comment = new String();
	

	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller) {
		return super.init(rootPanel, p, parent, vmMap, nodes, bindings, controller);
	}

	@SuppressWarnings("unchecked")
	@Override
	public JComponent execute() {
		controller.getVSpecControllerInterface().setNodeName(parent, name);
		controller.getVSpecControllerInterface().setNodeComment(parent, comment);
		
		for(Variable v : ((CompoundNode) vc).getVariable()){
				String newName = varNames.get(v);
				String newType = varTypes.get(v);
				controller.getVSpecControllerInterface().updateVariable(v, newName, newType);
		
		}
		return parent;
	}

	public void setVariable(Variable v, String name, String type) {
		varNames.put(v, name);
		varTypes.put(v, type);
	}
	
	public void setComment(String text) {
		comment = text;
	}
}
