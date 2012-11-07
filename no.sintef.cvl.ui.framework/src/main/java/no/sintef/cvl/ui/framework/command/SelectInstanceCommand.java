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
package no.sintef.cvl.ui.framework.command;

import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

import cvl.VSpec;

import no.sintef.cvl.ui.framework.SelectElement;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;
import no.sintef.cvl.ui.editor.CVLUIKernel;

public class SelectInstanceCommand implements Command {

    private CVLUIKernel kernel;
    private static SelectElement alreadySelected = null;

	public Command init(CVLUIKernel rootPanel, Object p,
			JComponent parent, Map<JComponent, VSpec> vmMap) {
		
		kernel = rootPanel;
		
		//System.out.println("init " + p);
		
        if (p instanceof SelectElement) {

            //org.kevoree.Instance instance = (Instance) bObject;
            
            SelectElement component = (SelectElement) p;
            if (alreadySelected != null && alreadySelected != component ) {
                alreadySelected.setSelected(false);
            }
            alreadySelected = component;
            
        }
        return this;
	}

	public JComponent execute() {
		alreadySelected.setSelected(!alreadySelected.isSelected());
        if (alreadySelected.isSelected()) {
        	System.out.println("kernel = " + kernel);
        	System.out.println("kernel.getEditorPanel() = " + kernel.getEditorPanel());
            kernel.getEditorPanel().showPropertyFor((JPanel) alreadySelected);
        } else {
            kernel.getEditorPanel().unshowPropertyEditor();
        }

        ((JPanel)alreadySelected).repaint();
        ((JPanel)alreadySelected).revalidate();
        kernel.getModelPanel().repaint();
        kernel.getModelPanel().revalidate();

		return null;
	}
}
