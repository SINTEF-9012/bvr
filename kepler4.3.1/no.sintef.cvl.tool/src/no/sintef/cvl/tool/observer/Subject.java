package no.sintef.cvl.tool.observer;

import no.sintef.cvl.tool.primitive.impl.ObserverDataBulk;

public interface Subject {

	public void attach(Observer observer);
	
	public void detach(Observer observer);
	
	public void notifyObserver();

	public void setState(ObserverDataBulk data);
	
	public boolean isApplicable(ObserverDataBulk data);
}
