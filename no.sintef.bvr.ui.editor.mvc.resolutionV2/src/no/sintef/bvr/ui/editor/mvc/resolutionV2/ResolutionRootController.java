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
package no.sintef.bvr.ui.editor.mvc.resolutionV2;



import java.io.Serializable;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.controller.SwingResolutionController;
import no.sintef.bvr.tool.interfaces.controller.BVRToolAbstractController;
import no.sintef.bvr.tool.interfaces.controller.ResolutionControllerInterface;
import no.sintef.bvr.tool.model.BVRToolModel;


public class ResolutionRootController extends BVRToolAbstractController {
	
	private BVRToolModel model;
	private SwingResolutionController<JComponent, EObject, Serializable> controller;
	
	public ResolutionRootController(BVRToolModel m) {
		model = m;
		controller = new SwingResolutionController<JComponent, EObject, Serializable>(model, this);
		controller.render();
	}

	public JTabbedPane getResolutionPane() {
		return controller.getResolutionPane();
	}

	@Override
	public void refresh() {
		controller.notifyResolutionViewUpdate();
	}
	
	@Override
	public ResolutionControllerInterface<?,?,?> getResolutionControllerInterface() {
		return controller;
	}

}
