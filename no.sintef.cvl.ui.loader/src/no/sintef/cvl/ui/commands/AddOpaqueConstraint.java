package no.sintef.cvl.ui.commands;

import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.ParallelogramTitledPanel;
import no.sintef.cvl.ui.framework.elements.ConstraintPanel;
import no.sintef.cvl.ui.loader.Main;
import cvl.OpaqueConstraint;
import cvl.VSpec;

public class AddOpaqueConstraint implements Command {

	CVLUIKernel rootPanel;
	OpaqueConstraint oc;
	JComponent parent;
	
	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, VSpec> vmMap) {
		if(p instanceof OpaqueConstraint){
			this.rootPanel = rootPanel;
			this.oc = (OpaqueConstraint) p;
			this.parent = parent;
		}		
		return this;
	}

	public JComponent execute() {
		//ConstraintPanel constraint1 = new ConstraintPanel(rootPanel.getModelPanel());
		ParallelogramTitledPanel constraint1 = new ParallelogramTitledPanel();
		Main.nodes.add(constraint1);
		constraint1.setTitle(oc.getConstraint());
		//constraint1.setConstraint(oc.getConstraint());
		rootPanel.getModelPanel().addNode(constraint1);

		Helper.bind(parent, constraint1, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY);
		
		return constraint1;
	}

}
