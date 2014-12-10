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
package no.sintef.bvr.tool.ui.edit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;


public class JCommandButton extends JButton {

	private static final long serialVersionUID = 6470959770787697161L;
	protected Command command;

	protected BVRNotifiableController controller;
	protected BVRUIKernel kernel;
	
    public JCommandButton(final String title, final Command command, final BVRUIKernel kernel, final BVRNotifiableController controller){
    	this.command = command;
    	this.controller = controller;
    	this.kernel = kernel;
        this.setText(title);
        this.setOpaque(false);
        this.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
        		command.execute();
        		if(controller != null)
        			kernel.getEditorPanel().unshowPropertyEditor();
            }
        });

    }
    
    public JCommandButton(final String title, final Command command){
    	this(title, command, null, null);
    }
}
