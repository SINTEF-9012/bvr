package no.sintef.cvl.ui.commands;

import javax.swing.JComponent;

import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.command.Command;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;
import no.sintef.cvl.ui.framework.elements.ConstraintPanel;
import cvl.OpaqueConstraint;

public class AddOpaqueConstraint implements Command {

	ConfigurableUnitPanel rootPanel;
	OpaqueConstraint oc;
	JComponent parent;
	
	public Command init(ConfigurableUnitPanel rootPanel, Object p, JComponent parent) {
		if(p instanceof OpaqueConstraint){
			this.rootPanel = rootPanel;
			this.oc = (OpaqueConstraint) p;
			this.parent = parent;
		}		
		return this;
	}

	public JComponent execute() {
		ConstraintPanel constraint1 = new ConstraintPanel(rootPanel);
		constraint1.setTitle("--------------");
		constraint1.setConstraint(oc.getConstraint());
		rootPanel.addNode(constraint1);

		Helper.bind(parent, constraint1, rootPanel, OPTION_STATE.MANDATORY);
		
		return constraint1;
	}

}
