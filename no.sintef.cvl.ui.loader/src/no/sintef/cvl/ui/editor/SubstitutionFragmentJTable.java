package no.sintef.cvl.ui.editor;

import java.util.ArrayList;

import javax.swing.JTable;

import org.eclipse.emf.common.util.EList;

import no.sintef.cvl.ui.command.event.SubFragTableEvent;
import no.sintef.cvl.ui.command.event.SubFragTableRowSelectionEvent;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.model.SubFragTableModel;
import no.sintef.cvl.ui.observer.Observer;
import no.sintef.cvl.ui.observer.Subject;
import no.sintef.cvl.ui.observer.impl.ConfigurableUnitSubject;
import no.sintef.cvl.ui.observer.impl.SelectedFragmentSubstitutionSubject;
import no.sintef.cvl.ui.primitive.impl.DataNamedElementItem;
import no.sintef.cvl.ui.renderer.SubFragTableCellRenderer;

import cvl.FragmentSubstitution;
import cvl.NamedElement;
import cvl.PlacementFragment;
import cvl.ReplacementFragmentType;
import cvl.Variabletype;
import cvl.VariationPoint;

public class SubstitutionFragmentJTable extends JTable implements Observer {

	private static final long serialVersionUID = 3496126066893900633L;
	
	private SubFragTableModel tableModel;
	private FragmentSubstitutionJTable fragSubJTable;
	private ArrayList<Subject> subjects;
	private FragmentSubstitution selectedFragmentSubstitution;

	public SubstitutionFragmentJTable(ArrayList<Subject> sbjcts){
		subjects = sbjcts;
		for(Subject subject : subjects)
			subject.attach(this);
		
		tableModel = new SubFragTableModel(new ArrayList<NamedElement>());
		setModel(tableModel);
		
		setDefaultEditor(DataNamedElementItem.class, new SubFragTextTabelCellEditor());
		setDefaultRenderer(DataNamedElementItem.class, new SubFragTableCellRenderer());
		
		tableModel.addTableModelListener(new SubFragTableEvent(this));
		getSelectionModel().addListSelectionListener(new SubFragTableRowSelectionEvent(this));
		
		getTableHeader().setReorderingAllowed(false);
		
		for(Subject subject : subjects)
			update(subject);
	}
	
	public void setFragmentSubstitutionJTable(FragmentSubstitutionJTable table){
		this.fragSubJTable = table;
	}
	
	public FragmentSubstitutionJTable getFragmentSubstitutionJTable(){
		return this.fragSubJTable;
	}
	
	@Override
	public void update(Subject subject) {
		if(subject instanceof ConfigurableUnitSubject){
			ArrayList<NamedElement> placReplList = new ArrayList<NamedElement>();
			EList<Variabletype> varTypes = ((ConfigurableUnitSubject) subject).getConfigurableUnit().getOwnedVariabletype();
			for(Variabletype varType : varTypes){
				if(varType instanceof ReplacementFragmentType){
					placReplList.add((ReplacementFragmentType) varType);
				}
			}
			EList<VariationPoint> varPoints = ((ConfigurableUnitSubject) subject).getConfigurableUnit().getOwnedVariationPoint();
			for(VariationPoint varPoint : varPoints){
				if(varPoint instanceof PlacementFragment){
					placReplList.add((PlacementFragment) varPoint);
				}
			}
			tableModel.setData(placReplList);
			if(selectedFragmentSubstitution != null)
				tableModel.updateDisplayData(filterOutFragments(selectedFragmentSubstitution));
		}
		if(subject instanceof SelectedFragmentSubstitutionSubject){
			selectedFragmentSubstitution = ((SelectedFragmentSubstitutionSubject) subject).getSelectedFragmentSubstitution();
			if(selectedFragmentSubstitution != null)
				tableModel.updateDisplayData(filterOutFragments(selectedFragmentSubstitution));
		}
	}

	@Override
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	
	private ArrayList<ArrayList<Object>> filterOutFragments(FragmentSubstitution fragmentSubstitution){
		PlacementFragment placement = fragmentSubstitution.getPlacement();
		ReplacementFragmentType replacement = fragmentSubstitution.getReplacement();
		ArrayList<ArrayList<Object>> newDisplayData = new ArrayList<ArrayList<Object>>();
		ArrayList<ArrayList<Object>> subsFragData = tableModel.getOriginalData();
		for(ArrayList<Object> row : subsFragData){
			DataNamedElementItem cellItem = (DataNamedElementItem) row.get(Constants.SUB_FRAG_FRAG_CLMN);
			NamedElement fragment = cellItem.getNamedElement();
			if(fragment instanceof PlacementFragment && ((PlacementFragment) fragment).equals(placement)){
				newDisplayData.add(row);
			}
			if(fragment instanceof ReplacementFragmentType && ((ReplacementFragmentType) fragment).equals(replacement)){
				newDisplayData.add(row);
			}
		}
		return newDisplayData;
	}
}
