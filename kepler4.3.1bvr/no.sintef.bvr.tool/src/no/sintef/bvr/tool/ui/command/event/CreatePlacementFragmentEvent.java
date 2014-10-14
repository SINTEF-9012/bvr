package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.exception.RethrownException;
import no.sintef.bvr.tool.strategy.impl.CreateBoundaryContext;
import no.sintef.bvr.tool.strategy.impl.GetSelectionContext;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.BvrFactory;
import bvr.PlacementFragment;

public class CreatePlacementFragmentEvent implements ActionListener {

	
	private BVRNotifiableController view;
	private boolean withContainment;
	private Logger logger = Context.eINSTANCE.logger;

	public CreatePlacementFragmentEvent(BVRNotifiableController _view, boolean _withContainment) {
		view = _view;
		withContainment = _withContainment;
	}
	
	static int count = 0;

	@Override
	public void actionPerformed(ActionEvent ev) {
		/*Context.eINSTANCE.getConfig().setContainmentSelectionMode(withContainment);
		ConfigurableUnit cu = view.getCU();
		GetSelectionContext selectionContext = new GetSelectionContext();
		try {
			EList<EObject> selectedObjects = selectionContext.getSelectedObjects();
			if(selectedObjects.size() == 0){
				JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), Messages.DIALOG_PLACEMENT_EMPTY_SELECTION, Messages.DIALOG_TITLE_OPERATION_FAILED, JOptionPane.WARNING_MESSAGE);
				return;
			}
			PlacementFragment placement = BvrFactory.eINSTANCE.createPlacementFragment();
			CreateBoundaryContext createBoundaryContext = new CreateBoundaryContext();
			createBoundaryContext.creatBoundaries(placement, selectedObjects);
			
			placement.setName(Constants.PLACEMENT_DEFAULT_NAME + count++);
			
			Context.eINSTANCE.getEditorCommands().addOwnedVariationPoint(cu, placement);
		} catch (Exception e) {
			logger.error("some failure during placement creation", e);
			throw new RethrownException("some failure during placement creation", e);
		}*/
	}
}