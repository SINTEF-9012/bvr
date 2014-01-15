package no.sintef.cvl.tool.ui.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

import com.explodingpixels.macwidgets.plaf.HudLabelUI;
import com.explodingpixels.macwidgets.plaf.HudTextFieldUI;

import no.sintef.cvl.tool.ui.command.UpdateChoice;
import no.sintef.cvl.tool.ui.command.UpdateVClassifier;
import no.sintef.cvl.tool.ui.command.UpdateVSpec;
import no.sintef.cvl.tool.ui.editor.CVLUIKernel;
import no.sintef.cvl.tool.ui.loader.VSpecView;
import cvl.Choice;
import cvl.ConfigurableUnit;
import cvl.PrimitiveTypeEnum;
import cvl.PrimitveType;
import cvl.VSpec;
import cvl.Variable;

public class ConfigurableUnitPropertyEditor extends ElementPropertyEditor{
	
    protected void init() {
    	command = new UpdateVSpec();
    	command.init(null, obj, null, null, null, null, view);
    }

	public ConfigurableUnitPropertyEditor(CVLUIKernel kernel, ConfigurableUnit elem, VSpecView view) {
		super(kernel, elem, view);
	}

}
