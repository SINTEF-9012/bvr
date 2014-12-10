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
package no.sintef.bvr.tool.chain.impl;

import no.sintef.bvr.tool.chain.ExecutionHandler;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.primitive.ExecutionRequest;
import no.sintef.bvr.tool.primitive.SymbolVSpecResolutionTable;
import no.sintef.bvr.tool.strategy.ScopeResolverStrategy;
import no.sintef.bvr.tool.strategy.impl.ScopeResolverStrategyScopeable;
import no.sintef.bvr.tool.strategy.impl.ScopeResolverStrategyScopeless;

public class ScopeResolverExecutionHandler implements ExecutionHandler {
	
	private ExecutionHandler successor;
	private ScopeResolverStrategy defaultStrategy;

	public ScopeResolverExecutionHandler(ExecutionHandler successor){
		this.successor = successor;
		//this.defaultStrategy = new ScopeResolverStrategyScopeless();
		this.defaultStrategy = new ScopeResolverStrategyScopeable();
	}

	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		SymbolVSpecResolutionTable table = (SymbolVSpecResolutionTable) request.getDataField("productSymbolTable");
		if(table == null){
			throw new UnexpectedException("symbol table is not set");
		}
		
		this.defaultStrategy.resolveScopes(table);
		
		if(this.successor != null)
			this.successor.handleRequest(request);
	}

}
