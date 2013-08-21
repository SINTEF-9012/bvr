package no.sintef.cvl.ui.command.event;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.common.Messages;
import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.loader.CVLView;

public class ExportModelImage implements ActionListener {

	JTabbedPane filePane;
	private static final String PNG_EXT = ".png";

	public ExportModelImage(JTabbedPane filePane) {
		this.filePane = filePane;
	}

	public void actionPerformed(ActionEvent e) {
		int i = filePane.getSelectedIndex();
		CVLView view = Context.eINSTANCE.getCvlViews().get(i);
		JFileChooser filechooser = Context.eINSTANCE.getFileChooser();
		
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
			JOptionPane.showMessageDialog(filePane, Messages.DIALOG_MSG_GENERAL_ERROR + ex.getMessage());
		}
	}
}