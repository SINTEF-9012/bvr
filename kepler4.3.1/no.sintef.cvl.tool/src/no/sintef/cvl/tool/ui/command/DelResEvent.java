package no.sintef.cvl.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.cvl.tool.ui.loader.VSpecView;
import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

public class DelResEvent implements ActionListener {
	private VSpecResolution v;
	private VSpecView cvlView;
	private ConfigurableUnit cu;

	public DelResEvent(ConfigurableUnit cu, VSpecResolution v, VSpecView cvlView) {
		this.cu = cu;
		this.v = v;
		this.cvlView = cvlView;
	}

	public void actionPerformed(ActionEvent arg0) {
		cu.getOwnedVSpecResolution().remove(v);
		cvlView.notifyResolutionViewUpdate();
	}

}
