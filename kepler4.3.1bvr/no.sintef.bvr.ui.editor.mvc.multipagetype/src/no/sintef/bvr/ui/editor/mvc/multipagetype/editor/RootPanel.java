package no.sintef.bvr.ui.editor.mvc.multipagetype.editor;

import no.sintef.bvr.ui.editor.mvc.multipagetype.abstraction.IPanel;
import no.sintef.bvr.ui.editor.mvc.multipagetype.abstraction.ISashFormContainer;
import no.sintef.bvr.ui.editor.mvc.multipagetype.abstraction.ISashedMultiTabEditor;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class RootPanel implements ISashedMultiTabEditor, IPanel {

	private SashFormWindow sashedContainer;
	private Composite parentContainer;
	
	public RootPanel(Composite parent) {
		parentContainer = parent;
		sashedContainer = new SashFormWindow(parentContainer);
	}
	
	@Override
	public ISashFormContainer getSashFormContainer() {
		return sashedContainer;
	}
	
	public void createPartControl(Control control) {
		
	};

}
