package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.loader.CVLView;
import no.sintef.bvr.tool.ui.loader.Main;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.elements.ChoicePanel;
import bvr.ConfigurableUnit;
import bvr.NamedElement;
import bvr.VSpec;

public class PasteChildEvent implements ActionListener {

	private Object p;
	private Map<JComponent, NamedElement> vmMap;
	private CVLView view;

	public PasteChildEvent(Object cp, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		this.p = cp;
		this.vmMap = vmMap;
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		NamedElement v = vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
		// Modify model
		if(Main.vSpecCut != null){
			if(v != null){
				if(v instanceof VSpec && Main.vSpecCut instanceof VSpec)
					((VSpec)v).getChild().add((VSpec)Main.vSpecCut);
			}else{
				ConfigurableUnit cu = view.getCU();
				if(Main.vSpecCut instanceof VSpec)
					cu.getOwnedVSpec().add((VSpec)Main.vSpecCut);
			}
			Main.vSpecCut = null;
		}
		
		// Regenerate view
		view.notifyVspecViewUpdate();
	}

}
