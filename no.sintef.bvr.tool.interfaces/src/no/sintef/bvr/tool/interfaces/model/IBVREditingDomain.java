package no.sintef.bvr.tool.interfaces.model;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public interface IBVREditingDomain {

	public ResourceSet getResourceSet();

	public List<String> getErrorMessages();

	public TransactionalEditingDomain getEditingDomain();

}
