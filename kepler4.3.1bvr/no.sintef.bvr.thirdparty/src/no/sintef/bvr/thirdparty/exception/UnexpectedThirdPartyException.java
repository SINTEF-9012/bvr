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
package no.sintef.bvr.thirdparty.exception;

import no.sintef.bvr.common.CommonUtility;

public class UnexpectedThirdPartyException extends
		AbstractThirdPartyEditorError {

	private static final long serialVersionUID = 5017329250280437942L;
	
	public UnexpectedThirdPartyException(String msg) {
		super(msg);
	}

	public UnexpectedThirdPartyException(Throwable ex) {
		super(CommonUtility.getStackTraceAsString(ex));
	}

}
