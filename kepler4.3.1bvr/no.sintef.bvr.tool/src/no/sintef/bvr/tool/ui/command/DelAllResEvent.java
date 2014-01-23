package no.sintef.bvr.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.ui.loader.CVLView;
import bvr.ConfigurableUnit;
import bvr.VSpecResolution;

public class DelAllResEvent implements ActionListener {
	private ConfigurableUnit cu;
	private CVLView bvrView;

	public DelAllResEvent(ConfigurableUnit cu, CVLView bvrView) {
		this.cu = cu;
		this.bvrView = bvrView;
	}

	public void actionPerformed(ActionEvent e) {
		cu.getOwnedVSpecResolution().clear();
		bvrView.notifyResolutionViewUpdate();
	}

}
