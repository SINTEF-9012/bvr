package no.sintef.bvr.ui.editor.common.observer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.transaction.ResourceSetChangeEvent;

public abstract class AbstractEditorSubject implements EditorSubject {

	protected List<EditorObserver> observers = new ArrayList<EditorObserver>();
	protected ResourceSetChangeEvent event;
	
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

	public void setResourceSetChangeEvent(ResourceSetChangeEvent e){
		event = e;
	}
	
	public ResourceSetChangeEvent getResourceSetChangeEvent(){
		return event;
	}

}
