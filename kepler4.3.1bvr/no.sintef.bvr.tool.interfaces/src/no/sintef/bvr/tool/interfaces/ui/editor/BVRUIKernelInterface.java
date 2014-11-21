package no.sintef.bvr.tool.interfaces.ui.editor;


public interface BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> {

	public EDITOR_PANEL getEditorPanel();
	
	public void setEditorPanel(EDITOR_PANEL editorPanel);
	
	public MODEL_PANEL getModelPanel();	
}
