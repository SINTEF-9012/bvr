package no.sintef.bvr.tool.ui.loader;

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

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.ict.splcatool.CALib;
import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CSVException;
import no.sintef.ict.splcatool.CVLException;
import no.sintef.ict.splcatool.CoveringArray;

public class SATValidateResolutions implements ActionListener {
	private CVLModel m;
	private CVLView v;

	public SATValidateResolutions(CVLModel m, CVLView bvrView) {
		this.m = m;
		this.v = bvrView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		no.sintef.ict.splcatool.CVLModel x = m.getCVLM();
		
		CoveringArray ca;
		try {
			ca = x.getCoveringArray();
		} catch (CSVException e) {
			Context.eINSTANCE.logger.error("Getting CA failed: ", e);
			StaticUICommands.showMessageErrorDialog(null, e, "Getting CA failed: ");
			return;
		} catch (CVLException e) {
			Context.eINSTANCE.logger.error("Getting CA failed: ", e);
			StaticUICommands.showMessageErrorDialog(null, e, "Getting CA failed: ");
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
