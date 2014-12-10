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
package no.sintef.bvr.thirdparty.editor;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import no.sintef.bvr.thirdparty.exception.NotSupportedThirdPartyEditor;
import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;



public class ProxyThirdPartyTreeEditor extends EditorPart
	implements IViewerProvider, IBVREnabledEditor {
	
	private EditorPart editor;
	private BVRLabelProvider labelProvider;
	private TreeViewer treeViewer;

	public ProxyThirdPartyTreeEditor(EditorPart editorPart) throws NotSupportedThirdPartyEditor {
		if(Display.getDefault() == null)
			throw new UnsupportedOperationException("Display is null, can not do any operation which reflects UI, wrap this call in the Display thread");
		
		if(!(editorPart instanceof IViewerProvider))
			throw new NotSupportedThirdPartyEditor("editorPart editor does not implement IViewerProvider interface, can not highlight anything");
		
		editor = (EditorPart) editorPart;
		Viewer viewer = getViewer();
		if(!(viewer instanceof TreeViewer))
			throw new NotSupportedThirdPartyEditor("MultiPageEditorPart should represent tree view editor, can not highlight anything");
		treeViewer = (TreeViewer) viewer;
			
		// Extend the label provider to support colors and fonts
		if(!(treeViewer.getLabelProvider() instanceof BVRLabelProvider)){
			ILabelProvider old = (ILabelProvider) treeViewer.getLabelProvider();
			labelProvider = new BVRLabelProvider(old);
			treeViewer.setLabelProvider(labelProvider);
		}else{
			labelProvider = (BVRLabelProvider) treeViewer.getLabelProvider();
		}
	}

	@Override
	public void highlightObject(Object object, int type) {
		if (labelProvider == null) return;
		if(!(object instanceof EObject))
			throw new UnsupportedOperationException("can not highlight non EObject");
		labelProvider.highlightObject(IDProvider.getObjectId((EObject) object), type);
		getViewer().refresh();
	}

	@Override
	public void clearHighlighting() {
		if (labelProvider == null) return;
		labelProvider.clearHighlighting();
		getViewer().refresh();
	}

	@Override
	public ArrayList<Object> getSelectedObjects() {
		ArrayList<Object> result = new ArrayList<Object>();
		if (getViewer().getSelection() != null && getViewer().getSelection() instanceof TreeSelection) {
			TreeSelection s = (TreeSelection)getViewer().getSelection();
			Iterator<Object> it = s.iterator();
			while(it.hasNext()) {
				result.add(it.next());
			}
		}
		return result;
	}

	@Override
	public void selectObjects(List<Object> objects) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public Viewer getViewer() {
		return ((IViewerProvider) editor).getViewer();
	}
	
	public void expandHiglightedObjects(){
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(treeViewer.getInput());
		ResourceSet resourceSet = domain.getResourceSet();
		IPath ipath = ((IFileEditorInput) editor.getEditorInput()).getFile().getFullPath();
		URI uri = URI.createPlatformResourceURI(ipath.toOSString(), true);
		Resource resource = resourceSet.getResource(uri, true);
		for(TreeIterator<EObject> contents = resource.getAllContents(); contents.hasNext();){
			EObject eObject = contents.next();
			String eObjectId = IDProvider.getObjectId(eObject);
			if(labelProvider.highlight.containsKey(eObjectId)){
				Integer type = labelProvider.highlight.get(eObjectId);
				treeViewer.expandToLevel(eObject, ((type == IBVREnabledEditor.HL_PLACEMENT) || (type == IBVREnabledEditor.HL_REPLACEMENT)) ? treeViewer.ALL_LEVELS : 0);
			}
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		editor.doSave(monitor);
		
	}

	@Override
	public void doSaveAs() {
		editor.doSaveAs();
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		editor.init(site, input);
	}

	@Override
	public boolean isDirty() {
		return editor.isDirty();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return editor.isSaveAsAllowed();
	}

	@Override
	public void createPartControl(Composite parent) {
		editor.createPartControl(parent);
	}

	@Override
	public void setFocus() {
		editor.setFocus();
	}
}
