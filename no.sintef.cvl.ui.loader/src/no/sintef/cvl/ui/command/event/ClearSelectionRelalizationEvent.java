package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTabbedPane;

import no.sintef.cvl.ui.common.ThirdpartyEditorSelector;
import no.sintef.cvl.ui.exception.NoEclipseDetectedException;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.logging.impl.Logging;

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
		try {
			ThirdpartyEditorSelector.getEditorSelector().clearHighlights();
		} catch (NoEclipseDetectedException e1) {
			Logging.getLogger().warn("can not clear highlighting due to : '" + e1.getMessage() + "'");
		}
	}

}
