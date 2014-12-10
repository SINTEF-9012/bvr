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
package no.sintef.bvr.tool.ui.dropdown;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.event.CreateToBindingEvent;
import no.sintef.bvr.tool.ui.command.event.DeleteBindingAllEvent;

public class BindingEditorDropDown extends JPopupMenu {

	private static final long serialVersionUID = 8629958457282670624L;
	
	public BindingEditorDropDown(BVRNotifiableController _view){
		
		JMenuItem createToBinding = new JMenuItem(Constants.REALIZATION_GENERATE_TO_BINDING);
		createToBinding.addActionListener(new CreateToBindingEvent(_view));
		add(createToBinding);
		
		add(new JSeparator());
		JMenuItem deleteAllBinding = new JMenuItem(Constants.REALIZATION_DELETE_ALL_BINDING);
		deleteAllBinding.addActionListener(new DeleteBindingAllEvent(_view));
		add(deleteAllBinding);
	}

}
