package no.sintef.bvr.tool.controller;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import bvr.BVRModel;
import bvr.FragmentSubstitution;
import bvr.NamedElement;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;
import bvr.Variabletype;
import bvr.VariationPoint;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.Messages;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.command.BatchCommandExecutor;
import no.sintef.bvr.tool.controller.command.CreatePlacement;
import no.sintef.bvr.tool.controller.command.CreateReplacement;
import no.sintef.bvr.tool.controller.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.exception.UserInputError;
import no.sintef.bvr.tool.model.SubstitutionFragmentFacade;
import no.sintef.bvr.tool.primitive.DataItem;
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
import no.sintef.bvr.tool.ui.loader.BVRToolModel;
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
		tableFragmSubst = new FragmentSubstitutionJTable();
		tableSubstFragm = new SubstitutionFragmentJTable();
		bindingEditor = new BindingJTable();
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
		PlacementFragment placement = SubstitutionFragmentFacade.eINSTANCE.createPlacementFragment();
		CreatePlacement command = new CreatePlacement(containment, toolModel.getBVRModel(), placement);
		return command;
	}

	@Override
	public SimpleExeCommandInterface createReplacementFragmentCommand(boolean containment) {
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
}
