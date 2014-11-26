package no.sintef.bvr.ui.editor.mvc.multipagetype.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import no.sintef.bvr.ui.editor.common.MVCEditor;


public class MultiPageTypeEditor extends MVCEditor {

	private int index = 0; 
	private RootPanel rootPanel;
	
	@Override
	public void setTitle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createView() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createPartControl(Composite parent) {
		rootPanel = new RootPanel(parent);
		createPage();
	}
	
	void createPage() {
		DragableCTabFolder dragableFolder = ((DragableCTabFolder) rootPanel.getSashFormContainer().getFolderList().get(0));
		CTabFolder cTabFolder = dragableFolder.getCTabFolder();
		
		Composite composite = new Composite(cTabFolder, SWT.NONE);
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);
		layout.numColumns = 2;

		Button fontButton = new Button(composite, SWT.NONE);
		GridData gd = new GridData(GridData.BEGINNING);
		gd.horizontalSpan = 2;
		fontButton.setLayoutData(gd);
		fontButton.setText("Create Tab "+ index +"...");
		
		fontButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				createPage();
			}
		});
		
		DragableCTabItemFolder item = dragableFolder.creatTabItem(composite);
		item.getCTabItem().setText("Tab " + index);
		index ++;
	}
}
