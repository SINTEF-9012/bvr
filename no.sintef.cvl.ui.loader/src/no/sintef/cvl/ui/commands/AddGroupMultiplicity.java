package no.sintef.cvl.ui.commands;

import javax.swing.JComponent;

import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.command.Command;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;
import no.sintef.cvl.ui.framework.elements.GroupPanel;
import cvl.MultiplicityInterval;
import cvl.VSpec;

public class AddGroupMultiplicity implements Command {

	ConfigurableUnitPanel rootPanel;
	VSpec v;
	JComponent parent;
	
	public Command init(ConfigurableUnitPanel rootPanel, Object p, JComponent parent) {
		if(p instanceof VSpec){
			this.rootPanel = rootPanel;
			this.v = (VSpec) p;
			this.parent = parent;
		}
		return this;
	}

	public JComponent execute() {
		if(v.getGroupMultiplicity() != null){
			MultiplicityInterval m = v.getGroupMultiplicity();
			GroupPanel group = new GroupPanel();
			int l = m.getLower();
			int u = m.getUpper();
			group.setCardinality(l, u);
			rootPanel.addNode(group);

			Helper.bind(parent, group, rootPanel, OPTION_STATE.MANDATORY);
			
			return group;
		}
		return null;
	}

}
