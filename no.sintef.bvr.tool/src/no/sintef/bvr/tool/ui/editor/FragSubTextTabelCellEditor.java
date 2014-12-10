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
import java.util.EventObject;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

import javax.swing.AbstractCellEditor;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.primitive.DataItem;

public class FragSubTextTabelCellEditor extends AbstractCellEditor implements
		TableCellEditor {

	private static final long serialVersionUID = 7772738255299065846L;
	private JTextField  editor;
	private DataItem editedValue = null;
	
	public FragSubTextTabelCellEditor(){
		editor = new JTextField();
	}

	@Override
	public Object getCellEditorValue() {
		editedValue.getLabel().setText(editor.getText());
		return editedValue;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		editedValue = (DataItem) table.getModel().getValueAt(row, column);
		editor.setText(editedValue.getLabel().getText());
		return editor;
	}
	
	@Override
	public boolean isCellEditable(EventObject e) {
		if (e instanceof MouseEvent) {
			return ((MouseEvent) e).getClickCount() >= Constants.FRAG_SUB_FS_CLICK_COUNT_TO_EDIT;
		}
		return true;
	}

}
