package no.sintef.bvr.common.logging;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;

public interface ResetableLogger extends Logger {

	public void setSource(EObject src);
	
	public void setResource(IResource resource);
	
	public void resetLogger();
}
