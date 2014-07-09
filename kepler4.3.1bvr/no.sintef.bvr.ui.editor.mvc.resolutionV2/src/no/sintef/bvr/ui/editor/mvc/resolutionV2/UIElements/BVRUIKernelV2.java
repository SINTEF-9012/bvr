package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import bvr.NamedElement;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.framework.elements.ConfigurableUnitPanel;

public class BVRUIKernelV2 extends BVRUIKernel {
	
	private BVREditorPanel editorPanel;
	private ConfigurableUnitPanel modelPanel;
	private BVRView view;
	
	public BVRUIKernelV2(Map<JComponent, NamedElement> vmMap, BVRView view, List<Map<JComponent, NamedElement>> resolutionvmMaps) {
		super(vmMap, view, resolutionvmMaps);
		this.view = view;
		modelPanel = new ConfigurableUnitPanel();
		editorPanel = new BVREditorPanelV2(this, vmMap, view, resolutionvmMaps);
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
