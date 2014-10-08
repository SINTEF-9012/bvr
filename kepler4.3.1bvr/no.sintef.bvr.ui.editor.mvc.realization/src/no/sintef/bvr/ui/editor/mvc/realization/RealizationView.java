package no.sintef.bvr.ui.editor.mvc.realization;

import java.awt.GridLayout;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

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
import no.sintef.bvr.tool.ui.editor.BindingJTable;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.editor.FragmentSubstitutionJTable;
import no.sintef.bvr.tool.ui.editor.SubstitutionFragmentJTable;
import no.sintef.bvr.tool.ui.loader.BVRRealizationView;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;
import no.sintef.bvr.tool.ui.loader.BVRToolViewAbstract;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;
import bvr.BVRModel;
import bvr.NamedElement;
import bvr.VSpecResolution;

public class RealizationView extends BVRToolViewAbstract implements BVRRealizationView {
	private BVRToolModel m;
	
	public JTabbedPane modelPane;
	
	// VSpec
	public JScrollPane vspecScrollPane;
	public EditableModelPanel vspecEpanel;
	private Map<JComponent, NamedElement> vspecvmMap;
	private BVRUIKernel vSpecbvruikernel;
	
	// Resolutions
	public JTabbedPane resPane;
	private List<Map<JComponent, NamedElement>> resolutionvmMaps;
	// Realization
	public JTabbedPane realizationPanel;
	private FragmentSubstitutionJTable tableFragmSubst;
	private SubstitutionFragmentJTable tableSubstFragm;
	private BindingJTable bindingEditor;
	
	private SelectedFragmentSubstitutionSubject selectedFS;
	private BVRModelSubject bvrModelSubject;


	int choiceCount = 1;
	
	public FragmentSubstitutionJTable getFragmentSubstitutionTable(){
		return tableFragmSubst;
	}
	
	public SubstitutionFragmentJTable getSubsitutionFragmentTable(){
		return tableSubstFragm;
	}
	
	public BindingJTable getBindingTable(){
		return bindingEditor;
	}
	
	public BVRUIKernel getKernel() {
		return vSpecbvruikernel;
	}
	
	public RealizationView(BVRToolModel _m) {
		m = _m;
		bvrModelSubject = new BVRModelSubject(getBVRModel());
    	selectedFS = new SelectedFragmentSubstitutionSubject(null);
    	
    	vSpecbvruikernel = new BVRUIKernel(vspecvmMap, this, resolutionvmMaps);
		
        // Realization panel
        realizationPanel = new JTabbedPane();
        loadBVRRelalizationView(m.getBVRModel());
	}

	@Override
	public BVRModelSubject getBVRModelSubject(){
		return bvrModelSubject;
	}

	@Override
	public BVRModel getBVRModel() {
		return m.getBVRModel();
	}
	
	@Override
	public BVRToolModel getBVRToolModel() {
		return m;
	}

	private void loadBVRRelalizationView(BVRModel model) {
		tableFragmSubst = new FragmentSubstitutionJTable();
		JScrollPane scrollPanelFragmSubst = new JScrollPane(tableFragmSubst);
		
		tableFragmSubst.addMouseListener(new FragmentSubstitutionTableDropDownListener(this));
		scrollPanelFragmSubst.addMouseListener(new FragmentSubstitutionDropDownListener(this));
		
		tableSubstFragm = new SubstitutionFragmentJTable();
		JScrollPane scrollPanelSubstFragm = new JScrollPane(tableSubstFragm);
		
		tableSubstFragm.addMouseListener(new SubstitutionFragmentTableDropDownListener(this));
		scrollPanelSubstFragm.addMouseListener(new SubstitutionFragmentDropDownListener(this));
		
		JPanel panel = new JPanel(new GridLayout(1, 2));
		panel.setName(Constants.REALIZATION_VP_SUBTAB_NAME);
		panel.add(scrollPanelFragmSubst);
		panel.add(scrollPanelSubstFragm);
		realizationPanel.add(panel);
		 
		bindingEditor = new BindingJTable();
		bindingEditor.addMouseListener(new BindingEditorTableDropDownListener(this));
		
		JScrollPane scrollPanelBinding = new JScrollPane(bindingEditor);
		scrollPanelBinding.addMouseListener(new BindingEditorDropDownListener(this));
		
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

	public void notifyRelalizationViewReset(){
		bvrModelSubject.notifyObserver();
	}
	
	@Override
	public void refresh() {
		notifyRelalizationViewReset();
	}
}