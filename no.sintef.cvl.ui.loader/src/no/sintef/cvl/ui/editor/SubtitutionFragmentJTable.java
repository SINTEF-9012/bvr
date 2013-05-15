package no.sintef.cvl.ui.editor;

import java.util.ArrayList;

import javax.swing.JTable;

import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.ui.adapters.impl.DataNamedElementItem;
import no.sintef.cvl.ui.adapters.impl.SubFragTableCellRenderer;
import no.sintef.cvl.ui.adapters.impl.SubFragTableModel;
import no.sintef.cvl.ui.adapters.impl.SubFragTextTabelCellEditor;
import no.sintef.cvl.ui.loader.CVLView;
import cvl.ConfigurableUnit;
import cvl.NamedElement;
import cvl.PlacementFragment;
import cvl.ReplacementFragmentType;
import cvl.Variabletype;
import cvl.VariationPoint;

public class SubtitutionFragmentJTable extends JTable {

	private ConfigurableUnit cu;
	private CVLView view;
	private SubFragTableModel tabelModel;

	public SubtitutionFragmentJTable(ConfigurableUnit cu, CVLView view){
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
		
		tabelModel = new SubFragTableModel(placReplList);
		setModel(tabelModel);
		
		this.setDefaultEditor(DataNamedElementItem.class, new SubFragTextTabelCellEditor());
		this.setDefaultRenderer(DataNamedElementItem.class, new SubFragTableCellRenderer());
		//this.setDefaultEditor(String.class, new SubFragTextTabelCellEditor());
		//this.setDefaultRenderer(String.class, new SubFragTableCellRenderer());
	}
}
