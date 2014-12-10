package no.sintef.bvr.ui.editor.mvc.multipagetype.editor;

import no.sintef.bvr.ui.editor.mvc.multipagetype.abstraction.AbstractTabItemFolder;
import no.sintef.bvr.ui.editor.mvc.multipagetype.abstraction.IFolder;
import no.sintef.bvr.ui.editor.mvc.multipagetype.abstraction.IPanel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Control;


public class DragableCTabItemFolder extends AbstractTabItemFolder implements IPanel {

	private CTabItem item;
	
	public DragableCTabItemFolder(IFolder _folder) {
		folder = _folder;
	}
	
	public void createPartControl(Control control){
		item = new CTabItem(((DragableCTabFolder) folder).getCTabFolder(), SWT.NONE);
		item.setControl(control);
		((DragableCTabFolder) folder).getCTabFolder().setSelection(item);
	}
	
	public CTabItem getCTabItem() {
		return item;
	}
}
