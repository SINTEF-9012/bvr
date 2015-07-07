/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;


public class GenerateCoveringArray implements ActionListener {
	private int t;

	private BVRNotifiableController controller;

	public GenerateCoveringArray(BVRNotifiableController _controller, int t) {
		this.t = t;
		controller = _controller;
	}

	public void actionPerformed(ActionEvent ae) {

		Job job = new Job("Generating Coverege Array") {
			 @Override
			 protected IStatus run(IProgressMonitor monitor) {
				 try {
					 SimpleExeCommandInterface command = controller.getResolutionControllerInterface().createGenerateCoveringArrayCommand(t);
					 command.execute();
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
