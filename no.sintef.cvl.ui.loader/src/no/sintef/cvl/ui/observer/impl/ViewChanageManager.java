package no.sintef.cvl.ui.observer.impl;

import java.util.ArrayList;
import java.util.HashMap;

import no.sintef.cvl.ui.observer.ChangeManager;
import no.sintef.cvl.ui.observer.Observer;
import no.sintef.cvl.ui.observer.Subject;
import no.sintef.cvl.ui.primitive.impl.ObserverDataBulk;

public class ViewChanageManager implements ChangeManager {

	private HashMap<Subject, ArrayList<Observer>> subjectObserverMap = new HashMap<Subject, ArrayList<Observer>>();
	private HashMap<Observer, ArrayList<Subject>> objectSubjectMap = new HashMap<Observer, ArrayList<Subject>>();
	private ArrayList<Subject> modifiedSubjects = new ArrayList<Subject>();
	
	private static final ViewChanageManager singeltone = new ViewChanageManager();
	
	public static ViewChanageManager getChangeManager(){
		return singeltone;
	}
	
	@Override
	public void register(Subject subject, Observer observer) {
		ArrayList<Observer> observers = (subjectObserverMap.get(subject) != null) ? subjectObserverMap.get(subject) : new ArrayList<Observer>();
		if(observers.indexOf(observer) < 0)
			observers.add(observer);
		subjectObserverMap.put(subject, observers);
		ArrayList<Subject> subjects = (objectSubjectMap.get(observer) != null) ? objectSubjectMap.get(observer) : new ArrayList<Subject>();
		if(subjects.indexOf(observer) < 0)
			subjects.add(subject);
		objectSubjectMap.put(observer, subjects);
	}

	@Override
	public void unregister(Subject subject, Observer observer) {
		ArrayList<Observer> observers =  subjectObserverMap.get(subject);
		if(observers != null)
			observers.remove(observer);
		ArrayList<Subject> subjects = objectSubjectMap.get(observer);
		if(subjects != null)
			subjects.remove(subject);
	}

	@Override
	public void notifyObserver() {
		for(Subject subject : subjectObserverMap.keySet()){
			if(modifiedSubjects.indexOf(subject) >= 0){
				for(Observer observer : subjectObserverMap.get(subject))
					observer.update(subject);
			}
		}
		modifiedSubjects.clear();
	}

	@Override
	public void updateSubjects(ObserverDataBulk data, Observer observer) {
		ArrayList<Subject> subsjects = objectSubjectMap.get(observer);
		for(Subject subject : subsjects){
			if(subject.isApplicable(data)){
				subject.setState(data);
				modifiedSubjects.add(subject);
			}
		}
		notifyObserver();
	}
	
	@Override
	public ArrayList<Observer> registeredObservers(Subject subject){
		return subjectObserverMap.get(subject);
	}

	@Override
	public void refreshSubject(Subject subject) {
		for(Subject sbjct : subjectObserverMap.keySet())
			if(subject.equals(sbjct))
				modifiedSubjects.add(subject);
		notifyObserver();
	}
}
