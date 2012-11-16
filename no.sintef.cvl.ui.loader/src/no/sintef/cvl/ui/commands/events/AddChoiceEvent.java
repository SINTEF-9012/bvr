package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Main;
import no.sintef.cvl.ui.loader.Pair;
import cvl.Choice;
import cvl.ConfigurableUnit;
import cvl.VSpec;
import cvl.cvlFactory;


public class AddChoiceEvent implements ActionListener {
	private JComponent p;
	private Map<JComponent, VSpec> vmMap;
	private CVLView view;

	public AddChoiceEvent(JComponent p, Map<JComponent, VSpec> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	static int x = 1;

	public void actionPerformed(ActionEvent arg0) {
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		VSpec v = vmMap.get(p);
		
		// Modify model
		Choice c = cvlFactory.eINSTANCE.createChoice();
		c.setName("Choice"+x);
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
