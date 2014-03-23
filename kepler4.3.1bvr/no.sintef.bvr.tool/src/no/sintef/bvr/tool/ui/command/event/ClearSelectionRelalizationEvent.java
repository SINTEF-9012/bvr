package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.tool.ui.loader.BVRView;

public class ClearSelectionRelalizationEvent implements ActionListener {

	private JTabbedPane filePane;
	private List<BVRView> views;
	public ClearSelectionRelalizationEvent(JTabbedPane filePane, List<BVRModel> models, List<BVRView> views){
		this.filePane = filePane;
		this.views = views;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = filePane.getSelectedIndex();
		//views.get(tab).notifyRelalizationViewReset();
		Context.eINSTANCE.clearHighlights();
	}

}
