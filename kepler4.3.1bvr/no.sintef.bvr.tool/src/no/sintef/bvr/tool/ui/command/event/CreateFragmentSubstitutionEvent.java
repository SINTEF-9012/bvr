package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import bvr.BvrFactory;
import bvr.FragmentSubstitution;
import bvr.NamedElement;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.primitive.impl.DataNamedElementItem;
import no.sintef.bvr.tool.ui.loader.BVRRealizationView;
import no.sintef.bvr.tool.ui.loader.BVRToolView;
import no.sintef.bvr.tool.ui.model.SubFragTableModel;

public class CreateFragmentSubstitutionEvent implements ActionListener {

	private BVRToolView view;
	static int count = 0;

	public CreateFragmentSubstitutionEvent(BVRToolView _view){
		view = _view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
/*		ConfigurableUnit cu = view.getCU();
		BVRRealizationView rView = (BVRRealizationView) view;
		
		
		if(rView.getSubsitutionFragmentTable().getSelectedRows().length != 2){
			JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), Messages.DIALOG_MSG_TWO_ROWS_SELECTED);
			return;
		}
		
		int[] rowIndexes = rView.getSubsitutionFragmentTable().getSelectedRows();
		SubFragTableModel model = (SubFragTableModel) rView.getSubsitutionFragmentTable().getModel();
		ArrayList<ArrayList<Object>> data = model.getData();
		
		DataNamedElementItem firstRowDataElement = (DataNamedElementItem) data.get(rowIndexes[0]).get(Constants.SUB_FRAG_FRAG_CLMN);
		DataNamedElementItem secondRowDataElement = (DataNamedElementItem) data.get(rowIndexes[1]).get(Constants.SUB_FRAG_FRAG_CLMN);
		
		HashMap<PlacementFragment, ReplacementFragmentType> tuple = this.isSelectionValid(firstRowDataElement, secondRowDataElement);
		if(tuple == null){
			JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), Messages.DIALOG_MSG_PLCM_REPL_SELECTED);
			return;
		}

		count++;
		PlacementFragment placement = tuple.keySet().iterator().next();
		ReplacementFragmentType replacement = tuple.values().iterator().next();
		
		FragmentSubstitution fs = BvrFactory.eINSTANCE.createFragmentSubstitution();
		fs.setName("FragmentSubstititution-" + placement.getName() + "-" + replacement.getName() + "-" + count);
		fs.setPlacement(placement);
		fs.setReplacement(replacement);
		Context.eINSTANCE.getEditorCommands().addOwnedVariationPoint(cu, fs);*/
	}
	
	private HashMap<PlacementFragment, ReplacementFragmentType> isSelectionValid(DataNamedElementItem d, DataNamedElementItem d1){
		NamedElement fragment = d.getNamedElement();
		NamedElement fragment1 = d1.getNamedElement();
		HashMap<PlacementFragment, ReplacementFragmentType> tuple = new HashMap<PlacementFragment, ReplacementFragmentType>();
		if((fragment instanceof PlacementFragment) && (fragment1 instanceof ReplacementFragmentType)){
			tuple.put((PlacementFragment) fragment, (ReplacementFragmentType) fragment1);
			return tuple;
		}
		if((fragment1 instanceof PlacementFragment) && (fragment instanceof ReplacementFragmentType)){
			tuple.put((PlacementFragment) fragment1, (ReplacementFragmentType) fragment);
			return tuple;
		}
		return null;
	}
}
