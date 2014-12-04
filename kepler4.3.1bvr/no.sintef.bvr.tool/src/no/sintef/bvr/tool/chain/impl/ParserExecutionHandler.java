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

import bvr.BVRModel;
import bvr.PosResolution;
import bvr.VSpecResolution;
import no.sintef.bvr.tool.chain.ExecutionHandler;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.primitive.ExecutionRequest;
import no.sintef.bvr.tool.primitive.SymbolVSpecResolutionTable;
import no.sintef.bvr.tool.strategy.TableBuilderStrategy;
import no.sintef.bvr.tool.strategy.impl.RRComposerStrategy;

public class ParserExecutionHandler implements ExecutionHandler {

	private ExecutionHandler successor;
	private TableBuilderStrategy defaultTableBuilder;

	public ParserExecutionHandler(ExecutionHandler successor){
		this.successor = successor;
		this.defaultTableBuilder = new RRComposerStrategy();
	}
	
	public ParserExecutionHandler(ExecutionHandler successor, TableBuilderStrategy tableBuilder){
		this.successor = successor;
		this.defaultTableBuilder = tableBuilder;
	}
	
	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		
		BVRModel bvrModel = (BVRModel) request.getDataField("model");
		PosResolution posResolution = (PosResolution) request.getDataField("PosResolution");
		
		if(bvrModel == null || posResolution == null){
			throw new UnexpectedException("bvr model or root vspec resolution is not set");
		}
		
		SymbolVSpecResolutionTable table = this.defaultTableBuilder.buildSymbolTable(bvrModel, posResolution);
		request.setDataField("productSymbolTable", table);
		
		if(this.successor != null)
			this.successor.handleRequest(request);
	}

}
