package no.sintef.bvr.tool.ui.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.controller.command.UpdateChoiceOccurence;
import no.sintef.bvr.tool.exception.RethrownException;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import bvr.ChoiceOccurrence;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitveType;
import bvr.VSpec;
import bvr.Variable;
import bvr.VNode;


public class ChoiceOccurencePropertyEditor extends ElementPropertyEditor {
	
	private static final long serialVersionUID = -561022693337041081L;

	@SuppressWarnings("unchecked")
	public ChoiceOccurencePropertyEditor(BVRUIKernel kernel, Command okCommand,  VSpec elem, JComponent node, BVRNotifiableController controller) {
		super(kernel, okCommand, (VSpec) elem, node, controller);
		
        // Type
        JPanel pt = new JPanel(new SpringLayout());
        pt.setBorder(null);
        pt.setOpaque(false);
        
        JLabel lt = new JLabel("Type", JLabel.TRAILING);

        pt.add(lt);
        JTextField type = new JTextField(15);

        lt.setLabelFor(type);
        pt.add(type);
        
        String setType = (((ChoiceOccurrence) elem).getVType() != null) ? ((ChoiceOccurrence) elem).getVType().getName() : Constants.DEFAULT_VTYPE_TITLE;
        type.setText(setType);
        ((UpdateChoiceOccurence) command).setChoiceType(setType);

        top.add(pt);
        SpringUtilities.makeCompactGrid(pt,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        
        type.addKeyListener(new EnterAccepter(command, kernel.getEditorPanel()));

        type.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                try {
                    ((UpdateChoiceOccurence) command).setChoiceType(e.getDocument().getText(0, e.getDocument().getLength()));
                } catch (BadLocationException ex) {
                	throw new RethrownException("input error in Type", ex);
                }
            }

            public void removeUpdate(DocumentEvent e) {
            	insertUpdate(e);
            }

            public void changedUpdate(DocumentEvent e) {
            	insertUpdate(e);
            }
        });

        // Comment
        JPanel p = new JPanel(new SpringLayout());
        p.setBorder(null);
        p.setOpaque(false);
        
        JLabel l = new JLabel("Comment", JLabel.TRAILING);

        p.add(l);
        JTextField comment = new JTextField(15);

        l.setLabelFor(comment);
        p.add(comment);
        String setComment = controller.getVSpecControllerInterface().getNodesCommentText(node);
        comment.setText(setComment);
        ((UpdateChoiceOccurence) command).setComment(setComment);

        top.add(p);
        SpringUtilities.makeCompactGrid(p,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        
        comment.addKeyListener(new EnterAccepter(command, kernel.getEditorPanel()));

        comment.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                try {
                    ((UpdateChoiceOccurence) command).setComment(e.getDocument().getText(0, e.getDocument().getLength()));
                } catch (BadLocationException ex) {
                	throw new RethrownException("input error in Comment", ex);
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
		int count = 3;
		for(Variable x : ((VNode) elem).getVariable()){
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
        ((UpdateChoiceOccurence) command).setVariable(v, v.getName(), ((PrimitveType)v.getType()).getType().getName());
        
        name.addKeyListener(new EnterAccepter(command, kernel.getEditorPanel()));
        types.addKeyListener(new EnterAccepter(command, kernel.getEditorPanel()));
        
    	// Part 3:
        DocumentListener dl = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
            	((UpdateChoiceOccurence) command).setVariable(v, name.getText(), types.getSelectedItem().toString());
            	
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
            	((UpdateChoiceOccurence) command).setVariable(v, name.getText(), types.getSelectedItem().toString());
            }
        });
	}

}
