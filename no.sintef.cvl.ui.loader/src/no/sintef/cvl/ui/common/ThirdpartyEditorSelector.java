package no.sintef.cvl.ui.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import no.sintef.cvl.ui.exceptions.IllegalOperationException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;

public final class ThirdpartyEditorSelector implements ModelSelector {

	private IWorkbenchWindow workbenchWindow;
	 
	private static final ThirdpartyEditorSelector singletone = new ThirdpartyEditorSelector();
	
	public static ThirdpartyEditorSelector getEditorSelector(IWorkbenchWindow workbenchWindow){
		singletone.setWorkbeach(workbenchWindow);
		return singletone;
	}
	
	public void setWorkbeach(IWorkbenchWindow workbenchWindow){
		this.workbenchWindow = workbenchWindow;
	}
	
	@Override
	public void highlightObject(EObject eObject, int type) {
		// TODO Auto-generated method stub
	}

	@Override
	public void clearHighlighting(EObject eObject) {
		// TODO Auto-generated method stub
	}

	@Override
	public EObject getEObject(Object object) {
		EObject eObject = null;
		if(object instanceof EObject){
			eObject = (EObject) object;
		}else{
			try {
				Method method = object.getClass().getMethod("resolveSemanticElement");
				eObject = (EObject) method.invoke(object, new Object[0]);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException error) {
				throw new UnsupportedOperationException("Can not access a model object, blame your editor. We should fall into a brach where we chech that an editor implements CVL enabled editor interface");
			}
		}
		return eObject;
	}

	@Override
	public List<Object> getSelections() throws IllegalOperationException {
		if(workbenchWindow == null)
			throw new IllegalOperationException("can not get selection, because workbench is not initialized");
		ISelection selection = workbenchWindow.getActivePage().getActiveEditor().getSite().getSelectionProvider().getSelection();
		StructuredSelection structuredSelection = (StructuredSelection) selection;
		return structuredSelection.toList();
	}
	
	

}
