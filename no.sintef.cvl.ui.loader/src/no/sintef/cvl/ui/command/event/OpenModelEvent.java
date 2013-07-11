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
		final JFileChooser fc = Context.eINSTANCE.getFileChooser();
		
		int isCanceled = fc.showOpenDialog(c);
		if(isCanceled == JFileChooser.CANCEL_OPTION)
			return;
		
		File sf = fc.getSelectedFile();
		
		if(sf == null) return;
		
		CVLModel m;
		try{
			m = Context.eINSTANCE.loadModelFromFile(sf);
		}catch(UnsupportedOperationException e){
			JOptionPane.showMessageDialog(null, "Failed to load file due to: " + e.getMessage());
			return;
		}
		Context.eINSTANCE.addCvlModel(m);
		Context.eINSTANCE.addCvlView(new CVLView(m, c));
	}

}