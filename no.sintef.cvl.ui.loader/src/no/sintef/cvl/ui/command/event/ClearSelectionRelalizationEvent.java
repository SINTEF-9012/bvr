package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;

public class ClearSelectionRelalizationEvent implements ActionListener {

	private JTabbedPane filePane;
	private List<CVLView> views;
	public ClearSelectionRelalizationEvent(JTabbedPane filePane, List<CVLModel> models, List<CVLView> views){
		this.filePane = filePane;
		this.views = views;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int tab = filePane.getSelectedIndex();
		views.get(tab).notifyRelalizationViewReset();
		Context.eINSTANCE.clearHighlights();
	}

}
