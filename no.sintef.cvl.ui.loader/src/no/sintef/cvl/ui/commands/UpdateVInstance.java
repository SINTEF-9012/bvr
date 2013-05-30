package no.sintef.cvl.ui.commands;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.editors.CVLUIKernel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Pair;
import cvl.NamedElement;

public class UpdateVInstance extends UpdateVSpec  {

	@Override
	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		return super.init(rootPanel, p, parent, vmMap, nodes, bindings, view);
	}

	@Override
	public JComponent execute() {
		super.execute();
		view.notifyResolutionViewUpdate();
		return null;
	}

}
