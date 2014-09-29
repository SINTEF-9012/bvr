package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Validate;
import bvr.Constraint;
import bvr.VSpecResolution;

public class ValidateEvent implements ActionListener{
	BVRResolutionToolView view;
	VSpecResolution vsr;
	Validate valid;
	Component frame;
	public ValidateEvent(BVRResolutionToolView view,VSpecResolution vsr ){
	this.view = view;
	this.vsr = vsr;
	valid = new Validator();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		String message = "";
		valid.validate(view, vsr);
		List<Constraint> invalid = valid.getInvalidConstraints();
		for(Constraint c : invalid){
			if(!view.getInvalidConstraints().contains(c)){
				view.getInvalidConstraints().add(c);
			}
		}
		if(invalid == null || invalid.size()==0){
			message = "no invalid constraints found";
		}
		else{
			message = valid.getMessage();
			view.setShowConstraints(true);
		}
		JOptionPane.showMessageDialog(
				Context.eINSTANCE.getActiveJApplet(), message);
		view.refresh();
		*/
	}

}
