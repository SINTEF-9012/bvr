package no.sintef.bvr.tool.controller;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.BVRModel;
import bvr.BoundaryElementBinding;
import bvr.FragmentSubstitution;
import bvr.NamedElement;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;
import bvr.VSpec;
import bvr.Variabletype;
import bvr.VariationPoint;
import no.sintef.bvr.common.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.common.NullVSpec;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.command.BatchCommandExecutor;
import no.sintef.bvr.tool.controller.command.CreatePlacement;
import no.sintef.bvr.tool.controller.command.CreateReplacement;
import no.sintef.bvr.tool.exception.UserInputError;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.model.SubstitutionFragmentFacade;
import no.sintef.bvr.tool.primitive.DataItem;
import no.sintef.bvr.tool.primitive.impl.DataBindingItem;
import no.sintef.bvr.tool.primitive.impl.DataBoundaryItem;
import no.sintef.bvr.tool.primitive.impl.DataNamedElementItem;
import no.sintef.bvr.tool.primitive.impl.ObserverDataBulk;
import no.sintef.bvr.tool.subject.BVRModelSubject;
import no.sintef.bvr.tool.subject.SelectedFragmentSubstitutionSubject;
import no.sintef.bvr.tool.ui.dropdown.BindingEditorDropDownListener;
import no.sintef.bvr.tool.ui.dropdown.BindingEditorTableDropDownListener;
import no.sintef.bvr.tool.ui.dropdown.FragmentSubstitutionDropDownListener;
import no.sintef.bvr.tool.ui.dropdown.FragmentSubstitutionTableDropDownListener;
import no.sintef.bvr.tool.ui.dropdown.SubstitutionFragmentDropDownListener;
import no.sintef.bvr.tool.ui.dropdown.SubstitutionFragmentTableDropDownListener;
import no.sintef.bvr.tool.ui.editor.BVRRealizationUIKernel;
import no.sintef.bvr.tool.ui.editor.BindingJTable;
import no.sintef.bvr.tool.ui.editor.FragmentSubstitutionJTable;
import no.sintef.bvr.tool.ui.editor.SubstitutionFragmentJTable;
import no.sintef.bvr.tool.ui.loader.BVRRealizationUIKernelInterface;
import no.sintef.bvr.tool.ui.model.BindingTableModel;
import no.sintef.bvr.tool.ui.model.FragSubTableModel;
import no.sintef.bvr.tool.ui.model.SubFragTableModel;

public class SwingRealizationController implements
		RealizationControllerInterface {

	private BVRToolModel toolModel;
	private BVRNotifiableController controller;
	private JTabbedPane realizationPanel;
	private FragmentSubstitutionJTable tableFragmSubst;
	private SubstitutionFragmentJTable tableSubstFragm;
	private BindingJTable bindingEditor;
	
	private SelectedFragmentSubstitutionSubject selectedFS;
	private BVRModelSubject bvrModelSubject;
	
	private BVRRealizationUIKernel kernel;

	public SwingRealizationController(BVRToolModel _model, BVRNotifiableController _controller) {
		toolModel = _model;
		controller = _controller;
		bvrModelSubject = new BVRModelSubject(toolModel.getBVRModel());
    	selectedFS = new SelectedFragmentSubstitutionSubject(null);
    	kernel = new BVRRealizationUIKernel();

        realizationPanel = new JTabbedPane();
        loadBVRRelalizationView(toolModel.getBVRModel());
	}
	
	@Override
	public BVRRealizationUIKernelInterface getUIKernel() {
		return kernel;
	}
	
	private void loadBVRRelalizationView(BVRModel model) {
		tableFragmSubst = new FragmentSubstitutionJTable(controller);
		tableSubstFragm = new SubstitutionFragmentJTable(controller);
		bindingEditor = new BindingJTable(controller);
		kernel.setFragmentSubstitutionTable(tableFragmSubst);
		kernel.setSubsitutionFragmentTable(tableSubstFragm);
		kernel.setBindingTable(bindingEditor);
		
		
		JScrollPane scrollPanelFragmSubst = new JScrollPane(tableFragmSubst);
		tableFragmSubst.addMouseListener(new FragmentSubstitutionTableDropDownListener(controller));
		scrollPanelFragmSubst.addMouseListener(new FragmentSubstitutionDropDownListener(controller));
		
		
		JScrollPane scrollPanelSubstFragm = new JScrollPane(tableSubstFragm);
		tableSubstFragm.addMouseListener(new SubstitutionFragmentTableDropDownListener(controller));
		scrollPanelSubstFragm.addMouseListener(new SubstitutionFragmentDropDownListener(controller));
		JPanel panel = new JPanel(new GridLayout(1, 2));
		panel.setName(Constants.REALIZATION_VP_SUBTAB_NAME);
		panel.add(scrollPanelFragmSubst);
		panel.add(scrollPanelSubstFragm);
		realizationPanel.add(panel);
		 
		
		bindingEditor.addMouseListener(new BindingEditorTableDropDownListener(controller));
		JScrollPane scrollPanelBinding = new JScrollPane(bindingEditor);
		scrollPanelBinding.addMouseListener(new BindingEditorDropDownListener(controller));
		
		scrollPanelBinding.setName(Constants.BINDING_EDITOR_NAME);
		realizationPanel.add(scrollPanelBinding, realizationPanel.getComponentCount());
		
		Context.eINSTANCE.getViewChangeManager().register(bvrModelSubject, tableFragmSubst);
		Context.eINSTANCE.getViewChangeManager().register(selectedFS, tableFragmSubst);
		Context.eINSTANCE.getViewChangeManager().register(bvrModelSubject, tableSubstFragm);
		Context.eINSTANCE.getViewChangeManager().register(selectedFS, tableSubstFragm);
		Context.eINSTANCE.getViewChangeManager().register(bvrModelSubject, bindingEditor);
		Context.eINSTANCE.getViewChangeManager().register(selectedFS, bindingEditor);
		
		bvrModelSubject.notifyObserver();
		selectedFS.notifyObserver();
	}
	
	public void render(){
		bvrModelSubject.notifyObserver();
	}
	
	public JTabbedPane getRealizationPanel(){
		return realizationPanel;
	}
	
	@Override
	public SimpleExeCommandInterface createPlacementFragmentCommand(boolean containment) {
		clearSelection();
		PlacementFragment placement = SubstitutionFragmentFacade.eINSTANCE.createPlacementFragment();
		CreatePlacement command = new CreatePlacement(containment, toolModel.getBVRModel(), placement);
		return command;
	}

	@Override
	public SimpleExeCommandInterface createReplacementFragmentCommand(boolean containment) {
		clearSelection();
		ReplacementFragmentType replacement = SubstitutionFragmentFacade.eINSTANCE.createReplacementFragment();
		CreateReplacement command = new CreateReplacement(containment, toolModel.getBVRModel(), replacement);
		return command;
	}

	@Override
	public void deleteSubstitutionFragments() {		
		ArrayList<NamedElement> placReplcFragmentsUsed = new ArrayList<NamedElement>();
		EList<VariationPoint> variationPoints = toolModel.getBVRModel().getRealizationModel();
		for(VariationPoint vp : variationPoints){
			if(vp instanceof FragmentSubstitution){
				placReplcFragmentsUsed.add(((FragmentSubstitution) vp).getPlacement());
				placReplcFragmentsUsed.add(((FragmentSubstitution) vp).getReplacement());
			}
		}
		
		int[] rowIndexes = tableSubstFragm.getSelectedRows();
		SubFragTableModel modelSubFrag = (SubFragTableModel) tableSubstFragm.getModel();
		ArrayList<ArrayList<Object>> dataSubFrag = modelSubFrag.getData();
		ArrayList<NamedElement> placReplcFragmentsNotDeleted = new ArrayList<NamedElement>();
		EList<VariationPoint> placements = new BasicEList<VariationPoint>();
		EList<Variabletype> replacements = new BasicEList<Variabletype>();
		for(int index : rowIndexes){
			NamedElement fragment = ((DataItem) dataSubFrag.get(index).get(Constants.SUB_FRAG_FRAG_CLMN)).getNamedElement();
			if(placReplcFragmentsUsed.indexOf(fragment) < 0){
				if(fragment instanceof PlacementFragment){
					placements.add((VariationPoint) fragment);
				}else if(fragment instanceof ReplacementFragmentType){
					replacements.add((Variabletype) fragment);
				}
			}else{
				placReplcFragmentsNotDeleted.add(fragment);
			}
		}
		toolModel.deleteReplacements(replacements);
		toolModel.deletePlacements(placements);
	}

	@Override
	public SimpleExeCommandInterface createDeleteSubstitutionFragmentsCommand() {
		BatchCommandExecutor command = new BatchCommandExecutor(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				deleteSubstitutionFragments();
			}
		});
		return command;
	}
	
	@Override
	public void deleteFragmentSubstitutions(){
		if(tableFragmSubst.getSelectedRows().length == 0)
			throw new UserInputError(Messages.DIALOG_MSG_NO_SELECTION);

		int[] rowIndexes = tableFragmSubst.getSelectedRows();
		FragSubTableModel model = (FragSubTableModel) tableFragmSubst.getModel();
		ArrayList<ArrayList<DataItem>> data = model.getData();
		EList<VariationPoint> fslist = new BasicEList<VariationPoint>();
		for(int index : rowIndexes){
			DataItem element = data.get(index).get(Constants.FRAG_SUBS_VARIATION_POINT_CLMN);
			VariationPoint vp = (VariationPoint) element.getNamedElement();
			fslist.add(vp);
		}
		
		clearSelection();
		toolModel.deleteFragments(fslist);
	}

	@Override
	public SimpleExeCommandInterface createDeleteFragmentSubstitutionsCommand() {
		BatchCommandExecutor command = new BatchCommandExecutor(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				deleteFragmentSubstitutions();
			}
		});
		return command;
	}
	
	@Override
	public void createFragmentSubstitution(){
		if(tableSubstFragm.getSelectedRows().length != 2)
			throw new UserInputError(Messages.DIALOG_MSG_TWO_ROWS_SELECTED);
		
		int[] rowIndexes = tableSubstFragm.getSelectedRows();
		SubFragTableModel model = (SubFragTableModel) tableSubstFragm.getModel();
		ArrayList<ArrayList<Object>> data = model.getData();
		
		DataNamedElementItem firstRowDataElement = (DataNamedElementItem) data.get(rowIndexes[0]).get(Constants.SUB_FRAG_FRAG_CLMN);
		DataNamedElementItem secondRowDataElement = (DataNamedElementItem) data.get(rowIndexes[1]).get(Constants.SUB_FRAG_FRAG_CLMN);
		
		HashMap<PlacementFragment, ReplacementFragmentType> tuple = isSelectionValid(firstRowDataElement, secondRowDataElement);
		if(tuple == null)
			throw new UserInputError(Messages.DIALOG_MSG_PLCM_REPL_SELECTED);

		PlacementFragment placement = tuple.keySet().iterator().next();
		ReplacementFragmentType replacement = tuple.values().iterator().next();
		
		toolModel.createFragmentSubstitution(placement, replacement);
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
	
	@Override
	public SimpleExeCommandInterface createGenerateBindingsCommand(){
		BatchCommandExecutor command = new BatchCommandExecutor(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				if(tableFragmSubst.getSelectedRows().length > 1)
					throw new UserInputError(Messages.DIALOG_MSG_MORE_THEN_ONE_SELECTION);
				
				int rowIndex = tableFragmSubst.getSelectedRows()[0];
				FragSubTableModel model = (FragSubTableModel) tableFragmSubst.getModel();
				ArrayList<ArrayList<DataItem>> data = model.getData();
				DataItem element = data.get(rowIndex).get(Constants.FRAG_SUBS_VARIATION_POINT_CLMN);
				VariationPoint vp = (VariationPoint) element.getNamedElement();
				
				if(!(vp instanceof FragmentSubstitution))
					throw new UserInputError(Messages.DIALOG_MSG_NOT_FRAG_SUB_SELECTION);
				
				FragmentSubstitution fragmentSubstitution = (FragmentSubstitution) vp;
				toolModel.generateBindings(fragmentSubstitution);
			}
		});
		return command;
	}

	@Override
	public SimpleExeCommandInterface createUpdateFragmentSubstitutionCommand(int _rowIndex, int _columnIndex) {
		final int columnIndex = _columnIndex;
		final int rowIndex = _rowIndex;
		BatchCommandExecutor command = new BatchCommandExecutor(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				FragSubTableModel model = (FragSubTableModel) tableFragmSubst.getModel();
				DataItem fragSubCell = model.getData().get(rowIndex).get(Constants.FRAG_SUBS_VARIATION_POINT_CLMN);
				VariationPoint vp = (VariationPoint) fragSubCell.getNamedElement();
				if(columnIndex == Constants.FRAG_SUBS_VARIATION_POINT_CLMN){
					JLabel label = (JLabel) fragSubCell.getLabel();
					toolModel.updateName(vp, label.getText());
				}
				if(columnIndex == Constants.FRAG_SUBS_VSPEC_CLMN){
					DataItem vspeCell = model.getData().get(rowIndex).get(Constants.FRAG_SUBS_VSPEC_CLMN);
					VSpec vSpec = (VSpec) vspeCell.getNamedElement();
					if(vSpec instanceof NullVSpec){
						toolModel.updateFragmentSubstitutionBinding(vp, null);
					}else{
						toolModel.updateFragmentSubstitutionBinding(vp, vSpec);
					}
				}
			}
		});
		return command;
	}
	
	@Override
	public SimpleExeCommandInterface createUpdateSubstitutionFragmentCommand(int _rowIndex, int _columnIndex) {
		final int columnIndex = _columnIndex;
		final int rowIndex = _rowIndex;
		BatchCommandExecutor command = new BatchCommandExecutor(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				if(columnIndex == Constants.SUB_FRAG_FRAG_CLMN){
					SubFragTableModel tableModel = (SubFragTableModel) tableSubstFragm.getModel();
					DataItem modifiedCell = (DataItem) tableModel.getData().get(rowIndex).get(columnIndex);
					NamedElement vp = (NamedElement) modifiedCell.getNamedElement();
					JLabel label = (JLabel) modifiedCell.getLabel();
					toolModel.updateName(vp, label.getText());
				}
			}
		});
		return command;		
	}

	@Override
	public SimpleExeCommandInterface createHighlightFragmentElementsCommand(ArrayList<Integer> _selectedRows) {
		final ArrayList<Integer> selectedRows = _selectedRows;
		final EList<HashMap<EObject, Integer>> objectsToHighlightList = new BasicEList<HashMap<EObject, Integer>>();
		BatchCommandExecutor command = new BatchCommandExecutor(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
	            SubFragTableModel model =  (SubFragTableModel) tableSubstFragm.getModel();
	            ArrayList<ArrayList<Object>> data = model.getData();
				for(Integer index : selectedRows){
	            	DataNamedElementItem subFragDataElement = (DataNamedElementItem) data.get(index).get(Constants.SUB_FRAG_FRAG_CLMN);
	            	NamedElement fragment = subFragDataElement.getNamedElement();
	            	objectsToHighlightList.addAll(toolModel.findFragmentElementsToHighlight(fragment));
				}
				toolModel.highlightElements(objectsToHighlightList);
			}
		});
		return command;		
	}

	@Override
	public void fragmentSubstitutionRowSelected(int _selectedIndex) {
		FragSubTableModel sourceModel = (FragSubTableModel) tableFragmSubst.getModel();
		ArrayList<ArrayList<DataItem>> sourceData = sourceModel.getData();
		ArrayList<DataItem> selectedRow = sourceData.get(_selectedIndex);
		DataNamedElementItem selectedFragSubData = (DataNamedElementItem) selectedRow.get(Constants.FRAG_SUBS_VARIATION_POINT_CLMN);
		NamedElement variationPoint = selectedFragSubData.getNamedElement();
		if(variationPoint instanceof FragmentSubstitution){
			ObserverDataBulk data = new ObserverDataBulk();
			FragmentSubstitution fragmentSubstitution = (FragmentSubstitution) variationPoint;
			data.setDataField("selectedFragmentSubstitution", fragmentSubstitution);
			Context.eINSTANCE.getViewChangeManager().updateSubjects(data, tableFragmSubst);
		}else{
			throw new UnsupportedOperationException("FragmentSubstitution should be passed when you select a row, but we have " + variationPoint);
		}
	}

	@Override
	public void highlightBoundaryElements(int _selectedIndex) {
		EList<HashMap<EObject, Integer>> objectsToHighlightList = new BasicEList<HashMap<EObject, Integer>>();
		BindingTableModel model = (BindingTableModel) bindingEditor.getModel();
		ArrayList<ArrayList<Object>> data = model.getData();
		DataBindingItem bindingCell = (DataBindingItem) data.get(_selectedIndex).get(Constants.BINDING_TYPE_CLMN);
		NamedElement binding = bindingCell.getNamedElement();
		objectsToHighlightList.addAll(toolModel.findBoundaryElementsToHighlight(binding));
		toolModel.highlightElements(objectsToHighlightList);
	}

	@Override
	public SimpleExeCommandInterface createUpdateBindingCommand(int _rowIndex, int _columnIndex) {
		final int columnIndex = _columnIndex;
		final int rowIndex = _rowIndex;
		BatchCommandExecutor command = new BatchCommandExecutor(new SimpleExeCommandInterface() {
			@Override
			public void execute() {
				BindingTableModel model = (BindingTableModel) bindingEditor.getModel();
				ArrayList<ArrayList<Object>> data = model.getData();
				DataBindingItem bindingCell = (DataBindingItem) data.get(rowIndex).get(Constants.BINDING_TYPE_CLMN);
				BoundaryElementBinding binding = (BoundaryElementBinding) bindingCell.getNamedElement();
				if(columnIndex == Constants.BINDING_VALUE_CLMN){
					DataBoundaryItem valueCell = (DataBoundaryItem) data.get(rowIndex).get(Constants.BINDING_VALUE_CLMN);
					NamedElement boundary = valueCell.getNamedElement();
					toolModel.updateBindingBoundary(binding, boundary);
				}else{
					throw new UnsupportedOperationException("edition operaton for this celll is not implemented");
				}	
			}
		});
		return command;
	}

	@Override
	public void clearSelection() {
		ObserverDataBulk data = new ObserverDataBulk();
		data.setDataField("selectedFragmentSubstitution", null);
		selectedFS.setState(data);
		Context.eINSTANCE.getViewChangeManager().updateSubjects(data, tableFragmSubst);
		toolModel.clearHighlightedObjects();
	}
}
