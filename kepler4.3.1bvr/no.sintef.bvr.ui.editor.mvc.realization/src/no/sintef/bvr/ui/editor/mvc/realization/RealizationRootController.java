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
package no.sintef.bvr.ui.editor.mvc.realization;


import javax.swing.JTabbedPane;

import no.sintef.bvr.tool.controller.SwingRealizationController;
import no.sintef.bvr.tool.interfaces.controller.BVRToolAbstractController;
import no.sintef.bvr.tool.interfaces.controller.RealizationControllerInterface;
import no.sintef.bvr.tool.model.BVRToolModel;


public class RealizationRootController extends BVRToolAbstractController {
	
	private BVRToolModel model;
	private SwingRealizationController controller;
		
	public RealizationRootController(BVRToolModel _model) {
		model = _model;
		controller = new SwingRealizationController(model, this);
	}

	@Override
	public void refresh() {
		controller.render();
	}
	
	public JTabbedPane getEditorRootPanel() {
		return controller.getRealizationPanel();
	}
	
	@Override
	public RealizationControllerInterface getRealizationControllerInterface() {
		return controller;
	}
}
