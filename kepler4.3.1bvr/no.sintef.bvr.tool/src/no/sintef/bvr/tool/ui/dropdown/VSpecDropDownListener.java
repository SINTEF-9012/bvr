package no.sintef.bvr.tool.ui.dropdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.event.ExportModelImage;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;


public class VSpecDropDownListener extends MouseAdapter {
	private BVRNotifiableController bvrView;
	private BVRToolModel m;

	public VSpecDropDownListener(BVRToolModel m, /*ConfigurableUnit cu,*/ BVRNotifiableController bvrView) {
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
    public VSpecDropdown(BVRToolModel m, /*ConfigurableUnit cu,*/ BVRNotifiableController bvrView){
		JMenuItem saveasImage = new JMenuItem("Export Diagram as PNG ...");
		add(saveasImage);
		saveasImage.addActionListener(new ExportModelImage(bvrView.getKernel().getModelPanel(), m, null, null));
    }
}