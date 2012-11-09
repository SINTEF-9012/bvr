package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Main;
import no.sintef.cvl.ui.loader.Pair;

import org.eclipse.emf.common.util.EList;

import cvl.VSpec;

public class PasteSiblingEvent implements ActionListener {

	private ChoicePanel p;
	private Map<JComponent, VSpec> vmMap;
	private CVLView view;

	public PasteSiblingEvent(ChoicePanel cp, Map<JComponent, VSpec> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		this.p = cp;
		this.vmMap = vmMap;
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		VSpec v = vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
		// Find parent
		VSpec parent = null;
		for(VSpec c : vmMap.values()){
			if(c.getChild().contains(v))
				parent = c;
		}
		
		// Modify model
		if(Main.vSpecCut != null){
			EList<VSpec> x = parent.getChild();
			int i = x.indexOf(v);
			x.add(i+1, Main.vSpecCut);
			//parent.getChild().add(Main.vSpecCut);
			Main.vSpecCut = null;
		}
		
		// Regenerate view
		view.notifyViewUpdate();
	}

}
