package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.BVRResolutionToolView;
import no.sintef.bvr.tool.ui.loader.BVRResolutionView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.ResolutionRootController;

public class DeleteResolution implements ActionListener {

	private BVRResolutionToolView view;
	
	public DeleteResolution(BVRResolutionToolView _view){
		view = _view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = ((ResolutionRootController) view).getResolutionPane().getSelectedIndex();
		Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolution(view.getBVRModel(), view.getBVRModel().getResolutionModels().get(tab));
	}

}
