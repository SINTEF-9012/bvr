package no.sintef.cvl.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.cvl.ui.loader.CVLView;
import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

public class DelAllResEvent implements ActionListener {
	private ConfigurableUnit cu;
	private CVLView cvlView;

	public DelAllResEvent(ConfigurableUnit cu, CVLView cvlView) {
		this.cu = cu;
		this.cvlView = cvlView;
	}

	public void actionPerformed(ActionEvent e) {
		cu.getOwnedVSpecResolution().clear();
		cvlView.notifyResolutionViewUpdate();
	}

}
