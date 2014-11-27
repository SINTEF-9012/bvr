package no.sintef.bvr.ui.editor.mvc.type;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import no.sintef.bvr.ui.editor.common.IBVRTypeEditorInput;
import no.sintef.bvr.ui.editor.common.IMVCTypeEditor;
import no.sintef.bvr.ui.editor.common.MVCEditor;

public class MVCTypeEditor extends MVCEditor implements IMVCTypeEditor {

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		super.init(site, input);
		
		//close Type editor if VType is null
		final EditorPart editor = this;
		if(!(input instanceof IBVRTypeEditorInput) ||
				(input instanceof IBVRTypeEditorInput &&
						((IBVRTypeEditorInput<?>)input).getVType() == null)) {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					getSite().getPage().closeEditor(editor, false);
				}
			});
		}
	}
	
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

}
