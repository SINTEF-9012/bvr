package no.sintef.cvl.ui.context;

import no.sintef.cvl.ui.common.ViewChanageManager;

import org.eclipse.ui.IWorkbenchWindow;

public final class FactoryCreator {
	
	public final static FactoryCreator eINSTANCE = getFactoryCreator();
	
	private static FactoryCreator getFactoryCreator(){
		return new FactoryCreator();
	}
	
	public Environment createEnvironment(IWorkbenchWindow workbanch){
		return (workbanch == null) ? new EclipseLessEnvironment() : new EclipseEnvironment(workbanch);
	}
	
	public ViewChanageManager createViewChanageManager(){
		return ViewChanageManager.getChangeManager();
	}

}
