package no.sintef.bvr.ui.editor.common.observer;

import java.util.ArrayList;
import java.util.List;

public class ResourceSavedSubject implements EditorSubject {

	List<EditorObserver> observers = new ArrayList<EditorObserver>();
	
	@Override
	public void attach(EditorObserver observer) {
		observers.add(observer);
	}

	@Override
	public void detach(EditorObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(EditorObserver o : observers){
			o.update(this);
		}
	}
}
