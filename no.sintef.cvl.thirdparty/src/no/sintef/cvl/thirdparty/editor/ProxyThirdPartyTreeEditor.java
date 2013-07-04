package no.sintef.cvl.thirdparty.editor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;


import no.sintef.cvl.thirdparty.exception.NotSupportedThirdPartyEditor;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.MultiPageEditorPart;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;


/*in fact not really a full proxy since we do not redirect all calls to the proxied object (editor), i think we should use something described here
 * http://docs.oracle.com/javase/6/docs/technotes/guides/reflection/proxy.html */

public class ProxyThirdPartyTreeEditor extends MultiPageEditorPart
	implements IEditingDomainProvider, ISelectionProvider, IMenuListener, IViewerProvider, IGotoMarker, ICVLEnabledEditor {
	
	private MultiPageEditorPart editor;
	private TreeViewer treeViewer;
	private CVLLabelProvider labelProvider = null;

	public ProxyThirdPartyTreeEditor(Object multiPageEditor) throws NotSupportedThirdPartyEditor {
		if(Display.getDefault() == null)
			throw new UnsupportedOperationException("Display is null, can not do any operation which reflects UI, wrapp this call in the Display thread");
		if(!(multiPageEditor instanceof MultiPageEditorPart))
			throw new NotSupportedThirdPartyEditor("active editor should extend MultiPageEditorPart, can not highlight anything");
		if(!(multiPageEditor instanceof IEditingDomainProvider))
			throw new NotSupportedThirdPartyEditor("MultiPageEditorPart editor does not implement IEditingDomainProvider interface, can not highlight anything");
		if(!(multiPageEditor instanceof ISelectionProvider))
			throw new NotSupportedThirdPartyEditor("MultiPageEditorPart editor does not implement ISelectionProvider interface, can not highlight anything");
		if(!(multiPageEditor instanceof IMenuListener))
			throw new NotSupportedThirdPartyEditor("MultiPageEditorPart editor does not implement IMenuListener interface, can not highlight anything");
		if(!(multiPageEditor instanceof IGotoMarker))
			throw new NotSupportedThirdPartyEditor("MultiPageEditorPart editor does not implement IGotoMarker interface, can not highlight anything");
		if(!(multiPageEditor instanceof IViewerProvider))
			throw new NotSupportedThirdPartyEditor("MultiPageEditorPart editor does not implement IViewerProvider interface, can not highlight anything");
		
		editor = (MultiPageEditorPart) multiPageEditor;
		Viewer viewer = getViewer();
		if(!(viewer instanceof TreeViewer))
			throw new NotSupportedThirdPartyEditor("MultiPageEditorPart should represent tree view editor, can not highlight anything");
		treeViewer = (TreeViewer) viewer;
		
		
		// Extend the label provider to support colors and fonts
		if(!(treeViewer.getLabelProvider() instanceof CVLLabelProvider)){
			AdapterFactoryLabelProvider old = (AdapterFactoryLabelProvider) treeViewer.getLabelProvider();
			labelProvider = new CVLLabelProvider(old);
			treeViewer.setLabelProvider(labelProvider);
		}else{
			labelProvider = (CVLLabelProvider) treeViewer.getLabelProvider();
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
	public void selectObjects(ArrayList<Object> objects) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public void gotoMarker(IMarker marker) {
		((IGotoMarker) editor).gotoMarker(marker);
		
	}

	@Override
	public Viewer getViewer() {
		return ((IViewerProvider) editor).getViewer();
	}

	@Override
	public void menuAboutToShow(IMenuManager manager) {
		((IMenuListener) editor).menuAboutToShow(manager);
	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		((ISelectionProvider) editor).addSelectionChangedListener(listener);
	}

	@Override
	public ISelection getSelection() {
		return ((ISelectionProvider) editor).getSelection();
	}

	@Override
	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		((ISelectionProvider) editor).removeSelectionChangedListener(listener);
	}

	@Override
	public void setSelection(ISelection selection) {
		((ISelectionProvider) editor).setSelection(selection);
	}

	@Override
	public EditingDomain getEditingDomain() {
		return ((IEditingDomainProvider) editor).getEditingDomain();
	}

	@Override
	protected void createPages() {
		Method method;
		try {
			method = editor.getClass().getMethod("createPages");
			method.invoke(editor, new Object[0]);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new UnsupportedOperationException(e.getStackTrace().toString());
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		Method method;
		try {
			method = editor.getClass().getMethod("doSave", new Class[] {IProgressMonitor.class});
			method.invoke(editor, new Object[] {monitor});
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new UnsupportedOperationException(e.getStackTrace().toString());
		}
	}

	@Override
	public void doSaveAs() {
		Method method;
		try {
			method = editor.getClass().getMethod("doSaveAs");
			method.invoke(editor, new Object[0]);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new UnsupportedOperationException(e.getStackTrace().toString());
		}
	}

	@Override
	public boolean isSaveAsAllowed() {
		Method method;
		try {
			method = editor.getClass().getMethod("isSaveAsAllowed");
			return (boolean) method.invoke(editor, new Object[0]);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new UnsupportedOperationException(e.getStackTrace().toString());
		}
	}
	
	public void expandHiglightedObjects(){
		treeViewer.expandAll();
	}
}
