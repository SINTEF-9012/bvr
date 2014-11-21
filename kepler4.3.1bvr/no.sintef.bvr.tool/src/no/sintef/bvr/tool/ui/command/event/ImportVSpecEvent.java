package no.sintef.bvr.tool.ui.command.event;

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
import no.sintef.bvr.tool.filter.BVRFilter;
import no.sintef.bvr.tool.filter.FMFilter;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.SXFM;

public class ImportVSpecEvent implements ActionListener {
	private JTabbedPane filePane;
	private List<BVRToolModel> models;
	private List<BVRNotifiableController> views;

	public ImportVSpecEvent(JTabbedPane filePane, List<BVRToolModel> models, List<BVRNotifiableController> views) {
		this.filePane = filePane;
		this.models = models;
		this.views = views;
	}

	public void actionPerformed(ActionEvent arg0) {
		int i = filePane.getSelectedIndex();
		BVRToolModel m = models.get(i);
		BVRNotifiableController v = views.get(i);
		
		final JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FMFilter());
		fc.addChoosableFileFilter(new BVRFilter());
		fc.showOpenDialog(filePane);
		
		File sf = fc.getSelectedFile();
		no.sintef.ict.splcatool.SPLCABVRModel bvrm = null;
		try {
			if(sf.getName().endsWith(".m"))
				bvrm = new GUIDSL(sf).getGraphMLFM().getBVRModel();
			else if(sf.getName().endsWith(".xml"))
				bvrm = new SXFM(sf.getAbsolutePath()).getGUIDSL().getGraphMLFM().getBVRModel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//m.addVSpec(bvrm.getCU().getOwnedVSpec().get(0));
		
	}
}
