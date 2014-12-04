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

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.command.event.ExportModelImage;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;


public class VSpecDropDownListener extends MouseAdapter {
	private BVRNotifiableController controller;
	private BVRToolModel toolModel;
	private BVRUIKernel kernel;

	public VSpecDropDownListener(BVRUIKernel kernel, BVRToolModel m, BVRNotifiableController controller) {
		this.kernel = kernel;
		this.toolModel = m;
		this.controller = controller;
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
    	VSpecDropdown menu = new VSpecDropdown(kernel, toolModel, controller);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}

class VSpecDropdown extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	JMenuItem anItem;
    public VSpecDropdown(BVRUIKernel kernel, BVRToolModel toolmodel, BVRNotifiableController bvrView){
		JMenuItem saveasImage = new JMenuItem("Export Diagram as PNG ...");
		add(saveasImage);
		saveasImage.addActionListener(new ExportModelImage(bvrView));
    }
}
