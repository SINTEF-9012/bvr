package no.sintef.bvr.tool.controller;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import bvr.BVRModel;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.context.Context;
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

public class SwingRealizationController implements
		RealizationControllerInterface {

	private BVRToolModel model;
	private BVRNotifiableController controller;
	private JTabbedPane realizationPanel;
	private FragmentSubstitutionJTable tableFragmSubst;
	private SubstitutionFragmentJTable tableSubstFragm;
	private BindingJTable bindingEditor;
	
	private SelectedFragmentSubstitutionSubject selectedFS;
	private BVRModelSubject bvrModelSubject;
	
	private BVRRealizationUIKernel kernel;

	public SwingRealizationController(BVRToolModel _model, BVRNotifiableController _controller) {
		model = _model;
		controller = _controller;
		bvrModelSubject = new BVRModelSubject(model.getBVRModel());
    	selectedFS = new SelectedFragmentSubstitutionSubject(null);
    	kernel = new BVRRealizationUIKernel();

        realizationPanel = new JTabbedPane();
        loadBVRRelalizationView(model.getBVRModel());
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
	
	

}
