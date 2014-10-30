package no.sintef.bvr.tool.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.filter.BVRFilter;
import no.sintef.bvr.tool.filter.SHFilter;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.CoveringArrayFile;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;

public class ImportResolutions implements ActionListener {
	private BVRToolModel m;
	private BVRNotifiableController v;

	public ImportResolutions(BVRToolModel m, BVRNotifiableController bvrView) {
		this.m = m;
		this.v = bvrView;
	}

	public void actionPerformed(ActionEvent ae) {
		
		final JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new SHFilter());
		fc.addChoosableFileFilter(new BVRFilter());
		fc.showOpenDialog(null);
		
		File sf = fc.getSelectedFile();
		GraphMLFM gfm = null;
		try {
			CoveringArray ca = new CoveringArrayFile(sf);
			GUIDSL gdsl = m.getBVRM().getGUIDSL();
			gfm = gdsl.getGraphMLFMConf(ca);
		} catch (Exception e) {
			Context.eINSTANCE.logger.error("Importing resolutions failed: ", e);
			StaticUICommands.showMessageErrorDialog(null, e, "Importing resolutions failed: ");
			return;
		}
		
		m.getBVRM().getChoiceResolutions(gfm);
	}
}