package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import bvr.ConfigurableUnit;
import bvr.VSpecResolution;
import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.tool.common.DeriveProduct;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.tool.ui.loader.BVRResolutionView;
import no.sintef.bvr.tool.ui.loader.BVRView;


public class ExecuteResolutionEvent implements ActionListener {

	private BVRView view;
	private Logger logger = Context.eINSTANCE.logger;

	public ExecuteResolutionEvent(BVRView _view) {
		view =_view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JTabbedPane filePane = ((BVRResolutionView) view).getResolutionPane();
		
		int tab = filePane.getSelectedIndex();
		JTabbedPane x = (JTabbedPane) ((JTabbedPane) filePane.getSelectedComponent()).getSelectedComponent();
		int i = x.getSelectedIndex();
		
		List<BVRModel> models = Context.eINSTANCE.getBvrModels();
		List<BVRView> views = Context.eINSTANCE.getBvrViews();
		
		BVRModel m = models.get(tab);
		
		if(m.getFile() == null){
			JOptionPane.showMessageDialog(filePane, Messages.DIALOG_MSG_SAVE_MODEL);
			return;
		}
		
		//there is an issue,if we add some elements dynamically to a VM model which were not loaded recently
		//then EMF does not add these resources to a ResourceSet of the model which uses them
		//even though all proxies are resolved successfully. Seems like EMF issue.
		//Thus we save model and reload it before an execution.
		Context.eINSTANCE.writeModelToFile(m, m.getFile());
		Context.eINSTANCE.reloadModel(m);
		//views.get(tab).notifyAllViews();
		
		ConfigurableUnit cu = m.getCU();
		VSpecResolution vsr = cu.getOwnedVSpecResolution().get(i);
		
		HashMap<String, Object> keywords = new HashMap<String, Object>();
		keywords.put("cu", cu);
		keywords.put("vSpecResolution", vsr);
		keywords.put("parentComponent", x);
		keywords.put("bvrModel", m);
		keywords.put("bvrView", views.get(tab));
		
		try {
			DeriveProduct deriviator = new DeriveProduct(keywords);
			deriviator.run();
		} catch (Exception error) {
			Context.eINSTANCE.reloadModel(m);
			//views.get(tab).notifyAllViews();
			logger.error("some failure during execution", error);
			StaticUICommands.showMessageErrorDialog(x, error, "some failure during execution");
		}
	}
}
