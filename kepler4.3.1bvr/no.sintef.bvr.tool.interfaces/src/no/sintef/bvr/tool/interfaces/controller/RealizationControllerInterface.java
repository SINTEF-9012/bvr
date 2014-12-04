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
package no.sintef.bvr.tool.interfaces.controller;

import java.util.ArrayList;

import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRRealizationUIKernelInterface;

public interface RealizationControllerInterface extends EditorsCommonControllerInterface {

	public BVRRealizationUIKernelInterface getUIKernel();
	
	public SimpleExeCommandInterface createPlacementFragmentCommand(boolean conatinment);
	
	public SimpleExeCommandInterface createReplacementFragmentCommand(boolean conatinment);
	
	public void deleteSubstitutionFragments();
	
	public SimpleExeCommandInterface createDeleteSubstitutionFragmentsCommand();

	public void deleteFragmentSubstitutions();
	
	public SimpleExeCommandInterface createDeleteFragmentSubstitutionsCommand();

	public void createFragmentSubstitution();

	public SimpleExeCommandInterface createGenerateBindingsCommand();
	
	public SimpleExeCommandInterface createUpdateFragmentSubstitutionCommand(int rowIndex, int columnIndex);

	public SimpleExeCommandInterface createUpdateSubstitutionFragmentCommand(int _rowIndex, int _columnIndex);
	
	public SimpleExeCommandInterface createHighlightFragmentElementsCommand(ArrayList<Integer> _selectedRows);
	
	public void fragmentSubstitutionRowSelected(int _selectedIndex);
	
	public void highlightBoundaryElements(int _selectedIndex);
	
	public SimpleExeCommandInterface createUpdateBindingCommand(int rowIndex, int columnIndex);

	public void clearSelection();
}
