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
import javax.swing.JSeparator;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRRealizationUIKernelInterface;
import no.sintef.bvr.tool.ui.command.event.CreateBindingsEvent;
import no.sintef.bvr.tool.ui.command.event.DeleteFragmentSubstitutionEvent;
import no.sintef.bvr.tool.ui.editor.FragmentSubstitutionJTable;


public class FragmentSubstitutionTableDropDown extends
		FragmentSubstitutionDropDown {

	private static final long serialVersionUID = 2778779861676603393L;
	
	public FragmentSubstitutionTableDropDown(BVRNotifiableController _controller) {
		super(_controller);
		BVRRealizationUIKernelInterface kenrel = controller.getRealizationControllerInterface().getUIKernel();
		FragmentSubstitutionJTable jtable = (FragmentSubstitutionJTable) kenrel.getFragmentSubstitutionTable();
		if(jtable.getSelectedRows().length != 0){
			add(new JSeparator());
			JMenuItem generateBindings = new JMenuItem(Constants.REALIZATION_GENERATE_BINDINGS);
			generateBindings.addActionListener(new CreateBindingsEvent(controller));
			add(generateBindings);
			
			add(new JSeparator());
			JMenuItem deleteFragmentSubstitution = new JMenuItem(Constants.REALIZATION_DL_FS_NAME);
			deleteFragmentSubstitution.addActionListener(new DeleteFragmentSubstitutionEvent(controller));
			add(deleteFragmentSubstitution);
		}
	}

}
