package no.sintef.bvr.tool.ui.command;

import java.util.List;

import javax.swing.JComponent;

import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.Binding;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;

public class Helper {

	public static void bind(JComponent from, JComponent to, BVRModelPanel model, OPTION_STATE edgetype, List<Pair<JComponent, JComponent>> bindings) {
		if(from != null && to != null){
			Binding b = new Binding(edgetype);
			b.setFrom(from);
			b.setTo(to);
			model.addBinding(b);
			
			bindings.add(new Pair<JComponent, JComponent>(from, to));
		}
	}
	
	
}
