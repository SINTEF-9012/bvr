package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRViewV2;

public class ToggleShowGroupEvent implements ActionListener {

	private BVRViewV2 view;

	public ToggleShowGroupEvent(BVRViewV2 view) {

		this.view = view;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		view.setGrouping(!view.showGrouping());
		view.refresh();
	}
}
