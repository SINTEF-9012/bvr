package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;
import bvr.NamedElement;
import bvr.VSpecResolution;

public class RemoveVSpecResolutionEvent implements ActionListener  {
	private JComponent p;
	private Map<JComponent, NamedElement> vmMap;
	private BVRNotifiableController controller;

	public RemoveVSpecResolutionEvent(JComponent p, BVRNotifiableController controller) {
		this.p = p;
		this.vmMap = vmMap;
		this.controller = controller;
	}
	
	
		public void actionPerformed(ActionEvent arg0) {
			@SuppressWarnings("unchecked")
			SimpleExeCommandInterface command = controller.getResolutionControllerInterface().RemoveVsSpecResoluton(p);
			command.execute();
		}
	
}
