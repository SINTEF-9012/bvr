package no.sintef.cvl.ui.commands;

import javax.swing.JComponent;

import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.command.Command;
import no.sintef.cvl.ui.framework.elements.ConstraintPanel;
import no.sintef.cvl.ui.loader.Main;
import cvl.OpaqueConstraint;

public class AddOpaqueConstraint implements Command {

	CVLUIKernel rootPanel;
	OpaqueConstraint oc;
	JComponent parent;
	
	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent) {
		if(p instanceof OpaqueConstraint){
			this.rootPanel = rootPanel;
			this.oc = (OpaqueConstraint) p;
			this.parent = parent;
		}		
		return this;
	}

	public JComponent execute() {
		ConstraintPanel constraint1 = new ConstraintPanel(rootPanel.getModelPanel());
		Main.nodes.add(constraint1);
		constraint1.setTitle("--------------");
		constraint1.setConstraint(oc.getConstraint());
		rootPanel.getModelPanel().addNode(constraint1);

		Helper.bind(parent, constraint1, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY);
		
		return constraint1;
	}

}
