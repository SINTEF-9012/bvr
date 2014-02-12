package no.sintef.bvr.ui.editor.common.observer;

public interface BVREditorSubject {

	public void attach(BVREditorObserver observer);
	
	public void detach(BVREditorObserver observer);
	
	public void notifyObservers();
}
