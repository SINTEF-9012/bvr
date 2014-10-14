package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.VSpecControllerInterface;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.BVRModel;
import bvr.Choice;
import bvr.CompoundNode;
import bvr.NamedElement;
import bvr.VSpec;
import bvr.BvrFactory;


public class AddChoiceEvent implements ActionListener {
	private JComponent p;
	private Map<JComponent, NamedElement> vmMap;
	private BVRNotifiableController view;

	public AddChoiceEvent(JComponent p, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	static int x = 1;

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		@SuppressWarnings("rawtypes")
		VSpecControllerInterface controller = view.getVSpecControllerInterface();
		controller.addChoice(p);
	}
}
