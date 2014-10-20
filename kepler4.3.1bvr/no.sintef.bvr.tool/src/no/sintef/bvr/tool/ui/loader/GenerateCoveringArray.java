package no.sintef.bvr.tool.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;

import bvr.VSpecResolution;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;

public class GenerateCoveringArray implements ActionListener {
	private int t;
	private BVRToolModel m;
	
	public GenerateCoveringArray(BVRToolModel m, BVRNotifiableController bvrView, int t) {
		this.m = m;
		this.t = t;
	}

	public void actionPerformed(ActionEvent ae) {
		
		Job job = new Job("Generating Coverege Array") {	
			 @Override
			 protected IStatus run(IProgressMonitor monitor) {
				 try {
					 GUIDSL gdsl = m.getBVRM().getGUIDSL();
					 CNF cnf = gdsl.getSXFM().getCNF();
					 CoveringArray ca = cnf.getCoveringArrayGenerator("J11", t, 1);
					 /*if(m.getBVRM().getCU().getOwnedVSpecResolution().size() > 0){
						 CoveringArray startFrom = m.getBVRM().getCoveringArray();
						 ca.startFrom(startFrom);
					 }*/
					 ca.generate();
					 GraphMLFM gfm = gdsl.getGraphMLFMConf(ca);
					 //Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolutions(m.getBVRM().getCU());
					 EList<VSpecResolution> resolutions = m.getBVRM().getChoiceResolutions(gfm);
					// Context.eINSTANCE.getEditorCommands().addOwnedVSpecResolutionsConfigurableUnit(m.getBVRM().getCU(), resolutions);
				 } catch (Exception e) {
					 Context.eINSTANCE.logger.error("Generating covering array failed:", e);
					 Status status = new Status(Status.ERROR, Constants.PLUGIN_ID, "Generating covering array failed (see log for more details): " + e.getMessage(), e);
					 return status;
				 }
				 return Status.OK_STATUS;
			 }
		};
		job.schedule(); 
	}
}
