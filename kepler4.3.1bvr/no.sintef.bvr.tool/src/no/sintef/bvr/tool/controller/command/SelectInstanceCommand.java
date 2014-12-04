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
package no.sintef.bvr.tool.controller.command;


import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

import bvr.NamedElement;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.Pair;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;
import no.sintef.bvr.ui.framework.SelectElement;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;


public class SelectInstanceCommand<EDITOR_PANEL extends BVREditorPanel, MODEL_PANEL extends BVRModelPanel>
		implements Command<EDITOR_PANEL, MODEL_PANEL> {

    private BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> kernel;
    private static SelectElement currentlySelected = null;
    
    private SelectElement selectableElement;
    
	public static void unselect() {
		System.out.println("unselect");
		if (currentlySelected != null)
			currentlySelected.setSelected(false);
	}

	public Command<EDITOR_PANEL, MODEL_PANEL> init(BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		
		kernel = rootPanel;
		
        if (p instanceof SelectElement) {
        	selectableElement = (SelectElement) p;
        }else{
        	throw new UnsupportedOperationException(p + " not instance of SelectElement");
        }
        return this;
	}

	public JComponent execute() {
		if (currentlySelected != null && currentlySelected != selectableElement) {
            currentlySelected.setSelected(false);
        }
        currentlySelected = selectableElement;
		
		currentlySelected.setSelected(!currentlySelected.isSelected());

		((BVREditorPanel) kernel.getEditorPanel()).showPropertyFor((JPanel) currentlySelected);


        ((JPanel)currentlySelected).repaint();
        ((JPanel)currentlySelected).revalidate();
        kernel.getModelPanel().repaint();
        kernel.getModelPanel().revalidate();

		return null;
	}
}
