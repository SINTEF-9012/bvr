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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.context.StaticUICommands;


public class ExecuteResolutionEvent implements ActionListener {

	private BVRNotifiableController controller;
	private File destFile;

	public ExecuteResolutionEvent(BVRNotifiableController _controller) {
		controller = _controller;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {	
		final JFileChooser fc = StaticUICommands.getFileChooser(null, null);
		
		int status = fc.showSaveDialog(Context.eINSTANCE.getActiveJApplet());
		if(status == JFileChooser.CANCEL_OPTION)
			return;
		
		destFile = fc.getSelectedFile();
		if(destFile == null) {
			JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), Messages.DIALOG_MSG_NO_FILE_SELECTED);
			return;
		}
		
		Job job = new Job("Executing Resolutions"){

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				Status status = new Status(Status.OK, Constants.PLUGIN_ID, "OK!");
					try {
						controller.getResolutionControllerInterface().executeProduct(destFile);
					} catch (Exception error) {
						status = new Status(Status.ERROR, Constants.PLUGIN_ID, "Failed to execute (see log for more details): " + error.getMessage(), error);
					}
				return status;
			}
		};
	
		job.schedule();
	}
}
