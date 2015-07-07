/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.ui.editor;


import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;


public class BVRUIKernel<EDITOR_PANEL extends BVREditorPanel, MODEL_PANEL extends BVRModelPanel>
		implements BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> {
	
	private BVREditorPanel editorPanel;
	private BVRModelPanel modelPanel;
	
	public BVRUIKernel(BVRNotifiableController controller) {
		modelPanel = new BVRModelPanel();
		editorPanel = new BVREditorPanel(this, controller);
	}
	
	@Override
	public EDITOR_PANEL getEditorPanel() {
		return (EDITOR_PANEL) editorPanel;
	}
	
	@Override
	public MODEL_PANEL getModelPanel() {
		return (MODEL_PANEL) modelPanel;
	}

	@Override
	public void setEditorPanel(EDITOR_PANEL editorPanel) {
		editorPanel = (EDITOR_PANEL) editorPanel;
	}
}
