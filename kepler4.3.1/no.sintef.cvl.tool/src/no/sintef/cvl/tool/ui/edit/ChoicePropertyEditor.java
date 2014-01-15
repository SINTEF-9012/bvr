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

import no.sintef.cvl.tool.ui.command.UpdateChoice;
import no.sintef.cvl.tool.ui.command.UpdateVClassifier;
import no.sintef.cvl.tool.ui.editor.CVLUIKernel;
import no.sintef.cvl.tool.ui.loader.CVLView;
import cvl.Choice;
import cvl.PrimitiveTypeEnum;
import cvl.PrimitveType;
import cvl.VSpec;
import cvl.Variable;

public class ChoicePropertyEditor extends ElementPropertyEditor{
	
    protected void init() {
    	command = new UpdateChoice();
    	command.init(null, obj, null, null, null, null, view);
    }

	public ChoicePropertyEditor(CVLUIKernel kernel, VSpec elem, CVLView view) {
		super(kernel, (VSpec) elem, view);
		
		int count = 1;
		for(VSpec x : elem.getChild()){
			if(x instanceof Variable){
				Variable v = (Variable)x;
				addEdit(elem, v);
				count++;
			}
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
