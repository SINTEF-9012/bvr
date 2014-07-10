package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRViewV2;

public class ToggleShowConstraintsEvent implements ActionListener {

	private BVRViewV2 view;

	public ToggleShowConstraintsEvent(BVRViewV2 view) {

		this.view = view;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		view.setShowConstraints((!view.isShowConstraints()));
		view.refresh();
	}
}
