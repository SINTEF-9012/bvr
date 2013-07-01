package no.sintef.cvl.ui.observer;

import no.sintef.cvl.ui.primitive.impl.ObserverDataBulk;

public interface Subject {

	public void attach(Observer observer);
	
	public void detach(Observer observer);
	
	public void notifyObserver();

	public void setState(ObserverDataBulk data);
}
