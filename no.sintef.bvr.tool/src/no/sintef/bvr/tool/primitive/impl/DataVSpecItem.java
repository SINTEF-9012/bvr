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
package no.sintef.bvr.tool.primitive.impl;

import javax.swing.JLabel;

import no.sintef.bvr.tool.primitive.AbstractDataItem;
import bvr.VSpec;

public class DataVSpecItem extends AbstractDataItem{
	
	public DataVSpecItem(JLabel label, VSpec vspec){
		this.label = label;
		this.data = vspec;
	}
	
	public boolean equals(Object object){
		if(object instanceof DataVSpecItem){
			DataVSpecItem item = (DataVSpecItem) object;
			if(getNamedElement().equals(item.getNamedElement())){
				return true;
			}
		}
		return false;
	}
}
