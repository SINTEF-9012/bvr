package no.sintef.bvr.tool.ui.edit;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.command.Command;
import no.sintef.bvr.tool.controller.command.UpdateVariableValueAssignment;
import no.sintef.bvr.tool.exception.RethrownException;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import bvr.ValueResolution;


public class VariableValueAssignmentPropertyEditor extends ElementPropertyEditor {

	private static final long serialVersionUID = 3611454599635119210L;


	@SuppressWarnings("unchecked")
	public VariableValueAssignmentPropertyEditor(BVRUIKernel kernel, Command _command, ValueResolution elem, JComponent _node, BVRNotifiableController _controller) {
    	super(kernel, _command, elem, _node, _controller);

        JPanel p2 = new JPanel(new SpringLayout());
        p2.setBorder(null);
        p2.setOpaque(false);
		
        JLabel l2 = new JLabel("Value", JLabel.TRAILING);

        p2.add(l2);
        JTextField textField2 = new JTextField(15);

        l2.setLabelFor(textField2);
        p2.add(textField2);
        
        String value = controller.getResolutionControllerInterface().getValueReolutionStringValue(node);
        textField2.setText(value);
        
        top.add(p2);
        SpringUtilities.makeCompactGrid(p2,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        
        pack(2,1);
        
        ((UpdateVariableValueAssignment) command).setValue(value);
        
        textField2.addKeyListener(new EnterAccepter(command, kernel.getEditorPanel()));
        
        textField2.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
            	try {
					((UpdateVariableValueAssignment) command).setValue(e.getDocument().getText(0, e.getDocument().getLength()));
				} catch (BadLocationException error) {
					throw new RethrownException("failed to get a value", error);
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
}
