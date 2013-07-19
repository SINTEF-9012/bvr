package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;

public class OpenModelEvent implements ActionListener {
	
	private JTabbedPane c;

	public OpenModelEvent(JTabbedPane c){
		this.c = c;
	}

	public void actionPerformed(ActionEvent arg0) {
		try{
			JFileChooser fc = Context.eINSTANCE.getFileChooser();
			
			int isCanceled = fc.showOpenDialog(c);
			if(isCanceled == JFileChooser.CANCEL_OPTION)
				return;
			
			File sf = fc.getSelectedFile();
			if(sf == null) return;
			
			CVLModel m = Context.eINSTANCE.loadModelFromFile(sf);
			Context.eINSTANCE.addCvlModel(m);
			Context.eINSTANCE.addCvlView(new CVLView(m, c));
		}catch(Exception e){
			Context.eINSTANCE.logger.error("some error on Open", e);
			JOptionPane.showMessageDialog(null, "Failed to load file due to: " + e.getMessage());
		}
	}

}