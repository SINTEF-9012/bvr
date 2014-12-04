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

import java.io.File;
import java.util.HashMap;

import no.sintef.bvr.tool.chain.ExecutionHandler;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.primitive.ExecutionRequest;
import no.sintef.bvr.tool.strategy.SaveProductStrategy;
import no.sintef.bvr.tool.strategy.impl.SimpleSaveProductStrategy;

public class SaveProductExecutionHandler implements ExecutionHandler {

	private ExecutionHandler successor;
	private SaveProductStrategy defaultStrategy;

	public SaveProductExecutionHandler(ExecutionHandler successor){
		this.successor = successor;
		this.defaultStrategy = new SimpleSaveProductStrategy();
	}
	
	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		bvr.BVRModel bvrMode = (bvr.BVRModel) request.getDataField("model");
		File destFile = (File) request.getDataField("destFile");
		BVRToolModel model =  (BVRToolModel) request.getDataField("bvrModel");
		
		if(bvrMode == null || destFile == null || model == null){
			throw new UnexpectedException("require nvr model, destinition file, and bvr model to handle this request");
		}
		
		HashMap<String, Object> keywords = new HashMap<String, Object>();
		keywords.put("model", bvrMode);
		keywords.put("destFile", destFile);
		keywords.put("bvrModel", model);
		
		defaultStrategy.saveProduct(keywords);
		
		if(successor != null)
			successor.handleRequest(request);
	}
}
