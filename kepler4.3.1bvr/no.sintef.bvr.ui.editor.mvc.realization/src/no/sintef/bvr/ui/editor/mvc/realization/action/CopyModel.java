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
package no.sintef.bvr.ui.editor.mvc.realization.action;

import java.awt.Toolkit;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.command.event.CopyModelEvent;
import no.sintef.bvr.ui.editor.common.ExecuteCommandEvent;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class CopyModel extends AbstractHandler {


	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new ExecuteCommandEvent(Context.eINSTANCE.getActiveJApplet(), new CopyModelEvent()));
		return null;
	}
}
