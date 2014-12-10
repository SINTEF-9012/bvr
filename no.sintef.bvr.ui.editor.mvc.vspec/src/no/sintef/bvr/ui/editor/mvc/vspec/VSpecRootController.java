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
package no.sintef.bvr.ui.editor.mvc.vspec;

import java.io.Serializable;

import javax.swing.JComponent;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.controller.SwingVSpecController;
import no.sintef.bvr.tool.interfaces.controller.BVRToolAbstractController;
import no.sintef.bvr.tool.interfaces.controller.VSpecControllerInterface;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;


public class VSpecRootController extends BVRToolAbstractController {
	
	private SwingVSpecController<JComponent, EObject, Serializable> controller;

	public VSpecRootController(BVRToolModel m) {
        controller = new SwingVSpecController<JComponent, EObject, Serializable>(m, this);
        controller.render();
	}
	
	
	public EditableModelPanel getEditorRootPanel(){
		return controller.getEditorRoolPanel();
	}
	
	@Override
	public void refresh() {
		controller.notifyViewUpdate();
	}
	
	@Override
	public VSpecControllerInterface<?,?, ?> getVSpecControllerInterface() {
		return controller;
	}
}
