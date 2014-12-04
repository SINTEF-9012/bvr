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


import no.sintef.bvr.tool.interfaces.controller.command.Command;


public interface VTypeControllerInterface<GUI_NODE, MODEL_OBJECT, SERIALIZABLE>
		extends
		EditorsCommonControllerInterface<SERIALIZABLE, GUI_NODE, MODEL_OBJECT> {

	public Command<?,?> createUpdateVTypeCommand(GUI_NODE elem);

	public void removeVType(GUI_NODE parent);

}
