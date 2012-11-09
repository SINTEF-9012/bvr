package no.sintef.cvl.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;

public class OpenModelEvent implements ActionListener {
	
	private JTabbedPane c;
	private List<CVLModel> models;
	private List<CVLView> views;

	OpenModelEvent(JTabbedPane c, List<CVLModel> models, List<CVLView> views){
		this.c = c;
		this.models = models;
		this.views = views;
	}

	public void actionPerformed(ActionEvent arg0) {
		final JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(c);
		CVLModel m = new CVLModel(fc.getSelectedFile());
		models.add(m);
		views.add(new CVLView(m, c));
	}

}
