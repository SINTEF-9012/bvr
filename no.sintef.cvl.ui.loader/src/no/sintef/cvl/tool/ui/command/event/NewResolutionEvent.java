package no.sintef.cvl.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;

import cvl.ChoiceResolutuion;
import cvl.CvlFactory;

import no.sintef.cvl.tool.ui.loader.CVLModel;
import no.sintef.cvl.tool.ui.loader.CVLView;

public class NewResolutionEvent implements ActionListener {

	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;

	public NewResolutionEvent(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views) {
		this.filePane = filePane;
		this.models = models;
		this.views = views;
	}

	public void actionPerformed(ActionEvent arg0) {
		int i = filePane.getSelectedIndex();
		CVLModel m = models.get(i);
		CVLView v = views.get(i);
		
		ChoiceResolutuion cr = CvlFactory.eINSTANCE.createChoiceResolutuion();
		m.getCU().getOwnedVSpecResolution().add(cr);
		
		v.notifyResolutionViewUpdate();
	}

}
