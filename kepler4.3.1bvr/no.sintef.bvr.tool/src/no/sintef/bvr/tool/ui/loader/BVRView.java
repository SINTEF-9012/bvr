package no.sintef.bvr.tool.ui.loader;

import no.sintef.bvr.tool.subject.ConfigurableUnitSubject;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import bvr.ConfigurableUnit;

abstract public class BVRView {
	abstract public BVRUIKernel getKernel() ;
	public abstract ConfigurableUnitSubject getConfigurableUnitSubject() ;
	public abstract ConfigurableUnit getCU();
	int choiceCount = 1;
	
	abstract public void setMaximized(Object v);
	abstract public void setMinimized(Object v) ;
	
	abstract public void refresh();
}
