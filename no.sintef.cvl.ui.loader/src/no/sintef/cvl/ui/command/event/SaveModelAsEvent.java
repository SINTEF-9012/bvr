package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.loader.CVLModel;


public class SaveModelAsEvent implements ActionListener {
	private JTabbedPane filePane;
	private boolean trydirectsave;


	public SaveModelAsEvent(JTabbedPane filePane,  boolean b) {
		this.filePane = filePane;
		this.trydirectsave = b;
	}

	public void actionPerformed(ActionEvent ae) {		
		try{
			int i = filePane.getSelectedIndex();
			CVLModel m = Context.eINSTANCE.getCvlModels().get(i);
			
			if(trydirectsave){
				if(m.getFile() != null){
					try{
						Context.eINSTANCE.writeModelToFile(m, m.getFile());
					} catch(UnsupportedOperationException e){
						JOptionPane.showMessageDialog(filePane, "Error writing file: " + e.getMessage());
					}
					return;
				}
			}
			
			final JFileChooser fc = Context.eINSTANCE.getFileChooser();
			
			int isCanceled = fc.showSaveDialog(filePane);
			if(isCanceled == JFileChooser.CANCEL_OPTION)
				return;
			
			File sf = fc.getSelectedFile();
			if(sf == null) return;	
			if(sf.exists()){
				int result = JOptionPane.showConfirmDialog(filePane, "File already exist, overwrite?", "alert", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.NO_OPTION)
					return;
			}
			Context.eINSTANCE.writeModelToFile(m, sf);
			
			filePane.setTitleAt(i, sf.getName());
			filePane.setToolTipTextAt(i, sf.getAbsolutePath());
		}catch(UnsupportedOperationException e){
			Context.eINSTANCE.logger.error("some error on Save", e);
			JOptionPane.showMessageDialog(filePane, "Error saving file: " + e.getMessage());
		}
	}
}
