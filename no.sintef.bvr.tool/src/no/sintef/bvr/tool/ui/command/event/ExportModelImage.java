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
import javax.swing.filechooser.FileFilter;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.tool.filter.PNGFilter;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.context.StaticUICommands;


public class ExportModelImage implements ActionListener {

	private BVRNotifiableController controller;
	
	private static final String PNG_EXT = "." + PNGFilter.PNG_EXT;

	public ExportModelImage(BVRNotifiableController _controller) {
		this.controller = _controller;
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
		FileFilter[] filters = {new PNGFilter()};
		JFileChooser filechooser = StaticUICommands.getFileChooser(filters, filters[0]);
		
		String defualtName = controller.getCommonControllerInterface().getModelFileLocation();
		if(defualtName != null) {
			defualtName = CommonUtility.removeExtension(defualtName);
			filechooser.setSelectedFile(new File(defualtName));
		}
		
		int status = filechooser.showSaveDialog(null);
		if(status == JFileChooser.CANCEL_OPTION)
			return;
		
		File sf = filechooser.getSelectedFile();
		if(sf == null) return;
		
		if(!sf.getAbsolutePath().endsWith(PNG_EXT))
			sf = new File(sf.getAbsolutePath() + PNG_EXT);
		
		if(sf.exists()){
			int result = JOptionPane.showConfirmDialog(null, "File already exist, overwrite?", "alert", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.NO_OPTION)
				return;
		}
		
		controller.getCommonControllerInterface().exportAsPNGImage(sf);
	}

}
