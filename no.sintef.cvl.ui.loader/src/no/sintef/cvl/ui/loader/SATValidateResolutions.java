package no.sintef.cvl.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;

import splar.core.fm.FeatureModelException;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

import no.sintef.ict.splcatool.CALib;
import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CSVException;
import no.sintef.ict.splcatool.CVLException;
import no.sintef.ict.splcatool.CoveringArray;

public class SATValidateResolutions implements ActionListener {
	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;
	
	public SATValidateResolutions(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views) {
		this.filePane = filePane;
		this.models = models;
		this.views = views;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int i = filePane.getSelectedIndex();
		CVLModel m = models.get(i);
		CVLView v = views.get(i);
		
		no.sintef.ict.splcatool.CVLModel x = m.getCVLM();
		
		CoveringArray ca;
		try {
			ca = x.getCoveringArray();
		} catch (CSVException e) {
			JOptionPane.showMessageDialog(null, "Getting CA failed: " + e.getMessage());
			return;
		} catch (CVLException e) {
			JOptionPane.showMessageDialog(null, "Getting CA failed: " + e.getMessage());
			return;
		}
		CNF cnf;
		try {
			cnf = x.getGUIDSL().getSXFM().getCNF();
			List<String> output = new ArrayList<String>();
			boolean valid = CALib.verifyCA(cnf, ca, true, output);
			JOptionPane.showMessageDialog(null, "Valid: " + valid + " " + output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
