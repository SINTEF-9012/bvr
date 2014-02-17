package no.sintef.bvr.ui.editor.mvc.resolution.observer;


import no.sintef.bvr.ui.editor.common.observer.AbstractEditorSubject;

public class ResolutionResourceSetSubject extends AbstractEditorSubject {

	public static ResolutionResourceSetSubject eINSTANCE = getInstance();
	
	private static ResolutionResourceSetSubject getInstance(){
		return new ResolutionResourceSetSubject();
	}
}
