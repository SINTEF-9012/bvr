package no.sintef.cvl.ui.editor;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import cvl.ConfigurableUnit;
import cvl.NamedElement;
import cvl.VSpec;

import no.sintef.cvl.ui.adapters.impl.FragSubTableModel;
import no.sintef.cvl.ui.adapters.impl.FragSubVSpecTableCellEditor;
import no.sintef.cvl.ui.commands.events.FragmentSubstitutionTableEvent;
import no.sintef.cvl.ui.loader.CVLView;

public class FragmentSubstitutionJTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6490422017472288712L;
	private FragSubTableModel tableModel;
	private FragSubVSpecTableCellEditor editorVSpec;
	private ConfigurableUnit cu;
	private EList<VSpec> vSpecs;
	private ArrayList<HashMap<JComponent, NamedElement>> vSpecMap;
	
	public FragmentSubstitutionJTable(ConfigurableUnit cu, CVLView view) {
		this.cu = cu;
		vSpecs = new BasicEList<VSpec>();
		this.getAllVSpec(cu.getOwnedVSpec());
		vSpecMap = new ArrayList<HashMap<JComponent, NamedElement>>();
		for(VSpec spec : vSpecs){
			HashMap<JComponent, NamedElement> map = new HashMap<JComponent, NamedElement>();
			JLabel label = new JLabel(spec.getName());
			map.put(label, spec);
			vSpecMap.add(map);
		}
		tableModel = new FragSubTableModel(cu, vSpecMap);
		setModel(tableModel);
		editorVSpec = new FragSubVSpecTableCellEditor(vSpecMap);
		this.setDefaultEditor(JComboBox.class, editorVSpec);
		tableModel.addTableModelListener(new FragmentSubstitutionTableEvent(cu, tableModel.getData(), view));
	}
	
	private void getAllVSpec(EList<VSpec> vSpecList){
		for(VSpec vSpec : vSpecList){
			vSpecs.add(vSpec);
			this.getAllVSpec(vSpec.getChild());
		}
	}
}
