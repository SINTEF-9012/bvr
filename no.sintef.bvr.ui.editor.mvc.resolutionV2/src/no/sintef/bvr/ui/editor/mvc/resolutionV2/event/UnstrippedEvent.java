package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.UnstripCommand;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Iterators;
import bvr.NamedElement;
import bvr.VSpec;
import bvr.VSpecResolution;

public class UnstrippedEvent implements ActionListener {
	private Object cp;
	private Map<JComponent, NamedElement> vmMap;
	private BVRView view;
	private VSpec x;

	public UnstrippedEvent(Object cp, Map<JComponent, NamedElement> vmMap, BVRView view, VSpec x) {
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
		(new Iterators()).iterateExisting(view, new UnstripCommand(), x, (VSpecResolution) v, true);
		//System.out.println("seting Unstriped");
	}
}