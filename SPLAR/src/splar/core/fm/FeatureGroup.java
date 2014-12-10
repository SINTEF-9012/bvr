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


public class FeatureGroup extends FeatureTreeNode {

	private boolean isOptional = false;
	private int min=1, max=1;
	
	public FeatureGroup( String id, String name, int min, int max) {		
		super(id,name);
		this.min = min;
		this.max = max;
	}
	
	public int getMin() {
		return min;
	}
	
	public int getMax() {
		return max;
	}

	public String getDescription() {
		String name = "";
		if ( !getName().startsWith("_")) {
			name = getName();
		}
		return name + " [" + getMin() + "," + (getMax()==-1?"*":getMax()) + "] ";
	}

	public String toString() {
		return ":g "+ super.toString() + " [" + getMin() + "," + (getMax()==-1?"*":getMax()) + "] ";
	}
}
