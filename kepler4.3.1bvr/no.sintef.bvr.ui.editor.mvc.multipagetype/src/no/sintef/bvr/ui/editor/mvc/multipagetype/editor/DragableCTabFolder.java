package no.sintef.bvr.ui.editor.mvc.multipagetype.editor;


import no.sintef.bvr.ui.editor.mvc.multipagetype.abstraction.AbstractTabFolder;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;


public class DragableCTabFolder extends AbstractTabFolder {

	private CTabFolder folder;
	private Composite container;
	
	public DragableCTabFolder(Composite parent) {
		container = parent;
		container.setLayout(new FillLayout());
		folder = new CTabFolder(container, SWT.BOTTOM | SWT.FLAT | SWT.CLOSE);
	}
	
	public CTabFolder getCTabFolder() {
		return folder;
	}
	
	public DragableCTabItemFolder creatTabItem(Control container) {
		DragableCTabItemFolder item = new DragableCTabItemFolder(this);
		item.createPartControl(container);
		addItem(item);
		return item;
	}
}
