package no.sintef.cvl.ui.thirdparty;

import java.util.ArrayList;

import no.sintef.cvl.ui.exceptions.UnexpectedException;

import org.eclipse.ui.part.MultiPageEditorPart;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

public class ProxyThirdPartyEditor implements ICVLEnabledEditor{
	
	private MultiPageEditorPart editor;
	private Viewer viewer;

	public ProxyThirdPartyEditor(MultiPageEditorPart multiPageEditor) throws UnexpectedException{
		if(multiPageEditor instanceof IViewerProvider)
			throw new UnexpectedException("MultiPageEditorPart editor does not implement IViewerProvider interface, can not highlight anything");
		editor = multiPageEditor;
		viewer = ((IViewerProvider) editor).getViewer();
		if(viewer instanceof TreeViewer)
			throw new UnexpectedException("");
	}

	@Override
	public void highlightObject(String xmi_id, int type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearHighlighting() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Object> getSelectedObjects() {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public void selectObjects(ArrayList<String> objects) {
		throw new UnsupportedOperationException("not implemented");
	}

}
