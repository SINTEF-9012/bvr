package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.cvl.common.logging.Logger;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.common.Messages;
import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.strategy.impl.CreateBoundaryContext;
import no.sintef.cvl.ui.strategy.impl.GetSelectionContext;

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
		List<CVLView> views = Context.eINSTANCE.getCvlViews();
		
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
			String stackTrace = Utility.getStackTraceAsString(e);
			logger.error(stackTrace);
			JOptionPane.showMessageDialog(filePane, Messages.DIALOG_MSG_GENERAL_ERROR + e.getMessage());
		}
		
		//views.get(tab).notifyRelalizationViewUpdate();
		views.get(tab).getConfigurableUnitSubject().notifyObserver();
	}
}