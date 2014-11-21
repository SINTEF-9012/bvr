package no.sintef.bvr.tool.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import no.sintef.bvr.tool.filter.BVRFilter;
import no.sintef.bvr.tool.filter.SHFilter;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;

public class ImportResolutions implements ActionListener {
	private BVRNotifiableController controller;

	public ImportResolutions(BVRNotifiableController _controller) {
		this.controller = _controller;
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent ae) {

		final JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new SHFilter());
		fc.addChoosableFileFilter(new BVRFilter());
		fc.showOpenDialog(null);

		File sf = fc.getSelectedFile();
		if (sf != null)
			controller.getResolutionControllerInterface().importResolution(sf);
	}
}
