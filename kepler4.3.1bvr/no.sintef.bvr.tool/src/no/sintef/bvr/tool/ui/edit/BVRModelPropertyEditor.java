package no.sintef.bvr.tool.ui.edit;

import javax.swing.JComponent;

import bvr.NamedElement;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;


public class BVRModelPropertyEditor extends ElementPropertyEditor{
	
	private static final long serialVersionUID = 3654695427983158448L;
	
	public BVRModelPropertyEditor(BVRUIKernel _kernel, Command _command,
			NamedElement _obj, JComponent _node, BVRNotifiableController _view) {
		super(_kernel, _command, _obj, _node, _view);
	}
}
