package no.sintef.cvl.ui.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellEditor;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.VSpec;

import no.sintef.cvl.ui.command.event.FragSubTableEvent;
import no.sintef.cvl.ui.command.event.FragSubTableRowSelectionEvent;
import no.sintef.cvl.ui.common.NullVSpec;
import no.sintef.cvl.ui.model.FragSubTableModel;
import no.sintef.cvl.ui.observer.Observer;
import no.sintef.cvl.ui.observer.Subject;
import no.sintef.cvl.ui.observer.impl.ConfigurableUnitSubject;
import no.sintef.cvl.ui.observer.impl.SelectedFragmentSubstitutionSubject;
import no.sintef.cvl.ui.primitive.DataItem;
import no.sintef.cvl.ui.primitive.impl.DataNamedElementItem;
import no.sintef.cvl.ui.primitive.impl.DataVSpecItem;
import no.sintef.cvl.ui.renderer.FragSubTableCellRenderer;

public class FragmentSubstitutionJTable extends JTable implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6490422017472288712L;
	private FragSubTableModel tableModel;
	
	private ArrayList<Subject> subjects;
	
	public FragmentSubstitutionJTable(ArrayList<Subject> sbjcts) {
		subjects = sbjcts;
		for(Subject subject : subjects)
			subject.attach(this);
			
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
		
		for(Subject subject : subjects)
			update(subject);
	}

	@Override
	public void update(Subject subject) {
		if(subject instanceof ConfigurableUnitSubject){
			ConfigurableUnit cu = ((ConfigurableUnitSubject) subject).getConfigurableUnit();
			EList<VSpec> vSpecs = getAllVSpec(cu.getOwnedVSpec(), new BasicEList<VSpec>());
			
			ArrayList<DataItem> vSpecMap = new ArrayList<DataItem>();
			
			NullVSpec nullVSpec = new NullVSpec();
			DataVSpecItem nullDataVSpecItem = new DataVSpecItem(new JLabel(nullVSpec.getName()), nullVSpec);
			vSpecMap.add(nullDataVSpecItem);
			
			for(VSpec spec : vSpecs){
				DataVSpecItem map = new DataVSpecItem(new JLabel(spec.getName()), spec);
				vSpecMap.add(map);
			}
			
			tableModel.setData(cu.getOwnedVariationPoint(), vSpecMap);
			FragSubVSpecTableCellEditor editor = (FragSubVSpecTableCellEditor) getDefaultEditor(DataVSpecItem.class);
			editor.getModel().setData(vSpecMap);
		}
		if(subject instanceof SelectedFragmentSubstitutionSubject){
			if(((SelectedFragmentSubstitutionSubject) subject).getSelectedFragmentSubstitution() == null){
				tableModel.fireTableDataChanged();
			}
		}
	}

	@Override
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	
	private EList<VSpec> getAllVSpec(EList<VSpec> vSpecList, EList<VSpec> result){
		for(VSpec vSpec : vSpecList){
			result.add(vSpec);
			result = getAllVSpec(vSpec.getChild(), result);
		}
		return result;
	}
}
