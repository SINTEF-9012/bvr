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

public class VSpecResDropDownListener extends MouseAdapter {
	private VSpecResolution v;
	private BVRView bvrView;
	private ConfigurableUnit cu;
	private BVRModel m;

	public VSpecResDropDownListener(BVRModel m, ConfigurableUnit cu, BVRView bvrView) {
		this.m = m;
		this.cu = cu;
		this.v = v;
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
    	VSpecResDropdown menu = new VSpecResDropdown(m, cu, v, bvrView);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class VSpecResDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public VSpecResDropdown(BVRModel m, ConfigurableUnit cu, VSpecResolution v, BVRView bvrView){
    	/*JMenuItem del = new JMenuItem("delete");
    	del.addActionListener(new DelResEvent(cu, v, bvrView));
		add(del);
		*/
		
		// Resolutions
		JMenuItem newres = new JMenuItem("New");
		newres.addActionListener(new NewResolutionEvent(cu, bvrView));
		add(newres);
		add(new JSeparator());
		JMenuItem importres = new JMenuItem("Import ...");
		importres.addActionListener(new ImportResolutions(m, bvrView));
		add(importres);
		//TODO: camenu.add(new JMenuItem("Export ..."));
/*		add(new JSeparator());
		JMenuItem valres = new JMenuItem("Validate Resolution");
		valres.addActionListener(new ValidateResolution(m, bvrView));
		add(valres);
*/		
		add(new JSeparator());
		
		JMenuItem delall = new JMenuItem("remove all");
		delall.addActionListener(new DelAllResEvent(cu, bvrView));
		add(delall);
		
		
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
			
			add(new JSeparator());
			add(camenu);
		}
		
		/* TODO
		add(new JSeparator());
		
		/* TODO
		JMenuItem execute = new JMenuItem(Constants.RESOLUTION_EXECUTE_NAME);
		execute.addActionListener(new ExecuteResolutionEvent(m, bvrView));
		add(execute);
		
		JMenuItem executeAll = new JMenuItem(Constants.RESOLUTION_EXECUTE_ALL_NAME);
		add(executeAll);
		*/
    }
}