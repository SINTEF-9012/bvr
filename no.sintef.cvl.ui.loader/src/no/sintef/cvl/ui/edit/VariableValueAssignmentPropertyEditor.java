package no.sintef.cvl.ui.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import no.sintef.cvl.ui.commands.UpdateChoice;
import no.sintef.cvl.ui.commands.UpdateVClassifier;
import no.sintef.cvl.ui.commands.UpdateVInstance;
import no.sintef.cvl.ui.commands.UpdateVariableValueAssignment;
import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.loader.CVLView;

import com.explodingpixels.macwidgets.plaf.HudLabelUI;
import com.explodingpixels.macwidgets.plaf.HudTextFieldUI;

import cvl.BCLExpression;
import cvl.BooleanLiteralExp;
import cvl.IntegerLiteralExp;
import cvl.PrimitiveTypeEnum;
import cvl.PrimitiveValueSpecification;
import cvl.PrimitveType;
import cvl.RealLiteralExp;
import cvl.StringLiteralExp;
import cvl.UnlimitedLiteralExp;
import cvl.VClassifier;
import cvl.VInstance;
import cvl.VSpec;
import cvl.ValueSpecification;
import cvl.Variable;
import cvl.VariableValueAssignment;

public class VariableValueAssignmentPropertyEditor extends ElementPropertyEditor{
    protected void init() {
    	command = new UpdateVariableValueAssignment();
    	command.init(null, obj, null, null, null, null, view);
    }

	public VariableValueAssignmentPropertyEditor(CVLUIKernel kernel, VariableValueAssignment elem, CVLView view) {
		super(kernel, elem, view);
		
		// Find value
		String value = "";
		value = getValueAsString(elem);
		
	    // Value
        JPanel p2 = new JPanel(new SpringLayout());
        p2.setBorder(null);
        p2.setOpaque(false);
		
        JLabel l2 = new JLabel("Value", JLabel.TRAILING);
        l2.setUI(new HudLabelUI());

        p2.add(l2);
        final JTextField textField2 = new JTextField(15);
        textField2.setUI(new HudTextFieldUI());

        l2.setLabelFor(textField2);
        p2.add(textField2);
        textField2.setText(value);
        
        top.add(p2);
        SpringUtilities.makeCompactGrid(p2,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
		
        pack(2, 1);
        
        ((UpdateVariableValueAssignment)command).setValue(value);
    	
    	textField2.addKeyListener(new EnterAccepter(command, kernel.getEditorPanel()));
        
        textField2.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                try {
                	String value = textField2.getText();
                	((UpdateVariableValueAssignment)command).setValue(value);
                } catch (java.lang.NumberFormatException nfe) {
                }
            }
            public void removeUpdate(DocumentEvent e) {
            	insertUpdate(e);
            }
            public void changedUpdate(DocumentEvent e) {
            	insertUpdate(e);
            }
        });
	}

	private String getValueAsString(VariableValueAssignment elem) {
		String value = "";
		ValueSpecification vs = elem.getValue();
		if(vs instanceof PrimitiveValueSpecification){
			PrimitiveValueSpecification pvs = (PrimitiveValueSpecification) vs;
			BCLExpression e = pvs.getExpression();
			if(e instanceof StringLiteralExp){
				StringLiteralExp sle = (StringLiteralExp) e;
				value = sle.getString();
			}else if(e instanceof IntegerLiteralExp){
				IntegerLiteralExp sle = (IntegerLiteralExp) e;
				value = ""+sle.getInteger();
			}else if(e instanceof RealLiteralExp){
				RealLiteralExp sle = (RealLiteralExp) e;
				value = sle.getReal();
			}else if(e instanceof BooleanLiteralExp){
				BooleanLiteralExp sle = (BooleanLiteralExp) e;
				value = ""+sle.isBool();
			}else if(e instanceof UnlimitedLiteralExp){
				UnlimitedLiteralExp sle = (UnlimitedLiteralExp) e;
				value = ""+sle.getUnlimited();
			}else{
				throw new UnsupportedOperationException();
			}
		}else{
			throw new UnsupportedOperationException();
		}
		return value;
	}
}
