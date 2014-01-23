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
import no.sintef.ict.splcatool.CoveringArrayFile;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;

public class GenerateCoveringArray implements ActionListener {
	private int t;
	private BVRModel m;
	private BVRView v;
	
	public GenerateCoveringArray(BVRModel m, BVRView bvrView, int t) {
		this.m = m;
		this.v = bvrView;
		this.t = t;
	}

	public void actionPerformed(ActionEvent ae) {
		
		try {
			GUIDSL gdsl = m.getBVRM().getGUIDSL();
			CNF cnf = gdsl.getSXFM().getCNF();
			CoveringArray ca = cnf.getCoveringArrayGenerator("J11", t, 1);
			if(m.getBVRM().getCU().getOwnedVSpecResolution().size() > 0){
				CoveringArray startFrom = m.getBVRM().getCoveringArray();
				ca.startFrom(startFrom);
			}
			ca.generate();
			GraphMLFM gfm = gdsl.getGraphMLFMConf(ca);
			m.getBVRM().getCU().getOwnedVSpecResolution().clear();
			m.getBVRM().injectConfigurations(gfm);
		} catch (Exception e) {
			Context.eINSTANCE.logger.error("Generating covering array failed:", e);
			StaticUICommands.showMessageErrorDialog(null, e, "Generating covering array failed:");
			return;
		}
		
		v.notifyResolutionViewUpdate();
	}
}
