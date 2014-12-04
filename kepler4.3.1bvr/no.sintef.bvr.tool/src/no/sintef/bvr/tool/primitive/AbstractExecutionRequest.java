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
package no.sintef.bvr.tool.primitive;

import java.util.HashMap;

import javax.swing.JComponent;

import bvr.BVRModel;
import bvr.VSpecResolution;

public abstract class AbstractExecutionRequest implements ExecutionRequest {

	protected VSpecResolution vSpecResolution;
	protected SymbolVSpecResolutionTable table;
	protected BVRModel model;
	protected JComponent parentComponent;
	protected HashMap<String, Object> data;
	
	@Override
	public Object getDataField(String name){
		return data.get(name);
	}
	
	@Override
	public void setDataField(String string, Object object) {
		data.put(string, object);
	}
}
