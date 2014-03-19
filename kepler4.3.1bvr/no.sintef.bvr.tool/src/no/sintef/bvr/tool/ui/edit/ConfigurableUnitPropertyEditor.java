package no.sintef.bvr.tool.ui.edit;

import no.sintef.bvr.tool.ui.command.UpdateVSpec;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.ConfigurableUnit;


public class ConfigurableUnitPropertyEditor extends ElementPropertyEditor{
	

	private static final long serialVersionUID = 3654695427983158448L;

	protected void init() {
    	command = new UpdateVSpec();
    	command.init(null, obj, null, null, null, null, view);
    }

	public ConfigurableUnitPropertyEditor(BVRUIKernel kernel, ConfigurableUnit elem, BVRView view) {
		super(kernel, elem, view);
	}

}
