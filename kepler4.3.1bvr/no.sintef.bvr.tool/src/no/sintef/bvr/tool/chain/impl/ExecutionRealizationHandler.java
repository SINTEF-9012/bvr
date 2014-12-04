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
import no.sintef.bvr.tool.strategy.RealizationStrategy;
import no.sintef.bvr.tool.strategy.impl.RealizationStrategyBottomUp;
import no.sintef.bvr.tool.strategy.impl.RealizationStrategyDefault;
import no.sintef.bvr.tool.strategy.impl.RealizationStrategyScopeless;

public class ExecutionRealizationHandler implements ExecutionHandler {
	
	private ExecutionHandler successor;
	private RealizationStrategy defaultStrategy;

	public ExecutionRealizationHandler(ExecutionHandler successor){
		this.successor = successor;
		//this.defaultStrategy = new RealizationStrategyScopeless();
		//this.defaultStrategy = new RealizationStrategyDefault();
		this.defaultStrategy = new RealizationStrategyBottomUp();
	}
	
	public ExecutionRealizationHandler(ExecutionHandler successor, RealizationStrategy strategy){
		this.successor = successor;
		this.defaultStrategy = strategy;
	}

	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		SymbolVSpecResolutionTable table = (SymbolVSpecResolutionTable) request.getDataField("productSymbolTable");
		
		if(table == null){
			throw new UnexpectedException("symbol table is not set");
		}
		
		this.defaultStrategy.deriveProduct(table);
		
		if(this.successor != null)
			this.successor.handleRequest(request);
	}

}
