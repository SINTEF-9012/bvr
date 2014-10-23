package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.VSpec;
import bvr.BvrFactory;

public class SetGroupToOrEvent implements ActionListener {
	private JComponent p;
	private BVRNotifiableController controller;

	public SetGroupToOrEvent(JComponent p, BVRNotifiableController controller) {
		this.p = p;
		this.controller = controller;
	}
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		controller.getVSpecControllerInterface().setGroupMultiplicityOr(p);
	}
}
