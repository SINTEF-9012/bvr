package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.RethrownException;
import no.sintef.bvr.tool.strategy.impl.CreateBoundaryContext;
import no.sintef.bvr.tool.strategy.impl.GetSelectionContext;
import no.sintef.bvr.tool.ui.loader.BVRView;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.ConfigurableUnit;
import bvr.BvrFactory;
import bvr.ReplacementFragmentType;

public class CreateReplacementFragmentEvent implements ActionListener {
	
	//private JTabbedPane filePane;
	static int count = 0;
	private BVRView view;
	private Logger logger = Context.eINSTANCE.logger;

	public CreateReplacementFragmentEvent(BVRView _view) {
		//this.filePane = filePane;
		view = _view;
	}
	

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		ConfigurableUnit cu = view.getCU();
		
		ReplacementFragmentType replacement = BvrFactory.eINSTANCE.createReplacementFragmentType();
		
		GetSelectionContext selectionContext = new GetSelectionContext();
		
		try {
			EList<EObject> selectedObjects = selectionContext.getSelectedObjects();
			CreateBoundaryContext createBoundaryContext = new CreateBoundaryContext();
			createBoundaryContext.creatBoundaries(replacement, selectedObjects);
			
			replacement.setName(Constants.REPLACEMENT_DEFAULT_NAME + count++);
			Context.eINSTANCE.getEditorCommands().addReplacementFrgament(cu, replacement);
			cu.getOwnedVariabletype().add(replacement);
		} catch (Exception e) {
			logger.error("some failure during replacement creation", e);
			throw new RethrownException("some failure during replacement creation", e);
		}
	}
}