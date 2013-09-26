package no.sintef.cvl.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.tool.ui.editor.CVLUIKernel;
import no.sintef.cvl.tool.ui.loader.CVLView;
import no.sintef.cvl.tool.ui.loader.Main;
import no.sintef.cvl.tool.ui.loader.Pair;
import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.ParallelogramTitledPanel;
import no.sintef.cvl.ui.framework.elements.ConstraintPanel;
import cvl.NamedElement;
import cvl.OpaqueConstraint;
import cvl.VSpec;

public class AddOpaqueConstraint implements Command {

	CVLUIKernel rootPanel;
	OpaqueConstraint oc;
	JComponent parent;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	
	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		this.rootPanel = rootPanel;
		this.oc = (OpaqueConstraint) p;
		this.parent = parent;	
		
		this.nodes = nodes;
		this.bindings = bindings;
		
		return this;
	}

	public JComponent execute() {
		//ConstraintPanel constraint1 = new ConstraintPanel(rootPanel.getModelPanel());
		ParallelogramTitledPanel constraint1 = new ParallelogramTitledPanel();
		nodes.add(constraint1);
		constraint1.setTitle("OpaqueConstraint(\""+ oc.getConstraintLanguage() + "\", \"" + oc.getConstraint() + "\")");
		//constraint1.setConstraint(oc.getConstraint());
		rootPanel.getModelPanel().addNode(constraint1);

		Helper.bind(parent, constraint1, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
		
		return constraint1;
	}

}
