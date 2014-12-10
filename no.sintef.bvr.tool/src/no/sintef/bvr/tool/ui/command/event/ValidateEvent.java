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
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;


public class ValidateEvent implements ActionListener{
	private JComponent component;
	private BVRNotifiableController controller;
	
	public ValidateEvent(JComponent _component, BVRNotifiableController _controller) {
		component = _component;
		controller = _controller;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		List<String> results = controller.getResolutionControllerInterface().validateResolutionNode(component);
		if(results.size() == 0) {
			JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), "Valid: true []");
			return;
		}

		String message = "";
		Iterator<String> iterator = results.iterator();
		while(iterator.hasNext()) {
			String result = iterator.next();
			message += result;
			if(iterator.hasNext())
				message += ", ";
		}
		
		JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), "Valid: false [" + message + "]");
	}
}
