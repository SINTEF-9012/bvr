package no.sintef.cvl.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.cvl.tool.ui.loader.CVLView;
import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

public class DelResEvent implements ActionListener {
	private VSpecResolution v;
	private CVLView cvlView;
	private ConfigurableUnit cu;

	public DelResEvent(ConfigurableUnit cu, VSpecResolution v, CVLView cvlView) {
		this.cu = cu;
		this.v = v;
		this.cvlView = cvlView;
	}

	public void actionPerformed(ActionEvent arg0) {
		cu.getOwnedVSpecResolution().remove(v);
		cvlView.notifyResolutionViewUpdate();
	}

}
