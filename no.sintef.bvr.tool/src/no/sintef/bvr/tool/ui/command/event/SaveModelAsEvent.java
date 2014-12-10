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


public class SaveModelAsEvent implements ActionListener {
	private JTabbedPane filePane;
	private boolean trydirectsave;

	public SaveModelAsEvent(JTabbedPane filePane,  boolean b) {
		this.filePane = filePane;
		this.trydirectsave = b;
	}

	public void actionPerformed(ActionEvent event) {		
		try{
			int i = filePane.getSelectedIndex();
			BVRToolModel model = Context.eINSTANCE.getBvrModels().get(i);
			
			File file = StaticUICommands.saveModelToFile(filePane, model, trydirectsave);
			if(file != null){
				filePane.setTitleAt(i, file.getName());
				filePane.setToolTipTextAt(i, file.getAbsolutePath());
			}
		}catch(Exception e){
			Context.eINSTANCE.logger.error("some error on Save", e);
			StaticUICommands.showMessageErrorDialog(filePane, e, "Error saving file:");
		}
	}
}
