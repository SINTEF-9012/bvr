package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import bvr.ConfigurableUnit;
import bvr.VariationPoint;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.primitive.DataItem;
import no.sintef.bvr.tool.ui.loader.BVRRealizationView;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.model.FragSubTableModel;

public class DeleteFragmentSubstitutionEvent implements ActionListener {

	private BVRView view;

	public DeleteFragmentSubstitutionEvent(BVRView _view){
		view = _view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ConfigurableUnit cu = view.getCU();
		
		if(((BVRRealizationView ) view).getFragmentSubstitutionTable().getSelectedRows().length == 0){
			JOptionPane.showMessageDialog(null, Messages.DIALOG_MSG_NO_SELECTION);
			return;
		}
		
		int[] rowIndexes = ((BVRRealizationView ) view).getFragmentSubstitutionTable().getSelectedRows();
		FragSubTableModel model = (FragSubTableModel) ((BVRRealizationView ) view).getFragmentSubstitutionTable().getModel();
		ArrayList<ArrayList<DataItem>> data = model.getData();
		EList<VariationPoint> fslist = new BasicEList<VariationPoint>();
		for(int index : rowIndexes){
			DataItem element = data.get(index).get(Constants.FRAG_SUBS_VARIATION_POINT_CLMN);
			VariationPoint vp = (VariationPoint) element.getNamedElement();
			fslist.add(vp);
		}
		
		Context.eINSTANCE.getEditorCommands().removeOwenedVariationPoints(cu, fslist);
	}

}
