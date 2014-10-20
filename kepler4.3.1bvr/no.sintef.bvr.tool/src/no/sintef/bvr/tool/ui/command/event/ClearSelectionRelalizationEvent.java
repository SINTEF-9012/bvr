package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.primitive.impl.ObserverDataBulk;
import no.sintef.bvr.tool.ui.loader.BVRRealizationView;

public class ClearSelectionRelalizationEvent implements ActionListener {

	
	private BVRNotifiableController view;
	
	public ClearSelectionRelalizationEvent(BVRNotifiableController _view){
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
