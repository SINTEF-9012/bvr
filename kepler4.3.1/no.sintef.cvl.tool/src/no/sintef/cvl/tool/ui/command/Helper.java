package no.sintef.cvl.tool.ui.command;

import java.util.List;

import javax.swing.JComponent;

import no.sintef.cvl.tool.ui.loader.Pair;
import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.elements.Binding;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;

public class Helper {

	public static void bind(JComponent from, JComponent to, ConfigurableUnitPanel model, OPTION_STATE edgetype, List<Pair<JComponent, JComponent>> bindings) {
		if(from != null && to != null){
			Binding b = new Binding(edgetype);
			b.setFrom(from);
			b.setTo(to);
			model.addBinding(b);
			
			bindings.add(new Pair<JComponent, JComponent>(from, to));
		}
	}
	
	
}
