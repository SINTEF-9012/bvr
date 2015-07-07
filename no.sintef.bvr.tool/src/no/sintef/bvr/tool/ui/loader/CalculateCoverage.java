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

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.ShowErrorException;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;


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
				} catch (ShowErrorException e) {
					Context.eINSTANCE.logger.error("Calculating coverage failed:", e);
					JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), "Failed with message : " + e.getMessage(), "Error : see error log for more details!", JOptionPane.ERROR_MESSAGE);
					Status status = new Status(Status.CANCEL, Constants.PLUGIN_ID, e.getMessage(), e);
					return status;
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
