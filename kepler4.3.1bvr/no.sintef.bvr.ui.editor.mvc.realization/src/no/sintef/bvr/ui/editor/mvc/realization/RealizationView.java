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
import no.sintef.bvr.tool.subject.ConfigurableUnitSubject;
import no.sintef.bvr.tool.subject.SelectedFragmentSubstitutionSubject;
import no.sintef.bvr.tool.ui.dropdown.FragmentSubstitutionDropDown;
import no.sintef.bvr.tool.ui.dropdown.FragmentSubstitutionDropDownListener;
import no.sintef.bvr.tool.ui.dropdown.FragmentSubstitutionTableDropDownListener;
import no.sintef.bvr.tool.ui.dropdown.SubstitutionFragmentDropDownListener;
import no.sintef.bvr.tool.ui.dropdown.SubstitutionFragmentTableDropDownListener;
import no.sintef.bvr.tool.ui.editor.BindingJTable;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.editor.FragmentSubstitutionJTable;
import no.sintef.bvr.tool.ui.editor.SubstitutionFragmentJTable;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.tool.ui.loader.BVRRealizationView;
import no.sintef.bvr.tool.ui.loader.BVRViewAbstract;
import no.sintef.bvr.ui.framework.elements.EditableModelPanel;
import bvr.ConfigurableUnit;
import bvr.NamedElement;

public class RealizationView extends BVRViewAbstract implements BVRRealizationView {
	private BVRModel m;
	
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
	private ConfigurableUnitSubject configurableUnitSubject;


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
	
	public RealizationView(BVRModel _m) {
		m = _m;
    	//bvrViewSubject = new BVRViewSubject(this);
		
    	configurableUnitSubject = new ConfigurableUnitSubject(getCU());
    	vSpecbvruikernel = new BVRUIKernel(vspecvmMap, this, resolutionvmMaps);
		
        // Realization panel
        realizationPanel = new JTabbedPane();
        loadBVRRelalizationView(m.getBVRM().getCU());
	}

	@Override
	public ConfigurableUnitSubject getConfigurableUnitSubject(){
		return configurableUnitSubject;
	}

	@Override
	public ConfigurableUnit getCU() {
		return m.getCU();
	}
	
	@Override
	public BVRModel getModel() {
		return m;
	}

	private void loadBVRRelalizationView(ConfigurableUnit cu) {
		selectedFS = new SelectedFragmentSubstitutionSubject(null);
		
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
		JScrollPane scrollPanelBinding = new JScrollPane(bindingEditor);
		scrollPanelBinding.setName(Constants.BINDING_EDITOR_NAME);
		realizationPanel.add(scrollPanelBinding, realizationPanel.getComponentCount());
		
		Context.eINSTANCE.getViewChangeManager().register(configurableUnitSubject, tableFragmSubst);
		Context.eINSTANCE.getViewChangeManager().register(selectedFS, tableFragmSubst);
		Context.eINSTANCE.getViewChangeManager().register(configurableUnitSubject, tableSubstFragm);
		Context.eINSTANCE.getViewChangeManager().register(selectedFS, tableSubstFragm);
		Context.eINSTANCE.getViewChangeManager().register(configurableUnitSubject, bindingEditor);
		Context.eINSTANCE.getViewChangeManager().register(selectedFS, bindingEditor);
		
		configurableUnitSubject.notifyObserver();
		selectedFS.notifyObserver();
	}

	public void notifyRelalizationViewReset(){
		selectedFS.resetSelectedFragmentSubstitution();
		selectedFS.notifyObserver();
		configurableUnitSubject.setConfigurableUnit(getCU());
		configurableUnitSubject.notifyObserver();
	}
	
	@Override
	public void refresh() {
		notifyRelalizationViewReset();
	}
}