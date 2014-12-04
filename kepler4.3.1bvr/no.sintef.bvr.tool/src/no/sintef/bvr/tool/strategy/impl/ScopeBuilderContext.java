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

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.primitive.SymbolTableEObject;
import no.sintef.bvr.tool.strategy.ContextBuilderStrategy;


public class ScopeBuilderContext {
	
	private ContextBuilderStrategy strategy;
	
	public ScopeBuilderContext(){
		strategy = new CompoundNodeScopeBuilderStrategy();
	}
	
	public ScopeBuilderContext(ContextBuilderStrategy builderStrategy){
		strategy = builderStrategy;
	}
	
	public void testEObject(EObject parent, EObject child){
		strategy.testEObject(parent, child);
	}
	
	public void init(){
		strategy.reset();
	}
	
	public SymbolTableEObject getRootScope(){
		return strategy.getRootScope();
	}
}
