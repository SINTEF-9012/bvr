package no.sintef.cvl.ui.loader;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class SaveModelAsEvent implements ActionListener {
	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;
	private boolean trydirectsave;

	public SaveModelAsEvent(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views, boolean b) {
		this.filePane = filePane;
		this.models = models;
		this.views = views;
		this.trydirectsave = b;
	}

	public void actionPerformed(ActionEvent ae) {
		int i = filePane.getSelectedIndex();
		CVLModel m = models.get(i);
		CVLView v = views.get(i);
		
		if(trydirectsave){
			if(m.getFile() != null){
				try{
					m.getCVLM().writeToFile(m.getFile().getAbsolutePath());
				}catch (IOException e) {
					JOptionPane.showMessageDialog(filePane, "Error writing file: " + e.getMessage());
				}
				return;
			}
		}
		System.out.println("ss");
		final JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new CVLFilter());
		fc.showSaveDialog(filePane);
		
		File sf = fc.getSelectedFile();
		if(sf == null) return;
		if(sf.exists()){
			int result = JOptionPane.showConfirmDialog(filePane, "File already exist, overwrite?", "alert", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.NO_OPTION)
				return;
		}
		
		try {
			m.getCVLM().writeToFile(sf.getAbsolutePath());
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = sw.toString();
			JOptionPane.showMessageDialog(filePane, "Error saving file: " + msg);
			return;
		}
		
		m.setFile(sf);
		filePane.setTitleAt(i, sf.getName());
		filePane.setToolTipTextAt(i, sf.getAbsolutePath());
	}
}
