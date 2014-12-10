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
package splar.core.fm;

import java.util.HashMap;
import java.util.Map;

public class FeatureTreeNodeState {
	
	private String stateID;
	protected FeatureTreeNode featureNode;
	protected int value;
	protected boolean isImmutable;
	protected Map<String,Object> properties;
	
	public String getStateID() {
		return stateID;
	}
	
	public FeatureTreeNodeState( String stateID, FeatureTreeNode featureNode ) {
		this.stateID = stateID;
		this.featureNode = featureNode;
	}
	
	public void save() {
		value = featureNode.getValue();
		isImmutable = featureNode.isImmutable();
		properties = new HashMap<String, Object>(featureNode.properties);
	}
	
	public void restore() {
		featureNode.assignValue(value);
		featureNode.setImmutable(isImmutable);
		featureNode.properties.clear();
		featureNode.properties.putAll(properties);
	}
	
	public int savedValue() {
		return value;
	}
	
	public void discard() {
	}
}
