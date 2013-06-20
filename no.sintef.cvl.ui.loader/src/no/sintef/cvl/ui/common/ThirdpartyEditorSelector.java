package no.sintef.cvl.ui.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

import no.sintef.cvl.ui.exceptions.IllegalOperationException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.swt.widgets.Display;

public final class ThirdpartyEditorSelector implements ModelSelector {

	private IWorkbenchWindow workbenchWindow;
	 
	private static final ThirdpartyEditorSelector singletone = new ThirdpartyEditorSelector();
	
	public static List<Object> removethis = null;
	
	public static ThirdpartyEditorSelector getEditorSelector(){
		return singletone;
	}
	
	public static void setWorkbeach(IWorkbenchWindow workbenchWindow){
		singletone.workbenchWindow = workbenchWindow;
	}
	
	@Override
	public void highlightObject(EObject eObject, int type) {
    	/*Random rn = new Random();
    	System.out.println("--------------------------------");
    	EObject object = (EObject) removethis.get(removethis.size() - 1);
    	System.out.println(object);
    	System.out.println(object.eResource().getURIFragment(object));
		final StructuredSelection selection = new StructuredSelection(object);
		Display.getDefault().asyncExec(new Runnable() {
		    public void run() {
		    	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		    	System.out.println((StructuredSelection) workbenchWindow.getActivePage().getActiveEditor().getSite().getSelectionProvider().getSelection());
		    	
		    	ISelectionChangedListener listener = new ISelectionChangedListener() {

					@Override
					public void selectionChanged(SelectionChangedEvent arg0) {
						System.out.println("selectionChanged");
						System.out.println(arg0.getSelection());
					}
		    		
				};
				
				ISelectionListener listener1 = new ISelectionListener() {
					
					@Override
					public void selectionChanged(IWorkbenchPart arg0, ISelection arg1) {
						//arg0.
						
					}
				};
				
		    	System.out.println(workbenchWindow.getActivePage().getActiveEditor());
				
		    	workbenchWindow.getActivePage().getActiveEditor().getSite().getSelectionProvider().addSelectionChangedListener(listener);
				workbenchWindow.getActivePage().getActiveEditor().getSite().getSelectionProvider().setSelection(selection);
				workbenchWindow.getActivePage().getActiveEditor().getSite().getSelectionProvider().removeSelectionChangedListener(listener);
				System.out.println("^^^^^^^^^^^^^^^^");
				System.out.println(workbenchWindow.getActivePage().getActiveEditor().getSite().getSelectionProvider().getSelection());
		    }
		});*/
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
			throw new IllegalOperationException("can not get selection, because no eclipse detected and workbench is not initialized");
		if(workbenchWindow.getActivePage().getActiveEditor() == null)
			throw new IllegalOperationException("editor is not opened");
		ISelection selection = workbenchWindow.getActivePage().getActiveEditor().getSite().getSelectionProvider().getSelection();
		StructuredSelection structuredSelection = (StructuredSelection) selection;
		return structuredSelection.toList();
	}
}