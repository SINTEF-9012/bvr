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
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.context.StaticUICommands;

public class CloseModelEvent implements ActionListener {

	private JTabbedPane filePane;

	public CloseModelEvent(JTabbedPane filePane){
		this.filePane = filePane;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int selected = filePane.getSelectedIndex();
		BVRToolModel model = Context.eINSTANCE.getBvrModels().get(selected);

		try{
			int result = JOptionPane.showConfirmDialog(filePane, "Save changes?", "alert", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION){
				File file = StaticUICommands.saveModelToFile(filePane, model, true);
				if(file == null){
					result = JOptionPane.showConfirmDialog(filePane, "Are you sure you want to close this model? Unsaved changes will be lost!", "alert", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.NO_OPTION)
						return;
				}
			}
			filePane.removeTabAt(selected);
			Context.eINSTANCE.getBvrViews().remove(selected);
			Context.eINSTANCE.getBvrModels().remove(selected);
		}catch(Exception e){
			Context.eINSTANCE.logger.error("can not close the model", e);
			StaticUICommands.showMessageErrorDialog(filePane, e, "Error (can not close the model):");
		}
	}

}
