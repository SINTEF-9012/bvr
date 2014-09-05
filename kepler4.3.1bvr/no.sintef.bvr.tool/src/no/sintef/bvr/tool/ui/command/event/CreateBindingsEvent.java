package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import bvr.FragmentSubstitution;
import bvr.VariationPoint;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.LoaderUtility;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.primitive.DataItem;
import no.sintef.bvr.tool.strategy.impl.BindingCalculatorContext;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;
import no.sintef.bvr.tool.ui.loader.BVRRealizationView;
import no.sintef.bvr.tool.ui.loader.BVRToolView;
import no.sintef.bvr.tool.ui.model.FragSubTableModel;

public class CreateBindingsEvent implements ActionListener {

	private BVRToolView view;

	public CreateBindingsEvent(BVRToolView _view){
		view = _view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
/*		ConfigurableUnit cu = view.getCU();
		
		if(((BVRRealizationView) view).getFragmentSubstitutionTable().getSelectedRows().length > 1){
			JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), Messages.DIALOG_MSG_MORE_THEN_ONE_SELECTION);
			return;
		}
		
		int rowIndex = ((BVRRealizationView) view).getFragmentSubstitutionTable().getSelectedRows()[0];
		FragSubTableModel model = (FragSubTableModel) ((BVRRealizationView) view).getFragmentSubstitutionTable().getModel();
		ArrayList<ArrayList<DataItem>> data = model.getData();
		DataItem element = data.get(rowIndex).get(Constants.FRAG_SUBS_VARIATION_POINT_CLMN);
		VariationPoint vp = (VariationPoint) element.getNamedElement();
		
		if(!(vp instanceof FragmentSubstitution)){
			JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), Messages.DIALOG_MSG_NOT_FRAG_SUB_SELECTION);
			return;
		}
		
		FragmentSubstitution fragmentSubstitution = (FragmentSubstitution) vp;
		BindingCalculatorContext bindingCalculator = new BindingCalculatorContext();

		bindingCalculator.generateBindings(fragmentSubstitution);*/
	}
}
