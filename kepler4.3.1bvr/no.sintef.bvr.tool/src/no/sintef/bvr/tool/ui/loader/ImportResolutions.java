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
import java.io.File;

import javax.swing.JFileChooser;

import no.sintef.bvr.tool.filter.BVRFilter;
import no.sintef.bvr.tool.filter.SHFilter;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;

public class ImportResolutions implements ActionListener {
	private BVRNotifiableController controller;

	public ImportResolutions(BVRNotifiableController _controller) {
		this.controller = _controller;
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent ae) {

		final JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new SHFilter());
		fc.addChoosableFileFilter(new BVRFilter());
		fc.showOpenDialog(null);

		File sf = fc.getSelectedFile();
		if (sf != null)
			controller.getResolutionControllerInterface().importResolution(sf);
	}
}
