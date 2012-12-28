package no.sintef.cvl.ui.edit;

import no.sintef.cvl.ui.commands.UpdateChoice;
import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.loader.CVLView;
import cvl.VSpec;

public class ChoicePropertyEditor extends VSpecPropertyEditor{
	
    protected void init() {
    	command = new UpdateChoice();
    	command.init(null, vSpec, null, null, null, null, view);
    }

	public ChoicePropertyEditor(CVLUIKernel kernel, VSpec elem, CVLView view) {
		super(kernel, (VSpec) elem, view);
	}

}
