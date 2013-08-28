package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileFilter;

import no.sintef.cvl.common.Utility;
import no.sintef.cvl.ui.common.Messages;
import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.context.StaticUICommands;
import no.sintef.cvl.ui.filter.PNGFilter;
import no.sintef.cvl.ui.filter.SVGFilter;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import com.google.common.collect.Lists;

public class ExportModelSVG implements ActionListener {

	JTabbedPane filePane;
	private static final String SVG_EXT = "." + SVGFilter.SVG_EXT;

	public ExportModelSVG(JTabbedPane filePane) {
		this.filePane = filePane;
	}

	public void actionPerformed(ActionEvent e) {
		int i = filePane.getSelectedIndex();
		CVLView view = Context.eINSTANCE.getCvlViews().get(i);
		CVLModel model = Context.eINSTANCE.getCvlModels().get(i);
		
		FileFilter[] filters = {new SVGFilter()};
		JFileChooser filechooser = StaticUICommands.getFileChooser(filters, filters[0]);
		
		if(model.getFile() != null){
			String defualtName = Utility.removeExtension(model.getFile().getName());
			filechooser.setSelectedFile(new File(defualtName));
		}
		
		int status = filechooser.showSaveDialog(filePane);
		
		if(status == JFileChooser.CANCEL_OPTION)
			return;
		
		File sf = filechooser.getSelectedFile();
		if(sf == null) return;
		
		if(!sf.getAbsolutePath().endsWith(SVG_EXT))
			sf = new File(sf.getAbsolutePath() + SVG_EXT);
		
		if(sf.exists()){
			int result = JOptionPane.showConfirmDialog(filePane, "File already exist, overwrite?", "alert", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.NO_OPTION)
				return;
		}
		
		try {
			view.getKernel().getModelPanel().clearBuffer();
			DOMImplementation impl = GenericDOMImplementation.getDOMImplementation();
			String svgNS = "http://www.w3.org/2000/svg";
			Document myFactory = impl.createDocument(svgNS, "svg", null);
			SVGGeneratorContext ctx = SVGGeneratorContext.createDefault(myFactory);
			ctx.setEmbeddedFontsOn(true);
			SVGGraphics2D g2 = new SVGGraphics2D(ctx,true);
			view.getKernel().getModelPanel().paintComponents(g2);
			view.getKernel().getModelPanel().paint(g2);
			FileOutputStream fout = new FileOutputStream(sf);
			Writer out = new OutputStreamWriter(fout, "UTF-8");
			g2.stream(out, true);
			fout.close();
			Context.eINSTANCE.getConfig().saveLastLocation(sf.getAbsolutePath());
		} catch (Exception ex) {
			Context.eINSTANCE.logger.error("", ex);
			JOptionPane.showMessageDialog(filePane, Messages.DIALOG_MSG_GENERAL_ERROR + ex.getMessage());
		}
	}
}