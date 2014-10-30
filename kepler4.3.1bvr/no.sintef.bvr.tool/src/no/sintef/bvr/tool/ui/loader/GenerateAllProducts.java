package no.sintef.bvr.tool.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;


public class GenerateAllProducts implements ActionListener {

	private BVRNotifiableController controller;

	public GenerateAllProducts(BVRNotifiableController _controller) {
		this.controller = _controller;
	}

	public void actionPerformed(ActionEvent ae) {
		Job job = new Job("Generating all possible products") {	
			 @Override
			 protected IStatus run(IProgressMonitor monitor) {
				 try {
					SimpleExeCommandInterface command = controller.getResolutionControllerInterface().createGenerateAllProductsCommand();
					command.execute();
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
