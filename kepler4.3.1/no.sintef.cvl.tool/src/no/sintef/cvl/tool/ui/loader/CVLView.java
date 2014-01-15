package no.sintef.cvl.tool.ui.loader;

import no.sintef.cvl.tool.subject.ConfigurableUnitSubject;
import no.sintef.cvl.tool.ui.editor.CVLUIKernel;
import cvl.ConfigurableUnit;
import cvl.VSpec;

abstract public class CVLView {
	protected BVRNotifier ep;
	abstract public CVLUIKernel getKernel() ;
	public abstract ConfigurableUnitSubject getConfigurableUnitSubject() ;
	public abstract boolean isDirty() ;
	public abstract ConfigurableUnit getCU();
	int choiceCount = 1;
	abstract public void notifyResolutionViewUpdate() ;
	abstract  public void notifyVspecViewUpdate();
	abstract public void notifyRelalizationViewReset() ;
	abstract public void notifyAllViews() ;
	abstract public void setMaximized(VSpec v);
	abstract public void setMinimized(VSpec v) ;
}
