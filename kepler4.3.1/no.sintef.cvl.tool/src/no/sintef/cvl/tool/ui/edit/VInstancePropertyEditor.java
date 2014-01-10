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

import no.sintef.cvl.tool.ui.command.UpdateChoice;
import no.sintef.cvl.tool.ui.command.UpdateVInstance;
import no.sintef.cvl.tool.ui.editor.CVLUIKernel;
import no.sintef.cvl.tool.ui.loader.CVLView;

import com.explodingpixels.macwidgets.plaf.HudLabelUI;
import com.explodingpixels.macwidgets.plaf.HudTextFieldUI;

import cvl.PrimitiveTypeEnum;
import cvl.PrimitveType;
import cvl.VInstance;
import cvl.VSpec;
import cvl.Variable;

public class VInstancePropertyEditor extends ElementPropertyEditor{
    protected void init() {
    	command = new UpdateVInstance();
    	command.init(null, obj, null, null, null, null, view);
    }

	public VInstancePropertyEditor(CVLUIKernel kernel, VInstance vInstance, CVLView view) {
		super(kernel, vInstance, view);
	}

	private void addEdit(VSpec elem, final Variable v) {
	    // Part 1
        JPanel panel = new JPanel(new SpringLayout());
        panel.setBorder(null);
        panel.setOpaque(false);
        
        // Name
        final JTextField name = new JTextField(10);
        name.setUI(new HudTextFieldUI());
        name.setText(v.getName());
        
        // Add
        panel.add(name);
     
        // Done
        top.add(panel);
        SpringUtilities.makeCompactGrid(panel,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        
        //Part 2
        ((UpdateVInstance)command).setName(v.getName());
        
        name.addKeyListener(new EnterAccepter(command, kernel.getEditorPanel()));
        
    	// Part 3:
        DocumentListener dl = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
            	((UpdateVInstance)command).setName(name.getText());
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
	}
}
