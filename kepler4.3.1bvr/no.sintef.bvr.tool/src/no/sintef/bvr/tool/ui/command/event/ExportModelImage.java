package no.sintef.bvr.tool.ui.command.event;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileFilter;

import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.internal.image.PNGFileFormat;

import bvr.VSpecResolution;

import com.google.common.collect.Lists;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.filter.PNGFilter;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;

public class ExportModelImage implements ActionListener {

	JLayeredPane view;
	BVRToolModel model;
	private EList<VSpecResolution> resolutions;
	private JTabbedPane resPane;
	
	private static final String PNG_EXT = "." + PNGFilter.PNG_EXT;

	public ExportModelImage(JLayeredPane cup, BVRToolModel model, EList<VSpecResolution> resolutions, JTabbedPane resPane) {
		this.view = cup;
		this.model = model;
		this.resolutions = resolutions;
		this.resPane = resPane;
	}

	public void actionPerformed(ActionEvent e) {
		JLayeredPane x;
		
		if(resPane == null){
			x = view;
		}else{
			EditableModelPanel draw = (EditableModelPanel) resPane.getSelectedComponent();
			JScrollPane draw2 = (JScrollPane) draw.modelPanel;
			x = (JLayeredPane) draw2.getViewport().getView();
		}
				
		saveImg(x);
	}

	private void saveImg(JLayeredPane draw) {
		FileFilter[] filters = {new PNGFilter()};
		JFileChooser filechooser = StaticUICommands.getFileChooser(filters, filters[0]);
		
		if(model.getFile() != null){
			String defualtName = CommonUtility.removeExtension(model.getFile().getName());
			filechooser.setSelectedFile(new File(defualtName));
		}
		
		int status = filechooser.showSaveDialog(null);
		if(status == JFileChooser.CANCEL_OPTION)
			return;
		
		File sf = filechooser.getSelectedFile();
		if(sf == null) return;
		
		if(!sf.getAbsolutePath().endsWith(PNG_EXT))
			sf = new File(sf.getAbsolutePath() + PNG_EXT);
		
		if(sf.exists()){
			int result = JOptionPane.showConfirmDialog(null, "File already exist, overwrite?", "alert", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.NO_OPTION)
				return;
		}
		
		try {			
			Dimension size = draw.getSize();
			BufferedImage bi = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
			
			final Graphics2D g2 = bi.createGraphics();

			draw.paintComponents(g2);
			draw.paint(g2);
			ImageIO.write(bi, "PNG", sf);
			
			Context.eINSTANCE.getConfig().saveLastLocation(sf.getAbsolutePath());
		} catch (Exception ex) {
			Context.eINSTANCE.logger.error("", ex);
			StaticUICommands.showMessageErrorDialog(null, ex, "can not export a model");
		}
	}
}