package no.sintef.bvr.tool.ui.editor;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import bvr.NamedElement;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.framework.elements.ConfigurableUnitPanel;

public class BVRUIKernel {
	
	private BVREditorPanel editorPanel;
	private ConfigurableUnitPanel modelPanel;
	private BVRView view;
	
	public BVRUIKernel(Map<JComponent, NamedElement> vmMap, BVRView view, List<Map<JComponent, NamedElement>> resolutionvmMaps) {
		this.view = view;
		modelPanel = new ConfigurableUnitPanel();
		editorPanel = new BVREditorPanel(this, vmMap, view, resolutionvmMaps);
	}
	
	public BVREditorPanel getEditorPanel() {
		return editorPanel;
	}
	public void setEditorPanel(BVREditorPanel editorPanel) {
		this.editorPanel = editorPanel;
	}
	public ConfigurableUnitPanel getModelPanel() {
		return modelPanel;
	}


}
