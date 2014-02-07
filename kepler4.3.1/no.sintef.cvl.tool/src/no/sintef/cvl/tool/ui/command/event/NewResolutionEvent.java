package no.sintef.cvl.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;

import cvl.ChoiceResolutuion;
import cvl.ConfigurableUnit;
import cvl.CvlFactory;
import no.sintef.cvl.tool.ui.loader.CVLModel;
import no.sintef.cvl.tool.ui.loader.CVLView;

public class NewResolutionEvent implements ActionListener {
	private ConfigurableUnit cu;
	private CVLView v;

	public NewResolutionEvent(ConfigurableUnit cu, CVLView cvlView) {
		this.cu = cu;
		this.v = cvlView;
	}

	public void actionPerformed(ActionEvent arg0) {
	
		ChoiceResolutuion cr = CvlFactory.eINSTANCE.createChoiceResolutuion();
		cu.getOwnedVSpecResolution().add(cr);
		
		v.notifyResolutionViewUpdate();
	}

}
