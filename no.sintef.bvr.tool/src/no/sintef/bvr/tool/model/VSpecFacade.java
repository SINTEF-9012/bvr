/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June
 * 2007; you may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package no.sintef.bvr.tool.model;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.interfaces.model.IIDProvider;
import bvr.BVRModel;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceOccurrence;
import bvr.CompoundNode;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.VClassOccurrence;
import bvr.VClassifier;
import bvr.VSpec;

public class VSpecFacade {

	public static VSpecFacade eINSTANCE = getInstance();
	private final static String defaultChoiceName = "Choice";
	private final static String defaultVClassifierName = "Classifier";
	private final static String defaultChoiceOccurenceName = "ChoiceOccurence";
	private final static String defaultVClassOccurenceName = "VClassOccurence";

	public IIDProvider choiceIDProvider;
	public IIDProvider classifierIDProvider;

	private VSpecFacade() {
		choiceIDProvider = new DefaultIDProvider();
		classifierIDProvider = new DefaultIDProvider();
	}

	private static VSpecFacade getInstance() {
		if (eINSTANCE == null)
			eINSTANCE = new VSpecFacade();
		return eINSTANCE;
	}

	private class DefaultIDProvider implements IIDProvider {

		private Integer count = 0;

		@Override
		public String getUnique() {
			String id = count.toString();
			count++;
			return id;
		}

		@Override
		public String toString() {
			return getUnique();
		}

	}

	public Choice appendChoice(NamedElement parent) {
		Choice c = BvrFactory.eINSTANCE.createChoice();
		c.setIsImpliedByParent(true);
		String targetName = defaultChoiceName + choiceIDProvider;
		c.setName(targetName);

		if (parent instanceof CompoundNode) {
			Context.eINSTANCE.getEditorCommands().addChoice(c, (CompoundNode) parent);
		} else if (parent instanceof BVRModel) {
			BVRModel model = (BVRModel) parent;
			if (model.getVariabilityModel() == null)
				Context.eINSTANCE.getEditorCommands().addChoice(c, model);
		} else {
			throw new UnexpectedException("parent is neither CompoundNode nor BVRModel, not supported");
		}
		return c;
	}

	public VClassifier appendVClassifier(NamedElement parent) {
		VClassifier c = BvrFactory.eINSTANCE.createVClassifier();
		String targetName = defaultVClassifierName + classifierIDProvider;
		c.setName(targetName);
		MultiplicityInterval mi = BvrFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(1);
		mi.setUpper(1);
		c.setInstanceMultiplicity(mi);

		if (parent instanceof CompoundNode) {
			Context.eINSTANCE.getEditorCommands().addVClassifierToVSpec((CompoundNode) parent, c);
		} else if (parent instanceof BVRModel) {
			BVRModel model = (BVRModel) parent;
			if (model.getVariabilityModel() == null)
				Context.eINSTANCE.getEditorCommands().addVClassifierToBVRModel(model, c);
		} else {
			throw new UnexpectedException("parent is neither CompoundNode nor BVRModel, not supported");
		}
		return c;
	}

	public ChoiceOccurrence appendChoiceOccurence(CompoundNode parent) {
		ChoiceOccurrence occurence = BvrFactory.eINSTANCE.createChoiceOccurrence();
		occurence.setName(defaultChoiceOccurenceName + choiceIDProvider);
		Context.eINSTANCE.getEditorCommands().addChoiceVClassOccurence(parent, occurence);
		return occurence;
	}

	public VClassOccurrence appendVClassOccurence(CompoundNode parent) {
		VClassOccurrence occurence = BvrFactory.eINSTANCE.createVClassOccurrence();
		occurence.setName(defaultVClassOccurenceName + classifierIDProvider);
		MultiplicityInterval mi = BvrFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(1);
		mi.setUpper(1);
		occurence.setInstanceMultiplicity(mi);
		Context.eINSTANCE.getEditorCommands().addChoiceVClassOccurence(parent, occurence);
		return occurence;
	}

	public void updateName(VSpec vSpec, String name) {
		String current_name = vSpec.getName();
		if (!current_name.startsWith(name))
			Context.eINSTANCE.getEditorCommands().setName(vSpec, name);

	}

	public String getBaseName(VSpec vSpec) {
		if (vSpec instanceof Choice || vSpec instanceof VClassifier) {
			return vSpec.getTarget().getName();
		}
		return vSpec.getName();
	}
}
