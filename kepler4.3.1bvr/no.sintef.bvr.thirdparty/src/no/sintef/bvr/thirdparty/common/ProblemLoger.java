package no.sintef.bvr.thirdparty.common;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.thirdparty.exception.UnexpectedThirdPartyException;

public class ProblemLoger implements Logger {
	
	private IResource iresource;
	private EObject srcObject;


	@Override
	public void error(String message) {
		IMarker m;
		try {
			m = iresource.createMarker(IMarker.PROBLEM);
			m.setAttribute(IMarker.MESSAGE, message);
			m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
			m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
		} catch (CoreException e) {
			throw new UnexpectedThirdPartyException(e);
		}

	}

	@Override
	public void error(String message, Throwable e) {
		IMarker m;
		try {
			m = iresource.createMarker(IMarker.PROBLEM);
			m.setAttribute(IMarker.MESSAGE, message);
			m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
			m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
		} catch (CoreException ex) {
			throw new UnexpectedThirdPartyException(ex);
		}
	}

	@Override
	public void warn(String message) {
		IMarker m;
		try {
			m = iresource.createMarker(IMarker.PROBLEM);
			m.setAttribute(IMarker.MESSAGE, message);
			m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
			m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
		} catch (CoreException ex) {
			throw new UnexpectedThirdPartyException(ex);
		}
	}

	@Override
	public void info(String message) {
		IMarker m;
		try {
			m = iresource.createMarker(IMarker.PROBLEM);
			m.setAttribute(IMarker.MESSAGE, message);
			m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
			m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
		} catch (CoreException ex) {
			throw new UnexpectedThirdPartyException(ex);
		}

	}

	@Override
	public void debug(String message) {
		IMarker m;
		try {
			m = iresource.createMarker(IMarker.PROBLEM);
			m.setAttribute(IMarker.MESSAGE, message);
			m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_LOW);
			m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
		} catch (CoreException ex) {
			throw new UnexpectedThirdPartyException(ex);
		}
	}

	@Override
	public void setSource(Object src) {
		srcObject = (EObject) src;
	}

	@Override
	public void setResource(Object resource) {
		iresource = (IResource) resource;
	}

}
