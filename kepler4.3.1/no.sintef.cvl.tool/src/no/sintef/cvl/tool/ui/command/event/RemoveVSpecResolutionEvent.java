package no.sintef.cvl.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.tool.ui.loader.CVLView;
import cvl.ConfigurableUnit;
import cvl.NamedElement;
import cvl.VSpecResolution;

public class RemoveVSpecResolutionEvent implements ActionListener  {
	private JComponent p;
	private Map<JComponent, NamedElement> vmMap;
	private CVLView view;

	public RemoveVSpecResolutionEvent(JComponent p, Map<JComponent, NamedElement> vmMap, CVLView view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		NamedElement v = vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
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
			parent.getChild().remove(v);
		}else if(cuParent == null){
			ConfigurableUnit cu = view.getCU();
			cu.getOwnedVSpecResolution().remove(v);
		}
		
		// Regenerate view
		view.notifyResolutionViewUpdate();
	}
}
