package no.sintef.cvl.ui.edit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import com.explodingpixels.macwidgets.plaf.HudLabelUI;
import com.explodingpixels.macwidgets.plaf.HudTextFieldUI;

import no.sintef.cvl.constraints.bcl.BCLPrettyPrinter;
import no.sintef.cvl.ui.commands.UpdateBCLConstraint;
import no.sintef.cvl.ui.commands.UpdateChoice;
import no.sintef.cvl.ui.commands.UpdateVClassifier;
import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.loader.CVLView;
import cvl.BCLConstraint;
import cvl.VSpec;

public class BCLConstraintPropertyEditor extends ElementPropertyEditor{
	
    protected void init() {
    	command = new UpdateBCLConstraint();
    	command.init(null, obj, null, null, null, null, view);
    }

	public BCLConstraintPropertyEditor(CVLUIKernel kernel, BCLConstraint elem, CVLView view) {
		super(kernel, elem, view);
		
		// Constraint
        JPanel p2 = new JPanel(new SpringLayout());
        p2.setBorder(null);
        p2.setOpaque(false);
		
        JLabel l2 = new JLabel("BCL Constraint", JLabel.TRAILING);
        l2.setUI(new HudLabelUI());

        p2.add(l2);
        JTextField textField2 = new JTextField(15);
        textField2.setUI(new HudTextFieldUI());

        l2.setLabelFor(textField2);
        p2.add(textField2);
        
        String s = new BCLPrettyPrinter().prettyPrint(elem.getExpression().get(0), view.getCU());
        
        textField2.setText(s);
        
        top.add(p2);
        SpringUtilities.makeCompactGrid(p2,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        
        pack(2,1);
        
        ((UpdateBCLConstraint) command).setConstraint(s);
        
        textField2.addKeyListener(new EnterAccepter(command, kernel.getEditorPanel()));
        
        textField2.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                try {
                    ((UpdateBCLConstraint) command).setConstraint(e.getDocument().getText(0, e.getDocument().getLength()));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(NamedElementPropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (java.lang.NumberFormatException nfe) {
                	//Do not update the value cannot be parsed
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
