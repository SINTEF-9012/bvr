package no.sintef.cvl.tool.ui.editor;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import cvl.ConfigurableUnit;
import cvl.VSpec;
import cvl.Variable;

import no.sintef.cvl.tool.common.NullVSpec;
import no.sintef.cvl.tool.observer.Observer;
import no.sintef.cvl.tool.observer.Subject;
import no.sintef.cvl.tool.primitive.impl.DataNamedElementItem;
import no.sintef.cvl.tool.primitive.impl.DataVSpecItem;
import no.sintef.cvl.tool.subject.ConfigurableUnitSubject;
import no.sintef.cvl.tool.subject.SelectedFragmentSubstitutionSubject;
import no.sintef.cvl.tool.ui.command.event.FragSubTableEvent;
import no.sintef.cvl.tool.ui.command.event.FragSubTableRowSelectionEvent;
import no.sintef.cvl.tool.ui.model.FragSubTableModel;
import no.sintef.cvl.tool.ui.renderer.FragSubTableCellRenderer;

public class FragmentSubstitutionJTable extends JTable implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6490422017472288712L;
	private FragSubTableModel tableModel;
	
	public FragmentSubstitutionJTable() {
		tableModel = new FragSubTableModel();
		setModel(tableModel);
		
		setDefaultEditor(DataNamedElementItem.class, new FragSubTextTabelCellEditor());
		
		setDefaultRenderer(DataVSpecItem.class, new FragSubTableCellRenderer());
		setDefaultRenderer(DataNamedElementItem.class, new FragSubTableCellRenderer());
		setDefaultEditor(DataVSpecItem.class, new FragSubVSpecTableCellEditor());
		
		tableModel.addTableModelListener(new FragSubTableEvent(this));
		getSelectionModel().addListSelectionListener(new FragSubTableRowSelectionEvent(this));
		getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTableHeader().setReorderingAllowed(false);
	}

	@Override
	public void update(Subject subject) {
		if(subject instanceof ConfigurableUnitSubject){
			ConfigurableUnit cu = ((ConfigurableUnitSubject) subject).getConfigurableUnit();
			EList<VSpec> vSpecs = getAllVSpec(cu.getOwnedVSpec(), new BasicEList<VSpec>());
			
			ArrayList<DataVSpecItem> vSpecMap = new ArrayList<DataVSpecItem>();
			
			NullVSpec nullVSpec = new NullVSpec();
			DataVSpecItem nullDataVSpecItem = new DataVSpecItem(new JLabel(nullVSpec.getName()), nullVSpec);
			vSpecMap.add(nullDataVSpecItem);
			
			for(VSpec spec : vSpecs){
				if(!(spec instanceof Variable)){
					DataVSpecItem map = new DataVSpecItem(new JLabel(spec.getName()), spec);
					vSpecMap.add(map);
				}
			}
			
			tableModel.setData(cu.getOwnedVariationPoint(), vSpecMap);
			FragSubVSpecTableCellEditor editor = (FragSubVSpecTableCellEditor) getDefaultEditor(DataVSpecItem.class);
			editor.setData(vSpecMap);
		}
		if(subject instanceof SelectedFragmentSubstitutionSubject){
			if(((SelectedFragmentSubstitutionSubject) subject).getSelectedFragmentSubstitution() == null){
				tableModel.fireTableDataChanged();
			}
		}
	}
	
	private EList<VSpec> getAllVSpec(EList<VSpec> vSpecList, EList<VSpec> result){
		for(VSpec vSpec : vSpecList){
			result.add(vSpec);
			result = getAllVSpec(vSpec.getChild(), result);
		}
		return result;
	}
}
