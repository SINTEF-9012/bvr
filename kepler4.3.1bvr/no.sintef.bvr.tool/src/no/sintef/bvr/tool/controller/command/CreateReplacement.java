package no.sintef.bvr.tool.controller.command;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.RethrownException;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.strategy.impl.CreateBoundaryContext;
import no.sintef.bvr.tool.strategy.impl.GetSelectionContext;
import bvr.BVRModel;
import bvr.ReplacementFragmentType;

public class CreateReplacement implements SimpleExeCommandInterface {

	private boolean withContainment;
	private BVRModel model;
	private ReplacementFragmentType replacement;

	public CreateReplacement(boolean _isContainmentMode, BVRModel _model, ReplacementFragmentType _replacement){
		withContainment = _isContainmentMode;
		model = _model;
		replacement = _replacement;		
	}
	
	@Override
	public void execute() {
		Context.eINSTANCE.getConfig().setContainmentSelectionMode(withContainment);
		GetSelectionContext selectionContext = new GetSelectionContext();
		
		try {
			EList<EObject> selectedObjects = selectionContext.getSelectedObjects();
			CreateBoundaryContext createBoundaryContext = new CreateBoundaryContext();
			createBoundaryContext.creatBoundaries(replacement, selectedObjects);
			
			Context.eINSTANCE.getEditorCommands().addOwnedVariationType(model, replacement);
		} catch (Exception e) {
			throw new RethrownException("some failure during replacement creation", e);
		}
	}

}
