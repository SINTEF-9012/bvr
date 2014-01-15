package no.sintef.cvl.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.cvl.tool.ui.loader.VSpecView;
import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

public class DelAllResEvent implements ActionListener {
	private ConfigurableUnit cu;
	private VSpecView cvlView;

	public DelAllResEvent(ConfigurableUnit cu, VSpecView cvlView) {
		this.cu = cu;
		this.cvlView = cvlView;
	}

	public void actionPerformed(ActionEvent e) {
		cu.getOwnedVSpecResolution().clear();
		cvlView.notifyResolutionViewUpdate();
	}

}
