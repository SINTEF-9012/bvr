package no.sintef.cvl.tool.ui.editor;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import cvl.NamedElement;
import no.sintef.cvl.tool.ui.edit.CVLEditorPanel;
import no.sintef.cvl.tool.ui.loader.VSpecView;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;

public class CVLUIKernel {
	
	private CVLEditorPanel editorPanel;
	private ConfigurableUnitPanel modelPanel;
	private VSpecView view;
	
	public CVLUIKernel(Map<JComponent, NamedElement> vmMap, VSpecView view, List<Map<JComponent, NamedElement>> resolutionvmMaps) {
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
