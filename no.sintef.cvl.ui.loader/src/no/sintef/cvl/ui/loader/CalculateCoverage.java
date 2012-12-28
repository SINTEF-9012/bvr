package no.sintef.cvl.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import splar.core.fm.FeatureModelException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

import no.sintef.ict.splcatool.CALib;
import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CSVException;
import no.sintef.ict.splcatool.CVLException;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;

public class CalculateCoverage implements ActionListener {
	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;
	private int t;

	public CalculateCoverage(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views, int t) {
		this.filePane = filePane;
		this.models = models;
		this.views = views;
		this.t = t;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int i = filePane.getSelectedIndex();
		CVLModel m = models.get(i);
		CVLView v = views.get(i);
		
		Integer cov = null;
		
		try {
			// Get FM:
			GUIDSL gdsl = m.getCVLM().getGUIDSL();
			CNF cnf = gdsl.getSXFM().getCNF();
			
			// Get Covering Array
			CoveringArray ca = m.getCVLM().getCoveringArray();
			
			// Calculate
			cov = (int) Math.round(CALib.calc_coverage(cnf, t, ca));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Calculating coverage failed: " + e.getMessage());
			e.printStackTrace();
			return;
		}
		
		JOptionPane.showMessageDialog(null, t +"-wise coverage: " + cov + "%");
	}

}
