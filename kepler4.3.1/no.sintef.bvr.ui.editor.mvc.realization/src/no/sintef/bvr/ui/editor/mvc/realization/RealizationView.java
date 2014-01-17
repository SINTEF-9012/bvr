package no.sintef.bvr.ui.editor.mvc.realization;

import java.awt.GridLayout;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import no.sintef.cvl.tool.common.Constants;
import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.subject.ConfigurableUnitSubject;
import no.sintef.cvl.tool.subject.SelectedFragmentSubstitutionSubject;
import no.sintef.cvl.tool.ui.editor.BindingJTable;
import no.sintef.cvl.tool.ui.editor.CVLUIKernel;
import no.sintef.cvl.tool.ui.editor.FragmentSubstitutionJTable;
import no.sintef.cvl.tool.ui.editor.SubstitutionFragmentJTable;
import no.sintef.cvl.tool.ui.loader.BVRNotifier;
import no.sintef.cvl.tool.ui.loader.CVLModel;
import no.sintef.cvl.tool.ui.loader.CVLView;
import no.sintef.cvl.ui.framework.elements.EditableModelPanel;
import cvl.ConfigurableUnit;
import cvl.NamedElement;
import cvl.VSpec;

public class RealizationView extends CVLView{
	private CVLModel m;
	
	public JTabbedPane modelPane;
	
	// VSpec
	public JScrollPane vspecScrollPane;
	public EditableModelPanel vspecEpanel;
	private Map<JComponent, NamedElement> vspecvmMap;
	private CVLUIKernel vSpeccvluikernel;
	
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

	private BVRNotifier ep;

	public CVLUIKernel getKernel() {
		return vSpeccvluikernel;
	}
	
	public RealizationView(CVLModel m, BVRNotifier ep) {
		super();
		this.ep = ep;
		
		// Alloc
		/*
		vspecvmMap = new HashMap<JComponent, NamedElement>();
		vspecNodes = new ArrayList<JComponent>();
		vspecBindings = new ArrayList<Pair<JComponent,JComponent>>();
		*/
		
		/*
        resolutionPanes = new ArrayList<JScrollPane>();
        resolutionEpanels = new ArrayList<EditableModelPanel>();
        resolutionkernels = new ArrayList<CVLUIKernel>();
    	resolutionvmMaps = new ArrayList<Map<JComponent,NamedElement>>();
    	resolutionNodes = new ArrayList<List<JComponent>>();
    	resolutionBindings = new ArrayList<List<Pair<JComponent,JComponent>>>();
    	*/
    	
    	//cvlViewSubject = new CVLViewSubject(this);
		
		this.m = m;
		
    	configurableUnitSubject = new ConfigurableUnitSubject(this.getCU());
	
    	vSpeccvluikernel = new CVLUIKernel(vspecvmMap, this, resolutionvmMaps);
		
		// VSpec pane
/*        try {
			loadCVLVSpecView(m.getCVLM().getCU(), vSpeccvluikernel);
		} catch (CVLModelException e) {
			e.printStackTrace();
		}
        
        autoLayoutVSpec();
*/		
		vspecScrollPane = new JScrollPane(vSpeccvluikernel.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//IAppWidgetFactory.makeIAppScrollPane(vspecScrollPane);
        vspecEpanel = new EditableModelPanel(vspecScrollPane);
        //x = vspecEpanel;
        //modelPane.add(x);
        
        //tp.addTab(m.getShortFileName(), null, modelPane, m.getLongFileName());
        
        
        // Resolution panes
        /*
        resPane = new JTabbedPane();
        //modelPane.addTab("Resolution", null, resPane, "");
        
        
        try {
			loadCVLResolutionView(m.getCVLM().getCU(), resolutionkernels, resPane);
		} catch (CVLModelException e) {
			e.printStackTrace();
		}
        
        autoLayoutResolutions();
        */
        
        // Realization panel
        realizationPanel = new JTabbedPane();
        //modelPane.addTab(Constants.REALIZATION_TAB_NAME, null, realizationPanel, "");
        
        try{
        	loadCVLRelalizationView(m.getCVLM().getCU());
        } catch (Exception e){
        	e.printStackTrace();
        }
	}

	public ConfigurableUnitSubject getConfigurableUnitSubject(){
		return configurableUnitSubject;
	}

	public ConfigurableUnit getCU() {
		return m.getCU();
	}

	int choiceCount = 1;

	private void loadCVLRelalizationView(ConfigurableUnit cu) throws Exception {
		selectedFS = new SelectedFragmentSubstitutionSubject(null);
		
		tableFragmSubst = new FragmentSubstitutionJTable();
		JScrollPane scrollPanelFragmSubst = new JScrollPane(tableFragmSubst);
		
		tableSubstFragm = new SubstitutionFragmentJTable();
		JScrollPane scrollPanelSubstFragm = new JScrollPane(tableSubstFragm);
		
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
	    
	    // Mark dirty
	    m.markNotSaved();
	    ep.notifyProbeDirty();
	}

	@Override
	public boolean isDirty() {
		return m.isNotSaved();
	}

	@Override
	public void notifyAllViews() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void notifyResolutionViewUpdate() {
		throw new UnsupportedOperationException();		
	}

	@Override
	public void notifyVspecViewUpdate() {
		throw new UnsupportedOperationException();		
	}

	@Override
	public void setMaximized(VSpec v) {
		throw new UnsupportedOperationException();		
	}

	@Override
	public void setMinimized(VSpec v) {
		throw new UnsupportedOperationException();		
	}
}
