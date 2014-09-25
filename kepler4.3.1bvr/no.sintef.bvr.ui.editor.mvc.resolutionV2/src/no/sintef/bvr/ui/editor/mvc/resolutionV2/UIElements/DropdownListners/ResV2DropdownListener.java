package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.DropdownListners;

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
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.tool.ui.loader.CalculateCost;
import no.sintef.bvr.tool.ui.loader.CalculateCoverage;
import no.sintef.bvr.tool.ui.loader.GenerateAllProducts;
import no.sintef.bvr.tool.ui.loader.GenerateCoveringArray;
import no.sintef.bvr.tool.ui.loader.ImportResolutions;
import no.sintef.bvr.tool.ui.loader.SATValidateResolutions;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRViewV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.NewResolvedResolutionEvent;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.ToggleShowConstraintsEvent;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.event.ToggleShowGroupEvent;
import bvr.ConfigurableUnit;
import bvr.NamedElement;

public class ResV2DropdownListener extends MouseAdapter {
	private BVRViewV2 bvrViewV2;
	private ConfigurableUnit cu;
	private BVRModel m;
	private JTabbedPane resPane;
	Map<JComponent, NamedElement> vmMap;

	public ResV2DropdownListener(BVRViewV2 bvrView, ConfigurableUnit cu, BVRModel m, JTabbedPane resPane, Map<JComponent, NamedElement> vmMap) {
		this.vmMap = vmMap;
		this.bvrViewV2 = bvrView;
		this.cu = cu;
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
		ResV2DropdownMenu menu = new ResV2DropdownMenu(m, cu, bvrViewV2, resPane, vmMap);
		menu.show(e.getComponent(), e.getX(), e.getY());
	}
}

class ResV2DropdownMenu extends JPopupMenu {

	public ResV2DropdownMenu(BVRModel m, ConfigurableUnit cu, BVRViewV2 bvrView, JTabbedPane resPane, Map<JComponent, NamedElement> vmMap) {

		JMenuItem newres = new JMenuItem("New");
		newres.addActionListener(new NewResolvedResolutionEvent(cu, bvrView));
		add(newres);
		if (!(cu.getOwnedVSpecResolution().size() == 0)) {
			JMenuItem remove = new JMenuItem("Remove");
			remove.addActionListener(new DeleteResolution(bvrView));
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
		saveasImage
				.addActionListener(new ExportModelImage(bvrView.getKernel().getModelPanel(), m, bvrView.getCU().getOwnedVSpecResolution(), resPane));

		JMenuItem showGrouping = new JMenuItem("Show/hide grouping");
		add(showGrouping);
		showGrouping.addActionListener(new ToggleShowGroupEvent((BVRViewV2) bvrView));

		JMenuItem showConstraints = new JMenuItem("Show/hide constraints");
		add(showConstraints);
		showConstraints.addActionListener(new ToggleShowConstraintsEvent((BVRViewV2) bvrView));
	}

	private static final long serialVersionUID = -4129916117036201146L;

}
