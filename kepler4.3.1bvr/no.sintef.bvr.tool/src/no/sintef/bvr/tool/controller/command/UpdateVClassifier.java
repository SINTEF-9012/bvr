package no.sintef.bvr.tool.controller.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import bvr.CompoundNode;
import bvr.NamedElement;
import bvr.VSpec;
import bvr.Variable;


public class UpdateVClassifier extends UpdateVSpec {
	
	protected int lower;
	protected int upper;
	
	Map<Variable, String> varNames = new HashMap<Variable, String>();
	Map<Variable, String> varTypes = new HashMap<Variable, String>();
	private String comment;
		
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller) {
		return super.init(rootPanel, (VSpec) p, parent, vmMap, nodes, bindings, controller);
	}

	@SuppressWarnings("unchecked")
	public JComponent execute() {
		controller.getVSpecControllerInterface().setVClassifierGroupMultiplicityUpperBound(parent, upper);
		controller.getVSpecControllerInterface().setVClassifierGroupMultiplicityLowerBound(parent, lower);
		
		controller.getVSpecControllerInterface().setNodeName(parent, name);
		controller.getVSpecControllerInterface().setNodeComment(parent, comment);
		
		for(Variable v : ((CompoundNode) namedElement).getVariable()){
				String newName = varNames.get(v);
				String newType = varTypes.get(v);
				controller.getVSpecControllerInterface().updateVariable(v, newName, newType);
		}
		
		return parent;
	}

	@Override
	public void setVariable(Variable v, String name, String type) {
		varNames.put(v, name);
		varTypes.put(v, type);
	}

	@Override
	public void setComment(String text) {
		comment = text;
	}
	
	public void setLower(int lower) {
		this.lower = lower;
	}
	
	public void setUpper(int upper) {
		this.upper = upper;
	}

}
