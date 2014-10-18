package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.NamedElement;
import bvr.Variable;

public class UpdateVInstance extends UpdateVSpec  {

	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		return super.init(rootPanel, p, parent, vmMap, nodes, bindings, view);
	}

	@Override
	public JComponent execute() {
		//super.execute();
		return null;
	}

	@Override
	public void setVar(Variable v, String name, String type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setComment(String text) {
		// TODO Auto-generated method stub
		
	}

}
