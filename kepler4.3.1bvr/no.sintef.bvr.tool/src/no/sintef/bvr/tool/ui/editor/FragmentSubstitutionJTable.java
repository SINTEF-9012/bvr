package no.sintef.bvr.tool.ui.editor;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import bvr.BVRModel;
import bvr.VSpec;
import bvr.Variable;
import no.sintef.bvr.tool.common.NullVSpec;
import no.sintef.bvr.tool.observer.Observer;
import no.sintef.bvr.tool.observer.Subject;
import no.sintef.bvr.tool.primitive.impl.DataNamedElementItem;
import no.sintef.bvr.tool.primitive.impl.DataVSpecItem;
import no.sintef.bvr.tool.subject.BVRModelSubject;
import no.sintef.bvr.tool.subject.SelectedFragmentSubstitutionSubject;
import no.sintef.bvr.tool.ui.command.event.FragSubTableEvent;
import no.sintef.bvr.tool.ui.command.event.FragSubTableRowSelectionEvent;
import no.sintef.bvr.tool.ui.model.FragSubTableModel;
import no.sintef.bvr.tool.ui.renderer.FragSubTableCellRenderer;

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
		if(subject instanceof BVRModelSubject){
			BVRModel cu = ((BVRModelSubject) subject).getConfigurableUnit();
			/*EList<VSpec> vSpecs = getAllVSpec(cu.getOwnedVSpec(), new BasicEList<VSpec>());
			
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
			editor.setData(vSpecMap);*/
		}
		if(subject instanceof SelectedFragmentSubstitutionSubject){
			if(((SelectedFragmentSubstitutionSubject) subject).getSelectedFragmentSubstitution() == null){
				tableModel.fireTableDataChanged();
			}
		}
	}
	
	/*private EList<VSpec> getAllVSpec(EList<VSpec> vSpecList, EList<VSpec> result){
		for(VSpec vSpec : vSpecList){
			result.add(vSpec);
			result = getAllVSpec(vSpec.getChild(), result);
		}
		return result;
	}*/
}
