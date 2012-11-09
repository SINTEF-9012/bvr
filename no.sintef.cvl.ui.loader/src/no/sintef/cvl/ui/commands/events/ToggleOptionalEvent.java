package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Main;
import no.sintef.cvl.ui.loader.Pair;
import cvl.Choice;
import cvl.VSpec;

public class ToggleOptionalEvent implements ActionListener {
	private ChoicePanel p;
	private Map<JComponent, VSpec> vmMap;
	private CVLView view;

	public ToggleOptionalEvent(ChoicePanel p, Map<JComponent, VSpec> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Choice v = (Choice)vmMap.get(p);
		
		// Modify model
		v.setIsImpliedByParent(!v.isIsImpliedByParent());
		
		// Regenerate view
		view.notifyViewUpdate();
	}
}
