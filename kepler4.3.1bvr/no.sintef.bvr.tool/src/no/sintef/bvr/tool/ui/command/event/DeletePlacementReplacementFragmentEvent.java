package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import bvr.ConfigurableUnit;
import bvr.FragmentSubstitution;
import bvr.NamedElement;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;
import bvr.Variabletype;
import bvr.VariationPoint;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.primitive.DataItem;
import no.sintef.bvr.tool.ui.loader.BVRRealizationView;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.model.SubFragTableModel;

public class DeletePlacementReplacementFragmentEvent implements ActionListener {

	private BVRView view;

	public DeletePlacementReplacementFragmentEvent(BVRView _view){
		view = _view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ConfigurableUnit cu = view.getCU();
		BVRRealizationView rView = (BVRRealizationView) view;
		
		ArrayList<NamedElement> placReplcFragmentsUsed = new ArrayList<NamedElement>();
		EList<VariationPoint> variationPoints = cu.getOwnedVariationPoint();
		for(VariationPoint vp : variationPoints){
			if(vp instanceof FragmentSubstitution){
				placReplcFragmentsUsed.add(((FragmentSubstitution) vp).getPlacement());
				placReplcFragmentsUsed.add(((FragmentSubstitution) vp).getReplacement());
			}
		}
		
		int[] rowIndexes = rView.getSubsitutionFragmentTable().getSelectedRows();
		SubFragTableModel modelSubFrag = (SubFragTableModel) rView.getSubsitutionFragmentTable().getModel();
		ArrayList<ArrayList<Object>> dataSubFrag = modelSubFrag.getData();
		ArrayList<NamedElement> placReplcFragmentsNotDeleted = new ArrayList<NamedElement>();
		EList<VariationPoint> placements = new BasicEList<VariationPoint>();
		EList<Variabletype> replacements = new BasicEList<Variabletype>();
		for(int index : rowIndexes){
			NamedElement fragment = ((DataItem) dataSubFrag.get(index).get(Constants.SUB_FRAG_FRAG_CLMN)).getNamedElement();
			if(placReplcFragmentsUsed.indexOf(fragment) < 0){
				if(fragment instanceof PlacementFragment){
					//cu.getOwnedVariationPoint().remove(fragment);
					placements.add((VariationPoint) fragment);
				}else if(fragment instanceof ReplacementFragmentType){
					//cu.getOwnedVariabletype().remove(fragment);
					replacements.add((Variabletype) fragment);
				}
			}else{
				placReplcFragmentsNotDeleted.add(fragment);
			}
		}
		
		if(placements.size() > 0)
			Context.eINSTANCE.getEditorCommands().removeOwenedVariationPoints(cu, placements);
		
		if(replacements.size() > 0)
			Context.eINSTANCE.getEditorCommands().removeOwnedVariationTypes(cu, replacements);
		
		if(placReplcFragmentsNotDeleted.size() > 0){
			String name = new String(Messages.DIALOG_MSG_CAN_NOT_REMOVE_PLC_RPLC + "\n");
			for(NamedElement element : placReplcFragmentsNotDeleted){
				name+=element.getName() + "\n";
			}
			JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), name);
		}
	}

}
