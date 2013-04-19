package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Main;
import no.sintef.cvl.ui.loader.Pair;
import cvl.ConfigurableUnit;
import cvl.NamedElement;
import cvl.VSpec;

public class RemoveChoiceEvent implements ActionListener {
	private JComponent p;
	private Map<JComponent, NamedElement> vmMap;
	private CVLView view;

	public RemoveChoiceEvent(JComponent p, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		VSpec v = (VSpec)vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
		// Modify model
		VSpec parent = null;
		for(NamedElement _c : vmMap.values()){
			VSpec c = (VSpec)_c;
			if(c.getChild().contains(v))
				parent = c;
		}
		if(parent != null){
			parent.getChild().remove(v);
		}else{
			ConfigurableUnit cu = view.getCU();
			cu.getOwnedVSpec().remove(v);
		}
		
		// Regenerate view
		view.notifyVspecViewUpdate();
	}
}
