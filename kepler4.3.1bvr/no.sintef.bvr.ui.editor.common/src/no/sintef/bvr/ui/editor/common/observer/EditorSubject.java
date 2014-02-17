package no.sintef.bvr.ui.editor.common.observer;

public interface EditorSubject {

	public void attach(EditorObserver observer);
	
	public void detach(EditorObserver observer);
	
	public void notifyObservers();
}
