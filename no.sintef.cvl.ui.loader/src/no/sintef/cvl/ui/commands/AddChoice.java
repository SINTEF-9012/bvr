package no.sintef.cvl.ui.commands;

import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.commands.events.AddChoiceEvent;
import no.sintef.cvl.ui.commands.events.RemoveChoiceEvent;
import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.command.Command;
import no.sintef.cvl.ui.framework.command.SelectInstanceCommand;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.framework.elements.GroupPanel;
import no.sintef.cvl.ui.framework.listener.CommandMouseListener;
import no.sintef.cvl.ui.loader.Main;
import cvl.Choice;
import cvl.VSpec;

public class AddChoice implements Command {

	CVLUIKernel rootPanel;
	Choice c;
	JComponent parent;
	
	CommandMouseListener listener;
	
	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, VSpec> vmMap) {
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
		
        listener = new CommandMouseListener();
        cp.addMouseListener(new ChoiceDropDownListener(cp));
        cp.addMouseListener(listener);
		
        cp.setTitle(c.getName());
        rootPanel.getModelPanel().addNode(cp);
        Helper.bind(parent, cp, rootPanel.getModelPanel(), (c.isIsImpliedByParent() || parent instanceof GroupPanel) ? OPTION_STATE.OPTIONAL : OPTION_STATE.MANDATORY);
        return cp;
	}

}
