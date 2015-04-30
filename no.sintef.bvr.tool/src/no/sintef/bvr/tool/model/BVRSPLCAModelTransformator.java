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

import java.util.List;

import no.sintef.bvr.tool.exception.MalformedVarModelException;
import no.sintef.bvr.tool.interfaces.common.IVarModelResolutionsCopier;
import no.sintef.bvr.tool.interfaces.model.IBVRSPLCAModelTransformator;
import no.sintef.bvr.tool.strategy.ModifyNodeStrategy;
import no.sintef.bvr.tool.strategy.impl.BCLConstraintModifiyTargetsStrategy;
import no.sintef.bvr.tool.strategy.impl.CreateTargetsModifyStrategy;
import no.sintef.bvr.tool.strategy.impl.RemoveStaleTargetStrategy;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import bvr.BCLConstraint;
import bvr.BVRModel;
import bvr.Choice;
import bvr.CompoundNode;
import bvr.Target;
import bvr.VClassifier;
import bvr.VSpec;

public class BVRSPLCAModelTransformator implements IBVRSPLCAModelTransformator {

	private ModifyNodeStrategy[] compoundNodeModifiers = { new CreateTargetsModifyStrategy(), new RemoveStaleTargetStrategy() };
	private ModifyNodeStrategy[] constraintModifiers = { new BCLConstraintModifiyTargetsStrategy() };
	private BVRModel model;
	private CompoundNode copiedVarModel;
	private List<CompoundNode> compoundNodes;
	private List<BCLConstraint> constraints;
	private BVRModel copiedModel;
	private IVarModelResolutionsCopier copier;

	public BVRSPLCAModelTransformator(BVRModel _model, IVarModelResolutionsCopier _copier) {
		model = _model;
		copier = _copier;
	}

	@Override
	public CompoundNode transformVarModelToSPLCA() {
		sanityModelCheck();

		copier.copyAbsractions(model);
		copiedModel = copier.getCopiedBVRModel();
		copiedVarModel = copiedModel.getVariabilityModel();
		compoundNodes = new BasicEList<CompoundNode>();
		compoundNodes.add(copiedVarModel);
		constraints = new BasicEList<BCLConstraint>();

		TreeIterator<EObject> iterator = copiedVarModel.eAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			if (eObject instanceof CompoundNode)
				compoundNodes.add((CompoundNode) eObject);

			if (eObject instanceof BCLConstraint)
				constraints.add((BCLConstraint) eObject);
		}

		for (CompoundNode node : compoundNodes) {
			for (ModifyNodeStrategy modifier : compoundNodeModifiers) {
				if (modifier.accept(node))
					modifier.modify(node);
			}
		}

		for (BCLConstraint constraint : constraints) {
			for (ModifyNodeStrategy modifier : constraintModifiers) {
				if (modifier.accept(constraint)) {
					if (modifier instanceof BCLConstraintModifiyTargetsStrategy)
						((BCLConstraintModifiyTargetsStrategy) modifier).init(compoundNodes, copiedModel);

					modifier.modify(constraint);
				}
			}
		}

		return copiedVarModel;
	}

	@Override
	public IVarModelResolutionsCopier getModelCopier() {
		return copier;
	}

	private void sanityModelCheck() {
		CompoundNode variabilityModel = model.getVariabilityModel();
		checkVSpec(variabilityModel, (VSpec) variabilityModel);

		TreeIterator<EObject> contents = variabilityModel.eAllContents();

		while (contents.hasNext()) {
			EObject eObject = contents.next();
			if (eObject instanceof Choice || eObject instanceof VClassifier)
				checkVSpec(variabilityModel, (VSpec) eObject);
		}

	}

	private void checkVSpec(CompoundNode varModel, VSpec vSpec) {
		String choiceBaseName;
		try {
			choiceBaseName = PostfixGeneratorFacade.eINSTANCE.removePostfix(vSpec.getName());
		} catch (Exception ex) {
			throw new MalformedVarModelException(ex.getMessage(), ex);
		}

		Target target = vSpec.getTarget();
		if (target == null)
			throw new MalformedVarModelException("target is not set for the choice " + vSpec);

		if (!target.getName().equals(choiceBaseName))
			throw new MalformedVarModelException("target name and base name of the vspec do not match " + vSpec + " " + target);
	}

}
