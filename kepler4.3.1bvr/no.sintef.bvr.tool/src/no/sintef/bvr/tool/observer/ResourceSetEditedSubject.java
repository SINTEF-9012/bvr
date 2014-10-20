package no.sintef.bvr.tool.observer;


import java.util.HashSet;

import no.sintef.bvr.tool.ui.loader.BVRToolModel;

import org.eclipse.emf.transaction.ResourceSetChangeEvent;

public class ResourceSetEditedSubject implements ResourceSubject {

	protected HashSet<ResourceObserver> observers = new HashSet<ResourceObserver>();
	protected ResourceSetChangeEvent event;
	protected BVRToolModel model;
	
	public ResourceSetEditedSubject(BVRToolModel model) {
		this.model = model;
	}
	
	@Override
	public void attach(ResourceObserver observer) {
		observers.add(observer);
	}

	@Override
	public void detach(ResourceObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(ResourceObserver o : observers){
			o.update(this);
		}
	}

	public void setResourceSetChangeEvent(ResourceSetChangeEvent e){
		event = e;
	}
	
	public ResourceSetChangeEvent getResourceSetChangeEvent(){
		return event;
	}

}
