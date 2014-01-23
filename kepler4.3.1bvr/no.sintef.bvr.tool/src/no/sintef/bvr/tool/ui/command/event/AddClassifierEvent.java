package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.loader.Main;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.ConfigurableUnit;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.BvrFactory;


public class AddClassifierEvent implements ActionListener {
	private JComponent p;
	private Map<JComponent, NamedElement> vmMap;
	private BVRView view;

	public AddClassifierEvent(JComponent p, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRView view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	static int x = 1;

	public void actionPerformed(ActionEvent arg0) {
		VSpec v = (VSpec)vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
		// Modify model
		VClassifier c = BvrFactory.eINSTANCE.createVClassifier();
		c.setName("Classifier"+x);
		MultiplicityInterval mi = BvrFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(1);
		mi.setUpper(1);
		c.setInstanceMultiplicity(mi);
		x++;
		
		if(v != null){
			v.getChild().add(c);
		}else{
			ConfigurableUnit cu = view.getCU();
			cu.getOwnedVSpec().add(c);
		}
		
		// Regenerate view
		view.notifyVspecViewUpdate();
	}

}
