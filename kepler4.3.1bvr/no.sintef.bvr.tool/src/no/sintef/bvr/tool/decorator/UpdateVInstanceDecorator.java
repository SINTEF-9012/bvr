package no.sintef.bvr.tool.decorator;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import bvr.NamedElement;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.command.Command;
import no.sintef.bvr.tool.controller.command.UpdateVInstance;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;

public abstract class UpdateVInstanceDecorator extends
		UpdateVInstance {

	protected UpdateVInstance wrapped;

	public UpdateVInstanceDecorator(UpdateVInstance _wrapped) {
		wrapped = _wrapped;
	}
	
	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings,
			BVRNotifiableController controller) {
		super.init(rootPanel, p, parent, vmMap, nodes, bindings, controller);
		return wrapped.init(rootPanel, p, parent, vmMap, nodes, bindings, controller);
	}
	
	@Override
	public JComponent execute() {
		return wrapped.execute();
	}
	
	@Override
	public void setName(String name) {
		wrapped.setName(name);
	}
}
