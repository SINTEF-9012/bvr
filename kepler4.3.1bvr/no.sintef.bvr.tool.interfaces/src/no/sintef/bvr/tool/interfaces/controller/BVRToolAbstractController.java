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
package no.sintef.bvr.tool.interfaces.controller;

import no.sintef.bvr.tool.interfaces.controller.RealizationControllerInterface;
import no.sintef.bvr.tool.interfaces.controller.ResolutionControllerInterface;
import no.sintef.bvr.tool.interfaces.controller.VSpecControllerInterface;



abstract public class BVRToolAbstractController implements BVRNotifiableController {
	
	@SuppressWarnings("rawtypes")
	protected EditorsCommonControllerInterface commonInterface;
	
	abstract public void refresh();
	
	@Override
	public VSpecControllerInterface<?,?,?> getVSpecControllerInterface() {
		throw new UnsupportedOperationException("not supported for this view");
	}
	
	@Override
	public ResolutionControllerInterface<?, ?, ?> getResolutionControllerInterface() {
		throw new UnsupportedOperationException("not supported for this view");
	}
	
	@Override
	public RealizationControllerInterface getRealizationControllerInterface() {
		throw new UnsupportedOperationException("not supported for this view");
	}
	
	@Override
	public VTypeControllerInterface<?, ?, ?> getVTypeControllerInterface() {
		throw new UnsupportedOperationException("not supported for this view");
	}
	
	@Override
	public EditorsCommonControllerInterface<?, ?, ?> getCommonControllerInterface() {
		return commonInterface;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void setCommonControllerInterface(EditorsCommonControllerInterface commonController) {
		commonInterface = commonController;
	}
	
}
