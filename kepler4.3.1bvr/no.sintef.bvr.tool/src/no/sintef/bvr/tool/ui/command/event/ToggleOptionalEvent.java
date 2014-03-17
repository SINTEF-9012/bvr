package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.loader.Main;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;
import bvr.Choice;
import bvr.NamedElement;
import bvr.VSpec;

public class ToggleOptionalEvent implements ActionListener {
	private ChoicePanel p;
	private Map<JComponent, NamedElement> vmMap;
	private BVRView view;

	public ToggleOptionalEvent(ChoicePanel p, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRView view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Choice v = (Choice)vmMap.get(p);
		
		// Modify model
		//v.setIsImpliedByParent(!v.isIsImpliedByParent());
		Context.eINSTANCE.getEditorCommands().setIsImpliedByParent(v, !v.isIsImpliedByParent());
		
		// Regenerate view
		//view.notifyVspecViewUpdate();
	}
}
