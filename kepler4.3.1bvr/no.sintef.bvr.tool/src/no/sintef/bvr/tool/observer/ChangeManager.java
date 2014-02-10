package no.sintef.bvr.tool.observer;

import java.util.ArrayList;

import no.sintef.bvr.tool.primitive.impl.ObserverDataBulk;

public interface ChangeManager {

	public void register(Subject subject, Observer observer);
	
	public void unregister(Subject subject, Observer observer);
	
	public void notifyObserver();
	
	public void updateSubjects(ObserverDataBulk data, Observer observer);

	public ArrayList<Observer> registeredObservers(Subject subject);
	
	public void refreshSubject(Subject subject);

	public ArrayList<Subject> registeredSubjects(Observer observer);
}
