package no.sintef.bvr.tool.ui.loader;

import no.sintef.bvr.tool.subject.ConfigurableUnitSubject;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import bvr.ConfigurableUnit;

public interface BVRView {
	public BVRUIKernel getKernel() ;
	public ConfigurableUnitSubject getConfigurableUnitSubject() ;
	public ConfigurableUnit getCU();
	public BVRModel getModel();
	
	public void setMaximized(Object v);
	public void setMinimized(Object v) ;
	
	public void refresh();
}
