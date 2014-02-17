package no.sintef.bvr.ui.editor.mvc.realization.observer;


import no.sintef.bvr.ui.editor.common.observer.AbstractEditorSubject;

public class RealizationResourceSetSubject extends AbstractEditorSubject {

	public static RealizationResourceSetSubject eINSTANCE = getInstance();
	
	private static RealizationResourceSetSubject getInstance(){
		return new RealizationResourceSetSubject();
	}
}
