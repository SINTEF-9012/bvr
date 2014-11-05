package no.sintef.bvr.tool.ui.dropdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

import no.sintef.bvr.tool.ui.command.event.DeleteResolution;
import no.sintef.bvr.tool.ui.command.event.ExportModelImage;
import no.sintef.bvr.tool.ui.command.event.NewResolvedResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.ToggleShowConstraintsEvent;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.loader.CalculateCost;
import no.sintef.bvr.tool.ui.loader.CalculateCoverage;
import no.sintef.bvr.tool.ui.loader.GenerateAllProducts;
import no.sintef.bvr.tool.ui.loader.GenerateCoveringArray;
import no.sintef.bvr.tool.ui.loader.ImportResolutions;
import no.sintef.bvr.tool.ui.loader.SATValidateResolutions;

import bvr.BVRModel;
import bvr.NamedElement;

public class ResolutionDropdownListener extends MouseAdapter {
	private static final long serialVersionUID = -4129916117036201146L;
	
	private BVRNotifiableController controller;


	public ResolutionDropdownListener(BVRNotifiableController controller) {
		this.controller = controller;
	}

	public void mousePressed(MouseEvent e) {
		if (e.isPopupTrigger())
			doPop(e);
	}

	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger())
			doPop(e);
	}

	private void doPop(MouseEvent e) {
		ResV2DropdownMenu menu = new ResV2DropdownMenu(controller);
		
		menu.show(e.getComponent(), e.getX(), e.getY());
	}
}

class ResV2DropdownMenu extends JPopupMenu {

	public ResV2DropdownMenu(BVRNotifiableController controller) {

		JMenuItem newres = new JMenuItem("New");
		newres.addActionListener(new NewResolvedResolutionEvent(controller));
		add(newres);
		if (controller.getResolutionControllerInterface().isResolutionModelSet()) {
			JMenuItem remove = new JMenuItem("Remove");
			remove.addActionListener(new DeleteResolution(controller));
			add(remove);
		}
		JMenuItem importres = new JMenuItem("Import ...");
		importres.addActionListener(new ImportResolutions(controller));
		add(importres);
 
		/* Choice-only options */{
			JMenu camenu = new JMenu("Models with Choices Only");
			JMenuItem satvalres = new JMenuItem("Validate Resolutions");
			satvalres.addActionListener(new SATValidateResolutions(controller));
			camenu.add(satvalres);
			JMenu cc1 = new JMenu("Calculate Coverage");
			JMenuItem calccov1 = new JMenuItem("1-wise");
			calccov1.addActionListener(new CalculateCoverage(controller, 1));
			cc1.add(calccov1);
			JMenuItem calccov2 = new JMenuItem("2-wise");
			calccov2.addActionListener(new CalculateCoverage(controller, 2));
			cc1.add(calccov2);
			JMenuItem calccov3 = new JMenuItem("3-wise");
			calccov3.addActionListener(new CalculateCoverage(controller, 3));
			cc1.add(calccov3);
			camenu.add(cc1);

			JMenuItem calcall = new JMenuItem("Generate All Possible Products");
			calcall.addActionListener(new GenerateAllProducts(controller));
			camenu.add(calcall);

			camenu.add(new JSeparator());

			JMenu genca = new JMenu("Generate Covering Array");
			JMenuItem genca1 = new JMenuItem("1-wise");
			genca1.addActionListener(new GenerateCoveringArray(controller, 1));
			genca.add(genca1);
			JMenuItem genca2 = new JMenuItem("2-wise");
			genca2.addActionListener(new GenerateCoveringArray(controller, 2));
			genca.add(genca2);
			JMenuItem genca3 = new JMenuItem("3-wise");
			genca3.addActionListener(new GenerateCoveringArray(controller, 3));
			genca.add(genca3);
			camenu.add(genca);

			camenu.add(new JSeparator());
			add(new JSeparator());

			JMenuItem calcost = new JMenuItem("Calculate Costs");
			calcost.addActionListener(new CalculateCost(controller));
			camenu.add(calcost);

			add(camenu);
		}

		add(new JSeparator());

		JMenuItem saveasImage = new JMenuItem("Export Diagram as PNG ...");
		add(saveasImage);
		saveasImage.addActionListener(new ExportModelImage(controller));

		JMenuItem showGrouping = new JMenuItem("Show/hide grouping");
		add(showGrouping);
	//TODO	showGrouping.addActionListener(new ToggleShowGroupEvent((BVRResolutionToolView) bvrView));

		JMenuItem showConstraints = new JMenuItem("Show/hide constraints");
		add(showConstraints);
		showConstraints.addActionListener(new ToggleShowConstraintsEvent(controller));
	}
}
