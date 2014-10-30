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
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.CoveringArrayComplete;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;

public class GenerateAllProducts implements ActionListener {
	private BVRToolModel m;
	private BVRNotifiableController v;
	
	public GenerateAllProducts(BVRToolModel m, BVRNotifiableController bvrView) {
		this.m = m;
		this.v = bvrView;
	}


	public void actionPerformed(ActionEvent ae) {
		Job job = new Job("Generating all possible products") {	
			 @Override
			 protected IStatus run(IProgressMonitor monitor) {
				 try {
					GUIDSL gdsl = m.getBVRM().getGUIDSL();
					CNF cnf = gdsl.getSXFM().getCNF();
					CoveringArray ca = new CoveringArrayComplete(cnf);
					ca.generate();
					GraphMLFM gfm = gdsl.getGraphMLFMConf(ca);
					//Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolutions(m.getBVRM().getRootBVRModel());
					EList<VSpecResolution> resolutions = m.getBVRM().getChoiceResolutions(gfm);
					//Context.eINSTANCE.getEditorCommands().addOwnedVSpecResolutionsConfigurableUnit(m.getBVRM().getCU(), resolutions);
				 } catch(Exception e){
					 Context.eINSTANCE.logger.error("Generating all possible products failed:", e);
					 Status status = new Status(Status.ERROR, Constants.PLUGIN_ID, "Generating all possible products failed (see log for more details): " + e.getMessage(), e);
					 return status;
				 }
				 return Status.OK_STATUS;
			 }
		};
		job.schedule();
	}
}
