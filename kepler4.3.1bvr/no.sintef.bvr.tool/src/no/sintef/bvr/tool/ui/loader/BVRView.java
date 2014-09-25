package no.sintef.bvr.tool.ui.loader;

import no.sintef.bvr.tool.subject.ConfigurableUnitSubject;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import bvr.ConfigurableUnit;
import bvr.VSpecResolution;

public interface BVRView {
	public BVRUIKernel getKernel() ;
	public ConfigurableUnitSubject getConfigurableUnitSubject() ;
	public ConfigurableUnit getCU();
	public BVRModel getModel();
	
	public void setMaximized(Object v);
	public void setMinimized(Object v) ;
	
	public void refresh();
	
	//added strip functionality for resolutioneditor v2 to avoid code dupplication
	public void setUnstripped(Object vsr);
	public void setStripped(Object vsr);
}
