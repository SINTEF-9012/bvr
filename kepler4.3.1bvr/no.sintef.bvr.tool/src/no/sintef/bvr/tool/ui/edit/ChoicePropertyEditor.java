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

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.Command;
import no.sintef.bvr.tool.ui.command.UpdateChoice;
import no.sintef.bvr.tool.ui.command.UpdateVSpec;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import bvr.CompoundNode;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitveType;
import bvr.VSpec;
import bvr.Variable;

public class ChoicePropertyEditor extends ElementPropertyEditor{
	
	private static final long serialVersionUID = -561022693337041081L;

	public ChoicePropertyEditor(BVRUIKernel kernel, Command okCommand,  VSpec elem, BVRNotifiableController controller) {
		super(kernel, okCommand, (VSpec) elem, controller);
		
        // Comment
        JPanel p = new JPanel(new SpringLayout());
        p.setBorder(null);
        p.setOpaque(false);
        
        JLabel l = new JLabel("Comment", JLabel.TRAILING);
        //l.setUI(new HudLabelUI());

        p.add(l);
        JTextField comment = new JTextField(15);
        //textField.setUI(new HudTextFieldUI());

        l.setLabelFor(comment);
        p.add(comment);
       // comment.setText(elem.getComment());

        top.add(p);
        SpringUtilities.makeCompactGrid(p,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        
        comment.addKeyListener(new EnterAccepter(command, kernel.getEditorPanel()));

        comment.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                try {
                    ((UpdateVSpec) command).setComment(e.getDocument().getText(0, e.getDocument().getLength()));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(NamedElementPropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            public void removeUpdate(DocumentEvent e) {
            	insertUpdate(e);
            }

            public void changedUpdate(DocumentEvent e) {
            	insertUpdate(e);
            }
        }); 
		
        // Vars
		int count = 2;
		for(Variable x : ((CompoundNode) elem).getVariable()){
			addEdit(elem, x);
			count++;
		}
		
        pack(count, 1);
	}

	private void addEdit(VSpec elem, final Variable v) {
	    // Part 1
        JPanel panel = new JPanel(new SpringLayout());
        panel.setBorder(null);
        panel.setOpaque(false);
        
        // Name
        final JTextField name = new JTextField(10);
        name.setText(v.getName());
        
        // Type
        JLabel l = new JLabel(((PrimitveType)v.getType()).getType().getName(), JLabel.TRAILING);
        
        final JComboBox types = new JComboBox();
        int index = 0;
        for(PrimitiveTypeEnum x : PrimitiveTypeEnum.VALUES){
        	types.addItem(x.getName());
        	if(x.getName().equals(((PrimitveType)v.getType()).getType().getName())){
        		types.setSelectedIndex(index);
        	}
        	index++;
        }
        
        // Add
        panel.add(name);
        panel.add(types);
        
        // Done
        top.add(panel);
        SpringUtilities.makeCompactGrid(panel,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        
        //Part 2
        ((UpdateChoice)command).setVar(v, v.getName(), ((PrimitveType)v.getType()).getType().getName());
        
        name.addKeyListener(new EnterAccepter(command, kernel.getEditorPanel()));
        types.addKeyListener(new EnterAccepter(command, kernel.getEditorPanel()));
        
    	// Part 3:
        DocumentListener dl = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
            	((UpdateChoice)command).setVar(v, name.getText(), types.getSelectedItem().toString());
            	//System.out.println("Set " + v.getName() + " to " + name.getText() + "," + types.getSelectedItem());
            }
            public void removeUpdate(DocumentEvent e) {
            	insertUpdate(e);
            }
            public void changedUpdate(DocumentEvent e) {
            	insertUpdate(e);
            }
        };
        name.getDocument().addDocumentListener(dl);
        types.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
            	((UpdateChoice)command).setVar(v, name.getText(), types.getSelectedItem().toString());
            	//System.out.println("Set " + v.getName() + " to " + name.getText() + "," + types.getSelectedItem());
            }
        });
	}

}
