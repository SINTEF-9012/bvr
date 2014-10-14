package no.sintef.bvr.tool.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.loader.BVRToolModel;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.NamedElement;
import bvr.VSpec;

public class SwingVSpecController<GIU_NODE extends JComponent> implements VSpecControllerInterface<GIU_NODE> {

	private Map<JComponent, NamedElement> vspecvmMap;
	private List<JComponent> vspecNodes;
	private List<Pair<JComponent, JComponent>> vspecBindings;
	private BVRToolModel toolModel;
	private BVRNotifiableController rootController;
	
	public SwingVSpecController(BVRToolModel model, Map<JComponent, NamedElement> a, List<JComponent> b, List<Pair<JComponent,JComponent>> c) {
		toolModel = model;
		vspecvmMap = a;
		vspecNodes = b;
		vspecBindings = c;
	}
	
	public SwingVSpecController(BVRToolModel model, BVRNotifiableController notifiableController) {
		toolModel = model;
		vspecvmMap = new HashMap<JComponent, NamedElement>();
		vspecNodes = new ArrayList<JComponent>();
		vspecBindings = new ArrayList<Pair<JComponent,JComponent>>();
		rootController = notifiableController;
	}
	
	@Override
	public void addChoice(GIU_NODE parent) {
		VSpec parentVSpec = (VSpec) vspecvmMap.get(parent);
		toolModel.addChoice(parentVSpec);
	}
	
	

}
