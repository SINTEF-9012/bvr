package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.loader.BVRResolutionView;

public class DeleteResolution implements ActionListener {

	private BVRNotifiableController view;
	
	public DeleteResolution(BVRNotifiableController _view){
		view = _view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = ((BVRResolutionView) view).getResolutionPane().getSelectedIndex();
		//Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolutionConfigurableUnit(view.getCU(), view.getCU().getOwnedVSpecResolution().get(tab));
	}

}
