package no.sintef.cvl.ui.observer.impl;

import java.util.ArrayList;

import no.sintef.cvl.ui.observer.Observer;
import no.sintef.cvl.ui.observer.Subject;
import no.sintef.cvl.ui.primitive.impl.ObserverDataBulk;

public abstract class AbstractViewSubject implements Subject {
 
	protected ViewChanageManager changeManager = ViewChanageManager.getChangeManager();
	
	@Override
	public void attach(Observer observer) {
		changeManager.register(this, observer);
	}

	@Override
	public void detach(Observer observer) {
		changeManager.unregister(this, observer);
	}

	@Override
	public void notifyObserver() {
		ArrayList<Observer> observers = changeManager.registeredObservers(this);
		if(observers != null){
			for(Observer observer : observers){
				observer.update(this);
			}
		}
	}
}
