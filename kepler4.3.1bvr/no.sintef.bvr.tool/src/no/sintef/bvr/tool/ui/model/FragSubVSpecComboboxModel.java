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
import no.sintef.bvr.tool.primitive.impl.DataVSpecItem;

public class FragSubVSpecComboboxModel extends AbstractListModel<DataVSpecItem> implements
		ComboBoxModel<DataVSpecItem> {

	private static final long serialVersionUID = -4928670717941556052L;
	
	public ArrayList<DataVSpecItem> data;
	DataItem selectedItem = null;
	
	public FragSubVSpecComboboxModel(ArrayList<DataVSpecItem> list){
		data = list;
	}
	
	public FragSubVSpecComboboxModel(){
		data = new ArrayList<DataVSpecItem>();
	}

	@Override
	public DataVSpecItem getElementAt(int index) {
		return data.get(index);
	}

	@Override
	public int getSize() {
		return data.size();
	}

	@Override
	public Object getSelectedItem() {
		return selectedItem;
	}

	@Override
	public void setSelectedItem(Object value) {
		selectedItem = (DataItem) value;
	}
}
