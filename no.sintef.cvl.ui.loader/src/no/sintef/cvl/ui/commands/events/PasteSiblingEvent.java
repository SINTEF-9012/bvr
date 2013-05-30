package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Main;
import no.sintef.cvl.ui.loader.Pair;

import org.eclipse.emf.common.util.EList;

import cvl.NamedElement;
import cvl.VSpec;

public class PasteSiblingEvent implements ActionListener {

	private JPanel p;
	private Map<JComponent, NamedElement> vmMap;
	private CVLView view;

	public PasteSiblingEvent(JPanel cp, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		this.p = cp;
		this.vmMap = vmMap;
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		VSpec v = (VSpec)vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
		// Find parent
		VSpec parent = null;
		for(NamedElement _c : vmMap.values()){
			if(_c instanceof VSpec){
				VSpec c = (VSpec)_c;
				if(c.getChild().contains(v))
					parent = c;
			}
		}
		
		// Modify model
		if(Main.vSpecCut != null){
			EList<VSpec> x = parent.getChild();
			int i = x.indexOf(v);
			if(Main.vSpecCut instanceof VSpec)
				x.add(i+1, (VSpec)Main.vSpecCut);
			//parent.getChild().add(Main.vSpecCut);
			Main.vSpecCut = null;
		}
		
		// Regenerate view
		view.notifyVspecViewUpdate();
	}

}
