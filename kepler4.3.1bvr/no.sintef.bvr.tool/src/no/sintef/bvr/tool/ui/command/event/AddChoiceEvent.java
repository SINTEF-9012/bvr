package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.Choice;
import bvr.ConfigurableUnit;
import bvr.NamedElement;
import bvr.VSpec;
import bvr.BvrFactory;


public class AddChoiceEvent implements ActionListener {
	private JComponent p;
	private Map<JComponent, NamedElement> vmMap;
	private BVRView view;

	public AddChoiceEvent(JComponent p, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRView view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	static int x = 1;

	public void actionPerformed(ActionEvent arg0) {
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		VSpec v = (VSpec)vmMap.get(p);
		
		// Modify model
		Choice c = BvrFactory.eINSTANCE.createChoice();
		c.setName("Choice"+x);
		x++;
		
		/*if(v != null){
			v.getChild().add(c);
		}else{
			ConfigurableUnit cu = view.getCU();
			cu.getOwnedVSpec().add(c);
		}*/
		if(v != null){
			Context.eINSTANCE.getEditorCommands().addChoice(c, v);
		}else{
			ConfigurableUnit cu = view.getCU();
			Context.eINSTANCE.getEditorCommands().addChoice(c, cu);
		}
		
		// Regenerate view
		view.notifyVspecViewUpdate();
	}
}
