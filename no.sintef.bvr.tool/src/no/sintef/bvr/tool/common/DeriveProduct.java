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
package no.sintef.bvr.tool.common;

import java.util.HashMap;

import no.sintef.bvr.tool.chain.ExecutionHandler;
import no.sintef.bvr.tool.chain.impl.ExecutionRealizationHandler;
import no.sintef.bvr.tool.chain.impl.IntersactionResolverExecutionHandler;
import no.sintef.bvr.tool.chain.impl.ParserExecutionHandler;
import no.sintef.bvr.tool.chain.impl.SaveProductExecutionHandler;
import no.sintef.bvr.tool.chain.impl.ScopeResolverExecutionHandler;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.primitive.impl.SingleExecutionRequest;


public class DeriveProduct {

	private SingleExecutionRequest request;
	private ExecutionHandler starter;

	public DeriveProduct(HashMap<String, Object> keywords) throws AbstractError{
		request = new SingleExecutionRequest(keywords);
		
		SaveProductExecutionHandler saveProduct = new SaveProductExecutionHandler(null);
		ExecutionRealizationHandler realization = new ExecutionRealizationHandler(saveProduct);
		ScopeResolverExecutionHandler scopeResolving = new ScopeResolverExecutionHandler(realization);
		IntersactionResolverExecutionHandler intersectionResolver = new IntersactionResolverExecutionHandler(scopeResolving);
		starter = new ParserExecutionHandler(intersectionResolver);
	}
	
	public void run() throws AbstractError{
		starter.handleRequest(request);
	}
}
