package no.sintef.bvr.tool.ui.editor;

import java.util.ArrayList;

import javax.swing.JTable;

import org.eclipse.emf.common.util.EList;

import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.observer.Observer;
import no.sintef.bvr.tool.observer.Subject;
import no.sintef.bvr.tool.primitive.impl.DataNamedElementItem;
import no.sintef.bvr.tool.subject.BVRModelSubject;
import no.sintef.bvr.tool.subject.SelectedFragmentSubstitutionSubject;
import no.sintef.bvr.tool.ui.command.event.SubFragTableEvent;
import no.sintef.bvr.tool.ui.command.event.SubFragTableRowSelectionEvent;
import no.sintef.bvr.tool.ui.model.SubFragTableModel;
import no.sintef.bvr.tool.ui.renderer.SubFragTableCellRenderer;
import bvr.FragmentSubstitution;
import bvr.NamedElement;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;
import bvr.VPackageable;
import bvr.VariationPoint;

public class SubstitutionFragmentJTable extends JTable implements Observer {

	private static final long serialVersionUID = 3496126066893900633L;
	
	private SubFragTableModel tableModel;
	private FragmentSubstitutionJTable fragSubJTable;
	private FragmentSubstitution selectedFragmentSubstitution;
	BVRNotifiableController controller;

	public SubstitutionFragmentJTable(BVRNotifiableController _controller){
		controller = _controller;
		tableModel = new SubFragTableModel(new ArrayList<NamedElement>());
		setModel(tableModel);
		
		setDefaultEditor(DataNamedElementItem.class, new SubFragTextTabelCellEditor());
		setDefaultRenderer(DataNamedElementItem.class, new SubFragTableCellRenderer());
		
		tableModel.addTableModelListener(new SubFragTableEvent(controller));
		getSelectionModel().addListSelectionListener(new SubFragTableRowSelectionEvent(this));
		
		getTableHeader().setReorderingAllowed(false);
	}
	
	public void setFragmentSubstitutionJTable(FragmentSubstitutionJTable table){
		this.fragSubJTable = table;
	}
	
	public FragmentSubstitutionJTable getFragmentSubstitutionJTable(){
		return this.fragSubJTable;
	}
	
	@Override
	public void update(Subject subject) {
		if(subject instanceof BVRModelSubject){
			ArrayList<NamedElement> placReplList = new ArrayList<NamedElement>();
			EList<VPackageable> packageables = ((BVRModelSubject) subject).getBVRModel().getPackageElement();
			for(VPackageable packagable : packageables){
				if(packagable instanceof ReplacementFragmentType){
					placReplList.add((ReplacementFragmentType) packagable);
				}
			}
			EList<VariationPoint> varPoints = ((BVRModelSubject) subject).getBVRModel().getRealizationModel();
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
			if(selectedFragmentSubstitution != null){
				tableModel.updateDisplayData(filterOutFragments(selectedFragmentSubstitution));
			}else{
				tableModel.updateDisplayData(tableModel.getOriginalData());
			}
		}
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
