/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package no.sintef.bvr.tool.context;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.sintef.bvr.thirdparty.editor.ProxyThirdPartyTreeEditor;
import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor;
import no.sintef.bvr.tool.common.ModelSelector;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.BundleException;

public final class ThirdpartyEditorSelector implements ModelSelector {

	private IWorkbenchWindow workbenchWindow = null;


	 
	private static final ThirdpartyEditorSelector singletone = new ThirdpartyEditorSelector();
	
	public static ThirdpartyEditorSelector getEditorSelector(){
		if(singletone.workbenchWindow == null)
			Context.eINSTANCE.logger.debug("workbenchWindow is not set you may run into some problems when it involves some external operations");
		return singletone;
	}
	
	public static void setWorkbeach(IWorkbenchWindow workbenchWindow) {
		singletone.workbenchWindow = workbenchWindow;
		try {
			Platform.getBundle("no.sintef.bvr.papyrusdiagram.adapter").start();
		} catch (BundleException e) {
			Context.eINSTANCE.logger.warn("Can not load no.sintef.bvr.papyrusdiagram.adapter for some reasons");
		}
	}
	
	@Override
	public EObject getEObject(Object object) {
		if(object instanceof EObject)
			return (EObject) object;
		
		IEditorPart activeEditor = workbenchWindow.getActivePage().getActiveEditor();
		IBVREnabledEditor bvrEneableAdapter = (IBVREnabledEditor) Platform.getAdapterManager().getAdapter(activeEditor, IBVREnabledEditor.class);
		
		if(bvrEneableAdapter != null) {
			List<EObject> result = bvrEneableAdapter.getModelObjects(Arrays.asList(new Object [] {object}));
			if(result.size() > 1)
				Context.eINSTANCE.logger.warn("there are few model objects which correspnd to on graphical element, graphical: "+ object + " " + result);

			return (result.size() != 0) ? result.get(0) : null;
		}

		EObject eObject = null;
		try {
			Method method = object.getClass().getMethod("resolveSemanticElement");
			eObject = (EObject) method.invoke(object, new Object[0]);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException error) {
			throw new UnsupportedOperationException("Can not access a model object, blame your editor");
		}
		return eObject;
	}

	@Override
	public List<Object> getSelections() {
		IEditorPart activeEditor = workbenchWindow.getActivePage().getActiveEditor();
		
		if(activeEditor == null) {
			Context.eINSTANCE.logger.debug("can not find any active aditor in the ActivePage of the workbench");
			return new ArrayList<Object>();
		}
		
		IBVREnabledEditor bvrEnabledEditor = (IBVREnabledEditor) Platform.getAdapterManager().getAdapter(activeEditor, IBVREnabledEditor.class);
		
		if(bvrEnabledEditor != null) {
			Context.eINSTANCE.logger.debug("found suitabale adapter: " + bvrEnabledEditor + " for the editor: " + activeEditor);
			return bvrEnabledEditor.getSelectedObjects();
		}
		
		if(activeEditor instanceof IBVREnabledEditor) {
			Context.eINSTANCE.logger.debug("editor implements IBVREnabledEditor: " + activeEditor);
			return ((IBVREnabledEditor) activeEditor).getSelectedObjects();
		}
	
		if(activeEditor.getSite().getSelectionProvider() == null) {
			Context.eINSTANCE.logger.debug("can not find selection provider for editor, nothing to grab from selection, editor: " + activeEditor);
			return new ArrayList<Object>();
		}
		
		Context.eINSTANCE.logger.debug("using default selection provider to grab selected elements, editor: " + activeEditor);
		ISelection selection = activeEditor.getSite().getSelectionProvider().getSelection();
		StructuredSelection structuredSelection = (StructuredSelection) selection;
		return structuredSelection.toList();
	}

	@Override
	public void highlightObjects(EList<HashMap<EObject, Integer>> objectsToHighlightList) {
		final HashMap<EObject, Integer> objectsToHiglight = new HashMap<EObject, Integer>();
		for(HashMap<EObject, Integer> pair : objectsToHighlightList){
			if(pair.size() != 1){
				Context.eINSTANCE.logger.debug("a hash map has more than one object to highlight or is empty, that is weird, skip it" + pair);
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
				if(type == IBVREnabledEditor.HL_PLACEMENT_IN && pair.get(key) == IBVREnabledEditor.HL_PLACEMENT_OUT
						|| type == IBVREnabledEditor.HL_PLACEMENT_OUT && pair.get(key) == IBVREnabledEditor.HL_PLACEMENT_IN
						|| (type == IBVREnabledEditor.HL_PLACEMENT_IN_OUT && (pair.get(key) == IBVREnabledEditor.HL_PLACEMENT_OUT || pair.get(key) == IBVREnabledEditor.HL_PLACEMENT_IN))){
					pair.put(key, IBVREnabledEditor.HL_PLACEMENT_IN_OUT);
				}else if(type == IBVREnabledEditor.HL_REPLACEMENT_IN && pair.get(key) == IBVREnabledEditor.HL_REPLACEMENT_OUT
						|| type == IBVREnabledEditor.HL_REPLACEMENT_OUT && pair.get(key) == IBVREnabledEditor.HL_REPLACEMENT_IN
						|| (type == IBVREnabledEditor.HL_REPLACEMENT_IN_OUT && (pair.get(key) == IBVREnabledEditor.HL_REPLACEMENT_OUT || pair.get(key) == IBVREnabledEditor.HL_REPLACEMENT_IN))){
					pair.put(key, IBVREnabledEditor.HL_REPLACEMENT_IN_OUT);
				}else if(type != pair.get(key)){
					Context.eINSTANCE.logger.debug("have no idea how to highlight element (highlighting will be partially correct): " + key);
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
		    		if(editorPart != null && Platform.getAdapterManager().getAdapter(editorPart, IBVREnabledEditor.class) != null) {
		    			IBVREnabledEditor bvrEnabledEditor = (IBVREnabledEditor) Platform.getAdapterManager().getAdapter(editorPart, IBVREnabledEditor.class);
		    			bvrEnabledEditor.clearHighlighting();
		    			highlightObjects(bvrEnabledEditor, objects);
		    		} else if(editorPart != null && !(editorPart instanceof IBVREnabledEditor)){
		    			try {
		    				ProxyThirdPartyTreeEditor bvrEnabledEditor = new ProxyThirdPartyTreeEditor((EditorPart) editorPart);
		    				bvrEnabledEditor.clearHighlighting();
		    				highlightObjects(bvrEnabledEditor, objects);
		    				bvrEnabledEditor.expandHiglightedObjects();
						} catch (Exception e) {
							Context.eINSTANCE.logger.debug("unsupported editor: -->"+ editorPart.getClass().toString() + "<--, can not highlight due to : " + e.getMessage());
						}
		    		}else if (editorPart != null && (editorPart instanceof IBVREnabledEditor)){
		    			IBVREnabledEditor bvrEnabledEditor = (IBVREnabledEditor) editorPart;
		    			bvrEnabledEditor.clearHighlighting();
		    			highlightObjects(bvrEnabledEditor, objects);
		    		}else{
		    			String editorName = (String) ((editorPart != null) ? editorPart.getClass().toString() : "null");
		    			Context.eINSTANCE.logger.debug("unsupported editor: -->" + editorName + "<--, can not highlight anything");
		    		}
		    	}
		    }
		
			private void highlightObjects(final IBVREnabledEditor editor, final HashMap<EObject, Integer> objects){
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
		    		if(editorPart != null && Platform.getAdapterManager().getAdapter(editorPart, IBVREnabledEditor.class) != null) {
		    			IBVREnabledEditor bvrEnabledEditor = (IBVREnabledEditor) Platform.getAdapterManager().getAdapter(editorPart, IBVREnabledEditor.class);
		    			bvrEnabledEditor.clearHighlighting();
		    		} else if(editorPart != null && !(editorPart instanceof IBVREnabledEditor)){
		    			try {
		    				IBVREnabledEditor editor = new ProxyThirdPartyTreeEditor((EditorPart) editorPart);
		    				editor.clearHighlighting();
						} catch (Exception e) {
							Context.eINSTANCE.logger.debug("unsupported editor: -->"+ editorPart.getClass() + "<--, can not clear highlighting (if any) due to: " + e.getMessage());
						}
		    		}if (editorPart != null && (editorPart instanceof IBVREnabledEditor)){
		    			IBVREnabledEditor bvrEnabledEditor = (IBVREnabledEditor) editorPart;
		    			bvrEnabledEditor.clearHighlighting();
		    		}else{
		    			String editorName = (String) ((editorPart != null) ? editorPart.getClass().toString() : "null");
		    			Context.eINSTANCE.logger.debug("unsupported editor: -->" + editorName + "<--, can not clear highlighting (if any)");
		    		}
		    	}				
			}
		});
	}
}
