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
package no.sintef.bvr.tool.ui.editor;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.exception.UnexpectedException;
import no.sintef.bvr.tool.primitive.DataItem;
import no.sintef.bvr.tool.ui.model.BindingBoundariesComboBoxModel;
import no.sintef.bvr.tool.ui.renderer.BindingBoundariesComboBoxRenderer;

public class BindingBoundariesComboBoxTableCellEditor extends AbstractCellEditor
		implements TableCellEditor {

	private static final long serialVersionUID = 7072158898721982324L;
	
	private HashMap<DataItem, ArrayList<DataItem>> data;
	private DataItem editedBoundaryProperty;
	private HashMap<DataItem, JComboBox<DataItem>> editedBoundaryPropertyComboBoxMap;
	
	public BindingBoundariesComboBoxTableCellEditor(HashMap<DataItem, ArrayList<DataItem>> boundariesListMap){
		data = boundariesListMap;
		editedBoundaryPropertyComboBoxMap = new HashMap<DataItem, JComboBox<DataItem>>();
	}
	
	public BindingBoundariesComboBoxTableCellEditor(){
		data = null;
		editedBoundaryPropertyComboBoxMap = new HashMap<DataItem, JComboBox<DataItem>>();
	}
	
	public void setData(HashMap<DataItem, ArrayList<DataItem>> boundariesListMap){
		data = boundariesListMap;
		editedBoundaryPropertyComboBoxMap = new HashMap<DataItem, JComboBox<DataItem>>();
	}
	
	@Override
	public Object getCellEditorValue() {
		JComboBox<DataItem> editor = editedBoundaryPropertyComboBoxMap.get(editedBoundaryProperty);
		if(editor == null)
			throw new UnexpectedException("editor should not be ever null here, or at least we assume that. We should set an editor on a getTableCellEditorComponent call");
		return editor.getSelectedItem();
	}
		
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex, int columnIndex) {
		JComboBox<DataItem> editor = null;
		if(data != null){
			editedBoundaryProperty = (DataItem) table.getModel().getValueAt(rowIndex, Constants.BINDING_PROP_CLMN);
			editor = editedBoundaryPropertyComboBoxMap.get(editedBoundaryProperty);
			if(editor == null){
				ArrayList<DataItem> comboxData = data.get(editedBoundaryProperty);
				editor = new JComboBox<DataItem>(new BindingBoundariesComboBoxModel(comboxData));
				editor.setRenderer(new BindingBoundariesComboBoxRenderer());
				editedBoundaryPropertyComboBoxMap.put(editedBoundaryProperty, editor);
			}
			editor.getModel().setSelectedItem(table.getModel().getValueAt(rowIndex, columnIndex));
		}
		return editor;
	}
	
	@Override
	public boolean isCellEditable(EventObject e) {
		if(e instanceof MouseEvent){
			return ((MouseEvent) e).getClickCount() >= Constants.BINDING_BOUNDARIES_CLICK_COUNT_TO_EDIT;
		}
		return true;
	}
}
