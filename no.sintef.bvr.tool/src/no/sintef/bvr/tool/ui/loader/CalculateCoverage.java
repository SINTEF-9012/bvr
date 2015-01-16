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
package no.sintef.bvr.tool.ui.loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.ShowErrorException;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;


public class CalculateCoverage implements ActionListener {
	private int t;
	private BVRNotifiableController controller;

	public CalculateCoverage(BVRNotifiableController _controller, int t) {
		this.t = t;
		controller = _controller;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Job job = new Job("Calculating Coverage Array") {
			 @Override
			 protected IStatus run(IProgressMonitor monitor) {
				Integer cov = null;
				try {
					cov = controller.getResolutionControllerInterface().calculateCoverage(t);
				} catch (ShowErrorException e) {
					Context.eINSTANCE.logger.error("Calculating coverage failed:", e);
					JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), "Failed with message : " + e.getMessage(), "Error : see error log for more details!", JOptionPane.ERROR_MESSAGE);
					Status status = new Status(Status.CANCEL, Constants.PLUGIN_ID, e.getMessage(), e);
					return status;
				} catch (Exception e) {
					Context.eINSTANCE.logger.error("Calculating coverage failed:", e);
					Status status = new Status(Status.ERROR, Constants.PLUGIN_ID, "Calculating coverage failed (see log for more details): " + e.getMessage(), e);
					return status;
				}
				JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), t +"-wise coverage: " + cov + "%");
				return Status.OK_STATUS;
			 }
		};

		job.schedule();
	}

}
