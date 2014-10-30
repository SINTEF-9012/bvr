package no.sintef.bvr.tool.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;


public class CalculateCoverage implements ActionListener {
	private int t;
	private BVRNotifiableController controller;

	public CalculateCoverage(BVRNotifiableController _controller, int t) {
		this.t = t;
		controller = _controller;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Job job = new Job("Calculating Coverage Array") {
			 @Override
			 protected IStatus run(IProgressMonitor monitor) {
				Integer cov = null;
				try {
					cov = controller.getResolutionControllerInterface().calculateCoverage(t);
				} catch (Exception e) {
					Context.eINSTANCE.logger.error("Calculating coverage failed:", e);
					Status status = new Status(Status.ERROR, Constants.PLUGIN_ID, "Calculating coverage failed (see log for more details): " + e.getMessage(), e);
					return status;
				}
				JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), t +"-wise coverage: " + cov + "%");
				return Status.OK_STATUS;
			 }
		};

		job.schedule();
	}

}
