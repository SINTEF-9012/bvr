package no.sintef.bvr.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.ui.loader.CVLView;
import bvr.ConfigurableUnit;
import bvr.VSpecResolution;

public class DelResEvent implements ActionListener {
	private VSpecResolution v;
	private CVLView bvrView;
	private ConfigurableUnit cu;

	public DelResEvent(ConfigurableUnit cu, VSpecResolution v, CVLView bvrView) {
		this.cu = cu;
		this.v = v;
		this.bvrView = bvrView;
	}

	public void actionPerformed(ActionEvent arg0) {
		cu.getOwnedVSpecResolution().remove(v);
		bvrView.notifyResolutionViewUpdate();
	}

}
