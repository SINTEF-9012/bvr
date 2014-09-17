package no.sintef.bvr.tool.observer;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.tool.ui.loader.BVRToolModel;
import no.sintef.bvr.tool.ui.loader.BVRTransactionalModel;

import org.eclipse.emf.transaction.ResourceSetChangeEvent;

public class ResourceSetEditedSubject implements ResourceSubject {

	protected List<ResourceObserver> observers = new ArrayList<ResourceObserver>();
	protected ResourceSetChangeEvent event;
	private BVRToolModel model;
	
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
