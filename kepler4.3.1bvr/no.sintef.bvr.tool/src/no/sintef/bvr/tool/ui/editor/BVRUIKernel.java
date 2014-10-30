package no.sintef.bvr.tool.ui.editor;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import bvr.NamedElement;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;

public class BVRUIKernel {
	
	private BVREditorPanel editorPanel;
	private BVRModelPanel modelPanel;
	
	public BVRUIKernel(Map<JComponent, NamedElement> vmMap, BVRNotifiableController controller, List<Map<JComponent, NamedElement>> resolutionvmMaps) {
		modelPanel = new BVRModelPanel();
		editorPanel = new BVREditorPanel(this, controller);
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
