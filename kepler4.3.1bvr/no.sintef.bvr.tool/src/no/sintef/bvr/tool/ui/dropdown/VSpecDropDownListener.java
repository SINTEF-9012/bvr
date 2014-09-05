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
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupToAltEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupToNoneEvent;
import no.sintef.bvr.tool.ui.command.event.SetGroupToOrEvent;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;
import no.sintef.bvr.tool.ui.loader.BVRToolView;
import no.sintef.bvr.tool.ui.loader.CalculateCoverage;
import no.sintef.bvr.tool.ui.loader.GenerateCoveringArray;
import no.sintef.bvr.tool.ui.loader.ImportResolutions;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.tool.ui.loader.SATValidateResolutions;
import no.sintef.bvr.tool.ui.loader.ValidateResolution;
import no.sintef.bvr.ui.framework.elements.VClassifierPanel;
import bvr.VSpec;
import bvr.VSpecResolution;

public class VSpecDropDownListener extends MouseAdapter {
	private BVRToolView bvrView;
	private BVRToolModel m;

	public VSpecDropDownListener(BVRToolModel m, /*ConfigurableUnit cu,*/ BVRToolView bvrView) {
		this.m = m;
		//this.cu = cu;
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
    	//VSpecDropdown menu = new VSpecDropdown(m, cu, bvrView);
        //menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class VSpecDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public VSpecDropdown(BVRToolModel m, /*ConfigurableUnit cu,*/ BVRToolView bvrView){
		JMenuItem saveasImage = new JMenuItem("Export Diagram as PNG ...");
		add(saveasImage);
		saveasImage.addActionListener(new ExportModelImage(bvrView.getKernel().getModelPanel(), m, null, null));
    }
}