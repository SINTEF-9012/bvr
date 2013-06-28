package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;

public class CloseModelEvent implements ActionListener {

	private JTabbedPane c;
	private List<CVLModel> models;
	private List<CVLView> views;

	public CloseModelEvent(JTabbedPane c, List<CVLModel> models, List<CVLView> views){
		this.c = c;
		this.models = models;
		this.views = views;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int selected = c.getSelectedIndex();
		
		c.removeTabAt(selected);
		views.remove(selected);
		models.remove(selected);
	}

}
