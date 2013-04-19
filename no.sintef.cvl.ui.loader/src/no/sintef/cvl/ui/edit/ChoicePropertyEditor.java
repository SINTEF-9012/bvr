package no.sintef.cvl.ui.edit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.explodingpixels.macwidgets.plaf.HudLabelUI;
import com.explodingpixels.macwidgets.plaf.HudTextFieldUI;

import no.sintef.cvl.ui.commands.UpdateChoice;
import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.loader.CVLView;
import cvl.BCLConstraint;
import cvl.VClassifier;
import cvl.VSpec;

public class ChoicePropertyEditor extends ElementPropertyEditor{
	
    protected void init() {
    	command = new UpdateChoice();
    	command.init(null, obj, null, null, null, null, view);
    }

	public ChoicePropertyEditor(CVLUIKernel kernel, VSpec elem, CVLView view) {
		super(kernel, (VSpec) elem, view);
	}

}
