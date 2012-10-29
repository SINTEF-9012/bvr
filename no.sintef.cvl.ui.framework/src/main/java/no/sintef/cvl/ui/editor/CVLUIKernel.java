package no.sintef.cvl.ui.editor;

import no.sintef.cvl.ui.editor.panel.CVLEditorPanel;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;

public class CVLUIKernel {
	
	private CVLEditorPanel editorPanel;
	private ConfigurableUnitPanel modelPanel;
	
	public CVLUIKernel() {
		modelPanel = new ConfigurableUnitPanel();
		//editorPanel = new CVLEditorPanel();
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
