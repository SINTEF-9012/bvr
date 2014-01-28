package no.sintef.bvr.tool.subject;

import java.util.ArrayList;

import bvr.ConfigurableUnit;

import no.sintef.bvr.tool.context.ViewChanageManager;
import no.sintef.bvr.tool.observer.Observer;
import no.sintef.bvr.tool.observer.Subject;
import no.sintef.bvr.tool.primitive.impl.ObserverDataBulk;

public abstract class AbstractViewSubject implements Subject {
 
	protected ViewChanageManager changeManager = ViewChanageManager.getChangeManager();
	private String[] fields = {};
	
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
	
	@Override
	public boolean isApplicable(ObserverDataBulk data) {
		for(String field : getFileds()){
			if(data.isFieldSet(field))
				return true;
		}
		return false;
	}
	
	protected String[] getFileds(){
		return fields;
	}
}