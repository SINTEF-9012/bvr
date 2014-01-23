package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.strategy.impl.CreateBoundaryContext;
import no.sintef.bvr.tool.strategy.impl.GetSelectionContext;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.bvr.tool.ui.loader.CVLModel;
import no.sintef.bvr.tool.ui.loader.CVLView;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.ConfigurableUnit;
import bvr.BvrFactory;
import bvr.PlacementFragment;

public class CreatePlacementFragmentEvent implements ActionListener {

	private JTabbedPane filePane;
	private Logger logger = Context.eINSTANCE.logger;

	public CreatePlacementFragmentEvent(JTabbedPane filePane) {
		this.filePane = filePane;

	}
	
	static int count = 0;

	@Override
	public void actionPerformed(ActionEvent ev) {
		int tab = filePane.getSelectedIndex();
		List<CVLModel> models = Context.eINSTANCE.getBvrModels();
		List<CVLView> views = Context.eINSTANCE.getBvrViews();
		
		CVLModel m = models.get(tab);
		ConfigurableUnit cu = m.getCU();
		
		PlacementFragment placement = BvrFactory.eINSTANCE.createPlacementFragment();
		
		GetSelectionContext selectionContext = new GetSelectionContext();
		try {
			EList<EObject> selectedObjects = selectionContext.getSelectedObjects();
			CreateBoundaryContext createBoundaryContext = new CreateBoundaryContext();
			createBoundaryContext.creatBoundaries(placement, selectedObjects);
			
			placement.setName(Constants.PLACEMENT_DEFAULT_NAME + count++);
			cu.getOwnedVariationPoint().add(placement);
		} catch (Exception e) {
			logger.error("some failure during placement creation", e);
			StaticUICommands.showMessageErrorDialog(filePane, e, "some failure during placement creation");
		}
		
		//views.get(tab).notifyRelalizationViewUpdate();
		views.get(tab).getConfigurableUnitSubject().notifyObserver();
	}
}