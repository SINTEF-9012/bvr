package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRToolView;
import bvr.NamedElement;
import bvr.VSpecResolution;

public class RemoveVSpecResolutionEvent implements ActionListener  {
	private JComponent p;
	private Map<JComponent, NamedElement> vmMap;
	private BVRToolView view;

	public RemoveVSpecResolutionEvent(JComponent p, Map<JComponent, NamedElement> vmMap, BVRToolView view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		/*NamedElement v = vmMap.get(p);
		
		// Modify model
		VSpecResolution parent = null;
		ConfigurableUnit cuParent = null;
		for(NamedElement _c : vmMap.values()){
			if(_c instanceof VSpecResolution){
				VSpecResolution c = (VSpecResolution)_c;
				if(c.getChild().contains(v))
					parent = c;
			}else{
				throw new UnsupportedOperationException();
			}
		}
		if(parent != null){
			//parent.getChild().remove(v);
			Context.eINSTANCE.getEditorCommands().removeNamedElementVSpecResolution(parent, v);
		}else if(cuParent == null){
			ConfigurableUnit cu = view.getCU();
			//cu.getOwnedVSpecResolution().remove(v);
			Context.eINSTANCE.getEditorCommands().removeOwnedVSpecResolutionConfigurableUnit(cu, v);
		}*/
	}
}
