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

import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.IllegalOperationException;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.strategy.SelectionStrategy;

public class ContainmentSelectionStrategy implements SelectionStrategy {

	@Override
	public EList<EObject> getSelectedObjects() throws AbstractError {
		EList<EObject> selected = new BasicEList<EObject>();
		List<Object> selections = Context.eINSTANCE.getSelections();

		for(Object object: selections){
			EObject eObject = Context.eINSTANCE.getEObject(object);
			if(eObject == null)
				throw new UnexpectedException("no model element is found from a given selection");
			if(eObject.eContainer() == null)
				throw new IllegalOperationException("selected object is not contained anywhere or simply a top most element, not allowed yet " + eObject);
			selected.add(eObject);
		}
		
		EList<EObject> selectedObjects = this.includeContainedElements(selected);
		return selectedObjects;
	}
	
	private EList<EObject> includeContainedElements(EList<EObject> eObjects){
		HashSet<EObject> set = new HashSet<EObject>();
		for(EObject eObject : eObjects){
			set.add(eObject);
			for(TreeIterator<EObject> iterator = eObject.eAllContents(); iterator.hasNext();){
				EObject eObj = iterator.next();
				set.add(eObj);
			}
		}
		return new BasicEList<EObject>(set);
	}
}
