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

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import no.sintef.cvl.ui.editor.CVLUIKernel;

import com.explodingpixels.macwidgets.plaf.HudLabelUI;
import com.explodingpixels.macwidgets.plaf.HudTextFieldUI;

import cvl.VSpec;

public class VSpecPropertyEditor  extends JPanel {
	
	protected Timer timer = new Timer();
	protected TimerUpdate task = new TimerUpdate();
	protected final long delay = 500;
	
	protected class TimerUpdate extends TimerTask {
		@Override
		public void run() {
			//no.sintef.cvl.ui.loader.Main.notifyViewUpdate();
		}		
	}

	protected CVLUIKernel kernel;
	protected VSpec vSpec;
	
    public void addCenter(JComponent p) {
        this.add(p);
    }

    public VSpecPropertyEditor(CVLUIKernel _kernel, VSpec _vspec) {
        this.setOpaque(false);
        this.setBorder(null);

        kernel = _kernel;
        vSpec = _vspec;
        
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

        this.addCenter(p);
        SpringUtilities.makeCompactGrid(p,
                1, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad



        /*JCommandButton btDelete = new JCommandButton("Delete");
        RemoveInstanceCommand removecmd = new RemoveInstanceCommand(elem);
        removecmd.setKernel(kernel);
        btDelete.setCommand(removecmd);
        this.addCenter(btDelete);*/

        textField.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                try {
                    updateName(e.getDocument().getText(0, e.getDocument().getLength()));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(NamedElementPropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            public void removeUpdate(DocumentEvent e) {
                try {
                    updateName(e.getDocument().getText(0, e.getDocument().getLength()));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(NamedElementPropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            public void changedUpdate(DocumentEvent e) {
                try {
                    updateName(e.getDocument().getText(0, e.getDocument().getLength()));
                } catch (BadLocationException ex) {
                    //Logger.getLogger(NamedElementPropertyEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    



    public void updateName(String newname) {
    	task.cancel();
    	task = new TimerUpdate();
    	vSpec.setName(newname);
        //no.sintef.cvl.ui.loader.Main.notifyViewUpdate();
        timer.schedule(task, delay);
    }	
   
}