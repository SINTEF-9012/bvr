package no.sintef.bvr.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import bvr.BVRModel;
import bvr.VSpecResolution;

public class DelResEvent implements ActionListener {
	private VSpecResolution v;
	private BVRNotifiableController bvrView;
	
	public DelResEvent(BVRModel model, VSpecResolution v, BVRNotifiableController bvrView) {
		this.v = v;
		this.bvrView = bvrView;
	}

	public void actionPerformed(ActionEvent arg0) {
		//Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolutionConfigurableUnit(cu, v);
		//cu.getOwnedVSpecResolution().remove(v);
		//bvrView.notifyResolutionViewUpdate();
	}

}
