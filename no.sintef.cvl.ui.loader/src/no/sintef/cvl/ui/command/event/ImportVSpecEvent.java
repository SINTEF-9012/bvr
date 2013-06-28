package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

import no.sintef.cvl.ui.filter.CVLFilter;
import no.sintef.cvl.ui.filter.FMFilter;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.SXFM;

public class ImportVSpecEvent implements ActionListener {
	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;

	public ImportVSpecEvent(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views) {
		this.filePane = filePane;
		this.models = models;
		this.views = views;
	}

	public void actionPerformed(ActionEvent arg0) {
		int i = filePane.getSelectedIndex();
		CVLModel m = models.get(i);
		CVLView v = views.get(i);
		
		final JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FMFilter());
		fc.addChoosableFileFilter(new CVLFilter());
		fc.showOpenDialog(filePane);
		
		File sf = fc.getSelectedFile();
		no.sintef.ict.splcatool.CVLModel cvlm = null;
		try {
			if(sf.getName().endsWith(".m"))
				cvlm = new GUIDSL(sf).getGraphMLFM().getCVLModel();
			else if(sf.getName().endsWith(".xml"))
				cvlm = new SXFM(sf.getAbsolutePath()).getGUIDSL().getGraphMLFM().getCVLModel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		m.addVSpec(cvlm.getCU().getOwnedVSpec().get(0));
		
		v.notifyVspecViewUpdate();
	}
}
