package no.sintef.bvr.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.ConfigurableUnit;
import bvr.VSpecResolution;

public class DelResEvent implements ActionListener {
	private VSpecResolution v;
	private BVRView bvrView;
	private ConfigurableUnit cu;

	public DelResEvent(ConfigurableUnit cu, VSpecResolution v, BVRView bvrView) {
		this.cu = cu;
		this.v = v;
		this.bvrView = bvrView;
	}

	public void actionPerformed(ActionEvent arg0) {
		Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolutionConfigurableUnit(cu, v);
		//cu.getOwnedVSpecResolution().remove(v);
		//bvrView.notifyResolutionViewUpdate();
	}

}
