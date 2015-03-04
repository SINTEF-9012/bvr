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

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import bvr.BVRModel;
import bvr.CompoundNode;
import no.sintef.bvr.tool.interfaces.model.IBVRSPLCAModelTransformator;
import no.sintef.bvr.tool.strategy.ModifyNodeStrategy;
import no.sintef.bvr.tool.strategy.impl.CreateTargetsModifyStrategy;
import no.sintef.bvr.tool.strategy.impl.RemoveStaleTargets;

public class BVRSPLCAModelTransformator implements IBVRSPLCAModelTransformator {

	private ModifyNodeStrategy[] compoundNodeModifiers = { new CreateTargetsModifyStrategy(), new RemoveStaleTargets() };
	private BVRModel model;
	private CompoundNode copiedVarModel;
	private List<CompoundNode> compundNodes;

	public BVRSPLCAModelTransformator(BVRModel _model) {
		model = _model;
	}

	@Override
	public CompoundNode transformVarModelToSPLCA() {
		copiedVarModel = EcoreUtil.copy(model.getVariabilityModel());

		compundNodes = new BasicEList<CompoundNode>();
		compundNodes.add(copiedVarModel);

		TreeIterator<EObject> iterator = copiedVarModel.eAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			if (eObject instanceof CompoundNode)
				compundNodes.add((CompoundNode) eObject);
		}

		for (CompoundNode node : compundNodes) {
			for (ModifyNodeStrategy modifier : compoundNodeModifiers) {
				if (modifier.accept(node))
					modifier.modify(node);
			}
		}

		return copiedVarModel;
	}

}
