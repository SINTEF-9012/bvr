package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.filter.CVLFilter;
import no.sintef.cvl.ui.filter.FMFilter;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.FileHelper;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;
import no.sintef.ict.splcatool.SXFM;

public class OpenModelEvent implements ActionListener {
	
	private JTabbedPane c;
	private List<CVLModel> models;
	private List<CVLView> views;

	public OpenModelEvent(JTabbedPane c, List<CVLModel> models, List<CVLView> views){
		this.c = c;
		this.models = models;
		this.views = views;
	}

	public void actionPerformed(ActionEvent arg0) {
		final JFileChooser fc = new JFileChooser();
		if(FileHelper.lastLocation() != null)
			fc.setCurrentDirectory(new File(FileHelper.lastLocation()));
		fc.addChoosableFileFilter(new FMFilter());
		fc.addChoosableFileFilter(new CVLFilter());
		fc.showOpenDialog(c);
		
		File sf = fc.getSelectedFile();
		
		if(sf == null) return;
		FileHelper.saveLastLocation(fc.getCurrentDirectory().getAbsolutePath());
		
		String ext = Utility.getExtension(sf);
		
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