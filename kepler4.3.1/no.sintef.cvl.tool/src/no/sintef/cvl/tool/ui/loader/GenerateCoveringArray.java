package no.sintef.cvl.tool.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.ui.context.StaticUICommands;
import no.sintef.ict.splcatool.CNF;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.CoveringArrayFile;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;

public class GenerateCoveringArray implements ActionListener {
	private JTabbedPane filePane;
	private List<CVLModel> models;
	private List<CVLView> views;
	private int t;

	public GenerateCoveringArray(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views, int t) {
		this.filePane = filePane;
		this.models = models;
		this.views = views;
		this.t = t;
	}

	public void actionPerformed(ActionEvent ae) {
		int i = filePane.getSelectedIndex();
		CVLModel m = models.get(i);
		CVLView v = views.get(i);
		
		try {
			GUIDSL gdsl = m.getCVLM().getGUIDSL();
			CNF cnf = gdsl.getSXFM().getCNF();
			CoveringArray ca = cnf.getCoveringArrayGenerator("J11", t, 1);
			if(m.getCVLM().getCU().getOwnedVSpecResolution().size() > 0){
				CoveringArray startFrom = m.getCVLM().getCoveringArray();
				ca.startFrom(startFrom);
			}
			ca.generate();
			GraphMLFM gfm = gdsl.getGraphMLFMConf(ca);
			m.getCVLM().getCU().getOwnedVSpecResolution().clear();
			m.getCVLM().injectConfigurations(gfm);
		} catch (Exception e) {
			Context.eINSTANCE.logger.error("Generating covering array failed:", e);
			StaticUICommands.showMessageErrorDialog(null, e, "Generating covering array failed:");
			return;
		}
		
		v.notifyResolutionViewUpdate();
	}
}
