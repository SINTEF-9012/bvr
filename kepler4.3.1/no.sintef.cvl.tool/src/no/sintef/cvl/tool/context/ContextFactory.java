package no.sintef.cvl.tool.context;

import no.sintef.cvl.tool.environment.Environment;
import no.sintef.cvl.tool.environment.eclipse.EclipseEnvironment;
import no.sintef.cvl.tool.environment.eclipseless.EclipseLessEnvironment;

import org.eclipse.ui.IWorkbenchWindow;

public final class ContextFactory {
	
	public final static ContextFactory eINSTANCE = getFactoryCreator();
	
	private static ContextFactory getFactoryCreator(){
		return new ContextFactory();
	}
	
	public Environment createEnvironment(IWorkbenchWindow workbanch){
		return (workbanch == null) ? new EclipseLessEnvironment() : new EclipseEnvironment(workbanch);
	}
	
	public Environment createEnvironment(){
		return new EclipseLessEnvironment();
	}
	
	public ViewChanageManager createViewChanageManager(){
		return ViewChanageManager.getChangeManager();
	}

}
