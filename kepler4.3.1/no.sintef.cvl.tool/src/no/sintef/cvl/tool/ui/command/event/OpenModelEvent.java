package no.sintef.cvl.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.ui.context.StaticUICommands;
import no.sintef.cvl.tool.ui.loader.CVLModel;
import no.sintef.cvl.tool.ui.loader.CVLView;

public class OpenModelEvent implements ActionListener {
	
	private JTabbedPane c;

	public OpenModelEvent(JTabbedPane c){
		this.c = c;
	}

	public void actionPerformed(ActionEvent arg0) {
		try{
			JFileChooser fc = StaticUICommands.getCVLFileChooser();
			
			int isCanceled = fc.showOpenDialog(c);
			if(isCanceled == JFileChooser.CANCEL_OPTION)
				return;
			
			File sf = fc.getSelectedFile();
			if(sf == null) return;
			
			CVLModel m = Context.eINSTANCE.loadModelFromFile(sf);
			Context.eINSTANCE.addCvlModel(m);
			//Context.eINSTANCE.addCvlView(new VSpecView(m, c));
		}catch(Exception e){
			Context.eINSTANCE.logger.error("some error on Open", e);
			StaticUICommands.showMessageErrorDialog(null, e, "Failed to load file due to:");
		}
	}

}