package no.sintef.cvl.ui.context;

import java.awt.Container;
import java.awt.Dimension;
import java.io.File;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

import com.google.common.collect.Lists;

import no.sintef.cvl.common.Utility;
import no.sintef.cvl.ui.common.Messages;
import no.sintef.cvl.ui.filter.CVLFilter;
import no.sintef.cvl.ui.filter.FMFilter;
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
						StaticUICommands.showMessageErrorDialog(parent, e, "Error writing file: ");
						return null;
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
	
	public static JFileChooser getFileChooser(FileFilter[] filters, FileFilter defaultFilter){
		JFileChooser fc = Context.eINSTANCE.getFileChooser();
		if(filters != null){
			for(FileFilter filer : filters)
				fc.addChoosableFileFilter(filer);
			if(defaultFilter != null && Lists.newArrayList(filters).indexOf(defaultFilter) >= 0)
				fc.setFileFilter(defaultFilter);
		}
		return fc;
	}
	
	public static JFileChooser getCVLFileChooser(){
		JFileChooser fc = Context.eINSTANCE.getFileChooser();
		fc.addChoosableFileFilter(new FMFilter());
		CVLFilter cvlFilter = new CVLFilter();
		fc.addChoosableFileFilter(cvlFilter);
		fc.setFileFilter(cvlFilter);
		return fc;
	}
	
	public static void showMessageErrorDialog(Container parent, Throwable e, String message){
		message = (message != null && !message.isEmpty()) ? message + " '" +e.getMessage() + "'\n" + Utility.getStackTraceAsString(e) : e.getMessage() + "\n" + Utility.getStackTraceAsString(e);
		JTextArea textArea = new JTextArea(message);
		JScrollPane scrollPane = new JScrollPane(textArea){
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(480, 320);
			};
		};
		JOptionPane.showMessageDialog(parent, scrollPane, Messages.DIALOG_MSG_GENERAL_ERROR, JOptionPane.ERROR_MESSAGE);
	}
}
