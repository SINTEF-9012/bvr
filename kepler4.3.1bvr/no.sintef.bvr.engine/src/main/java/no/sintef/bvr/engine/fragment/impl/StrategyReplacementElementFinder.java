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
package no.sintef.bvr.engine.fragment.impl;

import java.util.HashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import bvr.FromReplacement;
import bvr.ReplacementBoundaryElement;
import bvr.ToReplacement;
import no.sintef.bvr.engine.common.HolderDataElement;
import no.sintef.bvr.engine.common.EngineUtility;
import no.sintef.bvr.engine.fragment.AbstractElementFinder;
import no.sintef.bvr.engine.interfaces.strategy.IReplacementElementFinderStrategy;

public class StrategyReplacementElementFinder extends
			AbstractElementFinder implements IReplacementElementFinderStrategy {

	private HolderDataElement elementsHolder;
	
	public StrategyReplacementElementFinder(){
		flush();
	}

	@Override
	public HolderDataElement locateReplacementElements(EList<ReplacementBoundaryElement> rbes) {
		flush();
		for(ReplacementBoundaryElement rbe : rbes){
			if(rbe instanceof ToReplacement){
				ToReplacement toReplacement = (ToReplacement) rbe;
				EList<EObject> insideBoundaryElements = EngineUtility.resolveProxies(toReplacement.getInsideBoundaryElement());
				EObject outsideBoundaryElement = EngineUtility.resolveProxies(toReplacement.getOutsideBoundaryElement());
				elementsHolder.addBoundaryElementInternal(insideBoundaryElements);
				elementsHolder.addInnerNeighboringElement(insideBoundaryElements);
				elementsHolder.addOuterInsideReferenceElements(outsideBoundaryElement);
				elementsHolder.addOuterNeighboringElement(outsideBoundaryElement);
			}
			if(rbe instanceof FromReplacement){
				FromReplacement fromReplacement = (FromReplacement) rbe;
				EObject insideBoundaryElement = EngineUtility.resolveProxies(fromReplacement.getInsideBoundaryElement());
				EList<EObject> outsideBoundaryElements = EngineUtility.resolveProxies(fromReplacement.getOutsideBoundaryElement());
				elementsHolder.addBoundaryElementExternal(insideBoundaryElement);
				elementsHolder.addInnerNeighboringElement(insideBoundaryElement);
				elementsHolder.addOuterOutsideReferenceElement(outsideBoundaryElements);
				elementsHolder.addOuterNeighboringElement(outsideBoundaryElements);
			}
		}
		EList<EObject> elements = new BasicEList<EObject>();
		elements = calculateInnerElements(new BasicEList<EObject>(elementsHolder.getOuterInsideReferenceElements()),
				new BasicEList<EObject>(elementsHolder.getOuterOutsideReferenceElements()),
				new BasicEList<EObject>(elementsHolder.getInnerNeighboringElements()), new BasicEList<EObject>());
		elementsHolder.addInnerFragmentElements(elements);
		HashSet<EObject> boundaryElements = new HashSet<EObject>();
		boundaryElements.addAll(elementsHolder.getBoundaryElementsExternal());
		boundaryElements.addAll(elementsHolder.getBoundaryElementsInternal());
		SetView<EObject> innerElements = Sets.symmetricDifference(elementsHolder.getInnerFragmentElements(), boundaryElements);
		elementsHolder.addInnerElement(innerElements);
		return elementsHolder;
	}

	@Override
	public void flush() {
		elementsHolder = new HolderDataElement();	
	}
		
}
