package no.sintef.cvl.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.cvl.common.logging.Logger;
import no.sintef.cvl.tool.common.Constants;
import no.sintef.cvl.tool.common.Messages;
import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.strategy.impl.CreateBoundaryContext;
import no.sintef.cvl.tool.strategy.impl.GetSelectionContext;
import no.sintef.cvl.tool.ui.context.StaticUICommands;
import no.sintef.cvl.tool.ui.loader.CVLModel;
import no.sintef.cvl.tool.ui.loader.VSpecView;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import cvl.ConfigurableUnit;
import cvl.CvlFactory;
import cvl.PlacementFragment;

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
		List<CVLModel> models = Context.eINSTANCE.getCvlModels();
		List<VSpecView> views = Context.eINSTANCE.getCvlViews();
		
		CVLModel m = models.get(tab);
		ConfigurableUnit cu = m.getCU();
		
		PlacementFragment placement = CvlFactory.eINSTANCE.createPlacementFragment();
		
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