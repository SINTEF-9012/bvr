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
package no.sintef.bvr.tool.strategy.impl;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;

import bvr.Choice;
import bvr.CompoundNode;
import bvr.Target;
import bvr.VClassifier;
import no.sintef.bvr.tool.strategy.ModifyNodeStrategy;

public class RemoveStaleTargetStrategy implements ModifyNodeStrategy {

	private Pattern pattern = Pattern.compile("@\\d+$");
	
	@Override
	public void modify(EObject eObject) {
		CompoundNode node = (CompoundNode) eObject;
		Iterator<Target> iterator = node.getOwnedTargets().iterator();
		while(iterator.hasNext()) {
			Target target = iterator.next();
			if(invalidTarget(target))
				iterator.remove();
		}
	}

	@Override
	public boolean accept(EObject eObject) {
		if(eObject instanceof Choice || eObject instanceof VClassifier)
			return true;
		return false;
	}
	
	private boolean invalidTarget(Target target) {
		String name = target.getName();
		name = name.trim();
		Matcher matches = pattern.matcher(name);
		return !matches.find();
	}

}
