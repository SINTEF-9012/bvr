package no.sintef.cvl.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.tool.ui.loader.VSpecView;
import no.sintef.cvl.tool.ui.loader.Main;
import no.sintef.cvl.tool.ui.loader.Pair;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import cvl.Choice;
import cvl.NamedElement;
import cvl.VSpec;

public class ToggleOptionalEvent implements ActionListener {
	private ChoicePanel p;
	private Map<JComponent, NamedElement> vmMap;
	private VSpecView view;

	public ToggleOptionalEvent(ChoicePanel p, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, VSpecView view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Choice v = (Choice)vmMap.get(p);
		
		// Modify model
		v.setIsImpliedByParent(!v.isIsImpliedByParent());
		
		// Regenerate view
		view.notifyVspecViewUpdate();
	}
}
