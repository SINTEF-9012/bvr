package no.sintef.bvr.tool.ui.loader;

import no.sintef.bvr.tool.subject.ConfigurableUnitSubject;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import bvr.ConfigurableUnit;

abstract public class BVRViewAbstract implements BVRView{
	
	public int choiceCount = 1;
	
	public abstract BVRUIKernel getKernel() ;
	public abstract ConfigurableUnitSubject getConfigurableUnitSubject();
	public abstract ConfigurableUnit getCU();
	
	public void setMaximized(Object v) {
		throw new UnsupportedOperationException("not supported for this view"); 
	}
	public void setMinimized(Object v) {
		throw new UnsupportedOperationException("not supported for this view");
	};
	
	public void refresh() {
		throw new UnsupportedOperationException("not supported for this view");
	};
}
