package no.sintef.bvr.tool.ui.dropdown;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.ui.command.event.ExecuteResolutionEvent;
import no.sintef.bvr.tool.ui.loader.BVRView;

public class ResolutionPanelDropDown extends JPopupMenu {

	private static final long serialVersionUID = 5430986678350903339L;

	public ResolutionPanelDropDown(BVRView _view){
		
		JMenuItem executeProduct = new JMenuItem(Constants.RESOLUTION_EXECUTE_PRODUCT);
		executeProduct.addActionListener(new ExecuteResolutionEvent(_view));
		add(executeProduct);
	}
}
