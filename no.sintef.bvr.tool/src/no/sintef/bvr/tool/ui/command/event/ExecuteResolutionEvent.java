/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.context.StaticUICommands;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public class ExecuteResolutionEvent implements ActionListener {

	private BVRNotifiableController controller;
	private File destFile;

	public ExecuteResolutionEvent(BVRNotifiableController _controller) {
		controller = _controller;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {

		List<String> bm_files_paths = controller.getResolutionControllerInterface().getBaseModelFiles();

		boolean result = StaticUICommands.showConfirmationDialog(Context.eINSTANCE.getActiveJApplet(), "Is it a correct base model?",
				"Base model consists of the following files:\n " + bm_files_paths
						+ "\nIf the base model is incorrect, select base model files in the Eclipse Navigator View (Window->Show View->Navigator).");

		if (!result)
			return;

		final JFileChooser fc = StaticUICommands.getFileChooser(null, null);

		int status = fc.showSaveDialog(Context.eINSTANCE.getActiveJApplet());
		if (status == JFileChooser.CANCEL_OPTION)
			return;

		destFile = fc.getSelectedFile();
		if (destFile == null) {
			JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), Messages.DIALOG_MSG_NO_FILE_SELECTED);
			return;
		}

		Job job = new Job("Executing Resolutions") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				Status status = new Status(Status.OK, Constants.PLUGIN_ID, "OK!");
				try {
					controller.getResolutionControllerInterface().executeProduct(destFile);
				} catch (Exception error) {
					status = new Status(Status.ERROR, Constants.PLUGIN_ID, "Failed to execute (see log for more details): " + error.getMessage(), error);
				}
				return status;
			}
		};

		job.schedule();
	}
}
