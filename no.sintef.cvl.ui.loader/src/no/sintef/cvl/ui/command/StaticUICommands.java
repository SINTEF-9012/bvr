package no.sintef.cvl.ui.command;

import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.filter.CVLFilter;
import no.sintef.cvl.ui.loader.CVLModel;

public class StaticUICommands {

	public static File saveModelToFile(JComponent parent, CVLModel model, boolean trydirectsave){
		try{
			final String CVL_EXT = "." + CVLFilter.CVL_EXT;
			if(trydirectsave){
				if(model.getFile() != null){
					try{
						Context.eINSTANCE.writeModelToFile(model, model.getFile());
					} catch(UnsupportedOperationException e){
						JOptionPane.showMessageDialog(parent, "Error writing file: " + e.getMessage());
					}
					return model.getFile();
				}
			}
			
			final JFileChooser fc = Context.eINSTANCE.getFileChooser();
			
			int isCanceled = fc.showSaveDialog(parent);
			if(isCanceled == JFileChooser.CANCEL_OPTION)
				return null;
			
			File sf = fc.getSelectedFile();
			if(sf == null) return null;
			
			if(!sf.getAbsolutePath().endsWith(CVL_EXT))
				sf = new File(sf.getAbsolutePath() + CVL_EXT);
			
			if(sf.exists()){
				int result = JOptionPane.showConfirmDialog(parent, "File already exist, overwrite?", "alert", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.NO_OPTION)
					return null;
			}
			Context.eINSTANCE.writeModelToFile(model, sf);
			return sf;
		}catch(Exception e){
			throw new UnsupportedOperationException(e);
		}
	}
}
