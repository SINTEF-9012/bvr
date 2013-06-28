package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.loader.CVLView;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

public class ExportModelSVG implements ActionListener {

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

	public ExportModelSVG(List<CVLView> views, JTabbedPane filePane) {
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
					view.getKernel().getModelPanel().clearBuffer();
					DOMImplementation impl = GenericDOMImplementation.getDOMImplementation();
					String svgNS = "http://www.w3.org/2000/svg";
					Document myFactory = impl.createDocument(svgNS, "svg", null);
					SVGGeneratorContext ctx = SVGGeneratorContext.createDefault(myFactory);
					ctx.setEmbeddedFontsOn(true);
					SVGGraphics2D g2 = new SVGGraphics2D(ctx,true);
					view.getKernel().getModelPanel().paintComponents(g2);
					view.getKernel().getModelPanel().paint(g2);
					FileOutputStream fout = new FileOutputStream(new File(filechooser.getSelectedFile(), "cvl_" + i + ".svg"));
					Writer out = new OutputStreamWriter(fout, "UTF-8");
					g2.stream(out, true);
					fout.close();
					i++;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}	
		}	
	}
}