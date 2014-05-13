package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.primitive.impl.ObserverDataBulk;
import no.sintef.bvr.tool.ui.loader.BVRRealizationView;
import no.sintef.bvr.tool.ui.loader.BVRView;

public class ClearSelectionRelalizationEvent implements ActionListener {

	
	private BVRView view;
	
	public ClearSelectionRelalizationEvent(BVRView _view){
		view = _view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ObserverDataBulk data = new ObserverDataBulk();
		data.setDataField("selectedFragmentSubstitution", null);
		Context.eINSTANCE.getViewChangeManager().updateSubjects(data, ((BVRRealizationView) view).getFragmentSubstitutionTable());
		Context.eINSTANCE.clearHighlights();
	}

}
