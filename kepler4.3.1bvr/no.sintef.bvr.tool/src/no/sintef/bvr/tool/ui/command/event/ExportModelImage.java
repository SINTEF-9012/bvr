package no.sintef.bvr.tool.ui.command.event;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileFilter;

import org.eclipse.swt.internal.image.PNGFileFormat;

import com.google.common.collect.Lists;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.filter.PNGFilter;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.tool.ui.loader.BVRView;

public class ExportModelImage implements ActionListener {

	JTabbedPane filePane;
	private static final String PNG_EXT = "." + PNGFilter.PNG_EXT;

	public ExportModelImage(JTabbedPane filePane) {
		this.filePane = filePane;
	}

	public void actionPerformed(ActionEvent e) {
		int i = filePane.getSelectedIndex();
		BVRView view = Context.eINSTANCE.getBvrViews().get(i);
		BVRModel model = Context.eINSTANCE.getBvrModels().get(i);
		
		FileFilter[] filters = {new PNGFilter()};
		JFileChooser filechooser = StaticUICommands.getFileChooser(filters, filters[0]);
		
		if(model.getFile() != null){
			String defualtName = CommonUtility.removeExtension(model.getFile().getName());
			filechooser.setSelectedFile(new File(defualtName));
		}
		
		int status = filechooser.showSaveDialog(filePane);
		if(status == JFileChooser.CANCEL_OPTION)
			return;
		
		File sf = filechooser.getSelectedFile();
		if(sf == null) return;
		
		if(!sf.getAbsolutePath().endsWith(PNG_EXT))
			sf = new File(sf.getAbsolutePath() + PNG_EXT);
		
		if(sf.exists()){
			int result = JOptionPane.showConfirmDialog(filePane, "File already exist, overwrite?", "alert", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.NO_OPTION)
				return;
		}
		
		try {			
			Dimension size = view.getKernel().getModelPanel().getSize();
			BufferedImage bi = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
			
			final Graphics2D g2 = bi.createGraphics();

			view.getKernel().getModelPanel().paintComponents(g2);
			view.getKernel().getModelPanel().paint(g2);
			ImageIO.write(bi, "PNG", sf);
			
			Context.eINSTANCE.getConfig().saveLastLocation(sf.getAbsolutePath());
		} catch (Exception ex) {
			Context.eINSTANCE.logger.error("", ex);
			StaticUICommands.showMessageErrorDialog(filePane, ex, "can not export a model");
		}
	}
}