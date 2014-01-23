package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.loader.CVLView;
import no.sintef.bvr.tool.ui.loader.Main;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.BCLConstraint;
import bvr.ConfigurableUnit;
import bvr.NamedElement;
import bvr.VSpec;

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
		NamedElement v = vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
		// Modify model
		VSpec parent = null;
		ConfigurableUnit cuParent = null;
		for(NamedElement _c : vmMap.values()){
			if(_c instanceof VSpec){
				VSpec c = (VSpec)_c;
				if(c.getChild().contains(v))
					parent = c;
			}else if(_c instanceof BCLConstraint){
				if(view.getCU().getOwnedConstraint().contains(v))
					cuParent = view.getCU();
			}else{
				throw new UnsupportedOperationException();
			}
		}
		if(parent != null){
			parent.getChild().remove(v);
		}else if(cuParent == null){
			ConfigurableUnit cu = view.getCU();
			cu.getOwnedVSpec().remove(v);
		}else{
			cuParent.getOwnedConstraint().remove(v);
		}
		
		// Regenerate view
		view.notifyVspecViewUpdate();
	}
}
