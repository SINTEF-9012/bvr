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
package no.sintef.bvr.tool.model;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.UnexpectedException;
import bvr.BVRModel;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceOccurrence;
import bvr.CompoundNode;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.Target;
import bvr.VClassOccurrence;
import bvr.VClassifier;

public class VSpecFacade {
	
	public static VSpecFacade eINSTANCE = getInstance();
	private static int choicCounter = 0;
	private static int classifierCount = 0;
	private final static String defaultChoiceName = "Choice";
	private final static String defaultVClassifierName = "Classifier";
	private final static String defaultChoiceOccurenceName = "ChoiceOccurence";
	private final static String defaultVClassOccurenceName = "VClassOccurence";
	
	private static VSpecFacade getInstance() {
		if(eINSTANCE == null)
			eINSTANCE = new VSpecFacade();
		return eINSTANCE;
	}
	
	public Choice appendChoice(NamedElement parent) {
		Choice c = BvrFactory.eINSTANCE.createChoice();
		c.setIsImpliedByParent(true);
		c.setName(defaultChoiceName + choicCounter);

		// each vspec has to have target
		Target target = BvrFactory.eINSTANCE.createTarget();
		target.setName(c.getName());
		((CompoundNode) c).getOwnedTargets().add(target);
		c.setTarget(target);

		if (parent instanceof CompoundNode) {
			Context.eINSTANCE.getEditorCommands().addChoice(c, (CompoundNode) parent);
		} else if (parent instanceof BVRModel) {
			BVRModel model = (BVRModel) parent;
			if (model.getVariabilityModel() == null) 
				Context.eINSTANCE.getEditorCommands().addChoice(c, model);
		} else {
			throw new UnexpectedException("parent is neither CompoundNode nor BVRModel, not supported");
		}
		choicCounter++;
		return c;
	}
	
	public VClassifier appendVClassifier(NamedElement parent) {
		VClassifier c = BvrFactory.eINSTANCE.createVClassifier();
		c.setName(defaultVClassifierName + classifierCount);
		MultiplicityInterval mi = BvrFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(1);
		mi.setUpper(1);
		c.setInstanceMultiplicity(mi);

		// each vspec has to have target
		Target target = BvrFactory.eINSTANCE.createTarget();
		target.setName(c.getName());
		((CompoundNode) c).getOwnedTargets().add(target);
		c.setTarget(target);

		if (parent instanceof CompoundNode) {
			Context.eINSTANCE.getEditorCommands().addVClassifierToVSpec((CompoundNode) parent, c);
		} else if (parent instanceof BVRModel) {
			BVRModel model = (BVRModel) parent;
			if (model.getVariabilityModel() == null)
				Context.eINSTANCE.getEditorCommands().addVClassifierToBVRModel(model, c);
		} else {
			throw new UnexpectedException("parent is neither CompoundNode nor BVRModel, not supported");
		}
		classifierCount++;
		return c;
	}
	
	public ChoiceOccurrence appendChoiceOccurence(CompoundNode parent) {
		ChoiceOccurrence occurence = BvrFactory.eINSTANCE.createChoiceOccurrence();
		occurence.setName(defaultChoiceOccurenceName + choicCounter);
		Context.eINSTANCE.getEditorCommands().addChoiceVClassOccurence(parent, occurence);
		choicCounter ++;
		return occurence;
	}
	
	public VClassOccurrence appendVClassOccurence(CompoundNode parent) {
		VClassOccurrence occurence = BvrFactory.eINSTANCE.createVClassOccurrence();
		occurence.setName(defaultVClassOccurenceName + classifierCount);
		MultiplicityInterval mi = BvrFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(1);
		mi.setUpper(1);
		occurence.setInstanceMultiplicity(mi);
		Context.eINSTANCE.getEditorCommands().addChoiceVClassOccurence(parent, occurence);
		classifierCount ++;
		return occurence;
	}
}
