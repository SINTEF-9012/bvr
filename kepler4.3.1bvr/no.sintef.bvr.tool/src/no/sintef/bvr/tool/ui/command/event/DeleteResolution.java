package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRResolutionView;
import no.sintef.bvr.tool.ui.loader.BVRView;

public class DeleteResolution implements ActionListener {

	private BVRView view;
	
	public DeleteResolution(BVRView _view){
		view = _view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = ((BVRResolutionView) view).getResolutionPane().getSelectedIndex();
		Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolutionConfigurableUnit(view.getCU(), view.getCU().getOwnedVSpecResolution().get(tab));
	}

}
