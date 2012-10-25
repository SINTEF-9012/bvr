package no.sintef.cvl.ui.commands;

import javax.swing.JComponent;

import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.command.Command;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;
import no.sintef.cvl.ui.framework.elements.GroupPanel;
import cvl.Choice;

public class AddChoice implements Command {

	ConfigurableUnitPanel rootPanel;
	Choice c;
	JComponent parent;
	
	public Command init(ConfigurableUnitPanel rootPanel, Object p, JComponent parent) {
		if(p instanceof Choice){
			this.rootPanel = rootPanel;
			this.c = (Choice) p;
			this.parent = parent;
		}	
		return this;
	}
	
	public JComponent execute() {
		ChoicePanel cp = new ChoicePanel();
        cp.setTitle(c.getName());
        rootPanel.addNode(cp);
        Helper.bind(parent, cp, rootPanel, (c.isIsImpliedByParent() || parent instanceof GroupPanel) ? OPTION_STATE.OPTIONAL : OPTION_STATE.MANDATORY);
        return cp;
	}

}
