package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;
import no.sintef.bvr.tool.ui.loader.BVRToolView;

public class NewModelEvent implements ActionListener {

	private JTabbedPane c;

	public NewModelEvent(JTabbedPane c) {
		this.c = c;
	}

	public void actionPerformed(ActionEvent arg0) {
		try{
			BVRToolModel m = new BVRToolModel();
			Context.eINSTANCE.addBvrModel(m);
			//Context.eINSTANCE.addBvrView(new VSpecView(m, c));
		}catch(Exception e){
			Context.eINSTANCE.logger.error("some error on New", e);
			StaticUICommands.showMessageErrorDialog(null, e, "some error on New");
		}
	}
}
