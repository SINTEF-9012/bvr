package no.sintef.bvr.tool.ui.edit;

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

import no.sintef.bvr.tool.ui.command.UpdateChoice;
import no.sintef.bvr.tool.ui.command.UpdateVClassifier;
import no.sintef.bvr.tool.ui.command.UpdateVSpec;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.Choice;
import bvr.ConfigurableUnit;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitveType;
import bvr.VSpec;
import bvr.Variable;

public class ConfigurableUnitPropertyEditor extends ElementPropertyEditor{
	
    protected void init() {
    	command = new UpdateVSpec();
    	command.init(null, obj, null, null, null, null, view);
    }

	public ConfigurableUnitPropertyEditor(BVRUIKernel kernel, ConfigurableUnit elem, BVRView view) {
		super(kernel, elem, view);
	}

}
