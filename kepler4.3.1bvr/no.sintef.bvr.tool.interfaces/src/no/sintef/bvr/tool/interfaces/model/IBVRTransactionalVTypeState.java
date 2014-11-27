package no.sintef.bvr.tool.interfaces.model;

import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;

public interface IBVRTransactionalVTypeState<VNODE, VTYPE> extends ResourceSubject {

	public VNODE getParentVNode();
	
	public VTYPE getVType();
}
