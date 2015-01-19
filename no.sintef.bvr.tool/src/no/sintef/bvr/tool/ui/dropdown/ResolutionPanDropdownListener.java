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
package no.sintef.bvr.tool.ui.dropdown;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import no.sintef.bvr.tool.ui.command.event.DeleteResolution;
import no.sintef.bvr.tool.ui.command.event.ExecuteResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.ExportModelImage;
import no.sintef.bvr.tool.ui.command.event.NewResolvedResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.RenameResolution;
import no.sintef.bvr.tool.ui.command.event.SATValidateSingleResolution;
import no.sintef.bvr.tool.ui.command.event.ToggleShowConstraintsEvent;
import no.sintef.bvr.tool.ui.command.event.ToggleShowGroupEvent;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.loader.CalculateCoverage;



public class ResolutionPanDropdownListener extends MouseAdapter {
	
	private BVRNotifiableController controller;


	public ResolutionPanDropdownListener(BVRNotifiableController controller) {
		this.controller = controller;
	}

	public void mousePressed(MouseEvent e) {
		if (e.isPopupTrigger())
			doPop(e);
	}

	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger())
			doPop(e);
	}

	private void doPop(MouseEvent e) {
		ResV2PanDropdownMenu menu = new ResV2PanDropdownMenu(controller);
		
		menu.show(e.getComponent(), e.getX(), e.getY());
	}
}

class ResV2PanDropdownMenu extends JPopupMenu {

	private static final long serialVersionUID = -3566954918415719879L;

	public ResV2PanDropdownMenu(BVRNotifiableController controller) {

		JMenuItem newres = new JMenuItem(Constants.RESOLUTION_NEW);
		newres.addActionListener(new NewResolvedResolutionEvent(controller));
		add(newres);
		
		add(new JSeparator());
		JMenuItem rename = new JMenuItem(Constants.RESOLUTION_RENAME);
		rename.addActionListener(new RenameResolution(controller));
		add(rename);
		
		add(new JSeparator());
		
		JMenuItem remove = new JMenuItem(Constants.RESOLUTION_REMOVE);
		remove.addActionListener(new DeleteResolution(controller));
		add(remove);

		add(new JSeparator());
		
		/* Choice-only options */
		{

			JMenuItem satvalres = new JMenuItem(Constants.RESOLUTION_DROPDOWN_VALIDATE_ITEM);
			satvalres.addActionListener(new SATValidateSingleResolution(controller));
			add(satvalres);
			JMenu cc1 = new JMenu(Constants.RESOLUTION_MODELS_CHOICES_CALC_COV);
			JMenuItem calccov1 = new JMenuItem(Constants.RESOLUTION_MODELS_CHOICES_1_WISE);
			calccov1.addActionListener(new CalculateCoverage(controller, 1));
			cc1.add(calccov1);
			JMenuItem calccov2 = new JMenuItem(Constants.RESOLUTION_MODELS_CHOICES_2_WISE);
			calccov2.addActionListener(new CalculateCoverage(controller, 2));
			cc1.add(calccov2);
			JMenuItem calccov3 = new JMenuItem(Constants.RESOLUTION_MODELS_CHOICES_3_WISE);
			calccov3.addActionListener(new CalculateCoverage(controller, 3));
			cc1.add(calccov3);
			add(cc1);

		}

		add(new JSeparator());

		JMenuItem saveasImage = new JMenuItem(Constants.RESOLUTION_MODELS_EXPORT_AS_PNG);
		add(saveasImage);
		saveasImage.addActionListener(new ExportModelImage(controller));

		JMenuItem showGrouping = new JMenuItem(Constants.RESOLUTION_MODELS_SHOWHIDE_GRP);
		add(showGrouping);
		showGrouping.addActionListener(new ToggleShowGroupEvent(controller));

		JMenuItem showConstraints = new JMenuItem(Constants.RESOLUTION_MODELS_SHOWHIDE_CNSTR);
		add(showConstraints);
		showConstraints.addActionListener(new ToggleShowConstraintsEvent(controller));
		
		add(new JSeparator());
		
		JMenuItem execute = new JMenuItem(Constants.RESOLUTION_MODELS_EXECUTE);
		execute.addActionListener(new ExecuteResolutionEvent(controller));
		execute.setEnabled(controller.getCommonControllerInterface().isSubstitutionEngineInitialized());
		
		add(execute);
	}
}
