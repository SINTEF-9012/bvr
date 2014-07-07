package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.StripCommand;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Iterators;
import bvr.NamedElement;
import bvr.VSpec;
import bvr.VSpecResolution;

public class StrippedEvent implements ActionListener {
	private Object cp;
	private Map<JComponent, NamedElement> vmMap;
	private BVRView view;
	private VSpec x;

	public StrippedEvent(Object cp, Map<JComponent, NamedElement> vmMap, BVRView view, VSpec x) {
		this.cp = cp;
		this.vmMap = vmMap;
		this.view = view;
		this.x = x;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		Object v = vmMap.get(cp);
		
		//view.setStripped(v);
		
		//vsr = (VSpecResolution) ((ChoiceResolutuionImpl) v).getResolvedChoice();
		
		
		//System.out.println("object get "+ (System.currentTimeMillis()-i));
		
		//i = System.currentTimeMillis();
		(new Iterators()).iterateExisting(view, new StripCommand(), x, (VSpecResolution) v, true);
		view.refresh();
		//System.out.println("total time for stripped event = "+ (System.currentTimeMillis()-i));
		//System.out.println("seting striped");
	}
}