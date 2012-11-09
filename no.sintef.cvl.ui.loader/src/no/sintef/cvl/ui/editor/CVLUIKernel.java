package no.sintef.cvl.ui.editor;

import java.util.Map;

import javax.swing.JComponent;

import cvl.VSpec;
import no.sintef.cvl.ui.edit.CVLEditorPanel;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;

public class CVLUIKernel {
	
	private CVLEditorPanel editorPanel;
	private ConfigurableUnitPanel modelPanel;
	
	public CVLUIKernel(Map<JComponent, VSpec> vmMap) {
		modelPanel = new ConfigurableUnitPanel();
		editorPanel = new CVLEditorPanel(this, vmMap);
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
