package no.sintef.bvr.tool.ui.dropdown;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.ui.command.event.DeleteResolution;
import no.sintef.bvr.tool.ui.command.event.ExecuteResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.ExportModelImage;
import no.sintef.bvr.tool.ui.loader.BVRResolutionView;
import no.sintef.bvr.tool.ui.loader.BVRView;

public class ResolutionPanelDropDown extends JPopupMenu {

	private static final long serialVersionUID = 5430986678350903339L;

	public ResolutionPanelDropDown(BVRView _view){
		
		JMenuItem removeResolution = new JMenuItem(Constants.RESOLUTION_REMOVE);
		removeResolution.addActionListener(new DeleteResolution(_view));
		add(removeResolution);
		
		add(new JSeparator());
		
		JMenuItem saveasImage = new JMenuItem(Constants.RESOLUTION_EXPORT_PNG);
		add(saveasImage);
		saveasImage.addActionListener(new ExportModelImage(_view.getKernel().getModelPanel(), _view.getModel(), _view.getCU().getOwnedVSpecResolution(), ((BVRResolutionView) _view).getResolutionPane()));
		
		add(new JSeparator());
		
		JMenuItem executeProduct = new JMenuItem(Constants.RESOLUTION_EXECUTE_PRODUCT);
		executeProduct.addActionListener(new ExecuteResolutionEvent(_view));
		add(executeProduct);
	}
}
