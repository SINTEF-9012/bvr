package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.command.StaticUICommands;
import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.loader.CVLModel;


public class SaveModelAsEvent implements ActionListener {
	private JTabbedPane filePane;
	private boolean trydirectsave;

	public SaveModelAsEvent(JTabbedPane filePane,  boolean b) {
		this.filePane = filePane;
		this.trydirectsave = b;
	}

	public void actionPerformed(ActionEvent event) {		
		try{
			int i = filePane.getSelectedIndex();
			CVLModel model = Context.eINSTANCE.getCvlModels().get(i);
			
			File file = StaticUICommands.saveModelToFile(filePane, model, trydirectsave);
			if(file != null){
				filePane.setTitleAt(i, file.getName());
				filePane.setToolTipTextAt(i, file.getAbsolutePath());
			}
		}catch(Exception e){
			Context.eINSTANCE.logger.error("some error on Save", e);
			JOptionPane.showMessageDialog(filePane, "Error saving file: " + e.getMessage());
		}
	}
}
