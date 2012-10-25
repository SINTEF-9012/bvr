package no.sintef.cvl.ui.commands;

import javax.swing.JComponent;

import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.command.Command;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;
import no.sintef.cvl.ui.framework.elements.GroupPanel;
import no.sintef.cvl.ui.framework.elements.VClassifierPanel;
import cvl.MultiplicityInterval;
import cvl.VClassifier;

public class AddVClassifier implements Command {
	
	ConfigurableUnitPanel rootPanel;
	VClassifier vc;
	JComponent parent;

	public Command init(ConfigurableUnitPanel rootPanel, Object p, JComponent parent) {
		if(p instanceof VClassifier){
			this.rootPanel = rootPanel;
			this.vc = (VClassifier) p;
			this.parent = parent;
		}		
		return this;
	}
	
	public JComponent execute() {
		VClassifierPanel c1 = new VClassifierPanel(rootPanel);
        MultiplicityInterval m = vc.getInstanceMultiplicity();

        //I would prefer not to mix concerns (here validation. We should assume a valid CVL model as input).
        /*if(m == null){
        	throw new CVLModelException("VClassifier instance must have InstanceMultiplicity");
        }*/
        int l = m.getLower();
        int u = m.getUpper();
        c1.setNameAndCardinality(vc.getName(), "[" + l + "," + ((u==-1)?"*":u) + "]");
        rootPanel.addNode(c1);
        
        Helper.bind(parent, c1, rootPanel, (parent instanceof GroupPanel) ? OPTION_STATE.OPTIONAL : OPTION_STATE.MANDATORY);
        
        return c1;
	}

}
