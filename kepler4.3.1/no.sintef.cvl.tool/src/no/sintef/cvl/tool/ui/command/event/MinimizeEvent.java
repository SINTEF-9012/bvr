package no.sintef.cvl.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.tool.ui.loader.CVLView;
import no.sintef.cvl.tool.ui.loader.Pair;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.framework.elements.VSpecPanel;
import cvl.CvlFactory;
import cvl.MultiplicityInterval;
import cvl.NamedElement;
import cvl.VSpec;

public class MinimizeEvent implements ActionListener {

	private VSpecPanel cp;
	private Map<JComponent, NamedElement> vmMap;
	private CVLView view;

	public MinimizeEvent(VSpecPanel cp, Map<JComponent, NamedElement> vmMap,List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		this.cp = cp;
		this.vmMap = vmMap;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		VSpec v = (VSpec)vmMap.get(cp);
		
		// Modify model
		view.setMinimized(v);
		
		// Regenerate view
		view.notifyVspecViewUpdate();
	}

}
