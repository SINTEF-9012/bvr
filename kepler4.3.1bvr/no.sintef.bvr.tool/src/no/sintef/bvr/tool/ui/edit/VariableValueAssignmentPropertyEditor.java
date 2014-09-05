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

import no.sintef.bvr.tool.ui.command.UpdateChoice;
import no.sintef.bvr.tool.ui.command.UpdateVClassifier;
import no.sintef.bvr.tool.ui.command.UpdateVInstance;
import no.sintef.bvr.tool.ui.command.UpdateVariableValueAssignment;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRToolView;
import bvr.BCLExpression;
import bvr.BooleanLiteralExp;
import bvr.IntegerLiteralExp;
import bvr.NamedElement;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
import bvr.RealLiteralExp;
import bvr.StringLiteralExp;
import bvr.UnlimitedLiteralExp;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.ValueSpecification;
import bvr.Variable;

public class VariableValueAssignmentPropertyEditor extends ElementPropertyEditor{
    public VariableValueAssignmentPropertyEditor(BVRUIKernel _kernel,
			NamedElement _obj, BVRToolView _view) {
		super(_kernel, _obj, _view);
		// TODO Auto-generated constructor stub
	}

	protected void init() {
    	command = new UpdateVariableValueAssignment();
    	command.init(null, obj, null, null, null, null, view);
    }

	/*public VariableValueAssignmentPropertyEditor(BVRUIKernel kernel, VariableValueAssignment elem, BVRToolView view) {
		super(kernel, elem, view);
		
		// Find value
		String value = "";
		value = getValueAsString(elem);
		
	    // Value
        JPanel p2 = new JPanel(new SpringLayout());
        p2.setBorder(null);
        p2.setOpaque(false);
		
        JLabel l2 = new JLabel("Value", JLabel.TRAILING);

        p2.add(l2);
        final JTextField textField2 = new JTextField(15);

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
	}*/
}
