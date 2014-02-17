package no.sintef.bvr.ui.editor.mvc.vspec.observer;


import no.sintef.bvr.ui.editor.common.observer.AbstractEditorSubject;

public final class VSpecResourseSetSubject extends AbstractEditorSubject {
	
	public static VSpecResourseSetSubject eINSTANCE = getInstance();
	
	private static VSpecResourseSetSubject getInstance(){
		return new VSpecResourseSetSubject();
	}
}
