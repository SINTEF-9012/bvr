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





import no.sintef.bvr.tool.ui.command.event.ExportModelImage;
import no.sintef.bvr.tool.ui.command.event.NewResolvedResolutionEvent;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.loader.CalculateCost;
import no.sintef.bvr.tool.ui.loader.CalculateCoverage;
import no.sintef.bvr.tool.ui.loader.GenerateAllProducts;
import no.sintef.bvr.tool.ui.loader.GenerateCoveringArray;
import no.sintef.bvr.tool.ui.loader.ImportResolutions;
import no.sintef.bvr.tool.ui.loader.SATValidateResolutions;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.DeleteResolution;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.NewResolvedResolutionEvent;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.ToggleShowConstraintsEvent;
//import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.ToggleShowGroupEvent;
import bvr.BVRModel;
//import bvr.ConfigurableUnit;
import bvr.NamedElement;

public class ResolutionDropdownListener extends MouseAdapter {
	private BVRNotifiableController controller;
	private BVRToolModel m;
	private BVRModel bvrModel;
	private JTabbedPane resPane;
	Map<JComponent, NamedElement> vmMap;

	public ResolutionDropdownListener(BVRNotifiableController controller, BVRModel bvrModel, BVRToolModel m, JTabbedPane resPane, Map<JComponent, NamedElement> vmMap) {
		this.vmMap = vmMap;
		this.controller = controller;
		this.bvrModel= bvrModel;
		this.m = m;
		this.resPane = resPane;

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
		ResV2DropdownMenu menu = new ResV2DropdownMenu(m, bvrModel, controller, resPane, vmMap);
		
		menu.show(e.getComponent(), e.getX(), e.getY());
	}
}

class ResV2DropdownMenu extends JPopupMenu {

	public ResV2DropdownMenu(BVRToolModel m, BVRModel bvrModel, BVRNotifiableController bvrView, JTabbedPane resPane, Map<JComponent, NamedElement> vmMap) {

		JMenuItem newres = new JMenuItem("New");
		newres.addActionListener(new NewResolvedResolutionEvent(bvrView));
		add(newres);
		if (!(bvrModel.getResolutionModels().size() == 0)) {
			JMenuItem remove = new JMenuItem("Remove");
		//TODO	remove.addActionListener(new DeleteResolution(bvrView)); //TODO add new DeleteResolution, or merge new and old editors
			add(remove);
		}
		JMenuItem importres = new JMenuItem("Import ...");
		importres.addActionListener(new ImportResolutions(m, bvrView));
		add(importres);
 
		/* Choice-only options */{
			JMenu camenu = new JMenu("Models with Choices Only");
			JMenuItem satvalres = new JMenuItem("Validate Resolutions");
			satvalres.addActionListener(new SATValidateResolutions(m, bvrView));
			camenu.add(satvalres);
			JMenu cc1 = new JMenu("Calculate Coverage");
			JMenuItem calccov1 = new JMenuItem("1-wise");
			calccov1.addActionListener(new CalculateCoverage(m, bvrView, 1));
			cc1.add(calccov1);
			JMenuItem calccov2 = new JMenuItem("2-wise");
			calccov2.addActionListener(new CalculateCoverage(m, bvrView, 2));
			cc1.add(calccov2);
			JMenuItem calccov3 = new JMenuItem("3-wise");
			calccov3.addActionListener(new CalculateCoverage(m, bvrView, 3));
			cc1.add(calccov3);
			camenu.add(cc1);

			JMenuItem calcall = new JMenuItem("Generate All Possible Products");
			calcall.addActionListener(new GenerateAllProducts(m, bvrView));
			camenu.add(calcall);

			camenu.add(new JSeparator());

			JMenu genca = new JMenu("Generate Covering Array");
			JMenuItem genca1 = new JMenuItem("1-wise");
			genca1.addActionListener(new GenerateCoveringArray(m, bvrView, 1));
			genca.add(genca1);
			JMenuItem genca2 = new JMenuItem("2-wise");
			genca2.addActionListener(new GenerateCoveringArray(m, bvrView, 2));
			genca.add(genca2);
			JMenuItem genca3 = new JMenuItem("3-wise");
			genca3.addActionListener(new GenerateCoveringArray(m, bvrView, 3));
			genca.add(genca3);
			camenu.add(genca);

			camenu.add(new JSeparator());
			add(new JSeparator());

			JMenuItem calcost = new JMenuItem("Calculate Costs");
			calcost.addActionListener(new CalculateCost(m, bvrView));
			camenu.add(calcost);

			add(camenu);
		}

		add(new JSeparator());

		JMenuItem saveasImage = new JMenuItem("Export Diagram as PNG ...");
		add(saveasImage);
	//	saveasImage
	//			.addActionListener(new ExportModelImage(bvrView.getKernel().getModelPanel(), m, bvrView.getCU().getOwnedVSpecResolution(), resPane));

		JMenuItem showGrouping = new JMenuItem("Show/hide grouping");
		add(showGrouping);
	//TODO	showGrouping.addActionListener(new ToggleShowGroupEvent((BVRResolutionToolView) bvrView));

		JMenuItem showConstraints = new JMenuItem("Show/hide constraints");
		add(showConstraints);
	//TODO	showConstraints.addActionListener(new ToggleShowConstraintsEvent((BVRResolutionToolView) bvrView));
	}

	private static final long serialVersionUID = -4129916117036201146L;

}
