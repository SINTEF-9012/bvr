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
package no.sintef.bvr.tool.ui.edit;

import javax.swing.JComponent;

import bvr.NamedElement;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.Command;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;

public class BVRVTypePropertyEditor extends ElementPropertyEditor {

	private static final long serialVersionUID = 3654695427983158448L;

	public BVRVTypePropertyEditor(BVRUIKernel _kernel, Command _command,
			NamedElement _obj, JComponent _node, BVRNotifiableController _view) {
		super(_kernel, _command, _obj, _node, _view);
	}
}
