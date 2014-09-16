package no.sintef.bvr.tool.ui.editor;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import bvr.NamedElement;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;
import no.sintef.bvr.tool.ui.loader.BVRToolView;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;

public class BVRUIKernel {
	
	private BVREditorPanel editorPanel;
	private BVRModelPanel modelPanel;
	private BVRToolView view;
	
	public BVRUIKernel(Map<JComponent, NamedElement> vmMap, BVRToolView view, List<Map<JComponent, NamedElement>> resolutionvmMaps) {
		this.view = view;
		modelPanel = new BVRModelPanel();
		editorPanel = new BVREditorPanel(this, vmMap, view, resolutionvmMaps);
	}
	
	public BVREditorPanel getEditorPanel() {
		return editorPanel;
	}
	public void setEditorPanel(BVREditorPanel editorPanel) {
		this.editorPanel = editorPanel;
	}
	public BVRModelPanel getModelPanel() {
		return modelPanel;
	}


}
