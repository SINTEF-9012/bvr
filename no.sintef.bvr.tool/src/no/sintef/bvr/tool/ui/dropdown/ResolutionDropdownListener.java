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

import no.sintef.bvr.tool.ui.command.event.DeleteAllResolutions;
import no.sintef.bvr.tool.ui.command.event.DeleteResolution;
import no.sintef.bvr.tool.ui.command.event.ExecuteResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.ExportModelImage;
import no.sintef.bvr.tool.ui.command.event.NewResolvedResolutionEvent;
import no.sintef.bvr.tool.ui.command.event.ToggleShowConstraintsEvent;
import no.sintef.bvr.tool.ui.command.event.ToggleShowGroupEvent;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.loader.CalculateCost;
import no.sintef.bvr.tool.ui.loader.CalculateCoverage;
import no.sintef.bvr.tool.ui.loader.GenerateAllProducts;
import no.sintef.bvr.tool.ui.loader.GenerateCoveringArray;
import no.sintef.bvr.tool.ui.loader.ImportResolutions;
import no.sintef.bvr.tool.ui.loader.SATValidateResolutions;


public class ResolutionDropdownListener extends MouseAdapter {
	
	private BVRNotifiableController controller;


	public ResolutionDropdownListener(BVRNotifiableController controller) {
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
		ResV2DropdownMenu menu = new ResV2DropdownMenu(controller);
		
		menu.show(e.getComponent(), e.getX(), e.getY());
	}
}

class ResV2DropdownMenu extends JPopupMenu {

	private static final long serialVersionUID = -3566954918415719879L;

	public ResV2DropdownMenu(BVRNotifiableController controller) {

		JMenuItem newres = new JMenuItem(Constants.RESOLUTION_NEW);
		newres.addActionListener(new NewResolvedResolutionEvent(controller));
		add(newres);
		if (controller.getResolutionControllerInterface().isResolutionModelSet()) {
			JMenuItem remove = new JMenuItem(Constants.RESOLUTION_REMOVE);
			remove.addActionListener(new DeleteResolution(controller));
			add(remove);
		}
		if (controller.getResolutionControllerInterface().isResolutionModelSet()) {
			JMenuItem remove = new JMenuItem(Constants.RESOLUTION_REMOVE_ALL);
			remove.addActionListener(new DeleteAllResolutions(controller));
			add(remove);
		}
		JMenuItem importres = new JMenuItem(Constants.RESOLUTION_IMPORT);
		importres.addActionListener(new ImportResolutions(controller));
		add(importres);
 
		/* Choice-only options */{
			JMenu camenu = new JMenu(Constants.RESOLUTION_MODELS_CHOICES_ONLY);
			JMenuItem satvalres = new JMenuItem(Constants.RESOLUTION_MODELS_CHOICES_ONLY_VALIDATE);
			satvalres.addActionListener(new SATValidateResolutions(controller));
			camenu.add(satvalres);
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
			camenu.add(cc1);

			JMenuItem calcall = new JMenuItem(Constants.RESOLUTION_MODELS_CHOICES_ALL_PROD);
			calcall.addActionListener(new GenerateAllProducts(controller));
			camenu.add(calcall);

			camenu.add(new JSeparator());

			JMenu genca = new JMenu(Constants.RESOLUTION_MODELS_CHOICES_GEN_COV_ARRAY);
			JMenuItem genca1 = new JMenuItem(Constants.RESOLUTION_MODELS_CHOICES_1_WISE);
			genca1.addActionListener(new GenerateCoveringArray(controller, 1));
			genca.add(genca1);
			JMenuItem genca2 = new JMenuItem(Constants.RESOLUTION_MODELS_CHOICES_2_WISE);
			genca2.addActionListener(new GenerateCoveringArray(controller, 2));
			genca.add(genca2);
			JMenuItem genca3 = new JMenuItem(Constants.RESOLUTION_MODELS_CHOICES_3_WISE);
			genca3.addActionListener(new GenerateCoveringArray(controller, 3));
			genca.add(genca3);
			camenu.add(genca);

			camenu.add(new JSeparator());
			add(new JSeparator());

			JMenuItem calcost = new JMenuItem(Constants.RESOLUTION_MODELS_CHOICES_CALC_COSTS);
			calcost.addActionListener(new CalculateCost(controller));
			camenu.add(calcost);

			add(camenu);
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
