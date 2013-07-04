package no.sintef.cvl.ui.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.sintef.cvl.thirdparty.editor.ICVLEnabledEditor;
import no.sintef.cvl.thirdparty.editor.ProxyThirdPartyTreeEditor;
import no.sintef.cvl.ui.exception.NoEclipseDetectedException;
import no.sintef.cvl.ui.logging.impl.Logging;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.swt.widgets.Display;

public final class ThirdpartyEditorSelector implements ModelSelector {

	private IWorkbenchWindow workbenchWindow = null;
	 
	private static final ThirdpartyEditorSelector singletone = new ThirdpartyEditorSelector();
	
	public static ThirdpartyEditorSelector getEditorSelector(){
		if(singletone.workbenchWindow == null)
			Logging.getLogger().warn("workbenchWindow is not set you may run into some problems when it involves some external operations");
		return singletone;
	}
	
	public static void setWorkbeach(IWorkbenchWindow workbenchWindow){
		singletone.workbenchWindow = workbenchWindow;
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
	public List<Object> getSelections() throws NoEclipseDetectedException {
		if(workbenchWindow == null)
			throw new NoEclipseDetectedException("can not get selection, because no eclipse detected and workbench is not initialized");
		if(workbenchWindow.getActivePage().getActiveEditor() == null)
			throw new NoEclipseDetectedException("editor is not opened");
		ISelection selection = workbenchWindow.getActivePage().getActiveEditor().getSite().getSelectionProvider().getSelection();
		StructuredSelection structuredSelection = (StructuredSelection) selection;
		return structuredSelection.toList();
	}

	@Override
	public void highlightObjects(EList<HashMap<EObject, Integer>> objectsToHighlightList) throws NoEclipseDetectedException {
		final HashMap<EObject, Integer> objectsToHiglight = new HashMap<EObject, Integer>();
		for(HashMap<EObject, Integer> pair : objectsToHighlightList){
			EObject key = pair.keySet().iterator().next();
			if(objectsToHiglight.containsKey(key)){
				if(pair.get(key) == ICVLEnabledEditor.HL_PLACEMENT_IN || pair.get(key) == ICVLEnabledEditor.HL_PLACEMENT_OUT)
					pair.put(key, ICVLEnabledEditor.HL_PLACEMENT_IN_OUT);
				if(pair.get(key) == ICVLEnabledEditor.HL_REPLACEMENT_IN || pair.get(key) == ICVLEnabledEditor.HL_REPLACEMENT_OUT)
					pair.put(key, ICVLEnabledEditor.HL_REPLACEMENT_IN_OUT);
			}
			objectsToHiglight.put(key, pair.get(key));
		}
		highlightObjects(objectsToHiglight);
	}
	
	private void highlightObjects(final HashMap<EObject, Integer> objects) throws NoEclipseDetectedException {
		if(workbenchWindow == null)
			throw new NoEclipseDetectedException("can not highlight object, because no eclipse detected and workbench is not initialized");
		final IEditorReference[] editorReferences = workbenchWindow.getActivePage().getEditorReferences();
		if(editorReferences.length == 0)
			return;
		Display.getDefault().asyncExec(new Runnable() {
			
			@Override
		    public void run() {
		    	for(IEditorReference ref : editorReferences){
		    		IEditorPart editorPart = ref.getEditor(false);
		    		if(editorPart != null && !(editorPart instanceof ICVLEnabledEditor)){
		    			try {
		    				ProxyThirdPartyTreeEditor cvlEnabledEditor = new ProxyThirdPartyTreeEditor(editorPart);
		    				cvlEnabledEditor.clearHighlighting();
		    				highlightObjects(cvlEnabledEditor, objects);
		    				cvlEnabledEditor.expandHiglightedObjects();
						} catch (Exception e) {
							Logging.getLogger().warn("unsupported editor: -->"+ editorPart.getClass().toString() + "<--, can not highlight due to : " + e.getMessage());
						}
		    		}else if (editorPart != null && (editorPart instanceof ICVLEnabledEditor)){
		    			ICVLEnabledEditor cvlEnabledEditor = (ICVLEnabledEditor) editorPart;
		    			cvlEnabledEditor.clearHighlighting();
		    			highlightObjects(cvlEnabledEditor, objects);
		    		}else{
		    			String editorName = (String) ((editorPart != null) ? editorPart.getClass().toString() : "null");
		    			Logging.getLogger().warn("unsupported editor: -->" + editorName + "<--, can not highlight anything");
		    		}
		    	}
		    }
		
			private void highlightObjects(final ICVLEnabledEditor editor, final HashMap<EObject, Integer> objects){
				for(Map.Entry<EObject, Integer> entry : objects.entrySet()){
					editor.highlightObject(entry.getKey(), entry.getValue());
				}
			}
		});
	}

	@Override
	public void clearHighlights() throws NoEclipseDetectedException {
		if(workbenchWindow == null)
			throw new NoEclipseDetectedException("can not clear selection, because no eclipse detected and workbench is not initialized");
		final IEditorReference[] editorReferences = workbenchWindow.getActivePage().getEditorReferences();
		if(editorReferences.length == 0)
			return;
		
		Display.getDefault().asyncExec(new Runnable() {
			
			@Override
			public void run() {
		    	for(IEditorReference ref : editorReferences){
		    		IEditorPart editorPart = ref.getEditor(false);
		    		if(editorPart != null && !(editorPart instanceof ICVLEnabledEditor)){
		    			try {
		    				ICVLEnabledEditor editor = new ProxyThirdPartyTreeEditor(editorPart);
		    				editor.clearHighlighting();
						} catch (Exception e) {
							Logging.getLogger().warn("unsupported editor: -->"+ editorPart.getClass() + "<--, can not clear highlighting (if any) due to: " + e.getMessage());
						}
		    		}if (editorPart != null && (editorPart instanceof ICVLEnabledEditor)){
		    			ICVLEnabledEditor cvlEnabledEditor = (ICVLEnabledEditor) editorPart;
		    			cvlEnabledEditor.clearHighlighting();
		    		}else{
		    			String editorName = (String) ((editorPart != null) ? editorPart.getClass().toString() : "null");
		    			Logging.getLogger().warn("unsupported editor: -->" + editorName + "<--, can not clear highlighting (if any)");
		    		}
		    	}				
			}
		});
	}
}