package no.sintef.cvl.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.CoveringArrayFile;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;

public class GenerateCoveringArray implements ActionListener {
	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;

	public GenerateCoveringArray(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views) {
		this.filePane = filePane;
		this.models = models;
		this.views = views;
	}

	public void actionPerformed(ActionEvent ae) {
		int i = filePane.getSelectedIndex();
		CVLModel m = models.get(i);
		CVLView v = views.get(i);
		
		try {
			GUIDSL gdsl = m.getCVLM().getGUIDSL();
			CNF cnf = gdsl.getSXFM().getCNF();
			CoveringArray ca = cnf.getCoveringArrayGenerator("J11", 2, 1);
			ca.generate();
			GraphMLFM gfm = gdsl.getGraphMLFMConf(ca);
			m.getCVLM().injectConfigurations(gfm);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Generating covering array failed: " + e.getMessage());
			e.printStackTrace();
			return;
		}
		
		v.notifyResolutionViewUpdate();
	}
}