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


import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;


public class SubFragTableEvent implements TableModelListener {

	private BVRNotifiableController controller;

	public SubFragTableEvent(BVRNotifiableController _controller){
		controller = _controller;
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
		if(TableModelEvent.UPDATE == e.getType()){
			//when column is less than zero then the update event in a model was triggered by for example filtering not users selection 
			if(e.getColumn() >= 0){
				if(e.getLastRow() == e.getFirstRow()){
					int rowIndex = e.getLastRow();
					int columnIndex = e.getColumn();
					SimpleExeCommandInterface command = controller.getRealizationControllerInterface().createUpdateSubstitutionFragmentCommand(rowIndex, columnIndex);
					command.execute();
				}else{
					throw new UnsupportedOperationException("Few rows were updated - not implemented");
				}
			}
		}

	}

}
