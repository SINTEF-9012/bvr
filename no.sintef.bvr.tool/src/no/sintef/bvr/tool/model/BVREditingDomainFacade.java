package no.sintef.bvr.tool.model;

import java.util.HashMap;
import java.util.Map;

import no.sintef.bvr.tool.interfaces.model.IBVREditingDomain;

import org.eclipse.emf.ecore.resource.ResourceSet;

public class BVREditingDomainFacade {

	static public BVREditingDomainFacade eINSTANCE = getInstance();

	private Map<ResourceSet, IBVREditingDomain> domains;

	static public BVREditingDomainFacade getInstance() {
		if (eINSTANCE == null)
			eINSTANCE = new BVREditingDomainFacade();
		return eINSTANCE;
	}

	private BVREditingDomainFacade() {
		domains = new HashMap<ResourceSet, IBVREditingDomain>();
	}

	public IBVREditingDomain testExecutionEditingDomain(ResourceSet resourceSet) {
		if (domains.containsKey(resourceSet))
			return domains.get(resourceSet);

		IBVREditingDomain executionDomain = new BVRExecutionEditingDomain(resourceSet);
		domains.put(resourceSet, executionDomain);
		return executionDomain;
	}

}
