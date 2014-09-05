package no.sintef.bvr.tool.ui.edit;

import bvr.NamedElement;
import no.sintef.bvr.tool.ui.command.UpdateVSpec;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRToolView;


public class ConfigurableUnitPropertyEditor extends ElementPropertyEditor{
	

	public ConfigurableUnitPropertyEditor(BVRUIKernel _kernel,
			NamedElement _obj, BVRToolView _view) {
		super(_kernel, _obj, _view);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 3654695427983158448L;

	protected void init() {
    	command = new UpdateVSpec();
    	command.init(null, obj, null, null, null, null, view);
    }

	/*public ConfigurableUnitPropertyEditor(BVRUIKernel kernel, ConfigurableUnit elem, BVRToolView view) {
		super(kernel, elem, view);
	}*/

}
