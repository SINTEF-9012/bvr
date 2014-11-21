package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.FragmentSubstitution;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRRealizationUIKernelInterface;
import no.sintef.bvr.tool.strategy.impl.BindingCalculatorContext;
import no.sintef.bvr.tool.strategy.impl.CreateBoundaryContext;
import no.sintef.bvr.tool.strategy.impl.GetSelectionContext;
import no.sintef.bvr.tool.strategy.impl.SingleDummyToPlacementBoundaryCalcStrategy;
import no.sintef.bvr.tool.ui.editor.BindingJTable;
import no.sintef.bvr.tool.ui.model.BindingTableModel;

public class CreateToBindingEvent implements ActionListener {

	private BVRNotifiableController view;

	public CreateToBindingEvent(BVRNotifiableController _view){
		view = _view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BVRRealizationUIKernelInterface kernel = view.getRealizationControllerInterface().getUIKernel();
		BindingJTable jtable = (BindingJTable) kernel.getBindingTable();
		BindingTableModel BindingTableModel = (BindingTableModel) jtable.getModel();
		FragmentSubstitution fragmentSubstitution = BindingTableModel.getFragmentSubstitution();
		if(fragmentSubstitution == null){
			JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), Messages.DIALOG_MSG_NO_FRAG_SUB_DETECTED);
			return;
		}
		
		GetSelectionContext selectionContext = new GetSelectionContext();
		EList<EObject> selectedObjects = selectionContext.getSelectedObjects();
		if(selectedObjects.size() == 0){
			JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(), Messages.DIALOG_MSG_NO_SELECTION);
			return;
		}
		
		CreateBoundaryContext singleToPlacementCrBoundryContext = new CreateBoundaryContext(new SingleDummyToPlacementBoundaryCalcStrategy(), null);
		singleToPlacementCrBoundryContext.creatBoundaries(fragmentSubstitution.getPlacement(), selectedObjects);
			
		BindingCalculatorContext bindingCalcContext = new BindingCalculatorContext();
		bindingCalcContext.generateBindings(fragmentSubstitution);	
	}
}
