package no.sintef.cvl.ui.loader;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;

public class ExportModelImage implements ActionListener {

	private List<CVLView> views;
	JTabbedPane filePane;
	private JFileChooser filechooser = new JFileChooser();
	private static String defaultLocation = null;

	public static String getDefaultLocation() {
		return defaultLocation;
	}

	public static void setDefaultLocation(String uri) {
		defaultLocation = uri;
	}

	public ExportModelImage(List<CVLView> views, JTabbedPane filePane) {
		this.filePane = filePane;
		this.views = views;
	}

	public void actionPerformed(ActionEvent e) {
		filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		filechooser.showOpenDialog(filePane);
		if (filechooser.getSelectedFile() != null) {
			try {
				int i = 0;

				for(CVLView view : views) {
				
				Dimension size = view.getKernel().getModelPanel().getSize();
				BufferedImage bi = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
				
				final Graphics2D g2 = bi.createGraphics();

				view.getKernel().getModelPanel().paintComponents(g2);
				view.getKernel().getModelPanel().paint(g2);


				ImageIO.write(bi, "PNG", new File(filechooser.getSelectedFile().getAbsoluteFile(), "cvl_" + i + ".png"));
				i++;
				
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}


		}
	}
}