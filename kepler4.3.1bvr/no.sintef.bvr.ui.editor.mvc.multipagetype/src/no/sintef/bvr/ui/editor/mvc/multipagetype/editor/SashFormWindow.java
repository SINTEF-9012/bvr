package no.sintef.bvr.ui.editor.mvc.multipagetype.editor;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.ui.editor.mvc.multipagetype.abstraction.IFolder;
import no.sintef.bvr.ui.editor.mvc.multipagetype.abstraction.ISashFormContainer;

import org.eclipse.swt.widgets.Composite;


public class SashFormWindow implements ISashFormContainer {

	private Composite container;
	private List<IFolder> folders = new ArrayList<IFolder>();
	
	public SashFormWindow(Composite _parent) {
		container = _parent;
		addFolder(new DragableCTabFolder(container));
	} 
	
	@Override
	public List<IFolder> getFolderList() {
		return folders;
	}

	@Override
	public void addFolder(IFolder iFolder) {
		folders.add(iFolder);
	}

	@Override
	public void removeFolder(IFolder iFolder) {
		// TODO Auto-generated method stub

	}
}
