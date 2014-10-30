package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.controller.BVRResolutionToolView;

public class ToggleShowGroupEvent implements ActionListener {

	private BVRResolutionToolView view;

	public ToggleShowGroupEvent(BVRResolutionToolView view) {

		this.view = view;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		view.setGrouping(!view.showGrouping());
		view.refresh();
	}
}
