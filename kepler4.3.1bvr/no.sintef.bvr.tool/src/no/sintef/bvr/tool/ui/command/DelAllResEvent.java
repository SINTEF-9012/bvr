package no.sintef.bvr.tool.ui.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bvr.BVRModel;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRToolView;


public class DelAllResEvent implements ActionListener {
	private BVRModel model;
	private BVRToolView bvrView;

	public DelAllResEvent(BVRModel model, BVRToolView bvrView) {
		this.model = model;
		this.bvrView = bvrView;
	}

	public void actionPerformed(ActionEvent e) {
		//Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolutions(cu);
	}

}
