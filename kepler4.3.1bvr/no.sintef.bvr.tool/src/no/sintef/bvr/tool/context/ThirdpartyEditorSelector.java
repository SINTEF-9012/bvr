package no.sintef.bvr.tool.context;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.thirdparty.editor.ICVLEnabledEditor;
import no.sintef.bvr.thirdparty.editor.ProxyThirdPartyTreeEditor;
import no.sintef.bvr.tool.common.ModelSelector;
import no.sintef.bvr.tool.exception.NoEclipseDetectedException;

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
			Context.eINSTANCE.logger.warn("workbenchWindow is not set you may run into some problems when it involves some external operations");
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
	public List<Object> getSelections() {
		ISelection selection = workbenchWindow.getActivePage().getActiveEditor().getSite().getSelectionProvider().getSelection();
		StructuredSelection structuredSelection = (StructuredSelection) selection;
		return structuredSelection.toList();
	}

	@Override
	public void highlightObjects(EList<HashMap<EObject, Integer>> objectsToHighlightList) {
		final HashMap<EObject, Integer> objectsToHiglight = new HashMap<EObject, Integer>();
		for(HashMap<EObject, Integer> pair : objectsToHighlightList){
			if(pair.size() != 1){
				Context.eINSTANCE.logger.warn("a hash map has more than one object to highlight or is empty, that is weird, skip it" + pair);
				continue;
			}
			EObject key = pair.keySet().iterator().next();
			if(objectsToHiglight.containsKey(key)){
				Integer type = objectsToHiglight.get(key);
				/*
				 * if an object is referenced by outsideBoundaryElement references of the both boundaries kinds (toPlacement, fromPlacement)
				 * then we should color it differently. Or if we already processed this element and colored it differently, but stumble upon the same element
				 * which is referenced by outsideBoundaryElement of either toPlacement or fromPlacement, then still color it differently. Otherwise we give a warning.
				 * The same logic for replacements
				 */
				if(type == ICVLEnabledEditor.HL_PLACEMENT_IN && pair.get(key) == ICVLEnabledEditor.HL_PLACEMENT_OUT
						|| type == ICVLEnabledEditor.HL_PLACEMENT_OUT && pair.get(key) == ICVLEnabledEditor.HL_PLACEMENT_IN
						|| (type == ICVLEnabledEditor.HL_PLACEMENT_IN_OUT && (pair.get(key) == ICVLEnabledEditor.HL_PLACEMENT_OUT || pair.get(key) == ICVLEnabledEditor.HL_PLACEMENT_IN))){
					pair.put(key, ICVLEnabledEditor.HL_PLACEMENT_IN_OUT);
				}else if(type == ICVLEnabledEditor.HL_REPLACEMENT_IN && pair.get(key) == ICVLEnabledEditor.HL_REPLACEMENT_OUT
						|| type == ICVLEnabledEditor.HL_REPLACEMENT_OUT && pair.get(key) == ICVLEnabledEditor.HL_REPLACEMENT_IN
						|| (type == ICVLEnabledEditor.HL_REPLACEMENT_IN_OUT && (pair.get(key) == ICVLEnabledEditor.HL_REPLACEMENT_OUT || pair.get(key) == ICVLEnabledEditor.HL_REPLACEMENT_IN))){
					pair.put(key, ICVLEnabledEditor.HL_REPLACEMENT_IN_OUT);
				}else if(type != pair.get(key)){
					Context.eINSTANCE.logger.warn("have no idea how to highlight element (highlighting will be partially correct): " + key);
				}
			}
			objectsToHiglight.put(key, pair.get(key));
		}
		highlightObjects(objectsToHiglight);
	}
	
	private void highlightObjects(final HashMap<EObject, Integer> objects) {
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
		    				ProxyThirdPartyTreeEditor bvrEnabledEditor = new ProxyThirdPartyTreeEditor(editorPart);
		    				bvrEnabledEditor.clearHighlighting();
		    				highlightObjects(bvrEnabledEditor, objects);
		    				bvrEnabledEditor.expandHiglightedObjects();
						} catch (Exception e) {
							Context.eINSTANCE.logger.warn("unsupported editor: -->"+ editorPart.getClass().toString() + "<--, can not highlight due to : " + e.getMessage());
						}
		    		}else if (editorPart != null && (editorPart instanceof ICVLEnabledEditor)){
		    			ICVLEnabledEditor bvrEnabledEditor = (ICVLEnabledEditor) editorPart;
		    			bvrEnabledEditor.clearHighlighting();
		    			highlightObjects(bvrEnabledEditor, objects);
		    		}else{
		    			String editorName = (String) ((editorPart != null) ? editorPart.getClass().toString() : "null");
		    			Context.eINSTANCE.logger.warn("unsupported editor: -->" + editorName + "<--, can not highlight anything");
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
	public void clearHighlights() {
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
							Context.eINSTANCE.logger.warn("unsupported editor: -->"+ editorPart.getClass() + "<--, can not clear highlighting (if any) due to: " + e.getMessage());
						}
		    		}if (editorPart != null && (editorPart instanceof ICVLEnabledEditor)){
		    			ICVLEnabledEditor bvrEnabledEditor = (ICVLEnabledEditor) editorPart;
		    			bvrEnabledEditor.clearHighlighting();
		    		}else{
		    			String editorName = (String) ((editorPart != null) ? editorPart.getClass().toString() : "null");
		    			Context.eINSTANCE.logger.warn("unsupported editor: -->" + editorName + "<--, can not clear highlighting (if any)");
		    		}
		    	}				
			}
		});
	}
}