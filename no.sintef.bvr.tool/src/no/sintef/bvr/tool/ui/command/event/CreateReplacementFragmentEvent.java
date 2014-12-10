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

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;


public class CreateReplacementFragmentEvent implements ActionListener {
	
	private BVRNotifiableController controller;
	private boolean withContainment;


	public CreateReplacementFragmentEvent(BVRNotifiableController _controller, boolean _withContainment) {
		controller = _controller;
		withContainment = _withContainment;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		SimpleExeCommandInterface command = controller.getRealizationControllerInterface().createReplacementFragmentCommand(withContainment);
		command.execute();
	}
}
