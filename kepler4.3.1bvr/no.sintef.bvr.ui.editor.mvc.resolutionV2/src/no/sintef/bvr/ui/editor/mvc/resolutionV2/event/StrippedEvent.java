package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRViewV2;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.commands.StripCommand;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.tools.Iterators;
import bvr.NamedElement;
import bvr.VSpec;
import bvr.VSpecResolution;

public class StrippedEvent implements ActionListener {
	private Object cp;
	private Map<JComponent, NamedElement> vmMap;
	private BVRViewV2 view;
	private VSpec x;

	public StrippedEvent(Object cp, Map<JComponent, NamedElement> vmMap, BVRViewV2 view, VSpec x) {
		this.cp = cp;
		this.vmMap = vmMap;
		this.view = view;
		this.x = x;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Object v = vmMap.get(cp);
		if (!view.getStripped().contains(v))
			Iterators.getInstance().iterateExisting(view, new StripCommand(), x, (VSpecResolution) v, true);
		view.refresh();
		}
	

}