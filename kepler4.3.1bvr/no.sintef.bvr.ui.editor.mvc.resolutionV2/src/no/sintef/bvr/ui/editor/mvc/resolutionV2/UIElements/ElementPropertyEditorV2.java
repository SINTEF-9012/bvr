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
package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

import no.sintef.bvr.tool.ui.command.Command;
import no.sintef.bvr.tool.ui.command.UpdateVSpec;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;
import no.sintef.bvr.tool.ui.edit.ElementPropertyEditor;
import no.sintef.bvr.tool.ui.edit.SpringUtilities;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.NamedElement;

public class ElementPropertyEditorV2 extends ElementPropertyEditor {
	
	public ElementPropertyEditorV2(BVRUIKernel _kernel, NamedElement _obj,
			BVRView _view) {
		super(_kernel, _obj, _view);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6151188246017274037L;

	protected BVRView view;
	
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
    	command.init(null, obj, null, null, null, null, view);
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