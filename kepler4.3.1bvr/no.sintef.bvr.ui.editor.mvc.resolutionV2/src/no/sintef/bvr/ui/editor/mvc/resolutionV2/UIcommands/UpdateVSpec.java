package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import bvr.NamedElement;
import bvr.VSpec;

public class UpdateVSpec implements UICommand {

	protected BVRUIKernel rootPanel;
	protected JComponent parent;
	protected NamedElement vc;
	protected Map<JComponent, NamedElement> vmMap;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;
	protected BVRNotifiableController view;
	
	protected String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public UICommand init(BVRUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, BVRResolutionToolView view) {
		
		//System.out.println("p: " + p);
		//System.out.println("p instanceof VSpec: " + (p instanceof VSpec));
		
		if(p instanceof NamedElement){
			this.rootPanel = rootPanel;
			this.vc = (NamedElement) p;
			this.parent = parent;
			
			this.name = vc.getName();
		}
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.view = view;
		
		return this;
		
	}

	public JComponent execute() {
		//System.out.println("vc: " + vc);
		//vc.setName(name);
		//view.notifyVspecViewUpdate();
		Context.eINSTANCE.getEditorCommands().setName(vc, name);
		
		return null;
	}

	public void setComment(String text) {
		//((VSpec)vc).setComment(text);
		Context.eINSTANCE.getEditorCommands().setVSpecComment((VSpec)vc, text);
	}

}
