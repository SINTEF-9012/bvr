package no.sintef.bvr.tool.ui.loader;

import no.sintef.bvr.tool.subject.ConfigurableUnitSubject;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import bvr.ConfigurableUnit;
import bvr.VSpec;

abstract public class BVRView {
	protected BVRNotifier ep;
	abstract public BVRUIKernel getKernel() ;
	public abstract ConfigurableUnitSubject getConfigurableUnitSubject() ;
	public abstract boolean isDirty() ;
	public abstract ConfigurableUnit getCU();
	int choiceCount = 1;
	abstract public void notifyResolutionViewUpdate() ;
	abstract  public void notifyVspecViewUpdate();
	abstract public void notifyRelalizationViewReset();
	abstract public void notifyAllViews();
	abstract public void setMaximized(Object v);
	abstract public void setMinimized(Object v) ;
	
	abstract public void refresh();
}
