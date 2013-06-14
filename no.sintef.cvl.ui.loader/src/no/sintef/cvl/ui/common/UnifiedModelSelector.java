package no.sintef.cvl.ui.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IWorkbenchWindow;

public class UnifiedModelSelector implements ModelSelector {

	private IWorkbenchWindow workbenchWindow;

	public UnifiedModelSelector(IWorkbenchWindow workbenchWindow){
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

}
