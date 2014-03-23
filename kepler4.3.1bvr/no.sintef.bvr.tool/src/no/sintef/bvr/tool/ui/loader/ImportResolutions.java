package no.sintef.bvr.tool.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileFilter;

import bvr.ConfigurableUnit;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.filter.BVRFilter;
import no.sintef.bvr.tool.filter.SHFilter;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.ict.splcatool.CSVException;
import no.sintef.ict.splcatool.CoveringArray;
import no.sintef.ict.splcatool.CoveringArrayFile;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;

public class ImportResolutions implements ActionListener {
	private BVRModel m;
	private BVRView v;

	public ImportResolutions(BVRModel m, BVRView bvrView) {
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
		
		//v.notifyResolutionViewUpdate();
	}
}