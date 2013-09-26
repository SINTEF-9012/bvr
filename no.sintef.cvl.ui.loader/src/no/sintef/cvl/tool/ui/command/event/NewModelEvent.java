package no.sintef.cvl.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.ui.context.StaticUICommands;
import no.sintef.cvl.tool.ui.loader.CVLModel;
import no.sintef.cvl.tool.ui.loader.CVLView;

public class NewModelEvent implements ActionListener {

	private JTabbedPane c;

	public NewModelEvent(JTabbedPane c) {
		this.c = c;
	}

	public void actionPerformed(ActionEvent arg0) {
		try{
			CVLModel m = new CVLModel();
			Context.eINSTANCE.addCvlModel(m);
			Context.eINSTANCE.addCvlView(new CVLView(m, c));
		}catch(Exception e){
			Context.eINSTANCE.logger.error("some error on New", e);
			StaticUICommands.showMessageErrorDialog(null, e, "some error on New");
		}
	}
}
