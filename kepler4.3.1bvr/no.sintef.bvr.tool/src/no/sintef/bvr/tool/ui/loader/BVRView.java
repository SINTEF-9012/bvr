package no.sintef.bvr.tool.ui.loader;

import no.sintef.bvr.tool.subject.ConfigurableUnitSubject;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import bvr.ConfigurableUnit;

public interface BVRView {
	abstract public BVRUIKernel getKernel() ;
	public abstract ConfigurableUnitSubject getConfigurableUnitSubject() ;
	public abstract ConfigurableUnit getCU();
	
	abstract public void setMaximized(Object v);
	abstract public void setMinimized(Object v) ;
	
	abstract public void refresh();
}
