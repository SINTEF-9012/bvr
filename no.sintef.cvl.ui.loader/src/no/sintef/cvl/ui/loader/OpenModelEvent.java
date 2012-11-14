package no.sintef.cvl.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileFilter;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;
import no.sintef.ict.splcatool.SXFM;

public class OpenModelEvent implements ActionListener {
	
	private JTabbedPane c;
	private List<CVLModel> models;
	private List<CVLView> views;
	private static File lastDir = new File("C:\\Users\\mjoha\\workspace-CVLTool2\\cvl\\TestData");

	OpenModelEvent(JTabbedPane c, List<CVLModel> models, List<CVLView> views){
		this.c = c;
		this.models = models;
		this.views = views;
	}

	public void actionPerformed(ActionEvent arg0) {
		final JFileChooser fc = new JFileChooser();
		if(lastDir != null)
			fc.setCurrentDirectory(lastDir);
		fc.addChoosableFileFilter(new FMFilter());
		fc.addChoosableFileFilter(new CVLFilter());
		fc.showOpenDialog(c);
		
		File sf = fc.getSelectedFile();
		
		if(sf == null) return;
		lastDir = fc.getCurrentDirectory();
		
		String ext = Utils.getExtension(sf);
		
		CVLModel m = null;
		if(ext.equals("cvl") || ext.equals("xmi")){
			m = new CVLModel(sf);
		}else if(ext.equals("m")){
			try {
				no.sintef.ict.splcatool.CVLModel cvlm = new GUIDSL(sf).getGraphMLFM().getCVLModel();
				m = new CVLModel(sf, cvlm);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Loading model failed: " + e.getMessage());
			}
		}else if(ext.equals("xml")){
			try {
				SXFM sxfm = new SXFM(sf.getAbsolutePath());
				GraphMLFM gml = sxfm.getGUIDSL().getGraphMLFM();
				no.sintef.ict.splcatool.CVLModel cvlm = gml.getCVLModel();
				m = new CVLModel(sf, cvlm);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Loading model failed: " + e.getMessage());
			}
		}else{
			JOptionPane.showMessageDialog(null, "Unknown file type: *." + ext);
		}
		
		if(m != null){
			models.add(m);
			views.add(new CVLView(m, c));
		}
	}

}

class Utils{
	static String getExtension(File f){
	    String p = f.getAbsolutePath();
	    return p.substring(p.lastIndexOf(".")+1, p.length());
	}
}


class CVLFilter extends FileFilter{
	@Override
	public boolean accept(File f) {
	    if (f.isDirectory()) {
	        return true;
	    }
	    
	    String extension = Utils.getExtension(f);
	    if (extension != null) {
	    	if(extension.equals("cvl")) return true;
	    	if(extension.equals("xmi")) return true;
	    }
	    return false;
	}
	@Override
	public String getDescription() {
		return "CVL Model (*.cvl, *.xmi)";
	}
}

class FMFilter extends FileFilter{
	@Override
	public boolean accept(File f) {
	    if (f.isDirectory()) {
	        return true;
	    }

	    String extension = Utils.getExtension(f);
	    if (extension != null) {
	    	if(extension.equals("m")) return true;
	    	if(extension.equals("xml")) return true;
	    }
	    return false;
	}
	@Override
	public String getDescription() {
		return "Other Feature Diagram (*.m, *.xml)";
	}
}