package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRToolView;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.BVRModel;
import bvr.CompoundNode;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.BvrFactory;


public class AddClassifierEvent implements ActionListener {
	private JComponent p;
	private Map<JComponent, NamedElement> vmMap;
	private BVRToolView view;

	public AddClassifierEvent(JComponent p, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRToolView view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	static int x = 1;

	public void actionPerformed(ActionEvent arg0) {
		VSpec v = (VSpec)vmMap.get(p);
		
		VClassifier c = BvrFactory.eINSTANCE.createVClassifier();
		c.setName("Classifier"+x);
		MultiplicityInterval mi = BvrFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(1);
		mi.setUpper(1);
		c.setInstanceMultiplicity(mi);
		x++;
		
		if(v != null){
			Context.eINSTANCE.getEditorCommands().addVClassifierToVSpec((CompoundNode) v, c);
		}else{
			BVRModel model = view.getBVRModel();
			if(model.getVariabilityModel() == null)
				Context.eINSTANCE.getEditorCommands().addVClassifierToBVRModel(model, c);
		}
	}

}
