package no.sintef.bvr.tool.ui.dropdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.command.event.ExportModelImage;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;


public class VSpecDropDownListener extends MouseAdapter {
	private BVRNotifiableController controller;
	private BVRToolModel toolModel;
	private BVRUIKernel kernel;

	public VSpecDropDownListener(BVRUIKernel kernel, BVRToolModel m, BVRNotifiableController controller) {
		this.kernel = kernel;
		this.toolModel = m;
		this.controller = controller;
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
    	VSpecDropdown menu = new VSpecDropdown(kernel, toolModel, controller);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class VSpecDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public VSpecDropdown(BVRUIKernel kernel, BVRToolModel toolmodel, BVRNotifiableController bvrView){
		JMenuItem saveasImage = new JMenuItem("Export Diagram as PNG ...");
		add(saveasImage);
		saveasImage.addActionListener(new ExportModelImage(bvrView));
    }
}
