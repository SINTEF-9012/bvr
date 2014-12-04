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
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.primitive.ExecutionRequest;

public class ResetExecutionHandler implements ExecutionHandler {
	
	private ExecutionHandler successor;

	public ResetExecutionHandler(ExecutionHandler successor) {
		this.successor = successor;
	}

	@Override
	public void handleRequest(ExecutionRequest request) throws AbstractError {
		BVRNotifiableController bvrView = (BVRNotifiableController) request.getDataField("bvrView");
		BVRToolModel bvrModel = (BVRToolModel) request.getDataField("bvrModel");
		if(bvrView == null){
			throw new UnexpectedException("bvrView is required to reset model");
		}
		Context.eINSTANCE.reloadModel(bvrModel);
		//bvrView.notifyAllViews();
		
		if(this.successor != null)
			this.successor.handleRequest(request);
	}

}
