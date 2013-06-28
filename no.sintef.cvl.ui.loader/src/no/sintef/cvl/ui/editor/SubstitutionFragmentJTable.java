package no.sintef.cvl.ui.editor;

import java.util.ArrayList;

import javax.swing.JTable;

import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.ui.command.event.FragSubTableEvent;
import no.sintef.cvl.ui.command.event.SubFragTableEvent;
import no.sintef.cvl.ui.command.event.SubFragTableRowSelectionEvent;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.model.SubFragTableModel;
import no.sintef.cvl.ui.primitive.impl.DataNamedElementItem;
import no.sintef.cvl.ui.renderer.SubFragTableCellRenderer;
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
		
		setDefaultEditor(DataNamedElementItem.class, new SubFragTextTabelCellEditor());
		setDefaultRenderer(DataNamedElementItem.class, new SubFragTableCellRenderer());
		
		tableModel.addTableModelListener(new SubFragTableEvent(cu, tableModel.getData(), view));
		getSelectionModel().addListSelectionListener(new SubFragTableRowSelectionEvent(this));
		
		getTableHeader().setReorderingAllowed(false);
	}
	
	public void setFragmentSubstitutionJTable(FragmentSubstitutionJTable table){
		this.fragSubJTable = table;
	}
	
	public FragmentSubstitutionJTable getFragmentSubstitutionJTable(){
		return this.fragSubJTable;
	}
}
