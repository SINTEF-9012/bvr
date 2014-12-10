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
package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;


public class AddChoiceFromVClassifierEvent implements ActionListener {
	private JComponent cr;
	private EObject target;
	private BVRNotifiableController controller;
	
	public AddChoiceFromVClassifierEvent(JComponent parent, EObject toResolve, BVRNotifiableController controller) {
		cr = parent;
		target = toResolve;
		this.controller = controller;
	}
	
	static int count = 0;

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent arg0) {
		controller.getResolutionControllerInterface().addChoiceOrVClassifierResolution(cr, target);
	}
}
