package no.sintef.bvr.tool.ui.edit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import no.sintef.bvr.tool.ui.command.UpdateVariableValueAssignment;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;

import bvr.BCLExpression;
import bvr.BooleanLiteralExp;
import bvr.IntegerLiteralExp;

import bvr.PrimitiveValueSpecification;
import bvr.RealLiteralExp;
import bvr.StringLiteralExp;
import bvr.UnlimitedLiteralExp;
import bvr.ValueSpecification;
//import bvr.VariableValueAssignment;


/*
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


	
}*/
