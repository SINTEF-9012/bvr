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

import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import org.eclipse.emf.common.util.EList;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.exception.BVRModelException;
import no.sintef.bvr.tool.primitive.impl.DataBindingItem;
import no.sintef.bvr.tool.primitive.impl.DataBoundaryItem;
import no.sintef.bvr.tool.primitive.impl.DataNamedElementItem;

import bvr.BoundaryElementBinding;
import bvr.FragmentSubstitution;
import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.FromReplacement;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;
import bvr.ToBinding;
import bvr.ToPlacement;
import bvr.ToReplacement;

public class BindingTableModel extends AbstractTableModel implements TableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6876766227353366136L;
	private FragmentSubstitution fs;
	private String[] columnNames = {
			Constants.BINDING_TYPE_CLMN_NAME,
			Constants.BINDING_PROPERTY_CLMN_NAME,
			Constants.BINDING_VALUE_CLMN_NAME
		};
	private ArrayList<ArrayList<Object>> data; 
	
	public BindingTableModel(FragmentSubstitution fragSub) throws AbstractError{
		fs = fragSub;
		data = new ArrayList<ArrayList<Object>>();
		loadBindings(fragSub);
	}
	
	public ArrayList<ArrayList<Object>> getData(){
		return data;
	}
	
	public FragmentSubstitution getFragmentSubstitution(){
		return fs;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex).get(columnIndex);
	}
	
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		switch(columnIndex){
			case Constants.BINDING_PROP_CLMN : {
				data.get(rowIndex).set(columnIndex, (DataNamedElementItem) value);
			}; break;
			case Constants.BINDING_VALUE_CLMN : {
				data.get(rowIndex).set(columnIndex, (DataBoundaryItem) value);
			}; break;
			default : {
				throw new UnsupportedOperationException("setter is not implemented for this column");
			}
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class cl;
		switch(columnIndex){
			case Constants.BINDING_TYPE_CLMN : {
				cl = DataBindingItem.class;
			}; break;
			case Constants.BINDING_PROP_CLMN : {
				cl = DataNamedElementItem.class;
			}; break;
			case Constants.BINDING_VALUE_CLMN : {
				cl = DataBoundaryItem.class;
			}; break;
			default : {
				cl = String.class;
			}
		}
		return cl;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		boolean isEditable = (columnIndex == Constants.BINDING_VALUE_CLMN || columnIndex == Constants.BINDING_PROP_CLMN) ? true : false;
		return isEditable;
	}
	
	public void updateBindingEditor(FragmentSubstitution fragSub) throws BVRModelException{
		loadBindings(fragSub);
		fireTableDataChanged();
	}

	private void loadBindings(FragmentSubstitution fragSub) throws BVRModelException{
		fs = fragSub;
		data.clear();
		if(fragSub != null){
			PlacementFragment placement = fs.getPlacement();
			ReplacementFragmentType replacement = fs.getReplacement();
			if(placement != null && replacement != null){
				ArrayList<ArrayList<Object>> dataToBindings = new ArrayList<ArrayList<Object>>();
				ArrayList<ArrayList<Object>> dataFromBindings = new ArrayList<ArrayList<Object>>();
				EList<BoundaryElementBinding> bindings = fs.getBoundaryElementBinding();
				for(BoundaryElementBinding binding : bindings){
					if(binding instanceof ToBinding){
						ToBinding toBinding = (ToBinding) binding;
						ToPlacement toPlacement = toBinding.getToPlacement();
						ToReplacement toReplacement = toBinding.getToReplacement();
						if(toPlacement == null || toReplacement == null){
							throw new BVRModelException("binding should reference toPlacement and toReplacement");
						}
						
						JLabel lableToB = new JLabel(Constants.BINDING_TYPE_TO_BINDING_NAME);
						DataBindingItem propToB = new DataBindingItem(lableToB, toBinding);
						
						JLabel labelToP = new JLabel(toPlacement.getName());
						DataNamedElementItem propToP = new DataNamedElementItem(labelToP, toPlacement);
						
						JLabel labelToR = new JLabel(toReplacement.getName());
						DataBoundaryItem propToR = new DataBoundaryItem(labelToR, toReplacement);
						
						ArrayList<Object> row = new ArrayList<Object>();
						row.add(propToB);
						row.add(propToP);
						row.add(propToR);
						dataToBindings.add(row);
					} else if (binding instanceof FromBinding){
						FromBinding fromBinding = (FromBinding) binding;
						FromPlacement fromPlacement = fromBinding.getFromPlacement();
						FromReplacement fromReplacement = fromBinding.getFromReplacement();
						if(fromPlacement == null || fromReplacement == null){
							throw new BVRModelException("binding should reference fromPlacement and fromReplacement");
						}
						
						JLabel lableFromB = new JLabel(Constants.BINDING_TYPE_FROM_BINDING_NAME);
						DataBindingItem propFromB = new DataBindingItem(lableFromB, fromBinding);
						
						JLabel labelFromP = new JLabel(fromPlacement.getName());
						DataBoundaryItem propFromP = new DataBoundaryItem(labelFromP, fromPlacement);
						
						JLabel labelFromR = new JLabel(fromReplacement.getName());
						DataNamedElementItem propFromR = new DataNamedElementItem(labelFromR, fromReplacement);
						
						ArrayList<Object> row = new ArrayList<Object>();
						row.add(propFromB);
						row.add(propFromR);
						row.add(propFromP);
						dataFromBindings.add(row);
					}
				}
				data.addAll(dataToBindings);
				data.addAll(dataFromBindings);
			}
		}		
	}
}
