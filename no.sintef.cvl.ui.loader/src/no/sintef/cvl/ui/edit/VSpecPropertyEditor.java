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
package no.sintef.cvl.ui.edit;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import no.sintef.cvl.ui.commands.Command;
import no.sintef.cvl.ui.commands.UpdateVSpec;
import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.loader.CVLView;

import com.explodingpixels.macwidgets.plaf.HudLabelUI;
import com.explodingpixels.macwidgets.plaf.HudTextFieldUI;

import cvl.VSpec;

public class VSpecPropertyEditor  extends JPanel {
	
	protected CVLView view;
	
	protected JPanel top;
	protected JPanel bottom;
	
	protected CVLUIKernel kernel;
	protected VSpec vSpec;
	
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
    	command.init(null, vSpec, null, null, null, null, view);
    }
    
    public VSpecPropertyEditor(CVLUIKernel _kernel, VSpec _vspec, CVLView _view) {

        this.setOpaque(false);
        this.setBorder(null);

        view = _view;
        kernel = _kernel;
        vSpec = _vspec;
        
    	init();
        
        top = new JPanel(new SpringLayout());
        top.setBorder(null);
        top.setOpaque(false);
        
        bottom = new JPanel();
        bottom.setBorder(null);
        bottom.setOpaque(false);
        
        this.addCenter(top);
        this.addCenter(bottom);
        
        JCommandButton okButton = new JCommandButton("OK", command);
        bottom.add(okButton);
        
        //Name
        JPanel p = new JPanel(new SpringLayout());
        p.setBorder(null);
        p.setOpaque(false);
        
        JLabel l = new JLabel("Name", JLabel.TRAILING);
        l.setUI(new HudLabelUI());

        p.add(l);
        JTextField textField = new JTextField(15);
        textField.setUI(new HudTextFieldUI());

        l.setLabelFor(textField);
        p.add(textField);
        textField.setText(vSpec.getName());

        top.add(p);
        SpringUtilities.makeCompactGrid(p,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad

        pack(1,1);

        textField.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                try {
                    ((UpdateVSpec) command).setName(e.getDocument().getText(0, e.getDocument().getLength()));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(NamedElementPropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            public void removeUpdate(DocumentEvent e) {
                try {
                	((UpdateVSpec) command).setName(e.getDocument().getText(0, e.getDocument().getLength()));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(NamedElementPropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            public void changedUpdate(DocumentEvent e) {
                try {
                	((UpdateVSpec) command).setName(e.getDocument().getText(0, e.getDocument().getLength()));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(NamedElementPropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }	
   
}