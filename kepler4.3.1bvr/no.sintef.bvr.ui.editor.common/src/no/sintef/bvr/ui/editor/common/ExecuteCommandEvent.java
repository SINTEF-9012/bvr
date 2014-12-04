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
package no.sintef.bvr.ui.editor.common;

import java.awt.AWTEvent;

import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;

public class ExecuteCommandEvent extends AWTEvent {


	private static final long serialVersionUID = -8635468107891567339L;
	
	public static final int EVENT_ID = AWTEvent.RESERVED_ID_MAX + 2;
	
	SimpleExeCommandInterface command;
	
	public ExecuteCommandEvent(Object target, SimpleExeCommandInterface _command) {
		super(target, EVENT_ID);
		command = _command;
	}
	
	public void execute() {
		command.execute();
	}
}
