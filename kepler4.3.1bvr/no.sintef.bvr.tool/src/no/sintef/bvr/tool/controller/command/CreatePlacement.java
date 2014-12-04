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
package no.sintef.bvr.tool.controller.command;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.BVRModel;
import bvr.PlacementFragment;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.RethrownException;
import no.sintef.bvr.tool.exception.UserInputError;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.strategy.impl.CreateBoundaryContext;
import no.sintef.bvr.tool.strategy.impl.GetSelectionContext;

public class CreatePlacement implements SimpleExeCommandInterface {

	private boolean withContainment;
	private BVRModel model;
	private PlacementFragment placement;

	public CreatePlacement(boolean _isContainmentMode, BVRModel _model, PlacementFragment _placement){
		withContainment = _isContainmentMode;
		model = _model;
		placement = _placement;
	}
	
	@Override
	public void execute() {
		Context.eINSTANCE.getConfig().setContainmentSelectionMode(withContainment);
		GetSelectionContext selectionContext = new GetSelectionContext();
		EList<EObject> selectedObjects = selectionContext.getSelectedObjects();
		
		if(selectedObjects.size() == 0)
			throw new UserInputError(Messages.DIALOG_PLACEMENT_EMPTY_SELECTION);

		try {	
			CreateBoundaryContext createBoundaryContext = new CreateBoundaryContext();
			createBoundaryContext.creatBoundaries(placement, selectedObjects);	
			Context.eINSTANCE.getEditorCommands().addRealizationVariationPoint(model, placement);
		} catch (Exception e) {
			throw new RethrownException("some failure during placement creation", e);
		}
	}
}
