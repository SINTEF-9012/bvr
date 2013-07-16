package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import cvl.ConfigurableUnit;
import cvl.VSpecResolution;

import no.sintef.cvl.ui.common.DeriveProduct;
import no.sintef.cvl.ui.common.Messages;
import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;


public class ExecuteResolutionEvent implements ActionListener {

	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;

	public ExecuteResolutionEvent(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views) {
		this.filePane = filePane;
		this.models = models;
		this.views = views;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = filePane.getSelectedIndex();
		JTabbedPane x = (JTabbedPane) ((JTabbedPane)filePane.getSelectedComponent()).getSelectedComponent();
		int i = x.getSelectedIndex();
		CVLModel m = models.get(tab);
		ConfigurableUnit cu = m.getCU();
		VSpecResolution vsr = cu.getOwnedVSpecResolution().get(i);
		
		HashMap<String, Object> keywords = new HashMap<String, Object>();
		keywords.put("cu", cu);
		keywords.put("vSpecResolution", vsr);
		keywords.put("parentComponent", x);
		keywords.put("cvlModel", m);
		keywords.put("cvlView", views.get(tab));
		
		try {
			DeriveProduct deriviator = new DeriveProduct(keywords);
			deriviator.run();
		} catch (Exception error) {
			JOptionPane.showMessageDialog(x, Messages.DIALOG_MSG_GENERAL_ERROR + error.getMessage());
			String stackTrace = Utility.getStackTraceAsString(error);
			Context.log.error(stackTrace);
		}
	}
}
