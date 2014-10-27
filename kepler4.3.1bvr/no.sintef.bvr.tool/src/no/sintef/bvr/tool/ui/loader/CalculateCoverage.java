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
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.ict.splcatool.CALib;
import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.GUIDSL;

public class CalculateCoverage implements ActionListener {
	private int t;
	private BVRToolModel m;

	public CalculateCoverage(BVRToolModel m, BVRNotifiableController bvrView, int t) {
		this.m = m;
		this.t = t;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Job job = new Job("Calculating Coverage Array") {	
			 @Override
			 protected IStatus run(IProgressMonitor monitor) {
				Integer cov = null;
				try {
					// Get FM:
					GUIDSL gdsl = m.getBVRM().getGUIDSL();
					CNF cnf = gdsl.getSXFM().getCNF();
						// Get Covering Array
					CoveringArray ca = m.getBVRM().getCoveringArray();
						
					// Calculate
					cov = (int) Math.round(CALib.calc_coverage(cnf, t, ca));
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
