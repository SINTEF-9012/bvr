package no.sintef.bvr.tool.controller.command;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.BVRModel;
import bvr.PlacementFragment;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.RethrownException;
import no.sintef.bvr.tool.exception.UserInputError;
import no.sintef.bvr.tool.strategy.impl.CreateBoundaryContext;
import no.sintef.bvr.tool.strategy.impl.GetSelectionContext;

public class CreatePlacement implements SimpleExeCommand {

	private boolean withContainment;
	private BVRModel model;
	private PlacementFragment placement;

	public CreatePlacement(boolean _isContainmentMode, BVRModel _model, PlacementFragment _placement){
		withContainment = _isContainmentMode;
		model = _model;
		placement = _placement;
	}
	
	@Override
	public void execute() {
		Context.eINSTANCE.getConfig().setContainmentSelectionMode(withContainment);
		GetSelectionContext selectionContext = new GetSelectionContext();
		EList<EObject> selectedObjects = selectionContext.getSelectedObjects();
		
		if(selectedObjects.size() == 0)
			throw new UserInputError(Messages.DIALOG_PLACEMENT_EMPTY_SELECTION);

		try {	
			CreateBoundaryContext createBoundaryContext = new CreateBoundaryContext();
			createBoundaryContext.creatBoundaries(placement, selectedObjects);	
			Context.eINSTANCE.getEditorCommands().addRealizationVariationPoint(model, placement);
		} catch (Exception e) {
			throw new RethrownException("some failure during placement creation", e);
		}
	}
}
