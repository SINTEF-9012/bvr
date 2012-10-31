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
package no.sintef.cvl.ui.editor.property;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import com.explodingpixels.macwidgets.plaf.HudLabelUI;
import com.explodingpixels.macwidgets.plaf.HudTextFieldUI;

import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.framework.elements.VClassifierPanel;
import no.sintef.cvl.ui.framework.elements.VSpecPanel;

public class VClassifierPropertyEditor extends VSpecPropertyEditor {

	public VClassifierPropertyEditor(CVLUIKernel kernel, VClassifierPanel elem) {
		super(kernel, (VSpecPanel) elem);
		
		
        //Lower bound
        JPanel p2 = new JPanel(new SpringLayout());
        p2.setBorder(null);
        p2.setOpaque(false);
		
        JLabel l2 = new JLabel("Lower", JLabel.TRAILING);
        l2.setUI(new HudLabelUI());

        p2.add(l2);
        JTextField textField2 = new JTextField(15);
        textField2.setUI(new HudTextFieldUI());

        l2.setLabelFor(textField2);
        p2.add(textField2);
        textField2.setText(gui.getName());
        
        this.addCenter(p2);
        SpringUtilities.makeCompactGrid(p2,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        
        
        //Upper bound
        JPanel p3 = new JPanel(new SpringLayout());
        p3.setBorder(null);
        p3.setOpaque(false);
        
        JLabel l3 = new JLabel("Upper", JLabel.TRAILING);
        l3.setUI(new HudLabelUI());

        p3.add(l3);
        JTextField textField3 = new JTextField(15);
        textField3.setUI(new HudTextFieldUI());

        l3.setLabelFor(textField3);
        p3.add(textField3);
        textField3.setText(gui.getName());
        
        this.addCenter(p3);
        SpringUtilities.makeCompactGrid(p3,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
        
        
        
        
        textField2.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                try {
                    updateLower(Integer.parseInt(e.getDocument().getText(0, e.getDocument().getLength())));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(NamedElementPropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            public void removeUpdate(DocumentEvent e) {
                try {
                    updateLower(Integer.parseInt(e.getDocument().getText(0, e.getDocument().getLength())));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(NamedElementPropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            public void changedUpdate(DocumentEvent e) {
                try {
                    updateLower(Integer.parseInt(e.getDocument().getText(0, e.getDocument().getLength())));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(NamedElementPropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        
        textField3.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                try {
                    updateUpper(Integer.parseInt(e.getDocument().getText(0, e.getDocument().getLength())));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(NamedElementPropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            public void removeUpdate(DocumentEvent e) {
                try {
                    updateUpper(Integer.parseInt(e.getDocument().getText(0, e.getDocument().getLength())));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(NamedElementPropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            public void changedUpdate(DocumentEvent e) {
                try {
                    updateUpper(Integer.parseInt(e.getDocument().getText(0, e.getDocument().getLength())));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(NamedElementPropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
	}
	
    public void updateLower(int lower) {
        //TODO update lower bound in the model and refresh/regenerate diagram    	
    }
    
    public void updateUpper(int upper) {
        //TODO update upper bound in the model and refresh/regenerate diagram
    }

}
