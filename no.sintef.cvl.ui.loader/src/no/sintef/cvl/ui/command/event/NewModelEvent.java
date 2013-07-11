package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;

public class NewModelEvent implements ActionListener {

	private JTabbedPane c;

	public NewModelEvent(JTabbedPane c) {
		this.c = c;
	}

	public void actionPerformed(ActionEvent arg0) {
		CVLModel m = new CVLModel();
		Context.eINSTANCE.addCvlModel(m);
		Context.eINSTANCE.addCvlView(new CVLView(m, c));
	}
}
