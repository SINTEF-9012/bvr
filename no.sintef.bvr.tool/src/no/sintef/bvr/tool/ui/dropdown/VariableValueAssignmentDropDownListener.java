/*******************************************************************************
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
 ******************************************************************************/
package no.sintef.bvr.tool.ui.dropdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.event.RemoveVSpecResolutionEvent;
import no.sintef.bvr.ui.framework.elements.VariableAssignmentPanel;



public class VariableValueAssignmentDropDownListener  extends MouseAdapter {
	private VariableAssignmentPanel cp;
	private BVRNotifiableController view;

	
    public VariableValueAssignmentDropDownListener(VariableAssignmentPanel cp, BVRNotifiableController view) {
		this.cp = cp;
		this.view = view;
	}

	public void mousePressed(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    private void doPop(MouseEvent e){
    	VariableValueAssignmentDropdown menu = new VariableValueAssignmentDropdown(cp, view);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class VariableValueAssignmentDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;

    public VariableValueAssignmentDropdown(VariableAssignmentPanel cp, BVRNotifiableController view){
		JMenuItem remove = new JMenuItem(Constants.RESOLUTION_DROPDOWN_REMOVE_ITEM);
		remove.addActionListener(new RemoveVSpecResolutionEvent(cp, view));
		add(remove);
    }
}
