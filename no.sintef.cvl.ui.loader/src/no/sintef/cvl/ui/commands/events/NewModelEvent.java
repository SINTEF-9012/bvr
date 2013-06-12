package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;

public class NewModelEvent implements ActionListener {
	private List<CVLModel> models;
	private List<CVLView> views;
	private JTabbedPane c;

	public NewModelEvent(List<CVLModel> models, List<CVLView> views, JTabbedPane c) {
		this.models = models;
		this.views = views;
		this.c = c;
	}

	public void actionPerformed(ActionEvent arg0) {
		CVLModel m = new CVLModel();
		models.add(m);
		views.add(new CVLView(m, c));
	}
}
