package no.sintef.cvl.ui.editor;

import java.util.ArrayList;

import javax.swing.JTable;

import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.ui.adapters.impl.DataNamedElementItem;
import no.sintef.cvl.ui.adapters.impl.SubFragTableCellRenderer;
import no.sintef.cvl.ui.adapters.impl.SubFragTableModel;
import no.sintef.cvl.ui.adapters.impl.SubFragTextTabelCellEditor;
import no.sintef.cvl.ui.commands.events.FragSubTableEvent;
import no.sintef.cvl.ui.commands.events.SubFragTableEvent;
import no.sintef.cvl.ui.loader.CVLView;
import cvl.ConfigurableUnit;
import cvl.NamedElement;
import cvl.PlacementFragment;
import cvl.ReplacementFragmentType;
import cvl.Variabletype;
import cvl.VariationPoint;

public class SubstitutionFragmentJTable extends JTable {

	private ConfigurableUnit cu;
	private CVLView view;
	private SubFragTableModel tableModel;
	private FragmentSubstitutionJTable fragSubJTable = null;

	public SubstitutionFragmentJTable(ConfigurableUnit cu, CVLView view){
		this.cu = cu;
		this.view = view;
		
		ArrayList<NamedElement> placReplList = new ArrayList<NamedElement>();
		EList<Variabletype> varTypes = this.cu.getOwnedVariabletype();
		for(Variabletype varType : varTypes){
			if(varType instanceof ReplacementFragmentType){
				placReplList.add((ReplacementFragmentType) varType);
			}
		}
		EList<VariationPoint> varPoints = this.cu.getOwnedVariationPoint();
		for(VariationPoint varPoint : varPoints){
			if(varPoint instanceof PlacementFragment){
				placReplList.add((PlacementFragment) varPoint);
			}
		}
		
		tableModel = new SubFragTableModel(placReplList);
		setModel(tableModel);
		
		this.setDefaultEditor(DataNamedElementItem.class, new SubFragTextTabelCellEditor());
		this.setDefaultRenderer(DataNamedElementItem.class, new SubFragTableCellRenderer());
		tableModel.addTableModelListener(new SubFragTableEvent(cu, tableModel.getData(), view));
		this.getTableHeader().setReorderingAllowed(false);
	}
	
	public void setFragmentSubstitutionJTable(FragmentSubstitutionJTable table){
		this.fragSubJTable = table;
	}
	
	public FragmentSubstitutionJTable getFragmentSubstitutionJTable(){
		return this.fragSubJTable;
	}
}
