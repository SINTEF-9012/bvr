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
/**
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Window;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;

import no.sintef.bvr.tool.ui.edit.VariableValueAssignmentPropertyEditor;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;
import no.sintef.bvr.ui.framework.elements.VariableAssignmentPanel;



//import com.explodingpixels.macwidgets.HudWindow;

/**
 * @author ffouquet
 */
public class EditableModelPanelV2 extends EditableModelPanel {
	
	private static final long serialVersionUID = 7573336297061006849L;
	

	public EditableModelPanelV2(JComponent _modelPanel) {
		super(_modelPanel);
		// TODO Auto-generated constructor stub
	}

    

    //HudWindow hud = new HudWindow("Properties editor");

    public void displayProperties(JPanel prop) {
        /*
    	hud.getJDialog().setSize(320, 440);
        hud.getJDialog().setLocationRelativeTo(null);
        hud.getJDialog().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hud.setContentPane(prop);
        hud.getJDialog().setVisible(true);
        */
    	if(dialog != null)
    		dialog.dispose();
    	
    	dialog = new JDialog();
    	dialog.setTitle("Properties editor");
    	dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    	dialog.setContentPane(prop);
    	dialog.pack();
    	dialog.setLocationRelativeTo(null);
    	dialog.setVisible(true);
    }
    
    public void displayProperties(JPanel content, Component parent, Dialog.ModalityType mode) {
    	Window parentWindow = findWindow(parent);
    	dialog = new JDialog(parentWindow, "Properties editor", mode);
    	dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    	dialog.setContentPane(content);
    	dialog.pack();
    	dialog.setLocationRelativeTo(parentWindow);
    	dialog.setVisible(true);
    }


    //show dialog relative to element

    public void displayProperties(VariableValueAssignmentPropertyEditor content, Component parent, Dialog.ModalityType mode, VariableAssignmentPanel elem) {
		
    	Window parentWindow = findWindow(parent);
    	dialog = new JDialog(parentWindow, "Properties editor", mode);
    	dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    	dialog.setContentPane(content);
    	dialog.pack();
    	dialog.setLocationRelativeTo(elem);
    	
    	dialog.setVisible(true);	
	}

}
