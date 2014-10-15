/**
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package no.sintef.bvr.tool.ui.edit;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.Command;
import no.sintef.bvr.tool.ui.command.UpdateVSpec;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;


import bvr.NamedElement;

public class ElementPropertyEditor extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6151188246017274037L;

	protected BVRNotifiableController controller;
	
	protected JPanel top;
	protected JPanel bottom;
	
	protected BVRUIKernel kernel;
	protected NamedElement obj;
	
    public void addCenter(JComponent p) {
        this.add(p);
    }
    
    public void pack(int rows, int cols){
    	SpringUtilities.makeCompactGrid(top,
                rows, cols, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad

    }
    
    protected Command command;
    
    protected void init() {
    	command = new UpdateVSpec();
    	command.init(null, obj, null, null, null, null, controller);
    }
    
    public ElementPropertyEditor(BVRUIKernel _kernel, NamedElement _obj, BVRNotifiableController _controller) {

        this.setOpaque(false);
        this.setBorder(null);

        controller = _controller;
        kernel = _kernel;
        obj = _obj;
        
    	init();
        
        top = new JPanel(new SpringLayout());
        top.setBorder(null);
        top.setOpaque(false);
        
        bottom = new JPanel();
        bottom.setBorder(null);
        bottom.setOpaque(false);
        
        this.addCenter(top);
        this.addCenter(bottom);
        
        final JCommandButton okButton = new JCommandButton("OK", command, kernel, controller);
        bottom.add(okButton);
        
        //Name
        JPanel p = new JPanel(new SpringLayout());
        p.setBorder(null);
        p.setOpaque(false);
        
        JLabel l = new JLabel("Name", JLabel.TRAILING);
        //l.setUI(new HudLabelUI());

        p.add(l);
        JTextField textField = new JTextField(15);
        
        //textField.setUI(new HudTextFieldUI());

        l.setLabelFor(textField);
        p.add(textField);
        textField.setText(obj.getName());

        top.add(p);
        SpringUtilities.makeCompactGrid(p,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad

        pack(1,1);
        
        textField.addKeyListener(new EnterAccepter(command, kernel.getEditorPanel()));

        textField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                try {
                    ((UpdateVSpec) command).setName(e.getDocument().getText(0, e.getDocument().getLength()));
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
    }
}

class EnterAccepter implements KeyListener {
	private Command command;
	private BVREditorPanel ep;

	public EnterAccepter(Command command, BVREditorPanel ep) {
		this.command = command;
		this.ep = ep;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			command.execute();
			ep.unshowPropertyEditor();
		}
	}
}