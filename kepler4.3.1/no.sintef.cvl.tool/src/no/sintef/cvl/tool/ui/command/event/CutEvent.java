package no.sintef.cvl.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

import no.sintef.cvl.tool.ui.loader.CVLView;
import no.sintef.cvl.tool.ui.loader.Main;
import no.sintef.cvl.tool.ui.loader.Pair;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import cvl.ConfigurableUnit;
import cvl.NamedElement;
import cvl.VSpec;

public class CutEvent implements ActionListener {

	private Map<JComponent, NamedElement> vmMap;
	private JPanel p;
	private CVLView view;

	public CutEvent(JPanel cp, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		this.p = cp;
		this.vmMap = vmMap;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		NamedElement v = vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
		// Modify model
		VSpec parent = null;
		for(NamedElement _c : vmMap.values()){
			if(_c instanceof VSpec){
				VSpec c = (VSpec)_c;
				if(c.getChild().contains(v))
					parent = c;
			}
		}
		
		if(parent != null){
			parent.getChild().remove(v);
		}else{
			ConfigurableUnit cu = view.getCU();
			cu.getOwnedVSpec().remove(v);
		}
		
		// Save cut
		Main.vSpecCut = v;
		
		// Regenerate view
		view.notifyVspecViewUpdate();
	}

}
