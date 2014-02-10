package no.sintef.bvr.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.ConfigurableUnit;
import bvr.VSpecResolution;

public class DelAllResEvent implements ActionListener {
	private ConfigurableUnit cu;
	private BVRView bvrView;

	public DelAllResEvent(ConfigurableUnit cu, BVRView bvrView) {
		this.cu = cu;
		this.bvrView = bvrView;
	}

	public void actionPerformed(ActionEvent e) {
		cu.getOwnedVSpecResolution().clear();
		bvrView.notifyResolutionViewUpdate();
	}

}
