package no.sintef.cvl.ui.editor;

import javax.swing.JComboBox;
import javax.swing.JTable;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import cvl.ConfigurableUnit;
import cvl.VSpec;

import no.sintef.cvl.ui.adapters.FragmentSubstitutionTableModel;
import no.sintef.cvl.ui.adapters.FragmentSubstitutionVSpecCellEditor;
import no.sintef.cvl.ui.loader.CVLView;

public class FragmentSubstitutionJTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6490422017472288712L;
	private FragmentSubstitutionTableModel tableModel;
	private FragmentSubstitutionVSpecCellEditor editorVSpec;
	private ConfigurableUnit cu;
	private EList<VSpec> vSpecs;  
	
	public FragmentSubstitutionJTable(ConfigurableUnit cu, CVLView view) {
		super(new FragmentSubstitutionTableModel(cu, view));
		this.cu = cu;
		tableModel = (FragmentSubstitutionTableModel) this.getModel();
		init();
	}
	
	private void init(){
		vSpecs = new BasicEList<VSpec>();
		this.getAllVSpec(cu.getOwnedVSpec());
		editorVSpec = new FragmentSubstitutionVSpecCellEditor(vSpecs);
		this.setDefaultEditor(JComboBox.class, editorVSpec);
	}
	
	private void getAllVSpec(EList<VSpec> vSpecList){
		for(VSpec vSpec : vSpecList){
			vSpecs.add(vSpec);
			this.getAllVSpec(vSpec.getChild());
		}
	}
}
