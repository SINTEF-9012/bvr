package no.sintef.cvl.ui.commands;

import javax.swing.JComponent;

import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.command.Command;
import no.sintef.cvl.ui.framework.command.SelectInstanceCommand;
import no.sintef.cvl.ui.framework.elements.GroupPanel;
import no.sintef.cvl.ui.framework.elements.VClassifierPanel;
import no.sintef.cvl.ui.framework.listener.CommandMouseListener;
import no.sintef.cvl.ui.loader.Main;
import cvl.MultiplicityInterval;
import cvl.VClassifier;

public class AddVClassifier implements Command {
	
	CVLUIKernel rootPanel;
	VClassifier vc;
	JComponent parent;

	CommandMouseListener listener;
	
	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent) {
		if(p instanceof VClassifier){
			this.rootPanel = rootPanel;
			this.vc = (VClassifier) p;
			this.parent = parent;
		}		
		
		return this;
	}
	
	public JComponent execute() {
		VClassifierPanel c1 = new VClassifierPanel(rootPanel.getModelPanel());
		Main.nodes.add(c1);
		
        listener = new CommandMouseListener();
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, c1, parent);
        listener.setLeftClickCommand(command);
        c1.addMouseListener(listener);
		
        MultiplicityInterval m = vc.getInstanceMultiplicity();

        //I would prefer not to mix concerns (here validation. We should assume a valid CVL model as input).
        /*if(m == null){
        	throw new CVLModelException("VClassifier instance must have InstanceMultiplicity");
        }*/
        int l = m.getLower();
        int u = m.getUpper();
        c1.setNameAndCardinality(vc.getName(), "[" + l + "," + ((u==-1)?"*":u) + "]");
        
        rootPanel.getModelPanel().addNode(c1);
        
        Helper.bind(parent, c1, rootPanel.getModelPanel(), (parent instanceof GroupPanel) ? OPTION_STATE.OPTIONAL : OPTION_STATE.MANDATORY);
        
        return c1;
	}

}
