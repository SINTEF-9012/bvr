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

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.ui.context.StaticUICommands;

public class OpenModelEvent implements ActionListener {
	
	private JTabbedPane c;

	public OpenModelEvent(JTabbedPane c){
		this.c = c;
	}

	public void actionPerformed(ActionEvent arg0) {
		try{
			JFileChooser fc = StaticUICommands.getBVRFileChooser();
			
			int isCanceled = fc.showOpenDialog(c);
			if(isCanceled == JFileChooser.CANCEL_OPTION)
				return;
			
			File sf = fc.getSelectedFile();
			if(sf == null) return;
			
			BVRToolModel m = Context.eINSTANCE.loadModelFromFile(sf);
			Context.eINSTANCE.addBvrModel(m);
			//Context.eINSTANCE.addBvrView(new VSpecView(m, c));
		}catch(Exception e){
			Context.eINSTANCE.logger.error("some error on Open", e);
			StaticUICommands.showMessageErrorDialog(null, e, "Failed to load file due to:");
		}
	}

}
