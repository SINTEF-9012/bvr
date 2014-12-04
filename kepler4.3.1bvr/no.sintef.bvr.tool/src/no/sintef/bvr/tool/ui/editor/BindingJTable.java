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

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.observer.Observer;
import no.sintef.bvr.tool.observer.Subject;
import no.sintef.bvr.tool.primitive.DataItem;
import no.sintef.bvr.tool.primitive.impl.DataBindingItem;
import no.sintef.bvr.tool.primitive.impl.DataBoundaryItem;
import no.sintef.bvr.tool.primitive.impl.DataNamedElementItem;
import no.sintef.bvr.tool.subject.BVRModelSubject;
import no.sintef.bvr.tool.subject.SelectedFragmentSubstitutionSubject;
import no.sintef.bvr.tool.ui.command.event.BindingModelTableEvent;
import no.sintef.bvr.tool.ui.command.event.BindingRowSelectionEvent;
import no.sintef.bvr.tool.ui.dropdown.BoundariesDropDownCalculator;
import no.sintef.bvr.tool.ui.model.BindingTableModel;
import no.sintef.bvr.tool.ui.renderer.BindingBindingCellRenderer;
import no.sintef.bvr.tool.ui.renderer.BindingBoundariesCellRenderer;
import bvr.FragmentSubstitution;

public class BindingJTable extends JTable implements Observer {

	private static final long serialVersionUID = 8644097588893969285L;
	private FragmentSubstitution selectedFragmentSubstitution;
	private BindingTableModel tableModel;
	private BVRNotifiableController controller;

	public BindingJTable(BVRNotifiableController _controller) throws AbstractError{
		controller = _controller;
		tableModel = new BindingTableModel(selectedFragmentSubstitution);
		setModel(tableModel);
		
		setDefaultRenderer(DataBindingItem.class, new BindingBindingCellRenderer());
		setDefaultRenderer(DataNamedElementItem.class, new BindingBoundariesCellRenderer());
		setDefaultRenderer(DataBoundaryItem.class, new BindingBoundariesCellRenderer());
		setDefaultEditor(DataBoundaryItem.class, new BindingBoundariesComboBoxTableCellEditor());
		
		//setDefaultEditor(DataNamedElementItem.class, new BindingBoundariesTextTableCellEditor());
		
		setColumnSelectionAllowed(false);
		getTableHeader().setReorderingAllowed(false);
		getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		getSelectionModel().addListSelectionListener(new BindingRowSelectionEvent(controller));
		tableModel.addTableModelListener(new BindingModelTableEvent(controller));	
	}
	
	@Override
	public void update(Subject subject) {
		if(subject instanceof SelectedFragmentSubstitutionSubject){
			selectedFragmentSubstitution = ((SelectedFragmentSubstitutionSubject) subject).getSelectedFragmentSubstitution();
			updateBindingEditor();
		}
		if(subject instanceof BVRModelSubject){
			updateBindingEditor();
		}
		
	}

	private void updateBindingEditor() {
		((BindingTableModel) getModel()).updateBindingEditor(selectedFragmentSubstitution);
		BindingBoundariesComboBoxTableCellEditor editor = (BindingBoundariesComboBoxTableCellEditor) getDefaultEditor(DataBoundaryItem.class);
		HashMap<DataItem, ArrayList<DataItem>> boundariesMap = null;
		if(selectedFragmentSubstitution != null)
			boundariesMap = BoundariesDropDownCalculator.calulateAllowedBoundaries(selectedFragmentSubstitution);
		editor.setData(boundariesMap);
	}
}
