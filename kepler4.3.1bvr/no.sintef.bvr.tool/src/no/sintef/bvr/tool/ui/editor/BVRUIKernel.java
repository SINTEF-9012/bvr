package no.sintef.bvr.tool.ui.editor;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import bvr.NamedElement;
import no.sintef.bvr.tool.ui.edit.CVLEditorPanel;
import no.sintef.bvr.tool.ui.loader.CVLView;
import no.sintef.bvr.ui.framework.elements.ConfigurableUnitPanel;

public class CVLUIKernel {
	
	private CVLEditorPanel editorPanel;
	private ConfigurableUnitPanel modelPanel;
	private CVLView view;
	
	public CVLUIKernel(Map<JComponent, NamedElement> vmMap, CVLView view, List<Map<JComponent, NamedElement>> resolutionvmMaps) {
		this.view = view;
		modelPanel = new ConfigurableUnitPanel();
		editorPanel = new CVLEditorPanel(this, vmMap, view, resolutionvmMaps);
	}
	
	public CVLEditorPanel getEditorPanel() {
		return editorPanel;
	}
	public void setEditorPanel(CVLEditorPanel editorPanel) {
		this.editorPanel = editorPanel;
	}
	public ConfigurableUnitPanel getModelPanel() {
		return modelPanel;
	}


}
