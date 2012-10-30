package no.sintef.cvl.ui.commands;

import javax.swing.JComponent;

import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.command.Command;
import no.sintef.cvl.ui.framework.elements.GroupPanel;
import no.sintef.cvl.ui.loader.Main;
import cvl.MultiplicityInterval;
import cvl.VSpec;

public class AddGroupMultiplicity implements Command {

	CVLUIKernel rootPanel;
	VSpec v;
	JComponent parent;
	
	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent) {
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
			Main.nodes.add(group);
			int l = m.getLower();
			int u = m.getUpper();
			group.setCardinality(l, u);
			rootPanel.getModelPanel().addNode(group);

			Helper.bind(parent, group, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY);
			
			return group;
		}
		return null;
	}

}
