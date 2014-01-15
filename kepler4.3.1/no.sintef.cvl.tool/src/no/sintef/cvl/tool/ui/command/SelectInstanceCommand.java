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
package no.sintef.cvl.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

import cvl.NamedElement;
import cvl.VSpec;

import no.sintef.cvl.tool.ui.editor.CVLUIKernel;
import no.sintef.cvl.tool.ui.loader.VSpecView;
import no.sintef.cvl.tool.ui.loader.Pair;
import no.sintef.cvl.ui.framework.SelectElement;

public class SelectInstanceCommand implements Command {

    private CVLUIKernel kernel;
    private static SelectElement currentlySelected = null;//only one element can be selected
    
    private SelectElement selectableElement;
    
	public static void unselect() {
		System.out.println("unselect");
		if (currentlySelected != null)
			currentlySelected.setSelected(false);
	}

	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, VSpecView view) {
		
		kernel = rootPanel;
		
		//System.out.println("init " + p);
		
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
        if (currentlySelected.isSelected()) {
        	//System.out.println("kernel = " + kernel);
        	//System.out.println("kernel.getEditorPanel() = " + kernel.getEditorPanel());
            kernel.getEditorPanel().showPropertyFor((JPanel) currentlySelected);
        } else {
            kernel.getEditorPanel().unshowPropertyEditor();
        }

        ((JPanel)currentlySelected).repaint();
        ((JPanel)currentlySelected).revalidate();
        kernel.getModelPanel().repaint();
        kernel.getModelPanel().revalidate();

		return null;
	}
}
