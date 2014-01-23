package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;

import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.BvrFactory;
import no.sintef.bvr.tool.ui.loader.CVLModel;
import no.sintef.bvr.tool.ui.loader.CVLView;

public class NewResolutionEvent implements ActionListener {
	private ConfigurableUnit cu;
	private CVLView v;

	public NewResolutionEvent(ConfigurableUnit cu, CVLView bvrView) {
		this.cu = cu;
		this.v = bvrView;
	}

	public void actionPerformed(ActionEvent arg0) {
	
		ChoiceResolutuion cr = BvrFactory.eINSTANCE.createChoiceResolutuion();
		cu.getOwnedVSpecResolution().add(cr);
		
		v.notifyResolutionViewUpdate();
	}

}
