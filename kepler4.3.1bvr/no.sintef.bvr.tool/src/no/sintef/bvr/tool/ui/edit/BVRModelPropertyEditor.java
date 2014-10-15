package no.sintef.bvr.tool.ui.edit;

import bvr.NamedElement;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.UpdateVSpec;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;


public class BVRModelPropertyEditor extends ElementPropertyEditor{
	

	public BVRModelPropertyEditor(BVRUIKernel _kernel,
			NamedElement _obj, BVRNotifiableController _view) {
		super(_kernel, _obj, _view);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 3654695427983158448L;

	protected void init() {
    	command = new UpdateVSpec();
    	command.init(null, obj, null, null, null, null, controller);
    }

	/*public ConfigurableUnitPropertyEditor(BVRUIKernel kernel, ConfigurableUnit elem, BVRToolView view) {
		super(kernel, elem, view);
	}*/

}
