package no.sintef.bvr.tool.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import splar.core.fm.FeatureModelException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.ict.splcatool.CALib;
import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CSVException;
import no.sintef.ict.splcatool.CVLException;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;

public class CalculateCoverage implements ActionListener {
	private int t;
	private CVLModel m;

	public CalculateCoverage(CVLModel m, CVLView bvrView, int t) {
		this.m = m;
		this.t = t;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
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
			Context.eINSTANCE.logger.error("Calculating coverage failed:", e);
			StaticUICommands.showMessageErrorDialog(null, e, "Calculating coverage failed:");
			return;
		}
		
		JOptionPane.showMessageDialog(null, t +"-wise coverage: " + cov + "%");
	}

}
