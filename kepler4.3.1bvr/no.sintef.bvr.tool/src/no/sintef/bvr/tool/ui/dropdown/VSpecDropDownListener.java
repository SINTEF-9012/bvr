package no.sintef.bvr.tool.ui.dropdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.ui.command.DelAllResEvent;
import no.sintef.bvr.tool.ui.command.DelResEvent;
import no.sintef.bvr.tool.ui.command.event.AddChoiceEvent;
import no.sintef.bvr.tool.ui.command.event.AddClassifierEvent;
import no.sintef.bvr.tool.ui.command.event.ExecuteResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.ExportModelImage;
import no.sintef.bvr.tool.ui.command.event.ExportModelSVG;
import no.sintef.bvr.tool.ui.command.event.NewResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.RemoveChoiceEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupToAltEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupToNoneEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupToOrEvent;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.loader.CalculateCoverage;
import no.sintef.bvr.tool.ui.loader.GenerateCoveringArray;
import no.sintef.bvr.tool.ui.loader.ImportResolutions;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.tool.ui.loader.SATValidateResolutions;
import no.sintef.bvr.tool.ui.loader.ValidateResolution;
import no.sintef.bvr.ui.framework.elements.VClassifierPanel;
import bvr.ConfigurableUnit;
import bvr.VSpec;
import bvr.VSpecResolution;

public class VSpecDropDownListener extends MouseAdapter {
	private BVRView bvrView;
	private ConfigurableUnit cu;
	private BVRModel m;

	public VSpecDropDownListener(BVRModel m, ConfigurableUnit cu, BVRView bvrView) {
		this.m = m;
		this.cu = cu;
		this.bvrView = bvrView;
		this.bvrView = bvrView;
	}

	public void mousePressed(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    private void doPop(MouseEvent e){
    	VSpecDropdown menu = new VSpecDropdown(m, cu, bvrView);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class VSpecDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public VSpecDropdown(BVRModel m, ConfigurableUnit cu, BVRView bvrView){
		JMenuItem saveasImage = new JMenuItem("Export Diagram as PNG ...");
		add(saveasImage);
		saveasImage.addActionListener(new ExportModelImage(bvrView.getKernel().getModelPanel(), m, null, null));
		/*JMenuItem saveasSVG = new JMenuItem("Export Diagram as SVG ...");
		add(saveasSVG);
		saveasSVG.addActionListener(new ExportModelSVG(bvrView, m));
		*/
    }
}