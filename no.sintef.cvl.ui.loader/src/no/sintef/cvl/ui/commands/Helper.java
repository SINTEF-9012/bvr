package no.sintef.cvl.ui.commands;

import javax.swing.JComponent;

import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.elements.Binding;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;

public class Helper {

	public static void bind(JComponent from, JComponent to, ConfigurableUnitPanel model, OPTION_STATE edgetype) {
		if(from != null && to != null){
			/*OPTION_STATE edgetype = OPTION_STATE.MANDATORY;
			if(from instanceof GroupPanel){
				edgetype = OPTION_STATE.OPTIONAL;
			}*/
			Binding b = new Binding(edgetype);
			b.setFrom(from);
			b.setTo(to);
			model.addBinding(b);
		}
	}
	
	
}
