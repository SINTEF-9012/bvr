package no.sintef.cvl.ui.commands;

import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JComponent;

import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.loader.Main;
import cvl.VClassifier;
import cvl.VSpec;

public class UpdateVClassifier implements Command {
	
	VClassifier vc;
	Map<JComponent, VSpec> vmMap;
	
	String name;
	int lower;
	int upper;
	
	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, VSpec> vmMap) {
		if(p instanceof VClassifier){
			this.vc = (VClassifier) p;
			this.vmMap = vmMap;
		}		
		
		return this;
	}
	
	public JComponent execute() {
		JComponent c = null;
		for(Entry<JComponent, VSpec> e : vmMap.entrySet()) {
			if (e.getValue() == vc) {
				c = e.getKey();
				break;
			}
		}
		
		vc.setName(name);
		vc.getInstanceMultiplicity().setLower(lower);
		vc.getInstanceMultiplicity().setUpper(upper);
		
		// Regenerate view
		Main.notifyViewUpdate();
		return c;
	}

}
