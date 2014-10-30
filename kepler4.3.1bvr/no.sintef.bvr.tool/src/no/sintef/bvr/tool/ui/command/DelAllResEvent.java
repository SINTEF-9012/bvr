package no.sintef.bvr.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bvr.BVRModel;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;


public class DelAllResEvent implements ActionListener {
	private BVRModel model;
	private BVRNotifiableController bvrView;

	public DelAllResEvent(BVRModel model, BVRNotifiableController bvrView) {
		this.model = model;
		this.bvrView = bvrView;
	}

	public void actionPerformed(ActionEvent e) {
		//Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolutions(cu);
	}

}
