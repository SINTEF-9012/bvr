package no.sintef.cvl.ui.commands;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Pair;

import cvl.NamedElement;
import cvl.VClassifier;
import cvl.VSpec;

public class UpdateVClassifier extends UpdateVSpec {
	
	protected int lower;
	protected int upper;
		
	public void setLower(int lower) {
		this.lower = lower;
	}
	
	public void setUpper(int upper) {
		this.upper = upper;
	}
	
	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		return super.init(rootPanel, (VSpec) p, parent, vmMap, nodes, bindings, view);
	}

	public JComponent execute() {
		super.execute();
		((VClassifier) vc).getInstanceMultiplicity().setLower(lower);
		((VClassifier) vc).getInstanceMultiplicity().setUpper(upper);
		view.notifyVspecViewUpdate();
		return null;
	}

}
