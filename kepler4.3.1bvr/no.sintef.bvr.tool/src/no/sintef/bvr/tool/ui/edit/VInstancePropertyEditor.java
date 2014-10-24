package no.sintef.bvr.tool.ui.edit;



import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;







import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.command.Command;
import no.sintef.bvr.tool.ui.command.UpdateVInstance;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import bvr.NamedElement;
import bvr.VSpec;
import bvr.Variable;

public class VInstancePropertyEditor extends ElementPropertyEditor{
    public VInstancePropertyEditor(BVRUIKernel _kernel, Command _command, NamedElement _obj, JComponent _node,
			BVRNotifiableController _view) {
		super(_kernel, _command, _obj, _node, _view);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 47770113151580106L;

	protected void init() {
    	command = new UpdateVInstance();
    	command.init(null, obj, null, null, null, null, controller);
    }

/*	public VInstancePropertyEditor(BVRUIKernel kernel, VInstance vInstance, BVRToolView view) {
		super(kernel, vInstance, view);
	}

	private void addEdit(VSpec elem, final Variable v) {
	    // Part 1
        JPanel panel = new JPanel(new SpringLayout());
        panel.setBorder(null);
        panel.setOpaque(false);
        
        // Name
        final JTextField name = new JTextField(10);
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
	}*/
}
