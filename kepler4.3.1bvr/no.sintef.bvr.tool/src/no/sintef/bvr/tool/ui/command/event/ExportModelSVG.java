package no.sintef.bvr.tool.ui.command.event;

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

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.filter.PNGFilter;
import no.sintef.bvr.tool.filter.SVGFilter;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.context.StaticUICommands;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import com.google.common.collect.Lists;

public class ExportModelSVG implements ActionListener {

	JTabbedPane filePane;
	private BVRNotifiableController controller;
	private BVRToolModel model;
	private static final String SVG_EXT = "." + SVGFilter.SVG_EXT;

	public ExportModelSVG(BVRNotifiableController controller, BVRToolModel model) {
		this.controller = controller;
		this.model = model;
	}

	public void actionPerformed(ActionEvent e) {
		
		FileFilter[] filters = {new SVGFilter()};
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
		
		if(!sf.getAbsolutePath().endsWith(SVG_EXT))
			sf = new File(sf.getAbsolutePath() + SVG_EXT);
		
		if(sf.exists()){
			int result = JOptionPane.showConfirmDialog(filePane, "File already exist, overwrite?", "alert", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.NO_OPTION)
				return;
		}
		
		try {
			//view.getKernel().getModelPanel().clearBuffer();
			DOMImplementation impl = GenericDOMImplementation.getDOMImplementation();
			String svgNS = "http://www.w3.org/2000/svg";
			Document myFactory = impl.createDocument(svgNS, "svg", null);
			SVGGeneratorContext ctx = SVGGeneratorContext.createDefault(myFactory);
			ctx.setEmbeddedFontsOn(true);
			SVGGraphics2D g2 = new SVGGraphics2D(ctx,true);
			//view.getKernel().getModelPanel().paintComponents(g2);
			//view.getKernel().getModelPanel().paint(g2);
			FileOutputStream fout = new FileOutputStream(sf);
			Writer out = new OutputStreamWriter(fout, "UTF-8");
			g2.stream(out, true);
			fout.close();
			Context.eINSTANCE.getConfig().saveLastLocation(sf.getAbsolutePath());
		} catch (Exception ex) {
			Context.eINSTANCE.logger.error("", ex);
			StaticUICommands.showMessageErrorDialog(filePane, ex, "can not export a model");
		}
	}
}