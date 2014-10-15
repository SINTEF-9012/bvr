package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.NamedElement;


public class MaximizeVSpecEvent implements ActionListener {

	private Object cp;
	private Map<JComponent, NamedElement> vmMap;
	private BVRNotifiableController controller;

	public MaximizeVSpecEvent(Object cp, Map<JComponent, NamedElement> vmMap,List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController controller) {
		this.cp = cp;
		this.vmMap = vmMap;
		this.controller = controller;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		controller.getVSpecControllerInterface().maximizeNode(cp);
	}

}
