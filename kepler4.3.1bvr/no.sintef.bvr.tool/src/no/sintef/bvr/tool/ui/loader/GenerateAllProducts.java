package no.sintef.bvr.tool.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.CoveringArrayComplete;
import no.sintef.ict.splcatool.CoveringArrayFile;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;

public class GenerateAllProducts implements ActionListener {
	private int t;
	private BVRModel m;
	private BVRView v;
	
	public GenerateAllProducts(BVRModel m, BVRView bvrView) {
		this.m = m;
		this.v = bvrView;
	}


	public void actionPerformed(ActionEvent ae) {
		
		try {
			GUIDSL gdsl = m.getBVRM().getGUIDSL();
			CNF cnf = gdsl.getSXFM().getCNF();
			CoveringArray ca = new CoveringArrayComplete(cnf);
			ca.generate();
			GraphMLFM gfm = gdsl.getGraphMLFMConf(ca);
			m.getBVRM().getCU().getOwnedVSpecResolution().clear();
			m.getBVRM().getChoiceResolutions(gfm);
		} catch (Exception e) {
			Context.eINSTANCE.logger.error("Generating covering array failed:", e);
			StaticUICommands.showMessageErrorDialog(null, e, "Generating covering array failed:");
			return;
		}
		
		//v.notifyResolutionViewUpdate();
	}
}
