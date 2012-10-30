package no.sintef.cvl.ui.commands;

import javax.swing.JComponent;

import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.command.Command;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.framework.elements.GroupPanel;
import no.sintef.cvl.ui.loader.Main;
import cvl.Choice;

public class AddChoice implements Command {

	CVLUIKernel rootPanel;
	Choice c;
	JComponent parent;
	
	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent) {
		if(p instanceof Choice){
			this.rootPanel = rootPanel;
			this.c = (Choice) p;
			this.parent = parent;
		}	
		return this;
	}
	
	public JComponent execute() {
		ChoicePanel cp = new ChoicePanel();
		Main.nodes.add(cp);
        cp.setTitle(c.getName());
        rootPanel.getModelPanel().addNode(cp);
        Helper.bind(parent, cp, rootPanel.getModelPanel(), (c.isIsImpliedByParent() || parent instanceof GroupPanel) ? OPTION_STATE.OPTIONAL : OPTION_STATE.MANDATORY);
        return cp;
	}

}
