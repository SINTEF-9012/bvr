package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements;

import no.sintef.bvr.tool.ui.edit.VariableValueAssignmentPropertyEditor;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands.UpdateVariableValueAssignmentV2;
import bvr.VariableValueAssignment;

public class VariableValueAssignmentPropertyEditorV2 extends VariableValueAssignmentPropertyEditor{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VariableValueAssignmentPropertyEditorV2(BVRUIKernel kernel,
			VariableValueAssignment elem, BVRView view) {
		super(kernel, elem, view);
		// TODO Auto-generated constructor stub
	}

	protected void init() {
    	command = new UpdateVariableValueAssignmentV2();
    	command.init(null, obj, null, null, null, null, view);
    }

}
