package no.sintef.cvl.ui.editors;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import cvl.ConfigurableUnit;
import cvl.CvlFactory;
import cvl.CvlPackage;
import cvl.NamedElement;
import cvl.VSpec;

import no.sintef.cvl.ui.commands.events.FragSubTableEvent;
import no.sintef.cvl.ui.commands.events.FragSubTableRowSelectionEvent;
import no.sintef.cvl.ui.common.NullVSpec;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.models.FragSubTableModel;
import no.sintef.cvl.ui.primitives.DataItem;
import no.sintef.cvl.ui.primitives.impl.DataNamedElementItem;
import no.sintef.cvl.ui.primitives.impl.DataVSpecItem;
import no.sintef.cvl.ui.renderes.FragSubTableCellRenderer;

public class FragmentSubstitutionJTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6490422017472288712L;
	private FragSubTableModel tableModel;
	private ConfigurableUnit cu;
	private EList<VSpec> vSpecs;
	private ArrayList<DataItem> vSpecMap;
	private SubstitutionFragmentJTable subFragJTable = null;
	private BindingJTable bindingJTable;
	
	public FragmentSubstitutionJTable(ConfigurableUnit cu, CVLView view) {
		this.cu = cu;
		vSpecs = new BasicEList<VSpec>();
		this.getAllVSpec(cu.getOwnedVSpec());
		vSpecMap = new ArrayList<DataItem>();
		
		NullVSpec nullVSpec = new NullVSpec();
		DataVSpecItem nullDataVSpecItem = new DataVSpecItem(new JLabel(nullVSpec.getName()), nullVSpec);
		vSpecMap.add(nullDataVSpecItem);
		
		for(VSpec spec : vSpecs){
			DataVSpecItem map = new DataVSpecItem(new JLabel(spec.getName()), spec);
			vSpecMap.add(map);
		}
		tableModel = new FragSubTableModel(cu, vSpecMap);
		this.setModel(tableModel);
		
		this.setDefaultEditor(DataVSpecItem.class, new FragSubVSpecTableCellEditor(vSpecMap));
		this.setDefaultEditor(DataNamedElementItem.class, new FragSubTextTabelCellEditor());
		
		this.setDefaultRenderer(DataVSpecItem.class, new FragSubTableCellRenderer());
		this.setDefaultRenderer(DataNamedElementItem.class, new FragSubTableCellRenderer());
		
		tableModel.addTableModelListener(new FragSubTableEvent(cu, tableModel.getData(), view));
		this.getSelectionModel().addListSelectionListener(new FragSubTableRowSelectionEvent(this));
		this.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
	}
	
	public void setSubstitutionFragmentJTable(SubstitutionFragmentJTable table){
		this.subFragJTable = table;
	}
	
	public SubstitutionFragmentJTable getSubstitutionFragmentJTable(){
		return this.subFragJTable;
	}
	
	private void getAllVSpec(EList<VSpec> vSpecList){
		for(VSpec vSpec : vSpecList){
			vSpecs.add(vSpec);
			this.getAllVSpec(vSpec.getChild());
		}
	}

	public void setBindingJTable(BindingJTable bindingEditor) {
		this.bindingJTable = bindingEditor;
	}
	
	public BindingJTable getBindingJTable(){
		return this.bindingJTable;
	}
}
