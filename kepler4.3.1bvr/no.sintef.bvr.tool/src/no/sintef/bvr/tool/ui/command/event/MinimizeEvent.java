package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.NamedElement;


public class MinimizeEvent implements ActionListener {

	private Object cp;
	private Map<JComponent, NamedElement> vmMap;
	private BVRNotifiableController view;

	public MinimizeEvent(Object cp, Map<JComponent, NamedElement> vmMap,List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		this.cp = cp;
		this.vmMap = vmMap;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object v = vmMap.get(cp);
		
		// Modify model
		view.setMinimized(v);
		
		// Regenerate view
		//view.notifyVspecViewUpdate();
		//view.notifyResolutionViewUpdate();
	}

}
