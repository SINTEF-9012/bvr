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
package no.sintef.bvr.tool.ui.model;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import no.sintef.bvr.tool.primitive.DataItem;

public class BindingBoundariesComboBoxModel extends AbstractListModel<DataItem>
		implements ComboBoxModel<DataItem> {

	private static final long serialVersionUID = 5126299116838742212L;
	
	private ArrayList<DataItem> data;
	private DataItem seletedItem = null;

	public BindingBoundariesComboBoxModel(ArrayList<DataItem> boundariesList){
		data = boundariesList;
	}
	
	@Override
	public DataItem getElementAt(int index) {
		return data.get(index);
	}

	@Override
	public int getSize() {
		return data.size();
	}

	@Override
	public Object getSelectedItem() {
		return seletedItem;
	}

	@Override
	public void setSelectedItem(Object value) {
		seletedItem = (DataItem) value;
	}
}
