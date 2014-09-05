package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRToolView;
import no.sintef.bvr.tool.ui.loader.Main;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.VSpec;
import bvr.BvrFactory;

public class SetGroupToOrEvent implements ActionListener {
	private JComponent p;
	private Map<JComponent, NamedElement> vmMap;
	private BVRToolView view;

	public SetGroupToOrEvent(JComponent p, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRToolView view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		VSpec v = (VSpec)vmMap.get(p);
		
		// Modify model
		MultiplicityInterval mi = BvrFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(1);
		mi.setUpper(-1);
		//v.setGroupMultiplicity(mi);
		Context.eINSTANCE.getEditorCommands().setVSpecGroupMultiplicity(v, mi);
		
		// Regenerate view
		//view.notifyVspecViewUpdate();
	}
}
