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
import no.sintef.bvr.tool.ui.context.StaticUICommands;


public class CalculateCost implements ActionListener {
	private BVRNotifiableController controller;

	public CalculateCost(BVRNotifiableController _controller) {
		this.controller = _controller;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Job job = new Job("Calculating Costs...") {
			 @Override
			 protected IStatus run(IProgressMonitor monitor) {
				 try {
					 String result = controller.getResolutionControllerInterface().calculateCosts();
					 Context.eINSTANCE.logger.info(result);
					 StaticUICommands.showMessageInformationDialog(Context.eINSTANCE.getActiveJApplet(), result);
				 } catch (Exception e) {
					 Context.eINSTANCE.logger.error("Calculating Costs failed:", e);
					 Status status = new Status(Status.ERROR, Constants.PLUGIN_ID, "Calculating Costs failed (see log for more details): " + e.getMessage(), e);
					 return status;
				 }
				 return Status.OK_STATUS;
			 }
		};
		job.schedule();
	}
}
