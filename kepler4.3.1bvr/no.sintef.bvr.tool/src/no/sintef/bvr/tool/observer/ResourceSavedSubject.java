package no.sintef.bvr.tool.observer;

import java.util.ArrayList;
import java.util.List;

public class ResourceSavedSubject implements ResourceSubject {

	List<ResourceObserver> observers = new ArrayList<ResourceObserver>();
	
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
}
